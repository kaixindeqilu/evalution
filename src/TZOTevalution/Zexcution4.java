package TZOTevalution;

import java.sql.SQLException;
import java.util.List;


public class Zexcution4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
	    
	    Zstep4SetNumberToB nssn = new Zstep4SetNumberToB();
	
	    List<String> Tls = nssn.getB();
	    List<Integer> Tli = nssn.getID(Tls);
	    List<Integer> Tlii = nssn.readNumberToo(Tli);
	    
	    //nssn.setB();
	}

}
