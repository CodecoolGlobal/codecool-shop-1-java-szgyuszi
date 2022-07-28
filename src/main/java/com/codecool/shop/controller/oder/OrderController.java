package com.codecool.shop.controller.oder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
            String firstname = req.getParameter("firstname");
            String email = req.getParameter("email");
            String cardNumber = req.getParameter("cardnumber");
            String expMonth = req.getParameter("expmonth");
            String expYear = req.getParameter("expyear");
            String cvv = req.getParameter("cvv");

        res.sendRedirect("/");



    }
}

