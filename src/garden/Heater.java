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
		Garden.timer.schedule(new HeaterOffTask(), growthPeriod);
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
				System.out.println("Heater is on!");
				this.cancel();
				Garden.timer.schedule(new HeaterOffTask(), 1 * 1000);
				System.out.println("Time: Sec " + growthPeriod);
			}
			int frequency = GrowingPlan.frequency(growthPeriod);
			Garden.timer.schedule(new HeaterTask(), frequency * 1000);
		}
	}
	
	class HeaterOffTask extends TimerTask {
		public void run() {
			vc.turnPalmHeater(false);
			vc.turnDeciduousHeater(false);
			vc.turnSunflowerHeater(false);
			vc.turnTulipHeater(false);
			System.out.println("Heater is off!");
			this.cancel();
		}
	}
	
	class HeaterTaskRandom extends TimerTask {
		public void run() {
			vc.turnPalmHeater(true);
			vc.turnDeciduousHeater(true);
			vc.turnSunflowerHeater(true);
			vc.turnTulipHeater(true);
			System.out.println("Heater is on!");
			this.cancel();
			Garden.timer.schedule(new HeaterOffTask(), 20 * 1000);
		}
	}
}