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
		tl.setB(new Boolean(true));//����ת��
		System.out.println(tl.getB());
		tl.setB(new Float(2.3));
		Float f = (Float)(tl.getB());//����ת��
		System.out.println(f);
		
		//����ת������ ��ᱨ��
		Integer in = (Integer) (tl.getB());
		System.out.println(in);//û���﷨����
	}
}
