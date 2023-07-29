import java.util.Scanner;
public class  T13
{
	public static void main(String[] args) 
	{
		//
	/*13、猜数字，定义一个变量num=56，让用户输入一个数与num进行比较，并提示用户是高了
	还是低了，直到猜中为止。（用到break）
	*/
		System.out.println("请输入你要猜的数（10次机会，提示在1-100之间）：");
		int a=0,sum=0;//定义

		do{
			Scanner sb=new Scanner(System.in);
			a=sb.nextInt();//循环输出
			if(a<56){
				System.out.println("猜的数小了，请重新输入");
			}
			if(a>56){
				System.out.println("猜的数大了，请重新输入");
			}
			sum++;
			if(sum==10){
				break;
			}
		}while(a!=56);

		if(a==56){
			System.out.println("恭喜你，答对了！！！");
		}
		if(sum==10){
			System.out.println("你的机会用完了");
		
		}
	}
}
