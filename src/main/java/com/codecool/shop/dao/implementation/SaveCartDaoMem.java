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
    public void saveCart(int id, int quantity, int userId, int badge) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO cart (movie_id, quantity, user_id, badge) VALUES (?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setInt(1, id);
            st.setInt(2, quantity);
            st.setInt(3, userId);
            st.setInt(4, badge);


            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}