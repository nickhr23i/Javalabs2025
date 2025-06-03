package org.Repository;

import org.Model.City;

import java.sql.SQLException;
import java.util.List;

public interface AbstractCity {
    public abstract void create(City city) ;
    public abstract City findById(Integer id);
    public abstract List<City> findByName(String cityName);
}
