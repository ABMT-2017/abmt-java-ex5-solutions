package ch.ethz.ivt.abmt.exercise5.ex4injectscoringfunction;

import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.events.Event;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Leg;
import org.matsim.core.scoring.ScoringFunction;
import org.matsim.facilities.ActivityFacility;

/**
 * @author thibautd
 */
public class MyParameterizedScoringFunction implements ScoringFunction {
	private double score = 0;
	private final Scenario scenario;

	public MyParameterizedScoringFunction( final Scenario scenario ) {
		this.scenario = scenario;
	}

	public void handleActivity( Activity activity ) {
		ActivityFacility facility =
				scenario.getActivityFacilities()
						.getFacilities()
						.get( activity.getFacilityId() );
		score += facility.getActivityOptions().size() * ( activity.getEndTime() - activity.getStartTime() );
	}

	public double getScore() {
		return score;
	}

	public void handleLeg( Leg leg ) {}
	public void agentStuck( double v ) {}
	public void addMoney( double v ) {}
	public void finish() {}
	public void handleEvent( Event event ) {}
}
