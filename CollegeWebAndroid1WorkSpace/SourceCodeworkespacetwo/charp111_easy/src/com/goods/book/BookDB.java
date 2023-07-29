package com.goods.book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



public class BookDB {

	private static Map<String, Book> books=new LinkedHashMap<String, Book>();
	
    static{
    	books.put("1", new Book("1","scratch","book1.jpg",80.0));
    	books.put("2", new Book("2","jdbc����","book2.jpg",99.0));
    	books.put("3", new Book("3","java����","book3.jpg",43.0));
    	books.put("4", new Book("4","Struts����","book4.jpg",66.0));
    	
    	
    }
    //������е�ͼ��
    public static Collection<Book> getAll(){
    	return books.values();
    }
   //����ָ����id���ͼ��
    public static Book getBook(String id){
    	return books.get(id);
    }
    
}

