/*
 * T15_4_2.java
 *
 * Created on 2019年9月18日, 上午11:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack15;

import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Administrator
 */
public class T15_4_2 {
    
    /** Creates a new instance of T15_4_2 */
    public T15_4_2() {
    }
     public static void main(String []args){
        try {
            FileWriter fw = new FileWriter("word2.txt");
            String s1 = "hello 你好呀 小伙子";
            
            fw.write(s1);
            
            fw.close();
            
            FileReader fr = new FileReader("word2.txt");
            char c1[] = new char[4];
            int len;
            while((len  = fr.read(c1)) != -1)
                System.out.print(new String(c1, 0 , len));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
