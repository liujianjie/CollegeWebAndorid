import java.util.Scanner;
public class T3
{
	//试试换换位置
	public static void main(String dsfa[]){
		int a[][]=new int[5][6];
		Scanner sb=new Scanner(System.in);//调用输入函数
		
		for(int i=0;i<5;i++){
			System.out.print("请输入第"+(i+1)+"个同学的学号三门成绩：");
			for(int j=0;j<4;j++){
				a[i][j]=sb.nextInt();//输入函数
				if(j>0){
					a[i][4]+=a[i][j];
				}
				a[i][5]=a[i][4]/3;
	
			}
		
		}
		System.out.println("同学们的成绩以表格输出的结果为：");
		System.out.println("学号\t语文\t数学\t英语\t总分");
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){//5行5列
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");//输出
		
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){//5行5列
				System.out.print(a[j][i]+"\t");
			}
			System.out.println("");//输出
		
		}
	}
}
