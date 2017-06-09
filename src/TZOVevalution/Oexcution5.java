package TZOVevalution;

import java.sql.SQLException;
import java.util.List;

public class Oexcution5 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Ostep5countError Tse = new Ostep5countError();
		Ostep3setNumberToA Tsn = new Ostep3setNumberToA();
		Ostep1getSim Tsd = new Ostep1getSim();
		List<Integer> Tli = Tse.countError();
		List<Integer> Tlii = Tsn.readNumber();
		List<String> Tls = Tsd.SgetCompanyNames();
		List<Double> Tld = Tse.getProbility(Tli, Tlii);
		Tse.setError(Tld, Tls);
	}

}
