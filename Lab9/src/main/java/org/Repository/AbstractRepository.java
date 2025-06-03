package org.Repository;

import jakarta.persistence.*;
import org.example.EntityManagerFactorySingleton;
import org.example.ProjectLogger;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractRepository<T, ID extends Serializable> {

    protected EntityManager em;
    protected Logger logger=ProjectLogger.getLogger();

    public void create(T entity) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public T findById(ID id) {
        return null;
    }

    public List<T> findByName(String name) {
        return null;
    }


}
