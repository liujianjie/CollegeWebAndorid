import java.util.Scanner;
public class T8 
{
	public static void main(String[] args) 
	{
		System.out.println("������һ������");
		Scanner sb=new Scanner(System.in);
		int n=sb.nextInt();//��������ô��
		int sum=1;
		for(int i=n;i>=1;i--){
			sum*=i;
		}
		System.out.println("������Ľ׳�Ϊ��"+sum);
	}
}
