package com.heleyquin.model;

import com.heleyquin.dao.CategoryDAO;
import com.heleyquin.dao.ProductDAO;
import com.heleyquin.dao.RoleDAO;
import com.heleyquin.dao.UserDAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data {
    List<Role> roles = new ArrayList<Role>(
    ){
        {
            add(new Role( "admin"));
            add(new Role("user"));
        }
    };
    List<User> users = new ArrayList<User>(
    ){
        {
            add(new User( "admintest", "12345", User.StatusType.ACTIVE, new ArrayList<Role>(
            ){
                {
                    add(new Role( 1,"admin"));
                    add(new Role(2,"user"));
                }
            }));
            add(new User( "usertest", "12345", User.StatusType.ACTIVE, new ArrayList<Role>(
            ){
                {
                    add(new Role(2,"user"));
                }
            }));
        }
    };
    List<Category> categories = new ArrayList<Category>(
    ){
        {
            add(new Category("Coffee"));
            add(new Category("Main Dish"));
            add(new Category("Drinks"));
            add(new Category("Desserts"));

        }
    };
    List<Product> products = new ArrayList<Product>(
    ){
        {
            add(new Product("Coffee Capuccino", 5.90, "/outside/assets/images/menu-1.jpg", "A small river named Duden flows by their place and supplies.", 1, 1));
            add(new Product("Black Coffee", 5.80, "/outside/assets/images/menu-2.jpg", "A small river named Duden flows by their place and supplies.", 1,1));
            add(new Product("Coffee Milk", 4.90, "/outside/assets/images/menu-3.jpg", "A small river named Duden flows by their place and supplies.", 1,1));
            add(new Product("Coffee Italy", 7.90, "/outside/assets/images/menu-4.jpg", "A small river named Duden flows by their place and supplies.", 1,1));
            add(new Product("Grilled Beef", 2.90, "/outside/assets/images/dish-1.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 2,1));
            add(new Product("Grilled Carrot Beef", 2.90, "/outside/assets/images/dish-2.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 2,1));
            add(new Product("Grilled Onion Beef", 2.90, "/outside/assets/images/dish-3.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 2,1));
            add(new Product("Grilled Sheep", 2.90, "/outside/assets/images/dish-4.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 2,1));
            add(new Product("Grilled Craff", 2.90, "/outside/assets/images/dish-5.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 2,1));
            add(new Product("Grilled Fish", 2.90, "/outside/assets/images/dish-6.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 2,1));
            add(new Product("Lemonade Juice", 2.90, "/outside/assets/images/drink-1.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 3,1));
            add(new Product("Orange Juice", 2.90, "/outside/assets/images/drink-2.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 3,1));
            add(new Product("Water melon Juice", 2.90, "/outside/assets/images/drink-3.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 3,1));
            add(new Product("Apple Juice", 2.90, "/outside/assets/images/drink-4.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 3,1));
            add(new Product("PineApple Juice", 2.90, "/outside/assets/images/drink-5.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 3,1));
            add(new Product("Tea Juice", 2.90, "/outside/assets/images/drink-6.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 3,1));
            add(new Product("Hot Cake Honey", 2.90, "/outside/assets/images/dessert-1.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 4,1));
            add(new Product("Strawberry Cake", 2.90, "/outside/assets/images/dessert-2.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 4,1));
            add(new Product("Whipping Blueberry Honey", 2.90, "/outside/assets/images/dessert-3.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 4,1));
            add(new Product("Cream Rose Honey", 3.40, "/outside/assets/images/dessert-4.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 4,1));
            add(new Product("Banana Cake", 3.90, "/outside/assets/images/dessert-5.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 4,1));
            add(new Product("Hot Cake Blackberry", 3.90, "/outside/assets/images/dessert-6.jpg", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.", 4,1));
        }
    };
    public void addData() {
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        RoleDAO roleDAO = new RoleDAO();
        UserDAO userDAO = new UserDAO();
        for (Category category: categories) {
            categoryDAO.insertCategory(category);
        }
        for (Product product: products) {
            product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            productDAO.insertProduct(product);
        }
        for (Role role: roles) {
            roleDAO.insertRole(role);
        }
        for (User user: users) {
            userDAO.insertUser(user);
        }
    }
}
