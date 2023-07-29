package testmusic;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class PlayerCTL {
	File wavFile = null;

	  // 打开文件
	  public void openSong(String strFileName) {
	   try {
	    wavFile = new File(strFileName);
	   } catch (Exception ex) {
	    ex.printStackTrace();
	   }
	  }

	  // 播放文件
	  public void play() {
	   try {
	    AudioInputStream ais = AudioSystem.getAudioInputStream(wavFile);
	    AudioFormat af = ais.getFormat();
	    SourceDataLine sdl = null;
	    DataLine.Info dinfo = new DataLine.Info(SourceDataLine.class,
	      af);
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
	    
	    // 是否持续播放
	    // 循环播放,只有在设置为循环播放时才使用循环播放功能
	    // 单次播放和不播放情况下均不进行循环动作
//	    DesignPanelConfigTitle designPanelConfigTitle = DesignPanelTitle
//	    .getInstance().getConfig();
//	    int nPlayType = designPanelConfigTitle.getBakSndDisType();
//	    switch (nPlayType) {
//	    case LuckyChooserConst.SND_DIS_TYPE_DISVISIBLE:
//	     break;
//	    case LuckyChooserConst.SND_DIS_TYPE_SINGLE:
//	     break;
//	    case LuckyChooserConst.SND_DIS_TYPE_LOOP:
//	     getPlayerCTL().openSong(getSongFileName());
//	     getPlayerCTL().play();
//	     break;
//	    default:
//	    }
	   } catch (Exception ex) {
	    ex.printStackTrace();
	   }
	  }
	  public void Restart(int lReadBytes,byte[] lbytes,AudioInputStream ais,SourceDataLine sdl){
		  while (lReadBytes != -1) {
		     try {
				lReadBytes = ais.read(lbytes, 0, lbytes.length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     if (lReadBytes > 0) {
		      sdl.write(lbytes, 0, lReadBytes);
		     }
		   }
	  }
}
