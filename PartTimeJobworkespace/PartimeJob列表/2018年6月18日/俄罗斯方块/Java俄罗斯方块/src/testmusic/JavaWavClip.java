package testmusic;
import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;
public class JavaWavClip extends Frame{
 
 public JavaWavClip(){
  super();
 }
 public static void main(String args[]) {
  try {
   URL cb;
   File f = new File("C:/Users/Administrator/Desktop/俄罗斯方块/音效4.wav");
   cb = f.toURL();
   AudioClip aau;
   aau = Applet.newAudioClip(cb);
   aau.loop();//循环播放  aau.play() 单曲 aau.stop()停止播放
   JavaWavClip frame=new JavaWavClip();
   frame.setBounds(0, 0, 300, 200);
   frame.setVisible(true);
  } catch (MalformedURLException e) {
   e.printStackTrace();
  }
 }
}