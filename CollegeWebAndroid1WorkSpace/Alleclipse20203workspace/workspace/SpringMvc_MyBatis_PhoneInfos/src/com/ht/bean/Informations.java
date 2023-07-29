package com.ht.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Informations entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Informations implements java.io.Serializable {

	// Fields

	private Long inInforid;
	private String inTitle;
	private String inContent;
	private Long inReplycount;
	private Long inViewcount;
	private Date inReporttime;
	private Date inLastposttime;
	private List<Replies> replieses;

	// Constructors

	/** default constructor */
	public Informations() {
	}

	/** minimal constructor */
	public Informations(String inTitle, String inContent, Long inReplycount,
			Long inViewcount, Date inReporttime, Date inLastposttime) {
		this.inTitle = inTitle;
		this.inContent = inContent;
		this.inReplycount = inReplycount;
		this.inViewcount = inViewcount;
		this.inReporttime = inReporttime;
		this.inLastposttime = inLastposttime;
	}

	

	// Property accessors

	public Long getInInforid() {
		return this.inInforid;
	}

	public void setInInforid(Long inInforid) {
		this.inInforid = inInforid;
	}

	public String getInTitle() {
		return this.inTitle;
	}

	public void setInTitle(String inTitle) {
		this.inTitle = inTitle;
	}

	public String getInContent() {
		return this.inContent;
	}

	public void setInContent(String inContent) {
		this.inContent = inContent;
	}

	public Long getInReplycount() {
		return this.inReplycount;
	}

	public void setInReplycount(Long inReplycount) {
		this.inReplycount = inReplycount;
	}

	public Long getInViewcount() {
		return this.inViewcount;
	}

	public void setInViewcount(Long inViewcount) {
		this.inViewcount = inViewcount;
	}

	public Date getInReporttime() {
		return this.inReporttime;
	}

	public void setInReporttime(Date inReporttime) {
		this.inReporttime = inReporttime;
	}

	public Date getInLastposttime() {
		return this.inLastposttime;
	}

	public void setInLastposttime(Date inLastposttime) {
		this.inLastposttime = inLastposttime;
	}

	public List<Replies> getReplieses() {
		return replieses;
	}

	public void setReplieses(List<Replies> replieses) {
		this.replieses = replieses;
	}



}