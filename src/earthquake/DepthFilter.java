package earthquake;

public class DepthFilter implements Filter {

	private double minDepth;
	private double maxDepth;

	public DepthFilter(double min, double max) {
		minDepth = min;
		maxDepth = max;
	}

	@Override
	public boolean satisfies(QuakeEntry qe) {
		if (qe.getDepth() > minDepth && qe.getDepth() < maxDepth)
			return true;

		return false;
	}

}
