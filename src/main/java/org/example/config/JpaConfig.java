package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConfig {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("bancoPU");
    }

    public static EntityManager entityManager() {
        return emf.createEntityManager();
    }

    public static void closeFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}