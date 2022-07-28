package com.codecool.shop.model;

public class Cart {

    private String movieName;

    private int movieId;

    private String moviePrice;

    private int quantity;

    private int user_id;

    private int badge;

    public Cart(Product product, int quantity, int user_id, int badge) {
        this.movieId = product.getId();
        movieName = product.getName();
        moviePrice = product.getPrice();
        this.quantity = quantity;
        this.user_id = user_id;
        this.badge = badge;
    }
}
