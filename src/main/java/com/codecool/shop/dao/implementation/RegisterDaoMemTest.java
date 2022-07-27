package com.codecool.shop.dao.implementation;

import com.codecool.shop.config.ReadConfig;
import com.codecool.shop.dao.DatabaseManager;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RegisterDaoMemTest {

    private DataSource connect() throws SQLException, IOException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        ReadConfig readConfig = new ReadConfig();
        readConfig.connect();
        String dbName = ReadConfig.getDbName();
        String user = ReadConfig.user();
        String password = ReadConfig.password();

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }


    @Test
    public void testRegistration() throws SQLException, IOException {
        DataSource dataSource = connect();
        RegisterDaoMem registerDaoMem = new RegisterDaoMem(dataSource);
        assertDoesNotThrow(() -> {registerDaoMem.registerUser("Kristof", "t@g.hu", "tata");});
    }

}