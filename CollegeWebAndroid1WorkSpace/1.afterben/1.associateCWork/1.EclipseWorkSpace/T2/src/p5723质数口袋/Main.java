package p5723�����ڴ�;
// ��Ҫ����
/*
С A ��һ�������ڴ����������װ�������������� 222 ��ʼ�������жϸ�����Ȼ���ǲ�������������������ͻ���������װ��ڴ���
�ڴ��ĸ��������ǿڴ������������֮�͡����ǿڴ��ĳ��������ޣ�����װ�����ܺͳ��� LLL��1��L��1051 \le L \le {10}^51��L��105��
������������ LLL�����ʿڴ�����װ�¼�������������Щ������С���������Ȼ����������װ�µ�������������������֮����һ���С�
*/
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int sum = 0;
		boolean iszhi;
		int count = 0;// ����
		for(int i = 2; (sum + i) <= L; i++){// ע������
			iszhi = true;
			for(int j = 2; j < i; j++){
				if(i % j == 0){
					iszhi = false;
				}
			}
			if(iszhi){
				count++;
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println(count);
		sc.close();
	}
}