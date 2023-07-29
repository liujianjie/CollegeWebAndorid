package eleven.five;

interface outinterface{
	public void doit();
}

public class InnerclassImpInterface {
	
	private class innerclass implements outinterface{

		@Override
		public void doit() {
			// TODO Auto-generated method stub
			System.out.println("innerclass.doit()");
		}
		
	}
	public outinterface otinterface(){
		return new innerclass();
	}
	
	public static void main(String[] args) {
		InnerclassImpInterface iiface = new InnerclassImpInterface();
		outinterface oi = iiface.otinterface();
		oi.doit();
	}
}
