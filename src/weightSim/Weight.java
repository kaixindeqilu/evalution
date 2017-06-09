package weightSim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import random.design;

public class Weight {
	public static double countWeight(double a,double b,double x){
		
		return (a+b)*x;
	}
	
	public List<Double> getSim() throws ClassNotFoundException, SQLException{
		List<Double> list = new ArrayList();
		Connection con = design.connectDatabase();
		Statement sm = con.createStatement();
		ResultSet rs = sm.executeQuery("select sim from test");
		while(rs.next()){
			list.add(rs.getDouble("sim"));
		}
		return list;
	}
	
	public List<Double> countX(List<Double> ld){
		double x= 0;
		List<Double> list = new ArrayList();
		for(int i=0;i<ld.size();i+=2){
			for(int j=i;j<i+2;j++){
				x = x+ld.get(j);
			}
			list.add(x);
			x = 0;
		}
		return list;
	}
	
	public List<Double> allWeight(List<List<Double>> lld,List<Double> ld){
		List<Double> list = new ArrayList();
		//List<List<Double>> llist = new ArrayList();
		for(int i=0;i<2923;i++){
			for(int j=0;j<2923;j++){
				for(int t=0;t<ld.size();t++){
					double x = (lld.get(i).get(t)+lld.get(j).get(t))*ld.get(t);
					list.add(x);
				}
			
			}
			
		}
		
		return list;
	}
	public void setNumber() throws ClassNotFoundException, SQLException{
		Connection con =  design.connectDatabase(); 
		String s = "insert into weight(qiyeA,qiyeB,zhibiao) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(s);
		con.setAutoCommit(false);
		int count=0;
		for(int i=0;i<2923;i++){
			for(int j=0;j<2923;j++){
				for(int t=0;t<3;t++){
					ps.setInt(1,i);
					ps.setInt(2,j);
					ps.setInt(3,t);
					//ps.setDouble(4,ld.get(t));
					count++;
					ps.addBatch(); 
				}
				if(count%10000==0){
				    ps.executeBatch();
				    con.commit();
				    ps.clearBatch();	
				}
			}
		}
		ps.executeBatch();
		con.commit();
		ps.clearBatch();
		con.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Weight weight = new Weight();
		design des = new design();
		List<List<Double>> lld = des.addDataToLld();
		List<Double> list1 = weight.getSim();
		List<Double> list2 = weight.countX(list1);
		List<Double> list3 = weight.allWeight(lld, list2);
		System.out.println(list3.size());
		//weight.setNumber();
	}

}
