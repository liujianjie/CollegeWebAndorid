package testmp3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;

public class ImpMp3 {
	public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
//		Loopmp3 loop = new Loopmp3(" /music/ " + "��������2.mp3");
//		System.out.println(System.getProperty("user.dir") + "/music/" + "��������2.mp3");
		
		Loopmp4 loop = new Loopmp4("��������2.mp3");
		loop.loop();
//		loop.stopbkmusic();
	}
}
