/*
 * T1.java
 *
 * Created on 2019年9月18日, 上午10:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack12;

/**
 *
 * @author Administrator
 */
public class T1 {
    
    /** Creates a new instance of T1 */
    public T1() {
    }
    public void f1(){
         try {
          int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
    }
    public void f2(){
        try {
          f1();
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
    }
    public void f3(){
        try {
            f2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String []args){
        
        T1 t1 = new T1();
        t1.f3();
    }
}
