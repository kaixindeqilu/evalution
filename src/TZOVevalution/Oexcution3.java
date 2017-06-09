package TZOVevalution;

import java.sql.SQLException;
import java.util.List;

public class Oexcution3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	    Ostep1getSim Osrd = new Ostep1getSim();
	    Ostep3setNumberToA Ossn = new Ostep3setNumberToA();
	
	    List<String> Tls = Osrd.SgetCompanyNames();
	    List<Integer> Tli = Ossn.readNumber();
	    Ossn.setNumber(Tli, Tls);
	}

}
