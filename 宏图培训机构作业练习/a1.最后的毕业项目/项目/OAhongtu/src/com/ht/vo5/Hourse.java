package com.ht.vo5;

import java.util.HashSet;
import java.util.Set;

/**
 * Hourse entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Hourse implements java.io.Serializable {

	// Fields

	private Long hourid;
	private Long eid;
	private String hourname;
	private Long hhead;
	private Long hnumber;

	// Constructors
	
	private Set student=new HashSet();
	
	public Set getStudent() {
		return student;
	}

	public void setStudent(Set student) {
		this.student = student;
	}
	private Elements elements;

	public Elements getElements() {
		return elements;
	}

	public void setElements(Elements elements) {
		this.elements = elements;
	}

	/** default constructor */
	public Hourse() {
	}

	/** minimal constructor */
	public Hourse(String hourname) {
		this.hourname = hourname;
	}

	/** full constructor */
	public Hourse(Long eid, String hourname, Long hhead, Long hnumber) {
		this.eid = eid;
		this.hourname = hourname;
		this.hhead = hhead;
		this.hnumber = hnumber;
	}

	// Property accessors

	public Long getHourid() {
		return this.hourid;
	}

	public void setHourid(Long hourid) {
		this.hourid = hourid;
	}

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getHourname() {
		return this.hourname;
	}

	public void setHourname(String hourname) {
		this.hourname = hourname;
	}

	public Long getHhead() {
		return this.hhead;
	}

	public void setHhead(Long hhead) {
		this.hhead = hhead;
	}

	public Long getHnumber() {
		return this.hnumber;
	}

	public void setHnumber(Long hnumber) {
		this.hnumber = hnumber;
	}

	

}