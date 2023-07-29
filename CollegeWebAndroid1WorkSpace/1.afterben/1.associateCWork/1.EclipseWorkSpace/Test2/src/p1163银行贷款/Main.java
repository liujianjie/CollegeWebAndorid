package p1163银行贷款;
// 暴力 1000+（1+x） - 100 = y
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int returnm = sc.nextInt();
		int month = sc.nextInt();
		float yue; 
		float i;
		for(i = 0.001f; i < 1; i += 0.1){
			yue = (float)money; 
			for(int j = 1; j <= month; j++){
				yue = yue + yue *(i) - returnm;
			}
			if(yue <= 0){
				break;
			}
		}
		System.out.println(i * 100);
		
		sc.close();
	}
	
}
