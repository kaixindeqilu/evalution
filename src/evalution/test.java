package evalution;

import java.util.Random;

public class test {
	public static void main(String[] args){
		Random ran = new Random();
		for(int i=0;i<100;i++){
			int a = ran.nextInt(20)+1;
			System.out.println(a);
		}
	}

}
