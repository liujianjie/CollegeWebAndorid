package com.ht.vo4;

/**
 * Salary entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Salary implements java.io.Serializable {

	// Fields

	private Long salaryId;
	private Long empid;
	private String dname;
	private String ename;
	private String jwork;
	private Float dixin;
	private Long kaoheN;
	private Long bingshijiaN;
	private Long weichuqinN;
	private Float weijiF;
	private Float chidaoF;
	private Float otherSalary;
	private Long year;
	private Long month;
	private Float totalSalary;
	private String person;		//经手人
	private String status;		//发放状态

	// Constructors

	/** default constructor */
	public Salary() {
	}

	/** minimal constructor */
	public Salary(Long salaryId) {
		this.salaryId = salaryId;
	}

	/** full constructor */
	public Salary(Long salaryId, Long empid, String dname, String ename,
			String jwork, Float dixin, Long kaoheN, Long bingshijiaN,
			Long weichuqinN, Float weijiF, Float chidaoF, Float otherSalary,
			Long year, Long month, Float totalSalary, String person,
			String status) {
		this.salaryId = salaryId;
		this.empid = empid;
		this.dname = dname;
		this.ename = ename;
		this.jwork = jwork;
		this.dixin = dixin;
		this.kaoheN = kaoheN;
		this.bingshijiaN = bingshijiaN;
		this.weichuqinN = weichuqinN;
		this.weijiF = weijiF;
		this.chidaoF = chidaoF;
		this.otherSalary = otherSalary;
		this.year = year;
		this.month = month;
		this.totalSalary = totalSalary;
		this.person = person;
		this.status = status;
	}

	// Property accessors

	public Long getSalaryId() {
		return this.salaryId;
	}

	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}

	public Long getEmpid() {
		return this.empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJwork() {
		return this.jwork;
	}

	public void setJwork(String jwork) {
		this.jwork = jwork;
	}

	public Float getDixin() {
		return this.dixin;
	}

	public void setDixin(Float dixin) {
		this.dixin = dixin;
	}

	public Long getKaoheN() {
		return this.kaoheN;
	}

	public void setKaoheN(Long kaoheN) {
		this.kaoheN = kaoheN;
	}

	public Long getBingshijiaN() {
		return this.bingshijiaN;
	}

	public void setBingshijiaN(Long bingshijiaN) {
		this.bingshijiaN = bingshijiaN;
	}

	public Long getWeichuqinN() {
		return this.weichuqinN;
	}

	public void setWeichuqinN(Long weichuqinN) {
		this.weichuqinN = weichuqinN;
	}

	public Float getWeijiF() {
		return this.weijiF;
	}

	public void setWeijiF(Float weijiF) {
		this.weijiF = weijiF;
	}

	public Float getChidaoF() {
		return this.chidaoF;
	}

	public void setChidaoF(Float chidaoF) {
		this.chidaoF = chidaoF;
	}

	public Float getOtherSalary() {
		return this.otherSalary;
	}

	public void setOtherSalary(Float otherSalary) {
		this.otherSalary = otherSalary;
	}

	public Long getYear() {
		return this.year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getMonth() {
		return this.month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Float getTotalSalary() {
		return this.totalSalary;
	}

	public void setTotalSalary(Float totalSalary) {
		this.totalSalary = totalSalary;
	}

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}