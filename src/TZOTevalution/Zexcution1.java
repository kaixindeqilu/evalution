package TZOTevalution;

import java.sql.SQLException;
import java.util.List;


public class Zexcution1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Zstep1getSim srd = new Zstep1getSim();
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
