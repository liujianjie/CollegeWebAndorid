package javaoneʵѵ;

import java.util.Scanner;
public class T3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������������ͶƱ�ж���ͬѧ(�������)��");
		int n = 2;
		while(n % 2 != 1 )
			n = sc.nextInt();
		int ticket[] = new int[2];
		System.out.println("����������ÿ��ѧ��ͶƱ�Ľ��");
		String result;
		int i = 0;
		while(++i != n + 1){
			System.out.print("��ǰ��"+(i)+"��ͬѧ��ͶƱ��");
			result = sc.next();
			if(result.equals("��"))
				++ticket[0];
			else if(result.equals("��"))
				++ticket[1];
		}
		if(ticket[0] > ticket[1])
			System.out.println("��ͬѧ��ѡ�ɹ�");
		else
			System.out.println("��ͬѧ��ѡ�ɹ�");
		sc.close();
	}
}
