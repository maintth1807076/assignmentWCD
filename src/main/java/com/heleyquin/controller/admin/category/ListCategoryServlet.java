package com.heleyquin.controller.admin.category;

import com.heleyquin.dao.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListCategoryServlet", urlPatterns = "/admin-listCategory")
public class ListCategoryServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categoryDAO.getAllCategory());
        request.getRequestDispatcher("admin/views/category/list.jsp").forward(request, response);
    }
}
