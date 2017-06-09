package random;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class design {
	private static final String forname = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/liulu?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	
	
	//�������ݿ�
	public static Connection connectDatabase() throws ClassNotFoundException, SQLException{
					
		Class.forName(forname);
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return con;
	}
	
	//������
	public void create() throws ClassNotFoundException, SQLException{
		Connection con = design.connectDatabase();
	    Statement stmt=con.createStatement();//����Statement����
		  
		//String s = "create table abc(A varchar(20),B varchar(20),sim double(16,4),id int unsigned auto_increment primary key)";
		String s1 = "create table sheetaa(A varchar(20),B varchar(20),sim double(16,4),id int unsigned auto_increment primary key)";
	   // String s2 = "create table sheetbb(name varchar(20),error double(16,4))";
		//stmt.executeUpdate(s);
		stmt.executeUpdate(s1);
		//stmt.executeUpdate(s2);
		
		con.close();
	}
	
	
	//ɾ����
		public void drop() throws ClassNotFoundException, SQLException{
			//String s = "drop table abc ";
			String s1 = "drop table sheetaa";
			//String s2 =  "drop table sheetbb ";
			Connection co0 = design.connectDatabase();
			Statement stmt=co0.createStatement();//����Statement����
			//stmt.executeUpdate(s);
			stmt.executeUpdate(s1);
			//stmt.executeUpdate(s2);
			co0.close();
		}
		
	
	//������ݿ����ݵ�lld��:�Ȼ�ȡ���ݿ�ԭʼ����
	public static List<List<Double>> addDataToLld() throws SQLException, ClassNotFoundException{  
		Connection co1 = design.connectDatabase();
		Statement sm = co1.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM logall");
		List<List<Double>> lld = new ArrayList<>();
		
		List<Double> list = new ArrayList<Double>();
		
		//ÿ��list�洢һ����¼��A��CG��ֵ����lld��ÿ��Ԫ����һ�������ļ�¼
	    while(rs.next()){
	//    	list.add(rs.getDouble("A"));
  //  	    list.add(rs.getDouble("B"));
//	    	list.add(rs.getDouble("C"));
//	    	list.add(rs.getDouble("D"));
//	    	list.add(rs.getDouble("E"));
//    	    list.add(rs.getDouble("F"));
//	    	list.add(rs.getDouble("G"));
//	    	list.add(rs.getDouble("H"));    	
//	    	list.add(rs.getDouble("I"));
//	    	list.add(rs.getDouble("J"));
//	    	list.add(rs.getDouble("K"));
//	    	list.add(rs.getDouble("L"));
//	    	list.add(rs.getDouble("M"));
//	    	list.add(rs.getDouble("N"));
//       	    list.add(rs.getDouble("O"));
//	    	list.add(rs.getDouble("P"));
//	    	list.add(rs.getDouble("Q"));
//	    	list.add(rs.getDouble("R"));
//	    	list.add(rs.getDouble("S"));
//	    	list.add(rs.getDouble("T"));
//	    	list.add(rs.getDouble("U"));
//	    	list.add(rs.getDouble("V"));
//	    	list.add(rs.getDouble("W"));
//	    	list.add(rs.getDouble("X"));
//	    	list.add(rs.getDouble("Y"));
//	    	list.add(rs.getDouble("Z"));
//	    	list.add(rs.getDouble("AA"));
//	    	list.add(rs.getDouble("AB"));
//	    	list.add(rs.getDouble("AC"));
//	    	list.add(rs.getDouble("AD"));
//	    	list.add(rs.getDouble("AE"));
//	    	list.add(rs.getDouble("AF"));
//	    	list.add(rs.getDouble("AG"));
//	    	list.add(rs.getDouble("AH"));
//	    	list.add(rs.getDouble("AI"));
//	    	list.add(rs.getDouble("AJ"));
//	    	list.add(rs.getDouble("AK"));
//	    	list.add(rs.getDouble("AL"));
//	    	list.add(rs.getDouble("AM"));
//	    	list.add(rs.getDouble("AN"));
//	    	list.add(rs.getDouble("AO"));
//	    	list.add(rs.getDouble("AP"));
//	    	list.add(rs.getDouble("AQ"));
//	    	list.add(rs.getDouble("AR"));
//	    	list.add(rs.getDouble("ASS"));
//	    	list.add(rs.getDouble("AT"));
//	    	list.add(rs.getDouble("AU"));
//	    	list.add(rs.getDouble("AV"));
//	    	list.add(rs.getDouble("AW"));
//	    	list.add(rs.getDouble("AX"));
//	    	list.add(rs.getDouble("AY"));
//	    	list.add(rs.getDouble("AZ"));
//	    	list.add(rs.getDouble("BA"));
//	    	list.add(rs.getDouble("BB"));
//       	    list.add(rs.getDouble("BC"));
//	    	list.add(rs.getDouble("BD"));
//	    	list.add(rs.getDouble("BE"));
//	    	list.add(rs.getDouble("BF"));
//	    	list.add(rs.getDouble("BG"));
//	    	list.add(rs.getDouble("BH"));
//	    	list.add(rs.getDouble("BI"));
//	    	list.add(rs.getDouble("BJ"));
//	    	list.add(rs.getDouble("BK"));	
//	    	list.add(rs.getDouble("BL"));
//	    	list.add(rs.getDouble("BM"));
//	    	list.add(rs.getDouble("BN"));
//	    	list.add(rs.getDouble("BO"));
//	    	list.add(rs.getDouble("BP"));
//	    	list.add(rs.getDouble("BQ"));
//	    	list.add(rs.getDouble("BR"));
//	    	list.add(rs.getDouble("BS"));
//	    	list.add(rs.getDouble("BT"));
//	    	list.add(rs.getDouble("BU"));
//	    	list.add(rs.getDouble("BV"));
//	    	list.add(rs.getDouble("BW"));
//	    	list.add(rs.getDouble("BX"));
//	    	list.add(rs.getDouble("BYY"));
//	    	list.add(rs.getDouble("BZ"));
//     	    list.add(rs.getDouble("CA"));	
//  	        list.add(rs.getDouble("CB"));
//	    	list.add(rs.getDouble("CC"));
//	    	
//	    	list.add(rs.getDouble("CE"));
//	    	list.add(rs.getDouble("CF"));
//	    	list.add(rs.getDouble("CG"));
	//2013����
	    	list.add(rs.getDouble("A"));
	    	list.add(rs.getDouble("D"));
	    	list.add(rs.getDouble("G"));
	    	list.add(rs.getDouble("J"));
	    	list.add(rs.getDouble("M"));
	    	list.add(rs.getDouble("P"));
	    	list.add(rs.getDouble("S"));
	    	list.add(rs.getDouble("V"));
	    	list.add(rs.getDouble("Y"));
	    	list.add(rs.getDouble("AB"));
	    	list.add(rs.getDouble("AE"));
	    	list.add(rs.getDouble("AH"));
	    	list.add(rs.getDouble("AK"));
	    	list.add(rs.getDouble("AN"));
	    	list.add(rs.getDouble("AQ"));
	    	list.add(rs.getDouble("AT"));
	    	list.add(rs.getDouble("AW"));
	    	list.add(rs.getDouble("AZ"));
	    	list.add(rs.getDouble("BC"));
	    	list.add(rs.getDouble("BF"));
	    	list.add(rs.getDouble("BI"));
	    	list.add(rs.getDouble("BL"));
	    	list.add(rs.getDouble("BO"));
	    	list.add(rs.getDouble("BR"));
	    	list.add(rs.getDouble("BW"));
	    	list.add(rs.getDouble("BZ"));
	    	list.add(rs.getDouble("CC"));
	    	list.add(rs.getDouble("CE"));
	    	
	    	lld.add(list);
	    	list = new ArrayList();
//	    	double[] arr = new double[28];
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
//	    	arr[13] = rs.getDouble("AK");
//	    	arr[14] = rs.getDouble("AN");
//	    	arr[15] = rs.getDouble("AQ");
//	    	arr[16] = rs.getDouble("AT");
//	    	arr[17] = rs.getDouble("AW");
//	    	arr[18] = rs.getDouble("AZ");
//	    	arr[19] = rs.getDouble("BC");
//	    	arr[20] = rs.getDouble("BF");
//	    	arr[21] = rs.getDouble("BI");
//	    	arr[22] = rs.getDouble("BL");
//	    	arr[23] = rs.getDouble("BO");
//	    	arr[24] = rs.getDouble("BR");
//	    	arr[25] = rs.getDouble("BW");
//	    	arr[26] = rs.getDouble("BZ");
//	    	arr[27] = rs.getDouble("CC");
//	    	arr[28] = rs.getDouble("CE");
//
//	    	lld.add(arr);	   	    
	    }
	    
	    co1.close();
	    return lld;
	}
	
	
	/*
	//����ԭʼ���ݣ�ȡԭʼ���ݵ�logֵ
	public List<List<Double>> getLog(List<List<Double>> logd){
		List<List<Double>> lldd = new ArrayList<>();
		List<Double> ld = new ArrayList<Double>();
		double x = 0;
		//System.out.println(logd.get(0).toString());
		for(int i=0;i<logd.size();i++){
			for(int j=0;j<logd.get(0).size();j++){
				if(logd.get(i).get(j)>0){
				    x = Math.log(logd.get(i).get(j));
				}
				if(logd.get(i).get(j)==0){
					x=0;
				}
				if(logd.get(i).get(j)<0){
					x = -(Math.log(-logd.get(i).get(j)));
				}
				ld.add(x);
			}
			lldd.add(ld);
			ld = new ArrayList<Double>();
		}
		return lldd;
	}
	*/
	
	/*
	//������������ݵ�logֵд�����ݿ�
	public void setLogValue(List<List<Double>> lld) throws ClassNotFoundException, SQLException{
		Connection co2 = design.connectDatabase();
		String s = "insert logAll(A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,"
				+ "AA,AB,AC,AD,AE,AF,AG,AH,AI,AJ,AK,AL,AM,AN,AO,AP,AQ,AR,ASS,AT,AU,AV,AW,AX,AY,AZ,"
				+ "BA,BB,BC,BD,BE,BF,BG,BH,BI,BJ,BK,BL,BM,BN,BO,BP,BQ,BR,BS,BT,BU,BV,BW,BX,BYY,BZ,"
				+ "CA,CB,CC,CE,CF,CG) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = co2.prepareStatement(s);
		for(int i=0;i<2923;i++){
			for(int j=0;j<84;j++){
				ps.setDouble(j+1, lld.get(i).get(j));
				
			}
			ps.execute();
		}
		co2.close();
	}
	*/
	
	/*
	//��ȡÿһ��ָ��������Сֵ
	public List<Double> getMaxAndMin() throws ClassNotFoundException, SQLException{
		//List<List<Double>> lldd = new ArrayList<>();
		List<Double> list = new ArrayList<Double>();
		String s1= "select max(ab),max(ac),max(ad),max(ae),max(af),max(ag),max(ah),max(ai),max(aj),max(ak),max(al),max(am) from sheet20";
		String s2= "select min(ab),min(ac),min(ad),min(ae),min(af),min(ag),min(ah),min(ai),min(aj),min(ak),min(al),min(am) from sheet20";
		Connection co2 = design.connectDatabase();
		Statement sm = co2.createStatement();
		ResultSet rs = sm.executeQuery(s1);

	}
	*/
	
	/*
	//����ԭʼ���ݣ�����min-max��һ��������x=��x-min��/��max-min��
	public List<List<Double>> Guiyihua(List<List<Double>> logd){
		List<List<Double>> lldd = new ArrayList<>();
		List<Double> ld = new ArrayList<Double>();
//		double[] max = {519.5651,707.5478,356.0487,7222.9197,22716.2408,16653.0738,1.916,14.8696,15.3829,277858.2863,82996.0924,141039.4947};//ab--am
//		double[] min = {-14055.2312,-108850.8561,-71251.7448,-13881.7136,-108340.7849,-71166.1499,-14.2288,-13.0474,-10.3812,-132701.4793,-262982.7837,-32364.4195 };
//		double[] max = {81800,1460,222.1634,6.6235,1.336,1,2.758,1.8708};//br--cb(��ȥ2013��)
//		double[] min = {0,0,-4.3349,-6.0965,0,0,-0.336,0};
		double[] max = {707.5478,356.0487,22716.2408,16653.0738,14.8696,15.3829,82996.0924,141039.4947};//ab--am(��ȥ2013��)
		double[] min = {-108850.8561,-71251.7448,-108340.7849,-71166.1499,-13.0474,-10.3812,-262982.7837,-32364.4195 };
		
		double x = 0;
		//System.out.println(logd.get(0).get(1));
		for(int i=0;i<8;i++){
			for(int j=0;j<2923;j++){
				double a = (logd.get(j).get(i)-min[i])/(max[i]-min[i]);
				//System.out.println(a);
				ld.add(a);//ld�洢����һ��ָ��ֵ��2923������
			}
			lldd.add(ld);//lldd�洢����12��ָ��ֵ�б���12��ld
			ld = new ArrayList<Double>();
			
		}
		return lldd;
	}
	*/
	
	/*
	//ת��lldd
	public List<List<Double>> reTransposition2(List<List<Double>> lldu){
		 List<List<Double>> lldl = new ArrayList<>();
		 List<Double> le = new ArrayList<>();
		
		 for(int i=0;i<2923;i++){
			    for(int j=0;j<8;j++){
				    le.add(lldu.get(j).get(i));
				    //System.out.println(le.toString());
			    }
			    lldl.add(le);
			    le = new ArrayList<Double>();
		}
		 //System.out.println(lldl.get(0).toString());
		 return lldl;
	}
	*/
	
	/*
	//��ת��֮������ݲ������ݿ�
	public void setGYHtoDB(List<List<Double>> lld) throws ClassNotFoundException, SQLException{
		Connection co =  design.connectDatabase(); 
		String s1 = "create table guiyihua(BS double(16,8),BT double(16,8),BU double(16,8),BV double(16,8),BX double(16,8),BYY double(16,8),CA double(16,8),CB double(16,8))";
		Statement stmt=co.createStatement();
		stmt.executeUpdate(s1);
		String s2 = "insert into guiyihua values(?,?,?,?,?,?,?,?)";
		int count = 0;
		co.setAutoCommit(false);
		PreparedStatement ps = co.prepareStatement(s2);
		for(int i=0;i<2923;i++){
		   ps.setDouble(1, lld.get(i).get(0));
		   ps.setDouble(2, lld.get(i).get(1));
		   ps.setDouble(3, lld.get(i).get(2));
		   ps.setDouble(4, lld.get(i).get(3));
		   ps.setDouble(5, lld.get(i).get(4));
		   ps.setDouble(6, lld.get(i).get(5));
		   ps.setDouble(7, lld.get(i).get(6));
		   ps.setDouble(8, lld.get(i).get(7));
		   count++;
		   ps.addBatch(); 
		   if(count%1000==0){
			    ps.executeBatch();
			    co.commit();
			    ps.clearBatch();	
		    }
		   
		}
		ps.executeBatch();
		co.commit();
		ps.clearBatch();
		co.close();
	}
	*/
	
	
	//lldo�е�Ԫ����һ����¼�����ڽ�ÿ����¼�е����е�Aֵ��CGֵ���lldd�е�Ԫ�أ���lldd�д洢���м�¼�е�Aֵ��Bֵ����������CGֵ����lldd�ĳ���Ϊ85
	public static List<List<Double>> transposition(List<List<Double>> lldo){
		List<List<Double>> lldd = new ArrayList<>();
		List<Double> ld = new ArrayList<Double>();
		for(int i=0;i<lldo.get(0).size();i++){
		    for(int j=0;j<2923;j++){
			    ld.add(lldo.get(j).get(i));
		    }
		    lldd.add(ld);
		
		    ld = new ArrayList<Double>();
		}
		
		return lldd;
	}
	
//	//��2013��28��������ѡ��3����Ϊ�������ݣ�����26*27*28/6=3276��ѡ��
//		public void choose(List<List<Double>> ld) throws ClassNotFoundException, SQLException{
//			int c = 0;
//	 	    for(int i=0;i<65;i++){
//				for(int j=i+1;j<65;j++){
//					for(int k=j+1;k<65;k++){
//						//c++;
//			
//						List<List<Double>> le = new ArrayList<List<Double>>();
//					    le.add(ld.get(i));
//						le.add(ld.get(j));
//						le.add(ld.get(k));
//						List<List<Double>> l0 = reTransposition(le);
//						//create();
//			            List<Map> l1 = newCountSim(l0);     
//						newLeadingSim(l1);
//				
//					}
//				}
//	 	    }
//		}

	
	/*
    //���ѡ��lldd����Ԫ�أ���ӵ����б�llde�У�	
	public List<List<Double>> random(List<List<Double>> lldu){
	    //int a = (int)(Math.random()*10);
	    List<List<Double>> llde = new ArrayList<>();
		//List<Double> lde = new ArrayList();
		for(int i=0;i<30;i++){
			int a = (int)(Math.random()*85);
			System.out.print(a+"..."+'\n');
		    llde.add(lldu.get(a));//!!!���Ż���ȥ���б�����ͬ��Ԫ�أ���1�������a�����ֵ����ֵֵͬʱ����β��ظ���ӣ���2������ظ�����ˡ����ȥ���ظ���Ԫ��
			
		}
		return llde;
	}
	*/
	
	
	//�ٴ�ת�ã���lldu�е�Ԫ���Լ�¼����ʽ�洢�����б�lldl��
	public List<List<Double>> reTransposition(List<List<Double>> lldu){
		 List<List<Double>> lldl = new ArrayList<>();
		 List<Double> le = new ArrayList<>();
		
		 for(int i=0;i<2923;i++){
			    for(int j=0;j<3;j++){
				    le.add(lldu.get(j).get(i));
				    //System.out.println(le.toString());
			    }
			    lldl.add(le);
			    le = new ArrayList<Double>();
		}
		
		 return lldl;
	}
	
	
	//��map����value���а�ֵ����
		 public  static Map<Integer, Double> sortMap(Map<Integer, Double> oriMap) {
		        if (oriMap == null || oriMap.isEmpty()) {
		            return null;
		        }
		        Map<Integer, Double> sortedMap = new LinkedHashMap<Integer, Double>();
		        List<Map.Entry<Integer, Double>> entryList = new ArrayList<Map.Entry<Integer, Double>>(
		                oriMap.entrySet());
		        Collections.sort(entryList, new MapValueComparator());

		        Iterator<Map.Entry<Integer, Double>> iter = entryList.iterator();
		        Map.Entry<Integer, Double> tmpEntry = null;
		        while (iter.hasNext()) {
		            tmpEntry = iter.next();
		            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		        }
		        return sortedMap;
		    }
	
		 
		 
	//�������ƶ�
		//public List<List<Double>> countSim(List<List<Double>> lldde){
		public List<Map> newCountSim(List<List<Double>> lldde){
			int count=0;
			 List<Map> lldee = new ArrayList<>();
		 	 Map<Integer, Double> map = new TreeMap<Integer, Double>();
			 double sum=0;
		     double sum1=0;
		     double sim=0;
		     for(int m=0;m<lldde.size();m++){
		 	    for(int t=0;t<lldde.size();t++){
		    	    for(int n=0;n<lldde.get(0).size();n++){
				        sum = sum + Math.pow(lldde.get(m).get(n)-lldde.get(t).get(n), 2);		
				    }
		    	   // Map<Integer, Double> map = new TreeMap<Integer, Double>();
				    sum1 =  Math.sqrt(sum);
				    sim = 1/(1+sum1);
				    map.put(t, sim);
			   	    sum=0;	  
			    }
		 	   Map<Integer,Double> sortMap = sortMap(map);
		 	   Map<Integer,Double> nmap = getten(sortMap);
			   lldee.add(nmap);
			   
		    }
		     //System.out.println(lldee.toString());  
			 return lldee;
		}

	//��ȡ�������ƶ���ߵ�ǰʮ����ҵ���ƶ�
	public Map<Integer,Double> getten(Map<Integer,Double> mp){
		
		Map<Integer,Double> map = new LinkedHashMap<Integer,Double>();
	    Set set = mp.keySet();
		Iterator it = set.iterator();
		int a=0;
	    while (it.hasNext()&&a<6) {
	          int key = (int) it.next(); 
	          double value = (double) mp.get(key);
	          map.put(key, value); 
	          a++;
	        }  
	    //System.out.println(map.toString());
		return map;
	}
	
	    //�������ƶ�
		public void newLeadingSim(List<Map> lm) throws ClassNotFoundException, SQLException{
			Connection co3 =  design.connectDatabase(); 
			String insert = "INSERT NEWSIM2013(A,B,sim) VALUES(?,?,?)";
			//List<String> ss = getName();
			int count=0;
	    	int k=0;
			co3.setAutoCommit(false);
			PreparedStatement ps = co3.prepareStatement(insert);
			for(int j=0;j<lm.size();j++){
				Set<Integer> set = lm.get(j).keySet();
				Iterator<Integer> it = set.iterator();
				while(it.hasNext()){
					Integer key =  (Integer) it.next();
					double value = (double) lm.get(j).get(key);
				    ps.setInt(1,j+1 );
				    ps.setInt(2, key+1 );
				    ps.setDouble(3, value);
//				    ps.setInt(4, li.get(j));
//				    ps.setInt(5, lg.get(k));
				   // k++;
				    count++;
				    ps.addBatch(); 
				}
				    
				if(count%10000==0){
				    ps.executeBatch();
				    co3.commit();
				    ps.clearBatch();	
				}
					
			}
			//System.out.println(count);
			ps.executeBatch();
			co3.commit();
			ps.clearBatch();
			co3.close();
		}
		/*
		//ɾ����ͬ����ҵ
		public void DleteSame () throws ClassNotFoundException, SQLException{
			Connection cct = design.connectDatabase();
			String s = "delete from sheetaa where id=?";
			cct.setAutoCommit(false);
			int c=0;
			PreparedStatement ps = cct.prepareStatement(s);
			for(int i=1;i<32154;i+=11){
				ps.setInt(1, i);
				c++;
				ps.addBatch();
				if(c%100==0){
					ps.executeBatch();
			    	cct.commit();
			    	ps.clearBatch();
				}
			}
			ps.executeBatch();
			cct.commit();
			ps.clearBatch();
			cct.close();
		}
	*/
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		design ds = new design();
		//ds.drop();
		//ds.create();
		List<List<Double>> lld1 = ds.addDataToLld();
		List<List<Double>> lld2 = ds.transposition(lld1);
		List<Map> lm = ds.newCountSim(lld2);
		ds.newLeadingSim(lm);
		
	}
	

}
