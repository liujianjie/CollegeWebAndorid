package �Ӱ�;
public class ����{
	public static void main(String[] args) {
		Process pro = null;
		try {
			pro=Runtime.getRuntime().exec("E:\\��ͼ�γ�\\JAVA�Ͽ�����\\QQ\\���д�ı�ǩ.java");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		   try {
			pro.waitFor( );
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
