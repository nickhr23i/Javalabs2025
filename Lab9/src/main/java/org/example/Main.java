package org.example;

import org.Model.Continent;

import jakarta.persistence.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Continent continent = new Continent("Europe");
        em.persist(continent);

        List<Continent> continets = (List<Continent>) em.createQuery(
                        "select e from Continent e where e.name='Europe'")
                .getResultList();
        for (Continent c : continets) {
            c.setName("Africa");
        }
        em.getTransaction().commit();
        em.close();
        EntityManagerFactorySingleton.closeEntityManagerFactory();
    }
}