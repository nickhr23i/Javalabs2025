package org.Repository;

import jakarta.persistence.EntityManager;
import org.Model.City;
import org.example.EntityManagerFactorySingleton;

import java.util.List;

public class CityRepository {
    private EntityManager em;

    public void create(City city) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        em.close();
    }

    public City findById(int id) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        City city = em.find(City.class, id);
        em.close();
        return city;
    }

    public List<City> findByName(String name) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        List<City> cities = em.createNamedQuery("City.findByName")
                .setParameter("cityname", name)
                .getResultList();
        em.close();
        return cities;
    }


}
