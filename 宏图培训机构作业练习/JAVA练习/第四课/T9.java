import java.util.Scanner;
public class  T9
{
	public static void main(String[] args) 
	{
		System.out.println("请输入两个数：");
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		int b=sb.nextInt();
		int max=0,c=0;
		max=a>b?a:b;
		for(int i=1;i<=max;i++){
			if(a%i==0&b%i==0){
				if(i>c){
					c=i;
				}
			}
		
		}
		System.out.println("最大的公约数是："+c);

	}
}
