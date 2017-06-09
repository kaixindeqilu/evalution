package random;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class avg {
	public List<Double> getwucha() throws ClassNotFoundException, SQLException{
		//step5countErrorPro wsce = new step5countErrorPro(); //如果调用step5,就得重新再计算一遍，不如直接读取数据库表
		
		List<Double> wld1 = new ArrayList<Double>();
		Connection wc = design.connectDatabase();
		Statement sm = wc.createStatement();
		ResultSet rs = sm.executeQuery("select error from sheetbb");
		while(rs.next()){
			wld1.add(rs.getDouble("error"));
	    }	
		wc.close();
		return wld1;
	}
	

	//计算平均误差
	public double countAvg(List<Double> ld){
		double a=0;
		for(int i=0;i<ld.size();i++){
			a=a+ld.get(i);	
		}
		a=a/2923;
		BigDecimal bb1 = new BigDecimal(a);	
    	double ffa = bb1.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
    	//System.out.println(ffa);
		return ffa;
	}
	
	//插入平均误差率的值到表wucha中
	public void setAvg(double d) throws ClassNotFoundException, SQLException{
		Connection wc1 = design.connectDatabase();
		PreparedStatement ps = wc1.prepareStatement("insert into Tnumber5(avg) values (?)");
		//ps.setString(1, "平均误差率");
		ps.setDouble(1, d);
		ps.execute();
        wc1.close();
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		avg ag = new avg();
		List<Double> ld = ag.getwucha();
		double x = ag.countAvg(ld);
		ag.setAvg(x);
	}
	

}
