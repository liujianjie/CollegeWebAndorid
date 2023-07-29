/*
 * T2.java
 *
 * Created on 2019年9月18日, 下午12:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class T2 {
    
    /** Creates a new instance of T2 */
    public T2() {
    }
    public static void main(String [] args){
        try {
            FileInputStream fis = new FileInputStream("text");
            System.out.println("content of text is");
            
        } catch(IOException e){
            System.out.println("ad");
            System.out.println(e);
        }
//        catch (FileNotFoundException e) {
//            System.out.println(e);
//            System.out.println("message:"+e.getMessage());
//            e.printStackTrace(System.out);
//        } 
    }
}
