package questionfour;

public class SubClass extends SuperClass{
	public void print(){
		System.out.println("Subclass��print()");
	}
	public static void main(String[] args) {
		SuperClass sb = new SubClass();
		sb.print();
	}
}
