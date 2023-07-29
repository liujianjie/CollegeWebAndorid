package com.aaa.entity;

/**
 * LevelDeptId entity. @author MyEclipse Persistence Tools
 */

public class LevelDeptId implements java.io.Serializable {

	// Fields

	private Dept dept;
	private Level level;

	// Constructors

	/** default constructor */
	public LevelDeptId() {
	}

	/** full constructor */
	public LevelDeptId(Dept dept, Level level) {
		this.dept = dept;
		this.level = level;
	}

	// Property accessors

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LevelDeptId))
			return false;
		LevelDeptId castOther = (LevelDeptId) other;

		return ((this.getDept() == castOther.getDept()) || (this.getDept() != null && castOther.getDept() != null
				&& this.getDept().equals(castOther.getDept())))
				&& ((this.getLevel() == castOther.getLevel()) || (this.getLevel() != null
						&& castOther.getLevel() != null && this.getLevel().equals(castOther.getLevel())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDept() == null ? 0 : this.getDept().hashCode());
		result = 37 * result + (getLevel() == null ? 0 : this.getLevel().hashCode());
		return result;
	}

}