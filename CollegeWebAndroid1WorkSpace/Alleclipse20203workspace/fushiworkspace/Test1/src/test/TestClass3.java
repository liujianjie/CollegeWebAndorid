package test;

public class TestClass3 {
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		try {
			int a = 1;
			System.out.println("1");
			return;
		} catch (Exception e) {
			System.out.println("11");
			// TODO: handle exception
		} finally{
			System.out.println("2");
		}
	}
}
