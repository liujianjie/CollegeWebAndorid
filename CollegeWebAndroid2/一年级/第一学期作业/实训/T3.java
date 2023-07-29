package javaone实训;

import java.util.Scanner;
public class T3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入这个班参与投票有多少同学(最好奇数)：");
		int n = 2;
		while(n % 2 != 1 )
			n = sc.nextInt();
		int ticket[] = new int[2];
		System.out.println("请依次输入每个学生投票的结果");
		String result;
		int i = 0;
		while(++i != n + 1){
			System.out.print("当前第"+(i)+"个同学的投票：");
			result = sc.next();
			if(result.equals("张"))
				++ticket[0];
			else if(result.equals("王"))
				++ticket[1];
		}
		if(ticket[0] > ticket[1])
			System.out.println("张同学竞选成功");
		else
			System.out.println("王同学竞选成功");
		sc.close();
	}
}
