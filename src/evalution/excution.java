package evalution;

import java.sql.SQLException;
import java.util.List;

public class excution {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		step1getSim gs = new step1getSim();
		List<List<Double>> list1 = gs.SaddDataToList();
		List<String> list2 =  gs.SgetCompanyNames();
		List<List<Double>> list3 = gs.SactionData(list1);
		/*
		for(List<Double> ld:list3){
		    System.out.println(ld.toString());
		}
		*/
		gs.SsetDataToDB(list2, list3);
	}

}
