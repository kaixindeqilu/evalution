package TZOFevalution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tstep2getTen {
	//�����ƶȱ�sim�л�ȡ������ҵ�������ƶ���ߵ�ǰ�ض�����ҵ�����ƶ�ֵ
	public List<Tcompany> getData() throws ClassNotFoundException, SQLException{
	    Connection cct = Tstep1rgetSim.connectDatabase();
	    Tcompany cm = new Tcompany();
		List<Tcompany> lc = new ArrayList<Tcompany>();
		String s = "select A,B,sim from newsim2 where id>? and id<=? order by sim desc limit 11";
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
			    cm = new Tcompany();
				
		    }
		}
		cct.close();
		return lc;
	}
		
	//��������ҵ��Ӧ���������ƶ���ߵ�ǰ�ض���������ҵ�����ƶ�д���result��
	public void setData(List<Tcompany> lcc) throws ClassNotFoundException, SQLException{
		Connection cctt = Tstep1rgetSim.connectDatabase();
		cctt.setAutoCommit(false);
		String ss = "insert into Tensim (A,B,sim) values (?,?,?)";
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