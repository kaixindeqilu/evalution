package cluster;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lulu on 2018/1/15.
 */
public class main {
    static int[] arr = {13,57,89,146,199,204,247,288,346,386,488,537,588,628,712,746,784,827,889,926,996,1055,1079,1127,
                  1183,1289,1344,1375,1456,1538,1592,1638,1678,1792,1826,1859,2035,2069,2101,2188,2255,2270,2389,
                  2477,2566,2599,2613,2679,2893,3087};
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        step2 two = new step2();
        step1 one = new step1();
        step0 zero = new step0();
        List<Double> preFs = new ArrayList<>();
        for (int i = 0;i < arr.length;i++){
           // List<Integer> listComp = zero.getComp(arr[i]);//获取相似企业
            List<Double> listSim = zero.getSim(arr[i]);//相似度值
            List<Double> listFs = zero.getFs(arr[i]);//实际指标值
            List<Double> listAvgs = two.getAvgs(arr[i]);//平均指标值
            double pre = one.getPreF(listAvgs,listSim,listFs);
            preFs.add(pre);
        }
        for (double x:preFs){
            System.out.println(x);
        }
    }

}
