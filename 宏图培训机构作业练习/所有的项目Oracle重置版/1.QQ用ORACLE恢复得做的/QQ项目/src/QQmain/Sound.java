package QQmain;

import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sound {
//
	public Sound(String filename) {
		try {
			FileInputStream fileau = new FileInputStream("sounds/"+filename);
			AudioStream as = new AudioStream(fileau);
			AudioPlayer.player.start(as);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
