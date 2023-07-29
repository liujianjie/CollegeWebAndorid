package fifteen.five.one;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class BufferdInputStreamTestClass {
	public static void main(String[] args) {
		try {
			FileInputStream fi = new FileInputStream("E:/testBufferOutputStream.txt");
			BufferedInputStream bi = new BufferedInputStream(fi);
			byte [] bt = new byte[2];
			
			int r = bi.read(bt);
			System.out.println(new String(bt,0,r));
			fi.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
