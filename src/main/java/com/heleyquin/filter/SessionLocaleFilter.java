package com.heleyquin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = "/*")
public class SessionLocaleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if(session.getAttribute("language") == null) {
            session.setAttribute("language", "en");
        }
        if(request.getParameter("lang") != null) {
            session.setAttribute("language", request.getParameter("lang"));
        }
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
