package one;

public class Demo02 {
	public static void main(String[] args) {
		for(int i = 0; i < 9; i++){
			for(int j = 0; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 9; i > 0; i--){
			for(int j = i; j > 0; j--){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 9; i > 0; i--){
			for(int j = 1; j <= i; j++){
				System.out.print((10 - i) + "*" + j + "=" + (i * j) + "\t");
			}
			System.out.println();
		}
	}
}
