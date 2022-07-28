package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.LoadCartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadCartDaoMem implements LoadCartDao {

    private DataSource dataSource;

    public LoadCartDaoMem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Cart loadCart(int userId) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT movie.id, movie.name, url, cast(price as decimal(10, 2)), description, img, c.genre, s.name, c2.quantity, c2.badge FROM movie JOIN category c on c.id = movie.category_id JOIN supplier s on s.id = movie.supplier_id JOIN cart c2 on movie.id = c2.movie_id WHERE c2.user_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            int movieId = rs.getInt(1);
            String movieName = rs.getString(2);
            String url = rs.getString(3);
            double price = rs.getDouble(4);
            String description = rs.getString(5);
            String img = rs.getString(6);
            ProductCategory category = new ProductCategory(rs.getString(7));
            Supplier supplier = new Supplier(rs.getString(8));
            int quantity = rs.getInt(9);
            int badge = rs.getInt(10);
            String currency = "USD";
            Product product = new Product(movieId, movieName, new BigDecimal(price), currency, description, category,
                    supplier, url, img);
            Cart cart = new Cart(product, quantity, userId, badge);
            return cart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
