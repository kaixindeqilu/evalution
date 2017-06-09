package cluster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class step3{
	double[] ones = {0.0896,0.0701,0.1658,0.0346,0.0631,0.2556,0.0715,0.0775};
	double[] twos = {0.1151,0.0112,0.0110,0.0124,0.0658,0.2180,0.1637,0.0866,0.0717,0.0353,0.1721,0.3402,0.0547,0.0106,0.0104,0.0103,0.0103};
	double[] threes = {0.0978,0.1065,0.2497};
	double[] cones = {0.0896,0.0701,0.1658,0.0346,0.0631,0.2556,0.0715,0.0775};;
	double[] ctwos = {0.1151,0.0112,0.0110,0.0124,0.0658,0.2180,0.1637,0.0866,0.0717,0.0353,0.1721,0.3402,0.0547,0.0106,0.0104,0.0103,0.0103};;
	double[] cthrees ={0.0978,0.1065,0.2497}; ;
	List<double[]>list = new ArrayList();
	public List<List<Double>> disRate(){
		
		double[] maxDis = new double[3];
		list.add(ones);
		list.add(twos);
		list.add(threes);
		for(int i=0;i<3;i++){
			Arrays.sort(list.get(i));
			//测试排序后数组输出
//			for(int j=0;j<list.get(i).length;j++){
//			    System.out.println(list.get(i)[j]);
//			}
			maxDis[i] = list.get(i)[list.get(i).length-1];
		}
		
		
		//测试最大值输出
		for(double x:maxDis){
			System.out.print(x+"    ");
		}
		
		List<Double> list1 = new ArrayList();
		List<Double> list2 = new ArrayList();
		List<Double> list3 = new ArrayList();
		for(int i=0;i<cones.length;i++){
			list1.add((cones[i]/maxDis[0])*(8.0/28.0));
		}
		for(int i=0;i<ctwos.length;i++){
			list2.add((ctwos[i]/maxDis[1])*(17.0/28.0));
		}
		for(int i=0;i<cthrees.length;i++){
			list3.add((cthrees[i]/maxDis[2])*(3.0/28.0));
		}
		List<List<Double>> listt = new ArrayList();
		listt.add(list1);
		listt.add(list2);
		listt.add(list3);
		
		return listt;
	}
	
	public static void main(String[] args){
		step3 three = new step3();
		List<List<Double>> listt = three.disRate();
		//结果输出
		for(int i=0;i<3;i++){
		   System.out.println(listt.get(i).toString());
		}
	}
	
}