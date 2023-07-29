package seventeen.one.two;

public class ConstantsConstructor {
	enum Constants{
		Constants_A("我是枚举成员A"),
		Constants_B("我是枚举成员b"),
		Constants_C("我是枚举成员C"),
		Constants_D(3);//构造参数为String的
		
		String description;
		int i = 4;
		private Constants(){//构造方法名称与枚举名称相同 不能实例化枚举 不能设置为public
			
		}
		private Constants(String description){
			this.description = description;
		}
		private Constants(int i){
			this.i = this.i+i;
			
		}
		public String getDescription() {
			return description;
		}
		public int getI() {
			return i;
		}
		
	}
	public static void main(String[] args) {
		for(int i = 0; i < Constants.values().length; i++){
			System.out.println(Constants.values()[i]+"调用getDescription()方法为："+Constants.values()[i].getDescription());
		}
		System.out.println(Constants.valueOf("Constants_D")+"调用GetI()方法为："+Constants.valueOf("Constants_D").getI());
	}
}
