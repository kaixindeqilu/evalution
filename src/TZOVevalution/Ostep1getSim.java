package TZOVevalution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Ostep1getSim {
	private static final String forname = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/liulu?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
		
	//连接数据库
	public static Connection connectDatabase() throws ClassNotFoundException, SQLException{
					
		Class.forName(forname);
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return con;
	}
			
			
	//添加数据库数据到list中:先获取数据库原始数据
	public List<List<Double>> SaddDataToList() throws SQLException, ClassNotFoundException{  
		Connection co1 = Ostep1getSim.connectDatabase();
		List<Double> list = new ArrayList<Double>();
		List<List<Double>> lls = new ArrayList<>();
		Statement sm = co1.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM sheet5 WHERE id<2924");
				
	    while(rs.next()){
			list.add(rs.getDouble("A"));
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
	    	list.add(rs.getDouble("AC"));
	    	lls.add(list);
			list = new ArrayList<Double>();
		}
			co1.close();
			return lls;
	}
			
	//获取所有公司的名字
	public List<String> SgetCompanyNames() throws ClassNotFoundException, SQLException{
		List<String> list = new ArrayList<String>();
		Connection co2 =  Ostep1getSim.connectDatabase(); 
		Statement sm = co2.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM sheet2 WHERE id<2924");
		while(rs.next()){
	    	list.add(rs.getString("name"));
	    }
	    co2.close();
	    return list;
	}
			
	/***处理数据，先计算两两之间的距离，这里计算欧几里得距离，公式为：d(x,y)=sqrt(sum((xi-yi)^2))，将距离值存储在List<List<Double> lld1里；
	              再计算两两用户之间的相似度，这里采用公式：sim(x,y)=1/(1+d(x,y))，将相似度值存储在List<Double>里                     
     ***/
	public List<List<Double>> SactionData(List<List<Double>> lldd){
	    List<List<Double>> lld = new ArrayList<>();
	    List<Double> ld1 = new ArrayList<Double>();
	    double sum=0;
	    double sum1=0;
	    double sim=0;
	    for(int m=0;m<lldd.size();m++){
		    for(int t=0;t<lldd.size();t++){
		        for(int n=0;n<lldd.get(m).size();n++){
			   	    sum = sum + Math.pow(lldd.get(m).get(n)-lldd.get(t).get(n), 2);	
			    	
			    }
		        sum1 =  Math.sqrt(sum);
			    sim = 1/(1+sum1);
		   	    ld1.add(sim);  
		   	    sum=0;	
			}
		    lld.add(ld1);
		    ld1 = new ArrayList<Double>();
		}
	   return lld;
	}
	    
	    
	    
	public void SsetDataToDB(List<String> ls,List<List<Double>> ld) throws ClassNotFoundException, SQLException{
		Connection co3 =  Ostep1getSim.connectDatabase(); 
		String insert = "INSERT newsim5 (A, B,sim) VALUES(?,?,?)";
		int count=0;
		co3.setAutoCommit(false);
		PreparedStatement ps = co3.prepareStatement(insert);
		for(int i=0;i<ls.size();i++){
			for(int j=0;j<ls.size();j++){
			    ps.setString(1, ls.get(i));
			    ps.setString(2, ls.get(j));
			    ps.setDouble(3, ld.get(i).get(j));
			    count++;
			    ps.addBatch(); 
			    //ps.execute();
			    
			    if(count%100000==0){
			    	ps.executeBatch();
			    	co3.commit();
			    	ps.clearBatch();
				    	    	
	            }    
		    }	
		}
			
		ps.executeBatch();
		co3.commit();
		ps.clearBatch();
		co3.close();
			
	}
		

}
