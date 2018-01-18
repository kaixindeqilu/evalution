package cluster;

import random.design;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//预测指标值
public class step1 {
    //list1平均指标，其中list1.get(0)是目标企业的平均指标；list2相似度值，其中list2.get(0)=1，是企业与自身的相似度值；
    // list3针对指标值，其中list3.get(0)是目标企业的真实待预测指标值。
    public double getPreF(List<Double> list1,List<Double> list2,List<Double> list3){
        double fenzi = 0;
        double fenmu = 0;
        for (int i = 1;i < 11;i++){
            fenzi += list2.get(i)*(list3.get(i) - list1.get(i));
            fenmu += Math.abs(list2.get(i));
        }
        double preF = list1.get(0) + fenzi/fenmu;
        return preF;
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        step1 one = new step1();
//        step0 zero = new step0();
//        List<Double> list2 = zero.getSim();
//        List<Double> list3 = zero.getFs();
//        step2 two = new step2();
//        List<Double> list1 = two.getAvgs();
//        double preF = one.getPreF(list1,list2,list3);
//        System.out.print(preF);
//    }

}