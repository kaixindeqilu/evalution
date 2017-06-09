package cluster;

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

import random.design;

//≈∑ Ωæ‡¿Î≤‚œ‡À∆∂»
public class step7 {
	double[] weight = {0.100,0.205,0.020,0.020,0.022,0.078,0.117,0.185,0.039,0.042,0.046,0.389,0.107,0.071,0.292,0.286,0.155,0.080,0.128,0.063,0.307,0.607,0.098,0.019,0.019,0.018,0.018,0.087};
	
	//≈∑ Ωæ‡¿Î
	public List<Map> oushiCountSim(List<List<Double>> lldde){
		int count=0;
		 List<Map> lm = new ArrayList<>();
	 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
		 double sum=0;
	     
	     double sim=0;
	     for(int m=0;m<lldde.size();m++){
	 	    for(int t=0;t<lldde.size();t++){
	    	    for(int n=0;n<lldde.get(0).size();n++){
			        sum = sum + Math.pow(lldde.get(m).get(n)-lldde.get(t).get(n), 2)*(1/weight[n]);		
			    }
	    	   // Map<Integer, Double> map = new TreeMap<Integer, Double>();
			    sum =  Math.sqrt(sum);
			    sim = 1/(1+sum);
			    map.put(t, sim);
		   	    sum=0;	  
		    }
	 	   Map<Integer,Double> sortMap = sortMap(map);
	 	   Map<Integer,Double> nmap = getten(sortMap);
		   lm.add(nmap);
		   
	    }
	     //System.out.println(lldee.toString());  
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
		    Set set = mp.keySet();
			Iterator it = set.iterator();
			int a=0;
		    while (it.hasNext()&&a<11) {
		          int key = (int) it.next(); 
		          double value = (double) mp.get(key);
		          map.put(key, value); 
		          a++;
		        }  
		    //System.out.println(map.toString());
			return map;
		}
    
	 public void LeadingSim(List<Map> lm) throws ClassNotFoundException, SQLException{
			Connection co3 =  design.connectDatabase(); 
			String insert = "INSERT 2013sim(A,B,sim) VALUES(?,?,?)";
			//List<String> ss = getName();
			int count=0;
	    	int k=0;
			co3.setAutoCommit(false);
			PreparedStatement ps = co3.prepareStatement(insert);
			for(int j=0;j<lm.size();j++){
				Set<Integer> set = lm.get(j).keySet();
				Iterator<Integer> it = set.iterator();
				while(it.hasNext()){
					Integer key =  (Integer) it.next();
					double value = (double) lm.get(j).get(key);
				    ps.setInt(1,j+1 );
				    ps.setInt(2, key+1 );
				    ps.setDouble(3, value);
//				    ps.setInt(4, li.get(j));
//				    ps.setInt(5, lg.get(k));
				   // k++;
				    count++;
				    ps.addBatch(); 
				}
				    
				if(count%10000==0){
				    ps.executeBatch();
				    co3.commit();
				    ps.clearBatch();	
				}
					
			}
			//System.out.println(count);
			ps.executeBatch();
			co3.commit();
			ps.clearBatch();
			co3.close();
		}
	 
	 public static void main(String[] args) throws ClassNotFoundException, SQLException{
		 step4 four = new step4();
		 step7 seven = new step7();
		 List<List<Double>> list1 = four.getDATA();
		 List<Map> list2 = seven.oushiCountSim(list1);
		 seven.LeadingSim(list2);
	 }

}
