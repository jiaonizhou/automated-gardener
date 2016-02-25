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
		Garden.timer.schedule(new PesticideOffTask(), 24 * 1000);
	}
	
	class PesticideTask extends TimerTask {
		public void run() {
			long growthPeriod = Garden.getGrowthPeriod();
			vc.turnPalmPesticide(true);
			vc.turnDeciduousPesticide(true);
			vc.turnSunflowerPesticide(true);
			vc.turnTulipPesticide(true);
			LogManager.getLogManager().getRegularLogger().info("Pesticide spray and ladybug is on! " + "Time: " + growthPeriod + " sec" );
		    this.cancel();
		}
	}
	
	class PesticideOffTask extends TimerTask {
		public void run() {
			vc.turnPalmPesticide(false);
			vc.turnDeciduousPesticide(false);
			vc.turnSunflowerPesticide(false);
			vc.turnTulipPesticide(false);
			long growthPeriod = Garden.getGrowthPeriod();
			LogManager.getLogManager().getRegularLogger().info("Pesticide spray and ladybug is off! " + "Time: " + growthPeriod + " sec");
			this.cancel();
		}
	}
}