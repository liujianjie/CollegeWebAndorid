import java.util.Scanner;
public class T11 
{
	public static void main(String[] args) 
	{
		/*11���û�����һ�������ж��Ƿ�Ϊ����,������ֻ�ܱ�1������������������while��forʵ�֣� break;
		*/
		System.out.println("������һ�����������ж��ǲ�����������");
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		int b=0;
		for(int i=2;i<a;i++){
			while(a%i==0){
				b=1;
				break;
			}
		
		}
		if(b==0){
			System.out.println("�����������");
		}
		if(b==1){
			System.out.println("�������������");
		}

	}
}
