package evalution;

import java.sql.SQLException;
import java.util.List;

public class excution1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step1getSim sgs = new step1getSim();
		step2getTen sgt = new step2getTen();
		List<String> l = sgs.SgetCompanyNames();
		//System.out.println(l.toString());
		sgt.getFirstTen(l);
	}

}
