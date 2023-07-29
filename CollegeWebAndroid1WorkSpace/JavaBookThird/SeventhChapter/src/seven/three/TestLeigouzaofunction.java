package seven.three;

public class TestLeigouzaofunction {
	public static void main(String[] args) {
		System.out.println(args.length);
		// Test args 参数 
		for(String str: args){
			System.out.println(str);
		}
	}
	
	public TestLeigouzaofunction(){
		
		System.out.println("构造方法");
//		this("this调用有方法");不能不再第一行
	}
	
	public TestLeigouzaofunction(String str){
		
	}
}
