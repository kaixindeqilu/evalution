package substract;

import java.sql.SQLException;
import java.util.List;


public class action5 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step5 sfive = new step5();
		
		List<String> tls = sfive.getB();
	    List<Integer> Tli = sfive.getID(tls);
	    List<Integer> tlii = sfive.readNumberToo(Tli);
	    sfive.setB(tlii, tls);
	}

}
