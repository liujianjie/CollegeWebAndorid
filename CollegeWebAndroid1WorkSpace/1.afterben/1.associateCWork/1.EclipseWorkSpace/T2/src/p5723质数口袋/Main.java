package p5723质数口袋;
// 不要复制
/*
小 A 有一个质数口袋，里面可以装各个质数。他从 222 开始，依次判断各个自然数是不是质数，如果是质数就会把这个数字装入口袋。
口袋的负载量就是口袋里的所有数字之和。但是口袋的承重量有限，不能装得下总和超过 LLL（1≤L≤1051 \le L \le {10}^51≤L≤105）
的质数。给出 LLL，请问口袋里能装下几个质数？将这些质数从小往大输出，然后输出最多能装下的质数个数，所有数字之间有一空行。
*/
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int sum = 0;
		boolean iszhi;
		int count = 0;// 个数
		for(int i = 2; (sum + i) <= L; i++){// 注意条件
			iszhi = true;
			for(int j = 2; j < i; j++){
				if(i % j == 0){
					iszhi = false;
				}
			}
			if(iszhi){
				count++;
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println(count);
		sc.close();
	}
}