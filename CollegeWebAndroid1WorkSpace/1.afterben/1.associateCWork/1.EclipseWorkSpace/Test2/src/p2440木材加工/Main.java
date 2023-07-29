package p2440木材加工;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int Li[] = new int[n];
        for(int i = 0; i < n; i++){
        	Li[i] = sc.nextInt();
        }
        // 排序
        Arrays.sort(Li);// 默认从小到大
        int max = Li[n - 1];// 最大的
        int count = 0;// 总数
        int tempLi;// 一个个测试的L值，从大到小递减
        int curk = 0;
    	for(int tempL = max - n; max >= Li[0]; tempL--){
    		if(max - tempL >= 0){
    			count = (int) Math.floor(max / tempL) ;
    		}
    		for(int i = n - 2; i >= 0; i--){
    			tempLi = Li[i];
    			if(tempLi - tempL >= 0){
        			count += Math.floor(tempLi / tempL);
        		}
			}
    		if(count >= k){
				System.out.println(tempL);
				break;
			}
    	}
		sc.close();
	}
}