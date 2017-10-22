package ch.ethz.ivt.abmt.exercise5.ex1scoringfunction;

import org.matsim.api.core.v01.population.Person;
import org.matsim.core.scoring.ScoringFunction;
import org.matsim.core.scoring.ScoringFunctionFactory;

public class MyScoringFunctionFactory implements ScoringFunctionFactory {
	public ScoringFunction createNewScoringFunction(Person person) {
		return new MyScoringFunction( person );
	}
}
