package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoMem implements SupplierDao {




    private final DataSource dataSource;

    /* A private Constructor prevents any other class from instantiating.
     */
    public SupplierDaoMem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SupplierDaoMem getInstance() {
       return this;
    }

    @Override
    public void add(Supplier supplier) {

    }

    @Override
    public Supplier find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public Supplier getSupplier(String name) {
        Supplier supplier = null;
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM movie JOIN supplier s on s.id = movie.supplier_id JOIN category c on c.id = movie.category_id WHERE s.name like ?";
            PreparedStatement st = conn.prepareStatement(sql);
            ArrayList<Product> products = new ArrayList<>();
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int movieId = rs.getInt(1);
                String movieName = rs.getString(2);
                String trailer = rs.getString(3);
                double defaultPrice = rs.getDouble(4);
                String description = rs.getString(5);
                String img = rs.getString(6);
                ProductCategory category = new ProductCategory(rs.getString(7));
                String currency = "USD";
                supplier = new Supplier(rs.getString(10));
                products.add(new Product(movieId, movieName, new BigDecimal(defaultPrice), currency, description, category, supplier, trailer, img));
            }
            supplier.setProducts(products);
            return supplier;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Supplier> getAll() {
        return null;
    }
}
