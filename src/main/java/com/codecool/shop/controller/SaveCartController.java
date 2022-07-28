package com.codecool.shop.controller;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/save_cart"})
public class SaveCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        ProductService productService = new ProductService(DatabaseManager.getInstance());

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("user_id");
        productService.saveCart(name, price, id, quantity, user_id);
        response.setStatus(201);
    }
}
