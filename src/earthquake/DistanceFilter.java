package earthquake;

public class DistanceFilter implements Filter {

	private Location fromCity;
	private double maxDist;

	public DistanceFilter(Location city, double dist) {
		fromCity = city;
		maxDist = dist;
	}

	@Override
	public boolean satisfies(QuakeEntry qe) {
		if (qe.getLocation().distanceTo(fromCity) < maxDist)
			return true;

		return false;
	}

}
