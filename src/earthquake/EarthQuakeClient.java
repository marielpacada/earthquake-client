package earthquake;

import java.util.ArrayList;

public class EarthQuakeClient {
	public EarthQuakeClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Filters out quakes in array list with bigger magnitudes than given parameter
	 * 
	 * @param quakeData
	 * @param magMin
	 * @return
	 */
	public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
		ArrayList<QuakeEntry> retList = new ArrayList<QuakeEntry>();
		for (QuakeEntry qe : quakeData) {
			if (qe.getMagnitude() > magMin) {
				retList.add(qe);
			}
		}

		return retList;
	}

	public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {
		ArrayList<QuakeEntry> retList = new ArrayList<QuakeEntry>();
		for (QuakeEntry qe : quakeData) {
			double currDist = qe.getLocation().distanceTo(from);
			if (currDist / 1000 < distMax) { // currDist in meters, distMax in km 
				retList.add(qe);
			
			}
		}
		return retList;
	}

	public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for (QuakeEntry qe : list) {
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n", qe.getLocation().getLatitude(), qe.getLocation().getLongitude(),
					qe.getMagnitude(), qe.getInfo());
		}

	}

	public void getBigQuakes() {
		EarthQuakeParser parser = new EarthQuakeParser();
		// String source =
		// "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";

		String source = "/Users/marielpacada/eclipse-workspace/earthquake-client/data/nov20quakedatasmall.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");

		ArrayList<QuakeEntry> bigQuakes = this.filterByMagnitude(list, 5.0);
		for (QuakeEntry qe : bigQuakes) {
			System.out.println(qe.getInfo());
		}

	}

	public void closeToMe() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "/Users/marielpacada/eclipse-workspace/earthquake-client/data/nov20quakedatasmall.atom";
//		String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");

		// This location is Durham, NC
		// Location city = new Location(35.988, -78.907);

		// This location is Bridgeport, CA
		Location city = new Location(38.17, -118.82);

		ArrayList<QuakeEntry> closeQuakes = this.filterByDistanceFrom(list, 1000, city);
		for (QuakeEntry qe : closeQuakes) {
			double currDist = city.distanceTo(qe.getLocation());
			System.out.println(currDist + " " + qe.getInfo());
		}
		
		
		
	}

	public void createCSV() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "data/nov20quakedatasmall.atom";
		// String source =
		// "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		dumpCSV(list);
		System.out.println("# quakes read: " + list.size());
		for (QuakeEntry qe : list) {
			System.out.println(qe);
		}
	}

}
