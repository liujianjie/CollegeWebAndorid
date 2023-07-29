package seventeen.two.one;

import java.util.HashMap;
import java.util.Map;

public class TestFangxingKV<K,V> {
	private Map<K, V> map = new HashMap<K,V>();

	public V getMap(K k) {
		return map.get(k);
	}

	public void setMap(K k , V v) {// important
		map.put(k, v);
	}
	
	public static void main(String[] args) {
		TestFangxingKV<Integer, String> tfkv = new TestFangxingKV<Integer,String>();
		for(int i = 0; i < 5; i++){
			tfkv.setMap(i, "我是成员"+i);
		}
		for(int i = 0; i < 5; i++){
			System.out.println(tfkv.getMap(i));
		}
	}
}
