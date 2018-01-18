package cluster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import random.design;


public class step5 {
	//1--28个指标的权重
    //double[] weight = {0.100,0.205,0.020,0.020,0.022,0.078,0.117,0.185,0.039,0.042,0.046,0.389,0.107,0.071,0.292,0.286,0.155,0.080,0.128,0.063,0.307,0.607,0.098,0.019,0.019,0.018,0.018,0.087};
	//读取数据库
	public List<List<Double>> getDATA() throws ClassNotFoundException, SQLException{
		List<List<Double>> lld = new ArrayList<List<Double>>();
		List<Double> list = new ArrayList<Double>();
		Connection con = design.connectDatabase();
		Statement sm = con.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM rechigu" );
		while(rs.next()){
			list.add(rs.getDouble("A"));
			list.add(rs.getDouble("B"));
			list.add(rs.getDouble("C"));
			list.add(rs.getDouble("D"));
			list.add(rs.getDouble("E"));

			lld.add(list);
			list = new ArrayList<Double>();
		}
		con.close();
		return lld;
	}
	//余弦夹角测相似度
    public List<Map> yuxianCountSim(List<List<Double>> lldde){
		 List<Map> lm = new ArrayList<>();
	 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
		 double sum = 0;
		 double mSum = 0;
		 double tSum = 0;
	     double sim = 0;
	     for(int m=0;m<lldde.size();m++){
	 	    for(int t=0;t<lldde.size();t++){
//	 	    	if (t == m){
//	 	    		map.put(t,2.0);
//	 	    		continue;
//				}
	    	    for(int n=0;n<lldde.get(0).size();n++){
	    	    	//if (lldde.get(m).get(n)!=0&&lldde.get(t).get(n)!=0) {  //取共同指标计算
						sum += lldde.get(m).get(n) * lldde.get(t).get(n);
						mSum += Math.pow(lldde.get(m).get(n),2);
						tSum += Math.pow(lldde.get(t).get(n),2);
					//}
			    }
			    if (mSum==0||tSum==0){
	    	    	sim = 0;
				}else {
					sim = sum / (Math.sqrt(mSum) * Math.sqrt(tSum));
				}
			    map.put(t, sim);
		   	    sum = 0;
		   	    mSum = 0;
		   	    tSum = 0;
		    }
	 	   Map<Integer,Double> sortMap = sortMap(map);
	 	   Map<Integer,Double> nmap = getten(sortMap);
		   lm.add(nmap);
		   
	    }
	     //System.out.println(lldee.toString());  
		 return lm;
	}


	//改进的余弦相似度,实质上就是皮尔逊相关系数
	 public List<Map> NyuxianCountSim(List<List<Double>> lldde){
		 List<Double> list = new ArrayList();
		 double averager = 0;
		 for(int i=0;i<lldde.size();i++){
			 for(int j=0;j<lldde.get(0).size();j++){
				 averager = averager + lldde.get(i).get(j);
			 }
			 averager = averager/lldde.get(0).size();
			 list.add(averager);
			 averager = 0;
		 }		 
		 List<Map> lm = new ArrayList<>();
	 	 Map<Integer, Double> map = new HashMap<Integer, Double>();
		 double sum1=0;
		 double sum2=0;
		 double sum3=0;
	     double sim=0;
	  
	     for(int m=0;m<lldde.size();m++){
	 	    for(int t=0;t<lldde.size();t++){
//	 	    	if (m == t){
//	 	    		map.put(t,2.0);
//	 	    		continue;
//				}
	    	    for(int n=0;n<lldde.get(0).size();n++){
					//if (lldde.get(m).get(n)!=0&&lldde.get(t).get(n)!=0) {
						sum1 += (lldde.get(m).get(n) - list.get(m)) * (lldde.get(t).get(n) - list.get(t));
						sum2 += Math.pow(lldde.get(m).get(n) - list.get(m), 2);
						sum3 += Math.pow(lldde.get(t).get(n) - list.get(t), 2);
					//}
			    }

				if (sum2==0||sum3==0){
					sim = 0;
				}else {
					sim = sum1 / (Math.sqrt(sum2) * Math.sqrt(sum3));
				}
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

	//欧式距离
	public List<Map> oushiCountSim(List<List<Double>> lldde){
		int count=0;
		List<Map> lm = new ArrayList<>();
		Map<Integer, Double> map = new HashMap<>();
		double sum=0;
		double sim=0;
		for(int m=0;m<lldde.size();m++){
			for(int t=0;t<lldde.size();t++){
//				if (m == t){
//					map.put(t,2.0);
//					continue;
//				}
				for(int n=0;n<lldde.get(0).size();n++){
					//if (lldde.get(m).get(n)!=0&&lldde.get(t).get(n)!=0) {
					sum += Math.pow(lldde.get(m).get(n) - lldde.get(t).get(n), 2);
					//}
				}
				// Map<Integer, Double> map = new TreeMap<Integer, Double>();
				sum =  Math.sqrt(sum);
//				if (sum == 0){
//					sim = 0;
//				}else {
				sim = 1 / (1 + sum);
				//}
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
    	while (it.hasNext() && a < 11) {
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
		String insert = "INSERT part6 (A,B,sim) VALUES(?,?,?)";
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
    	step5 five = new step5();
    	step4 four = new step4();
    	List<List<Double>> list1 = four.getDATA();
		//System.out.print(list1.size());
    	//List<Map> yuxian = five.yuxianCountSim(list1);
		//List<Map> oushi = five.oushiCountSim(list1);
	    List<Map> pierxun = five.NyuxianCountSim(list1);
    	five.LeadingSim(pierxun);
		//five.LeadingSim(oushi);
		//five.LeadingSim(yuxian);
    }
}
