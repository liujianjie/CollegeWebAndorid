package questionfive;

public class Tran {
	public void TestThrowException(int x) throws Myexception{
		if(x < 0 || x > 100){
			throw new Myexception("数值太大或者太小");
		}
	}
	
	public static void main(String[] args) {
		Tran r =new Tran();
		try {
			System.out.println("aaaaaaaaaaaaa");
			r.TestThrowException(-2);
			System.out.println("bbbbbbbbbbbbbbbbbb");
		} catch (Myexception e) {
//			e.printStackTrace();
			System.out.println(e);
		}
		System.out.println("continue");
	}
}
