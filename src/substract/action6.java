package substract;

import java.sql.SQLException;
import java.util.List;


public class action6 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step6 Tse = new step6();
		step4 Tsn = new step4();
		step2 Tsd = new step2();
		List<Integer> Tli = Tse.countError();
		List<Integer> Tlii = Tsn.readNumber();
		List<String> Tls = Tsd.SgetCompanyNames();
		List<Double> Tld = Tse.getProbility(Tli, Tlii);
		Tse.setError(Tld, Tls);
	}

}
