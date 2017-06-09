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
	
	//�������ݿ�
	public static Connection connectDatabase() throws ClassNotFoundException, SQLException{				
		Class.forName(forname);
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return con;
	}
	
	//��ȡ���ݿ����ݱ�originData������
	public List<List<Double>> getData() throws SQLException, ClassNotFoundException{  
	//public void getData() throws SQLException, ClassNotFoundException{  
		Connection co1 = step1.connectDatabase();
		List<List<Double>> lldl = new ArrayList<>();
		List<String> list = new ArrayList<String>();
		List<Double> listt = new ArrayList<Double>();
		
		//��ȡ���ݱ�������ƣ�resultsetmetadata����
		String str = "select * from originData";
		Statement st = co1.createStatement();
		ResultSet rs = st.executeQuery(str);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnSize = rsmd.getColumnCount();
		for(int i=1;i<columnSize;i++){               //ע������i��1��ʼ
			list.add(rsmd.getColumnName(i));
			//System.out.println(rsmd.getColumnName(i));
		}
		
		//��ȡ��Ӧ�����µľ�������
		Statement st1 = co1.createStatement();
		for(int j=0;j<list.size();j++){
			//String s = "select"+"'"+list.get(j)+"'"+"from originData";//Ϊʲô��preparedstatement,statement���ᱨ������
			ResultSet rs1 = st1.executeQuery(str);//?????????????????????????????
			while(rs1.next()){
				listt.add(rs1.getDouble(list.get(j)));//resultset�������洢��ѯ����ģ����д洢�𣿣�������������������������
			}
			lldl.add(listt);
			listt = new ArrayList<Double>();
		}
		co1.close();
		return lldl;
	}
		
	//���㲻ͬ�������֮��Ĳ�ֵ�������ٶȣ�
	public List<List<Double>> getSub(List<List<Double>> lld){
		List<List<Double>> lldd = new ArrayList<List<Double>>();//lldd�洢lld��ÿ����Ԫ��(�ֱ��Ӧÿ��ָ��2013,2014,2015��ȵ�ֵ)������֮�����㣬�����洢��һ������Ԫ�أ�֪��lld����Ԫ��
		List<List<Double>> lladd = new ArrayList<List<Double>>();//lladd�洢ld����lladd��ÿ��Ԫ�ض���һ����ֵ�б������ĵ�һ��Ԫ�ؾ���lldd��Ԫ��1��Ԫ��0�Ĳ�ֵ�б�
		List<Double> ld = new ArrayList<Double>();//ld�洢lldd�к�һ��Ԫ�ؼ�ȥǰһ��Ԫ�صĲ�ֵ��Ȼ�����㣬�����洢��һ�в�ֵ����Ϊlldd��ֻ������Ԫ�أ�����ldֻ��洢����
		
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
	
	
	//��lladd��Ԫ��д���sub1
	public void setData(List<List<Double>> lld) throws ClassNotFoundException, SQLException{
		Connection co2 = step1.connectDatabase();
		/*
		//lld��Ԫ����ÿ�����У�ǰ�����еĲ�ֵ��������ֵ��Ϊ�˽�һ����¼һ����д�����ݿ⣬�½�llde�洢����ֵ���罫lld������Ԫ�صĵ�һ��Ԫ�����һ���б�lde��Ϊ�����ĵĵ�һ��Ԫ��
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
	
		String ss = "insert sub2 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//��ν������ļ�¼һ����д�룿����
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
