package com.heleyquin.controller.admin.product;

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

@WebServlet(name = "ListProductServlet", urlPatterns = "/admin/product/list")
public class ListProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = 1;
        int pageSize = 3;
        int status = 1;
        int categoryId = 0;
        int filterId = 1;
        if(request.getParameter("pageSize") != null){
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }
        if(request.getParameter("page") != null) {
            pageNumber = Integer.parseInt(request.getParameter("page"));
        }
        if(request.getParameter("categoryId") != null) {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
        }
        if(request.getParameter("filterId") != null) {
            filterId = Integer.parseInt(request.getParameter("filterId"));
        }
        if(request.getParameter("status") != null) {
            status = Integer.parseInt(request.getParameter("status"));
        }
        List<Product> products = productDAO.getAllProductWithCriteria(categoryId, 0, 10, status, filterId);
        int productCount = products.size();
        int pageCount= (int) Math.ceil((double)productCount / pageSize);
        request.setAttribute("products", products);
        request.setAttribute("noOfPages", pageCount);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("start", (pageNumber-1) * pageSize);
        request.setAttribute("end", (pageNumber-1) * pageSize + pageSize - 1);
        request.setAttribute("categoryId", categoryId);
        request.setAttribute("filterId", filterId);
        request.setAttribute("status", status);
        request.setAttribute("categories", categoryDAO.getAllCategory());
        request.getRequestDispatcher("/admin/views/product/list.jsp").forward(request, response);
    }
}
