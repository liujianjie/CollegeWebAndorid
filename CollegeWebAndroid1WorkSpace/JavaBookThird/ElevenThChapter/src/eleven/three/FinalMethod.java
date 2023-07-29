package eleven.three;

class Parents{
	private final void doIt(){
		System.out.println("���� doit");
	}
	public final void doIt1(){
		System.out.println("���� doit1");
	}
	public void doIt2(){
		System.out.println("���� doit2");
	}
	
	private void say(){
		System.out.println("say();");
	}
	
}

class Sub extends Parents{
	
	public final void doIt(){
		System.out.println("���� doit");
	}
//	public final void doIt1(){ //���ܸ���
//		System.out.println("���� doit1");
//	}
	public void doIt2(){
		System.out.println("���� doit2");
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
//		p.doIt();//�޷����� ��Ϊ ��s��������ת�ͣ������ܷ��������doIt ˵�� �½��˸�doIt����

		
	}
	
}
