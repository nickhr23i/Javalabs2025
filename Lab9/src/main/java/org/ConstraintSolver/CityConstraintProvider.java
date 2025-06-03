package org.ConstraintSolver;

import org.Model.City;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.*;

public class CityConstraintProvider implements ConstraintProvider {

    private static final int MIN_POP = 1300000;
    private static final int MAX_POP = 5000000;

    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[]{
                sameStartLetter(factory),
                uniqueCountries(factory),
                populationWithinBounds(factory)
        };
    }

    private Constraint sameStartLetter(ConstraintFactory factory) {
        var builder = factory.forEach(CitySelection.class)
                .filter(sel -> sel.getCity() != null)
                .groupBy(sel -> sel.getCity().getName().substring(0, 1), ConstraintCollectors.count())
                .filter((letter, count) -> count < 2)
                .penalize(HardSoftScore.ofHard(1));
        return builder.asConstraint("sameStartLetter");
    }


    private Constraint uniqueCountries(ConstraintFactory factory) {
        var builder = factory.forEachUniquePair(CitySelection.class,
                        Joiners.equal(sel -> sel.getCity().getCountry()))
                .penalize(HardSoftScore.ofHard(10));
        return builder.asConstraint("uniqueCountries");
    }

    private Constraint populationWithinBounds(ConstraintFactory factory) {
        var builder = factory.forEach(CitySelection.class)
                .filter(sel -> sel.getCity() != null)
                .groupBy(
                        (sel) -> 1,
                        ConstraintCollectors.sum(sel -> sel.getCity().getPopulation())
                )
                .filter((k, popSum) -> popSum < MIN_POP || popSum > MAX_POP)
                .penalize(HardSoftScore.ofHard(100));
        return builder.asConstraint("population");
    }
}
