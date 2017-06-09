package evalution;

import java.sql.SQLException;
import java.util.List;

public class excution3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step1getSim step1 = new step1getSim();
		step3setNumberToA step3 = new step3setNumberToA();
		List<String>  comNames = step1.SgetCompanyNames();
		List<List<Integer>> number = step3.readNumber();
		for(List<?> list:number){
			System.out.println(list.toString());
		}
		step3.setNumber(number, comNames);
	}

}
