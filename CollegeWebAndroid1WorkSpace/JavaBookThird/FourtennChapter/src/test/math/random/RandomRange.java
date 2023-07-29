package test.math.random;


public class RandomRange {
	public static void main(String[] args) {
		for(int y = 0; y < 10; y++){
			int i = (int)(Math.random()*(3-1));
			System.out.println(i);
		}
	}
}
