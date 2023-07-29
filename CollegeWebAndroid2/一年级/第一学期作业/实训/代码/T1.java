package pack201914;

public class T1 {
	public static void main(String[] args) {
		int num[] = new int[4];
		num[0] = 1;
		num[1] = 2;
		num[2] = 3;
		num[3] = 4;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(j != i){
					for(int k = 0; k < 4; ++k){
						if(k != j && k != i){
							System.out.print(num[i]+" "+num[j]+" "+num[k]);
							System.out.println();
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
