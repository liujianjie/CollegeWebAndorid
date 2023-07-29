/*
 * Hello.java
 *
 * Created on 2019年9月19日, 下午7:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack104;

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author Administrator
 */
public class Hello extends Applet{
    
    /** Creates a new instance of Hello */
    public Hello() {
    }

    public void paint(Graphics g) {
        g.drawString("Hello world",25,25);
    }
    

}
