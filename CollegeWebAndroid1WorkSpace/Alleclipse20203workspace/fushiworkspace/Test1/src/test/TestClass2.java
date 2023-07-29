package test;

public class TestClass2 {
//	static class inner{}
	class inner{}
	public static void Test1() {
//		new inner();
		new TestClass2().new inner();
	}
	public void Test2() {
		new inner();
	}
	public static void main(String[] args) {
//		new inner();
		new TestClass2().new inner();
	}
}
