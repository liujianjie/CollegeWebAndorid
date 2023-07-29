package pack;

public class Car {
	private int weight;
	private String color;
	private int N;
	private int speed;
	private boolean gps;
	
	public void change(String color){
		this.color = color;
	}
	public void change(String color, boolean gps){
		this.gps = gps;
	}
	public void print_Info(){
		String isgps = gps == true ? "有":"无";
		System.out.println("车速："+speed+",车重："+weight+",颜色："+color+"，"+isgps+"gps");
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getN() {
		return N;
	}
	public void setN(int n) {
		N = n;
	}
	public int getSpeed() {
		return this.speed = N * 30;
	}
//	public void setSpeed() {
//		this.speed = N * 30;
//	}
	public boolean isGps() {
		return gps;
	}
	public void setGps(boolean gps) {
		this.gps = gps;
	}
	public static void main(String[] args) {
		Car ca = new Car();
		ca.setColor("黄色");
		ca.setGps(true);
		ca.setN(20);
		ca.setWeight(30);
		ca.print_Info();
		ca.change("绿色");
		ca.print_Info();
		ca.change("金色", false);
		ca.print_Info();
	}
}
