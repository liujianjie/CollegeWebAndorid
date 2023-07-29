package p1115最大子段和;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int allmaxlinum = Integer.MIN_VALUE;
		int curmaxlinnum = 0;
		int curn;
		for(int i = 0; i < n; i++){
			 curn = sc.nextInt();
			if(curmaxlinnum + curn > curn){
				curmaxlinnum = curmaxlinnum + curn;
			}else{
				curmaxlinnum = curn;
			}
			if(curmaxlinnum > allmaxlinum){
				allmaxlinum = curmaxlinnum;
			}
		}
		System.out.println(allmaxlinum);
		sc.close();
	}
}
