package com.codecool.shop.controller.session;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet("/test_session")
public class TestSessionController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        PrintWriter writer = response.getWriter();
        writer.println("Session ID: " + session.getId());
        writer.println("Creation Time: " + new Date(session.getCreationTime()));
        writer. println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));
    }
}
