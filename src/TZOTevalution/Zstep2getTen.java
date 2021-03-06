package TZOTevalution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Zstep2getTen {
	//从相似度表sim中获取各个企业与其相似度最高的前特定个企业及相似度值
		public List<Zcompany> getData() throws ClassNotFoundException, SQLException{
		    Connection cct = Zstep1getSim.connectDatabase();
		    Zcompany cm = new Zcompany();
			List<Zcompany> lc = new ArrayList<Zcompany>();
			String s = "select A,B,sim from newsim3 where id>? and id<=? order by sim desc limit 11";
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
				    cm = new Zcompany();
					
			    }
			}
			cct.close();
			return lc;
		}
			
		//将各个企业对应的与其相似度最高的前特定个数的企业及相似度写入表result中
		public void setData(List<Zcompany> lcc) throws ClassNotFoundException, SQLException{
			Connection cctt = Zstep1getSim.connectDatabase();
			cctt.setAutoCommit(false);
			String ss = "insert into Tensim2 (A,B,sim) values (?,?,?)";
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
