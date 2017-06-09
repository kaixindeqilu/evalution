package TZOFevalution;

import java.sql.SQLException;
import java.util.List;

public class Excution4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	    
	    Tstep4setNumberToB nssn = new Tstep4setNumberToB();
	/*
	    List<String> Tls = nssn.getB();
	    List<Integer> Tli = nssn.getID(Tls);
	    List<Integer> Tlii = nssn.readNumberToo(Tli);
	   */
	    nssn.setB();
	}

}
