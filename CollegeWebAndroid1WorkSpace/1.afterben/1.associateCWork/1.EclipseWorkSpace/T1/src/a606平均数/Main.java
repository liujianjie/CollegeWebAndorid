package a606Æ½¾ùÊý;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main  {
	public static void main(String []args)
	{
		DecimalFormat dc = new DecimalFormat("#.#####");
		Scanner sc = new Scanner(System.in);
		float a, b;
		a = sc.nextFloat();
		b = sc.nextFloat();
		double sum = (double) ((a * 3.5 + b * 7.5) / 11);
//		System.out.println("MEDIA = " + String.format("%.5f", sum));
		System.out.println("MEDIA = " + dc.format(sum));
		
		sc.close();
	}
}
