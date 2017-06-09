package TZOVevalution;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Ostep6avgError {
	//��ȡ��twucha
			public List<Double> getwucha() throws ClassNotFoundException, SQLException{
				//step5countErrorPro wsce = new step5countErrorPro(); //�������step5,�͵������ټ���һ�飬����ֱ�Ӷ�ȡ���ݿ��
				
				List<Double> wld1 = new ArrayList<Double>();
				Connection wc = Ostep1getSim.connectDatabase();
				Statement sm = wc.createStatement();
				ResultSet rs = sm.executeQuery("select 2015error from newtfwucha");
				while(rs.next()){
					wld1.add(rs.getDouble("2015error"));
			    }	
				return wld1;
			}
			

			//����ƽ�����
			public double countAvg(List<Double> ld){
				double a=0;
				for(int i=0;i<ld.size();i++){
					a=a+ld.get(i);	
				}
				a=a/2923;
				BigDecimal bb1 = new BigDecimal(a);	
		    	double ffa = bb1.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		    	
				return ffa;
			}
			
			//����ƽ������ʵ�ֵ����wucha��
			public void setAvg(double d) throws ClassNotFoundException, SQLException{
				Connection wc1 = Ostep1getSim.connectDatabase();
				PreparedStatement ps = wc1.prepareStatement("insert into newtfwucha values (?,?)");
				ps.setString(1, "avgError");
				ps.setDouble(2, d);
				ps.execute();

			}

}
