package com.codecool.shop.controller;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.entities.Movie;
import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@WebServlet(urlPatterns = {"/load_cart"})
public class LoadCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = 1;
        ProductService productService = new ProductService(DatabaseManager.getInstance());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String result = new Gson().toJson(productService.loadCart(userId));
        System.out.println(result);
        out.print(result);
        out.flush();
        out.close();

    }

}
