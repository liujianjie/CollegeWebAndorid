package seventeen.two.four;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Tongpeifu <T extends List>{
	public static void main(String[] args) {
//		Tongpeifu<? extends List> tpf = null;
//		tpf = new Tongpeifu<ArrayList>();
//		tpf = new Tongpeifu<LinkedList>();
		
		List<String> l1 = new ArrayList<String>();
		l1.add("成员");
		List<?> l2 = l1;
		List<?> l3 = new LinkedList<Integer>(); // ？可以接受String 也可以Integer 但是用?的不能set值 只能获取和删除
		
//		l2.add("1221");
//		l2.set(0,"///");
//		l3.add("12");
//		l3.set(0, "12321");
		l2.get(0);
		l2.remove(0);
		
		//向上限制
		Tongpeifu<? super List> a = null;
		a = new Tongpeifu<List>();
//		a = new Tongpeifu<ArrayList>();//不行 不是上层
//		a = new Tongpeifu<Collection<List>>(); // 奇怪 object 和 这个都不行
	}
	
	//通配符方法
	public void doSomething(Tongpeifu<? extends List> a){
		
	}
}
