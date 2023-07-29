/*
 * T1.java
 *
 * Created on 2019年9月19日, 下午7:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack105;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 *
 * @author Administrator
 */
public class T1 {
    
    /** Creates a new instance of T1 */
    public T1() {
    }
    public static void main(String args[])
    {
        AudioClip a1 = new Applet().getAudioClip("E:\\popo.mid");
        a1.play();
    }
}
