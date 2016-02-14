package garden;

import java.util.*;
import garden.GardenViewController;

class Heater {
	GardenViewController vc;
	
	public Heater(GardenViewController vc) {
		this.vc = vc;
		int frequency = FlowerGrowingPlan.frequency(0);
		Garden.timer.schedule(new HeaterTask(), frequency*1000);
	}
	
	class HeaterTask extends TimerTask {
		public void run() {
			vc.turnPalmHeater(true);
			System.out.println("Heater is on!");
		    this.cancel();
			Date currentDate = new Date();
			long growthPeriod = (currentDate.getTime() - Garden.epoch.getTime()) / 1000;
			System.out.println("Time: Sec " + growthPeriod);
			int frequency = FlowerGrowingPlan.frequency(growthPeriod);
			Garden.timer.schedule(new HeaterOffTask(), frequency*1000);
		}
	}
	
	class HeaterOffTask  extends TimerTask {
		public void run() {
			vc.turnPalmHeater(false);
			System.out.println("Heater is off!");
			this.cancel();
			Date currentDate = new Date();
			long growthPeriod = (currentDate.getTime() - Garden.epoch.getTime()) / 1000;
			System.out.println("Time: Sec " + growthPeriod);
		}
	}
}