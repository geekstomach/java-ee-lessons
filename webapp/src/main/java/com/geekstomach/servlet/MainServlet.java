package com.geekstomach.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "main", urlPatterns = "")
public class MainServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(MainServlet.class);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
}
}
