package com.heleyquin.controller.admin.category;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.model.Category;
import com.heleyquin.model.Product;

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
        Category category = new Category(req);
        Map<String, String> validator = category.validate();
        if (validator.keySet().size() > 0) {
            req.setAttribute("old", category);
            req.setAttribute("errors", validator);
            doGet(req, res);
            return;
        }

        String name = req.getParameter("name");
        Category category1 = new Category();
        category.setName(name);
        categoryDAO.insertCategory(category1);
        res.sendRedirect("admin-listCategory");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/views/category/addCategory.jsp").forward(request, response);
    }
}
