package substract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class step2 {
	public List<List<Double>> getdatafromsub1() throws ClassNotFoundException, SQLException{
		List<List<Double>> lls = new ArrayList<>();
		List<Double> list = new ArrayList<Double>();
		Connection co1 = step1.connectDatabase();
		Statement sm = co1.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM sub1");
		while(rs.next()){
			list.add(rs.getDouble("a14-13"));
	    	list.add(rs.getDouble("a15-14"));
	    	list.add(rs.getDouble("b14-13"));
	    	list.add(rs.getDouble("b15-14"));
	    	list.add(rs.getDouble("c14-13"));
	    	list.add(rs.getDouble("c15-14"));
	    	list.add(rs.getDouble("d14-13"));
	    	list.add(rs.getDouble("d15-14"));
	    	list.add(rs.getDouble("e14-13"));
	    	list.add(rs.getDouble("e15-14"));
	    	list.add(rs.getDouble("f14-13"));
	    	list.add(rs.getDouble("f15-14"));
	    	list.add(rs.getDouble("g14-13"));
	    	list.add(rs.getDouble("g15-14"));
	    	list.add(rs.getDouble("h14-13"));
	    	list.add(rs.getDouble("h15-14"));
	    	list.add(rs.getDouble("i14-13"));
	    	list.add(rs.getDouble("i15-14"));
	    	list.add(rs.getDouble("j14-13"));
	    	list.add(rs.getDouble("j15-14"));
	    	list.add(rs.getDouble("k14-13"));
	    	list.add(rs.getDouble("k15-14"));
	    	list.add(rs.getDouble("l14-13"));
	    	list.add(rs.getDouble("l15-14"));
	    	list.add(rs.getDouble("m14-13"));
	    	list.add(rs.getDouble("m15-14"));
	    	list.add(rs.getDouble("n14-13"));
	    	list.add(rs.getDouble("n15-14"));
	    	list.add(rs.getDouble("o14-13"));
	    	list.add(rs.getDouble("o15-14"));
	    	list.add(rs.getDouble("p14-13"));
	    	list.add(rs.getDouble("p15-14"));
	    	list.add(rs.getDouble("q14-13"));
	    	list.add(rs.getDouble("q15-14"));
	    	list.add(rs.getDouble("r14-13"));
	    	list.add(rs.getDouble("r15-14"));
	    	list.add(rs.getDouble("s14-13"));
	    	list.add(rs.getDouble("s15-14"));
	    	list.add(rs.getDouble("t14-13"));
	    	list.add(rs.getDouble("t15-14"));
	    	list.add(rs.getDouble("u14-13"));
	    	list.add(rs.getDouble("u15-14"));
	    	list.add(rs.getDouble("v14-13"));
	    	list.add(rs.getDouble("v15-14"));
	    	list.add(rs.getDouble("w14-13"));
	    	list.add(rs.getDouble("w15-14"));
	    	list.add(rs.getDouble("x14-13"));
	    	list.add(rs.getDouble("x15-14"));
	    	list.add(rs.getDouble("y14-13"));
	    	list.add(rs.getDouble("y15-14"));
	    	list.add(rs.getDouble("z14-13"));
	    	list.add(rs.getDouble("z15-14"));
	    	list.add(rs.getDouble("aa14-13"));
	    	list.add(rs.getDouble("aa15-14"));
	    	list.add(rs.getDouble("ab14-13"));
	    	list.add(rs.getDouble("ab15-14"));
	    	
	    	lls.add(list);
			list = new ArrayList<Double>();
		}
		co1.close();
		return lls;
		
	}
	
	public List<String> SgetCompanyNames() throws ClassNotFoundException, SQLException{
		List<String> list = new ArrayList<String>();
		Connection co2 =  step1.connectDatabase(); 
		Statement sm = co2.createStatement();
		ResultSet rs = sm.executeQuery(" SELECT * FROM sheet2 WHERE id<2924");
        //先获取数据库的原始数据
	    while(rs.next()){
	    	list.add(rs.getString("name"));
	    }
	    co2.close();
	    return list;
    }
	
	public List<List<Double>> actionData(List<List<Double>> lldd){
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
		Connection co3 =  step1.connectDatabase(); 
		String insert = "INSERT speedsim (A, B,sim) VALUES(?,?,?)";
		int count=0;
		co3.setAutoCommit(false);
		PreparedStatement ps = co3.prepareStatement(insert);
		for(int i=0;i<ls.size();i++){
			for(int j=0;j<ls.size();j++){
			    ps.setString(1, ls.get(i));
			    ps.setString(2, ls.get(j));
			    ps.setDouble(3, ld.get(i).get(j));
			    count++;
			    ps.addBatch(); 
			    //ps.execute();
				    
			    if(count%100000==0){
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
