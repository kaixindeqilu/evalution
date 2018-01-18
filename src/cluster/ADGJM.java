package cluster;

import random.design;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lulu on 2017/6/20.
 */
public class ADGJM {
    public List<List<Double>> getADGJM() throws ClassNotFoundException, SQLException {
        List<List<Double>> lld = new ArrayList<List<Double>>();
        List<Double> list = new ArrayList<Double>();
        Connection con = design.connectDatabase();
        Statement sm = con.createStatement();
        ResultSet rs = sm.executeQuery(" SELECT * FROM logall");
        while (rs.next()) {
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

            lld.add(list);
            list = new ArrayList<Double>();
        }
        return lld;
    }
    //转换数据为1-10的评分
    public List<List<Integer>> tranToInt(List<List<Double>> lld){
        List<List<Integer>> lli = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        for (int i = 0;i < lld.size();i++){
            for (int j = 0;j < lld.get(0).size();j++){
                double value = lld.get(i).get(j);
                if (value==0){
                    li.add(0);
                }
                if (value>8&&value<10){
                    li.add(1);
                }
                if (value>6&&value<=8){
                    li.add(2);
                }
                if (value>4&&value<=6){
                    li.add(3);
                }
                if (value>2&&value<=4){
                    li.add(4);
                }
                if (value>0&&value<=2){
                    li.add(5);
                }
                if (value>=-2&&value<0){
                    li.add(6);
                }
                if (value>=-4&&value<-2){
                    li.add(7);
                }
                if (value>=-6&&value<-4){
                    li.add(8);
                }
                if (value>=-8&&value<-6){
                    li.add(9);
                }
                if (value>-10&&value<-8){
                    li.add(10);
                }

            }
            lli.add(li);
            li = new ArrayList<>();
        }
        return lli;
    }

    //写入数据库
    public void write(List<List<Integer>> lli) throws ClassNotFoundException, SQLException {
        String s = "insert adgjm3 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = design.connectDatabase();
        PreparedStatement ps = con.prepareStatement(s);
        for (int i = 0; i < lli.size(); i++) {
            ps.setDouble(1, lli.get(i).get(0));
            ps.setDouble(2, lli.get(i).get(1));
            ps.setDouble(3, lli.get(i).get(2));
            ps.setDouble(4, lli.get(i).get(3));
            ps.setDouble(5, lli.get(i).get(4));
            ps.setDouble(6, lli.get(i).get(5));
            ps.setDouble(7, lli.get(i).get(6));
            ps.setDouble(8, lli.get(i).get(7));
            ps.setDouble(9, lli.get(i).get(8));
            ps.setDouble(10, lli.get(i).get(9));
            ps.setDouble(11, lli.get(i).get(10));
            ps.setDouble(12, lli.get(i).get(11));
            ps.setDouble(13, lli.get(i).get(12));
            ps.setDouble(14, lli.get(i).get(13));
            ps.setDouble(15, lli.get(i).get(14));
            ps.execute();
        }
        con.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ADGJM adgjm = new ADGJM();
        List<List<Double>> list1 = adgjm.getADGJM();
        List<List<Integer>> list2 = adgjm.tranToInt(list1);
        adgjm.write(list2);
    }
}
