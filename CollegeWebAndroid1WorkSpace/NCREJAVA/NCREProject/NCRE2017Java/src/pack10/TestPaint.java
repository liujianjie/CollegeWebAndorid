/*
 * CustomPainting.java
 *
 * Created on 2019年9月19日, 下午3:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack10;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class TestPaint extends JApplet{
    
    static String[] imageFile = {"E:\\2.jpg","E:\\3.jpg","E:\\4.gif"};

    public void init() {
        Container c = getContentPane();
        c.setLayout(new GridLayout(1,3));
        for(int i =0; i < imageFile.length; i++){
//            Image image = getImage(getCodeBase(), imageFile[i]);
            Image image = new ImageIcon(imageFile[i]).getImage();
            ImagePanel imagePanel = new ImagePanel(image);
            c.add(imagePanel);
        }
    }
    
    /** Creates a new instance of CustomPainting */
    public TestPaint() {
    }
    
}
class ImagePanel extends JPanel{
   Image image;
   public ImagePanel(Image image){
    this.image = image;
   }
   public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(image,0,0,null);
    System.out.println("");
   }
}
