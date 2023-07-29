package com.ht.vo5;

/**
 * Summary entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Summary implements java.io.Serializable {

	// Fields

	private Long sids;
	private Long sstuid;
	private String ssay;
	private Long steaches;

	// Constructors

	/** default constructor */
	public Summary() {
	}

	/** minimal constructor */
	public Summary(Long sstuid, String ssay) {
		this.sstuid = sstuid;
		this.ssay = ssay;
	}

	/** full constructor */
	public Summary(Long sstuid, String ssay, Long steaches) {
		this.sstuid = sstuid;
		this.ssay = ssay;
		this.steaches = steaches;
	}

	// Property accessors

	public Long getSids() {
		return this.sids;
	}

	public void setSids(Long sids) {
		this.sids = sids;
	}

	public Long getSstuid() {
		return this.sstuid;
	}

	public void setSstuid(Long sstuid) {
		this.sstuid = sstuid;
	}

	public String getSsay() {
		return this.ssay;
	}

	public void setSsay(String ssay) {
		this.ssay = ssay;
	}

	public Long getSteaches() {
		return this.steaches;
	}

	public void setSteaches(Long steaches) {
		this.steaches = steaches;
	}

}