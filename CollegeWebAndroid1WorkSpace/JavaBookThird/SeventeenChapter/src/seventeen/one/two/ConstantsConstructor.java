package seventeen.one.two;

public class ConstantsConstructor {
	enum Constants{
		Constants_A("����ö�ٳ�ԱA"),
		Constants_B("����ö�ٳ�Աb"),
		Constants_C("����ö�ٳ�ԱC"),
		Constants_D(3);//�������ΪString��
		
		String description;
		int i = 4;
		private Constants(){//���췽��������ö��������ͬ ����ʵ����ö�� ��������Ϊpublic
			
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
			System.out.println(Constants.values()[i]+"����getDescription()����Ϊ��"+Constants.values()[i].getDescription());
		}
		System.out.println(Constants.valueOf("Constants_D")+"����GetI()����Ϊ��"+Constants.valueOf("Constants_D").getI());
	}
}
