package ch.ethz.ivt.abmt.exercise5.ex4injectscoringfunction;

import ch.ethz.ivt.abmt.exercise5.ex1scoringfunction.MyScoringFunctionFactory;
import org.matsim.core.controler.AbstractModule;

/**
 * @author thibautd
 */
public class MyScoringFunctionModule extends AbstractModule {
	public void install() {
		bindScoringFunctionFactory().to( MyParameterizedScoringFunctionFactory.class );
	}
}
