package com.heleyquin.dao;

import com.heleyquin.model.Product;
import com.heleyquin.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RoleDAO {
    EntityManagerFactory emf = new Manager().init();
    EntityManager em = emf.createEntityManager();

    public void insertRole(Role role) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
        em.close();
    }
}
