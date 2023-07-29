import java.util.Scanner;
public class T2
{
	public static void main(String sdd[]){
		System.out.println("请输入一个三位数：");
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		int b,c,d,e;
		b=a/100%10;
		c=a/10%10;
		d=a/1%10;
		System.out.println("三位数是："+b+"  "+c+"  "+d);
		e=b*b*b+c*c*c+d*d*d;
		if(e==a){
			System.out.println("这个数是水仙花数");
		
		}else{
			System.out.println("这个数不是水仙花数");
		
		}
	}
}