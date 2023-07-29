package com.goods.bean;
 
import java.io.Serializable;
 
// 图书bean，对应数据库表goods
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;// id
	private String name;// 书名
	private double price;// 价格
	private String pic;// 图片路径
	private String intro;// 图书简介
	private String catalog;// 所属分类
 
	public Book() {
	}
 
	public Book(int id, String name, String pic, double price) {
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.price = price;
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public double getPrice() {
		return price;
	}
 
	public void setPrice(double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}	
 
}