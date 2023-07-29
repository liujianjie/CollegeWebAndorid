package eighteen.six.one;

public class ThreadSafeTest extends Thread{
	int count = 10;
	
	public void sendTicket(){
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while( true){
			if(count > 0 ){
			
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("count值"+count);
				count--;
			}else{
				break;
			}
		}
	}
	public static void main(String[] args) {
//		Thread threada = new ThreadSafeTest();
//		Thread threadb = new ThreadSafeTest();
//		Thread threadc = new ThreadSafeTest();
//		Thread threadd = new ThreadSafeTest();
//		threada.start();
//		threadb.start();
//		threadc.start();
//		threadd.start(); 错误的东西 因为各自实例了ThreadSafeTest
		ThreadSafeTest tst = new ThreadSafeTest();
		Thread threada = new Thread(tst);
		Thread threadb = new Thread(tst);
		Thread threadc = new Thread(tst);
		Thread threadd = new Thread(tst);
		threada.start();
		threadb.start();
		threadc.start();
		threadd.start();
		
		
	}
}
