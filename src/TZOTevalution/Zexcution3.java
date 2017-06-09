package TZOTevalution;

import java.sql.SQLException;
import java.util.List;

public class Zexcution3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	    Zstep1getSim srd = new Zstep1getSim();
	    Zstep3setNumberToA ssn = new Zstep3setNumberToA();
	
	    List<String> Tls = srd.SgetCompanyNames();
	    List<Integer> Tli = ssn.readNumber();
	    ssn.setNumber(Tli, Tls);
	}

}
