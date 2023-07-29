package com.ht.pojo;

/**
 * ·ÑÂÊ±í
 **/
public class Rates {
	private String r_id;
	private String r_name;
	private Double r_zhi;
	private String r_tiao;

	public Rates() {
	}

	public Rates(String r_id, String r_name, Double r_zhi) {
		super();
		this.r_id = r_id;
		this.r_name = r_name;
		this.r_zhi = r_zhi;
	}

	public String getR_tiao() {
		return r_tiao;
	}

	public void setR_tiao(String r_tiao) {
		this.r_tiao = r_tiao;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public Double getR_zhi() {
		return r_zhi;
	}

	public void setR_zhi(Double r_zhi) {
		this.r_zhi = r_zhi;
	}

}
