package evalution;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//计算误差率
public class step5countErrorPro {
	public List<List<Integer>> countError() throws ClassNotFoundException, SQLException{
		List<List<Integer>> error = new ArrayList<List<Integer>>();		
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<Integer> l4 = new ArrayList<Integer>();
		List<Integer> l5 = new ArrayList<Integer>();
		List<Integer> l6 = new ArrayList<Integer>();
		List<Integer> l7 = new ArrayList<Integer>();
		List<Integer> l8 = new ArrayList<Integer>();
		List<Integer> l9 = new ArrayList<Integer>();
		int a=0;
		int b=0;
		int c=0;
		
		Connection ce = step1getSim.connectDatabase();
		Statement esm = ce.createStatement();
		ResultSet rs = esm.executeQuery(" SELECT 2013A,2013B,2014A,2014B,2015A,2015B FROM result1_copy ");
		while(rs.next()){
			l1.add(rs.getInt("2013A"));
		    l2.add(rs.getInt("2013B"));
		    l3.add(rs.getInt("2014A"));
		    l4.add(rs.getInt("2014B"));
		    l5.add(rs.getInt("2015A"));
		    l6.add(rs.getInt("2015B"));
		}
		//System.out.println(l2.get(l2.size()-1));
		//System.out.println(l5.toString());
		//System.out.println(l6.toString());
		
		//l7存储2013年度企业之间的误差绝对值之和
		int count1=0;
		for(int i=0;i<l1.size();i+=10){
			for(int j=i;j<l1.size();j++){             //注！为什么循环条件为j<j+10是错误的，因为当j不断增加时，j+10也是不断增加的
			    a = a + Math.abs(l1.get(j)-l2.get(j));
			    count1++;
			    if(count1%10==0){
			    	break;
			    }
			    //System.out.println(count);
			   // System.out.println(a);   
			}
		
			l7.add(a);
			a=0;
			
		}
		//System.out.println(l7.toString());	
		
		//l8存储2014年度企业之间的误差绝对值之和
		int count2=0;
		for(int i=0;i<l3.size();i+=10){
			for(int j=i;j<l3.size();j++){
			    b = b + Math.abs(l3.get(j)-l4.get(j));
			    count2++;
			    if(count2%10==0){
			    	break;
			    }
			    
			}
			l8.add(b);
			b=0;
		}
		//System.out.println(l8.toString());	
		
		//l8存储2015年度企业之间的误差绝对值之和
		int count3=0;
		for(int i=0;i<l5.size();i+=10){
			for(int j=i;j<l5.size();j++){
			    c = c + Math.abs(l5.get(j)-l6.get(j));
			    count3++;
			    if(count3%10==0){
			    	break;
			    }
			    
			}
			l9.add(c);
			c=0;
		}
		//System.out.println(l9.toString());	
		
		error.add(l7);
		error.add(l8);
		error.add(l9);
		
		return error;
		
	}
	
	//计算平均误差概率
	public List<List<Double>> getProbility(List<List<Integer>> err,List<List<Integer>> plli){
		List<List<Double>> plld = new ArrayList<List<Double>>();
		List<Double> pld1 = new ArrayList<Double>();
		List<Double> pld2 = new ArrayList<Double>();
		List<Double> pld3 = new ArrayList<Double>();
		double aa=0;
		double bb=0;
		double cc=0;
	
	    for(int v=0;v<err.get(0).size();v++){
		    aa=(double)err.get(0).get(v)/(plli.get(v).get(0)*10);//注！因为err的元素是整型，如果不加强制转换，回四舍五入输出整型
		    BigDecimal b = new BigDecimal(aa);	
	    	double ff1 = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			pld1.add(ff1);		
		}
	   // System.out.println(pld1.toString());
	    
	    for(int v=0;v<err.get(1).size();v++){
		    bb=(double)err.get(1).get(v)/(plli.get(v).get(1)*10);
		    BigDecimal b = new BigDecimal(bb);	
	    	double ff2 = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			pld2.add(ff2);		
		}
	    //System.out.println(pld2.toString());	
	    
	    for(int v=0;v<err.get(2).size();v++){
		    cc=(double)err.get(2).get(v)/(plli.get(v).get(2)*10);
		    BigDecimal b = new BigDecimal(cc);	
	    	double ff3 = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			pld3.add(ff3);		
		}
	    //System.out.println(pld3.toString());	
	    
	    plld.add(pld1);
	    plld.add(pld2);
	    plld.add(pld3);
	    
		return plld;
	}
	
	//将最终的误差比率写入表误差中
	public void setError(List<List<Double>> slld,List<String> sls) throws ClassNotFoundException, SQLException{
	    Connection ce1 = step1getSim.connectDatabase();
	    String ss = "insert newwucha values(?,?,?,?)";
	    PreparedStatement sps = ce1.prepareStatement(ss);
	    for(int i=0;i<2923;i++){
	    	sps.setString(1, sls.get(i));
	    	sps.setDouble(2, slld.get(0).get(i));
	    	sps.setDouble(3, slld.get(1).get(i));
	    	sps.setDouble(4, slld.get(2).get(i));
	    	sps.execute();
	    }
	    ce1.close();
	}
	

}
