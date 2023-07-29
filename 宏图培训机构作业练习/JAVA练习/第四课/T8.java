import java.util.Scanner;
public class T8 
{
	public static void main(String[] args) 
	{
		System.out.println("请输入一个数：");
		Scanner sb=new Scanner(System.in);
		int n=sb.nextInt();//不能输这么大
		int sum=1;
		for(int i=n;i>=1;i--){
			sum*=i;
		}
		System.out.println("这个数的阶乘为："+sum);
	}
}
