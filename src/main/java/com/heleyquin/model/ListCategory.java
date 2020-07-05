package com.heleyquin.model;

import java.util.ArrayList;
import java.util.List;

public class ListCategory {
    List<Category> categories = new ArrayList<Category>(
    ){
        {
            add(new Category(1, "Coffee"));
            add(new Category(2, "Main Dish"));
            add(new Category(3, "Drinks"));
            add(new Category(4, "Desserts"));

        }
    };
}
