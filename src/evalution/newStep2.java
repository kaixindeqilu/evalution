package evalution;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

public class newStep2 {
	
	//从相似度表sim中获取各个企业与其相似度最高的前特定个企业及相似度值
	public List<company> getData() throws ClassNotFoundException, SQLException{
		//List<company> lc = new ArrayList();
		Connection cct = step1getSim.connectDatabase();
		company cm = new company();
		List<company> lc = new ArrayList<company>();
		String s = "select A,B,sim from newsim where id>? and id<=? order by sim desc limit 21";
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
			cm = new company();
			
		}
		}
		cct.close();
		return lc;
	}
	
	//将各个企业对应的与其相似度最高的前特定个数的企业及相似度写入表result中
	public void setData(List<company> lcc) throws ClassNotFoundException, SQLException{
		Connection cctt = step1getSim.connectDatabase();
		cctt.setAutoCommit(false);
		String ss = "insert into result2 (A,B,sim) values (?,?,?)";
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
		/*
		for(company c:lc){
			System.out.println(c.getcA()+c.getcB());
			System.out.println(c.getCsim());
		}
		*/
		/*
		cct.setAutoCommit(false);
		int count=0;
		CallableStatement cas = cct.prepareCall("call sql2(?)");
		for(int i=0;i<200;i++){
		  
		  cas.setString(1, list.get(i));
		 
		  cas.addBatch();
		  count++;
		  if(count == 50){
			  cas.executeBatch();
			  cct.commit();
			  cas.clearBatch();
		  }
		  
		  
		}
		cas.executeBatch();
		cct.commit();
		cas.clearBatch();
		cct.close();
		*/
		
		
		
	}

}

