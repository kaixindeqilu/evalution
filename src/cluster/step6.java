package cluster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import random.design;

//计算平均误差
public class step6 {
	public List<Integer> sumSub() throws SQLException, ClassNotFoundException{
		List<Integer> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		Connection con = design.connectDatabase();
		Statement esm = con.createStatement();
		ResultSet rs = esm.executeQuery(" SELECT sub FROM 2013sim ");
		while(rs.next()){
			list1.add(rs.getInt("sub"));
		}
		int count = 0;
		int val = 0;
		for(int i=0;i<list1.size();i++){
			val +=list1.get(i);
			count++;
			if(count%10==0){
				
				list2.add(val);
				val = 0;
			}
		}
		return list2;
	}
	
	public List<Double> countErr(List<Integer> listI) throws ClassNotFoundException, SQLException{
		List<Double> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		Connection con = design.connectDatabase();
		Statement esm = con.createStatement();
		ResultSet rs = esm.executeQuery(" SELECT partlogv FROM averagejgcg ");
		while(rs.next()){
			list2.add(rs.getInt("partlogv"));
		}
		double val = 0;
		for(int i=0;i<list2.size();i++){
			val = (double)listI.get(i)/(double)(list2.get(i)*10);
			list1.add(val);
		}
		return list1;
	}
	
	public double avgErr(List<Double> ld){
		double res = 0;
		for(int i=0;i<ld.size();i++){
			res += ld.get(i);
			
		}
		res = res/ld.size();
		return res;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step6 six = new step6();
		List<Integer> list1 = six.sumSub();
		List<Double> list2 = six.countErr(list1);
		double result = six.avgErr(list2);
		//测试结果输出
		System.out.println(list2.toString());
		System.out.println(result);
	}

}
