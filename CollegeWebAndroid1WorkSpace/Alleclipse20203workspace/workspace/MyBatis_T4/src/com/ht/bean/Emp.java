package com.ht.bean;

import java.util.Date;


public class Emp  implements java.io.Serializable {


    // Fields    

     private Integer empno;
     private String ename;
     private String job;
     private Integer mgrs;
     private Date hiredate;
     private Double sal;
     private Double comm;
     
     private Integer deptno;


    // Constructors

    /** default constructor */
    public Emp() {
    }

	/** minimal constructor */
    public Emp(Integer empno) {
        this.empno = empno;
    }
    
    /** full constructor */
    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal, Double comm) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgrs = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
    }

   
    // Property accessors

    public Integer getEmpno() {
        return this.empno;
    }
    
    public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return this.ename;
    }
    
    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return this.mgrs;
    }
    
    public void setMgr(Integer mgr) {
        this.mgrs = mgr;
    }

    public Date getHiredate() {
        return this.hiredate;
    }
    
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return this.sal;
    }
    
    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return this.comm;
    }
    
    public void setComm(Double comm) {
        this.comm = comm;
    }
   








}