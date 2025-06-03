package org.Repository;

public class JpaFactory extends AbstractFactory{
    @Override
    public AbstractCountry getCountryDAO() {
        return new CountryRepository();
    }

    @Override
    public AbstractCity getCityDAO() {
        return new CityRepository();
    }

    @Override
    public AbstractContinent getContinentDAO() {
        return new ContinentRepository();
    }
}
