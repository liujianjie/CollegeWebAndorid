package fifteen.six;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DataInputOrOUT {
	public static void main(String[] args) {
		try {
			FileOutputStream fs = new FileOutputStream("E:/word.txt");
			DataOutputStream ds = new DataOutputStream(fs);
			ds.writeUTF("ʹ��writeUFT����д������");
			ds.writeChars("ʹ��writeCharд������");
			ds.writeBytes("ʹ��writeBytesд������");
			ds.close();
			FileInputStream fis = new FileInputStream("E:/word.txt");
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readUTF());
			System.out.println(dis.readByte());//Ϊʲô����ʹ��chars bytes
			System.out.println(dis.readByte());
			dis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
}
