package cluster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import random.design;

//参考融合奇异性和扩散过程的协同过滤模型
public class step8 {
	//获取共同评分项目
	public List<List<Integer>> getCommon() throws ClassNotFoundException, SQLException{
		String[] arr = {"A","D","P","S","V","Y","AB","AE","AH","AK","AN","AQ","AT","AW","AZ","BC","BF","BI","BL","BO","CE"};
		List<List<Integer>> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		
		Connection con =  design.connectDatabase(); 
		Statement sm = con.createStatement();
        for(int i = 0;i<arr.length;i++){
        	String s = "select id from log2013 where " +arr[i]+ " !=0";//!!!注意！！！变量前后都要有空格
        	ResultSet rs = sm.executeQuery(s);
        	while(rs.next()){
        		list2.add(rs.getInt("id"));
        		
        	}
        	list1.add(list2);
        	list2 = new ArrayList();
        }
        System.out.println(list1.size());
		return list1;
	}
	
	public void setD(List<Integer> li) throws ClassNotFoundException, SQLException{
		String s = "update step8 set A = ?";
		Connection con =  design.connectDatabase(); 
		PreparedStatement ps = con.prepareStatement(s);
		for(int i = 0;i < li.size();i++){
			ps.setInt(1, li.get(i));
			ps.execute();
		}
		
		con.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step8 eight = new step8();
		List<List<Integer>> list = eight.getCommon();
		System.out.println(list.get(0).toString()); 
		eight.setD(list.get(0));
	}

}
