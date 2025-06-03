package org.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "continents")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from Continent e order by e.name"),

        @NamedQuery(name = "Continent.findByName",
                query = "select e from Continent e where e.name LIKE :continentName ")
})
public class Continent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "continent")
    private List<Country> countries = new ArrayList<>();

    public Continent(String name) {
        this.name = name;
    }

    public Continent() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}


