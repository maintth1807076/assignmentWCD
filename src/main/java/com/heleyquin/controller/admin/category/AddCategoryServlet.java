package com.heleyquin.controller.admin.category;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCategoryServlet", urlPatterns = "/admin-addCategory")
public class AddCategoryServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Category category = new Category();
        category.setName(name);
        categoryDAO.insertCategory(category);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("admin/views/category/addCategory.jsp").forward(request, response);
    }
}
