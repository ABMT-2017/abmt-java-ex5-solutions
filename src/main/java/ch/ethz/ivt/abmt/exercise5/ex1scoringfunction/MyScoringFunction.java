package ch.ethz.ivt.abmt.exercise5.ex1scoringfunction;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.events.Event;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Leg;
import org.matsim.api.core.v01.population.Person;
import org.matsim.core.scoring.ScoringFunction;

public class MyScoringFunction implements ScoringFunction {
	private static final Logger log = Logger.getLogger( MyScoringFunction.class );
	private double score = 0;

	public MyScoringFunction( Person person ) {
		log.debug( "Creating scoring function for person "+person.getId() );
	}

	public void handleLeg(Leg leg) {
		score -= leg.getTravelTime();
	}

	public double getScore() {
		return score;
	}

	public void handleActivity(Activity activity) {}
	public void agentStuck(double v) {}
	public void addMoney(double v) {}
	public void finish() {}
	public void handleEvent(Event event) {}
}
