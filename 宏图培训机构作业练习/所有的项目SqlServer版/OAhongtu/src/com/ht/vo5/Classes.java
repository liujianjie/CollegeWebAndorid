package com.ht.vo5;

import java.util.HashSet;
import java.util.Set;

import com.ht.vo.Emp;

/**
 * Classes entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Long classid;
	private String classname;
	private Long classcount;
	private Long empteach;		//任课老师
	private Long empteachs;		//辅导老师
	private Long empteaches;	//班主任
	private String classaddr;	//位置

	
	private Set student=new HashSet();
	
	// Constructors

	public Set getStudent() {
		return student;
	}

	public void setStudent(Set student) {
		this.student = student;
	}

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(String classname, Long classcount, Long empteach) {
		this.classname = classname;
		this.classcount = classcount;
		this.empteach = empteach;
	}

	/** full constructor */
	public Classes(String classname, Long classcount, Long empteach,
			Long empteachs, Long empteaches, String classaddr) {
		this.classname = classname;
		this.classcount = classcount;
		this.empteach = empteach;
		this.empteachs = empteachs;
		this.empteaches = empteaches;
		this.classaddr = classaddr;
	}

	// Property accessors

	public Long getClassid() {
		return this.classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Long getClasscount() {
		return this.classcount;
	}

	public void setClasscount(Long classcount) {
		this.classcount = classcount;
	}

	public Long getEmpteach() {
		return this.empteach;
	}

	public void setEmpteach(Long empteach) {
		this.empteach = empteach;
	}

	public Long getEmpteachs() {
		return this.empteachs;
	}

	public void setEmpteachs(Long empteachs) {
		this.empteachs = empteachs;
	}

	public Long getEmpteaches() {
		return this.empteaches;
	}

	public void setEmpteaches(Long empteaches) {
		this.empteaches = empteaches;
	}

	public String getClassaddr() {
		return this.classaddr;
	}

	public void setClassaddr(String classaddr) {
		this.classaddr = classaddr;
	}


}