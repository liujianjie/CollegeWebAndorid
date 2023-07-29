package twlve.four;

public class T2 {
	public static void main(String[] args) {
		try {
			System.out.println("bbbbbbbbbbb");
			int i = 100 / 0;
			System.out.println("aaaaaaaaaaa");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e);
		}
		System.out.println("cc");
	}
}
