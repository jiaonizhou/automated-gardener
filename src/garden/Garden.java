package garden;

import java.util.*;
import garden.GardenViewController;

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
		new Weather();
		Sprinkler sprinkler = new Sprinkler(vc);
		Heater heater = new Heater(vc);
		Pesticide pesticide = new Pesticide(vc);
		new Fertilizer(vc);
		new Random(vc, sprinkler, heater, pesticide);
	}
}