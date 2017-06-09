package TZOTevalution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zstep4SetNumberToB {
	
	//���tensim2����B�е�ֵ����������ҵB������
		public List<String> getB() throws ClassNotFoundException, SQLException{
			Connection dct = Zstep1getSim.connectDatabase();
			List<String> dls = new ArrayList<String>();
			Statement nsm = dct.createStatement();
			ResultSet rs = nsm.executeQuery(" SELECT B FROM tensim2 WHERE  id<29231");
			while(rs.next()){
				dls.add(rs.getString("B"));
			}
			dct.close();
			return dls;
		}
			
	//�����ҵB��Ӧ��idֵ
		public List<Integer> getID(List<String> dls) throws ClassNotFoundException, SQLException{
			Connection dct1 = Zstep1getSim.connectDatabase();
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
			
	//������ҵB��idֵ��ø���ҵ��Ӧ��number2014ֵ
		public List<Integer> readNumberToo(List<Integer> lg) throws ClassNotFoundException, SQLException{
			Connection dct2 = Zstep1getSim.connectDatabase();
			List<Integer> li = new ArrayList<Integer>();
			Statement nsm = dct2.createStatement();
			for(int j=0;j<lg.size();j++){
			    ResultSet rs = nsm.executeQuery(" SELECT number2013 FROM sheet10 WHERE id="+'"'+lg.get(j)+'"');
			    while(rs.next()){
			    	li.add(rs.getInt("number2013"));
			    }
			}
			dct2.close();
			return li;
		}
		
	//����ҵB��2014numberֵд���tensim��2014numberB
		public void setB(List<Integer> li,List<String> lis) throws ClassNotFoundException, SQLException{
			Connection dct3 = Zstep1getSim.connectDatabase();				
			String str = "update tensim2 set 2013numberB=? where B=?";
			PreparedStatement dps = dct3.prepareStatement(str);
			for(int i=0;i<li.size();i++){					  
				dps.setInt(1, li.get(i));
			    dps.setString(2, lis.get(i));
			    dps.execute();
			}
			dct3.close();
				
		}
    
	/*
	//�������ʵ��
	public void setB() throws ClassNotFoundException, SQLException{
		Connection dct3 = Zstep1getSim.connectDatabase();				
		String str = "update tensim2_copy set 2013numberB=? where id=?";
		PreparedStatement dps = dct3.prepareStatement(str);
		Random ran = new Random();
		for(int i=1;i<29231;i++){					  
			dps.setInt(1,ran.nextInt(20)+1 );
		    dps.setInt(2,i);
		    dps.execute();
		}
		dct3.close();
			
	}
	*/

}
