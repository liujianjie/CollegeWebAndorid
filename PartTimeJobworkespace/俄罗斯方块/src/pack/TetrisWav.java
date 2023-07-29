package pack;
import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class TetrisWav {
	private static FileInputStream filein;
	private static AudioStream as;
	private static File file;
	
	public void playWavfile(String filename){ //简单快 并行 ，但是可能会对内存泄露
		try {  
            // 1.wav 文件放在java project / music下面  JCREATOR编译器是写../music/，eclipse是music/
            filein = new FileInputStream("music/"+filename); 
            as = new AudioStream(filein);  
            AudioPlayer.player.start(as);  
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	public void playWavfileSave(String filename) { // 能更好控制流 更不会造成内存泄露，但是慢，因为字节读取 while
		try{
			file = new File("music/"+filename); //文件地址
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			AudioFormat af = ais.getFormat();
			SourceDataLine sdl = null;
			DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class, af);
			sdl = (SourceDataLine) AudioSystem.getLine(dinfo);
			sdl.open(af);
			byte[] lbytes = new byte[sdl.available()];
			int lReadBytes = 0;
			sdl.start();
			while (lReadBytes != -1) {
				lReadBytes = ais.read(lbytes, 0, lbytes.length);
				if (lReadBytes > 0) {
					sdl.write(lbytes, 0, lReadBytes);
				}
			}
			//关闭流
			ais.close();
			sdl.close();
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		TetrisWav te = new TetrisWav();
		te.playWavfile("音效1.wav");
		te.playWavfileSave("音效1.wav");
	}
}
