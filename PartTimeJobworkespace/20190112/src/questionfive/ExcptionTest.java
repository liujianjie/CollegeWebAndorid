package questionfive;

public class ExcptionTest {
	public static void main(String[] args) {
		try {
			int get = 10 / 0;
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("continue");
	}
}
