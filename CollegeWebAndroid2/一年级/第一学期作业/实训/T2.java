package javaoneʵѵ;

public class T2 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 12,count = 1; i <= 202; i += 10,count++)
			if(count % 2 == 1)
				sum += i;
			else
				sum -= i;
		System.out.println(sum);
		int counts = 0;
		for(int i = 22; i <= 202; i += 20)
			counts++;
		System.out.println(counts * -10);
		System.out.println(((202 - 22) / 20 + 1)*-10);
	}
}

