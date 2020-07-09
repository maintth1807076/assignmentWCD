package com.heleyquin.controller.admin.category;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.model.Category;
import com.heleyquin.model.Product;
import com.heleyquin.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddCategoryServlet", urlPatterns = "/admin/category/create")
public class AddCategoryServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        Category category = new Category(name);
        if (category.getErrors().size() > 0) {
            req.setAttribute("errors", category.getErrors());
            req.getRequestDispatcher("/addCategory.jsp").forward(req, res);
        } else {
            categoryDAO.insertCategory(category);
            res.sendRedirect("admin-listCategory");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/views/category/addCategory.jsp").forward(request, response);
    }
}
