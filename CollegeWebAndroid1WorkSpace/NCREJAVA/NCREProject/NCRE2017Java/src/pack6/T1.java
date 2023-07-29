/*
 * T1.java
 *
 * Created on 2019年9月18日, 下午12:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack6;

/**
 *
 * @author Administrator
 */
public class T1 {
    
    /** Creates a new instance of T1 */
    public T1() {
    }
    public static void main(String [] args){
        try {
            throw new Throwable("Here is my Exception");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
