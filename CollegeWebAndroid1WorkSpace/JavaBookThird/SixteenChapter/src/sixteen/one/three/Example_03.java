package sixteen.one.three;

public class Example_03 {
	static void staticMethod(){
		System.out.println("执行 staticMethod()方法");
	}
	public int publicMethod(int i){
		System.out.println("执行 staticMethod()方法");
		return i * 100;
	}
	protected int protectedMethod(String s, int i) throws NumberFormatException{
		System.out.println("执行 staticMethod()方法");
		return Integer.valueOf(s);
	}
	private String privateMethod(String...strings){
		System.out.println("执行 staticMethod()方法");
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i < stringBuffer.length(); i++){
			stringBuffer.append(strings[i]);
		}
		return stringBuffer.toString();
	}
}
