package p2615神奇的幻方;
/*
幻方是一种很神奇的 N∗NN*NN∗N 矩阵：它由数字 1,2,3,⋯⋯ ,N×N1,2,3,\cdots \cdots ,N \times N1,2,3,⋯⋯,N×N 构成，且每行、每列及两条对角线上的数字之和都相同。

当 NNN 为奇数时，我们可以通过下方法构建一个幻方：

首先将 111 写在第一行的中间。

之后，按如下方式从小到大依次填写每个数 k(k=2,3,⋯ ,N×N)k (k=2,3,\cdots,N \times N)k(k=2,3,⋯,N×N) ：

    若 (k−1)(k-1)(k−1) 在第一行但不在最后一列，则将 kkk 填在最后一行， (k−1)(k-1)(k−1) 所在列的右一列；
    若 (k−1)(k-1)(k−1) 在最后一列但不在第一行，则将 kkk 填在第一列， (k−1)(k-1)(k−1) 所在行的上一行；
    若 (k−1)(k-1)(k−1) 在第一行最后一列，则将 kkk 填在 (k−1)(k-1)(k−1) 的正下方；
    若 (k−1)(k-1)(k−1) 既不在第一行，也不在最后一列，如果 (k−1)(k-1)(k−1) 的右上方还未填数，则将 kkk 填在 (k−1)(k-1)(k−1) 的右上方，否则将 kkk 填在 (k−1)(k-1)(k−1) 的正下方。

现给定 NNN ，请按上述方法构造 N×NN \times NN×N 的幻方。

*/
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int matrix[][] = new int[N + 1][N + 1];
		matrix[1][N / 2 + 1] = 1;
		int khang[] = new int[N * N + 1];// d[i] = j,i是k，j是所在的行
		int klie[] = new int[N * N + 1];// d[i] = j,i是k，j是所在的列
		khang[1] = 1;
		klie[1] = N / 2 + 1;
		int kk;
		int curkh = 1,curkl = 1;
		for(int k = 2; k <= N * N; k++){
			kk = k - 1;
			if(khang[kk] == 1 && klie[kk] != N){
				curkh = N;
				curkl = klie[kk] + 1;
				matrix[curkh][curkl] = k;
			}
			else if(khang[kk] != 1 && klie[kk] == N){
				curkh = khang[kk] - 1;
				curkl = 1;
				matrix[curkh][curkl] = k;
			}
			else if(khang[kk] == 1 && klie[kk] == N){
				curkh = khang[kk] + 1;
				curkl = klie[kk];
				matrix[curkh][curkl] = k;
			}
			else if(khang[kk] != 1 && klie[kk] != N){
				if(matrix[khang[kk] - 1][klie[kk] + 1] == 0){
					curkh = khang[kk] - 1;
					curkl = klie[kk] + 1;
					matrix[curkh][curkl] = k;
				}else{
					curkh = khang[kk] + 1;
					curkl = klie[kk];
					matrix[curkh][curkl] = k;
				}
			}else{
				curkh = khang[kk] + 1;
				curkl = klie[kk];
				matrix[curkh][curkl] = k;
			}
			khang[k] = curkh;
			klie[k] = curkl;
		}
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= N; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
