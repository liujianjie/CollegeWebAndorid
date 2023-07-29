package p1980计数问题;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        String xs = x + "";
        int count = 0;
        int temp = 0;
        for(int i = 1; i <= n; i++){
        	if(String.valueOf(i).indexOf(xs) != -1){
        		temp = i;
        		while(temp != 0){
        			if(temp % 10 == x){
        				count++;
        			}
        			temp /= 10;
        		}
        	}
        }
        System.out.println(count);
		sc.close();
	}
}