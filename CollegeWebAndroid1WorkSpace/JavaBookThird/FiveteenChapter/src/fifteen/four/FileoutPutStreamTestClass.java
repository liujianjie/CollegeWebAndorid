package fifteen.four;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutPutStreamTestClass {
	public static void main(String[] args) {
		try {
			FileOutputStream fi = new FileOutputStream("testoutput.txt");
			byte [] bt= "��򷢴򷢴��˿ռ���������".getBytes();
			fi.write(bt);
			fi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
