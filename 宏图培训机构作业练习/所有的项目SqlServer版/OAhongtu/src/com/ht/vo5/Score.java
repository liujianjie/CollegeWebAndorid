package com.ht.vo5;

import com.ht.vo2.Course;

/**
 * Score entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable {

	// Fields

	private Long scoid;
	private Long stuid;
	private Float score;
	private Long sconame;

	
	// Constructors

	/** default constructor */
	public Score() {
	}

	/** minimal constructor */
	public Score(Float score) {
		this.score = score;
	}

	/** full constructor */
	public Score(Long stuid, Float score, Long sconame) {
		this.stuid = stuid;
		this.score = score;
		this.sconame = sconame;
	}

	// Property accessors

	public Long getScoid() {
		return this.scoid;
	}

	public void setScoid(Long scoid) {
		this.scoid = scoid;
	}

	public Long getStuid() {
		return this.stuid;
	}

	public void setStuid(Long stuid) {
		this.stuid = stuid;
	}

	public Float getScore() {
		return this.score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Long getSconame() {
		return this.sconame;
	}

	public void setSconame(Long sconame) {
		this.sconame = sconame;
	}

}