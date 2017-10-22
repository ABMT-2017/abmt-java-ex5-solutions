package ch.ethz.ivt.abmt.exercise5.ex2controlerlistener;

import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;

public class RunWithControlerListener {
	public static void main( String[] args ) {
		String configFile = args[ 0 ];

		Config config = ConfigUtils.loadConfig( configFile );
		Controler controler = new Controler( config );

		controler.addControlerListener( new MyControlerListenner() );

		controler.run();
	}
}
