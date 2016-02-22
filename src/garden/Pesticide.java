package garden;

import java.util.TimerTask;

class Pesticide {
	GardenViewController vc;
	
	public Pesticide(GardenViewController vc) {
		this.vc = vc;
	}

	public void randomPesticide(GardenViewController vc) {
		this.vc = vc;
		long growthPeriod = Garden.getGrowthPeriod();
		Garden.timer.schedule(new PesticideTask(), growthPeriod);
	}
	
	public void randomPesticideOff(GardenViewController vc) {
		this.vc = vc;
		Garden.timer.schedule(new PesticideOffTask(), 20 * 1000);
	}
	
	class PesticideTask extends TimerTask {
		public void run() {
			vc.turnPalmPesticide(true);
			vc.turnDeciduousPesticide(true);
			vc.turnSunflowerPesticide(true);
			vc.turnTulipPesticide(true);
			System.out.println("Pesticide spray and ladybug is on!");
		    this.cancel();
		}
	}
	
	class PesticideOffTask extends TimerTask {
		public void run() {
			vc.turnPalmPesticide(false);
			vc.turnDeciduousPesticide(false);
			vc.turnSunflowerPesticide(false);
			vc.turnTulipPesticide(false);
			System.out.println("Pesticide spray and ladybug is off!");
			this.cancel();
		}
	}
}