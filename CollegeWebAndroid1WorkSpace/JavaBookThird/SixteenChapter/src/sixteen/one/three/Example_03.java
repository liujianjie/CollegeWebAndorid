package sixteen.one.three;

public class Example_03 {
	static void staticMethod(){
		System.out.println("ִ�� staticMethod()����");
	}
	public int publicMethod(int i){
		System.out.println("ִ�� staticMethod()����");
		return i * 100;
	}
	protected int protectedMethod(String s, int i) throws NumberFormatException{
		System.out.println("ִ�� staticMethod()����");
		return Integer.valueOf(s);
	}
	private String privateMethod(String...strings){
		System.out.println("ִ�� staticMethod()����");
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i < stringBuffer.length(); i++){
			stringBuffer.append(strings[i]);
		}
		return stringBuffer.toString();
	}
}
