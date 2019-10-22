package com.geekstomach.servlet;

import com.geekstomach.entity.ProductsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "catalog", urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(CatalogServlet.class);

    private ProductsList productsList;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productsList = new ProductsList(9);
        req.setAttribute("productsList",productsList.getProductsList());
                req.getRequestDispatcher("catalogPage.jsp").forward(req, resp);

    }
}
