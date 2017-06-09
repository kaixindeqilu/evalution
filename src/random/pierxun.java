package random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class pierxun {
	public List<Double> average(List<List<Double>> lld){
		List<Double> ld = new ArrayList();
		double sum=0;
		double avg=0;
		for(int i=0;i<lld.size();i++){
			for(int j=0;j<lld.get(0).size();j++){
				sum += lld.get(i).get(j);

			}
			avg = sum/lld.get(0).size();
			ld.add(avg);
			sum = 0;	
		}
		return ld;
	}
	
	public void setAvg(List<Double> ld) throws ClassNotFoundException, SQLException{
		String s = "insert avglog values(?)";
		Connection con1 = design.connectDatabase(); 
		PreparedStatement ps = con1.prepareStatement(s);
		for(int i=0;i<ld.size();i++){
			ps.setDouble(1, ld.get(i));
			ps.execute();
		}
	}
	public double countSim(List<Double> ld1,List<Double> ld2,double d1,double d2){
		double sum = 0;
		double sum1 = 0;
	    double sum2 = 0;
	    double sim = 0;
		for(int i=0;i<ld1.size();i++){
			sum = sum + (ld1.get(i)-d1)*(ld2.get(i)-d2);
			sum1 = sum1 + Math.pow(ld1.get(i)-d1,2);
			sum2 = sum2 + Math.pow(ld2.get(i)-d2,2);	
		}
		sum1 = Math.sqrt(sum1);
		sum2 = Math.sqrt(sum2);
		
	    sim = (sum)/(sum1*sum2);
		
		return sim;
	}
	

	public List<Map> getSim(List<List<Double>> lld,List<Double> ld){
		 int count=0;
		 double sim = 0;
		 List<Map> lm = new ArrayList<>();
	 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
	     for(int m=0;m<lld.size();m++){
	 	    for(int t=0;t<lld.size();t++){
	    	    sim = countSim(lld.get(m),lld.get(t),ld.get(m),ld.get(t));
	    	    map.put(t,sim);
		 	    sim = 0;
	    	}
	 	    Map<Integer,Double> sortMap = sortMap(map);
		 	Map<Integer,Double> nmap = getten(sortMap);
			lm.add(nmap);	 	    
		 }	
	     
		 return lm;
	 }
	
	
	 public  static Map<Integer, Double> sortMap(Map<Integer, Double> oriMap) {
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
		    while (it.hasNext()&&a<6) {
		          int key = (int) it.next(); 
		          double value = (double) mp.get(key);
		          map.put(key, value); 
		          a++;
		        }  
		    //System.out.println(map.toString());
			return map;
	 }
	 
	 public static void main(String[] args) throws ClassNotFoundException, SQLException{
		 pierxun pi = new pierxun();
		 design des = new design();
		 List<List<Double>> lld1 = des.addDataToLld();
		 List<List<Double>> lld2 = des.transposition(lld1);
		 List<Double> ld = pi.average(lld2);
		 //pi.setAvg(ld);
		 List<Map> lm = pi.getSim(lld2, ld);
		 des.newLeadingSim(lm);
	 }
	                  
}
