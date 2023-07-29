package com.aaa.entity;

/**
 * Country entity. @author MyEclipse Persistence Tools
 */

public class Country implements java.io.Serializable {

	// Fields

	private Integer countryId;
	private String countryName;

	// Constructors

	/** default constructor */
	public Country() {
	}

	/** full constructor */
	public Country(String countryName) {
		this.countryName = countryName;
	}

	// Property accessors

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}