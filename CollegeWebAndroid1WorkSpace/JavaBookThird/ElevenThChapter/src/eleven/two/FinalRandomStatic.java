package eleven.two;

import java.util.Random;

public class FinalRandomStatic {
	private static Random rand = new Random();
	private final int a1 = rand.nextInt(10);
	private final static int a2 = rand.nextInt(10);
	
	public static void main(String[] args) {
		FinalRandomStatic rs = new FinalRandomStatic();
		System.out.println("a1 "+ rs.a1);
		System.out.println("a2 "+ rs.a2);
		
		FinalRandomStatic rs2 = new FinalRandomStatic();
		System.out.println("a1 " + rs2.a1);
		System.out.println("a2 "+ rs2.a2);//被修饰成 final static 的 a2在内存开辟了一块区域 再次实例化使用 还是那个值
	}
}
