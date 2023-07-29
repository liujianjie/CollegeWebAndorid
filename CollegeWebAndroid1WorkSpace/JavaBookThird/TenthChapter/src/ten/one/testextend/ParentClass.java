package ten.one.testextend;

public class ParentClass {
	int a = 0;
	static int b = 0;
	
	public ParentClass(){
		System.out.println("ParentClass()");
	}
	
	public static void say(){
		System.out.println("static say()");
	}
	
	public void talk(){
		System.out.println("talk()");
	}
	
	protected ParentClass dolt(){
		
		return this;
	}
}
