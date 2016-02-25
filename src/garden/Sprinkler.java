package garden;

import java.util.*;
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
		Garden.timer.schedule(new SprinklerOffTaskRandom(), growthPeriod);
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
				LogManager.getLogManager().getRegularLogger().info("Sprinkler is on! " + "Time: " + growthPeriod + " sec");
				this.cancel();
				Garden.timer.schedule(new SprinklerOffTask(), 3 * 1000);
			}
			int frequency = GrowingPlan.frequency(growthPeriod);
			Garden.timer.schedule(new SprinklerTask(), frequency * 1000);
		}
	}
	
	class SprinklerOffTask extends TimerTask {
		public void run() {
			int n = Weather.currentWeather;
			if (n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9 || n == 10) {
				vc.turnPalmSprinkler(false);
				vc.turnDeciduousSprinkler(false);
				vc.turnSunflowerSprinkler(false);
				vc.turnTulipSprinkler(false);
				long growthPeriod = Garden.getGrowthPeriod();
				LogManager.getLogManager().getRegularLogger().info("Sprinkler is off! " + "Time: " + growthPeriod + " sec");
				this.cancel();
			}
		}
	}
	
	class SprinklerTaskRandom extends TimerTask {
		public void run() {
			vc.turnPalmSprinkler(true);
			vc.turnDeciduousSprinkler(true);
			vc.turnSunflowerSprinkler(true);
			vc.turnTulipSprinkler(true);
			long growthPeriod = Garden.getGrowthPeriod();
			LogManager.getLogManager().getRandomLogger().info("Sprinkler is on! " + "Time: " + growthPeriod + " sec");
			this.cancel();
		}
	}
	
	class SprinklerOffTaskRandom extends TimerTask {
		public void run() {
			vc.turnPalmSprinkler(false);
			vc.turnDeciduousSprinkler(false);
			vc.turnSunflowerSprinkler(false);
			vc.turnTulipSprinkler(false);
			long growthPeriod = Garden.getGrowthPeriod();
			LogManager.getLogManager().getRandomLogger().info("Sprinkler is off! " + "Time: " + growthPeriod + " sec");
			this.cancel();
		}
	}
}