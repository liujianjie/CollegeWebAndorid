/*
 * ClickTest.java
 *
 * Created on 2019年9月19日, 下午3:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack10;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Administrator
 */
public class ClickTest extends Applet implements MouseListener{
    
    int num = 0;

    public void init() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        g.drawRect(0,0,getSize().width-1,getSize().height-1);
        g.drawString("鼠标在此点击"+num+"次",5,15);
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }


    public void mouseClicked(MouseEvent e) {
        num++;
        repaint();
    }

    
    /** Creates a new instance of ClickTest */
    public ClickTest() {
    }
    
}
