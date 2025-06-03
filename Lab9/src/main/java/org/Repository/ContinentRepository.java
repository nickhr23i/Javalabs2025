package org.Repository;

import jakarta.persistence.NoResultException;
import org.Model.Continent;
import org.Model.Country;
import org.example.EntityManagerFactorySingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ContinentRepository extends AbstractRepository<Continent, Integer> implements AbstractContinent{

    @Override
    public Continent findById(Integer id) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        Continent continent = em.find(Continent.class, id);
        em.close();
        return continent;
    }

    @Override
    public List<Continent> findByName(String name) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        List<Continent> continents = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        try {
            continents = em.createNamedQuery("Continent.findByName")
                .setParameter("continentName", name)
                .getResultList();
            if(continents.isEmpty()) {
                logger.warning("No continent found with name: " + name);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error executing query: Continent.findByName", e);
        } finally {
            long elapsed = System.currentTimeMillis() - startTime;
            logger.info("JPQL Execution time: " + elapsed + " ms");
        }
        em.close();
        return continents;
    }

}
