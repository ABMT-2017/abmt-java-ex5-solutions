package ch.ethz.ivt.abmt.exercise5.ex4injectscoringfunction;

import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.events.Event;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Leg;
import org.matsim.api.core.v01.population.Person;
import org.matsim.core.scoring.ScoringFunction;
import org.matsim.core.utils.misc.Time;
import org.matsim.facilities.ActivityFacility;
import org.matsim.pt.PtConstants;

/**
 * @author thibautd
 */
public class MyParameterizedScoringFunction implements ScoringFunction {
	private double score = 0;
	private final Scenario scenario;
	private final Person person;

	public MyParameterizedScoringFunction(
			Scenario scenario ,
			Person person ) {
		this.scenario = scenario;
		this.person = person;
	}

	public void handleActivity( Activity activity ) {
		// changing from one public transport vehicle to the other is represented by activities,
		// that we want to ignore (they do not have facilities)
		if ( PtConstants.TRANSIT_ACTIVITY_TYPE.equals( activity.getType() ) ) return;

		// first and last activity have no start/end time. Ignore them
		if ( Time.UNDEFINED_TIME == activity.getStartTime() ) return;
		if ( Time.UNDEFINED_TIME == activity.getEndTime() ) return;

		ActivityFacility facility =
				scenario.getActivityFacilities()
						.getFacilities()
						.get( activity.getFacilityId() );

		if ( facility == null ) throw new RuntimeException( "Could not find facility "+activity.getFacilityId()+" for person "+person.getId() );

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
