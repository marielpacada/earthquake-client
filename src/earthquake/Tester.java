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
}
