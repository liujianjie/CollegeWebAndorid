package goods.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
    private static Map<String, Book> books = new LinkedHashMap<String, Book>();

    static {
        books.put("1", new Book(1, "javaweb开发", "book1.jpg", 9.08));
        books.put("2", new Book(2, "jdbc", "book2.jpg", 67.0));
        books.put("3", new Book(3, "jhhh", "book3.jpg", 43.0));
        books.put("4", new Book(4, "struts", "book4.jpg", 118.0));

    }

    //获得所有图书
    public static Collection<Book> getAll() {
        return books.values();
    }//根据指定id获得图书

    public static Book getBook(String id) {
        return books.get(id);
    }
}