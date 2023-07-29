package eleven.three;

class Parents{
	private final void doIt(){
		System.out.println("父类 doit");
	}
	public final void doIt1(){
		System.out.println("父类 doit1");
	}
	public void doIt2(){
		System.out.println("父类 doit2");
	}
	
	private void say(){
		System.out.println("say();");
	}
	
}

class Sub extends Parents{
	
	public final void doIt(){
		System.out.println("子类 doit");
	}
//	public final void doIt1(){ //不能覆盖
//		System.out.println("子类 doit1");
//	}
	public void doIt2(){
		System.out.println("子类 doit2");
	}
}

public class FinalMethod {
	public static void main(String[] args) {
		Sub s = new Sub();
		s.doIt();
		s.doIt2();
		Parents p = s;
		p.doIt1();
		p.doIt2();
//		p.doIt();//无法访问 因为 是s子类向上转型，而不能访问子类的doIt 说明 新建了个doIt方法

		
	}
	
}
