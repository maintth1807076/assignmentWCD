package com.heleyquin.controller.outside;

import com.heleyquin.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductSingleServlet", urlPatterns = "/product-single")
public class ProductSingleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") == null || request.getParameter("id").length() == 0) {
            request.getRequestDispatcher("errors.jsp").forward(request, response);
        }
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        request.setAttribute("product", productDAO.getProduct(id));
        request.getRequestDispatcher("outside/views/product-single.jsp").forward(request, response);
    }
}
