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
   File f = new File("C:/Users/Administrator/Desktop/����˹����/��Ч4.wav");
   cb = f.toURL();
   AudioClip aau;
   aau = Applet.newAudioClip(cb);
   aau.loop();//ѭ������  aau.play() ���� aau.stop()ֹͣ����
   JavaWavClip frame=new JavaWavClip();
   frame.setBounds(0, 0, 300, 200);
   frame.setVisible(true);
  } catch (MalformedURLException e) {
   e.printStackTrace();
  }
 }
}