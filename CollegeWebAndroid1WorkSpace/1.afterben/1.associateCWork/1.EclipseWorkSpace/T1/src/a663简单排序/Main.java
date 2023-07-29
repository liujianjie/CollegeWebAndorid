package a663¼òµ¥ÅÅÐò;

import java.util.Scanner;

public class Main  {
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		int arr[] = new int[3];
		a = arr[0] = sc.nextInt();
		b = arr[1] = sc.nextInt();
		c = arr[2] = sc.nextInt();
		if(a > b){
			int temp = a;
			a = b;
			b = temp;
		}
		if(a > c){
			int temp = a;
			a = c;
			c = temp;
		}
		if(b > c){
			int temp = b;
			b = c;
			c = temp;
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println();
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		sc.close();
	}
}
