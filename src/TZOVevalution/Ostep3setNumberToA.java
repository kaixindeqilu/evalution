package TZOVevalution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Ostep3setNumberToA {
	//获取以2014机构持股比例降序排列的各企业对应的档次值number2014
		public List<Integer> readNumber() throws ClassNotFoundException, SQLException{
				
			List<Integer> nld = new ArrayList<Integer>();
			Connection nct = Ostep1getSim.connectDatabase();
			Statement nsm = nct.createStatement();
			ResultSet rs = nsm.executeQuery(" SELECT number2015 FROM sheet5 WHERE  id<2924");
			while(rs.next()){
				nld.add(rs.getInt("number2015"));	
			}
			nct.close();
			return nld;
		}
			
	//将得到的档次值对应存入2014number表的A列
		public void setNumber(List<Integer> li,List<String> lss) throws ClassNotFoundException, SQLException{
			Connection nct1 = Ostep1getSim.connectDatabase();
			String str = "update tensim3 set 2015numberA=? where A=?";
			PreparedStatement nps = nct1.prepareStatement(str);
			for(int i=0;i<li.size();i++){
			    nps.setInt(1, li.get(i));
				    nps.setString(2, lss.get(i));
				    nps.execute();
			}
			
			nct1.close();
		}

}
