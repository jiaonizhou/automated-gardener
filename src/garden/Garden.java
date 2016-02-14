package garden;

import java.util.*;
import garden.GardenViewController;
import garden.Flower;

class Garden {
	static Timer timer = new Timer();
	static Date epoch = new Date();
		
	public Garden (GardenViewController vc) {
		new Flower("rose");
		//new Sprinkler();
		new Heater(vc);
		//new Fertilizer();
	}
}