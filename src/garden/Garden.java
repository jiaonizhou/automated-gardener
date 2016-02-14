package garden;

import java.util.*;

class Garden {
	static Timer timer;
	static Date epoch;
	
	// Track the passing of time for certain events, java calcualte date difference
	//public static int calculateVirtualTime(Date when) {
	//	int dayDiff;
	//	int hourDiff;
	//	int minDiff;
	//	int secDiff;
	//	int whenDay = Integer.parseInt(when.toString().substring(8, 9));
	//	int epochDay = Integer.parseInt(epoch.toString().substring(8, 9));
	//	dayDiff = whenDay - epochDay;
	//	hourDiff = int(when.toString().substring(11, 12)) - int(epoch.toString().substring(11, 12));
	//	minDiff = 
	//	secDiff = 
	//}
	
	public static void main (String args[]) {
		timer = new Timer();
		epoch = new Date();
		System.out.println(epoch);
		new Flower("rose");
		new Sprinkler("flower");
		while(true) {
		}
	}
}