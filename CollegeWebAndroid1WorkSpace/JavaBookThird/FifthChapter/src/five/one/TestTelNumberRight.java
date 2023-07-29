package five.one;

public class TestTelNumberRight {
	public static void main(String[] args) {
		String regex = "[^a-zA-Z]*\\d{11}";
//		String num1 = "12345678911";
		String num1 = "123458911";
//		String num1 = "~3";
		
		System.out.println(num1.matches(regex));
	}
}
