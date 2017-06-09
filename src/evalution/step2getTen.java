package evalution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
import java.util.List;

//获取前十个彼此相似度最大的十个企业
public class step2getTen {
	/*
	//获取2923个公司的名称
	public List<String> getNamesNew() throws ClassNotFoundException, SQLException{
		step1getSim sgs = new step1getSim();
		List<String> l1 = sgs.SgetCompanyNames();
		return l1;
	}
	*/
	
	//获取每个公司最相似的前十个公司数据C,写入数据表result；
	public void getFirstTen(List<String> list) throws ClassNotFoundException, SQLException{
		Connection c1 = step1getSim.connectDatabase();
		List<String> l2 = new ArrayList<String>();
		List<String> l3 = new ArrayList<String>();
		List<Double> l4 = new ArrayList<Double>();
		//for(int i=0;i<list.size();i++){	
		//String s1 = "SELECT A,B,sim FROM newsim WHERE A="+'"'+list.get(i)+'"'+" ORDER BY sim DESC LIMIT 11";
			String s1 = "SELECT A,B,sim FROM newsim WHERE A=? ORDER BY sim DESC LIMIT 21";
		    PreparedStatement ps1 = c1.prepareStatement(s1);
		    for(int j=0;j<list.size();j++){
		    	ps1.setString(1, list.get(j));
		    	ResultSet rs = ps1.executeQuery();
				while(rs.next()){
					l2.add(rs.getString("A"));
					l3.add(rs.getString("B"));
					l4.add(rs.getDouble("sim"));
				
				}
		    	
		    }
		//c1.setAutoCommit(false);
		//int count = 0;
		//Statement s = c1.createStatement();
		
		
		System.out.println(l2.toString());
	/*
		for(int j=0;j<list.size();j++){
			ps1.setString(1, list.get(j));
			
			ps1.addBatch(); 
			count++;
			if(count%10==0){
				ps1.executeBatch();
		    	c1.commit();
		    	ps1.clearBatch();
		    	
			}
			
			ps1.execute();
		}
	*/
	}

}
