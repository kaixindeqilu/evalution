package substract;

import java.sql.SQLException;
import java.util.List;


public class action4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	    step2 stwo = new step2();
	    step4 sfour = new step4();
	
	    List<String> Tls = stwo.SgetCompanyNames();
	    List<Integer> Tli = sfour.readNumber();
	    sfour.setNumber(Tli, Tls);
	}


}
