package questionthree;

public class Animal {
	private String name;

	private void fly(){
		System.out.println("I can fly");
	}
	protected void getfly() {
		fly();
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
}
