package org.example;

import jakarta.persistence.*;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactory emf=null;

    private EntityManagerFactorySingleton() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = createEntityManagerFactory();
        }
        return emf;
    }

    public static EntityManagerFactory createEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("citydb");
        } catch (Exception e) {
            System.err.println("Could not create entity manager factory: " + e);
        }
        return null;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }
}
