package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoMem implements ProductDao {


    private final DataSource dataSource;

    /* A private Constructor prevents any other class from instantiating.
     */
    public ProductDaoMem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProductDaoMem getInstance() {
        return this;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT movie.id,\n" +
                    "       movie.name,\n" +
                    "       url,\n" +
                    "       price,\n" +
                    "       description,\n" +
                    "       img,\n" +
                    "       c.genre,\n" +
                    "       s.name\n" +
                    "FROM movie\n" +
                    "         JOIN category c on c.id = movie.category_id\n" +
                    "         JOIN supplier s on s.id = movie.supplier_id\n" +
                    "WHERE movie.id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            int movieId = rs.getInt(0);
            String name = rs.getString(1);
            String trailer = rs.getString(2);
            double defaultPrice = rs.getDouble(3);
            String description = rs.getString(4);
            String img = rs.getString(5);
            ProductCategory category = new ProductCategory(rs.getString(6));
            Supplier supplier = new Supplier(rs.getString(7));
            String currency = "USD";
            return new Product(movieId, name, new BigDecimal(defaultPrice), currency, description, category, supplier, trailer, img);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
