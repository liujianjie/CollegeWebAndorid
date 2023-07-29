


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.*;  
import javazoom.jl.decoder.*;  
import javazoom.jl.player.*;  
  
public class TetrisMp3 extends Thread {  
  
    private static Player player;  
    private static String musicName;  
    private static FileInputStream filein; 
  
    //º”‘ÿ“Ù¿÷  
    public TetrisMp3(String musicName){  
        this.musicName = musicName;  
        try {
			filein = new FileInputStream(System.getProperty("user.dir") + "/music/" + musicName);
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
            Logger.getLogger(TetrisMp3.class.getName()).log(Level.SEVERE, null, ex);  
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
                Logger.getLogger(TetrisMp3.class.getName()).log(Level.SEVERE, null, ex);  
            }  
        }  
    }  
  
}  