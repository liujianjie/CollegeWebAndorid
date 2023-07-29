/*
 * T4.java
 *
 * Created on 2019年9月18日, 下午1:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack7;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class T4 {
    
    /** Creates a new instance of T4 */
    public T4() {
    }
    public static void main(String[] args){
        try {
            PrintWriter pw = new PrintWriter("word3.txt");
            String s1 = "你好呀 小小达达美年达";
            pw.write(s1);
            pw.close();
            
            Scanner sc = new Scanner(new FileReader("word3.txt"));
            System.out.println(sc.next());
            System.out.println(sc.next());
//            System.out.println(sc.nextLine());
            
        } catch (Exception e) {
            
        }
    }
}
