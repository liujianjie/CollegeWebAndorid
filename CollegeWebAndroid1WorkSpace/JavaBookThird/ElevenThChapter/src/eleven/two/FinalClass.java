package eleven.two;

import java.util.Random;

class Test{
	int i = 0;
}

public class FinalClass {
	static Random r = new Random();
	private final int VALUE_1 = 8;
	private static final int VALUE_2 = 0;
	private final Test test = new Test();
	private Test test2 = new Test();
	private final static int[] a = {1,2,3,4,5};
	public static void main(String[] args) {
		FinalClass fi = new FinalClass();
		//fi.test = new Test();//���ܽ� final������ ָ����������
		//fi.VALUE_1 = 1;//����
		fi.test.i = 0; //���Զ�final�������еĳ�Ա����
		fi.test2 = new Test();		// ���Զ�û��final������ָ����������
		fi.a[2] = 4; 
		
		for(int i = 0; i < fi.a.length; i++){
			a[i] = 9;
		}
		
		System.out.println(a[4]);
	}
}
