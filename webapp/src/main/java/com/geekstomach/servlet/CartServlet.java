package com.geekstomach.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(CartServlet.class);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cartPage.jsp").forward(req, resp);
    }
}
