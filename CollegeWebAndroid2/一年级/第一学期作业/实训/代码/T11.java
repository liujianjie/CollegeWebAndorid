package pack201914;

import java.util.Scanner;

public class T11 {
	public static void main(String[] args) {
		int zimu = 0, span = 0,num = 0,other = 0;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] str_c = str.toCharArray();
		int asc = 0;
		for(int i = 0; i < str_c.length; i++){
			asc = (int)str_c[i];
			if(asc == 32){
				span++;
			}else if(asc >= 49 && asc <= 57){
				num++;
			}else if(asc >= 65 && asc <= 90 || asc >= 97 && asc <= 122){
				zimu++;
			}else{
				other++;
			}
		}
		System.out.println("英文字母："+zimu);
		System.out.println("数字："+num);
		System.out.println("空格："+span);
		System.out.println("其它："+other);
		sc.close();
	}
}
