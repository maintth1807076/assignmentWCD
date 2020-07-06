package com.heleyquin.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private static EntityManagerFactory emf;
    public EntityManagerFactory init(){
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("persistence");
        }
        return emf;
    }
}
