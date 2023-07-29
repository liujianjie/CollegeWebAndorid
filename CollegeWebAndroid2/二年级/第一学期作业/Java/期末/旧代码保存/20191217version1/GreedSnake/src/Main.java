import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;
public class Main {
//    
//    public static JPanel makeVerticalFlowPanel() {
//        JPanel result = new JPanel();
//        result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
//        return result;
//    }
	static Queue<int[]> qu = new LinkedList<int[]>();
	public static void main(String[] args) {
		int val = 1 << 30;
		System.out.println(val);
		int a1[] = {1,1};
		int a2[] = {2,2};
		int a3[] = {3,3};
		int a4[] = {4,4};
		qu.add(a1);
		qu.add(a2);
		par();
		qu.poll();
		qu.add(a3);
		par();
		
	}
	public static void par(){
		int size = qu.size();
		for(int i = 0; i < size; i++){
			int z [] = qu.poll();
			System.out.println(z[0]+" "+z[1]);
		}
	}
}