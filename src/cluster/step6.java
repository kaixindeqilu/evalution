package cluster;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import random.design;

//计算平均误差
public class step6 {
	public List<List<Double>> MASE() throws SQLException, ClassNotFoundException{
		List<List<Double>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList();
		List<Double> list2 = new ArrayList();
		List<Double> list3 = new ArrayList();
		Connection con = design.connectDatabase();
		Statement esm = con.createStatement();
		ResultSet rs = esm.executeQuery(" SELECT sub FROM origin1");
		while(rs.next()){
			list1.add(rs.getInt("sub"));
		}
		con.close();
		int count = 0;
		double val2 = 0;
		double val3 = 0;
		for(int i=0;i<list1.size();i++){
			val2 +=list1.get(i);
			val3 +=Math.pow(list1.get(i),2);
			count++;
			if(count%10==0){
				list2.add(val2/10);
				val2 = 0;
				list3.add(val3/10);
				val3 = 0;
			}
		}
		list.add(list2);
		list.add(list3);
		return list;
	}

	public List<Double> avgErr(List<List<Double>> ld){
		List<Double> list = new ArrayList<>();
		double res1 = 0;
		double res2 = 0;
		for (int i = 0;i < 2923;i++){
			res1 += ld.get(0).get(i);
			res2 += ld.get(1).get(i);
		}
		res1 = res1/2923;
		res2 = res2/2923;
		list.add(res1);
		list.add(res2);
		return list;
	}
	public void leading(List<List<Double>> lld) throws ClassNotFoundException, SQLException {
		String s = "update wucha1 set MAE=?,MSE=?";
		Connection con = design.connectDatabase();
		PreparedStatement ps = con.prepareStatement(s);
		for(int i=0;i<2923;i++) {
			ps.setDouble(1, lld.get(0).get(i));
			ps.setDouble(2, lld.get(1).get(i));
			ps.execute();
		}
		con.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step6 six = new step6();
		List<List<Double>> list = six.MASE();
		List<Double> result = six.avgErr(list);
		//测试结果输出
		System.out.println(list.get(0));
		System.out.println(result);
		//six.leading(list);
	}

}
