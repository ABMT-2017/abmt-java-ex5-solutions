package ch.ethz.ivt.abmt.exercise5.ex4injectscoringfunction;

import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;

/**
 * @author thibautd
 */
public class RunWithGuice {
	public static void main( String[] args ) {
		String configFile = args[ 0 ];

		Config config = ConfigUtils.loadConfig( configFile );
		Controler controler = new Controler( config );

		// now you will need to add our module to the controler
		controler.addOverridingModule( new MyScoringFunctionModule() );

		controler.run();
	}
}
