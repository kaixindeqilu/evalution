package cluster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import random.design;;

public class step4 {
	public static List<List<Double>> getDATA() throws ClassNotFoundException, SQLException{
		List<List<Double>> lld = new ArrayList<List<Double>>();
		List<Double> list = new ArrayList<Double>();
		Connection con = design.connectDatabase();
		Statement sm = con.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM sheet20");
		while(rs.next()){
			list.add(rs.getDouble("A"));
		    list.add(rs.getDouble("D"));
		    list.add(rs.getDouble("G"));
		   	list.add(rs.getDouble("J"));
		   	list.add(rs.getDouble("M"));
	    	list.add(rs.getDouble("P"));
	    	list.add(rs.getDouble("S"));
		   	list.add(rs.getDouble("V"));
		   	list.add(rs.getDouble("Y"));
	    	list.add(rs.getDouble("AB"));
	    	list.add(rs.getDouble("AE"));
		   	list.add(rs.getDouble("AH"));
		   	list.add(rs.getDouble("AK"));
		   	list.add(rs.getDouble("AN"));
		   	list.add(rs.getDouble("AQ"));
	    	list.add(rs.getDouble("AT"));
	    	list.add(rs.getDouble("AW"));
		   	list.add(rs.getDouble("AZ"));
		   	list.add(rs.getDouble("BC"));
	    	list.add(rs.getDouble("BF"));
		   	list.add(rs.getDouble("BI"));
	    	list.add(rs.getDouble("BL"));
		   	list.add(rs.getDouble("BO"));
		   	list.add(rs.getDouble("BR"));
		   	list.add(rs.getDouble("BW"));
		   	list.add(rs.getDouble("BZ"));
	    	list.add(rs.getDouble("CC"));
	    	list.add(rs.getDouble("CE"));
		    	
		   	lld.add(list);
		   	list = new ArrayList<Double>();
		 }
		return lld;
	}
	
	
	public List<List<Double>> newList(List<List<Double>> lld){
		List<List<Double>> listb = new ArrayList();
		List<Double> listc = new ArrayList();
		for(int i=0;i<lld.size();i++){
			for(int j=0;j<lld.get(0).size();j++){
				listc.add(Math.pow(lld.get(i).get(j),2));
			}
			listb.add(listc);
			listc = new ArrayList();
		}
		return listb;
	}
	public  static List<List<Double>> transp(List<List<Double>> lld){
		List<List<Double>> lldd = new ArrayList<List<Double>>();
		List<Double> list = new ArrayList<Double>();
		for(int i=0;i<28;i++){
		    for(int j=0;j<2923;j++){
			    list.add(lld.get(j).get(i));
		    }
		    lldd.add(list);
		    list = new ArrayList<Double>();
		}
		return lldd;
	}
	
	/*
	//将lldd写入txt
	public void writeTxt(List<List<Double>> ldlist){
		 try {
			    BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\2013.txt"));
			    DecimalFormat df = new DecimalFormat("0.0000"); 
			    for (List<Double> arr : ldlist) {
			    	for(double d:arr){
			    		String s = df.format(d);
			    		bw.write(s);
			    		bw.write(" ");
			    	}
			    	bw.newLine();
			    	
			    }
			    bw.close();
			} catch (IOException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
	}
	*/
	
	/*
	//读取txt文件
	public List<ArrayList<Double>> readTxt(){
		List<ArrayList<Double>> lldd = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> list = new ArrayList<Double>();
		
	}
	*/
	
	public void leading(List<List<Double>> lld) throws ClassNotFoundException, SQLException{
		
		String s = "insert 2013_pow values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con =  design.connectDatabase(); 
		PreparedStatement ps = con.prepareStatement(s);
		//con.setAutoCommit(false);
		for(int i=0;i<2923;i++){
			ps.setDouble(1, lld.get(i).get(0));
			ps.setDouble(2, lld.get(i).get(1));
			ps.setDouble(3, lld.get(i).get(2));
			ps.setDouble(4, lld.get(i).get(3));
			ps.setDouble(5, lld.get(i).get(4));
			ps.setDouble(6, lld.get(i).get(5));
			ps.setDouble(7, lld.get(i).get(6));
			ps.setDouble(8, lld.get(i).get(7));
			ps.setDouble(9, lld.get(i).get(8));
			ps.setDouble(10, lld.get(i).get(9));
			ps.setDouble(11, lld.get(i).get(10));
			ps.setDouble(12, lld.get(i).get(11));
			ps.setDouble(13, lld.get(i).get(12));
			ps.setDouble(14, lld.get(i).get(13));
			ps.setDouble(15, lld.get(i).get(14));
			ps.setDouble(16, lld.get(i).get(15));
			ps.setDouble(17, lld.get(i).get(16));
			ps.setDouble(18, lld.get(i).get(17));
			ps.setDouble(19, lld.get(i).get(18));
			ps.setDouble(20, lld.get(i).get(19));
			ps.setDouble(21, lld.get(i).get(20));
			ps.setDouble(22, lld.get(i).get(21));
			ps.setDouble(23, lld.get(i).get(22));
			ps.setDouble(24, lld.get(i).get(23));
			ps.setDouble(25, lld.get(i).get(24));
			ps.setDouble(26, lld.get(i).get(25));
			ps.setDouble(27, lld.get(i).get(26));
			ps.setDouble(28, lld.get(i).get(27));
			
			ps.execute();
				
		}
//		ps.executeBatch();
//		con.commit();
//	    ps.clearBatch();
		con.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step4 four = new step4();
		List<List<Double>> list1 = four.getDATA();
		//List<List<Double>> list2 = s.transp(list1);
		
    	List<List<Double>> list4 = four.newList(list1);
    	
    	four.leading(list4);
		//s.writeTxt(list2);
		//System.out.println(list2.get(0).toString());
	}
	
}
