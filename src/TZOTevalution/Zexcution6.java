package TZOTevalution;

import java.sql.SQLException;
import java.util.List;


public class Zexcution6 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Zstep6avgError Tse = new Zstep6avgError();
		List<Double> Tlds = Tse.getwucha();
		double Td = Tse.countAvg(Tlds);
		Tse.setAvg(Td);
	}

}
