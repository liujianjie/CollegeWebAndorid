import java.util.Scanner;
public class T11 
{
	public static void main(String[] args) 
	{
		/*11、用户输入一个数，判断是否为素数,素数：只能被1和它本身整除的数（while、for实现） break;
		*/
		System.out.println("请输入一个数（我来判断是不是素数）：");
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
			System.out.println("这个数是素数");
		}
		if(b==1){
			System.out.println("这个数不是素数");
		}

	}
}
