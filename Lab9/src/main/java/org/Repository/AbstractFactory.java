package org.Repository;

public abstract class AbstractFactory {

    public static AbstractFactory getFactory(String type) {
        return switch (type.toLowerCase()) {
            case "jpa" -> new JpaFactory();
            case "jdbc" -> new JdbcFactory();
            default -> throw new IllegalArgumentException("Unknown DAO type: " + type);
        };
    }

    public abstract AbstractCity getCityDAO();

    public abstract AbstractContinent getContinentDAO();

    public abstract AbstractCountry getCountryDAO();
}
