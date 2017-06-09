package substract;

import java.sql.SQLException;
import java.util.List;

public class action3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step3 se = new step3();
		List<scompany> slc = se.getData();
		se.setData(slc);
	}

}
