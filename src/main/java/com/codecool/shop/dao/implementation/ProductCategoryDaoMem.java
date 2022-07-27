package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductCategoryDao;
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

public class ProductCategoryDaoMem implements ProductCategoryDao {

    private final DataSource dataSource;

    /* A private Constructor prevents any other class from instantiating.
     */
    public ProductCategoryDaoMem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProductCategoryDaoMem getInstance() {
        return this;
    }

    @Override
    public void add(ProductCategory category) {

    }

    @Override
    public ProductCategory find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }


    @Override
    public ProductCategory getCategory(String categoryName) {
        return null;
    }

    @Override
    public List<Product> getAllProductByCategory(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT *, cast(m.price as decimal(10, 2)) FROM category JOIN movie m on category.id = m.category_id JOIN supplier s on s.id = m.supplier_id WHERE category.id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                products.add
                        (new Product(rs.getInt(3),
                        rs.getString(4),
                        BigDecimal.valueOf(rs.getDouble(6)),
                        "USD",
                        rs.getString(7),
                        new ProductCategory(rs.getString(2)),
                        new Supplier(rs.getString(12)),
                        rs.getString(5),
                        rs.getString(8)));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
