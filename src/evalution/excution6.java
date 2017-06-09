package evalution;

import java.sql.SQLException;
import java.util.List;

public class excution6 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step6avgError sae = new step6avgError();
		List<List<Double>> slld = sae.getwucha();
		System.out.println(slld.get(0).size());
		List<Double> slldd = sae.countAvg(slld);
		System.out.println(slldd.toString());
		sae.setAvg(slldd);
	}

}
