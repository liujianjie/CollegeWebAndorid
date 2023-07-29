package com.ljj.assemble;
import java.util.List;
public class User {
	private String username;
	private Integer password;
	private List<String> list;
	// 默认构造不能少，不然不能实例化
	public User(){}
	//使用构造注入，需要提供有参构造方法
	public User(String username, Integer password, List<String> list) {
		super();
		this.username = username;
		this.password = password;
		this.list = list;
	}
	// 需要提供setter方法
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
