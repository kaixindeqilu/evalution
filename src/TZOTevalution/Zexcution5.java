package TZOTevalution;

import java.sql.SQLException;
import java.util.List;


public class Zexcution5 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Zstep5countError Tse = new Zstep5countError();
		Zstep3setNumberToA Tsn = new Zstep3setNumberToA();
		Zstep1getSim Tsd = new Zstep1getSim();
		List<Integer> Tli = Tse.countError();
		List<Integer> Tlii = Tsn.readNumber();
		List<String> Tls = Tsd.SgetCompanyNames();
		List<Double> Tld = Tse.getProbility(Tli, Tlii);
		//Tse.setError(Tld, Tls);
	}

}
