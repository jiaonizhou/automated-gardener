package garden;

public class GrowingPlan {
	private static int frequency;
	public static int period1;
	public static int period2;
	public static int seed = period1 * 24;
	public static int germination = period2 * 24;
	public static int lowFreq = 12;
	public static int mediumFreq = 8;
	public static int highFreq = 6;
	
	
	public static int frequency(long growthPeriod) {
		if (growthPeriod >= 0 && growthPeriod < seed) {
			frequency = lowFreq;
		} else if (growthPeriod >= seed && growthPeriod < germination) {
			frequency = mediumFreq;
		} else {
			frequency = highFreq;
		}
		return frequency;
	}
}