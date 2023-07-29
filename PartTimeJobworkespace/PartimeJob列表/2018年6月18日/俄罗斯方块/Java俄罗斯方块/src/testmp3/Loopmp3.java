package testmp3;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.*;  
import javazoom.jl.decoder.*;  
import javazoom.jl.player.*;  
  
public class Loopmp3 extends Thread {  
  
    private Player player;  
    private String musicName;  
    private FileInputStream filein; 
  
    //º”‘ÿ“Ù¿÷  
    public Loopmp3(String musicName){  
        this.musicName = musicName;  
        try {
			filein = new FileInputStream(System.getProperty("user.dir") + "/" + musicName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }  
  
    //≤•∑≈“Ù¿÷  
    public void play() {  
        try {  
        	new Player(filein).play();    
        } catch (JavaLayerException ex) {  
            Logger.getLogger(Loopmp3.class.getName()).log(Level.SEVERE, null, ex);  
        }  
    }  
  
    //—≠ª∑≤•∑≈“Ù¿÷  
    public void loop() {  
        this.start();  
    }  
  
    @Override  
    public void run() {  
        while (true) {  
            try {  
            	 new Player(filein).play();   
            } catch (JavaLayerException ex) {  
                Logger.getLogger(Loopmp3.class.getName()).log(Level.SEVERE, null, ex);  
            }  
        }  
    }  
  
}  