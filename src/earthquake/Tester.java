package earthquake;

public class Tester {

	public void testGetBigQuakes() {
		EarthQuakeClient c = new EarthQuakeClient();
		c.getBigQuakes();
	}

	public void testCloseToMe() {
		EarthQuakeClient c = new EarthQuakeClient();
		c.closeToMe();
	}

	public void testGetDeepQuakes() {
		EarthQuakeClient c = new EarthQuakeClient();
		c.getDeepQuakes();
	}

	public void testGetPhraseQuakes() {
		EarthQuakeClient c = new EarthQuakeClient();
		c.getQuakesByPhrase();
	}

	public void testClosestQuakes() {
		ClosestQuakes c = new ClosestQuakes();
		c.findClosestQuakes();
	}

}
