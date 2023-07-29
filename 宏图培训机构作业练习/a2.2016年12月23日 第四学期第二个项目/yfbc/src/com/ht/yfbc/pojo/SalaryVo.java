package com.ht.yfbc.pojo;

import java.io.Serializable;
/**
 * <p>Salary类的扩展类</p>
 * <p>username:用户名（users类）</p>
 * <p>positionname:岗位名称</p>
 * <p>Day 2017-1-3</p>
 * @author 刘宗龙
 *
 */
public class SalaryVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Salary salary;
	private String username;
	private String positionname;
	public SalaryVo() {
	}
	public SalaryVo(Salary salary, String username, String positionname) {
		this.salary = salary;
		this.username = username;
		this.positionname = positionname;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	@Override
	public String toString() {
		return "SalaryVo [salary=" + salary + ", username=" + username + ", positionname=" + positionname + "]";
	}
	
}
