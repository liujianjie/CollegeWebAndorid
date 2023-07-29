package eighteen.two.two;

public class TestRunnable implements Runnable{

	int count = 10;
	@Override
	public void run() {
		while(true){
			System.out.println(count+"");
			if(--count == 0){
				return;
			}
		}
		
	}
	public static void main(String[] args) {
		TestRunnable run = new TestRunnable();
		Thread th = new Thread(run);
		th.start();
	}
}
