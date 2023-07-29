package com.example.bean;
// 设置的bean
public class SettingBean {
	int settingid;
	int mainnum;// 主页一行多少个
	int photonum;// 相册一行多少个
	int hobbynum;;// 爱好一行多少个
	int titlesize;// 标题字体大小
	
	public SettingBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "SettingBean [settingid=" + settingid + ", mainnum=" + mainnum + ", photonum=" + photonum + ", hobbynum="
				+ hobbynum + ", titlesize=" + titlesize + "]";
	}


	public SettingBean(int settingid, int mainnum, int photonum, int hobbynum, int titlesize) {
		super();
		this.settingid = settingid;
		this.mainnum = mainnum;
		this.photonum = photonum;
		this.hobbynum = hobbynum;
		this.titlesize = titlesize;
	}
	public int getSettingid() {
		return settingid;
	}
	public void setSettingid(int settingid) {
		this.settingid = settingid;
	}
	public int getMainnum() {
		return mainnum;
	}
	public void setMainnum(int mainnum) {
		this.mainnum = mainnum;
	}
	public int getPhotonum() {
		return photonum;
	}
	public void setPhotonum(int photonum) {
		this.photonum = photonum;
	}
	public int getHobbynum() {
		return hobbynum;
	}
	public void setHobbynum(int hobbynum) {
		this.hobbynum = hobbynum;
	}
	public int getTitlesize() {
		return titlesize;
	}
	public void setTitlesize(int titlesize) {
		this.titlesize = titlesize;
	}
}
