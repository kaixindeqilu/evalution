package TZOFevalution;

import java.sql.SQLException;
import java.util.List;

//import evalution.step1getSim;

public class Excution1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Tstep1rgetSim srd = new Tstep1rgetSim();
		List<List<Double>> list1 = srd.SaddDataToList();
		List<String> list2 =  srd.SgetCompanyNames();
		List<List<Double>> list3 = srd.SactionData(list1);
		/*
		for(List<Double> ld:list3){
		    System.out.println(ld.toString());
		}
		*/
		srd.SsetDataToDB(list2, list3);
	}

}
