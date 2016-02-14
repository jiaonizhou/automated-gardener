package garden;

import java.util.*;

class Fertilizer {
	
	public Fertilizer() {
		int frequency = FlowerGrowingPlan.frequency(0);
		Garden.timer.schedule(new FertilizerTask(), frequency*1000);
	}
	
	class FertilizerTask extends TimerTask {
		public void run() {
			System.out.println("Fertilizing!");
		    this.cancel();
			Date currentDate = new Date();
			long growthPeriod = (currentDate.getTime() - Garden.epoch.getTime()) / 1000;
			System.out.println("Time: Sec " + growthPeriod);
			int frequency = FlowerGrowingPlan.frequency(growthPeriod);
			Garden.timer.schedule(new FertilizerTask(), frequency*1000);
		}
	}
	
	class FertilizerOffTask extends TimerTask {
		public void run() {
			System.out.println("Fertilizing finished!");
			this.cancel();
			Date currentDate = new Date();
			long growthPeriod = (currentDate.getTime() - Garden.epoch.getTime()) / 1000;
			System.out.println("Time: Sec " + growthPeriod);
		}
	}
}