package seventeen.one.two;

public class ConstantsTest {
	enum Constants{
		Constants_A,
		Constants_B,
		Constants_C
	}
	
	public static void compare(Constants con){
		for(int i = 0; i < Constants.values().length; i++){
			System.out.println(con+"��"+Constants.values()[i]+"�Ա�"+con.compareTo(Constants.values()[i]));
		}
	}
	
	public static void main(String[] args) {
//		for(int i = 0; i < Constants.values().length; i++){
//			System.out.println("Constants��ö����ֵ�У�"+ Constants.values()[i]);
//		}
//		compare(Constants.Constants_A);

		for(int i = 0; i < Constants.values().length; i++){
			System.out.println("Constants��ö�������е�λ�������ǣ�"+ Constants.values()[i].ordinal());
		}
		Constants.valueOf("Constants_C").ordinal();//ֻ�ǵ���ö�����Constants_C
		
	}
}
