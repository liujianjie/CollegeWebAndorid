package seventeen.two.one;

public class TestOriginal {
	private Object b;
	public Object getB(){
		return b;
	}
	public void setB(Object b){
		this.b = b;
	}
	
	public static void main(String[] args) {
		TestOriginal tl= new TestOriginal();
		tl.setB(new Boolean(true));//向上转型
		System.out.println(tl.getB());
		tl.setB(new Float(2.3));
		Float f = (Float)(tl.getB());//向下转型
		System.out.println(f);
		
		//假如转错类型 则会报错
		Integer in = (Integer) (tl.getB());
		System.out.println(in);//没有语法错误
	}
}
