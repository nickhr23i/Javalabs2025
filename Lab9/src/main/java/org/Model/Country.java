package org.Model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Country.findByName",
                query = "select e from Country e where e.name LIKE :countryName ")
})
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "code", length = 3)
    private String code;

    @JoinColumn(name="continent",referencedColumnName = "id")
    @ManyToOne
    private Continent continent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="country")
    private List<City> cities=new ArrayList<>();

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
