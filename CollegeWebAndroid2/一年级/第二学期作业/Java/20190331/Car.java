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
		String isgps = gps == true ? "��":"��";
		System.out.println("���٣�"+speed+",���أ�"+weight+",��ɫ��"+color+"��"+isgps+"gps");
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
		ca.setColor("��ɫ");
		ca.setGps(true);
		ca.setN(20);
		ca.setWeight(30);
		ca.print_Info();
		ca.change("��ɫ");
		ca.print_Info();
		ca.change("��ɫ", false);
		ca.print_Info();
	}
}
