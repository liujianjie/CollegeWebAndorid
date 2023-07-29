import java.util.Scanner;
public class T2
{
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
		System.out.println("");
		//)输出每个学生的学号及总分
		System.out.println("学号\t总分");
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j+=4){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");//输出
		}
		//比较
		int max=0,b=0,c=0;
		for(b=0;b<5;b++){
			if(max<a[b][4]){
				max=a[b][4];
				c=a[b][0];
			}
		}

		System.out.println("");
		System.out.println("总分最高的为:"+max+" 学号为："+c);

		System.out.println("");
		System.out.println("学号\t语文\t数学\t英语\t总分\t平均分");
		for(int i=0;i<5;i++){
			for(int j=0;j<6;j++){//5行5列
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");//输出
		
		}
		//定义 终于尼玛做出来了 这样的反序赋值和算真尼玛难 操操操 重中之重啊
		int m[][]=new int[5][7];
		for(int i=1;i<4;i++){
			for(int j=0;j<5;j++){
				m[i][j]=a[j][i];
				m[i][5]+=m[i][j];
				m[i][6]=m[i][5]/5;
			}
		
		}
		//循环赋值

		//4)分别输出语文、数学、英语的平均分
		System.out.println("");
		System.out.println("语文\t数学\t英语");
		//循环输出
		for(int i=1;i<4;i++){
			System.out.print((float)m[i][6]+"\t");
		
		}
		System.out.println("");
		int t=0;
		System.out.println("冒泡排序练练");
		for(int i=0;i<5;i++){
			for(int j=i+1;j<5;j++){
				if(a[i][5]<a[j][5]){
					for(int k=0;k<6;k++){
						t=a[i][k];
						a[i][k]=a[j][k];
						a[j][k]=t;
					}
				}
			}
		
		}
		System.out.println("学号\t语文\t数学\t英语\t总分\t平均分");
		for(int i=0;i<5;i++){
			for(int j=0;j<6;j++){//5行5列
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");//输出
		
		}
	}
}