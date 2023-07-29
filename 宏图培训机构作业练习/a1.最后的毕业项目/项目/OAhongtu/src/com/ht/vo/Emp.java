package com.ht.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ht.vo2.Discuss;

/**
 * Emp entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Long eid;
	private String ename;
	private String esex;
	private Long did;
	private String ecertid;
	private String ecity;
	private String edu;
	private String eaddr;
	private Date etry;
	private Long estatus;
	private String myqq;
	private String zhuanye;
	private String hunyin;
	private String jwork;
	private String favorite;
	private String techang;
	private String face;
	private String ephone;
	private Long eday;
	private Long disid;

	// Constructors

	/** default constructor */
	public Emp() {
	}


	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsex() {
		return this.esex;
	}

	public void setEsex(String esex) {
		this.esex = esex;
	}

	public Long getDid() {
		return this.did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getEcertid() {
		return this.ecertid;
	}

	public void setEcertid(String ecertid) {
		this.ecertid = ecertid;
	}

	public String getEcity() {
		return this.ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

	public String getEdu() {
		return this.edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getEaddr() {
		return this.eaddr;
	}

	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}

	public Date getEtry() {
		return this.etry;
	}

	public void setEtry(Date etry) {
		this.etry = etry;
	}

	public Long getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	public String getMyqq() {
		return this.myqq;
	}

	public void setMyqq(String myqq) {
		this.myqq = myqq;
	}

	public String getZhuanye() {
		return this.zhuanye;
	}

	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}

	public String getHunyin() {
		return this.hunyin;
	}

	public void setHunyin(String hunyin) {
		this.hunyin = hunyin;
	}

	public String getJwork() {
		return this.jwork;
	}

	public void setJwork(String jwork) {
		this.jwork = jwork;
	}

	public String getFavorite() {
		return this.favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public String getTechang() {
		return this.techang;
	}

	public void setTechang(String techang) {
		this.techang = techang;
	}

	public String getFace() {
		return this.face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	

	public String getEphone() {
		return ephone;
	}

	public void setEphone(String ephone) {
		this.ephone = ephone;
	}

	public Long getEday() {
		return eday;
	}

	public void setEday(Long eday) {
		this.eday = eday;
	}




	public Long getDisid() {
		return disid;
	}


	public void setDisid(Long disid) {
		this.disid = disid;
	}


}