/*
 * AwtSimple.java
 *
 * Created on 2019��9��19��, ����2:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack10;

import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.TextField;

/**
 *
 * @author Administrator
 */
public class AwtSimple extends Applet{
    TextField field;
    
    public void init(){
        field = new TextField();
        field.setEditable(false);
        setLayout(new GridLayout(1,0));
        add(field);
        validate();
        addItem("��ʼ��...");
    }

    public void start() {
        addItem("����...");
    }
    public void stop(){
        addItem("ֹͣ");
    }

    public void destroy() {
        addItem("׼��ж��");
    }
    void addItem(String newWord){
        String t = field.getText();
        System.out.println(newWord);
        field.setText(t + newWord);
    }

    /** Creates a new instance of AwtSimple */
    public AwtSimple() {
    }
    
}
