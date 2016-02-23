package garden;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import garden.GardenViewController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.nio.file.Path;
import java.nio.file.Paths;


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
		new Fertilizer(vc);
		Pesticide pesticide = new Pesticide(vc);
		new Random(vc, sprinkler, heater, pesticide);
	}
	
	public void setupLogger() {
		Logger logger = Logger.getLogger("Gardener");
		logger.setLevel(Level.ALL);
		FileHandler fh;  

	    try {
	        // This block configure the logger with handler and formatter  
	    	Path currentRelativePath = Paths.get("");
	    	String dir = currentRelativePath.toAbsolutePath().toString();
	        fh = new FileHandler(dir + "/gardener.log");  
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