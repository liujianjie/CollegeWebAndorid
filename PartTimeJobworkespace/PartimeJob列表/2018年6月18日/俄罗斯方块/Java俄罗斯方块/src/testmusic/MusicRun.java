package testmusic;

import java.io.FileInputStream;  
  
import sun.audio.AudioPlayer;  
import sun.audio.AudioStream;  
  
public class MusicRun {  
    public static void main(String args[]) {  
        try {  
            // 1.wav 文件放在java project 下面  
            FileInputStream fileau = new FileInputStream("music/背景音乐2.mp3");  
            AudioStream as = new AudioStream(fileau);  
            AudioPlayer.player.start(as);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}