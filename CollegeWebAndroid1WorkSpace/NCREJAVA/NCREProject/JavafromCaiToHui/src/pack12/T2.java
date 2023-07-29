/*
 * T2.java
 *
 * Created on 2019年9月18日, 上午11:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pack12;

/**
 *
 * @author Administrator
 */
public class T2 {
    
    /** Creates a new instance of T2 */
    public T2() {
    }   
    public static void main(String [] args){
        T2.Inner1 ti1 = new T2().new Inner1();
        try{

//            ti1.cal();
                        throw ti1;
        }catch(Inner1 tiex){
            System.out.println(tiex.getMessage());
        }
    }
    
    class Inner1 extends Throwable{
        public void cal(){
            int a = 10 / 0;
        }
        public String getMessage() {
            return "first extends Throwable;";
        }
    }
}
