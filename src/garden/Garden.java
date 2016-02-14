package garden;

import java.util.*;

class Garden {
	static Timer timer;
	static Date epoch;
	
	public static void main (String args[]) {
		timer = new Timer();
		epoch = new Date();
		System.out.println(epoch);
		new Flower("rose");
		new Sprinkler();
		new Heater();
		new Fertilizer();
		while(true) {
		}
	}
}