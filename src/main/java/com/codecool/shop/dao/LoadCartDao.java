package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

public interface LoadCartDao {

    Cart loadCart(int userId);

}
