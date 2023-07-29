package p52710数的性质;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {0, 0, 0, 0};// 默认不喜欢
		int num = sc.nextInt();
		boolean b1 = num % 2 == 0;
		boolean b2 = num > 4 && num <= 12;
		if(b1 && b2){
			arr[0] = 1;
		}
		if(b1 || b2){
			arr[1] = 1;
		}
		if((b1 && !b2) || (!b1 && b2)){
			arr[2] = 1;
		}
		if(!b1 && !b2){
			arr[3] = 1;
		}
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}
}
