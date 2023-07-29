package ch2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Fangdi Chen 
 * @date 2018922
 * @purpose ��ϤforǶ�ף�switch �÷�
 */
public class ch2HW_WindChill {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//�ȴ��û�����ʵ��
		//��ʽ�� ������λС����������λС������5���λ
		DecimalFormat   fnum  =   new  DecimalFormat("##0.00");  
		String outaverage = "";// ������� �ظ�ʹ��
		System.out.println("Enter number of students to simulate:");
		
		//�貶���쳣�����Ƿ�Ϊ����
		try{
			int count = input.nextInt(); // ��ȡ���û���������� 
			System.out.println("Beginning Simulation:");
			System.out.println("===================================");
			System.out.println("Name:		HW1		HW2		HW3		HW4		HW5		Average:");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			
			float SumHW[] = new float[5]; // Ϊ�˼���ÿ��ѧ�Ƶ�ƽ���ɼ� 
			for(int i = 1 ; i <= count; i++){ // ˫��Ƕ��
				int score = 0; // Ĭ��Ϊ0
				float average = 0f;// �ָ�Ϊ0
				System.out.print("Student #"+ i +":	");
				for(int j = 1; j <= 5; j++){
					score = 30 + (int)(Math.random() * (101 - 30));//��Χ 30 - 100 ���� 30 �� 100
					
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
			System.out.println("Input Error");// ����������ǲ�������
		}
		
		input.close();
	}
}
