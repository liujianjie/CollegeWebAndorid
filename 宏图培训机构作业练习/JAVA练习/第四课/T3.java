import java.util.Scanner;
public class T3 
{
	public static void main(String[] args) 
	{
		System.out.println("������3������");
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		int b=sb.nextInt();
		int c=sb.nextInt();
		int max=0,min=0,mid=0,sum=0;//��ʼ
		sum=a+b+c;//��Ϊ

		max=a>b?a:b;

		max=max>c?max:c;//�Ƚ�����

		min=a<b?a:b;

		min=min<c?min:c;//�Ƚ���С��

		mid=sum-max-min;//�м����
		System.out.print("������Ϊ��"+max);
		System.out.print("��С����Ϊ��"+min);
		a=min;
		b=mid;
		c=max;
		System.out.println("�ı�ֵ��a,b,c��������"+a+"  "+b+"  "+c);
	}
}
