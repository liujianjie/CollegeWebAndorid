/*
 * T3.java
 *
 * Created on 2019年9月18日, 下午12:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack6;

/**
 *
 * @author Administrator
 */
public class T3 {
    
    /** Creates a new instance of T3 */
    public T3() {
    }
    public static void rt() throws Exception{
        System.out.println("old eception in rt()");
        throw new Exception("thrown from rt()");
    }
    public static void wq() throws Throwable{
        try {
            rt();
        } catch (Exception e) {
            System.out.println("Inside wq(),e.printStackTrace();");
            e.printStackTrace();
            throw e;
        }
    }
     public static void main(String [] args) throws Throwable{
         try {
             wq();
         } catch (Exception e) {
             System.out.print("Caught in main, e.printStackTrace();");
             e.printStackTrace();
         }
     }
}
