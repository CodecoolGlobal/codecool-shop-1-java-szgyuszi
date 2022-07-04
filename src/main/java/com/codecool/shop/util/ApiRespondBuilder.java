package com.codecool.shop.util;

import com.codecool.shop.entities.Movie;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ApiRespondBuilder {
    public static String getAllProductGson(List<Product> products) {
        List<Movie> movies = new ArrayList<>();
        for (Product  product : products) {
            movies.add(new Movie(product.getName(), product.getPrice(), product.getId()));
        }
        return new Gson().toJson(movies);
    }
}
