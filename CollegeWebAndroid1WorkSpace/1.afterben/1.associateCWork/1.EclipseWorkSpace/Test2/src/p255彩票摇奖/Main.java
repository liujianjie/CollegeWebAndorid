package p255²ÊÆ±Ò¡½±;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int countarr[] = new int[8];// ÖÐ½±´ÎÊý
		List<Integer> zjlist = new ArrayList<Integer>();
		for(int i = 0; i < 7; i++){
			zjlist.add(sc.nextInt());
		}
		int countcor;
		for(int i = 0; i < size; i++){
			countcor = 0;
			for(int j = 0; j < 7; j++){
				if(zjlist.contains(sc.nextInt())){
					countcor++;
				}
			}
			countarr[countcor]++;
		}
		for(int i = 7; i > 0; i--){
			System.out.print(countarr[i] + " ");
		}
		sc.close();
	}
}
