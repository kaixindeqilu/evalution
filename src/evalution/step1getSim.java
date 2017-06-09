package evalution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//计算两两企业之间的相似度
public class step1getSim {
	private static final String forname = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/liulu?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	List<List<Double>> lls = new ArrayList<>();
	List<Double> list = new ArrayList<Double>();
	
	List<Double> ld2 = new ArrayList<Double>();
	List<Double> ld3 = new ArrayList<Double>();
	
	//连接数据库
		public static Connection connectDatabase() throws ClassNotFoundException, SQLException{
				
			Class.forName(forname);
			Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return con;
		}
		
		
		//添加数据库数据到list中:先获取数据库原始数据
		public List<List<Double>> SaddDataToList() throws SQLException, ClassNotFoundException{  
			Connection co1 = step1getSim.connectDatabase();
			Statement sm = co1.createStatement();
			ResultSet rs = sm.executeQuery(" SELECT * FROM sheet20");
			
		    while(rs.next()){
			   	    list.add(rs.getDouble("A"));
			    	list.add(rs.getDouble("B"));
			    	list.add(rs.getDouble("C"));
			    	list.add(rs.getDouble("D"));
			    	list.add(rs.getDouble("E"));
			    	list.add(rs.getDouble("F"));
			    	list.add(rs.getDouble("G"));
			    	list.add(rs.getDouble("H"));
			    	list.add(rs.getDouble("I"));
			    	list.add(rs.getDouble("J"));
			    	list.add(rs.getDouble("K"));
			    	list.add(rs.getDouble("L"));
			    	list.add(rs.getDouble("M"));
			    	list.add(rs.getDouble("N"));
			    	list.add(rs.getDouble("O"));
			    	list.add(rs.getDouble("P"));
			    	list.add(rs.getDouble("Q"));
			    	list.add(rs.getDouble("R"));
			    	list.add(rs.getDouble("S"));
			    	list.add(rs.getDouble("T"));
			    	list.add(rs.getDouble("U"));
			    	list.add(rs.getDouble("V"));
			    	list.add(rs.getDouble("W"));
			    	list.add(rs.getDouble("X"));
			    	list.add(rs.getDouble("Y"));
			    	list.add(rs.getDouble("Z"));
			    	list.add(rs.getDouble("AA"));
			    	list.add(rs.getDouble("AB"));
			    	list.add(rs.getDouble("AC"));
			    	list.add(rs.getDouble("AD"));
			    	list.add(rs.getDouble("AE"));
			    	list.add(rs.getDouble("AF"));
			    	list.add(rs.getDouble("AG"));
			    	list.add(rs.getDouble("AH"));
			    	list.add(rs.getDouble("AI"));
			    	list.add(rs.getDouble("AJ"));
			    	list.add(rs.getDouble("AK"));
			    	list.add(rs.getDouble("AL"));
			    	list.add(rs.getDouble("AM"));
			    	list.add(rs.getDouble("AN"));
			    	list.add(rs.getDouble("AO"));
			    	list.add(rs.getDouble("AP"));
			    	list.add(rs.getDouble("AQ"));
			    	list.add(rs.getDouble("AR"));
			    	list.add(rs.getDouble("ASS"));
			    	list.add(rs.getDouble("AT"));
			    	list.add(rs.getDouble("AU"));
			    	list.add(rs.getDouble("AV"));
			    	list.add(rs.getDouble("AW"));
			    	list.add(rs.getDouble("AX"));
			    	list.add(rs.getDouble("AY"));
			    	list.add(rs.getDouble("AZ"));
			    	list.add(rs.getDouble("BA"));
			    	list.add(rs.getDouble("BB"));
			    	list.add(rs.getDouble("BC"));
			    	list.add(rs.getDouble("BD"));
			    	list.add(rs.getDouble("BE"));
			    	list.add(rs.getDouble("BF"));
			    	list.add(rs.getDouble("BG"));
			    	list.add(rs.getDouble("BH"));
			    	list.add(rs.getDouble("BI"));
			    	list.add(rs.getDouble("BJ"));
			    	list.add(rs.getDouble("BK"));
			    	list.add(rs.getDouble("BL"));
			    	list.add(rs.getDouble("BM"));
			    	list.add(rs.getDouble("BN"));
			    	list.add(rs.getDouble("BO"));
			    	list.add(rs.getDouble("BP"));
			    	list.add(rs.getDouble("BQ"));
			    	list.add(rs.getDouble("BR"));
			    	list.add(rs.getDouble("BS"));
			    	list.add(rs.getDouble("BT"));
			    	list.add(rs.getDouble("BU"));
			    	list.add(rs.getDouble("BV"));
			    	list.add(rs.getDouble("BW"));
			    	list.add(rs.getDouble("BX"));
			    	list.add(rs.getDouble("BYY"));
			    	list.add(rs.getDouble("BZ"));
			    	list.add(rs.getDouble("CA"));
			    	list.add(rs.getDouble("CB"));
			    	list.add(rs.getDouble("CC"));
			    	//list.add(rs.getDouble("CD"));
			    	list.add(rs.getDouble("CE"));
			    	list.add(rs.getDouble("CF"));
			    	list.add(rs.getDouble("CG"));
    
			        lls.add(list);
		            list = new ArrayList<Double>();  	
			    	
	           }
		   
			    co1.close();
			    return lls;
		}
		
