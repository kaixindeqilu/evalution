package evalution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//设置result表中A列的值
public class step3setNumberToA {
	
	//获取分别以2013,2014,2015降序排列的各企业对应的档次值number，number1，number2
	public List<List<Integer>> readNumber() throws ClassNotFoundException, SQLException{
		List<List<Integer>>  nlist = new ArrayList<List<Integer>>();
		List<Integer> nld = new ArrayList<Integer>();
		Connection nct = step1getSim.connectDatabase();
		Statement nsm = nct.createStatement();
		ResultSet rs = nsm.executeQuery(" SELECT number,number1,number2 FROM sheet20 WHERE  id<2924");
		while(rs.next()){
			nld.add(rs.getInt("number"));
			nld.add(rs.getInt("number1"));
			nld.add(rs.getInt("number2"));
			nlist.add(nld);
			nld = new ArrayList<Integer>();
		}
		nct.close();
		return nlist;
	}
	
	//将得到的档次值对应存入result1表的A列
	public void setNumber(List<List<Integer>> llde,List<String> lss) throws ClassNotFoundException, SQLException{
		Connection nct1 = step1getSim.connectDatabase();
		String str = "update result1 set 2013A=?,2014A=?,2015A=? where A=?";
		PreparedStatement nps = nct1.prepareStatement(str);
		for(int i=0;i<llde.size();i++){
			    nps.setInt(1, llde.get(i).get(0));
			    nps.setInt(2, llde.get(i).get(1));
			    nps.setInt(3, llde.get(i).get(2));
			    nps.setString(4, lss.get(i));
			    nps.execute();
		}
		
		nct1.close();
	}

}
