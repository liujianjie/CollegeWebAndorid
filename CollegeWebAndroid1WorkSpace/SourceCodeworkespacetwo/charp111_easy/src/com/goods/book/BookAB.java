package com.goods.book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



public class BookAB {

	private static Map<String, Book> books=new LinkedHashMap<String, Book>();
	
    static{
    	
    	books.put("1", new Book("1","�滭����","art1.png",55.0));
    	books.put("2", new Book("2","����д��","art2.png",44.0));
    	books.put("3", new Book("3","��������","art3.png",77.0));
    	books.put("4", new Book("4","�ʻ�","art4.png",93.0));
    	
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

