/*
 * DukeWave.java
 *
 * Created on 2019年9月19日, 下午6:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack104;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */
public class DukeWave extends Applet implements Runnable{
    
    /** Creates a new instance of DukeWave */
    public DukeWave() {
    }
    
    private Thread duke;
    private Image image;
    private boolean flag;
    int frameNum = 0;
    int delay = 200;
    Image[] images = new Image[12];
    public void init(){
//        delay = Integer.parseInt(getParameter("delay"));
        for(int i = 1; i <= 12; i++){
//            images[i-1] = getImage(getCodeBase(),"T"+i+".gif");
             images[i-1]  = new ImageIcon("E:\\animg\\a"+i+".png").getImage();
        }
        
        image = images[0];
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent ev){
                if(duke == null)
                    start();
                else
                    stop();
            }
            
        });
    }
    public void start(){
        flag = true;
        duke = new Thread(this);
        duke.start();
        showStatus("Click to stop");
    }
    public void stop(){
        flag = false;
        duke = null;
        showStatus("click to restart");
    }

    public void paint(Graphics g) {
        g.drawImage(image,0,0,null);
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        while(flag){
            repaint();
            synchronized(""){
                if(frameNum < 11)
                    frameNum++;
                else
                    frameNum = 0;
                try{
                    Thread.sleep(delay);
                }catch(Exception e){
                }
                image = images[frameNum];
            }
        }
        
    }

}
