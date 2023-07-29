package javaoneʵѵ;

public class T666 {
	public static void main(String[] args) {
		int count = 0;
		int curval = 5,temps,finalval;
		int num[] = new int[5];
		num[4] = 6;
		for(int i = num.length - 2; i >= 0; i--){
			num[i] = num[i+1] * 5 + 1;
		}
		for(int i = 0; i < 5; i++){
			System.out.println(num[i]);
		}
	}
}
