package TZOTevalution;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

	class MapValueComparator implements Comparator<Map.Entry<Integer, Double>> {

		    public int compare(Entry<Integer, Double> me1, Entry<Integer, Double> me2) {

		        return me2.getValue().compareTo(me1.getValue());//???
		    }
	}

