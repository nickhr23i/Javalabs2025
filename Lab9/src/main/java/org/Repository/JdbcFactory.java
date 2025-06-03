package org.Repository;

public class JdbcFactory extends AbstractFactory {
    @Override
    public AbstractCity getCityDAO() {
        return new CityDAO();
    }

    @Override
    public AbstractContinent getContinentDAO() {
        return new ContinentDAO();
    }

    @Override
    public AbstractCountry getCountryDAO() {
        return new CountryDAO();
    }
}
