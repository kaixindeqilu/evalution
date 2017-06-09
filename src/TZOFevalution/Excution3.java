package TZOFevalution;

import java.sql.SQLException;
import java.util.List;

public class Excution3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	    Tstep1rgetSim srd = new Tstep1rgetSim();
	    Tstep3setNumberToA ssn = new Tstep3setNumberToA();
	
	    List<String> Tls = srd.SgetCompanyNames();
	    List<Integer> Tli = ssn.readNumber();
	    ssn.setNumber(Tli, Tls);
	}
}
