package com.ht.yfbc.pojo;

import java.io.Serializable;
/**
 * <p>Users类的扩展类</p>
 * <p>pname:岗位名称（position类）</p>
 * <p>lmtlist:权限列表（permissions类）</p>
 * <p>Day 2016-12-28</p>
 * @author 刘宗龙
 *
 */
public class UsersVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users users;
	private String pname;
	private String lmtlist;
	public UsersVo() {
	}
	public UsersVo(Users users, String pname, String lmtlist) {
		super();
		this.users = users;
		this.pname = pname;
		this.lmtlist = lmtlist;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getLmtlist() {
		return lmtlist;
	}
	public void setLmtlist(String lmtlist) {
		this.lmtlist = lmtlist;
	}
	@Override
	public String toString() {
		return "UsersVo [users=" + users + ", pname=" + pname + ", lmtlist=" + lmtlist + "]";
	}
	
	
}
