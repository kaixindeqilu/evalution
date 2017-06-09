package random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Average {
	public List<List<Double>> addDataToLld() throws SQLException, ClassNotFoundException{  
		Connection co1 = design.connectDatabase();
		Statement sm = co1.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM origin ");
		List<List<Double>> lld1 = new ArrayList<>();
		List<Double> list1 = new ArrayList<Double>();
	    while(rs.next()){
		    list1.add(rs.getDouble("A"));
	    	list1.add(rs.getDouble("B"));
		    list1.add(rs.getDouble("C"));

	    	lld1.add(list1);
            list1 = new ArrayList<Double>();  
	   	    
	    }
	    
	    co1.close();
	    return lld1;
	}
	
	public List<List<Double>> pastZero(List<List<Double>> lld){  
		List<List<Double>> lld2 = new ArrayList<>();
		List<Double> list2 = new ArrayList<Double>();
		for(int i=0;i<2923;i++){
			for(int j=0;j<3;j++){
				if(lld.get(i).get(j)!=0){
					list2.add(lld.get(i).get(j));
				}
			}
			lld2.add(list2);
			list2 = new ArrayList<>();
		}
		return lld2;
		
	}
	
	public List<Double> getAvg(List<List<Double>> lld){  
		List<Double> list3 = new ArrayList<Double>();
		
		for(int i=0;i<2923;i++){
			int x = lld.get(i).size();
			//System.out.println(x);
			double sum = 0;
			double val = 0;
			for(int j=0;j<x;j++){
				sum = sum + lld.get(i).get(j);	
			}
			if(x==0){
				list3.add(0.0);
				continue;
			}
			val = sum/x;
			list3.add(val);
		}
		return list3;
	}
	
	public List<Double> logAverage(List<Double> ld){
		List<Double> list4 = new ArrayList<Double>();
		for(int i=0;i<2923;i++){
			list4.add(Math.log(ld.get(i)+1));
		}
		
		return list4;	
	}
	
	
	public void setAverage(List<Double> ld1,List<Double> ld2) throws ClassNotFoundException, SQLException{
	    Connection co2 = design.connectDatabase();
	    String ss = "insert averageJGCG(value,logValue) values(?,?)";
	    PreparedStatement sps = co2.prepareStatement(ss);
	    for(int i=0;i<2923;i++){
	    	sps.setDouble(1, ld1.get(i));
	    	sps.setDouble(2, ld2.get(i));   
		    sps.execute();
	    }
	    co2.close();
	}

	public List<Double> countNumber() throws ClassNotFoundException, SQLException{
		Connection co3 = design.connectDatabase();
		Statement sm = co3.createStatement();
		List<Double> list5 = new ArrayList<>();
		ResultSet rs = sm.executeQuery("select max(logValue),min(logValue) from averageJGCG ");
		double a=0;
		double b=0;
		while(rs.next()){
		    a = (rs.getDouble("max(logValue)"));
            b = (rs.getDouble("min(logValue)"));
		}
		double sub = a-b;
		double val = sub/10;
		for(int i=0;i<11;i++){
			list5.add(b+val*(i));
		}
		co3.close();
		return list5;
		
	}
	
	public void setNumber(List<Double> ld){
		
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Average avg = new Average();
		List<List<Double>> avgList1 = avg.addDataToLld();
		List<List<Double>> avgList2 = avg.pastZero(avgList1);
		List<Double> avgList3 = avg.getAvg(avgList2);
		List<Double> avgList4 = avg.logAverage(avgList3);
		List<Double> avgList5 = avg.countNumber();
		//avg.setAverage(avgList3,avgList4);
		
		//System.out.println(avgList3.toString());
		System.out.println(avgList5.toString());
	}
	
	
}
