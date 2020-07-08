package com.heleyquin.controller.outside;

import com.heleyquin.model.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "UpdateCartServlet", urlPatterns = "/update-cart")
public class UpdateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if(quantity <= 0) {
            return;
        }
        HttpSession session = request.getSession();
        session.getAttribute("cart");
        HashMap<Integer, CartItem> cart = (HashMap<Integer, CartItem>) session.getAttribute("cart");
        if(cart.containsKey(id)) {
            CartItem cartItem = cart.get(id);
            cartItem.setQuantity(quantity);
            cart.put(id, cartItem);
            response.sendRedirect("cart");
        } else {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
