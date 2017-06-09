package TZOVevalution;

import java.sql.SQLException;
import java.util.List;

public class Oexcution2 {
public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Ostep2getTen Osgt = new Ostep2getTen();
		List<Ocompany> lcp = Osgt.getData();
		Osgt.setData(lcp);
	}

}
