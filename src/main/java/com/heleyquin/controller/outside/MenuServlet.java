package com.heleyquin.controller.outside;

import com.heleyquin.dao.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MenuServlet", urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        request.setAttribute("categories", categoryDAO.getAllCategory());
        request.getRequestDispatcher("outside/views/menu.jsp").forward(request, response);
    }
}
