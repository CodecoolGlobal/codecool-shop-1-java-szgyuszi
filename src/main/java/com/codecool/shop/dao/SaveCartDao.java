package com.codecool.shop.dao;

public interface SaveCartDao {

    void saveCart(String name, double price, int id, int quantity, int userId, int badge);
}
