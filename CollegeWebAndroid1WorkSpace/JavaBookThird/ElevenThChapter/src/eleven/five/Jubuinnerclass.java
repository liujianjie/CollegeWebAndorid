package eleven.five;



public class Jubuinnerclass {
	

	public outinterface otinterface(final String x){
		 class innerclass implements outinterface{

			public innerclass(String s) {
				// TODO Auto-generated constructor stub
				s = x;
				System.out.println(s);
			}
			
			@Override
			public void doit() {
				// TODO Auto-generated method stub
				System.out.println("innerclass.doit()");
			}
			
		}
		return new innerclass("doit");
	}
	
	public static void main(String[] args) {
		Jubuinnerclass ju = new Jubuinnerclass();
		outinterface oi = ju.otinterface("hello");
		oi.doit();
	}
}
