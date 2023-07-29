package com.ht.vo5;

/**
 * Defenses entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Defenses implements java.io.Serializable {

	// Fields

	private Long did;
	private Long pid;
	private Long dhead;
	private Long dmember;
	private Float dfunction;
	private Float ddifficulty;
	private Float dbeanutiful;
	private Float ddemo;
	private Float dexpress;
	private Float danswer;
	private Float dscore;
	private String dremark;
	private Long dcount;

	// Constructors

	/** default constructor */
	public Defenses() {
	}

	/** full constructor */
	public Defenses(Long pid, Long dhead, Long dmember, Float dfunction,
			Float ddifficulty, Float dbeanutiful, Float ddemo, Float dexpress,
			Float danswer, Float dscore, String dremark, Long dcount) {
		this.pid = pid;
		this.dhead = dhead;
		this.dmember = dmember;
		this.dfunction = dfunction;
		this.ddifficulty = ddifficulty;
		this.dbeanutiful = dbeanutiful;
		this.ddemo = ddemo;
		this.dexpress = dexpress;
		this.danswer = danswer;
		this.dscore = dscore;
		this.dremark = dremark;
		this.dcount = dcount;
	}

	// Property accessors

	public Long getDid() {
		return this.did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getDhead() {
		return this.dhead;
	}

	public void setDhead(Long dhead) {
		this.dhead = dhead;
	}

	public Long getDmember() {
		return this.dmember;
	}

	public void setDmember(Long dmember) {
		this.dmember = dmember;
	}

	public Float getDfunction() {
		return this.dfunction;
	}

	public void setDfunction(Float dfunction) {
		this.dfunction = dfunction;
	}

	public Float getDdifficulty() {
		return this.ddifficulty;
	}

	public void setDdifficulty(Float ddifficulty) {
		this.ddifficulty = ddifficulty;
	}

	public Float getDbeanutiful() {
		return this.dbeanutiful;
	}

	public void setDbeanutiful(Float dbeanutiful) {
		this.dbeanutiful = dbeanutiful;
	}

	public Float getDdemo() {
		return this.ddemo;
	}

	public void setDdemo(Float ddemo) {
		this.ddemo = ddemo;
	}

	public Float getDexpress() {
		return this.dexpress;
	}

	public void setDexpress(Float dexpress) {
		this.dexpress = dexpress;
	}

	public Float getDanswer() {
		return this.danswer;
	}

	public void setDanswer(Float danswer) {
		this.danswer = danswer;
	}

	public Float getDscore() {
		return this.dscore;
	}

	public void setDscore(Float dscore) {
		this.dscore = dscore;
	}

	public String getDremark() {
		return this.dremark;
	}

	public void setDremark(String dremark) {
		this.dremark = dremark;
	}

	public Long getDcount() {
		return this.dcount;
	}

	public void setDcount(Long dcount) {
		this.dcount = dcount;
	}

}