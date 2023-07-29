package testmusic;



//import javazoom.jlgui.basicplayer.BasicPlayerEvent;
//
//import com.hf.app.lucky.config.DesignPanelConfigTitle;
//import com.hf.app.lucky.design.DesignPanelTitle;

public class PlayerWavStatic {

 // 播放器使用单例模式
 private static PlayerWavStatic instace = null;

 public static PlayerWavStatic getInstance() {
  if (instace == null) {
   instace = new PlayerWavStatic();
  }
  return instace;
 }

 private PlayerWavStatic() {
 }

 // PlayerCTL
 private PlayerCTL playerCTL = null;

 public PlayerCTL getPlayerCTL() {
  if (playerCTL == null) {
   playerCTL = new PlayerCTL();
  }
  return playerCTL;
 }

 // wav文件名
 private String strSongFileName = null;

 public String getSongFileName() {
  return strSongFileName;
 }

 public void setSongFileName(String szSongFileName) {
  if (strSongFileName == null) {
   strSongFileName = new String(szSongFileName);
  } else {
   strSongFileName = szSongFileName;
  }
 }

 public void playSong(String strFilePath) {
  setSongFileName(strFilePath);
  getPlayerCTL().openSong(getSongFileName());
  getPlayerCTL().play();
 }
 public static void main(String[] args) {
	 PlayerWavStatic pw = new PlayerWavStatic();
	 pw.playSong("C:/Users/Administrator/Desktop/俄罗斯方块/音效1.wav");
}
}