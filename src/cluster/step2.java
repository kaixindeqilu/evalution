package cluster;

import random.design;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lulu on 2017/12/18.
 */

//取随机数
public class step2 {
    //获取目标企业及其相似企业对于所有指标的平均值
    public static double getAvg(int val) throws SQLException, ClassNotFoundException {
        Connection con = design.connectDatabase();
        Statement sm = con.createStatement();
        ResultSet rs = sm.executeQuery(" SELECT * FROM newlishuqing2 WHERE id ="+ val );
        List<Double> list = new ArrayList<Double>();
        while (rs.next()){
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
           // list.add(rs.getDouble("BS"));
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
            list.add(rs.getDouble("CD"));
            list.add(rs.getDouble("CE"));
            list.add(rs.getDouble("CF"));
            list.add(rs.getDouble("CG"));
            list.add(rs.getDouble("CH"));
            list.add(rs.getDouble("CI"));
            list.add(rs.getDouble("CJ"));
            list.add(rs.getDouble("CK"));
            list.add(rs.getDouble("CL"));
            list.add(rs.getDouble("CM"));
            list.add(rs.getDouble("CN"));
            list.add(rs.getDouble("CO"));
            list.add(rs.getDouble("CP"));
            list.add(rs.getDouble("CQ"));
            list.add(rs.getDouble("CR"));
            list.add(rs.getDouble("CS"));
            list.add(rs.getDouble("CT"));
            list.add(rs.getDouble("CU"));
            list.add(rs.getDouble("CV"));
            list.add(rs.getDouble("CW"));
            list.add(rs.getDouble("CX"));
            list.add(rs.getDouble("CY"));
            list.add(rs.getDouble("CZ"));
            list.add(rs.getDouble("DA"));
            list.add(rs.getDouble("DB"));
            list.add(rs.getDouble("DC"));
            list.add(rs.getDouble("DD"));
            list.add(rs.getDouble("DE"));
            list.add(rs.getDouble("DF"));
            list.add(rs.getDouble("DG"));
            list.add(rs.getDouble("DH"));
            list.add(rs.getDouble("DI"));
            list.add(rs.getDouble("DJ"));
            list.add(rs.getDouble("DK"));
            list.add(rs.getDouble("DL"));
            list.add(rs.getDouble("DM"));
            list.add(rs.getDouble("DN"));
            list.add(rs.getDouble("DO"));
            list.add(rs.getDouble("DP"));
            list.add(rs.getDouble("DQ"));
            list.add(rs.getDouble("DR"));
            list.add(rs.getDouble("DS"));
            list.add(rs.getDouble("DT"));
            list.add(rs.getDouble("DU"));
            list.add(rs.getDouble("DV"));
            list.add(rs.getDouble("DW"));
            list.add(rs.getDouble("DX"));
            list.add(rs.getDouble("DY"));
            list.add(rs.getDouble("DZ"));
            list.add(rs.getDouble("EA"));
            list.add(rs.getDouble("EB"));
            list.add(rs.getDouble("EC"));
            list.add(rs.getDouble("ED"));
            list.add(rs.getDouble("EE"));
            list.add(rs.getDouble("EF"));
            list.add(rs.getDouble("EG"));
            list.add(rs.getDouble("EH"));
            list.add(rs.getDouble("EI"));
            list.add(rs.getDouble("EJ"));
            list.add(rs.getDouble("EK"));
            list.add(rs.getDouble("EL"));
            list.add(rs.getDouble("EM"));
            list.add(rs.getDouble("EN"));
            list.add(rs.getDouble("EO"));
            list.add(rs.getDouble("EP"));
            list.add(rs.getDouble("EQ"));
            list.add(rs.getDouble("ER"));
            list.add(rs.getDouble("ES"));
            list.add(rs.getDouble("ET"));
            list.add(rs.getDouble("EU"));
            list.add(rs.getDouble("EV"));
        }
        double sum = 0;
        double avg = 0;
        for (int i = 0;i < list.size();i++){
            sum += list.get(i);
        }
        avg = sum/list.size();
        con.close();
        return avg;
    }

//    //获取目标企业的相似企业
//    public List<Integer> getComp() throws SQLException, ClassNotFoundException {
//        Connection con = design.connectDatabase();
//        Statement sm = con.createStatement();
//        ResultSet rs = sm.executeQuery(" SELECT B FROM part3 WHERE A = 2035" );
//        List<Integer> list = new ArrayList<>();
//        while (rs.next()){
//            list.add(rs.getInt("B"));
//        }
//        con.close();
//        return list;
//    }

    //获取目标企业的相似企业
    public List<Integer> getComp(int a) throws SQLException, ClassNotFoundException {
        Connection con = design.connectDatabase();
        Statement sm = con.createStatement();
        ResultSet rs = sm.executeQuery(" SELECT B FROM part6 WHERE A = " + a );
        List<Integer> list = new ArrayList<>();
        while (rs.next()){
            list.add(rs.getInt("B"));
        }
        con.close();
        return list;
    }

    public List<Double> getAvgs(int a) throws SQLException, ClassNotFoundException {
        List<Integer> listComp = getComp(a);
        List<Double> listAvg = new ArrayList<>();
        for (int i = 0;i < listComp.size();i++){
            double avg = getAvg(listComp.get(i));
            listAvg.add(avg);
        }
        return listAvg;
    }

}
