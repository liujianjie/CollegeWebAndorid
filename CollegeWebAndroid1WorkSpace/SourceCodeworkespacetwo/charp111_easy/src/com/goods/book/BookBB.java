package com.goods.book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



public class BookBB {

	private static Map<String, Book> books=new LinkedHashMap<String, Book>();
	
    static{
    	
    	books.put("1", new Book("1","�й�����","wai1.png",51.0));
    	books.put("2", new Book("2","��������","wai2.png",88.0));
    	books.put("3", new Book("3","�ӳ�����","wai3.png",37.0));
    	books.put("4", new Book("4","���﷽��","wai4.png",92.0));
    	
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

