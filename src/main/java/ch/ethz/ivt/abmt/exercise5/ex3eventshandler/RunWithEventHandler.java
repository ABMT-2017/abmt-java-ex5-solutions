package ch.ethz.ivt.abmt.exercise5.ex3eventshandler;

import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;

public class RunWithEventHandler {
	public static void main( String[] args ) {
		//String configFile = args[ 0 ];
		String configFile = "input/siouxfalls-2014/config_default.xml";

		Config config = ConfigUtils.loadConfig( configFile );
		Controler controler = new Controler( config );

		// the same event handler object needs to be added both as a controler listener
		// and as an event handler
		MyEventHandler handler = new MyEventHandler();
		controler.addControlerListener( handler );
		controler.getEvents().addHandler( handler );

		controler.run();
	}
}
