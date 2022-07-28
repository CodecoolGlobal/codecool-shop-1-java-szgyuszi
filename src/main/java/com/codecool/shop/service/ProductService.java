package com.codecool.shop.service;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.model.Cart;
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

    public List<Product> getAllProductByCategory(int id) {
        return databaseManager.getAllProductByCategory(id);
    }

    public void registerUser(String name, String email, String password){
        databaseManager.registerUser(name, email, password);
    }

    public void saveCart(int movie_id, int quantity, int userId, int badge) {
        databaseManager.saveCart(movie_id,  quantity,  userId, badge);
    }

    public Cart loadCart(int userId) {
        return databaseManager.loadCart(userId);
    }

}
