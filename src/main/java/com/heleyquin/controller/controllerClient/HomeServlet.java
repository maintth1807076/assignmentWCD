package com.heleyquin.controller.controllerClient;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    private CategoryDAO dao = new CategoryDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("outside/views/index.jsp").forward(request, response);
//        Category model = new Category();
//        model.setName("Coffee");
//        dao.insert(model);
    }
}
