package substract;

import java.sql.SQLException;
import java.util.List;

public class action1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step1 s = new step1();
		List<List<Double>> lld = s.getData();
		List<List<Double>> lld1 = s.getSub(lld);
		//List<String> ls = s.getData();
		//System.out.println(ls.toString());
		//System.out.println(lld.get(1).toString());
		//System.out.println(lld1.get(1).toString());
		//s.getData();
		System.out.println(lld.size());
		System.out.println(lld.get(0).size());
		System.out.println(lld1.size());
		//s.setData(lld1);
	}

}
