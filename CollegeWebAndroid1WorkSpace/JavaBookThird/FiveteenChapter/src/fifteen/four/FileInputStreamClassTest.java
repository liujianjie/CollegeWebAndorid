package fifteen.four;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileInputStreamClassTest {
	public static void main(String[] args) {
		try {
			FileInputStream fot = new FileInputStream("E:/testoutput.txt");
			byte[] bt = new byte[2];
//			int str	= fot.read(bt);
//			System.out.println(new String(bt,0 , str));
			while(fot.read(bt) > 0){
				System.out.println(new String(bt));
			}
			
			fot.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println(FileInputStream.class.getResource("/FileInputStreamClassTest.java"));
	}
}
