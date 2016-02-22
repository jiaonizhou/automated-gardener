package garden;

public class GrowingPlan {
	private static int frequency;
	
	public static int frequency(long growthPeriod) {
		if (growthPeriod >= 0 && growthPeriod < 10) {
			frequency = 10;
		} else if (growthPeriod >= 10 && growthPeriod < 20) {
			frequency = 5;
		} else {
			frequency = 2;
		}
		return frequency;
	}
}