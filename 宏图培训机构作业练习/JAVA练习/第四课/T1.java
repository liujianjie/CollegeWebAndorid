import java.util.Scanner;
public class T1
{
	public static void main(String sdd[]){
		System.out.print("������һ������");
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		if(a%7==0&&a%3==0){
			System.out.println("�������7��3�ı���");
		
		}
		if(a%7==0){
			System.out.println("�������7�ı���");
	
		}else{
			System.out.println("���������7�ı���");

		}

	}

}