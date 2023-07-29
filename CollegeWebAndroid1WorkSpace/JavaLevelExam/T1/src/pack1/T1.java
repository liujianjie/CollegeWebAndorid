package pack1;


class Father{
	
	int val1;
}

class Child extends Father{
	int val2;
}
public class T1 {
	public static void main(String[] args) {
		Father f1 = new Child();
		System.out.println(f1.val1);
//		System.out.println(f1.val2);
		Child f2 = new Child();
		System.out.println(f2.val2);
		
		test2((Child)f1);
	}
	static void test(Father f){
		System.out.println(f.val1);
	}
	static void test2(Child c){
		System.out.println(c.val2);
	}
}
