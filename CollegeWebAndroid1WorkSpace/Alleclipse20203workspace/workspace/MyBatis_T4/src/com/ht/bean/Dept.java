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

	// ����Ҫ������޲ι��췽������Ȼ����UserMapper.xml�е����ã��ڲ�ѯ���ݿ�ʱ�������ܷ��乹���Userʵ��
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
