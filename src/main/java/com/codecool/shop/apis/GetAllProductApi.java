package com.codecool.shop.apis;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.util.ApiRespondBuilder;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ApiProducts", urlPatterns = {"/api/get-movies-all"}, loadOnStartup = 0)
public class GetAllProductApi extends javax.servlet.http.HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductService productService = new ProductService(DatabaseManager.getInstance());
        List<Product> allProduct = productService.getAllProduct();
        String result = ApiRespondBuilder.getAllProductGson(allProduct);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
        out.close();
    }
}
