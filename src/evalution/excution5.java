package evalution;

import java.sql.SQLException;
import java.util.List;

public class excution5 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step5countErrorPro sce = new step5countErrorPro();
		step3setNumberToA fsn = new step3setNumberToA();
		step1getSim fss = new step1getSim();
		List<List<Integer>> flli = sce.countError();
		List<List<Integer>> flli1 = fsn.readNumber();
		List<String> fls = fss.SgetCompanyNames();
		List<List<Double>> flld = sce.getProbility(flli, flli1);
		sce.setError(flld, fls);
		
		
	}

}
