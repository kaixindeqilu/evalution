package TZOVevalution;

import java.sql.SQLException;
import java.util.List;


public class Oexcution1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Ostep1getSim Osrd = new Ostep1getSim();
		List<List<Double>> list1 = Osrd.SaddDataToList();
		List<String> list2 =  Osrd.SgetCompanyNames();
		List<List<Double>> list3 = Osrd.SactionData(list1);
		/*
		for(List<Double> ld:list3){
		    System.out.println(ld.toString());
		}
		*/
		Osrd.SsetDataToDB(list2, list3);
	}

}
