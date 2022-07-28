package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SaveCartDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveCartDaoMem implements SaveCartDao {
    private final DataSource dataSource;

    public SaveCartDaoMem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void saveCart(String name, double price, int id, int quantity, int userId) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO cart (name, price, id, quantity, userId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, name);
            st.setDouble(2, price);
            st.setInt(3, id);
            st.setInt(4, quantity);
            st.setInt(5, userId);

            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}