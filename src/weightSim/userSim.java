package weightSim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class userSim {
	//加权后的欧式距离计算相似度
	public double countSim(List<Double> ld1,List<Double> ld2,List<Double> ld12){
		double sim = 0;
		double distance = 0;
		for(int i=0;i<ld1.size();i++){
		    distance = distance + ld12.get(i)*Math.pow(ld1.get(1)-ld2.get(1), 2);	
		    
		}
		sim = 1/Math.sqrt(distance);
		return sim;
	}
	
	public List<Map> getSim(List<List<Double>> lld1,List<List<Double>> lld2){
		 double sim = 0;
		 List<Map> lm = new ArrayList<>();
	 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
	     for(int m=0;m<lld1.size();m++){
	 	    for(int t=0;t<lld1.size();t++){
	    	    sim = countSim(lld1.get(m),lld1.get(t),lld2.get(m));//
	    	    map.put(t,sim);
		 	    sim = 0;
	    	}
	 	    Map<Integer,Double> sortMap = sortMap(map);
		 	Map<Integer,Double> nmap = getten(sortMap);
			lm.add(nmap);	 	    
		 }		     
		 return lm;
	}
	
	 public static Map<Integer, Double> sortMap(Map<Integer, Double> oriMap) {
	        if (oriMap == null || oriMap.isEmpty()) {
	            return null;
	        }
	        Map<Integer, Double> sortedMap = new LinkedHashMap<Integer, Double>();
	        List<Map.Entry<Integer, Double>> entryList = new ArrayList<Map.Entry<Integer, Double>>(
	                oriMap.entrySet());
	        Collections.sort(entryList, new MapValueComparator());

	        Iterator<Map.Entry<Integer, Double>> iter = entryList.iterator();
	        Map.Entry<Integer, Double> tmpEntry = null;
	        while (iter.hasNext()) {
	            tmpEntry = iter.next();
	            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
	        }
	        return sortedMap;
	  }
	 
	
    public Map<Integer,Double> getten(Map<Integer,Double> mp){		
		Map<Integer,Double> map = new LinkedHashMap<Integer,Double>();
	    Set<Integer> set = mp.keySet();
		Iterator<Integer> it = set.iterator();
		int a=0;
	    while (it.hasNext()&&a<11) {
	          int key = (int) it.next(); 
	          double value = (double) mp.get(key);
	          map.put(key, value); 
	          a++;
	        }  
		return map;
	}

}
