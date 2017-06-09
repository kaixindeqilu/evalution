package weightSim;

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

public class projectSim {
	
	//≈∑ Ωæ‡¿Î
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
	
	//∆§∂˚—∑œµ ˝
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
		 	
			lm.add(sortMap);	 	    
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
	 
	 public void newLeadingSim(List<Map> lm) throws ClassNotFoundException, SQLException{
			Connection con =  design.connectDatabase(); 
			con.setAutoCommit(false);
			String insert = "INSERT test(A,B,sim) VALUES(?,?,?)";
			//String insert1 = "INSERT projectSimoushiA,B,sim) VALUES(?,?,?)";
			int count=0;
	    	int k=0;
			PreparedStatement ps = con.prepareStatement(insert);
			for(int j=0;j<lm.size();j++){
				Set<Integer> set = lm.get(j).keySet();
				Iterator<Integer> it = set.iterator();
				while(it.hasNext()){
					Integer key =  (Integer) it.next();
					double value = (double) lm.get(j).get(key);
				    ps.setInt(1,j+1 );
				    ps.setInt(2, key+1 );
				    ps.setDouble(3, value);
				   
				    k++;
				    count++;
				    ps.addBatch(); 
				}
				    
				if(count%1000==0){
				    ps.executeBatch();
				    con.commit();
				    ps.clearBatch();	
				}
					
			}
			//System.out.println(count);
			ps.executeBatch();
			con.commit();
			ps.clearBatch();
			con.close();
		}
	 public static void main(String[] args) throws ClassNotFoundException, SQLException{
		 projectSim Psim = new projectSim();
		 design des = new design();
		 List<List<Double>> lld1 = des.addDataToLld();
		 List<List<Double>> lld2 = des.transposition(lld1);
		 //System.out.println(lld2.get(1).toString());
		 List<Map> lm = Psim.getSim(lld2);
		 Psim.newLeadingSim(lm);
		 
	 }

}
