package com.heleyquin.controller.admin;

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
            if(checkRole(user, "admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("admin/views/dashboard.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("admin/views/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("admin/views/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null) {
            request.getRequestDispatcher("admin/views/dashboard.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("admin/views/login.jsp").forward(request, response);
        }
    }
    public boolean checkRole(User user, String roleName) {
        List<Role> roles = user.getRoles();
        for (int i = 0; i < roles.size(); i++) {
            Role role = roles.get(i);
            if(role.getName() == roleName){
                return true;
            }
        }
        return false;
    }
}
