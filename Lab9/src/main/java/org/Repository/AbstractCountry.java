package org.Repository;

import org.Model.Country;

import java.sql.SQLException;
import java.util.List;

public interface AbstractCountry {
    public abstract void create(Country country);
    public abstract Country findById(Integer id) ;
    public abstract List<Country> findByName(String cityName) ;
}
