package p5708三角形面积;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();
		float p = (a + b + c) / 2;
		double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		System.out.println(String.format("%.1f", area));
		sc.close();
	}
}
