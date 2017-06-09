package TZOFevalution;

import java.sql.SQLException;
import java.util.List;

public class Excution2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Tstep2getTen sgt = new Tstep2getTen();
		List<Tcompany> lcp = sgt.getData();
		sgt.setData(lcp);
	}

}
