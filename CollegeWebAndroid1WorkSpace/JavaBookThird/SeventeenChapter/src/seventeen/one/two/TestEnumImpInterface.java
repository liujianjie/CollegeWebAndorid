package seventeen.one.two;

public enum TestEnumImpInterface implements D{
	Constants_A{//�������ڲ�ʵ�ָ÷���

		@Override
		public String getDescripe() {
			return "����ö�ٳ�ԱA";
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	},
	Constants_C{//�������ڲ�ʵ�ָ÷���

		@Override
		public String getDescripe() {
			return "����ö�ٳ�ԱC";
		}

		@Override
		public int getI() {
			// TODO Auto-generated method stub
			return 2;
		}
		
	},
	Constants_B{//�������ڲ�ʵ�ָ÷���

		@Override
		public String getDescripe() {
			return "����ö�ٳ�ԱB";
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
			System.out.println(TestEnumImpInterface.values()[i] + "����GetDescription��������Ϊ:" + TestEnumImpInterface.values()[i].getDescripe());
			System.out.println(TestEnumImpInterface.values()[i] + "����GetI��������Ϊ:" + TestEnumImpInterface.values()[i].getI());
			
		}
	}
}
