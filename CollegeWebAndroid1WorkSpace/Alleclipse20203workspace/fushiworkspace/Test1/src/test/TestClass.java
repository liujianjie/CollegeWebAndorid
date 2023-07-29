package test;

public class TestClass {
	class Inner{}
	public static void main(String[] args) {
		
		Integer int1 = 100, int2 = 100;
		Integer int3 = new Integer(100);
		int int4 = 100;
		Integer int5 = 150, int6 = 150;
		System.out.println(int1 == int2);
		System.out.println(int2 == int3);
		System.out.println(int1 == int3);
		System.out.println(int1 == int4);
		System.out.println(int5 == int6);
		System.out.println(Math.round(11.5));
		System.out.println(Math.round(-11.5));
	}
	
}
