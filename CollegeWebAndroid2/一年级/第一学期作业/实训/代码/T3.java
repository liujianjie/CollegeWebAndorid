package pack201914;

import java.util.Scanner;
public class T3 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		String outstr = "";
		int num3;
		outstr = num1 + "=";
		num3 = num1;
		if(!isSushu(num1)){
			for(int i = 2; i <= num3; i++){
				if(num3 % i == 0){
					outstr += i ;
					if(num3 / i != 1){
						outstr += "*";
					}
					num3 /= i;
					i = 1;// 重新开始。
				}
			}
			System.out.println(outstr);
		}else{
			System.out.println(num1+"="+num1);
		}
		sc.close();
	}
	//是否为素数 
	public static boolean isSushu(int num){
		for(int i = 2; i < num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
}

