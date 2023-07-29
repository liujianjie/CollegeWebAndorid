package com.aaa.entity;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private User user;
	private OutOrder outOrder;
	private String evaluate;
	private String replay;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(User user, OutOrder outOrder, String evaluate,String replay) {
		this.user = user;
		this.outOrder = outOrder;
		this.evaluate = evaluate;
		this.replay = replay;
	}

	// Property accessors

	
	public Integer getCommentId() {
		return this.commentId;
	}

	public String getReplay() {
		return replay;
	}

	public void setReplay(String replay) {
		this.replay = replay;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OutOrder getOutOrder() {
		return this.outOrder;
	}

	public void setOutOrder(OutOrder outOrder) {
		this.outOrder = outOrder;
	}

	public String getEvaluate() {
		return this.evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

}