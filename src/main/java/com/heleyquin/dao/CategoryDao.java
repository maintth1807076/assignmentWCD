package com.heleyquin.dao;

import com.heleyquin.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public void insert(Category model) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();
        em.close();
    }
}
