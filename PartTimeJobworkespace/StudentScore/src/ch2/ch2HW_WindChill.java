package ch2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Fangdi Chen 
 * @date 2018922
 * @purpose 熟悉for嵌套，switch 用法
 */
public class ch2HW_WindChill {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//等待用户输入实例
		//格式化 保留两位小数，当第三位小数大于5则进位
		DecimalFormat   fnum  =   new  DecimalFormat("##0.00");  
		String outaverage = "";// 定义出来 重复使用
		System.out.println("Enter number of students to simulate:");
		
		//需捕获异常输入是否为数字
		try{
			int count = input.nextInt(); // 获取到用户输入的数字 
			System.out.println("Beginning Simulation:");
			System.out.println("===================================");
			System.out.println("Name:		HW1		HW2		HW3		HW4		HW5		Average:");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			
			float SumHW[] = new float[5]; // 为了计算每门学科的平均成绩 
			for(int i = 1 ; i <= count; i++){ // 双层嵌套
				int score = 0; // 默认为0
				float average = 0f;// 恢复为0
				System.out.print("Student #"+ i +":	");
				for(int j = 1; j <= 5; j++){
					score = 30 + (int)(Math.random() * (101 - 30));//范围 30 - 100 包括 30 和 100
					
					switch (j) {	// switch 
					case 1:
						SumHW[0] += score;
						break;
					case 2:
						SumHW[1] += score;
						break;
					case 3:
						SumHW[2] += score;			
						break;
					case 4:
						SumHW[3] += score;
						break;
					case 5:
						SumHW[4] += score;
						break;
					default:
						break;
					}
					
					average += score;
					System.out.print(score + "		");
				}
				outaverage = fnum.format(average / 5);
				System.out.print(outaverage);
				System.out.println("");
			}
		
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.print("Averages:	");
			
			for(int m = 0;m < 5; m++)
			{
					outaverage = fnum.format(SumHW[m]/count);
					System.out.print(outaverage+"		");
					
			}
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("Simulation finished");
		}catch(Exception e){
			System.out.println("Input Error");// 捕获输入的是不是数字
		}
		
		input.close();
	}
}
