package org.ConstraintSolver;

import org.Model.City;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
//import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class CitySolution {

    private List<City> cityList;
    private List<CitySelection> selectionList;

    @PlanningScore
    private HardSoftScore score;

    @ValueRangeProvider(id = "cityRange")
    @ProblemFactCollectionProperty
    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @PlanningEntityCollectionProperty
    public List<CitySelection> getSelectionList() {
        return selectionList;
    }

    public void setSelectionList(List<CitySelection> selectionList) {
        this.selectionList = selectionList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
