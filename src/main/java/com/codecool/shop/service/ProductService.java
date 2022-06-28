package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.List;

public class ProductService{

    private SupplierDao supplierDao;
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;

    public ProductService(ProductDao productDao, ProductCategoryDao productCategoryDao, SupplierDao supplierDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.supplierDao = supplierDao;
    }



    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId){
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }

    public List<Product> getAllProduct() {
        return productDao.getAll();
    }

    public ProductCategory getProductCategoryByParameter(String name){
        return productCategoryDao.getCategory(name);
    }

    public Supplier getProductSupplierByParameter(String name){
        return supplierDao.getSupplier(name);
    }

}
