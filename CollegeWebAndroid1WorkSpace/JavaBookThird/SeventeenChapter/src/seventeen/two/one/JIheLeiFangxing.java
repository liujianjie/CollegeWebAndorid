package seventeen.two.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class JIheLeiFangxing {
	public static void main(String[] args) {
		//ArrayList����
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		for(int i = 0; i < A.size(); i++){
			System.out.println(A.get(i));
		}
		
		// Hashmap
		Map<Integer, String> m = new HashMap<Integer,String>();
		for(int i = 0; i < 5; i++){
			m.put(i, "��Ա"+i);
		}
		for(int i = 0; i < 5; i++){
			System.out.println(m.get(i));// ���ݼ�ֵ��
		}
		
		//����Vector
		Vector<String> v = new Vector<String>();
		for (int i = 0; i < 5; i++){
			v.add(i+"��Ա");
		}
		
		for (int i = 0; i < 5; i++){
			System.out.println(v.get(i));
		}
	}
	
}
