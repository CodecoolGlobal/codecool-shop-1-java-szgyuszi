package com.codecool.shop.dao;

import com.codecool.shop.config.ReadConfig;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DatabaseManager {

    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SupplierDao supplierDao;

    private static DatabaseManager instance = null;

    private DatabaseManager(){

    }

    public void setup() throws SQLException, IOException {
        DataSource dataSource = connect();
        productDao = new ProductDaoMem(dataSource);
        productCategoryDao = new ProductCategoryDaoMem(dataSource);
        supplierDao = new SupplierDaoMem(dataSource);
    }

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

    public static DatabaseManager getInstance(){
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public ProductCategory getProductCategoryById(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }
    public Supplier getProductSupplierByName(String name){
        return supplierDao.getSupplier(name);
    }

    public Product getProductById(int id) {
        return productDao.find(id);
    }


}
