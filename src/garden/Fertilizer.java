package garden;

import java.util.*;
import garden.GardenViewController;
import java.util.logging.Logger;

class Fertilizer {
	GardenViewController vc;
	
	public Fertilizer(GardenViewController vc) {
		this.vc = vc;
		int frequency = GrowingPlan.frequency(0);
		Garden.timer.schedule(new FertilizerTask(), frequency * 1000);
	}
	
	class FertilizerTask extends TimerTask {
		public void run() {
		    long growthPeriod = Garden.getGrowthPeriod();
			vc.turnPalmFertilizer(true);
			vc.turnDeciduousFertilizer(true);
			vc.turnSunflowerFertilizer(true);
			vc.turnTulipFertilizer(true);
			Logger.getLogger("Gardener").info("Fertilizing! " + "Time: " + growthPeriod + " sec");
		    this.cancel();
		    Garden.timer.schedule(new FertilizerOffTask(), 3 * 1000);
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
			long growthPeriod = Garden.getGrowthPeriod();
			Logger.getLogger("Gardener").info("Fertilizing finished! " + "Time: " + growthPeriod + " sec");
			this.cancel();
		}
	}
}