package org.Repository;

import org.Model.Continent;

import java.sql.SQLException;
import java.util.List;

public interface AbstractContinent {
    public abstract void create(Continent continent);
    public abstract Continent findById(Integer id) ;
    public abstract List<Continent> findByName(String cityName) ;
}
