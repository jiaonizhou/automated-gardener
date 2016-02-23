package garden;

public class GrowingPlan {
	private static int frequency;
	
	public static int frequency(long growthPeriod) {
		if (growthPeriod >= 0 && growthPeriod < 240) {
			frequency = 12;
		} else if (growthPeriod >= 240 && growthPeriod < 480) {
			frequency = 8;
		} else {
			frequency = 6;
		}
		return frequency;
	}
}