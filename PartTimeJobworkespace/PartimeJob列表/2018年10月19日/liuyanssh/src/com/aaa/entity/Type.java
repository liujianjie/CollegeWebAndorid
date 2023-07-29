package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String typeName;
	private Set menus = new HashSet(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public Type(String typeName, Set menus) {
		this.typeName = typeName;
		this.menus = menus;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getMenus() {
		return this.menus;
	}

	public void setMenus(Set menus) {
		this.menus = menus;
	}

}