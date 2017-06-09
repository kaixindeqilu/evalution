package TZOFevalution;

import java.sql.SQLException;
import java.util.List;

public class Excution5 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Tstep5countError Tse = new Tstep5countError();
		Tstep3setNumberToA Tsn = new Tstep3setNumberToA();
		Tstep1rgetSim Tsd = new Tstep1rgetSim();
		List<Integer> Tli = Tse.countError();
		List<Integer> Tlii = Tsn.readNumber();
		List<String> Tls = Tsd.SgetCompanyNames();
		List<Double> Tld = Tse.getProbility(Tli, Tlii);
		Tse.setError(Tld, Tls);
	}

}
