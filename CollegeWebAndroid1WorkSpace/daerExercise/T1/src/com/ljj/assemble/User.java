package com.ljj.assemble;
import java.util.List;
public class User {
	private String username;
	private Integer password;
	private List<String> list;
	// Ĭ�Ϲ��첻���٣���Ȼ����ʵ����
	public User(){}
	//ʹ�ù���ע�룬��Ҫ�ṩ�вι��췽��
	public User(String username, Integer password, List<String> list) {
		super();
		this.username = username;
		this.password = password;
		this.list = list;
	}
	// ��Ҫ�ṩsetter����
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	// tostring
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", list=" + list + "]";
	}
}
