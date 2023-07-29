package com.ht.vo5;

/**
 * Job entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Job implements java.io.Serializable {

	// Fields

	private Long jobid;
	private Long jobstu;
	private String jobnum;
	private String jobname;
	private Float jobsalary;
	private String jobaddr;
	private String jobdesc;
	private String jobdate;
	private Long jobtea;

	// Constructors

	/** default constructor */
	public Job() {
	}

	/** minimal constructor */
	public Job(Long jobstu, String jobname, Float jobsalary) {
		this.jobstu = jobstu;
		this.jobname = jobname;
		this.jobsalary = jobsalary;
	}

	/** full constructor */
	public Job(Long jobstu, String jobnum, String jobname, Float jobsalary,
			String jobaddr, String jobdesc, String jobdate, Long jobtea) {
		this.jobstu = jobstu;
		this.jobnum = jobnum;
		this.jobname = jobname;
		this.jobsalary = jobsalary;
		this.jobaddr = jobaddr;
		this.jobdesc = jobdesc;
		this.jobdate = jobdate;
		this.jobtea = jobtea;
	}

	// Property accessors

	public Long getJobid() {
		return this.jobid;
	}

	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}

	public Long getJobstu() {
		return this.jobstu;
	}

	public void setJobstu(Long jobstu) {
		this.jobstu = jobstu;
	}

	public String getJobnum() {
		return this.jobnum;
	}

	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}

	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public Float getJobsalary() {
		return this.jobsalary;
	}

	public void setJobsalary(Float jobsalary) {
		this.jobsalary = jobsalary;
	}

	public String getJobaddr() {
		return this.jobaddr;
	}

	public void setJobaddr(String jobaddr) {
		this.jobaddr = jobaddr;
	}

	public String getJobdesc() {
		return this.jobdesc;
	}

	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}

	public String getJobdate() {
		return this.jobdate;
	}

	public void setJobdate(String jobdate) {
		this.jobdate = jobdate;
	}

	public Long getJobtea() {
		return this.jobtea;
	}

	public void setJobtea(Long jobtea) {
		this.jobtea = jobtea;
	}

}