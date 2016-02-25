package garden;

import java.util.*;
import garden.GardenViewController;

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
}