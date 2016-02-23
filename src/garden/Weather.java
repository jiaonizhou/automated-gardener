package garden;

import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Logger;

class Weather {
	public static int currentWeather;
	
	public Weather() {
		Garden.timer.schedule(new WeatherTask(), 0, 24 * 1000);
	}
	
	// 1 = sunny, 2 = rainy, 3 = cold, 4 = hot, 5 = pest, 6, 7, 8, 9, 10 = normal
	public static int generateRand() {
		int randomNum;
		Random rand = new Random();
		randomNum = rand.nextInt(10) + 1;
		return randomNum;
	}
	
	public static String getWeather(int n) {
		String weather;
		if (n == 1) {
			weather = "sunny";
		} else if (n == 2) {
			weather = "rainy";
		} else if (n == 3) {
			weather = "cold";
	    } else if (n == 4) {
		    weather = "hot";
	    } else if (n == 5) {
		    weather = "pest attack";
	    } else {
	    	weather = "normal";
	    }
		return weather;
	}
	
	class WeatherTask extends TimerTask {
		public void run() {
			Weather.currentWeather = Weather.generateRand();
			long growthPeriod = Garden.getGrowthPeriod();
			Logger.getLogger("Gardener").info("\n\n Today's weather/ situation is " + Weather.getWeather(Weather.currentWeather) + ". " + "Time: " + growthPeriod + " sec");
		}
	}
}
	
	
	