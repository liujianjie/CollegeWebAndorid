package com.bean;

// ���ﳵ��bean��û�ж�Ӧ�����ݿ��
public class BookCart {
	private int id;// ���
	private String name;// ����
	private String pic;// ͼƬ·��
	private double price;// �۸�
	private int count;// ����
	
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
