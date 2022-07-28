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
    public void saveCart(String name, double price, int id, int quantity, int userId, int badge) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO cart (name, price, id, quantity, user_id, badge) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, name);
            st.setDouble(2, price);
            st.setInt(3, id);
            st.setInt(4, quantity);
            st.setInt(5, userId);
            st.setInt(6, badge);


            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}