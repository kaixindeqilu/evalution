package substract;

import java.sql.SQLException;
import java.util.List;

public class action2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step2 st = new step2();
		List<List<Double>> sld = st.getdatafromsub1();
		List<String> sls = st.SgetCompanyNames();
		List<List<Double>> sld1 = st.actionData(sld);
		st.SsetDataToDB(sls, sld1);
	}

}
