/*
 * T15_4_1.java
 *
 * Created on 2019年9月18日, 上午11:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack15;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Administrator
 */
public class T15_4_1 {
    
    /** Creates a new instance of T15_4_1 */
    public T15_4_1() {
        
    }
    
    public static void main(String []args){
        try {
              FileOutputStream ot = new FileOutputStream("word.txt");
              byte []b = "我饿额外阿斯蒂芬阿斯蒂芬".getBytes();
              ot.write(b);
              ot.close();
              
              FileInputStream is = new FileInputStream("word.txt");
              byte []b2 = new byte[2];
              int len = 0 ;
              while( (len = is.read(b2)) != -1){
                    System.out.print(new String(b2, 0 , len));
//                    System.out.print(new String(b2, 0, len));
                    
                    
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
     
       
    }
    
}
