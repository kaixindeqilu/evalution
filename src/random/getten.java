package random;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class getten {
	public void dropd() throws ClassNotFoundException, SQLException{
		String s = "delete from abcd ";
		Connection coo = design.connectDatabase();
		Statement stmt=coo.createStatement();//创建Statement对象
		stmt.executeUpdate(s);
		coo.close();
	}
	
	public List<companys> mostTenSim() throws ClassNotFoundException, SQLException{
		List<companys> comlist = new ArrayList<companys>();
		companys com = new companys();
		Connection cct = design.connectDatabase();
		String s = "select A,B,sim from abc where id>? and id<=? order by sim desc limit 11";
		PreparedStatement pst = cct.prepareStatement(s);
		for(int i=0,j=2923;i<8541007&&j<=8543929;i+=2923,j+=2923){
		    pst.setInt(1, i);
		    pst.setInt(2, j);
		    ResultSet rst = pst.executeQuery();
		    while(rst.next()){
			    com.setcA(rst.getString("A"));
			    com.setcB(rst.getString("B"));
			    com.setCsim(rst.getDouble("sim"));
			    comlist.add(com);
			    com = new companys();
				
		    }
		}
		cct.close();
		return comlist;
	}
	
	
	public void setsim(List<companys> lcc) throws ClassNotFoundException, SQLException{
		Connection cco = design.connectDatabase();
		cco.setAutoCommit(false);
		String ss = "insert into abcd (A,B,sim) values (?,?,?)";
		PreparedStatement pstt = cco.prepareStatement(ss);
		int count = 0;
		for(int i=0;i<lcc.size();i++){
			pstt.setString(1, lcc.get(i).getcA());
			pstt.setString(2, lcc.get(i).getcB());
			pstt.setDouble(3, lcc.get(i).getCsim());
			pstt.addBatch();
			count++;
			if(count%1000==0){
				pstt.executeBatch();
				cco.commit();
				pstt.clearBatch();
			}
		}
		pstt.executeBatch();
		cco.commit();
		pstt.clearBatch();
		cco.close();		
    }
	
	//删除相同的企业
	public void dleteSame () throws ClassNotFoundException, SQLException{
		Connection cct = design.connectDatabase();
		String s = "delete from abc where A=B";
		Statement sm = cct.createStatement();
		sm.executeUpdate(s);
		cct.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		getten gt = new getten();
		gt.dropd();
		List<companys> com = gt.mostTenSim();
		gt.setsim(com);
		gt.dleteSame();
		
	}
	

}
