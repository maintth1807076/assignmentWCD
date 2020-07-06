package com.heleyquin.dao;

import com.heleyquin.model.Category;
import com.heleyquin.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CategoryDAO {
    EntityManagerFactory emf = new Manager().init();
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public void insertCategory(Category Category) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(Category);
        em.getTransaction().commit();
        em.close();
    }

    public Category getCategory(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = em.find(Category.class, id);
        em.getTransaction().commit();
        em.close();
        return category;
    }

    public List<Category> getAllCategory() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Category> list = em.createQuery("select c from Category c", Category.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public List<Product> getProductsByCategory(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("SELECT c FROM Product c WHERE c.categoryId = " + id, Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public void updateCategory(Category category) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Category entity = em.find(Category.class, category.getId());
        entity.setName(category.getName());
        em.getTransaction().commit();
        em.close();
    }

    public void deleteCategory(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product entity = em.find(Product.class, id);
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }
}
