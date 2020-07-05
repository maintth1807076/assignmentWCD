package com.heleyquin.controller.admin.product;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.dao.ProductDAO;
import com.heleyquin.model.Category;
import com.heleyquin.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddProductServlet", urlPatterns = "/admin-addProduct")
public class AddProductServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String thumbnail = request.getParameter("thumbnail");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");
        Product product = new Product(name, Double.parseDouble(price), thumbnail, description, Integer.parseInt(categoryId));
        productDAO.insertProduct(product);
        response.sendRedirect("admin-listProduct");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("admin/views/product/addProduct.jsp").forward(request, response);
    }
}
