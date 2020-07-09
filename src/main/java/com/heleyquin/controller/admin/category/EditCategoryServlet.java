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

@WebServlet(name = "EditCategoryServlet", urlPatterns = "/admin/category/edit")
public class EditCategoryServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Category category = new Category();
        category.setId(Integer.parseInt(id));
        category.setName(name);
        categoryDAO.updateCategory(category);
        response.sendRedirect("admin/category/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null || id.length() == 0){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        Category category = categoryDAO.getCategory(Integer.parseInt(id));
        request.setAttribute("category", category);
        request.getRequestDispatcher("/admin/views/category/edit.jsp").forward(request, response);
    }
}
