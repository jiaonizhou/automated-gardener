package garden;

public class GrowingPlan {
	private static int frequency;
	public static int period1 = 240;
	public static int period2 = 480;
	public static int highFreq = 12;
	public static int mediumFreq = 8;
	public static int lowFreq = 6;
	
	
	public static int frequency(long growthPeriod) {
		if (growthPeriod >= 0 && growthPeriod < period1) {
			frequency = highFreq;
		} else if (growthPeriod >= period1 && growthPeriod < period2) {
			frequency = mediumFreq;
		} else {
			frequency = lowFreq;
		}
		return frequency;
	}
}