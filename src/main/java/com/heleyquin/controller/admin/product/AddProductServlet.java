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
import java.util.Map;

@WebServlet(name = "AddProductServlet", urlPatterns = "/admin/product/add")
public class AddProductServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Product product = new Product(req);
        Map<String, String> validator = product.validate();
        if (validator.keySet().size() > 0) {
            req.setAttribute("old", product);
            req.setAttribute("errors", validator);
            doGet(req, res);
            return;
        }
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String thumbnail = req.getParameter("thumbnail");
        String description = req.getParameter("description");
        String categoryId = req.getParameter("categoryId");
        Product p = new Product(name, Double.parseDouble(price), thumbnail, description, Integer.parseInt(categoryId));
        product.setStatus(1);
        productDAO.insertProduct(p);
        res.sendRedirect("admin-listProduct");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/admin/views/product/addProduct.jsp").forward(request, response);
    }
}
