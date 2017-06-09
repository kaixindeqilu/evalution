package substract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class step3 {
	public List<scompany> getData() throws ClassNotFoundException, SQLException{
	    Connection cct = step1.connectDatabase();
	    scompany cm = new scompany();
		List<scompany> lc = new ArrayList<scompany>();
		String s = "select A,B,sim from speedsim where id>? and id<=? order by sim desc limit 11";
		PreparedStatement pst = cct.prepareStatement(s);
		for(int i=0,j=2923;i<8541007&&j<=8543930;i+=2923,j+=2923){
		    pst.setInt(1, i);
		    pst.setInt(2, j);
		    ResultSet rst = pst.executeQuery();
		    while(rst.next()){
			    cm.setcA(rst.getString("A"));
			    cm.setcB(rst.getString("B"));
			    cm.setCsim(rst.getDouble("sim"));
			    lc.add(cm);
			    cm = new scompany();
				
		    }
		}
		cct.close();
		return lc;
	}
	
	public void setData(List<scompany> lcc) throws ClassNotFoundException, SQLException{
		Connection cctt = step1.connectDatabase();
		cctt.setAutoCommit(false);
		String ss = "insert into tenspeedsim (A,B,sim) values (?,?,?)";
		PreparedStatement pstt = cctt.prepareStatement(ss);
		int count = 0;
		for(int i=0;i<lcc.size();i++){
			pstt.setString(1, lcc.get(i).getcA());
			pstt.setString(2, lcc.get(i).getcB());
			pstt.setDouble(3, lcc.get(i).getCsim());
			pstt.addBatch();
			count++;
			if(count%1000==0){
				pstt.executeBatch();
				cctt.commit();
				pstt.clearBatch();
			}
		}
		pstt.executeBatch();
		cctt.commit();
		pstt.clearBatch();
		cctt.close();		
    }

}
