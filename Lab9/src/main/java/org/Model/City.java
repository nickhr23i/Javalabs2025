
package org.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findByName",
                query = "select e from City e where e.name LIKE :cityName ")
})

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "country", referencedColumnName = "name")
    @ManyToOne
    private Country country;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "capital")
    private Boolean capital;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name="population")
    private Integer population;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}