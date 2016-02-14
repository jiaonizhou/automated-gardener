package garden;

import java.util.Date;

public class Flower {
	Date plantDate;
	String plantName;
	
	public Flower(String plantName) {
		plantDate = new Date();
		this.plantName = plantName;
		System.out.println("New flower " + plantName + " is planted");
	}
}