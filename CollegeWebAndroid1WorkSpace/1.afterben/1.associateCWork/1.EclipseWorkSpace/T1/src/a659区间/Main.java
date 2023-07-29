package a659Çø¼ä;

import java.util.Scanner;

public class Main  {
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int a;
		float b, c;
		a = sc.nextInt();
		b = sc.nextFloat();
		c = sc.nextFloat();
		c = b * c;
		System.out.println("NUMBER = " + a);
		System.out.println("SALARY = U$ " + String.format("%.2f", c));
		
		sc.close();
	}
}
