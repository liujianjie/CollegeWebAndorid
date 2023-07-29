package com.ht.bean;

public class Dept {
	private Integer deptno;
	private String dname;
	private String loc;

	public Dept(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	// 必须要有这个无参构造方法，不然根据UserMapper.xml中的配置，在查询数据库时，将不能反射构造出User实例
	public Dept() {
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
