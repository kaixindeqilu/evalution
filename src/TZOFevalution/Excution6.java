package TZOFevalution;

import java.sql.SQLException;
import java.util.List;

public class Excution6 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Tstep6avgError Tse = new Tstep6avgError();
		List<Double> Tlds = Tse.getwucha();
		double Td = Tse.countAvg(Tlds);
		Tse.setAvg(Td);
	}

}
