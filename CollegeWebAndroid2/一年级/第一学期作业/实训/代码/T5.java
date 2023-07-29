package pack201914;

public class T5 {
	static int ans[];
	static int num[];
	static int C[];
	static int n = 3;
	public static void main(String[] args) {
		num = new int[4];
		ans = new int[3];
		num[0] = 1;
		num[1] = 2;
		num[2] = 3;
		num[3] = 4;
		print_permutation(0,1);
	}
	static void print_permutation(int cur,int time)
	{
		// 递归边界
		if (cur == n) {
			for (int i = 0; i < n; ++i) {
				System.out.print(ans[i]);
			}
			System.out.println();
		}
		else {
			// 尝试在A[CUR]中填各种整数i
			for (int i = 0; i < 4; ++i) {
				int ok = 1;
				for (int j = 0; j < cur; ++j) {
					// 如果i已经在A[0]~A[cur-1]出现过，则不能再选
					if (ans[j] == num[i]) {
						ok = 0;
					}
				}
				if (ok == 1) {
					// 保存已经输出的值，如 1，
					ans[cur] = num[i];
					// cur 就是先输出1的序列吗？已经填好的位置个数	
					print_permutation(cur + 1, time +1);// 递归调用
				}
			}
		}
	}
}
