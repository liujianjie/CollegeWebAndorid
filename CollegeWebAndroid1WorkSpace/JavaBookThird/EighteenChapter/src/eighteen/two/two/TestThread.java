package eighteen.two.two;

public class TestThread extends Thread{
	int count = 10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		while(true){
			System.out.println(count+"");
			if(--count == 0){
				return;
			}
		}
	}
	public static void main(String[] args) {
		new TestThread().start();
	}
}
