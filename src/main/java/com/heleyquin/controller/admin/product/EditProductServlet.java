package com.heleyquin.controller.admin.product;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.dao.ProductDAO;
import com.heleyquin.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProductServlet", urlPatterns = "/admin/product/edit")
public class EditProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String thumbnail = request.getParameter("thumbnail");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");
        Product product = new Product(name, Double.parseDouble(price), thumbnail, description, Integer.parseInt(categoryId));
        product.setId(Integer.parseInt(id));
        productDAO.updateProduct(product);
        response.sendRedirect("admin-listProduct");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categoryDAO.getAllCategory());
        String id = request.getParameter("id");
        if(id == null || id.length() == 0){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        Product product = productDAO.getProduct(Integer.parseInt(id));
        request.setAttribute("product", product);
        request.getRequestDispatcher("/admin/views/product/edit.jsp").forward(request, response);
    }
}
