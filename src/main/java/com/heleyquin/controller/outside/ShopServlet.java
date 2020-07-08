package com.heleyquin.controller.outside;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.dao.ProductDAO;
import com.heleyquin.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    private ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = 1;
        int pageSize = 3;
        int minPrice = 0;
        int maxPrice = 100;
        int categoryId = 0;
        if(request.getParameter("pageSize") != null){
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }
        if(request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        if(request.getParameter("categoryId") != null) {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
        }
        if(request.getParameter("minPrice") != null) {
            minPrice = Integer.parseInt(request.getParameter("minPrice"));
        }
        if(request.getParameter("maxPrice") != null) {
            minPrice = Integer.parseInt(request.getParameter("maxPrice"));
        }
        List<Product> products = productDAO.getAllProductWithCriteria(categoryId, minPrice, maxPrice, 1);
        int productCount = products.size();
        int pageCount= (int) Math.ceil((double)productCount / pageSize);
        request.setAttribute("products", products);
        request.setAttribute("noOfPages", pageCount);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("start", (pageNumber-1) * pageSize);
        request.setAttribute("end", (pageNumber-1) * pageSize + pageSize - 1);
        request.setAttribute("categoryId", categoryId);
        request.getRequestDispatcher("/outside/views/shop.jsp").forward(request, response);
    }
}
