package fifteen.four.two;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderTestClass {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("E:/testFilewriter.txt");
			char [] bt = new char[2];
			
			int currlen = 0;
			int len = 0;
			while(fr.read() > 0){
				len += fr.read(bt);
				System.out.println(new String(bt));
				currlen += len;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
