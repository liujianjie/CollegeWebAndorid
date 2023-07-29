package twentythree.seven;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class TestDesktopClass {
	public static void main(String[] args) {
		while(true){
			Scanner scan = new Scanner(System.in);
			int val = scan.nextInt();
			try {
				openDesk(val);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void openDesk(int index) throws Exception{
		if (Desktop.isDesktopSupported()) {
			Desktop desk = Desktop.getDesktop();
			switch (index) {
			case 1:
				if(desk.isSupported(Desktop.Action.BROWSE)){
					desk.browse(new URI("http://www.baidu.com"));
				}
				break;
			case 2:
				if(desk.isSupported(Desktop.Action.EDIT)){
					desk.edit(new File("E:/word.txt"));
				}
				break;
			case 3:
				if(desk.isSupported(Desktop.Action.OPEN)){
					desk.edit(new File("G:/2018年无聊看的/IMG_20180602_152157.jpg"));
				}
				break;
			case 5:

				break;
			default:
				break;
			}
		}

	}
}
