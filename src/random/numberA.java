package random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class numberA {
	public List<Integer> readNumber() throws ClassNotFoundException, SQLException{	
		List<Integer> ld = new ArrayList<Integer>();
		Connection nct = design.connectDatabase();
		Statement nsm = nct.createStatement();
		ResultSet rs = nsm.executeQuery(" SELECT number2013 FROM sheet10 WHERE  id<2924");
		while(rs.next()){
			ld.add(rs.getInt("number2013"));	
		}
		nct.close();
		return ld;
	}
	public void setNumber(List<Integer> li) throws ClassNotFoundException, SQLException{
		Connection nct1 = design.connectDatabase();
		String str = "update abc set numberA=? where A=?";
		PreparedStatement nps = nct1.prepareStatement(str);
		for(int i=0;i<li.size();i++){
		    nps.setInt(1, li.get(i));
		    nps.setInt(2, i);
		    nps.execute();
		}
		
		nct1.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		numberA na = new numberA();
		design ds = new design();
		List<Integer> inte = na.readNumber();
		//List<String> ls = ds.getName();
		na.setNumber(inte);
	}
	

}
