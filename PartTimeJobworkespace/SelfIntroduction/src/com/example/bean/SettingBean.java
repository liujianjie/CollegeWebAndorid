package com.example.bean;
// ���õ�bean
public class SettingBean {
	int settingid;
	int mainnum;// ��ҳһ�ж��ٸ�
	int photonum;// ���һ�ж��ٸ�
	int hobbynum;;// ����һ�ж��ٸ�
	int titlesize;// ���������С
	int titlecolor;// ������ɫ 0��ɫ��1�죬2���ƣ�3��
	int titlestyle;// ������ʽ 0Ĭ�� 1�Ӵ� 2��б 3�Ӵ���б
	
	public SettingBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SettingBean [settingid=" + settingid + ", mainnum=" + mainnum + ", photonum=" + photonum + ", hobbynum="
				+ hobbynum + ", titlesize=" + titlesize + ", titlecolor=" + titlecolor + ", titlestyle=" + titlestyle
				+ "]";
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


	public int getTitlecolor() {
		return titlecolor;
	}


	public void setTitlecolor(int titlecolor) {
		this.titlecolor = titlecolor;
	}


	public int getTitlestyle() {
		return titlestyle;
	}


	public void setTitlestyle(int titlestyle) {
		this.titlestyle = titlestyle;
	}
	
	
}


