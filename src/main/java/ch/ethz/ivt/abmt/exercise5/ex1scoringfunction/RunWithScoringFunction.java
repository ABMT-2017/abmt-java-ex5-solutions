package ch.ethz.ivt.abmt.exercise5.ex1scoringfunction;

import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;

public class RunWithScoringFunction {
	public static void main( String[] args ) {
		String configFile = args[ 0 ];

		Config config = ConfigUtils.loadConfig( configFile );
		Controler controler = new Controler( config );

		// now you will need to add your scoring function factory to the controler
		controler.setScoringFunctionFactory( new MyScoringFunctionFactory() );

		controler.run();
	}
}
