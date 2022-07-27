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
    void testGetProductById() {
    }

    @Test
    void getAllProductByCategory() {
    }
}