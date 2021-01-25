package earthquake;

import java.util.ArrayList;

/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

public class ClosestQuakes {

	public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
		ArrayList<QuakeEntry> retList = new ArrayList<QuakeEntry>();
		ArrayList<QuakeEntry> copyData = quakeData;

		for (int i = 0; i < howMany; i++) {
			double closest = Double.POSITIVE_INFINITY;
			QuakeEntry qe = null;
			for (QuakeEntry currQE : copyData) {
				double currDist = current.distanceTo(currQE.getLocation());
				if (currDist < closest) {
					closest = currDist;
					qe = currQE;
				}
			}
			retList.add(qe);
			copyData.remove(qe);
		}
		return retList;
	}

	public void findClosestQuakes() {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source = "data/nov20quakedata.atom";
		String source = "/Users/marielpacada/eclipse-workspace/earthquake-client/data/nov20quakedatasmall.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size());

		Location jakarta = new Location(-6.211, 106.845);

		ArrayList<QuakeEntry> close = getClosest(list, jakarta, 3);
		for (int k = 0; k < close.size(); k++) {
			QuakeEntry entry = close.get(k);
			double distanceInMeters = jakarta.distanceTo(entry.getLocation());
			System.out.printf("%4.2f\t %s\n", distanceInMeters / 1000, entry);
		}
		System.out.println("number found: " + close.size());
	}

}
