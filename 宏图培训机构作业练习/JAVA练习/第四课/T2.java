import java.util.Scanner;
public class T2
{
	public static void main(String sdd[]){
		System.out.println("������һ����λ����");
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		int b,c,d,e;
		b=a/100%10;
		c=a/10%10;
		d=a/1%10;
		System.out.println("��λ���ǣ�"+b+"  "+c+"  "+d);
		e=b*b*b+c*c*c+d*d*d;
		if(e==a){
			System.out.println("�������ˮ�ɻ���");
		
		}else{
			System.out.println("���������ˮ�ɻ���");
		
		}
	}
}