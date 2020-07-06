package com.heleyquin.dao;

import com.heleyquin.model.Product;
import com.heleyquin.model.Role;
import com.heleyquin.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class UserDAO {
    EntityManagerFactory emf = new Manager().init();
    EntityManager em = emf.createEntityManager();

    public void insertUser(User user) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public boolean checkExistUser(String username, String password) {
        Query query = em.createQuery("SELECT e FROM User e WHERE e.username = ?1 and e.password = :passwordValue");
        query.setParameter(1, username);
        query.setParameter("passwordValue", password);
        List<User> resultList = query.getResultList();
        if(resultList.size() > 0) {
            return true;
        }
        return false;
    }
    public User getUser(String username, String password) {
        Query query = em.createQuery("SELECT e FROM User e WHERE e.username = ?1 and e.password = :passwordValue");
        query.setParameter(1, username);
        query.setParameter("passwordValue", password);
        List<User> resultList = query.getResultList();
        if(resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
