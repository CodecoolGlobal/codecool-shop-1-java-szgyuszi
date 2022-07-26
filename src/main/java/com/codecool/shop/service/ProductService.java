package com.codecool.shop.service;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.entities.Movie;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.List;

public class ProductService{

    private final DatabaseManager databaseManager;



    public ProductService(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public ProductCategory getProductCategory(int categoryId){
        return databaseManager.getProductCategoryById(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId){
        return databaseManager.getProductsForCategoryById(categoryId);
    }

    public List<Product> getAllProduct() {
        return databaseManager.getAllProducts();
    }

    public Supplier getProductSupplierByName(String name){
        return databaseManager.getProductSupplierByName(name);
    }

    public Product getProductById(int id) {
        return databaseManager.getProductById(id);
    }

    public Product getProductById(Product movie) {
        return getProductById(movie.getId());
    }

}
