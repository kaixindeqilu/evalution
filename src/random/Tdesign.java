package random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class Tdesign {
	private static final String forname = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/liulu?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	List<List<Double>> lld = new ArrayList<>();
	List<Double> list = new ArrayList<Double>();
	
	//List<Double> ld2 = new ArrayList<Double>();
	//List<Double> ld3 = new ArrayList<Double>();
	
	//连接数据库
	public static Connection connectDatabase() throws ClassNotFoundException, SQLException{
					
		Class.forName(forname);
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return con;
	}
	
	//创建表
	public void create() throws ClassNotFoundException, SQLException{
		Connection con = Tdesign.connectDatabase();
	    Statement stmt=con.createStatement();//创建Statement对象
		  
		//String s = "create table abc(A varchar(20),B varchar(20),sim double(16,4),id int unsigned auto_increment primary key)";
		String s1 = "create table sheetdd(A varchar(20),B varchar(20),sim double(16,4),numberA int,numberB int,id int unsigned auto_increment primary key)";
	    String s2 = "create table sheetee(name varchar(20),error double(16,4))";
		//stmt.executeUpdate(s);
		stmt.executeUpdate(s1);
		stmt.executeUpdate(s2);
		
		con.close();
	}
	
	//删除表
		public void drop() throws ClassNotFoundException, SQLException{
			//String s = "drop table abc ";
			String s1 = "drop table sheetdd";
			String s2 = "drop table sheetee";
			Connection co0 = Tdesign.connectDatabase();
			Statement stmt=co0.createStatement();//创建Statement对象
			//stmt.executeUpdate(s);
			stmt.executeUpdate(s1);
			stmt.executeUpdate(s2);
			co0.close();
		}
		
	
	//添加数据库数据到lld中:先获取数据库原始数据
	public List<List<Double>> addDataToLld() throws SQLException, ClassNotFoundException{  
		Connection co1 = Tdesign.connectDatabase();
		Statement sm = co1.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM sheet20 where ID < 2924");
		
		//每个list存储一条记录的A到CG的值，即lld的每个元素是一条完整的记录
	    while(rs.next()){
	    	//list.add(rs.getDouble("A"));
//    	    list.add(rs.getDouble("B"));
//	    	list.add(rs.getDouble("C"));
//	    	list.add(rs.getDouble("D"));
//	    	list.add(rs.getDouble("E"));
//	    	list.add(rs.getDouble("F"));
//	    	list.add(rs.getDouble("G"));
//	    	list.add(rs.getDouble("H"));
//	    	list.add(rs.getDouble("I"));
//	    	list.add(rs.getDouble("J"));
//	    	list.add(rs.getDouble("K"));
//	    	list.add(rs.getDouble("L"));
//	    	list.add(rs.getDouble("M"));
//	    	list.add(rs.getDouble("N"));
//	    	list.add(rs.getDouble("O"));
	    	list.add(rs.getDouble("P"));
	    	list.add(rs.getDouble("Q"));
	    	list.add(rs.getDouble("R"));
//	    	list.add(rs.getDouble("S"));
//	    	list.add(rs.getDouble("T"));
//	    	list.add(rs.getDouble("U"));
//	    	list.add(rs.getDouble("V"));
//	    	list.add(rs.getDouble("W"));
//	    	list.add(rs.getDouble("X"));
//	    	list.add(rs.getDouble("Y"));
//	    	list.add(rs.getDouble("Z"));
//	    	list.add(rs.getDouble("AA"));
//	    	list.add(rs.getDouble("AB"));
//	    	
//	    	
//	    	list.add(rs.getDouble("AC"));
//	    	list.add(rs.getDouble("AD"));
//	    	list.add(rs.getDouble("AE"));
//	    	list.add(rs.getDouble("AF"));
//	    	list.add(rs.getDouble("AG"));
//	    	list.add(rs.getDouble("AH"));
//	    	list.add(rs.getDouble("AI"));
//	    	list.add(rs.getDouble("AJ"));
//	    	list.add(rs.getDouble("AK"));
//	    	list.add(rs.getDouble("AL"));
//	    	list.add(rs.getDouble("AM"));
//	    	list.add(rs.getDouble("AN"));
//	    	list.add(rs.getDouble("AO"));
//	    	list.add(rs.getDouble("AP"));
//	    	list.add(rs.getDouble("AQ"));
//	    	list.add(rs.getDouble("AR"));
//	    	list.add(rs.getDouble("ASS"));
//	    	list.add(rs.getDouble("AT"));
//	    	list.add(rs.getDouble("AU"));
//	    	list.add(rs.getDouble("AV"));
//	    	list.add(rs.getDouble("AW"));
//	    	list.add(rs.getDouble("AX"));
//	    	list.add(rs.getDouble("AY"));
//	    	list.add(rs.getDouble("AZ"));
//	    	list.add(rs.getDouble("BA"));
//	    	list.add(rs.getDouble("BB"));
//	    	list.add(rs.getDouble("BC"));
//	    	list.add(rs.getDouble("BD"));
//	    	list.add(rs.getDouble("BE"));
//	    	list.add(rs.getDouble("BF"));
//	    	list.add(rs.getDouble("BG"));
//	    	list.add(rs.getDouble("BH"));
//	    	list.add(rs.getDouble("BI"));
//	    	list.add(rs.getDouble("BJ"));
//	    	list.add(rs.getDouble("BK"));
//	    	list.add(rs.getDouble("BL"));
//	    	list.add(rs.getDouble("BM"));
//	    	list.add(rs.getDouble("BN"));
//	    	list.add(rs.getDouble("BO"));
//	    	list.add(rs.getDouble("BP"));
////	    	list.add(rs.getDouble("BQ"));
//	    	list.add(rs.getDouble("BR"));
//	    	list.add(rs.getDouble("BS"));
//	    	list.add(rs.getDouble("BT"));
//	    	list.add(rs.getDouble("BU"));
//	    	list.add(rs.getDouble("BV"));
//	    	list.add(rs.getDouble("BW"));
//	    	list.add(rs.getDouble("BX"));
//	    	list.add(rs.getDouble("BYY"));
//	    	list.add(rs.getDouble("BZ"));
//	    	list.add(rs.getDouble("CA"));
//	    	list.add(rs.getDouble("CB"));
//	    	list.add(rs.getDouble("CC"));
//	    	list.add(rs.getDouble("CD"));
//	    	list.add(rs.getDouble("CE"));
//	    	list.add(rs.getDouble("CF"));
//	    	list.add(rs.getDouble("CG"));
//	    	
	    	
	    	lld.add(list);
            list = new ArrayList<Double>();  
	   	    
	    }
	    co1.close();
	    return lld;
	}
	
	
	//从sheet10读取number2013
	public List<Integer> readNumber2013() throws ClassNotFoundException, SQLException{
		List<Integer> lin = new ArrayList<Integer>();
		Connection nct = Tdesign.connectDatabase();
		Statement nsm = nct.createStatement();
		ResultSet rs = nsm.executeQuery(" SELECT number6 FROM sheet20 WHERE  id<2924");
		while(rs.next()){
			lin.add(rs.getInt("number6"));	
		}
		nct.close();
		return lin;
		
	}
	
	//获取企业B所对应的number2013
	public List<Integer> getBNumber2013(List<Integer> lg) throws ClassNotFoundException, SQLException{
		Connection dct2 = design.connectDatabase();
		List<Integer> li = new ArrayList<Integer>();
		Statement nsm = dct2.createStatement();
		for(int j=0;j<lg.size();j++){
		    ResultSet rs = nsm.executeQuery(" SELECT number6 FROM sheet20 WHERE id="+'"'+(lg.get(j)+1)+'"');
		    while(rs.next()){
		    	li.add(rs.getInt("number6"));
		    }
		}
		dct2.close();
		return li;
	}
	
	/*
	//获取企业B所对应的number2013
		public List<Integer> getBNumber2013(List<Integer> lg) throws ClassNotFoundException, SQLException{
			Connection dct2 = design.connectDatabase();
			List<Integer> li = new ArrayList<Integer>();
			PreparedStatement ps = dct2.prepareStatement(" SELECT number2013 FROM sheet10 WHERE id=?");
			
			for(int i=0;i<lg.size();i++){
				ps.setInt(1, lg.get(i));
			}
			ResultSet set = ps.executeQuery();
			while(set.next()){
				li.add(set.getInt("number2013"));
			}
			dct2.close();
			return li;
		}
	*/
	
	/*
	//lldo中的元素是一条记录，现在将每条记录中的所有的A值到CG值变成lldd中的元素，即lldd中存储所有记录中的A值，B值，。。。，CG值，即lldd的长度为85
	public List<List<Double>> transposition(List<List<Double>> lldo){
		List<List<Double>> lldd = new ArrayList<>();
		List<Double> ld = new ArrayList<Double>();
		for(int i=0;i<59;i++){
		    for(int j=0;j<2923;j++){
			    ld.add(lldo.get(j).get(i));
		    }
		    lldd.add(ld);
		
		    ld = new ArrayList<Double>();
		}
		
		return lldd;
	}
	*/
	/*
    //随机选择lldd的中元素，添加到新列表llde中；	
	public List<List<Double>> random(List<List<Double>> lldu){
	    //int a = (int)(Math.random()*10);
	    List<List<Double>> llde = new ArrayList<>();
		//List<Double> lde = new ArrayList();
		for(int i=0;i<30;i++){
			int a = (int)(Math.random()*85);
			System.out.print(a+"..."+'\n');
		    llde.add(lldu.get(a));//!!!待优化：去除列表中相同的元素，（1）解决当a的随机值有相同值值时，如何不重复添加；（2）如果重复添加了。如何去除重复的元素
			
		}
		return llde;
	}
	*/
	
	//从2013年28组数据中选择3组作为测试数据，总有26*27*28/6=3276种选择
	public void choose(List<List<Double>> ld,List<String> ls ) throws ClassNotFoundException, SQLException{
		//List<String> ls = getName();
		error er = new error();
		avg ag = new avg();
		int c = 0;
		List<Double> ldd = new ArrayList();
					drop();
//					List<List<Double>> le = new ArrayList<List<Double>>();
//				    le.add(ld.get(0));
//					le.add(ld.get(2));
//					le.add(ld.get(4));
					//System.out.println(le.toString());
					//System.out.println(le.size());
					//List<List<Double>> l0 = reTransposition(le);
					create();
		            //drop();
		           
					List<Map> l1 = newCountSim(ld);
     				List<Integer> l2 = readNumber2013();
     				List<Integer> l3 = GetB(l1);
     				List<Integer> l4 = getBNumber2013(l3);
					newLeadingSim(l1,l2,l4);
					DleteSame(); 
					List<Integer> l6 = er.countError();
					//List<Double> l7 = er.getProbility(l6, l2);
					//System.out.println(l7.toString());
					//er.setError(l7, ls);
					List<Double> l8 = ag.getwucha();
					Double x = ag.countAvg(l8); 
					ag.setAvg(x);
					//drop();

	}
	
	//再次转置，将lldu中的元素以记录的形式存储到新列表lldl中
	public List<List<Double>> reTransposition(List<List<Double>> lldu){
		 List<List<Double>> lldl = new ArrayList<>();
		 List<Double> le = new ArrayList<>();
		
		 for(int i=0;i<2923;i++){
			    for(int j=0;j<3;j++){
				    le.add(lldu.get(j).get(i));
				    //System.out.println(le.toString());
			    }
			    lldl.add(le);
			    le = new ArrayList<Double>();
		}
		
		 return lldl;
	}
	
	//对map进行按值排序
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
	
	//计算相似度
		//public List<List<Double>> countSim(List<List<Double>> lldde){
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
		    	   // Map<Integer, Double> map = new TreeMap<Integer, Double>();
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
	
		//获取B
		public List<Integer> GetB(List<Map> lm){
			List<Integer> lger = new ArrayList<Integer>();
			for(int j=0;j<lm.size();j++){
				Set<Integer> set = lm.get(j).keySet();
				Iterator<Integer> it = set.iterator();
				while(it.hasNext()){
					Integer key =  (Integer) it.next();
					lger.add(key);
				}
			}
			return lger;
		}
		/*
	//计算相似度
	//public List<List<Double>> countSim(List<List<Double>> lldde){
	public List<Map> countSim(List<List<Double>> lldde){
		 List<Map> lldee = new ArrayList<>();
		// List<Double> lle = new ArrayList<>();
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
		   	    //lle.add(sim); 
			    //System.out.println(sim);
			    map.put(t, sim);
		   	    sum=0;	
		    }
		    lldee.add(map);
		    //System.out.println(map.toString());
		    map = new TreeMap<Integer,Double>();
	    }
	     //System.out.println(lldee.get(0).toString()); 
		 return lldee;
	}
	*/
	
	 
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
	
	/*
	//获取索引
	public List<Integer> getIndex(List<Double> lee,List<List<Double>> ldd){
		//List<List<Integer>> lld = new ArrayList();
		List<Integer> li = new ArrayList<Integer>();
		for(int i=0,k=0;i<ldd.size()&&k<lee.size();i++,k+=11){
			for(int j=k;j<j+11&&j<lee.size();j++){
			   int a = ldd.get(i).indexOf(lee.get(j));
			   li.add(a);
			}
		    //lld.add(li);
		    //li = new ArrayList();
	    }
		return li;
	}
	*/
	/*
	//根据索引获取名字
	public List<String> getname(List<Integer> lg) throws ClassNotFoundException, SQLException{
		Connection co2 =  design.connectDatabase(); 
		List<String> ls = new ArrayList<String>();
		String ss = "select name from sheet2 wnere id=?";
		PreparedStatement ps = co2.prepareStatement(ss);
		for(int i=0;i<lg.size();i++){
			ps.setInt(1, lg.get(i)+1);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()){
			ls.add(rs.getString("name"));
		    }
		}
		return ls;
	}
	*/
	//获取公司的名称
	public List<String> getName() throws ClassNotFoundException, SQLException{
		List<String> lss = new ArrayList<>();
		Connection co2 =  Tdesign.connectDatabase(); 
		Statement sm = co2.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM sheet2 WHERE id<2924");
        //先获取数据库的原始数据
	    while(rs.next()){
	    	lss.add(rs.getString("name"));
	    }
	    co2.close();
	    
		return lss;
	}
	
	
	/*
	//导入相似度
	public void leadingSim(List<Map> lm) throws ClassNotFoundException, SQLException{
		Connection co3 =  design.connectDatabase(); 
		String insert = "INSERT abc (A, B,sim) VALUES(?,?,?)";
		//List<String> ss = getName();
		int count=0;
		co3.setAutoCommit(false);
		PreparedStatement ps = co3.prepareStatement(insert);
		for(int j=0;j<lm.size();j++){
			for(int i=0;i<11;i++){
			Set set = lm.get(j).keySet();
			Iterator it = set.iterator();
			int key = (int) it.next();
			double value = (double) lm.get(j).get(key);
		    ps.setInt(1,j );
		    ps.setInt(2, key );
		    ps.setDouble(3, value);
		    count++;
		    ps.addBatch(); 
			    //ps.execute();
			    
			    if(count%1000==0){
			    	ps.executeBatch();
			    	co3.commit();
			    	ps.clearBatch();	
			    }
			}
				
		}
		//System.out.println(count);
		ps.executeBatch();
		co3.commit();
		ps.clearBatch();
		co3.close();
	}
	*/
	
	//导入相似度
		public void newLeadingSim(List<Map> lm,List<Integer> li,List<Integer> lg) throws ClassNotFoundException, SQLException{
			Connection co3 =  Tdesign.connectDatabase(); 
			String insert = "INSERT sheetdd (A, B,sim,numberA,numberB) VALUES(?,?,?,?,?)";
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
		//删除相同的企业
		public void DleteSame () throws ClassNotFoundException, SQLException{
			Connection cct = Tdesign.connectDatabase();
			String s = "delete from sheetdd where id=?";
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
			cct.close();
		}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Tdesign ds = new Tdesign();
		List<List<Double>> lld1 = ds.addDataToLld();
		//List<List<Double>> lld2 = ds.transposition(lld1);
		List<String> ss =ds.getName(); 
		ds.choose(lld1,ss);
		
	}
	

}
