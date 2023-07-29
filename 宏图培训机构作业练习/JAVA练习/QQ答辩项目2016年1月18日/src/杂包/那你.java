package 杂包;
public class 那你{
	public static void main(String[] args) {
		Process pro = null;
		try {
			pro=Runtime.getRuntime().exec("E:\\宏图课程\\JAVA上课列子\\QQ\\吴彬写的标签.java");
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
