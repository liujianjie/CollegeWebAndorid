package pack201914;

// ���������Ҫ�����������ⶼ����д���ң��е�������һ����Ӧ���뵽ǰ���ǿո񣬺��������֣�����Ӧ��������ռ���У�sb���ң���Ҫ��/t����һ���������������ǾͶ༸��������ѽ����
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

