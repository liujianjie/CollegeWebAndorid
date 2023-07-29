package questionfour;

public class OverloadTest {
	public static void main(String[] args) {
		book(1,"一千零一夜");
		book("活着",2);
		book("Java从入门到精通");
	}
	public static void book(int id,String name){
		System.out.println("我是"+name+",我的id是"+id);
	}
	public static void book(String name,int id){
		System.out.println("我的id是"+id+",我是"+name);
	}
	public static void book(String name){
		System.out.println("我是"+name);
	}
}
