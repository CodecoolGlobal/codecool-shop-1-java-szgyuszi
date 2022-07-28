package com.codecool.shop.controller;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;

@WebServlet(urlPatterns = {"/save_cart"})
public class SaveCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductService productService = new ProductService(DatabaseManager.getInstance());

        String s = extractPostRequestBody(request);
        JsonObject jsonObject = new Gson().fromJson(s, JsonObject.class);
        int id = Integer.parseInt(jsonObject.get("id").getAsString());
        int quantity = Integer.parseInt(jsonObject.get("quantity").getAsString());
        int userId = Integer.parseInt(jsonObject.get("userId").getAsString());
        int badge = Integer.parseInt(jsonObject.get("badge").getAsString());
        productService.saveCart(id, quantity, userId, badge);

    }
     String extractPostRequestBody(HttpServletRequest request) throws IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }
        return "";
    }
}
