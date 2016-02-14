package garden;

import java.util.*;

class Sprinkler {
	

	public Sprinkler() {
		int frequency = FlowerGrowingPlan.frequency(0);
		Garden.timer.schedule(new SprinklerTask(), frequency*1000);
	}
	
	class SprinklerTask extends TimerTask {
		public void run() {
			System.out.println("Sprinkler is on!");
		    this.cancel();
			Date currentDate = new Date();
			long growthPeriod = (currentDate.getTime() - Garden.epoch.getTime()) / 1000;
			System.out.println("Time: Sec " + growthPeriod);
			int frequency = FlowerGrowingPlan.frequency(growthPeriod);
			Garden.timer.schedule(new SprinklerTask(), frequency*1000);
		}
	}
	
	class SprinklerOffTask  extends TimerTask {
		public void run() {
			System.out.println("Sprinkler is off!");
			this.cancel();
			Date currentDate = new Date();
			long growthPeriod = (currentDate.getTime() - Garden.epoch.getTime()) / 1000;
			System.out.println("Time: Sec " + growthPeriod);
		}
	}
}