package com.ht.pojo;

/**
 * Ttzuser entity. @author MyEclipse Persistence Tools
 */

public class Ttzuser extends People implements java.io.Serializable {

	// Fields

	private String tid;
	private String userid;
	private String username;
	private String pwd;
	private String zpwd;
	private Integer vip;
	private String zsname;
	private String idcard;
	private String email;
	private String tel;
	private Double money;
	private Integer syed;
	private Integer xylevel;
	private Integer jifen;
	private String head;
	private String newuser;
	private String shren;

	// Constructors

	/** default constructor */
	public Ttzuser() {
	}

	// Property accessors

	
	
	
	public Integer getSyed() {
		return syed;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	
	

	public String getNewuser() {
		return newuser;
	}

	public void setNewuser(String newuser) {
		this.newuser = newuser;
	}

	public String getShren() {
		return shren;
	}

	public void setShren(String shren) {
		this.shren = shren;
	}

	public Ttzuser(String tid, String userid, String username, String pwd, String zpwd, Integer vip, String zsname,
			String idcard, String email, String tel, Double money, Integer syed, Integer xylevel, Integer jifen,
			String head, String newuser, String shren) {
		super();
		this.tid = tid;
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.zpwd = zpwd;
		this.vip = vip;
		this.zsname = zsname;
		this.idcard = idcard;
		this.email = email;
		this.tel = tel;
		this.money = money;
		this.syed = syed;
		this.xylevel = xylevel;
		this.jifen = jifen;
		this.head = head;
		this.newuser = newuser;
		this.shren = shren;
	}

	public void setSyed(Integer syed) {
		this.syed = syed;
	}

	public Integer getXylevel() {
		return xylevel;
	}

	public void setXylevel(Integer xylevel) {
		this.xylevel = xylevel;
	}

	public Integer getJifen() {
		return jifen;
	}

	public void setJifen(Integer jifen) {
		this.jifen = jifen;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getZpwd() {
		return this.zpwd;
	}

	public void setZpwd(String zpwd) {
		this.zpwd = zpwd;
	}

	public Integer getVip() {
		return this.vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public String getZsname() {
		return this.zsname;
	}

	public void setZsname(String zsname) {
		this.zsname = zsname;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}