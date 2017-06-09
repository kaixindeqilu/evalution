package random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class partError {
	
	public List<List<Integer>> getRate() throws ClassNotFoundException, SQLException{
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList();
		//List<Double> list = new ArrayList<Double>();
		Connection con = design.connectDatabase();
		Statement sm = con.createStatement();
		ResultSet rs1 = sm.executeQuery(" SELECT substract FROM originp");
		while(rs1.next()){
			l1.add(rs1.getInt("substract"));
		
		}
		ResultSet rs2 = sm.executeQuery(" SELECT partlogv FROM averagejgcg");
		while(rs2.next()){
			l2.add(rs2.getInt("partlogv"));
		
		}
		System.out.println(l2.toString());
		int count1=0;
		int a=0;
		for(int i=0;i<l1.size();i+=10){
			for(int j=i;j<l1.size();j++){             //注！为什么循环条件为j<j+10是错误的，因为当j不断增加时，j+10也是不断增加的
			    a = a +l1.get(j);
			    count1++;
			    if(count1%10==0){
			    	break;
			    }
			}	
			l3.add(a);
			a=0;		
		}
		System.out.println(l3.toString());
		list.add(l2);
		list.add(l3);
		
		/*
		double b=0;
		for(int k=0;k<2923;k++){
			b = l3.get(k)/(l2.get(k)*10);
			System.out.print(b+" ");
			list.add(b);
			b=0;
		}
		System.out.println(list.toString());
		*/
		return list;
	}
	public void setrate(List<Integer> ld1,List<Integer> ld2) throws ClassNotFoundException, SQLException{
	    Connection con = design.connectDatabase();
	    String ss = "insert into originpRate(sumnumbera,sumnumberb) values(?,?)";
	    PreparedStatement ps = con.prepareStatement(ss);
	    for(int i=0;i<2923;i++){
	    	ps.setDouble(1, ld1.get(i)*10);
	    	ps.setDouble(2, ld2.get(i));
	    	ps.execute();

	    }
	    con.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		partError per = new partError();
		List<List<Integer>> list = per.getRate();
		per.setrate(list.get(0),list.get(1));
	}
	
	
}
