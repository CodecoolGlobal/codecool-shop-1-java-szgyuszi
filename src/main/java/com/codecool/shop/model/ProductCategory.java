package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory extends BaseModel {

    private List<Product> products;

    public ProductCategory(String name) {
        super(name);
        this.products = new ArrayList<>();
    }


    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return String.format(
                "id: %d," +
                        "name: %s, " +
                        "description: %s",
                this.id,
                this.name,
                this.description);
    }
}