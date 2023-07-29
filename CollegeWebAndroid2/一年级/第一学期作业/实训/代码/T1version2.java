package pack201914;

public class T1version2 {
	public static void main(String[] args) {
		int num[] = new int[4];
		int C[] = new int[4];
		int cur = 0;
		num[0] = 1;
		num[1] = 2;
		num[2] = 3;
		num[3] = 4;
		int ok;
		for(int i = 0; i < 4; i++){
			cur = 0;
			C[cur++] = num[i]; 
			for(int j = 0; j < 4; j++){
				if(num[j] != num[i]){
					cur = 1;
					C[cur] = num[j]; 
					for(int k = 0; k < 4; ++k){
						ok = 1;
						for (int m = 0; m <= cur; ++m) {
							if (C[m] == num[k]) {
								ok = 0;
							}
						}
						if(ok == 1){
							cur = 2;
							C[cur] = num[k];
							if(cur == 2){
								System.out.print(C[0]+" "+C[1]+" "+C[2]);
								System.out.println();
							}
						}
					}
				}
			}
		}
	}
}
/*
 * 
ok = 1;
for (int k = 0; k <= cur; ++k) {
	if (C[k] == num[j]) {
		ok = 0;
	}
}
if(ok == 1){
	C[++cur] = num[j];
	if(cur == 2){
		System.out.print(C[0]+" "+C[1]+" "+C[2]);
		cur = 1;
		System.out.println();
	}
}
*/
