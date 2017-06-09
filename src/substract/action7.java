package substract;

import java.sql.SQLException;
import java.util.List;


public class action7 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step7 Tse = new step7();
		List<Double> Tlds = Tse.getwucha();
		double Td = Tse.countAvg(Tlds);
		Tse.setAvg(Td);
	}

}
