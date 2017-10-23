package ch.ethz.ivt.abmt.exercise5.ex4injectscoringfunction;

import com.google.inject.Inject;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.population.Person;
import org.matsim.core.scoring.ScoringFunction;
import org.matsim.core.scoring.ScoringFunctionFactory;

/**
 * @author thibautd
 */
public class MyParameterizedScoringFunctionFactory implements ScoringFunctionFactory {
	private final Scenario scenario;

	@Inject
	public MyParameterizedScoringFunctionFactory( Scenario scenario ) {
		this.scenario = scenario;
	}

	public ScoringFunction createNewScoringFunction( Person person ) {
		return new MyParameterizedScoringFunction( scenario , person );
	}
}
