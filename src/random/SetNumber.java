package random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetNumber {
	String[] c = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
	
	public List<Double> getMaxNumber() throws ClassNotFoundException, SQLException{
		Connection con1 = design.connectDatabase();
		Statement sm = con1.createStatement();
		List<Double> list1 = new ArrayList<>();
		for(int i=0;i<15;i++){
		    ResultSet rs1 = sm.executeQuery("select "+c[i]+" from sheet1 order by "+c[i]+" desc limit 1");
	        while(rs1.next()){
	    	    list1.add(rs1.getDouble(c[i]));  
	        }
		}
	   
	    con1.close();
	    return list1;   
	}
	

	public List<Double> getMinNumber() throws ClassNotFoundException, SQLException{
		Connection con2 = design.connectDatabase();
		Statement sm = con2.createStatement();
		List<Double> list2 = new ArrayList<>();
		for(int i=0;i<15;i++){
			ResultSet rs2 = sm.executeQuery("select "+c[i]+" from sheet1 order by "+c[i]+" asc limit 1");	
			while(rs2.next()){
        	    list2.add(rs2.getDouble(c[i])); 
		    }
        }
		con2.close();
		return list2;
	}
	
	
	public List<List<Double>> split(List<Double> ld){
		List<Double> ld1 = new ArrayList();
		List<List<Double>> ld2 = new ArrayList();
		for(int i = 0;i<15;i++){
			double a = ld.get(i)/20;
			double b = a;
			for(int j=0;j<20;j++){
				ld1.add(b);
				b+=a;
			}
			ld2.add(ld1);
			ld1 = new ArrayList<>();
		}
		return ld2;
	}
	/*
	public void update(List<List<Double>> lld) throws ClassNotFoundException, SQLException{
		Connection con3 = design.connectDatabase();
		String s = "update sheet20 set number13=? where N>=? and N<?";
		PreparedStatement ps = con3.prepareStatement(s);
		for(int i=19;i>0;i--){
			ps.setInt(1, i);
			ps.setDouble(2, );
		}
		
	}
	*/
	

	/*
	public List<Double> getMinAndMax(List<List<Double>> lld){
		//List<List<Double>> listB = new ArrayList<>();
		List<Double> list1 = new ArrayList<>();
		//List<Double> list2 = new ArrayList<>();
		double min = 0;
		double max = 0;
		for(int i = 0;i<15;i++){
			for(int j=1;j<2923;j++){
				min = lld.get(i).get(0);
				max = lld.get(i).get(0);
				if(min>lld.get(i).get(j)){
					min = lld.get(i).get(j);
				}
				if(max<lld.get(i).get(j)){
					max = lld.get(i).get(j);
				}	
			}
			list1.add(min);
			list1.add(max);
		}
		return list1;
	}
	*/
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		SetNumber sn = new SetNumber();
		List<Double> lista = sn.getMaxNumber();
		List<Double> listb = sn.getMinNumber();
		List<List<Double>> listc = sn.split(lista);
		//List<Double> listb = sn.getMinAndMax(lista);
		System.out.println(lista.toString());
		System.out.println(listb.toString());
		for(int m=0;m<listc.size();m++){
			System.out.println(listc.get(m).toString());
		}
		
		
	}

}
