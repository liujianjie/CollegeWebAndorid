package com.ht.yfbc.pojo;

import java.io.Serializable;
/**
 * Rewards_penalties的扩展类<br>
 * rp:Rewards_penalties对象<br>
 * username：用户名<br>
 * Day 2017-1-10 
 * @author 刘宗龙
 *
 */
public class Rewards_penaltiesVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rewards_penalties rp;
	private String username;
	public Rewards_penaltiesVo() {
	}
	public Rewards_penaltiesVo(Rewards_penalties rp, String username) {
		this.rp = rp;
		this.username = username;
	}
	public Rewards_penalties getRp() {
		return rp;
	}
	public void setRp(Rewards_penalties rp) {
		this.rp = rp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Rewards_penaltiesVo [rp=" + rp + ", username=" + username + "]";
	}
	
	
}
