package seventeen.two.one;

public class TestFanxing<T> {
	private T over;
	private T[] array;//���巺������ 
//	private T[] array2 = new T[];// ����ʹ�÷��������������ʵ��
	
	public T getOver() {
		return over;
	}
	public void setOver(T over) {
		this.over = over;
	}
	
	
	
	public T[] getArray() {
		return array;
	}
	public void setArray(T[] array) {
		this.array = array;
	}
	public static void main(String[] args) {
		TestFanxing<String> tf = new TestFanxing<String>();
		tf.setOver("String");
		String str = tf.getOver();//�����÷��ͻ�Ҫ��ת��
		
		TestFanxing<Boolean> tf2 = new TestFanxing<Boolean>();// boolean ֻ������ ���ܷ��ڷ�������
		tf2.setOver(false);
		boolean bl = tf2.getOver();
		
		//Integer in = tf.getOver();//���� �Զ����
		
		TestFanxing<String> tf3 = new TestFanxing<String>();
		tf3.setArray(new String[]{"111","222","3333"});
		
		for(int i = 0; i < tf3.getArray().length; i++){
			System.out.println(tf3.getArray()[i]);
		}
	}
	
}
