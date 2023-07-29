package com.example.bean;
// ͼƬ
public class PhotoBean {
	int photoid;// ͼƬid 
	String photouri;// ͼƬ·��
	public PhotoBean(int photoid, String photouri) {
		super();
		this.photoid = photoid;
		this.photouri = photouri;
	}
	public PhotoBean() {
	}
	public int getPhotoid() {
		return photoid;
	}
	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}
	public String getPhotouri() {
		return photouri;
	}
	public void setPhotouri(String photouri) {
		this.photouri = photouri;
	}
	
	
}
