package testmp3;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.*;  
import javazoom.jl.decoder.*;  
import javazoom.jl.player.*;  
  
public class Loopmp4 extends Thread {  
  
    private Player player;  
    private String musicName;  
    private FileInputStream filein; 
  
    //º”‘ÿ“Ù¿÷  
    public Loopmp4(String musicName) throws FileNotFoundException {  
        this.musicName = musicName;
        filein = new FileInputStream(System.getProperty("user.dir") + "/music/" + musicName);  
    }  
  
    //≤•∑≈“Ù¿÷  
    public void play() {  
        try {  
        	new Player(filein).play();
        } catch (JavaLayerException ex) {  
            Logger.getLogger(Loopmp4.class.getName()).log(Level.SEVERE, null, ex);  
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
                Logger.getLogger(Loopmp4.class.getName()).log(Level.SEVERE, null, ex);  
            }  
        }  
    }  
    // Õ£÷π≤•∑≈“Ù¿÷
//    public void stopbkmusic() throws JavaLayerException{
//    }
  
}  