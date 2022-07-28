package com.codecool.shop.service;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceTest
{

    DatabaseManager databaseManager = Mockito.mock(DatabaseManager.class);
    ProductService service = new ProductService(databaseManager);
    Product testProduct = new Product(4, "Splendid", new BigDecimal("9.99"),
            "USD", "asd", new ProductCategory("action"), new Supplier("Gmt"), "", "");


    @Test
    void getAllProduct() {
        when(databaseManager.getAllProducts()).thenReturn(List.of(testProduct));
        List<Product> result = service.getAllProduct();
        List<Product> actual = new ArrayList<>();
        actual.add(new Product(4, "Splendid", new BigDecimal("9.99"),
                "USD", "asd", new ProductCategory("action"), new Supplier("Gmt"), "", ""));
        assertEquals(result.size(), actual.size());

    }

    @Test
    void getProductSupplierByName() {
        when(databaseManager.getProductSupplierByName("GMT")).thenReturn(new Supplier("GMT"));
        Supplier result = service.getProductSupplierByName("GMT");
        assertEquals(result, new Supplier("GMT"));

    }

    @Test
    void getProductById() {
        when(databaseManager.getProductById(4)).thenReturn(testProduct);
        Product result = service.getProductById(4);
        assertEquals(result.getId(), testProduct.getId());
    }

    @Test
    void getAllProductByCategory() {
        Product testObject1 = new Product(1, "name", new BigDecimal(10.10), "HUF", "asd", new ProductCategory("action"),
                new Supplier("Metro"), "", "");
        Product testObject2 = new Product(2, "moviename", new BigDecimal(9.99), "COR", "asd", new ProductCategory("comedy"),
                new Supplier("Paramount"), "", "");
        when(databaseManager.getAllProductByCategory(2)).thenReturn(List.of(testProduct, testObject1));
        List<Product> result = service.getAllProductByCategory(2);
        List<Product> actual = new ArrayList<>();
        actual.add(testObject1);
        actual.add(testProduct);
        assertEquals(result, actual);
    }
}