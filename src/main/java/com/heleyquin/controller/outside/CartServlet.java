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

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Integer, CartItem> cart = (HashMap<Integer, CartItem>) session.getAttribute("cart");
        request.setAttribute("cart", cart);
        Double totalPrice = 0.0;
        for (CartItem cartItem: cart.values()) {
            totalPrice += cartItem.getQuantity() * cartItem.getUnitPrice();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("outside/views/cart.jsp").forward(request, response);
    }
}
