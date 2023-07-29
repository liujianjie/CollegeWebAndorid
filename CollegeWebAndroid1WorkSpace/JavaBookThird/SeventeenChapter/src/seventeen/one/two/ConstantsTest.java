package seventeen.one.two;

public class ConstantsTest {
	enum Constants{
		Constants_A,
		Constants_B,
		Constants_C
	}
	
	public static void compare(Constants con){
		for(int i = 0; i < Constants.values().length; i++){
			System.out.println(con+"与"+Constants.values()[i]+"对比"+con.compareTo(Constants.values()[i]));
		}
	}
	
	public static void main(String[] args) {
//		for(int i = 0; i < Constants.values().length; i++){
//			System.out.println("Constants的枚举数值有："+ Constants.values()[i]);
//		}
//		compare(Constants.Constants_A);

		for(int i = 0; i < Constants.values().length; i++){
			System.out.println("Constants在枚举类型中的位置索引是："+ Constants.values()[i].ordinal());
		}
		Constants.valueOf("Constants_C").ordinal();//只是调用枚举里的Constants_C
		
	}
}
