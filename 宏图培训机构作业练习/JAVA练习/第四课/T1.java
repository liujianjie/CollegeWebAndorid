import java.util.Scanner;
public class T1
{
	public static void main(String sdd[]){
		System.out.print("请输入一个数：");
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		if(a%7==0&&a%3==0){
			System.out.println("这个数是7和3的倍数");
		
		}
		if(a%7==0){
			System.out.println("这个数是7的倍数");
	
		}else{
			System.out.println("这个数不是7的倍数");

		}

	}

}