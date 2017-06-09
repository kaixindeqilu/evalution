package cluster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import random.design;;

public class step1{
	public List<double[]> getData() throws ClassNotFoundException, SQLException{
		List<double[]> list = new ArrayList();
		//double[] arr = new double[28];
		Connection con = design.connectDatabase();
		Statement sm = con.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM logall");
		while(rs.next()){
			double[] arr = new double[28];
			//2013数据
//	    	arr[0] = rs.getDouble("A");
//	    	arr[1] = rs.getDouble("D");
//	    	arr[2] = rs.getDouble("G");
//	    	arr[3] = rs.getDouble("J");
//	    	arr[4] = rs.getDouble("M");
//	    	arr[5] = rs.getDouble("P");
//	    	arr[6] = rs.getDouble("S");
//	    	arr[7] = rs.getDouble("V");
//	    	arr[8] = rs.getDouble("Y");
//	    	arr[9] = rs.getDouble("AB");
//	    	arr[10] = rs.getDouble("AE");
//	    	arr[11] = rs.getDouble("AH");
//	    	arr[12] = rs.getDouble("AK");
//	    	arr[13] = rs.getDouble("AN");
//	    	arr[14] = rs.getDouble("AQ");
//	    	arr[15] = rs.getDouble("AT");
//	    	arr[16] = rs.getDouble("AW");
//	    	arr[17] = rs.getDouble("AZ");
//	    	arr[18] = rs.getDouble("BC");
//	    	arr[19] = rs.getDouble("BF");
//	    	arr[20] = rs.getDouble("BI");
//	    	arr[21] = rs.getDouble("BL");
//	    	arr[22] = rs.getDouble("BO");
//	    	arr[23] = rs.getDouble("BR");
//	    	arr[24] = rs.getDouble("BW");
//	    	arr[25] = rs.getDouble("BZ");
//	    	arr[26] = rs.getDouble("CC");
//	    	arr[27] = rs.getDouble("CE");
	    	//2014数据
//	    	arr[0] = rs.getDouble("B");
//	    	arr[1] = rs.getDouble("E");
//	    	arr[2] = rs.getDouble("H");
//	    	arr[3] = rs.getDouble("K");
//	    	arr[4] = rs.getDouble("N");
//	    	arr[5] = rs.getDouble("Q");
//	    	arr[6] = rs.getDouble("T");
//	    	arr[7] = rs.getDouble("W");
//	    	arr[8] = rs.getDouble("Z");
//	    	arr[9] = rs.getDouble("AC");
//	    	arr[10] = rs.getDouble("AF");
//	    	arr[11] = rs.getDouble("AI");
//	    	arr[12] = rs.getDouble("AL");
//	    	arr[13] = rs.getDouble("AO");
//	    	arr[14] = rs.getDouble("AR");
//	    	arr[15] = rs.getDouble("AU");
//	    	arr[16] = rs.getDouble("AX");
//	    	arr[17] = rs.getDouble("BA");
//	    	arr[18] = rs.getDouble("BD");
//	    	arr[19] = rs.getDouble("BG");
//	    	arr[20] = rs.getDouble("BJ");
//	    	arr[21] = rs.getDouble("BM");
//	    	arr[22] = rs.getDouble("BP");
//	    	arr[23] = rs.getDouble("BS");
//	    	arr[24] = rs.getDouble("BV");
//	    	arr[25] = rs.getDouble("BYY");
//	    	arr[26] = rs.getDouble("CB");
//	    	arr[27] = rs.getDouble("CF");
	    	//2015数据
	    	arr[0] = rs.getDouble("C");
	    	arr[1] = rs.getDouble("F");
	    	arr[2] = rs.getDouble("I");
	    	arr[3] = rs.getDouble("L");
	    	arr[4] = rs.getDouble("O");
	    	arr[5] = rs.getDouble("R");
	    	arr[6] = rs.getDouble("U");
	    	arr[7] = rs.getDouble("X");
	    	arr[8] = rs.getDouble("AA");
	    	arr[9] = rs.getDouble("AD");
	    	arr[10] = rs.getDouble("AG");
	    	arr[11] = rs.getDouble("AJ");
	    	arr[12] = rs.getDouble("AM");
	    	arr[13] = rs.getDouble("AP");
	    	arr[14] = rs.getDouble("ASS");
	    	arr[15] = rs.getDouble("AV");
	    	arr[16] = rs.getDouble("AY");
	    	arr[17] = rs.getDouble("BB");
	    	arr[18] = rs.getDouble("BE");
	    	arr[19] = rs.getDouble("BH");
	    	arr[20] = rs.getDouble("BK");
	    	arr[21] = rs.getDouble("BN");
	    	arr[22] = rs.getDouble("BQ");
	    	arr[23] = rs.getDouble("BT");
	    	arr[24] = rs.getDouble("BU");
	    	arr[25] = rs.getDouble("BX");
	    	arr[26] = rs.getDouble("CA");
	    	arr[27] = rs.getDouble("CG");
	    	

	    	list.add(arr);	   	   
		}
		
		//测试数据是否正确读取
//		for(int i=0;i<28;i++){
//			System.out.println(list.get(0)[i]);
//		}
		return list;
	}
		
		public  List<double[]> transp(List<double[]> lld){
			List<double[]> lldd = new ArrayList<>();
			
			for(int i=0;i<28;i++){
				double[] arr = new double[2923];
			    for(int j=0;j<2923;j++){
				    arr[j] = lld.get(j)[i];
			    }
			    lldd.add(arr);
			}
			return lldd;
		}
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException{
			step1 s = new step1();
			List<double[]> list1 = s.getData();
			List<double[]> list2 = s.transp(list1);
//			for(int i=0;i<2923;i++){
//				System.out.println(list2.get(0)[i]);
//			}
		}
	
}
