package p5716月份天数;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int month = sc.nextInt();
		boolean isrun = false;
		// 1.先判断是否闰年 
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
			isrun = true;
		}
		int eryue = 28;// 默认平年
		if(isrun){
			eryue = 29;
		}
		int day;
		switch (month) {
		case 2:
			day = eryue;
			break;
		case 1:case 3:case 5:case 7:case 8:case 10:case 12:
			day = 31;
			break;
		default:
			day = 30;
			break;
		}
		System.out.println(day);
		sc.close();
	}
}
