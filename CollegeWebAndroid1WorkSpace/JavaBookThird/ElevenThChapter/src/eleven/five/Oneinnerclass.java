package eleven.five;

public class Oneinnerclass {
	innerclass ic = new innerclass();
	int y = 5;
	
	public void ouf(){
		ic.inf();
	}
	
	class innerclass{
		int x = 0;
		public innerclass(){
			System.out.println("innerclass");
		}
		public void inf(){
			System.out.println("inf()");
		}
		
	}
	public innerclass doit(){
		return new innerclass();
	}
	
	public static void main(String[] args) {
		Oneinnerclass out = new Oneinnerclass();
		Oneinnerclass.innerclass ic2 = out.new innerclass();
		
		Oneinnerclass.innerclass ic3 = out.doit();
	}
	
}
