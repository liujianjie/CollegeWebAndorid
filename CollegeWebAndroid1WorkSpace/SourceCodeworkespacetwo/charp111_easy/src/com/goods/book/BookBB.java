package com.goods.book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



public class BookBB {

	private static Map<String, Book> books=new LinkedHashMap<String, Book>();
	
    static{
    	
    	books.put("1", new Book("1","中国外语","wai1.png",51.0));
    	books.put("2", new Book("2","外语听声","wai2.png",88.0));
    	books.put("3", new Book("3","视唱练耳","wai3.png",37.0));
    	books.put("4", new Book("4","外语方法","wai4.png",92.0));
    	
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

