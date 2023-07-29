package p1957ø⁄À„¡∑œ∞Ã‚;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.valueOf(sc.nextLine());
		String scstr;
		String[] numberarr;
		char curop = '+';
		char lastop = '+';
		int aopv;
		int num1, num2;
		String operastr;
		for(int i = 0; i < size; i++){
			scstr = sc.nextLine();
			numberarr = scstr.split(" ");
			if(numberarr.length > 2){
				curop = numberarr[0].charAt(0);
				num1 = Integer.valueOf(numberarr[1]);
				num2 = Integer.valueOf(numberarr[2]);
				aopv = Operator(curop, num1, num2);
			}else{
				num1 = Integer.valueOf(numberarr[0]);
				num2 = Integer.valueOf(numberarr[1]);
				aopv = Operator(lastop, num1, num2);
			}
			lastop = curop;
			operastr = num1+""+returnchar(lastop)+""+num2+"="+aopv;
			System.out.println(operastr);
			System.out.println(operastr.length());
		}
		sc.close();
	}
	public static int Operator(char op, int num1, int num2){
		switch (op) {
		case 'a':
			return num1 + num2;
		case 'b':
			return num1 - num2;
		case 'c':
			return num1 * num2;
		}
		return 0;
	}
	public static char returnchar(char op){
		switch (op) {
		case 'a':
			return '+';
		case 'b':
			return '-';
		case 'c':
			return '*';
		}
		return '+';
	}
}
