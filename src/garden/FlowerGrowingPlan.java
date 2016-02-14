package garden;

class FlowerGrwoingPlan {
	private int frequency;
	
	public int frequency(int growthPeriod) {
		if (growthPeriod > 0 && growthPeriod < 10) {
			frequency = 3;
			return frequency;
		} else if (growthPeriod > 10 && growthPeriod < 20) {
			frequency = 2;
			return frequency;
		} else {
			frequency = 1;
			return frequency;
		}
	}
}