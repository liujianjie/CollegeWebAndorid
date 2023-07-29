package eighteen.four.three;

public class InterruptedTest implements Runnable{
	private boolean iscoutinue = false;
	
	public void run(){
		while(true){
			
			if(iscoutinue){
				break;
			}
		}
	}
}
