package Game2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class 扩展 {
	private static final String EXIT_ON_CLOSE = null;
	AudioClip Musci_anjian, Music_shibai, Music_chenggong;
	public 扩展() {
		   try {
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		   
		    //-----------------声音文件---------------------
		   Musci_anjian = Applet.newAudioClip(new File("sounds/Centuries-Fall Out Boy.wav")
		      .toURL());
		   Music_shibai = Applet.newAudioClip(new File("sounds//shibai.wav")
		      .toURL());
		   Music_chenggong = Applet.newAudioClip(new File(
		      "sounds//chenggong.wav").toURL());
		   
		    //---------------------------------------
		    jbInit();
		   } catch (Exception exception) {
		    exception.printStackTrace();
		   }
		}
	public static void main(String sdf[]){
		new 扩展();
		
	}

	private void jbInit() {
		// TODO 自动生成的方法存根
		
	}

	private void setDefaultCloseOperation(String exitOnClose) {
		// TODO 自动生成的方法存根
		
	}
}
