package cluster;

import random.design;

import java.sql.*;
import java.util.*;

//为指标值分配整型值
public class step3{
	public Map<Integer,Double> newList() throws SQLException, ClassNotFoundException {
		List<Integer> list1 = new ArrayList();
		List<Double> list2 = new ArrayList();
		Map<Integer,Double> map = new HashMap<>();
		Connection con = design.connectDatabase();
		Statement sm = con.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT id,e FROM logall order by e" );
		while (rs.next()){
			map.put(rs.getInt("id"),rs.getDouble("e"));
		}
		con.close();
		return map;
	}
	public  Map<Integer, Double> sortMap(Map<Integer, Double> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		Map<Integer, Double> sortedMap = new LinkedHashMap<Integer, Double>();
		List<Map.Entry<Integer, Double>> entryList = new ArrayList<Map.Entry<Integer, Double>>(
				oriMap.entrySet());
		Collections.sort(entryList, new MapValueComparator());

		Iterator<Map.Entry<Integer, Double>> iter = entryList.iterator();
		Map.Entry<Integer, Double> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}
    public Map<Integer,Double> intMap(Map<Integer,Double> doubleMap){
		int len = doubleMap.size();
		System.out.print(len);
		int i = 0;
		Iterator<Map.Entry<Integer, Double>> iter = doubleMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer,Double > entry = iter.next();
			if (i <= len / 10 * 1) {
				doubleMap.put(entry.getKey(), 1.0);
				i++;
				continue;
			}
			if (len / 10 * 1 < i && i <= len / 10 * 2) {
				doubleMap.put(entry.getKey(), 2.0);
				i++;
				continue;
			}
			if (len / 10 * 2 < i && i <= len / 10 * 3) {
				doubleMap.put(entry.getKey(), 3.0);
				i++;
				continue;
			}
			if (len / 10 * 3 < i && i <= len / 10 * 4) {
				doubleMap.put(entry.getKey(), 4.0);
				i++;
				continue;
			}
			if (len / 10 * 4 < i && i <= len / 10 * 5) {
				doubleMap.put(entry.getKey(), 5.0);
				i++;
				continue;
			}
			if (len / 10 * 5 < i && i <= len / 10 * 6) {
				doubleMap.put(entry.getKey(), 6.0);
				i++;
				continue;
			}
			if (len / 10 * 6 < i && i <= len / 10 * 7) {
				doubleMap.put(entry.getKey(), 7.0);
				i++;
				continue;
			}
			if (len / 10 * 7 < i && i <= len / 10 * 8) {
				doubleMap.put(entry.getKey(), 8.0);
				i++;
				continue;
			}
			if (len / 10 * 8 < i && i <= len / 10 * 9) {
				doubleMap.put(entry.getKey(), 9.0);
				i++;
				continue;
			}
			if (len / 10 * 9 < i) {
				doubleMap.put(entry.getKey(), 10.0);
				i++;
				continue;
			}
		}
		return doubleMap;
	}
	public void setnum(Map<Integer,Double> intMap) throws SQLException, ClassNotFoundException {
		Connection con = design.connectDatabase();
		Iterator<Map.Entry<Integer, Double>> iter = intMap.entrySet().iterator();
		String insert = "insert zhengshu(id,e) values(?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		while (iter.hasNext()) {
			Map.Entry<Integer,Double > entry = iter.next();
			ps.setDouble(1, entry.getKey());
			ps.setDouble(2, entry.getValue());
			ps.execute();
		}
		con.close();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		step3 three = new step3();
		Map<Integer,Double> map1 = three.newList();
//		for (Map.Entry<Integer,Double> entry : map1.entrySet())
//			System.out.println(entry.getKey() + "   "+entry.getValue());
		Map<Integer,Double> map2 = three.sortMap(map1);
//		for (Map.Entry<Integer,Double> entry : map2.entrySet())
//			System.out.println(entry.getKey() + "   "+entry.getValue());
		Map<Integer,Double> map3 = three.intMap(map2);
//		for (Map.Entry<Integer,Double> entry : map3.entrySet())
//			System.out.println(entry.getKey() + "   "+entry.getValue());
		three.setnum(map3);
	}
	
}