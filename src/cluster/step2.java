package cluster;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;  
import random.design; 
/** 
 * K��ֵ�����㷨 
 */  
public class step2 {  
    private int k;// �ֳɶ��ٴ�  
    private int m;// ��������  
    private int dataSetLength;// ���ݼ�Ԫ�ظ����������ݼ��ĳ���  
    private List<double[]> dataSet;// ���ݼ�����  
    private List<double[]> center;// ��������  
    private List<List<double[]>> cluster; // ��  
    private List<Double> jc;// ���ƽ���ͣ�kԽ�ӽ�dataSetLength�����ԽС  
    private Random random;  
  
    /** 
     * ����������ԭʼ���ݼ� 
     *  
     * @param dataSet 
     */  
  
    public void setDataSet(List<double[]> dataSet) {  
        this.dataSet = dataSet;  
    }  
  
    /** 
     * ��ȡ������� 
     *  
     * @return ����� 
     */  
  
    public List<List<double[]>> getCluster() {  
        return cluster;  
    }  
  
    /** 
     * ���캯����������Ҫ�ֳɵĴ����� 
     *  
     * @param k 
     *            ������,��k<=0ʱ������Ϊ1����k��������Դ�ĳ���ʱ����Ϊ����Դ�ĳ��� 
     */  
    public step2(int k) {  
        if (k <= 0) {  
            k = 1;  
        }  
        this.k = k;  
    }  
  
    /** 
     * ��ʼ�� 
     */  
    private void init() {  
        m = 0;  
        random = new Random();  
//        if (dataSet == null || dataSet.size() == 0) {  
//            initDataSet();  
//        }  
        dataSetLength = dataSet.size();  
        if (k > dataSetLength) {  
            k = dataSetLength;  
        }  
        center = initCenters();  
        cluster = initCluster();  
        jc = new ArrayList<Double>();  
    }  
  
    /** 
     * ���������δ��ʼ�����ݼ���������ڲ��������ݼ� 
     */  
//    private void initDataSet() {  
//        dataSet = new ArrayList<double[]>();  
//        // ����{6,3}��һ���ģ����Գ���Ϊ15�����ݼ��ֳ�14�غ�15�ص���Ϊ0  
//        double[][] dataSetArray = new double[][] { { 8, 2 }, { 3, 4 }, { 2, 5 },  
//                { 4, 2 }, { 7, 3 }, { 6, 2 }, { 4, 7 }, { 6, 3 }, { 5, 3 },  
//                { 6, 3 }, { 6, 9 }, { 1, 6 }, { 3, 9 }, { 4, 1 }, { 8, 6 } };  
//  
//        for (int i = 0; i < dataSetArray.length; i++) {  
//            dataSet.add(dataSetArray[i]);  
//        }  
//    }  
  
    /** 
     * ��ʼ���������������ֳɶ��ٴؾ��ж��ٸ����ĵ� 
     *  
     * @return ���ĵ㼯 
     */  
    private List<double[]> initCenters() {  
        List<double[]> center = new ArrayList<double[]>();  
        int[] randoms = new int[k];  
        boolean flag;  
        int temp = random.nextInt(dataSetLength);  
        randoms[0] = temp;  
        for (int i = 1; i < k; i++) {  
            flag = true;  
            while (flag) {  
                temp = random.nextInt(dataSetLength);  
                int j = 0;  
                // �����forѭ������j�޷���1  
                // for(j=0;j<i;++j)  
                // {  
                // if(temp==randoms[j]);  
                // {  
                // break;  
                // }  
                // }  
                while (j < i) {  
                    if (temp == randoms[j]) {  
                        break;  
                    }  
                    j++;  
                }  
                if (j == i) {  
                    flag = false;  
                }  
            }  
            randoms[i] = temp;  
        }  
  
        // ����������������  
        // for(int i=0;i<k;i++)  
        // {  
        // System.out.println("test1:randoms["+i+"]="+randoms[i]);  
        // }  
  
        // System.out.println();  
        for (int i = 0; i < k; i++) {  
            center.add(dataSet.get(randoms[i]));// ���ɳ�ʼ����������  
        }  
        return center;  
    }  
  
    /** 
     * ��ʼ���ؼ��� 
     *  
     * @return һ����Ϊk�صĿ����ݵĴؼ��� 
     */  
    private List<List<double[]>> initCluster() {  
        List<List<double[]>> cluster = new ArrayList<List<double[]>>();  
        for (int i = 0; i < k; i++) {  
            cluster.add(new ArrayList<double[]>());  
        }  
  
        return cluster;  
    }  
  
    /** 
     * ����������֮��ľ��� 
     *  
     * @param element 
     *            ��1 
     * @param center 
     *            ��2 
     * @return ���� 
     */  
    private double distance(double[] element, double[] center) {  
        double distance = 0.0;
        double sum = 0;
        //System.out.println(element.length);
       // System.out.println(center.length);
        for(int i = 0; i<element.length; i++){
        	 sum = sum + Math.pow((element[i]-center[i]), 2);	
        }
  
        distance = (double) Math.sqrt(sum);  
  
        return distance;  
    }  
  
    /** 
     * ��ȡ���뼯������С�����λ�� 
     *  
     * @param distance 
     *            �������� 
     * @return ��С�����ھ��������е�λ�� 
     */  
    private int minDistance(double[] distance) {  
    	double minDistance = distance[0];  
        int minLocation = 0;  
        for (int i = 1; i < distance.length; i++) {  
            if (distance[i] < minDistance) {  
                minDistance = distance[i];  
                minLocation = i;  
            } else if (distance[i] == minDistance) // �����ȣ��������һ��λ��  
            {  
                if (random.nextInt(10) < 5) {  
                    minLocation = i;  
                }  
            }  
        }  
  
        return minLocation;  
    }  
  
