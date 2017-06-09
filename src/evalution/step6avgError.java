package evalution;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//����2013,2014,2015��ȵ�ƽ�����
public class step6avgError {
	//��ȡ��wucha
	public List<List<Double>> getwucha() throws ClassNotFoundException, SQLException{
		//step5countErrorPro wsce = new step5countErrorPro(); //�������step5,�͵������ټ���һ�飬����ֱ�Ӷ�ȡ���ݿ��
		List<List<Double>> wlld = new ArrayList<List<Double>>();
		List<Double> wld1 = new ArrayList<Double>();
		List<Double> wld2 = new ArrayList<Double>();
		List<Double> wld3 = new ArrayList<Double>();
		Connection wc = step1getSim.connectDatabase();
		Statement sm = wc.createStatement();
		ResultSet rs = sm.executeQuery("select 2013errorPro,2014errorPro,2015errorPro from newwucha");
		while(rs.next()){
			wld1.add(rs.getDouble("2013errorPro"));
			wld2.add(rs.getDouble("2014errorPro"));
			wld3.add(rs.getDouble("2015errorPro"));
		}
		//System.out.println(wld1.toString());
		wlld.add(wld1);
		wlld.add(wld2);
		wlld.add(wld3);
		return wlld;
	}
	
	//����ƽ�����
	public List<Double> countAvg(List<List<Double>> lld){
		List<Double> ald = new ArrayList<Double>();
		double a=0;
		double b=0;
		double c=0;
		for(int i=0;i<lld.get(0).size();i++){
			a=a+lld.get(0).get(i);
			b=b+lld.get(1).get(i);
			c=c+lld.get(2).get(i);
		}
		a=a/2923;
		BigDecimal bb1 = new BigDecimal(a);	
    	double ffa = bb1.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		b=b/2923;
		BigDecimal bb2= new BigDecimal(b);	
    	double ffb = bb2.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		c=c/2923;
		BigDecimal bb3 = new BigDecimal(c);	
    	double ffc = bb3.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		ald.add(ffa);
		ald.add(ffb);
		ald.add(ffc);
		return ald;
	}
	
	
	//����ƽ������ʵ�ֵ����wucha��
	public void setAvg(List<Double> ld) throws ClassNotFoundException, SQLException{
		Connection wc1 = step1getSim.connectDatabase();
		PreparedStatement ps = wc1.prepareStatement("insert into newwucha values (?,?,?,?)");
		ps.setString(1, "avgError");
		ps.setDouble(2, ld.get(0));
		ps.setDouble(3, ld.get(1));
		ps.setDouble(4, ld.get(2));
		ps.execute();

	}
	

}
