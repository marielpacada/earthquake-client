package earthquake;

import java.util.ArrayList;

public class LargestQuakes {

	public void findLargestQuakes() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "/Users/marielpacada/eclipse-workspace/earthquake-client/data/nov20quakedatasmall.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");
		
		System.out.println(this.getLargestQuakes(list, 5)); 

	}
	
	public int getIndexOfLargest(ArrayList<QuakeEntry> quakeData) { 
		int targetIndex = 0;
		double largestMag = 0; 
		
		for (int i = 0; i < quakeData.size(); i++) { 
			QuakeEntry currQE = quakeData.get(i); 
			double currMag = currQE.getMagnitude();
			if (currMag > largestMag) { 
				largestMag = currMag; 
				targetIndex = i;
			}
		}
		return targetIndex;
	}
	
	public ArrayList<QuakeEntry> getLargestQuakes(ArrayList<QuakeEntry> quakeData, int howMany) { 
		ArrayList<QuakeEntry> retList = new ArrayList<QuakeEntry>(); 
		ArrayList<QuakeEntry> copyData = quakeData;
		
		for (int i = 0; i < howMany; i++) { 
			int index = this.getIndexOfLargest(copyData);
			retList.add(copyData.get(index)); 
			copyData.remove(index); 
		}
		return retList;
	}
	
	
	

}
