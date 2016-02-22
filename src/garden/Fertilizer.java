package garden;

import java.util.*;
import garden.GardenViewController;

class Fertilizer {
	GardenViewController vc;
	
	public Fertilizer(GardenViewController vc) {
		this.vc = vc;
		int frequency = GrowingPlan.frequency(0);
		Garden.timer.schedule(new FertilizerTask(), frequency * 1000);
	}
	
	class FertilizerTask extends TimerTask {
		public void run() {
			vc.turnPalmFertilizer(true);
			vc.turnDeciduousFertilizer(true);
			vc.turnSunflowerFertilizer(true);
			vc.turnTulipFertilizer(true);
			System.out.println("Fertilizing!");
		    this.cancel();
		    Garden.timer.schedule(new FertilizerOffTask(), 1 * 1000);
		    long growthPeriod = Garden.getGrowthPeriod();
			System.out.println("Time: Sec " + growthPeriod);
			int frequency = GrowingPlan.frequency(growthPeriod);
			Garden.timer.schedule(new FertilizerTask(), frequency * 1000);
		}
	}
	
	class FertilizerOffTask extends TimerTask {
		public void run() {
			vc.turnPalmFertilizer(false);
			vc.turnDeciduousFertilizer(false);
			vc.turnSunflowerFertilizer(false);
			vc.turnTulipFertilizer(false);
			System.out.println("Fertilizing finished!");
			this.cancel();
		}
	}
}