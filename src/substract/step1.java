package substract;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class step1 {
	private static final String forname = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/liulu?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	
	//连接数据库
	public static Connection connectDatabase() throws ClassNotFoundException, SQLException{				
		Class.forName(forname);
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return con;
	}
	
	//获取数据库数据表originData的数据
	public List<List<Double>> getData() throws SQLException, ClassNotFoundException{  
	//public void getData() throws SQLException, ClassNotFoundException{  
		Connection co1 = step1.connectDatabase();
		List<List<Double>> lldl = new ArrayList<>();
		List<String> list = new ArrayList<String>();
		List<Double> listt = new ArrayList<Double>();
		
		//获取数据表的列名称：resultsetmetadata方法
		String str = "select * from originData";
		Statement st = co1.createStatement();
		ResultSet rs = st.executeQuery(str);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnSize = rsmd.getColumnCount();
		for(int i=1;i<columnSize;i++){               //注！这里i从1开始
			list.add(rsmd.getColumnName(i));
			//System.out.println(rsmd.getColumnName(i));
		}
		
		//获取对应列名下的具体数据
		Statement st1 = co1.createStatement();
		for(int j=0;j<list.size();j++){
			//String s = "select"+"'"+list.get(j)+"'"+"from originData";//为什么用preparedstatement,statement都会报错？？？
			ResultSet rs1 = st1.executeQuery(str);//?????????????????????????????
			while(rs1.next()){
				listt.add(rs1.getDouble(list.get(j)));//resultset是怎样存储查询结果的？以列存储吗？？？？？？？？？？？？？？
			}
			lldl.add(listt);
			listt = new ArrayList<Double>();
		}
		co1.close();
		return lldl;
	}
		
	//计算不同年度数据之间的差值（增长速度）
	public List<List<Double>> getSub(List<List<Double>> lld){
		List<List<Double>> lldd = new ArrayList<List<Double>>();//lldd存储lld中每三个元素(分别对应每个指标2013,2014,2015年度的值)，计算之后，清零，继续存储下一个三个元素，知道lld最后的元素
		List<List<Double>> lladd = new ArrayList<List<Double>>();//lladd存储ld，即lladd的每个元素都是一个差值列表，如它的第一个元素就是lldd中元素1与元素0的差值列表
		List<Double> ld = new ArrayList<Double>();//ld存储lldd中后一个元素减去前一个元素的差值，然后清零，继续存储下一列差值，因为lldd中只有三个元素，所以ld只需存储两次
		
		for(int i=0;i<lld.size();i++){
			lldd.add(lld.get(i));
			if((i+1)%3==0){
				for(int j=0;j+1<3;j++){
					for(int k=0;k<lldd.get(j).size();k++){
						double x = lldd.get(j+1).get(k)-lldd.get(j).get(k);
						BigDecimal b = new BigDecimal(x);	
				    	double f = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue(); 
						ld.add(f);	
					}
					lladd.add(ld);
					ld = new ArrayList<Double>();
				}
				lldd = new ArrayList<List<Double>>();
			}
		}
	
		return lladd;
	}
	
	
	//将lladd的元素写入表sub1
	public void setData(List<List<Double>> lld) throws ClassNotFoundException, SQLException{
		Connection co2 = step1.connectDatabase();
		/*
		//lld的元素是每三列中，前后两列的差值，是纵向值，为了将一条记录一次性写入数据库，新建llde存储横向值，如将lld中所有元素的第一个元素组成一个列表lde作为凉凉的的第一个元素
     	List<List<Double>>  llde = new ArrayList();
     	List<Double> lde = new ArrayList();
     	for(int i=0;i<lld.size();i++){
            for(int j=0;j<lld.get(i).size();j++){
            	lde.add(lld.get(j).get(i));
            }
            llde.add(lde);
            lde = new ArrayList();
     	}
     	*/
	
		String ss = "insert sub2 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//如何将完整的记录一次性写入？？？
		PreparedStatement pss = co2.prepareStatement(ss);
		for(int j=0;j<lld.get(0).size();j++){
			for(int i=0;i<lld.size();i++){
				pss.setDouble(i+1, lld.get(i).get(j));
				
			}
			pss.execute();
		}
		co2.close();
	}
    
	
}
