package questionfour;

public class SubClass extends SuperClass{
	public void print(){
		System.out.println("Subclass£ºprint()");
	}
	public static void main(String[] args) {
		SuperClass sb = new SubClass();
		sb.print();
	}
}
