package eleven.three;

final class finalclass {
	int a = 3;
	void doit(){
		
	}
	public static void main(String[] args) {
		finalclass fc = new finalclass();
		fc.a++;
		System.out.println(fc.a);
		fc.doit();
	}
	void doit(int a){}
}
