package random;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class oushi {
	
	public double CountSim(List<Double> ld1,List<Double> ld2){
		double sum = 0;
	    double sim = 0;
	    for(int n=0;n<ld1.size();n++){
	        sum = sum + Math.pow(ld1.get(n)-ld2.get(n), 2);		
	    }
	    sum =  Math.sqrt(sum);
	    sim = 1/(1+sum);
		return sim;	 	   
	}
	
	public List<Map> getSim(List<List<Double>> lld){
		 double sim = 0;
		 List<Map> lm = new ArrayList<>();
	 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
	     for(int m=0;m<lld.size();m++){
	 	    for(int t=0;t<lld.size();t++){
	    	    sim = CountSim(lld.get(m),lld.get(t));
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
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
		 oushi ou = new oushi();
		 design des = new design();
		 List<List<Double>> lld1 = des.addDataToLld();
		 List<List<Double>> lld2 = des.transposition(lld1);
		 List<Map> lm = ou.getSim(lld2);
		 //pi.setAvg(ld);
		 des.newLeadingSim(lm);
	 }
	 

}
