package com.goods.book;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String path;
	private double price;
	public Book(){
	}
	
	public Book(String id, String name,String path,double price){
		this.id =id;
		this.name=name;
		this.path =path;
		this.price=price;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id =id;
	}
	public String getName(){
		return name;
	}
	public void setName(String id){
		this.name =name;
	}
	public String getPath(){
		return path;
	}
	public void setPath(String id){
		this.path =path;
	}
	public double getPrice(){
		 return price;
	}
	public void setPrice(double id){
		this.price =price;
	}
	
	}

	



