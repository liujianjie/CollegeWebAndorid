package com.ht.bean;

import java.util.Date;

/**
 * Replies entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Replies implements java.io.Serializable {

	// Fields

	private Long reId;
	private Long inInforid;
	private String reContent;
	private Date reReplytime;

	// Constructors
	private Informations informations;
	/** default constructor */
	public Replies() {
	}

	/** minimal constructor */
	public Replies(String reContent, Date reReplytime) {
		this.reContent = reContent;
		this.reReplytime = reReplytime;
	}

	/** full constructor */
	public Replies(Informations informations, String reContent, Date reReplytime) {
		this.informations = informations;
		this.reContent = reContent;
		this.reReplytime = reReplytime;
	}

	// Property accessors

	public Long getReId() {
		return this.reId;
	}

	public void setReId(Long reId) {
		this.reId = reId;
	}

	public Informations getInformations() {
		return this.informations;
	}

	public void setInformations(Informations informations) {
		this.informations = informations;
	}

	public String getReContent() {
		return this.reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public Date getReReplytime() {
		return this.reReplytime;
	}

	public void setReReplytime(Date reReplytime) {
		this.reReplytime = reReplytime;
	}

	public Long getInInforid() {
		return inInforid;
	}

	public void setInInforid(Long inInforid) {
		this.inInforid = inInforid;
	}

}