package garden;

import java.util.*;

class Sprinkler {
	
	public Sprinkler(String plantType) {
		String growingPlan = plantType + "GrowingPlan";
		
		int frequency = FlowerGrwoingPlan.frequency(growthPeriod);
		Garden.timer.schedule(new SprinklerTask(), frequency*1000);
	}
	
	class SprinklerTask extends TimerTask {
		public void run() {
			System.out.println("Watering!");
		}
	}
}