package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Level entity. @author MyEclipse Persistence Tools
 */

public class Level implements java.io.Serializable {

	// Fields

	private Integer levelId;
	private String levelName;
	private String levelUrl;
	private String levelPoint;
	private Set levelDepts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Level() {
	}

	/** minimal constructor */
	public Level(String levelName, String levelUrl, String levelPoint) {
		this.levelName = levelName;
		this.levelUrl = levelUrl;
		this.levelPoint = levelPoint;
	}

	/** full constructor */
	public Level(String levelName, String levelUrl, String levelPoint, Set levelDepts) {
		this.levelName = levelName;
		this.levelUrl = levelUrl;
		this.levelPoint = levelPoint;
		this.levelDepts = levelDepts;
	}

	// Property accessors

	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelUrl() {
		return this.levelUrl;
	}

	public void setLevelUrl(String levelUrl) {
		this.levelUrl = levelUrl;
	}

	public String getLevelPoint() {
		return this.levelPoint;
	}

	public void setLevelPoint(String levelPoint) {
		this.levelPoint = levelPoint;
	}

	public Set getLevelDepts() {
		return this.levelDepts;
	}

	public void setLevelDepts(Set levelDepts) {
		this.levelDepts = levelDepts;
	}

}