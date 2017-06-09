package evalution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//设置result表中B列的值
public class step4setNumberToB {
	/*
	//获得result1表中B列的值，即各个企业B的名称
	public List<String> getB() throws ClassNotFoundException, SQLException{
		Connection dct = step1getSim.connectDatabase();
		List<String> dls = new ArrayList<String>();
		Statement nsm = dct.createStatement();
		ResultSet rs = nsm.executeQuery(" SELECT B FROM result1 WHERE  id<32154");
		while(rs.next()){
			dls.add(rs.getString("B"));
		}
		dct.close();
		return dls;
	}
	
	//获得qiyeB对应的id值
	public List<Integer> getID(List<String> dls) throws ClassNotFoundException, SQLException{
		Connection dct1 = step1getSim.connectDatabase();
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
	
	//根据企业B的id值获得各企业对应的number，number1，number2值
	public List<List<Integer>> readNumberToo(List<Integer> lg) throws ClassNotFoundException, SQLException{
		Connection dct2 = step1getSim.connectDatabase();
		List<List<Integer>> lli = new ArrayList<List<Integer>>();
		List<Integer> li = new ArrayList<Integer>();
		Statement nsm = dct2.createStatement();
		for(int j=0;j<lg.size();j++){
		    ResultSet rs = nsm.executeQuery(" SELECT number,number1,number2 FROM sheet20 WHERE id="+'"'+lg.get(j)+'"');
		    while(rs.next()){
		    	li.add(rs.getInt("number"));
		    	li.add(rs.getInt("number1"));
		    	li.add(rs.getInt("number2"));
		    	lli.add(li);
		    	li = new ArrayList<Integer>();
		    }
		}
		dct2.close();
		return lli;
	}
	
	public void setB(List<List<Integer>> llii,List<String> lis) throws ClassNotFoundException, SQLException{
		Connection dct3 = step1getSim.connectDatabase();
		String str = "update result1 set 2013B=?,2014B=?,2015B=? where B=?";
		PreparedStatement dps = dct3.prepareStatement(str);
		for(int i=0;i<llii.size();i++){
			    dps.setInt(1, llii.get(i).get(0));
			    dps.setInt(2, llii.get(i).get(1));
			    dps.setInt(3, llii.get(i).get(2));
			    dps.setString(4, lis.get(i));
			    dps.execute();
		}
		dct3.close();
	*/	
	//用随机数填充企业B的档次值
	public void setB() throws ClassNotFoundException, SQLException{
		Connection dct3 = step1getSim.connectDatabase();
		String str = "update result1_copy set 2013B=?,2014B=?,2015B=? where id=? ";
		PreparedStatement dps = dct3.prepareStatement(str);
		Random rand = new Random();
		for(int i=1;i<29231;i++){
			    dps.setInt(1, rand.nextInt(20)+1);
			    dps.setInt(2, rand.nextInt(20)+1);
			    dps.setInt(3, rand.nextInt(20)+1);
			    dps.setInt(4, i);
			    dps.execute();
		}
		dct3.close();
	}
	
	

}
