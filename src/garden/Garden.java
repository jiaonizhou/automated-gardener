package garden;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import garden.GardenViewController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

class Garden {
	static Timer timer = new Timer();
	static Date epoch = new Date();
	public Random random;
	
	public static long getGrowthPeriod() {
		Date currentDate = new Date();
		long growthPeriod = (currentDate.getTime() - Garden.epoch.getTime()) / 1000;
		return growthPeriod;
	}
	
	public Garden (GardenViewController vc) {
		// set up logger
		setupLogger();
		
		new Weather();
		Sprinkler sprinkler = new Sprinkler(vc);
		Heater heater = new Heater(vc);
		Pesticide pesticide = new Pesticide(vc);
		new Fertilizer(vc);
		new Random(vc, sprinkler, heater, pesticide);
	}
	
	public void setupLogger() {
		Logger logger = Logger.getLogger("Gardener");
		logger.setLevel(Level.ALL);
		FileHandler fh;  

	    try {
	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("/tmp/gardener.log");  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}
}