package fifteen.five.one;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferOutputStreamTestClass {
	public static void main(String[] args) {
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("E:/testBufferOutputStream.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedOutputStream bo = new BufferedOutputStream(fo);
		byte [] bt = "��������ͷ�������ҷ��忨���ǵ�������".getBytes();
		try {
			bo.write(bt);
			bo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
