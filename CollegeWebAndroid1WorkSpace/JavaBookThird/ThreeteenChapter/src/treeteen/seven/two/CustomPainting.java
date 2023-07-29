/*
 * CustomPainting.java
 *
 * Created on 2019年9月19日, 下午3:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package treeteen.seven.two;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class CustomPainting extends JApplet{
    
    static String[] imageFile = {"2.jpg","3.jpg","4.gif"};

    public void init() {
        Container c = getContentPane();
        c.setLayout(new GridLayout(1,3));
        for(int i =0; i < imageFile.length; i++){
//            Image image = getImage(getCodeBase(), imageFile[i]);
            Image image = null;
			try {
				image = getImage(getCodeBase(),imageFile[i]);
				
				System.out.println(getCodeBase());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            ImagePanel imagePanel = new ImagePanel(image);
            c.add(imagePanel);
        }
    }
    
    /** Creates a new instance of CustomPainting */
    public CustomPainting() {
    }
    
}
class ImagePanel extends JPanel{
   Image image;
   public ImagePanel(Image image){
    this.image = image;
   }
   public void paintComponent(Graphics g){
    super.paintComponent(g);
    System.out.println("1");
//    g.drawImage(image,0,0,this);
//    g.drawString("12aa2", 20, 39);
   }

}
