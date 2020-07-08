package com.heleyquin.controller.outside;

import com.heleyquin.dao.ProductDAO;
import com.heleyquin.model.CartItem;
import com.heleyquin.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "AddCartServlet", urlPatterns = "/add-cart")
public class AddCartServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        if(Integer.parseInt(quantity) <= 0) {
            return;
        }
        Product product = productDAO.getProduct(Integer.parseInt(id));
        if(product != null) {
            HttpSession session = request.getSession();
            HashMap<Integer, CartItem> cart = (HashMap<Integer, CartItem>) session.getAttribute("cart");
            if(cart == null) {
                cart = new HashMap<Integer, CartItem>();
                session.setAttribute("cart", cart);
            }
            CartItem cartItem;
            if(cart.containsKey(product.getId())) {
                cartItem = cart.get(product.getId());
                int newQuantity = cartItem.getQuantity() + Integer.parseInt(quantity);
                cartItem.setQuantity(newQuantity);
            } else {
                cartItem = new CartItem();
                cartItem.setId(product.getId());
                cartItem.setName(product.getName());
                cartItem.setThumbnail(product.getThumbnail());
                cartItem.setUnitPrice(product.getPrice());
                cartItem.setQuantity(Integer.parseInt(quantity));
            }
            cart.put(product.getId(), cartItem);
            request.getRequestDispatcher("cart");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        if(Integer.parseInt(quantity) <= 0) {
            return;
        }
        Product product = productDAO.getProduct(Integer.parseInt(id));
        if(product != null) {
            HttpSession session = request.getSession();
            HashMap<Integer, CartItem> cart = (HashMap<Integer, CartItem>) session.getAttribute("cart");
            if(cart == null) {
                cart = new HashMap<Integer, CartItem>();
                session.setAttribute("cart", cart);
            }
            CartItem cartItem;
            if(cart.containsKey(product.getId())) {
                cartItem = cart.get(product.getId());
                int newQuantity = cartItem.getQuantity() + Integer.parseInt(quantity);
                cartItem.setQuantity(newQuantity);
            } else {
                cartItem = new CartItem();
                cartItem.setId(product.getId());
                cartItem.setName(product.getName());
                cartItem.setThumbnail(product.getThumbnail());
                cartItem.setUnitPrice(product.getPrice());
                cartItem.setQuantity(Integer.parseInt(quantity));
            }
            cart.put(product.getId(), cartItem);
            response.sendRedirect("cart");
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
