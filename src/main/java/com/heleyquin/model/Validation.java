package com.heleyquin.model;

import com.heleyquin.dao.ProductDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

public class Validation {
    public HashMap<String, ArrayList<String>> validateProduct(HttpServletRequest req) {
        ProductDAO productDAO = new ProductDAO();
        HashMap<String, ArrayList<String>> errors = new HashMap<>();
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String thumbnail = req.getParameter("thumbnail");
        String description = req.getParameter("description");
        String categoryId = req.getParameter("categoryId");
        if (name == null || name.isEmpty()) {
            ArrayList<String> nameErrors = new ArrayList<>();
            if (errors.containsKey("name")) {
                nameErrors = errors.get("name");
            }
            nameErrors.add("Product name is required!");
            errors.put("name", nameErrors);
        } else {
            ArrayList<String> nameErrors = new ArrayList<>();
            if(productDAO.checkProductByName(name)) {
                nameErrors.add("Product exists");
                errors.put("name", nameErrors);
            }
        }
        if (price == null || price.isEmpty()) {
            ArrayList<String> priceErrors = new ArrayList<>();
            if (errors.containsKey("price")) {
                priceErrors = errors.get("price");
            }
            priceErrors.add("Price is required!");
            errors.put("price", priceErrors);
        } else {
            try {
                Double.parseDouble(price);
                if(Double.parseDouble(price) <= 0) {
                    ArrayList<String> priceErrors = new ArrayList<>();
                    if (errors.containsKey("price")) {
                        priceErrors = errors.get("price");
                    }
                    priceErrors.add("Price need be greater than 0");
                    errors.put("price", priceErrors);
                }
            } catch (NumberFormatException ex) {
                ArrayList<String> priceErrors = new ArrayList<>();
                if (errors.containsKey("price")) {
                    priceErrors = errors.get("price");
                }
                priceErrors.add("Price must be a number!");
                errors.put("price", priceErrors);
            }
        }
        if (thumbnail == null || thumbnail.isEmpty()) {
            ArrayList<String> thumbnailErrors = new ArrayList<>();
            if (errors.containsKey("thumbnail")) {
                thumbnailErrors = errors.get("thumbnail");
            }
            thumbnailErrors.add("Thumbnail is required!");
            errors.put("thumbnail", thumbnailErrors);
        }
        if (description == null || description.isEmpty()) {
            ArrayList<String> descriptionErrors = new ArrayList<>();
            if (errors.containsKey("description")) {
                descriptionErrors = errors.get("description");
            }
            descriptionErrors.add("Description is required!");
            errors.put("description", descriptionErrors);
        }
        return errors;
    }
}