    /** 
     * ���ģ�����ǰԪ�طŵ���С����������صĴ��� 
     */  
    private void clusterSet() {  
    	double[] distance = new double[k];  
        for (int i = 0; i < dataSetLength; i++) {  
            for (int j = 0; j < k; j++) {  
                distance[j] = distance(dataSet.get(i), center.get(j));  
                // System.out.println("test2:"+"dataSet["+i+"],center["+j+"],distance="+distance[j]);  
  
            }  
            int minLocation = minDistance(distance);  
            // System.out.println("test3:"+"dataSet["+i+"],minLocation="+minLocation);  
            // System.out.println();  
  
            cluster.get(minLocation).add(dataSet.get(i));// ���ģ�����ǰԪ�طŵ���С����������صĴ���  
  
        }  
    }  
  
    /** 
     * ���������ƽ���ķ��� 
     *  
     * @param element 
     *            ��1 
     * @param center 
     *            ��2 
     * @return ���ƽ�� 
     */  
    private double errorSquare(double[] element, double[] center) {  
//    	double x = element[0] - center[0];  
//    	double y = element[1] - center[1];  
//  
//    	double errSquare = x * x + y * y;  
    	 double errSquare = 0;
    	 
         for(int i = 0; i<element.length; i++){
        	 errSquare = errSquare + Math.pow(element[i]-center[i], 2);	
         }
   
  
        return errSquare;  
    }  
  
    /** 
     * �������ƽ����׼�������� 
     */  
    private void countRule() {  
    	double jcF = 0;  
        for (int i = 0; i < cluster.size(); i++) {  
            for (int j = 0; j < cluster.get(i).size(); j++) {  
                jcF += errorSquare(cluster.get(i).get(j), center.get(i));  
  
            }  
        }  
        jc.add(jcF);  
    }  
  
    /** 
     * �����µĴ����ķ��� 
     */  
    private void setNewCenter() {  
        for (int i = 0; i < k; i++) {  
            int n = cluster.get(i).size();  
            if (n != 0) {  
            	double[] newCenter = new double[2923];  
            	for(int k = 0;k < 2923;k++){
                    for (int j = 0; j < n; j++) {  
                    newCenter[k] += cluster.get(i).get(j)[k];  
                    }
                }  
                // ����һ��ƽ��ֵ  
//                newCenter[0] = newCenter[0] / n;  
//                newCenter[1] = newCenter[1] / n;  
            	for(int t=0;t<2923;t++){
            		 newCenter[t] = newCenter[t] / n;  
            	}
                center.set(i, newCenter);  
            }  
        }  
    }  
  
    /** 
     * ��ӡ���ݣ������� 
     *  
     * @param dataArray 
     *            ���ݼ� 
     * @param dataArrayName 
     *            ���ݼ����� 
     */  
    public void printDataArray(List<double[]> dataArray,  String dataArrayName) {  
        for (int i = 0; i < dataArray.size(); i++) { 
        	
            System.out.println("print:" + dataArrayName + "[" + i + "]={"  
                    + dataArray.get(i)[0] + "," + dataArray.get(i)[1] + ","+ dataArray.get(i)[2]+"}");  
        }  
        System.out.println("===================================");  
    }  
  
    /** 
     * Kmeans�㷨���Ĺ��̷��� 
     */  
    private void kmeans() {  
        init();  
        // printDataArray(dataSet,"initDataSet");  
        // printDataArray(center,"initCenter");  
  
        // ѭ�����飬ֱ������Ϊֹ  
        while (true) {  
            clusterSet();  
            // for(int i=0;i<cluster.size();i++)  
            // {  
            // printDataArray(cluster.get(i),"cluster["+i+"]");  
            // }  
  
            countRule();  
    
            // �����ˣ��������  
            if (m != 0) {  
                if (jc.get(m) - jc.get(m - 1) == 0) {  
                    break;  
                }  
            }  
  
            setNewCenter();  
            // printDataArray(center,"newCenter");  
            m++;  
            cluster.clear();  
            cluster = initCluster();  
        }  
  
        // System.out.println("note:the times of repeat:m="+m);//�����������  
    }  
  
    /** 
     * ִ���㷨 
     */  
    public void execute() {  
        long startTime = System.currentTimeMillis();  
        System.out.println("kmeans begins");  
        kmeans();  
        long endTime = System.currentTimeMillis();  
        System.out.println("kmeans running time=" + (endTime - startTime)  
                + "ms");  
        System.out.println("kmeans ends");  
        System.out.println();  
    } 
    
        public  static void main(String[] args) throws ClassNotFoundException, SQLException {  
            //��ʼ��һ��Kmean���󣬽�k��Ϊ10  
            step2 k=new step2(8); 
            step1 kk=new step1();
            
            List<double[]> dataSet1=kk.getData();
            List<double[]> dataSet = kk.transp(dataSet1);        
            //����ԭʼ���ݼ�  
            k.setDataSet(dataSet);  
            //ִ���㷨  
            k.execute();  
            //�õ�������  
            List<List<double[]>> cluster=k.getCluster();  
            //�鿴���  
            for(int i=0;i<cluster.size();i++)  
            {  
                k.printDataArray(cluster.get(i), "cluster["+i+"]");  
            }  
              
        }  
      
}  