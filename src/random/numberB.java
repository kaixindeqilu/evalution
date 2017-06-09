package random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class numberB {
	public List<Integer> getB() throws ClassNotFoundException, SQLException{
		Connection dct = design.connectDatabase();
		List<Integer> dls = new ArrayList<Integer>();
		Statement nsm = dct.createStatement();
		ResultSet rs = nsm.executeQuery(" SELECT B FROM abcd");
		while(rs.next()){
			dls.add(rs.getInt("B"));
		}
		dct.close();
		return dls;
	}
	
	/*
	public List<Integer> getID(List<String> dls) throws ClassNotFoundException, SQLException{
		Connection dct1 = design.connectDatabase();
		List<Integer> dli = new ArrayList<Integer>();
		Statement nsm = dct1.createStatement();
		for(int i=0;i<dls.size();i++){
		    ResultSet rs = nsm.executeQuery(" SELECT id FROM sheet2 WHERE name="+'"'+dls.get(i)+'"');
		    while(rs.next()){
		    	dli.add(rs.getInt("id"));
		    }
		}
		dct1.close();
		return dli;
	}
	*/
	
	public List<Integer> readNumberToo(List<Integer> lg) throws ClassNotFoundException, SQLException{
		Connection dct2 = design.connectDatabase();
		List<Integer> li = new ArrayList<Integer>();
		Statement nsm = dct2.createStatement();
		for(int j=0;j<lg.size();j++){
		    ResultSet rs = nsm.executeQuery(" SELECT number2013 FROM sheet10 WHERE id="+'"'+(lg.get(j)+1)+'"');
		    while(rs.next()){
		    	li.add(rs.getInt("number2013"));
		    }
		}
		dct2.close();
		return li;
	}
	
	public void setB(List<Integer> li,List<Integer> lis) throws ClassNotFoundException, SQLException{
		Connection dct3 = design.connectDatabase();				
		String str = "update abc set numberB=? where B=?";
		PreparedStatement dps = dct3.prepareStatement(str);
		for(int i=0;i<li.size();i++){					  
			dps.setInt(1, li.get(i));
		    dps.setInt(2, lis.get(i));
		    dps.execute();
		}
		dct3.close();
			
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		numberB nb = new numberB();
		List<Integer> l1 = nb.getB();
		//List<Integer> l2 = nb.getID(l1);
		List<Integer> l3 = nb.readNumberToo(l1);
		nb.setB(l3, l1);
	}
	

}
