package com.ht.vo5;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Long intenid;
	private String intenname;
	private String intensch;
	private String intensex;
	private Long intenage;
	private String intenhob;
	private String intenbir;
	private String intenfat;
	private String intentel;
	private String intenfatel;
	private String intenaddr;
	private String intenpeo;
	private String intenjob;
	private String intenimg;
	private Long intenstatus;
	private Long classid;
	private Long hourid;
	private String intentime;
	private Long state;
	private Classes classes;
	private Hourse hourse;
	
	// Constructors

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Hourse getHourse() {
		return hourse;
	}

	public void setHourse(Hourse hourse) {
		this.hourse = hourse;
	}

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String intenname, String intensch, String intensex,
			Long intenage, String intenhob, String intenbir, String intenfat,
			String intentel, String intenfatel, String intenaddr,
			String intenpeo, String intenjob, String intenimg,
			Long intenstatus, Long classid, Long hourid, String intentime,Long state) {
		this.intenname = intenname;
		this.intensch = intensch;
		this.intensex = intensex;
		this.intenage = intenage;
		this.intenhob = intenhob;
		this.intenbir = intenbir;
		this.intenfat = intenfat;
		this.intentel = intentel;
		this.intenfatel = intenfatel;
		this.intenaddr = intenaddr;
		this.intenpeo = intenpeo;
		this.intenjob = intenjob;
		this.intenimg = intenimg;
		this.intenstatus = intenstatus;
		this.classid = classid;
		this.hourid = hourid;
		this.intentime = intentime;
		this.state=state;
	}

	// Property accessors

	public Long getIntenid() {
		return this.intenid;
	}

	public void setIntenid(Long intenid) {
		this.intenid = intenid;
	}

	public String getIntenname() {
		return this.intenname;
	}

	public void setIntenname(String intenname) {
		this.intenname = intenname;
	}

	public String getIntensch() {
		return this.intensch;
	}

	public void setIntensch(String intensch) {
		this.intensch = intensch;
	}

	public String getIntensex() {
		return this.intensex;
	}

	public void setIntensex(String intensex) {
		this.intensex = intensex;
	}

	public Long getIntenage() {
		return this.intenage;
	}

	public void setIntenage(Long intenage) {
		this.intenage = intenage;
	}

	public String getIntenhob() {
		return this.intenhob;
	}

	public void setIntenhob(String intenhob) {
		this.intenhob = intenhob;
	}

	public String getIntenbir() {
		return this.intenbir;
	}

	public void setIntenbir(String intenbir) {
		this.intenbir = intenbir;
	}

	public String getIntenfat() {
		return this.intenfat;
	}

	public void setIntenfat(String intenfat) {
		this.intenfat = intenfat;
	}

	public String getIntentel() {
		return this.intentel;
	}

	public void setIntentel(String intentel) {
		this.intentel = intentel;
	}

	public String getIntenfatel() {
		return this.intenfatel;
	}

	public void setIntenfatel(String intenfatel) {
		this.intenfatel = intenfatel;
	}

	public String getIntenaddr() {
		return this.intenaddr;
	}

	public void setIntenaddr(String intenaddr) {
		this.intenaddr = intenaddr;
	}

	public String getIntenpeo() {
		return this.intenpeo;
	}

	public void setIntenpeo(String intenpeo) {
		this.intenpeo = intenpeo;
	}

	public String getIntenjob() {
		return this.intenjob;
	}

	public void setIntenjob(String intenjob) {
		this.intenjob = intenjob;
	}

	public String getIntenimg() {
		return this.intenimg;
	}

	public void setIntenimg(String intenimg) {
		this.intenimg = intenimg;
	}

	public Long getIntenstatus() {
		return this.intenstatus;
	}

	public void setIntenstatus(Long intenstatus) {
		this.intenstatus = intenstatus;
	}

	public Long getClassid() {
		return this.classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public Long getHourid() {
		return this.hourid;
	}

	public void setHourid(Long hourid) {
		this.hourid = hourid;
	}

	public String getIntentime() {
		return this.intentime;
	}

	public void setIntentime(String intentime) {
		this.intentime = intentime;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

}