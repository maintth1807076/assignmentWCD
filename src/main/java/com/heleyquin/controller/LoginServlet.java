package com.heleyquin.controller;

import com.heleyquin.dao.UserDAO;
import com.heleyquin.model.Role;
import com.heleyquin.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(userDAO.checkExistUser(username, password)) {
            User user = userDAO.getUser(username, password);
            if(user.isAdmin()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("admin");
                return;
            }
            if(user.isUser()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("home");
                return;
            }
        } else {
            doGet(request, response);
            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        if(user != null) {
//            if(user.isAdmin()) {
//                response.sendRedirect("admin");
//                return;
//            }
//            if(user.isUser()) {
//                response.sendRedirect("home");
//                return;
//            }
//        } else {
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
