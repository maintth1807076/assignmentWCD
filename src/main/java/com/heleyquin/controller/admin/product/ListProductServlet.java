package com.heleyquin.controller.admin.product;

import com.heleyquin.dao.ProductDAO;
import com.heleyquin.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListProductServlet", urlPatterns = "/admin-listProduct")
public class ListProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = 1;
        int pageSize = 5;
        if(request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        List<Product> products = productDAO.getAllProduct(pageNumber, pageSize);
        int productCount = productDAO.getCountProduct();
        int pageCount= (int) Math.ceil(productCount / pageSize);
        request.setAttribute("products", products);
        request.setAttribute("noOfPages", pageCount);
        request.setAttribute("currentPage", pageNumber);
        request.getRequestDispatcher("admin/views/product/list.jsp").forward(request, response);
    }
}
