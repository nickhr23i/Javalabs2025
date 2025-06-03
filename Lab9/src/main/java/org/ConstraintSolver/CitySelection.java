package org.ConstraintSolver;
import org.Model.City;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class CitySelection {

    private City city;

    @PlanningId
    private
    Integer id;


    @PlanningVariable(valueRangeProviderRefs = {"cityRange"})
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
