package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoMem implements ProductCategoryDao {

    private final DataSource dataSource;

    /* A private Constructor prevents any other class from instantiating.
     */
    public ProductCategoryDaoMem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProductCategoryDaoMem getInstance() {
        return this;
    }

    @Override
    public void add(ProductCategory category) {

    }

    @Override
    public ProductCategory find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }


    @Override
    public ProductCategory getCategory(String categoryName) {
        return null;
    }
}
