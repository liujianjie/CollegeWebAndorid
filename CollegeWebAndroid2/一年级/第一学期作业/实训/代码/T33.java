package pack201914;

// 这个三角形要我命，唉，这都不会写了我，有点垃圾，一看就应该想到前面是空格，后面是数字，而不应该像数字占的列，sb啊我，主要是/t不能一个语句输出两个，那就多几个输出语句呀。。
import java.util.Scanner;

public class T33 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int num[][] = new int[n + 1][n + 1];
			int i,j;
			for (i = 0; i < n; i++) {
				for (j = 0; j < (n - i - 1); j++){
					System.out.print("    ");
				}
				for (j = 0; j <= i; j++) {
					if (i == j || j == 0) {
						num[i][j] = 1;
					} else {
						num[i][j] = num[i][j - 1] * (i - j + 1) / j;
					}
					System.out.print("   ");
					System.out.print(num[i][j]);
					System.out.print("   ");
				}
				System.out.println();
			}
			sc.close();
		}
	}

