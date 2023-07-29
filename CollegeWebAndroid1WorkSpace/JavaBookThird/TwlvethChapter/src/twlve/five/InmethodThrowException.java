package twlve.five;

public class InmethodThrowException {
	public int TestMyexceptionAndOtherExcetion(int x , int y) throws Myexception{
		if(x < 0 | x > 100 ){
			throw new Myexception("数值问题");
		}
		return x/y;
	}
	public static void main(String[] args) {
		
		InmethodThrowException in = new InmethodThrowException();
		
		try {
			System.out.println("111111");
			in.TestMyexceptionAndOtherExcetion(-6, 0);
			System.out.println("22222");
		} catch (ArithmeticException e){
			System.out.println(e.getMessage());;
		}catch (Myexception e) {
			// TODO Auto-generated catch block
//			System.out.println(e);
			System.out.println(e.getMessage());
		} catch(Exception e){
			e.printStackTrace();
		}
		
		for(int i = 0; i < 10; i++){
			System.out.println(i);
		}
	}
}
