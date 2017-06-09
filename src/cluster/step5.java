package cluster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import random.design;

//余弦夹角测相似度
public class step5 {
	//1--28个指标的权重
	double[] weight = {0.100,0.205,0.020,0.020,0.022,0.078,0.117,0.185,0.039,0.042,0.046,0.389,0.107,0.071,0.292,0.286,0.155,0.080,0.128,0.063,0.307,0.607,0.098,0.019,0.019,0.018,0.018,0.087};
	
	/*
	public List<List<Double>> getPow() throws ClassNotFoundException, SQLException{
		List<List<Double>> lld = new ArrayList<List<Double>>();
		List<Double> list = new ArrayList<Double>();
		Connection con = design.connectDatabase();
		Statement sm = con.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM 2013_pow");
		while(rs.next()){
			list.add(rs.getDouble("A"));
		    list.add(rs.getDouble("D"));
		   	list.add(rs.getDouble("G"));
		   	list.add(rs.getDouble("J"));
		   	list.add(rs.getDouble("M"));
	    	list.add(rs.getDouble("P"));
	    	list.add(rs.getDouble("S"));
		   	list.add(rs.getDouble("V"));
		   	list.add(rs.getDouble("Y"));
	    	list.add(rs.getDouble("AB"));
	    	list.add(rs.getDouble("AE"));
		   	list.add(rs.getDouble("AH"));
		   	list.add(rs.getDouble("AK"));
		   	list.add(rs.getDouble("AN"));
		   	list.add(rs.getDouble("AQ"));
	    	list.add(rs.getDouble("AT"));
	    	list.add(rs.getDouble("AW"));
		   	list.add(rs.getDouble("AZ"));
		   	list.add(rs.getDouble("BC"));
	    	list.add(rs.getDouble("BF"));
		   	list.add(rs.getDouble("BI"));
	    	list.add(rs.getDouble("BL"));
		   	list.add(rs.getDouble("BO"));
		   	list.add(rs.getDouble("BR"));
		   	list.add(rs.getDouble("BW"));
		   	list.add(rs.getDouble("BZ"));
	    	list.add(rs.getDouble("CC"));
	    	list.add(rs.getDouble("CE"));
		    	
		   	lld.add(list);
		   	list = new ArrayList<Double>();
		 }
		return lld;
	}
	*/
	
	/*
	public List<Double> Mould(List<List<Double>> lld){
		List<Double> lista = new ArrayList();
		double mould = 0;
		for(int i=0;i<lld.size();i++){
			for(int j=0;j<lld.get(0).size();j++){
				mould += lld.get(i).get(j);
			}
			mould = Math.sqrt(mould);
			lista.add(mould);
			mould = 0;
		}
		return lista;
	}
	*/
	
	/*
	public List<List<Double>> newList(List<List<Double>> lld,List<Double> ld){
		List<Double> list1 = new ArrayList();
		List<List<Double>> list2 = new ArrayList();
		double val = 0;
		for(int i=0;i<2923;i++){
			for(int j=0;j<28;j++){
				val = lld.get(i).get(j)/ld.get(i);
				list1.add(val);
			}
			list2.add(list1);
			list1 = new ArrayList();
		}
		return list2;
	}
	*/
	/*
    public List<Map> yuxianCountSim(List<List<Double>> lldde,List<Double> ld){
		
		 List<Map> lldee = new ArrayList<>();
	 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
		 double sum=0;
	     double sim=0;
	  
	     for(int m=0;m<lldde.size();m++){
	 	    for(int t=0;t<lldde.size();t++){
	    	    for(int n=0;n<lldde.get(0).size();n++){
			        sum = sum + lldde.get(m).get(n)*lldde.get(t).get(n)*weight[n];		
			    }
	    	   // Map<Integer, Double> map = new TreeMap<Integer, Double>();
	    	    sim = sum/(ld.get(m)*ld.get(t));
			    map.put(t, sim);
		   	    sum=0;	  
		    }
	 	   Map<Integer,Double> sortMap = sortMap(map);
	 	   Map<Integer,Double> nmap = getten(sortMap);
		   lldee.add(nmap);
		   
	    }
	     //System.out.println(lldee.toString());  
		 return lldee;
	}
	*/
	
	//改进的余弦相似度,实质上就是皮尔逊相关系数
	 public List<Map> NyuxianCountSim(List<List<Double>> lldde){
		 List<Double> list = new ArrayList();
		 double averager = 0;
		 for(int i=0;i<lldde.size();i++){
			 for(int j=0;j<lldde.get(0).size();j++){
				 averager = averager + lldde.get(i).get(j);
			 }
			 averager = averager/28;
			 list.add(averager);
			 averager = 0;
		 }		 
		 List<Map> lm = new ArrayList<>();
	 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
		 double sum1=0;
		 double sum2=0;
		 double sum3=0;
	     double sim=0;
	  
	     for(int m=0;m<lldde.size();m++){
	 	    for(int t=0;t<lldde.size();t++){
	    	    for(int n=0;n<lldde.get(0).size();n++){
			        sum1 = sum1 + (lldde.get(m).get(n)-list.get(m))*(lldde.get(t).get(n)-list.get(t));
			        sum2 = sum2 + Math.pow(lldde.get(m).get(n)-list.get(m), 2);
			        sum3 = sum3 + Math.pow(lldde.get(t).get(n)-list.get(t), 2);
			    }
	    	   // Map<Integer, Double> map = new TreeMap<Integer, Double>();
	    	    sim = sum1/(Math.sqrt(sum2)*Math.sqrt(sum3));
			    map.put(t, sim);
		   	    sum1=0;
		   	    sum2=0;	
		   	    sum3=0;	
		    }
	 	   Map<Integer,Double> sortMap = sortMap(map);
	 	   Map<Integer,Double> nmap = getten(sortMap);
		   lm.add(nmap);
		   
	    }
	     //System.out.println(lldee.toString());  
		 return lm;
	}
	
    public  Map<Integer, Double> sortMap(Map<Integer, Double> oriMap) {
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


    //获取单个相似度最高的前十个企业相似度
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
    
    //导入相似度
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
    	step5 five = new step5();
    	List<List<Double>> list1 = four.getDATA();
    	//List<List<Double>> list3 = five.newList(list1, list2);
    	List<Map> list4 = five.NyuxianCountSim(list1);
    	five.LeadingSim(list4);
    	//List<Map> lm = five.newCountSim(list3);
    	//five.newLeadingSim(lm);
    }
}
