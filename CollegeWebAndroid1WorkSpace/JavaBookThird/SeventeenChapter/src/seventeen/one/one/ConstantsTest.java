package seventeen.one.one;

public class ConstantsTest {
	enum Constants2{
		Constants_A,Constants_B
	}
	// ʹ�ýӿڶ��峣��
	public static void doit(int c){
		switch(c){
		case Constants.Constants_A:
			System.out.println("doit() constants_A");
			break;
		case Constants.Constants_B:
			System.out.println("doit() constants_B");
			break;
		}
	}
	
	public static void doit2(Constants2 con){
		switch(con){
		case Constants_A:
			System.out.println("doit2() Constants2.constants_A");
			break;
		case Constants_B:
			System.out.println("doit2() Constants2.constants_B");
			break;
		}
	}
	public static void main(String[] args) {
		ConstantsTest.doit(Constants.Constants_A);
		ConstantsTest.doit2(Constants2.Constants_A);
		ConstantsTest.doit2(Constants2.Constants_B);
		
		ConstantsTest.doit(3);//�����ᱨ��
//		ConstantsTest.doit2(3);//�ᱨ��
	}
}
