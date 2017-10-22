package ch.ethz.ivt.abmt.exercise5.ex3eventshandler;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.events.ActivityEndEvent;
import org.matsim.api.core.v01.events.ActivityStartEvent;
import org.matsim.api.core.v01.events.handler.ActivityEndEventHandler;
import org.matsim.api.core.v01.events.handler.ActivityStartEventHandler;
import org.matsim.core.controler.events.AfterMobsimEvent;
import org.matsim.core.controler.listener.AfterMobsimListener;

public class MyEventHandler implements ActivityStartEventHandler, ActivityEndEventHandler, AfterMobsimListener {
	private static final Logger log = Logger.getLogger( MyEventHandler.class );
	private int activityStarts = 0;
	private int activityEnds = 0;

	public void handleEvent(ActivityEndEvent event) {
		activityEnds++;
	}

	public void handleEvent(ActivityStartEvent event) {
		activityStarts++;
	}

	public void notifyAfterMobsim(AfterMobsimEvent event) {
		log.info( activityStarts+" activity start events in iteration "+event.getIteration() );
		log.info( activityEnds+" activity end events in iteration "+event.getIteration() );
	}

	public void reset(int iteration) {
		activityEnds = 0;
		activityStarts = 0;
	}
}
