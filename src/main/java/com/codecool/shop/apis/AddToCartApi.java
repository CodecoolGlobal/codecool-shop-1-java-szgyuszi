package com.codecool.shop.apis;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.entities.Movie;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Movie", urlPatterns = {"/api/movie"}, loadOnStartup = 0)
public class AddToCartApi extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movieId = request.getParameter("id");
        int movieNumber = 1;
        try {
            movieNumber = Integer.parseInt(movieId);
        } catch (NumberFormatException ignored) {
        }
        ProductService productService = new ProductService(DatabaseManager.getInstance());
        Product productById = productService.getProductById(movieNumber);
        String[] price = productById.getPrice().split(" ");
        String result = new Gson().toJson(new Movie(productById.getName(), price[0], productById.getId()));
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
        out.close();
    }

}
