import java.util.Scanner;
public class T10 
{
	public static void main(String[] args) 
	{
		System.out.println("请输入5个学生的成绩：（空格隔开）");
		Scanner sb=new Scanner(System.in);
		int a=0,sum=0,max=0,min=200;
		for(int i=0;i<5;i++){
			a=sb.nextInt();

			if(max<a){
				max=a;
			}
			if(min>a){
				min=a;
			}
			sum+=a;
		}
		System.out.println("其中最大的数为："+max+"  最小的数为："+min+"  平均数为："+sum/5);
	}
}
		/*
		Scanner sb=new Scanner(System.in);
		int a=sb.nextInt();
		int b=sb.nextInt();
		int c=sb.nextInt();
		int d=sb.nextInt();
		int e=sb.nextInt();
		int max=0,min=0,sum=0;
		float avg=0.0f;
		max=a>b?a:b;
		max=max>c?max:c;
		max=max>d?max:d;
		max=max>e?max:e;

		min=a<b?a:b;
		min=min<c?min:c;
		min=min<d?min:d;
		min=min<e?min:e;
		
		sum=a+b+c+d+e;
		avg=sum/5;
		System.out.println("其中最大的数为："+max+"  最小的数为："+min+"  平均数为："+avg);*/

