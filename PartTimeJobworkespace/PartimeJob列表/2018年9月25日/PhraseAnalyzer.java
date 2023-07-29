//package hw4;

import java.util.Scanner;
/*

Author: Fangdi Chen
Date: 9/25/2018
Description: You are to write a small Java program that will allow for the input of a sentence, as
well as the input of four letters. Your program will search the phrase for each of the four letters
individually and keep a count of how many times each letter appears in the phrase. The user
should be able to enter any four characters they wish (assume they will enter only a through z,
and assume they will always enter 4 letters separated by a space). Then your program will print
this count out at the end.

*/
public class PhraseAnalyzer {
	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		boolean blninput = true;
		while(blninput){
			System.out.println("Enter a phrase to analyze:");
			// Waiting for user to enter a phrase
			String phrasestr = scann.nextLine();
			
			// Judge input cannot be empty
			if((!phrasestr.trim().equals("")) && phrasestr != null){
				
				System.out.println("Enter four characters to count in phrase:");
				
				String fourcharstr = scann.nextLine();
				
				if((!fourcharstr.equals("")) && fourcharstr != null){
					
					// Convert lowercase
					phrasestr = phrasestr.toLowerCase();
					fourcharstr = fourcharstr.toLowerCase();
					
					// Remove spaces
					phrasestr = phrasestr.replace(" ", "");
					fourcharstr = fourcharstr.replace(" ","");
					
					// Just use an array to record the number of occurrences
					int[] charcount = new int[fourcharstr.length()];
					// Intermediate variables
					String tempphrasestr,fourchar;
					for(int i = 0; i < fourcharstr.length(); i++){
						// tempphrasestr Initialize phrasestr from each loop
						tempphrasestr = phrasestr;
						fourchar = fourcharstr.substring(i, i + 1); // a single character obtained in the input character
						
						// Continue counting when the characters are no longer entered in the phrase
						while(tempphrasestr.indexOf(fourchar) != -1){
							int index = tempphrasestr.indexOf(fourchar);
							tempphrasestr = tempphrasestr.substring(index + 1); // Need to add one
							charcount[i]++; // count
						}
					}
					
					System.out.print("Counts:");
					
					// print
					for(int i = 0; i < fourcharstr.length(); i++){
						System.out.print("'" +fourcharstr.substring(i, i+1) + "'" + ":" + charcount[i]);
						if(i != fourcharstr.length()-1){
							System.out.print(",");
						}
					}
					blninput = false;
				}else{
					System.out.println("Input is not allowed to be empty,please enter again");
					blninput = true;
				}
			}else{
				System.out.println("Input is not allowed to be empty,please enter again");
				blninput = true;
			}
		}
		scann.close(); // close scann
	}
}