		//获取所有公司的名字
		public List<String> SgetCompanyNames() throws ClassNotFoundException, SQLException{
			List<String> list = new ArrayList<String>();
			Connection co2 =  step1getSim.connectDatabase(); 
			Statement sm = co2.createStatement();
			ResultSet rs = sm.executeQuery(" SELECT * FROM sheet2 WHERE id<2924");
	        //先获取数据库的原始数据
		    while(rs.next()){
		    	list.add(rs.getString("name"));
		    }
		    co2.close();
		    return list;
	    }
		
		/***处理数据，先计算两两之间的距离，这里计算欧几里得距离，公式为：d(x,y)=sqrt(sum((xi-yi)^2))，将距离值存储在List<List<Double> lld1里；
                                         再计算两两用户之间的相似度，这里采用公式：sim(x,y)=1/(1+d(x,y))，将相似度值存储在List<Double>里                     
        ***/
		
    public List<List<Double>> SactionData(List<List<Double>> lldd){
	    List<List<Double>> lld = new ArrayList<>();
	    List<Double> ld1 = new ArrayList<Double>();
	    double sum=0;
	    double sum1=0;
	    double sim=0;
	    for(int m=0;m<lldd.size();m++){
		    for(int t=0;t<lldd.size();t++){
		        for(int n=0;n<lldd.get(m).size();n++){
		    	    sum = sum + Math.pow(lldd.get(m).get(n)-lldd.get(t).get(n), 2);	
		    	
		            }
		        sum1 =  Math.sqrt(sum);
		        sim = 1/(1+sum1);
	    	    ld1.add(sim);  
	    	    sum=0;	
		    }
		    lld.add(ld1);
		    ld1 = new ArrayList<Double>();
	    }
	    return lld;
    }
    
    
    
    public void SsetDataToDB(List<String> ls,List<List<Double>> ld) throws ClassNotFoundException, SQLException{
		Connection co3 =  step1getSim.connectDatabase(); 
		String insert = "INSERT newsim1 (A, B,sim) VALUES(?,?,?)";
		int count=0;
		co3.setAutoCommit(false);
		PreparedStatement ps = co3.prepareStatement(insert);
		for(int i=0;i<ls.size();i++){
			for(int j=0;j<ls.size();j++){
			    ps.setInt(1, i+1);
			    ps.setInt(2, j+1);
			    ps.setDouble(3, ld.get(i).get(j));
			    count++;
			    ps.addBatch(); 
			    //ps.execute();
			    
			    if(count%10000==0){
			    	ps.executeBatch();
			    	co3.commit();
			    	ps.clearBatch();
			    	
			    	
			    }
			    
			}
			
		}
		//System.out.println(count);
		ps.executeBatch();
		co3.commit();
		ps.clearBatch();
		co3.close();
		
	}
	
}
