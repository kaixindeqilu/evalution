package cluster;

import random.design;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lulu on 2017/12/20.
 */
public class step0 {
    //获取目标企业的相似企业
    public List<Integer> getComp(int a) throws SQLException, ClassNotFoundException {
        Connection con = design.connectDatabase();
        Statement sm = con.createStatement();
        ResultSet rs = sm.executeQuery(" SELECT B FROM part6 WHERE A = " + a );
        List<Integer> list = new ArrayList<>();
        while (rs.next()){
            list.add(rs.getInt("B"));
        }
        return list;
    }

    //获取目标企业和相似企业的相似度值sim
    public List<Double> getSim(int a) throws SQLException, ClassNotFoundException {
        List<Double> listSim = new ArrayList<>();
        Connection con = design.connectDatabase();
        Statement sm = con.createStatement();
        ResultSet rs = sm.executeQuery(" SELECT sim FROM part6 WHERE A = " + a );
        while (rs.next()){
            listSim.add(rs.getDouble("sim"));
        }
        con.close();
        return listSim;
    }

    //获取目标企业及其最相似企业的要预测的指标值
    public double getF(int val) throws SQLException, ClassNotFoundException {
        double f = 0;
        Connection con = design.connectDatabase();
        Statement sm = con.createStatement();
        ResultSet rs = sm.executeQuery(" SELECT BS FROM newlishuqing2 WHERE id = " + val);
        while (rs.next()) {
            f = rs.getDouble("BS");
        }
        con.close();
        return f;
    }
    public List<Double> getFs(int a) throws SQLException, ClassNotFoundException {
        List<Integer> listComp = getComp(a);
        List<Double> listF = new ArrayList<>();
        for (int i = 0;i < listComp.size();i++){
            double f = getF(listComp.get(i));
            listF.add(f);
        }
        return listF;
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        step0 zero = new step0();
//        List<Double> Fs = zero.getFs();
//        List<Double> sims = zero.getSim();
//        for (double x:Fs){
//            System.out.println(x);
//        }
//        System.out.println(".........................................................");
//        for (double y:sims){
//            System.out.println(y);
//        }
//    }
}
