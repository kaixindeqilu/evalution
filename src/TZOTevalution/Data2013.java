package TZOTevalution;

import java.sql.Connection;
import java.sql.DriverManager;
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


public class Data2013 {
	private static final String forname = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/liulu?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	
		
	//step1:连接数据库
	public static Connection connectDatabase() throws ClassNotFoundException, SQLException{
					
		Class.forName(forname);
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return con;
	}
			
			
	//step2：获取数据库数据（表sheet10）
	public List<List<Double>> GetData() throws SQLException, ClassNotFoundException{  
		Connection co1 = Data2013.connectDatabase();
		List<Double> list = new ArrayList<Double>();
		List<List<Double>> lls = new ArrayList<>();
		Statement sm = co1.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM sheet10 WHERE id<2924");
				
	    while(rs.next()){
			//list.add(rs.getDouble("A"));
		    list.add(rs.getDouble("B"));
			list.add(rs.getDouble("C"));
			list.add(rs.getDouble("D"));
			list.add(rs.getDouble("E"));
			list.add(rs.getDouble("F"));
			list.add(rs.getDouble("G"));
		  	list.add(rs.getDouble("H"));
			list.add(rs.getDouble("I"));
			list.add(rs.getDouble("J"));
	    	list.add(rs.getDouble("K"));
	    	list.add(rs.getDouble("L"));
	    	list.add(rs.getDouble("M"));
	    	list.add(rs.getDouble("N"));
	    	list.add(rs.getDouble("O"));
	    	list.add(rs.getDouble("P"));
	    	list.add(rs.getDouble("Q"));
	    	list.add(rs.getDouble("R"));
	    	list.add(rs.getDouble("S"));
	    	list.add(rs.getDouble("T"));
	    	list.add(rs.getDouble("U"));
	    	list.add(rs.getDouble("V"));
	    	list.add(rs.getDouble("W"));
	    	list.add(rs.getDouble("X"));
	    	list.add(rs.getDouble("Y"));
	    	list.add(rs.getDouble("Z"));
	    	list.add(rs.getDouble("AA"));
	    	list.add(rs.getDouble("AB"));
	       
	    	lls.add(list);
			list = new ArrayList<Double>();
		}
			co1.close();
			return lls;
	}
	
	//step3:计算相似度
	public List<Map> newCountSim(List<List<Double>> lldde){
		 List<Map> lldee = new ArrayList<>();
	 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
		 double sum=0;
	     double sum1=0;
	     double sim=0;
	     for(int m=0;m<lldde.size();m++){
	 	    for(int t=0;t<lldde.size();t++){
	    	    for(int n=0;n<lldde.get(m).size();n++){
			        sum = sum + Math.pow(lldde.get(m).get(n)-lldde.get(t).get(n), 2);	
			    	
			    }
			    sum1 =  Math.sqrt(sum);
			    sim = 1/(1+sum1);
			    map.put(t, sim);
		   	    sum=0;	
    	    }
	 	   Map<Integer,Double> sortMap = sortMap(map);
	 	   Map<Integer,Double> nmap = getten(sortMap);
		   lldee.add(nmap);
		    
	    }
		 return lldee;
	}	 
		 //相关的方法：对map类型进行按值降序排序，获取排序后的map中前11个数据
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
		 
		 //step4：获取B，设置numberA,B
			public List<Integer> GetB(List<Map> lm){
				List<Integer> lger = new ArrayList<Integer>();
				for(int j=0;j<lm.size();j++){
					Set<Integer> set = lm.get(j).keySet();
					Iterator<Integer> it = set.iterator();
					while(it.hasNext()){
						Integer key =  (Integer) it.next();
						//double value = (double) lm.get(j).get(key);
						lger.add(key);
					}
				}
				return lger;
			}
			//获取企业B所对应的number2013
			public List<Integer> getBNumber2013(List<Integer> lg) throws ClassNotFoundException, SQLException{
				Connection dct2 = design.connectDatabase();
				List<Integer> li = new ArrayList<Integer>();
				Statement nsm = dct2.createStatement();
				for(int j=0;j<lg.size();j++){
				    ResultSet rs = nsm.executeQuery(" SELECT number2013 FROM sheet10 WHERE id="+'"'+(lg.get(j)+1)+'"');
				    while(rs.next()){
				    	li.add(rs.getInt("number2013"));
				    }
				}
				//dct2.close();
				return li;
			}
			//从sheet10读取number2013
			public List<Integer> readNumber2013() throws ClassNotFoundException, SQLException{
				List<Integer> lin = new ArrayList<Integer>();
				Connection nct = design.connectDatabase();
				Statement nsm = nct.createStatement();
				ResultSet rs = nsm.executeQuery(" SELECT number2013 FROM sheet10 WHERE  id<2924");
				while(rs.next()){
					lin.add(rs.getInt("number2013"));	
				}
				//nct.close();
				return lin;
				
			}
	
	//step:5:导入相似度；这里直接导入每个企业最相似的前11个相似度
public void newLeadingSim(List<Map> lm,List<Integer> li,List<Integer> lg) throws ClassNotFoundException, SQLException{
	Connection co3 =  design.connectDatabase(); 
	String insert = "INSERT bcd (A, B,sim,numberA,numberB) VALUES(?,?,?,?,?)";
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
		    ps.setInt(1,j );
		    ps.setInt(2, key );
		    ps.setDouble(3, value);
		    ps.setInt(4, li.get(j));
		    ps.setInt(5, lg.get(k));
		    k++;
		    count++;
		    ps.addBatch(); 
		}
		    
		    if(count%1000==0){
		    	ps.executeBatch();
		    	co3.commit();
		    	ps.clearBatch();	
		    }
			
	}
	//System.out.println(count);
	ps.executeBatch();
	co3.commit();
	ps.clearBatch();
	//co3.close();
}
//step6：删除相同的企业
public void DleteSame () throws ClassNotFoundException, SQLException{
	Connection cct = design.connectDatabase();
	String s = "delete from bcd where id=?";
	cct.setAutoCommit(false);
	int c=0;
	PreparedStatement ps = cct.prepareStatement(s);
	for(int i=1;i<32154;i+=11){
		ps.setInt(1, i);
		c++;
		ps.addBatch();
		if(c%100==0){
			ps.executeBatch();
	    	cct.commit();
	    	ps.clearBatch();
		}
	}
	ps.executeBatch();
	cct.commit();
	ps.clearBatch();
	//Statement sm = cct.createStatement();
	//sm.executeUpdate(s);
	cct.close();
}
public static void main(String[] args) throws ClassNotFoundException, SQLException{
	Data2013 data2013 = new Data2013();
	Zstep5countError counter = new Zstep5countError();
	Zstep6avgError avg = new Zstep6avgError();
	 List<List<Double>> l1 = data2013.GetData();
	 List<Map> l2 = data2013.newCountSim(l1);
	 List<Integer> l3 = data2013.readNumber2013();
	 List<Integer> l4 = data2013.GetB(l2);
	 List<Integer> l5 = data2013.getBNumber2013(l4);
	 data2013.newLeadingSim(l2, l3, l5);
	 data2013.DleteSame();
	 counter.countError();
	 List<Double> l6 =  counter.getProbility(l3, l5);
	 counter.setError(l6);
	 List<Double> l7 = avg.getwucha();
	 double x = avg.countAvg(l7);
	 avg.setAvg(x);
}
}

