package pack201914;

import java.util.Scanner;
public class T4 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		String outstr = "";
		int num3;
		for(;num1 <= num2; num1++){
			outstr = num1 + "=";
			num3 = num1;// 运算后的值不一样
			// 不是素数就进行运算
			if(!isSushu(num1)){
				for(int i = 2; i <= num3; i++){
					// 是否能除以 能的话进行输出准备 以及 重新赋值 num3 
					if(num3 % i == 0){
						outstr += i ;
						// 这个是到尾最后一个因素就不要再加上 *了
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

