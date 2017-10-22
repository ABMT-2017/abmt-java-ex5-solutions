package ch.ethz.ivt.abmt.exercise5.ex2controlerlistener;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.population.Person;
import org.matsim.api.core.v01.population.Population;
import org.matsim.core.controler.events.IterationStartsEvent;
import org.matsim.core.controler.listener.IterationStartsListener;

public class MyControlerListenner implements IterationStartsListener {
	private static final Logger log = Logger.getLogger( MyControlerListenner.class );

	public void notifyIterationStarts(IterationStartsEvent event) {
		Population population = event.getServices().getScenario().getPopulation();

		double mean = 0;
		for ( Person person : population.getPersons().values() ) {
			mean += person.getPlans().size();
		}
		mean /= population.getPersons().size();

		log.info( "The average number of plans per agent in iteration "+event.getIteration()+" is "+mean );
	}
}
