package com.aaa.entity;

/**
 * LevelDept entity. @author MyEclipse Persistence Tools
 */

public class LevelDept implements java.io.Serializable {

	// Fields

	private LevelDeptId id;
	private Level level;
	private Dept dept;

	// Constructors

	/** default constructor */
	public LevelDept() {
	}

	/** full constructor */
	public LevelDept(LevelDeptId id, Level level, Dept dept) {
		this.id = id;
		this.level = level;
		this.dept = dept;
	}

	// Property accessors

	public LevelDeptId getId() {
		return this.id;
	}

	public void setId(LevelDeptId id) {
		this.id = id;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}