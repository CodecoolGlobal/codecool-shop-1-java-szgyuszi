package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabaseManager {

    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;

    private static DatabaseManager instance = null;

    private DatabaseManager(){

    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        productDao = new ProductDaoMem(dataSource);
        productCategoryDao = new ProductCategoryDaoMem(dataSource);
        supplierDao = new SupplierDaoMem(dataSource);
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName = "dungeon";
        String user = "cula";
        String password = "dudidudi12";

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }

    public static DatabaseManager getInstance(){
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

}
