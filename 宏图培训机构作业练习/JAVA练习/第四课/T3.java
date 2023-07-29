import java.util.Scanner;
public class T3 
{
	public static void main(String[] args) 
	{
		System.out.println("请输入3个数：");
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		int b=sb.nextInt();
		int c=sb.nextInt();
		int max=0,min=0,mid=0,sum=0;//初始
		sum=a+b+c;//和为

		max=a>b?a:b;

		max=max>c?max:c;//比较最大的

		min=a<b?a:b;

		min=min<c?min:c;//比较最小的

		mid=sum-max-min;//中间的数
		System.out.print("最大的数为："+max);
		System.out.print("最小的数为："+min);
		a=min;
		b=mid;
		c=max;
		System.out.println("改变值后a,b,c依次排序："+a+"  "+b+"  "+c);
	}
}
