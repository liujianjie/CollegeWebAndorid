package com.goods.book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



public class BookAB {

	private static Map<String, Book> books=new LinkedHashMap<String, Book>();
	
    static{
    	
    	books.put("1", new Book("1","绘画欣赏","art1.png",55.0));
    	books.put("2", new Book("2","素描写生","art2.png",44.0));
    	books.put("3", new Book("3","艺术拍摄","art3.png",77.0));
    	books.put("4", new Book("4","彩绘","art4.png",93.0));
    	
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

