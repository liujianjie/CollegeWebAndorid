package seventeen.two.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class JIheLeiFangxing {
	public static void main(String[] args) {
		//ArrayList容器
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		for(int i = 0; i < A.size(); i++){
			System.out.println(A.get(i));
		}
		
		// Hashmap
		Map<Integer, String> m = new HashMap<Integer,String>();
		for(int i = 0; i < 5; i++){
			m.put(i, "成员"+i);
		}
		for(int i = 0; i < 5; i++){
			System.out.println(m.get(i));// 根据键值来
		}
		
		//定义Vector
		Vector<String> v = new Vector<String>();
		for (int i = 0; i < 5; i++){
			v.add(i+"成员");
		}
		
		for (int i = 0; i < 5; i++){
			System.out.println(v.get(i));
		}
	}
	
}
