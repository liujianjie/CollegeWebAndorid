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
		// �ݹ�߽�
		if (cur == n) {
			for (int i = 0; i < n; ++i) {
				System.out.print(ans[i]);
			}
			System.out.println();
		}
		else {
			// ������A[CUR]�����������i
			for (int i = 0; i < 4; ++i) {
				int ok = 1;
				for (int j = 0; j < cur; ++j) {
					// ���i�Ѿ���A[0]~A[cur-1]���ֹ���������ѡ
					if (ans[j] == num[i]) {
						ok = 0;
					}
				}
				if (ok == 1) {
					// �����Ѿ������ֵ���� 1��
					ans[cur] = num[i];
					// cur ���������1���������Ѿ���õ�λ�ø���	
					print_permutation(cur + 1, time +1);// �ݹ����
				}
			}
		}
	}
}
