package TZOVevalution;

import java.sql.SQLException;
import java.util.List;


public class Oexcution6 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Ostep6avgError Tse = new Ostep6avgError();
		List<Double> Tlds = Tse.getwucha();
		double Td = Tse.countAvg(Tlds);
		Tse.setAvg(Td);
	}

}
