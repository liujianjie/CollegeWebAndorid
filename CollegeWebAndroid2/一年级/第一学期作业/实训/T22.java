package javaone实训;

import java.util.Scanner;

public class T22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个月的收入：");
		float saly = sc.nextFloat();
		float shui = 0.0f;
		if(saly >= 2000 && saly < 3500){
			shui = (saly - 2000) * 0.05f;
		}else if(saly >= 3500 && saly < 5000){
			shui = (3500 - 2000) * 0.05f + (saly - 3500) * 0.1f;
		}else if(saly >= 5000 && saly < 10000){
			shui = (3500 - 2000) * 0.05f + (5000 - 3500) * 0.1f + (saly - 5000) * 0.15f;
		}else if(saly >= 10000){
			shui = (3500 - 2000) * 0.05f + (5000 - 3500) * 0.1f + (10000 - 5000) * 0.15f + (saly - 10000) * 0.2f ;
		}
		System.out.println(shui);
		sc.close();
	}
}
