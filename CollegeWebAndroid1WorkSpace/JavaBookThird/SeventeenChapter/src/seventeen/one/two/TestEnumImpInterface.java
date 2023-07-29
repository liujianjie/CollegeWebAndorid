package seventeen.one.two;

public enum TestEnumImpInterface implements D{
	Constants_A{//可以在内部实现该方法

		@Override
		public String getDescripe() {
			return "我是枚举成员A";
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	},
	Constants_C{//可以在内部实现该方法

		@Override
		public String getDescripe() {
			return "我是枚举成员C";
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return 2;
		}
		
	},
	Constants_B{//可以在内部实现该方法

		@Override
		public String getDescripe() {
			return "我是枚举成员B";
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return 1;
		}
		
	};
	
	private static int i = 5;
	public static void main(String[] args) {
		for(int i = 0; i < TestEnumImpInterface.values().length; i++){
			System.out.println(TestEnumImpInterface.values()[i] + "调用GetDescription（）方法为:" + TestEnumImpInterface.values()[i].getDescripe());
			System.out.println(TestEnumImpInterface.values()[i] + "调用GetI（）方法为:" + TestEnumImpInterface.values()[i].getI());
			
		}
	}
}
