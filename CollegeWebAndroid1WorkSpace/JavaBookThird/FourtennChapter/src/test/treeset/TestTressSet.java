package test.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TestTressSet {
	public static void main(String[] args) {
		TreeSet<Emp> ts = new TreeSet<Emp>();
		
		Emp e1 = new Emp(1, "张三");
		Emp e2 = new Emp(2, "李四");
		Emp e3 = new Emp(3, "王五");
		Emp e4 = new Emp(4, "燕小六");
		
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		ts.add(e4);
		
		Iterator<Emp> it = ts.iterator();
		while(it.hasNext()){
			Emp em = it.next();
			System.out.println(em.getId()+"  "+em.getName());
		}
	}
}
