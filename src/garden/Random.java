package garden;

import java.util.TimerTask;
import garden.GardenViewController;


class Random {
	GardenViewController vc;
	Sprinkler sprinkler;
	Heater heater;
	Pesticide pesticide;
	
	public Random(GardenViewController vc, Sprinkler sprinkler, Heater heater, Pesticide pesticide) {
		this.vc = vc;
		this.sprinkler = sprinkler;
		this.heater = heater;
		this.pesticide = pesticide;
		int n = Weather.currentWeather;
		long growthPeriod = Garden.getGrowthPeriod();

		if (n == 1) {
			Garden.timer.schedule(new RandomTask1(), growthPeriod);
		} else if (n == 2) {
			Garden.timer.schedule(new RandomTask2(), growthPeriod);
		} else if (n == 3) {
			Garden.timer.schedule(new RandomTask3(), growthPeriod);
		} else if (n == 4) {
			Garden.timer.schedule(new RandomTask4(), growthPeriod);
		} else if (n == 5) {
			Garden.timer.schedule(new RandomTask5(), growthPeriod);
		}
		vc.turnPalmRandomEvent(n);
		vc.turnDeciduousRandomEvent(n);
		vc.turnSunflowerRandomEvent(n);
		vc.turnTulipRandomEvent(n);
		Garden.timer.schedule(new RandomTask6(), 24 * 1000);
	}
		
	class RandomTask1 extends TimerTask {
		public void run() {
			Random.this.sprinkler.randomSprinkler(vc);
		}
	}
	
	class RandomTask2 extends TimerTask {
		public void run() {
			Random.this.sprinkler.randomSprinklerOff(vc);
		}
	}
	
	class RandomTask3 extends TimerTask {
		public void run() {
			Random.this.heater.randomHeater(vc);
		}
	}
	
	class RandomTask4 extends TimerTask {
		public void run() {
			Random.this.heater.randomHeaterOff(vc);
		}
	}
	
	class RandomTask5 extends TimerTask {
		public void run() {
			Random.this.pesticide.randomPesticide(vc);
			Random.this.pesticide.randomPesticideOff(vc);
		}
	}
	
	class RandomTask6 extends TimerTask {
		public void run() {
			new Random(vc, sprinkler, heater, pesticide);
		}
	}
}