import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

	public void playWavfile(String filename) {
		try {
			// 1.wav 文件放在java project 下面
			filein = new FileInputStream("music/" + filename);
			as = new AudioStream(filein);
			AudioPlayer.player.start(as);

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void playWavfile2(String wavFile) {
		try{
			File file = new File("music/" + wavFile);
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
			ais.close();
			sdl.close();
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		TetrisWav te = new TetrisWav();
//		
//		te.playWavfile2("music/音效1.wav");
//	}
}
