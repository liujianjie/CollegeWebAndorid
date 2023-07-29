package com.goods.book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



public class BookCB {

	private static Map<String, Book> books=new LinkedHashMap<String, Book>();
	
    static{
    	books.put("1", new Book("1","财经高校","cai1.png",83.0));
    	books.put("2", new Book("2","财经审计","cai2.png",99.0));
    	books.put("3", new Book("3","会计","cai3.png",43.0));
    	books.put("4", new Book("4","演算","cai4.png",66.0));
    	
    	
    }
    //获得所有的图书
    public static Collection<Book> getAll(){
    	return books.values();
    }
   //根据指定的id获得图书
    public static Book getBook(String id){
    	return books.get(id);
    }
    
}

