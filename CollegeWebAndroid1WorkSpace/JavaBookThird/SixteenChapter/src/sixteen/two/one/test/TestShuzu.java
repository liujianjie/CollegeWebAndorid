package sixteen.two.one.test;

public class TestShuzu {
	public static void main(String[] args) {
		int[][] ts = new int[2][2];
		System.out.println(ts.length);
		for(int i = 0; i < ts.length; i++){
			System.out.println("testi: "+i);
			for(int n = 0; n < ts[i].length; n++){
				System.out.println("testn: "+n);
			}
		}
	}
}
