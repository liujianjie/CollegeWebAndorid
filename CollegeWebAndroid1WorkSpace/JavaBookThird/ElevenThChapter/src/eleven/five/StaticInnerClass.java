package eleven.five;

public class StaticInnerClass {
	int x = 100;
	static int y = 50;
	static class staticinner{
		public void doit(){
			//System.out.println(x);//不行
			System.out.println(y);
		}
		public static void main(String[] args) {
			System.out.println("staticinner");
		}
	}
	public static void main(String[] args) {
		staticinner st = new staticinner();//不需要外部类
		st.doit();
	}
}
