package one;

import java.util.Scanner;

public class Demo01 {
	int x1;
	public static void main(String[] args) {
		int m,n;
		m = 1;n=1;
		int x = 10;
		if(x > 90){
			System.out.println("x>5");
			
		}else if(x > 6){
			System.out.println("x>6");
			
		}else if(x > 7){
			System.out.println("x>7");
		}else{
			System.out.println("x");
		}
		int y = 0;
		for(int x1 = 1; x1 <= 10;x1++){
			y += x1;
		}
		System.out.println(y);
		
		Scanner sc = new Scanner(System.in);
		int floats = sc.nextInt();
		System.out.println(floats);
	}
}
