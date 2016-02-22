package garden;

import java.util.*;
import java.util.logging.Logger;

import garden.GardenViewController;

class Sprinkler {
	GardenViewController vc;

	public Sprinkler(GardenViewController vc) {
		this.vc = vc;
		int frequency = GrowingPlan.frequency(0);
		Garden.timer.schedule(new SprinklerTask(), frequency * 1000);
	}
	
	public void randomSprinkler(GardenViewController vc) {
		this.vc = vc;
		long growthPeriod = Garden.getGrowthPeriod();
		Garden.timer.schedule(new SprinklerTaskRandom(), growthPeriod);
	}
	
	public void randomSprinklerOff(GardenViewController vc) {
		this.vc = vc;
		long growthPeriod = Garden.getGrowthPeriod();
		Garden.timer.schedule(new SprinklerOffTask(), growthPeriod);
	}
	
	class SprinklerTask extends TimerTask {
		public void run() {
			int n = Weather.currentWeather;
			long growthPeriod = Garden.getGrowthPeriod();
			if (n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9 || n == 10) {
				vc.turnPalmSprinkler(true);
				vc.turnDeciduousSprinkler(true);
				vc.turnSunflowerSprinkler(true);
				vc.turnTulipSprinkler(true);
				Logger.getLogger("Gardener").info("Sprinkler is on");
				this.cancel();
				Garden.timer.schedule(new SprinklerOffTask(), 1 * 1000);
				System.out.println("Time: Sec " + growthPeriod);
			}
			int frequency = GrowingPlan.frequency(growthPeriod);
			Garden.timer.schedule(new SprinklerTask(), frequency * 1000);
		}
	}
	
	class SprinklerOffTask extends TimerTask {
		public void run() {
			vc.turnPalmSprinkler(false);
			vc.turnDeciduousSprinkler(false);
			vc.turnSunflowerSprinkler(false);
			vc.turnTulipSprinkler(false);
			System.out.println("Sprinkler is off!");
			this.cancel();
		}
	}
	
	class SprinklerTaskRandom extends TimerTask {
		public void run() {
			vc.turnPalmSprinkler(true);
			vc.turnDeciduousSprinkler(true);
			vc.turnSunflowerSprinkler(true);
			vc.turnTulipSprinkler(true);
			System.out.println("Sprinkler is on!");
			this.cancel();
			Garden.timer.schedule(new SprinklerOffTask(), 20 * 1000);
		}
	}
}