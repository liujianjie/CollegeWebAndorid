package Game2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class ��չ {
	private static final String EXIT_ON_CLOSE = null;
	AudioClip Musci_anjian, Music_shibai, Music_chenggong;
	public ��չ() {
		   try {
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		   
		    //-----------------�����ļ�---------------------
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
		new ��չ();
		
	}

	private void jbInit() {
		// TODO �Զ����ɵķ������
		
	}

	private void setDefaultCloseOperation(String exitOnClose) {
		// TODO �Զ����ɵķ������
		
	}
}
