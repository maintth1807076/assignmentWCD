package com.heleyquin.filter;

import com.heleyquin.model.Role;
import com.heleyquin.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
//        Role role = (Role) session.getAttribute("role");
//        String loginURI = request.getContextPath() + "/login";
//        boolean loggedIn = session != null && session.getAttribute("user") != null;
//        boolean loginRequest = request.getRequestURI().equals(loginURI);
        if (user != null && user.isUser()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendRedirect("/login");
        }
//        if (loggedIn || loginRequest) {
//            filterChain.doFilter(request, response);
//        } else {
//            response.sendRedirect(loginURI);
//        }
    }

    public void destroy() {

    }
}
