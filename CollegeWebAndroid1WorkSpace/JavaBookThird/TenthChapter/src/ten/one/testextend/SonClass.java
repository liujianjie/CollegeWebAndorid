package ten.one.testextend;

public class SonClass extends ParentClass{
//	public int dolt(){ 不能改写改写 返回值类型
		
//	}
	
	int a = 0;
	static int  b = 0;
	
	public SonClass() {
		// TODO Auto-generated constructor stub
		System.out.println("sonclass()");
	}
	
	public static void main(String[] args) {
//		String s = "123";
//		String s1 = s;
//		String s2 = s;
//		
//		System.out.println(s1 == s2);
//		
//		String s3 = "1234";
//		String s4 = "1234";
//		System.out.println(s3 == s4);//true
//		
//		//但是 如果new的话就不行 因为引用 是以对象为核心。？？
//		String s5 = new String("12345");
//		String s6 = new String("12345");
//		System.out.println(s5==s6);
		
		SonClass son = new SonClass();
		
	}
}
