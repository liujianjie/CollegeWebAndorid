/*
 * SwingSimpleAwt.java
 *
 * Created on 2019年9月19日, 下午2:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack10;

import java.awt.Container;
import javax.swing.JApplet;
import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.JTextField;
/**
 *
 * @author Administrator
 */
public class SwingSimpleAwt extends JApplet{
      JTextField field;
    
    public void init(){
        Container contentPane = getContentPane();
        field = new JTextField();
        field.setEditable(false);
        contentPane.setLayout(new GridLayout(1,0));
        contentPane.add(field);
        addItem("初始化...");
    }

    public void start() {
        addItem("启动...");
    }
    public void stop(){
        addItem("停止");
    }

    public void destroy() {
        addItem("准备卸载");
    }
    void addItem(String newWord){
        String t = field.getText();
        System.out.println(newWord);
        field.setText(t + newWord);
    }
    
    /** Creates a new instance of SwingSimpleAwt */
    public SwingSimpleAwt() {
    }
    
}
