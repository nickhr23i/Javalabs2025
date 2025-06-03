package org.Repository;

import jakarta.persistence.NoResultException;
import org.Model.City;
import org.Model.Country;
import org.example.EntityManagerFactorySingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class CountryRepository extends AbstractRepository<Country, Integer> implements AbstractCountry{
    @Override
    public Country findById(Integer id) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        Country country = em.find(Country.class, id);
        em.close();
        return country;
    }

    @Override
    public List<Country> findByName(String name) {
        em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        List<Country> countries = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        try {
            countries = em.createNamedQuery("Country.findByName")
                    .setParameter("countryName", name)
                    .getResultList();
            if (countries.isEmpty()) {
                logger.warning("No country found with name: " + name);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error executing query: Country.findByName", e);
        } finally {
            long elapsed = System.currentTimeMillis() - startTime;
            logger.info("JPQL Execution time: " + elapsed + " ms");
        }
        em.close();
        return countries;
    }
}
