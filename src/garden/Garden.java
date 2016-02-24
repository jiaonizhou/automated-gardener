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
	static Timer timer;
	static Date epoch;
	
	private static Garden g;
	private GardenViewController vc;
	@SuppressWarnings("unused")
	private Weather weather;
	private Sprinkler sprinkler;
	private Heater heater;
	@SuppressWarnings("unused")
	private Fertilizer fertilizer;
	private Pesticide pesticide;
	@SuppressWarnings("unused")
	private Random random;

	
	public static Garden getGarden() {
		return g;
	}
	
	public static Garden initGarden(GardenViewController vc) {
		if (g == null) {
			g = new Garden(vc);
		}
		return g;
	}
	
	public Garden (GardenViewController vc) {
		// set up logger
		setupLogger();
		
		this.vc = vc;
	}
	
	public void start() {
		timer = new Timer();
		epoch = new Date();
		weather = new Weather();
		sprinkler = new Sprinkler(vc);
		heater = new Heater(vc);
		fertilizer = new Fertilizer(vc);
		pesticide = new Pesticide(vc);
		random = new Random(vc, sprinkler, heater, pesticide);
	}
	
	public static long getGrowthPeriod() {
		Date currentDate = new Date();
		long growthPeriod = (currentDate.getTime() - Garden.epoch.getTime()) / 1000;
		return growthPeriod;
	}

	public void setupLogger() {
		Logger logger = Logger.getLogger("Gardener");
		logger.setLevel(Level.ALL);
		FileHandler fh;  

	    try {
	        // This block configure the logger with handler and formatter  
	    	Path currentRelativePath = Paths.get("");
	    	String dir = currentRelativePath.toAbsolutePath().toString();
	        fh = new FileHandler(dir + "/gardener.log", 10000000, 1);
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