package fifteen.four.two;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTestClass {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("E:/testFilewriter.txt");
			fw.write("的法定flak大家flak江东父老抗啊打发");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
