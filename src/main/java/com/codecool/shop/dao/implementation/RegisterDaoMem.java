package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.RegisterDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDaoMem implements RegisterDao {

    private final DataSource dataSource;

    public RegisterDaoMem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public RegisterDaoMem getInstance(){
        return this;
    }

    @Override
    public void registerUser(String name, String email, String password) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO \"user\" (\"name\", email, password) VALUES (?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleterUser(int id) {

    }

    @Override
    public void updateUser(int id, String newName, String newEmail, String newPassword) {

    }
}
