package TZOFevalution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Tstep3setNumberToA {
	//��ȡ��2014�����ֹɱ����������еĸ���ҵ��Ӧ�ĵ���ֵnumber2014
		public List<Integer> readNumber() throws ClassNotFoundException, SQLException{
			
			List<Integer> nld = new ArrayList<Integer>();
			Connection nct = Tstep1rgetSim.connectDatabase();
			Statement nsm = nct.createStatement();
			ResultSet rs = nsm.executeQuery(" SELECT number2014 FROM sheet9 WHERE  id<2924");
			while(rs.next()){
				nld.add(rs.getInt("number2014"));	
			}
			nct.close();
			return nld;
		}
		
		//���õ��ĵ���ֵ��Ӧ����2014number���A��
		public void setNumber(List<Integer> li,List<String> lss) throws ClassNotFoundException, SQLException{
			Connection nct1 = Tstep1rgetSim.connectDatabase();
			String str = "update tensim set 2014numberA=? where A=?";
			PreparedStatement nps = nct1.prepareStatement(str);
			for(int i=0;i<li.size();i++){
				    nps.setInt(1, li.get(i));
				    nps.setString(2, lss.get(i));
				    nps.execute();
			}
			
			nct1.close();
		}

}
