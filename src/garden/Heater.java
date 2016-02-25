package garden;

import java.util.*;
import garden.GardenViewController;

class Heater {
	GardenViewController vc;
	
	public Heater(GardenViewController vc) {
		this.vc = vc;
		int frequency = GrowingPlan.frequency(0);
		Garden.timer.schedule(new HeaterTask(), frequency * 1000);
	}
	
	public void randomHeater(GardenViewController vc) {
		this.vc = vc;
		long growthPeriod = Garden.getGrowthPeriod();
		Garden.timer.schedule(new HeaterTaskRandom(), growthPeriod);
	}
	
	public void randomHeaterOff(GardenViewController vc) {
		this.vc = vc;
		long growthPeriod = Garden.getGrowthPeriod();
		Garden.timer.schedule(new HeaterOffTaskRandom(), growthPeriod);
	}
	
	class HeaterTask extends TimerTask {
		public void run() {
			int n = Weather.currentWeather;
			long growthPeriod = Garden.getGrowthPeriod();
			if (n == 1 || n == 2 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9 || n == 10) {
				vc.turnPalmHeater(true);
				vc.turnDeciduousHeater(true);
				vc.turnSunflowerHeater(true);
				vc.turnTulipHeater(true);
				LogManager.getLogManager().getRegularLogger().info("Heater is on! " + "Time: " + growthPeriod + " sec");
				this.cancel();
				Garden.timer.schedule(new HeaterOffTask(), 3 * 1000);
			}
			int frequency = GrowingPlan.frequency(growthPeriod);
			Garden.timer.schedule(new HeaterTask(), frequency * 1000);
		}
	}
	
	class HeaterOffTask extends TimerTask {
		public void run() {
			int n = Weather.currentWeather;
			if (n == 1 || n == 2 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9 || n == 10) {
				vc.turnPalmHeater(false);
				vc.turnDeciduousHeater(false);
				vc.turnSunflowerHeater(false);
				vc.turnTulipHeater(false);
				long growthPeriod = Garden.getGrowthPeriod();
				LogManager.getLogManager().getRegularLogger().info("Heater is off! " + "Time: " + growthPeriod + " sec");
				this.cancel();
			}
		}
	}
	
	class HeaterTaskRandom extends TimerTask {
		public void run() {
			vc.turnPalmHeater(true);
			vc.turnDeciduousHeater(true);
			vc.turnSunflowerHeater(true);
			vc.turnTulipHeater(true);
			long growthPeriod = Garden.getGrowthPeriod();
			LogManager.getLogManager().getRandomLogger().info("Heater is on! " + "Time: " + growthPeriod + " sec");
			this.cancel();
		}
	}
	
	class HeaterOffTaskRandom extends TimerTask {
		public void run() {
			vc.turnPalmHeater(false);
			vc.turnDeciduousHeater(false);
			vc.turnSunflowerHeater(false);
			vc.turnTulipHeater(false);
			long growthPeriod = Garden.getGrowthPeriod();
			LogManager.getLogManager().getRandomLogger().info("Heater is off! " + "Time: " + growthPeriod + " sec");
			this.cancel();
		}
	}
}