package com.codecool.shop.dao;

public interface SaveCartDao {

    void saveCart(int movie_id, int quantity, int userId, int badge);
}
