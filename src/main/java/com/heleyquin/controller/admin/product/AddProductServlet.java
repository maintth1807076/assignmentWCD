package com.heleyquin.controller.admin.product;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.dao.ProductDAO;
import com.heleyquin.model.Category;
import com.heleyquin.model.Product;
import com.heleyquin.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AddProductServlet", urlPatterns = "/admin/product/create")
public class AddProductServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String thumbnail = req.getParameter("thumbnail");
        String description = req.getParameter("description");
        String categoryId = req.getParameter("categoryId");
        Product product = new Product(name, price, thumbnail, description, categoryId);

        if (product.getErrors().size() > 0) {
            req.setAttribute("errors", product.getErrors());
            req.getRequestDispatcher("/admin/views/product/addProduct.jsp").forward(req, res);
        } else {
            Product p = new Product(name, Double.parseDouble(price), thumbnail, description, Integer.parseInt(categoryId));
            product.setStatus(1);
            productDAO.insertProduct(p);
            res.sendRedirect("/admin/product/list");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/admin/views/product/addProduct.jsp").forward(request, response);
    }
}
