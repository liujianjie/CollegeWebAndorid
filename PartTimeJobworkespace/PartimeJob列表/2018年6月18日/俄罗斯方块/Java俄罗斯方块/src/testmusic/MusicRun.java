package testmusic;

import java.io.FileInputStream;  
  
import sun.audio.AudioPlayer;  
import sun.audio.AudioStream;  
  
public class MusicRun {  
    public static void main(String args[]) {  
        try {  
            // 1.wav �ļ�����java project ����  
            FileInputStream fileau = new FileInputStream("music/��������2.mp3");  
            AudioStream as = new AudioStream(fileau);  
            AudioPlayer.player.start(as);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}