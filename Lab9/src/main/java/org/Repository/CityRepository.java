package org.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.Model.City;
import org.example.EntityManagerFactorySingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class CityRepository extends AbstractRepository<City, Integer> implements AbstractCity{

    @Override
    public City findById(Integer id) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        City city = em.find(City.class, id);
        em.close();
        return city;
    }

    @Override
    public List<City> findByName(String name) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        List<City> cities = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        try {
            cities = em.createNamedQuery("City.findByName")
                    .setParameter("cityName", name)
                    .getResultList();
            if (cities.isEmpty()) {
                logger.warning("No city found with name: " + name);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error executing query: City.findByName", e);
        } finally {
            long elapsed = System.currentTimeMillis() - startTime;
            logger.info("JPQL Execution time: " + elapsed + " ms");
        }
        em.close();
        return cities;
    }


}
