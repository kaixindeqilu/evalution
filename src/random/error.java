package random;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class error {
	 public List<Integer> countError() throws ClassNotFoundException, SQLException{
			
			List<Integer> l1 = new ArrayList<Integer>();
			List<Integer> l2 = new ArrayList<Integer>();
			List<Integer> list = new ArrayList<Integer>();
			
			Connection ce = design.connectDatabase();
			Statement esm = ce.createStatement();
			ResultSet rs = esm.executeQuery(" SELECT substract FROM part1");
			while(rs.next()){
				l1.add(rs.getInt("substract"));
			
			}
			
			int count1=0;
			int a=0;
			for(int i=0;i<l1.size();i+=10){
				for(int j=i;j<l1.size();j++){             //注！为什么循环条件为j<j+10是错误的，因为当j不断增加时，j+10也是不断增加的
				    a = a + Math.abs(l1.get(j)-l2.get(j));
				    count1++;
				    if(count1%10==0){
				    	break;
				    }
				}
			
				list.add(a);
				a=0;		
			}
			
			ce.close();
			return list;
		}
		
	 /*
		//计算误差概率
		public List<Double> getProbility(List<Integer> err,List<Integer> plli){
			
			List<Double> pld1 = new ArrayList<Double>();	
		    double aa=0;
		    int x = err.size();
		    int y = plli.size();
		 
		    for(int v=0;v<err.size();v++){
			    aa=(double)err.get(v)/(plli.get(v)*10);//注！因为err的元素是整型，如果不加强制转换，回四舍五入输出整型
			    BigDecimal b = new BigDecimal(aa);	
		    	double ff1 = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
				pld1.add(ff1);		
			}
		    return pld1;
		}
		*/
		
		//将最终的误差比率写入表误差中
		public void setError(List<Integer> ld) throws ClassNotFoundException, SQLException{
		    Connection ce1 = design.connectDatabase();
		    String ss = "insert part1(substract) values(?)";
		    PreparedStatement sps = ce1.prepareStatement(ss);
		    for(int i=0;i<2923;i++){
		    	sps.setInt(1, ld.get(i));
			    sps.execute();
		    }
		    ce1.close();
		}
		
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException{
			error er = new error();
			design ds = new design();
			List<Integer> li = er.countError();
			//List<Integer> lii = ds.readNumber2013();
			//List<Double> ld = er.getProbility(li, lii);
			//List<String> ls = ds.getName();
			er.setError(li);
		}
		

}
