package com.codecool.shop.controller;


import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/save_sign_up"})
public class SaveUserPersonalDataController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductService productService = new ProductService(DatabaseManager.getInstance());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("register.html").include(request, response);

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        productService.registerUser(name, email, password);

        out.close();



    }
}
