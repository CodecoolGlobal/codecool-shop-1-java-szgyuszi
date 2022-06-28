package com.codecool.shop.routes;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.service.ProductService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/movies_by_category"})
public class MoviesByGenreRoute extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        System.out.println(category);

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDao = SupplierDaoMem.getInstance();
        ProductService productService = new ProductService(productDataStore,productCategoryDataStore, supplierDao);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        ProductCategory category1 = productService.getProductCategoryByParameter(category);
        System.out.println(category1);
        context.setVariable("category", category1);
        context.setVariable("products", productService.getProductsForCategory(category1.getId()));

        engine.process("product/filtered_movies.html", context, resp.getWriter());
    }
}
