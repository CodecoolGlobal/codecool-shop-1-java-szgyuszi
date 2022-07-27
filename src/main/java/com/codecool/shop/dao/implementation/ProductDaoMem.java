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
            String sql = "SELECT movie.id, movie.name, url, cast(price as decimal(10, 2)), description, img, c.genre, s.name FROM movie JOIN category c on c.id = movie.category_id JOIN supplier s on s.id = movie.supplier_id WHERE movie.id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            int movieId = rs.getInt(1);
            String name = rs.getString(2);
            String trailer = rs.getString(3);
            BigDecimal defaultPrice = BigDecimal.valueOf(rs.getDouble(4));
            String description = rs.getString(5);
            String img = rs.getString(6);
            ProductCategory category = new ProductCategory(rs.getString(7));
            Supplier supplier = new Supplier(rs.getString(8));
            String currency = "USD";
            return new Product(movieId, name, defaultPrice, currency, description, category, supplier, trailer, img);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public List<Product> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT movie.id, movie.name, url, price, description, img, c.genre, s.name FROM movie JOIN category c on c.id = movie.category_id JOIN supplier s on s.id = movie.supplier_id";
            PreparedStatement st = conn.prepareStatement(sql);
            List<Product> products = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int movieId = rs.getInt(1);
                String name = rs.getString(2);
                String trailer = rs.getString(3);
                double defaultPrice = rs.getDouble(4);
                String description = rs.getString(5);
                String img = rs.getString(6);
                ProductCategory category = new ProductCategory(rs.getString(7));
                Supplier supplier = new Supplier(rs.getString(8));
                String currency = "USD";
                products.add(new Product(movieId, name, new BigDecimal(defaultPrice), currency, description, category, supplier, trailer, img));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        int supplierId = supplier.getId();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT movie.id, movie.name, url, price, description, img, c.genre, s.name FROM movie JOIN category c on c.id = movie.category_id JOIN supplier s on s.id = movie.supplier_id WHERE movie.supplier_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            List<Product> products = new ArrayList<>();
            st.setInt(1, supplierId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int movieId = rs.getInt(1);
                String name = rs.getString(2);
                String trailer = rs.getString(3);
                double defaultPrice = rs.getDouble(4);
                String description = rs.getString(5);
                String img = rs.getString(6);
                ProductCategory category = new ProductCategory(rs.getString(7));
                String currency = "USD";
                products.add(new Product(movieId, name, new BigDecimal(defaultPrice), currency, description, category, supplier, trailer, img));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
