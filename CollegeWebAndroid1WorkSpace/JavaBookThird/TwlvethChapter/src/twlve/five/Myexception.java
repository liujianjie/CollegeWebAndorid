package twlve.five;

public class Myexception extends Exception{
	
	String message;

	public Myexception(String str){
		message = str;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
		
	}
}
