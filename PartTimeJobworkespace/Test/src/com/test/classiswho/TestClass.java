package com.test.classiswho;

import java.util.LinkedList;

public class TestClass {
	public static void main(String[] args) {
		Music m1 = new Music("1","4",2.0,2.0,"5","6");
		System.out.println(m1 instanceof Music);
		
		Movie mv1 = new Movie();
		LinkedList list = new LinkedList();
		list.add(m1);
		list.add(mv1);
		for(Object ob: list){
			System.out.println(ob instanceof Movie);
		}
	}
}
