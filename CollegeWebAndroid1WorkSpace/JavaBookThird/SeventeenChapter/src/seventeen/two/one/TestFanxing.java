package seventeen.two.one;

public class TestFanxing<T> {
	private T over;
	private T[] array;//定义泛型数组 
//	private T[] array2 = new T[];// 不能使用泛型来建立数组的实例
	
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
		String str = tf.getOver();//不设置泛型会要求转型
		
		TestFanxing<Boolean> tf2 = new TestFanxing<Boolean>();// boolean 只是引用 不能放在泛型里面
		tf2.setOver(false);
		boolean bl = tf2.getOver();
		
		//Integer in = tf.getOver();//不行 自动检测
		
		TestFanxing<String> tf3 = new TestFanxing<String>();
		tf3.setArray(new String[]{"111","222","3333"});
		
		for(int i = 0; i < tf3.getArray().length; i++){
			System.out.println(tf3.getArray()[i]);
		}
	}
	
}
