package ch3;
/*

Author: Fangdi Chen
Date: 9/22/2018
Program:Amortization
Description: You are to write a small program in Java that will simulate five homework grades for a 
certain number of students. The program will randomly create the grades for each assignment, 
for each student, and  calculate the average of all the grades for each student AND the average of 
each assignment across students.

*/

import java.text.DecimalFormat;
import java.util.Scanner;
public class GradeSimulator {
	
	public static void main(String[] args) {
		
		//Waiting for user input
		Scanner input = new Scanner(System.in);
		
		//Formatting keeps two decimal places, and when third decimal places are greater than 5, carry them.
		
		DecimalFormat   fnum  =   new  DecimalFormat("##0.00");  
		String outaverage = "";
		
		System.out.println("Enter number of students to simulate:");
		
		//Whether to capture abnormal input is numeric.
		try{
			 // Gets the number entered to the user.
			int count = input.nextInt();
			System.out.println("Beginning Simulation:");
			System.out.println("===================================");
			System.out.println("Name:		HW1		HW2		HW3		HW4		HW5		Average:");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			
			float SumHW[] = new float[5]; // In order to calculate the average scores of each subject
			for(int i = 1 ; i <= count; i++){ // Double nesting
				int score = 0; // Default is 0
				float average = 0f;// Restore to 0
				System.out.print("Student #"+ i +":	");
				for(int j = 1; j <= 5; j++){
					score = 30 + (int)(Math.random() * (101 - 30));//Scope 30-100 includes 30 and 100.
					
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
		}catch(Exception e){
			System.out.println("Input Error");// Is the number captured?
		}
		
		input.close();
	}
}
