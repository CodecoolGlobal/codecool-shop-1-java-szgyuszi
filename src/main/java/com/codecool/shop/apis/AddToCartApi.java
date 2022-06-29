package com.codecool.shop.apis;

import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.entities.Movie;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Movie", urlPatterns = {"/api/movie"}, loadOnStartup = 0)
public class AddToCartApi extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId = request.getParameter("id");
        int movieNumber = 1;
        try {
            movieNumber = Integer.parseInt(movieId);
        } catch (NumberFormatException e) {
        }
        Product product = ProductDaoMem.getInstance().find(movieNumber);

        String result = new Gson().toJson(new Movie(product.getName(), product.getPrice(), product.getId()));
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
        out.close();
    }

}
