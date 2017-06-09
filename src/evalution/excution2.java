package evalution;

import java.sql.SQLException;
import java.util.List;

public class excution2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//step1getSim sgs = new step1getSim();
		//List<String> ls = sgs.SgetCompanyNames();
		newStep2 ns = new newStep2();
		List<company> lcp = ns.getData();
		ns.setData(lcp);
	}

}
