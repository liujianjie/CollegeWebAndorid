package com.ht.pojo;

import java.util.Date;

/**
 * Borrowmoney entity. @author MyEclipse Persistence Tools
 */

public class Borrowmoney implements java.io.Serializable {

	// Fields
	private String b_id;
	private Double b_money;
	private Double manage_money;
	private Double paid_money;
	private Double should_money;
	private Double repay_money;
	private Double collection_money;
	private Double principal_money;
	private Double fine_money;
	private Double tb_money;
	private String rate;
	private String tb_unreward;
	private String tb_rewardtype;
	private String tb_reward;
	private String repayment;
	private Double tb_minmoney;
	private Date yx_time;
	private String borrowqx;
	private Double tb_maxmoney;
	private String borrow_yt;
	private String borrow_bt;
	private String borrow_sm;
	private Date borrow_time;
	private String borrow_type;
	private Date mbsj;
	private Date realreplay_time;
	private String statu;
	private String sfdxb;
	private String b_password;
	private String tb_openmessage;
	private Double succes_completion;
	private Date borrow_fbtime;
	private Date repay_startime;
	private Date repay_lasttime;
	private Date release_time;
	private String dbw;
	private String dbx;
	private String tid;// ´æµÄÊÇttzuserµÄuserid
	private String tname;

	// mapperÓ³Éä×Ö¶Î
	private String ttz_tid;

	public Borrowmoney() {
		// TODO Auto-generated constructor stub
	}

	public Borrowmoney(String b_id, Double b_money, Double manage_money, Double paid_money, Double should_money,
			Double repay_money, Double collection_money, Double principal_money, Double fine_money, Double tb_money,
			String rate, String tb_unreward, String tb_rewardtype, String tb_reward, String repayment,
			Double tb_minmoney, Date yx_time, String borrowqx, Double tb_maxmoney, String borrow_yt, String borrow_bt,
			String borrow_sm, Date borrow_time, String borrow_type, Date mbsj, Date realreplay_time, String statu,
			String sfdxb, String b_password, String tb_openmessage, Double succes_completion, Date borrow_fbtime,
			Date repay_startime, Date repay_lasttime, Date release_time, String dbw, String dbx, String tid,
			String tname) {
		super();
		this.b_id = b_id;
		this.b_money = b_money;
		this.manage_money = manage_money;
		this.paid_money = paid_money;
		this.should_money = should_money;
		this.repay_money = repay_money;
		this.collection_money = collection_money;
		this.principal_money = principal_money;
		this.fine_money = fine_money;
		this.tb_money = tb_money;
		this.rate = rate;
		this.tb_unreward = tb_unreward;
		this.tb_rewardtype = tb_rewardtype;
		this.tb_reward = tb_reward;
		this.repayment = repayment;
		this.tb_minmoney = tb_minmoney;
		this.yx_time = yx_time;
		this.borrowqx = borrowqx;
		this.tb_maxmoney = tb_maxmoney;
		this.borrow_yt = borrow_yt;
		this.borrow_bt = borrow_bt;
		this.borrow_sm = borrow_sm;
		this.borrow_time = borrow_time;
		this.borrow_type = borrow_type;
		this.mbsj = mbsj;
		this.realreplay_time = realreplay_time;
		this.statu = statu;
		this.sfdxb = sfdxb;
		this.b_password = b_password;
		this.tb_openmessage = tb_openmessage;
		this.succes_completion = succes_completion;
		this.borrow_fbtime = borrow_fbtime;
		this.repay_startime = repay_startime;
		this.repay_lasttime = repay_lasttime;
		this.release_time = release_time;
		this.dbw = dbw;
		this.dbx = dbx;
		this.tid = tid;
		this.tname = tname;
	}

	public String getTtz_tid() {
		return ttz_tid;
	}

	public void setTtz_tid(String ttz_tid) {
		this.ttz_tid = ttz_tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public Double getB_money() {
		return b_money;
	}

	public void setB_money(Double b_money) {
		this.b_money = b_money;
	}

	public Double getManage_money() {
		return manage_money;
	}

	public void setManage_money(Double manage_money) {
		this.manage_money = manage_money;
	}

	public Double getPaid_money() {
		return paid_money;
	}

	public void setPaid_money(Double paid_money) {
		this.paid_money = paid_money;
	}

	public Double getShould_money() {
		return should_money;
	}

	public void setShould_money(Double should_money) {
		this.should_money = should_money;
	}

	public Double getRepay_money() {
		return repay_money;
	}

	public void setRepay_money(Double repay_money) {
		this.repay_money = repay_money;
	}

	public Double getCollection_money() {
		return collection_money;
	}

	public void setCollection_money(Double collection_money) {
		this.collection_money = collection_money;
	}

	public Double getPrincipal_money() {
		return principal_money;
	}

	public void setPrincipal_money(Double principal_money) {
		this.principal_money = principal_money;
	}

	public Double getFine_money() {
		return fine_money;
	}

	public void setFine_money(Double fine_money) {
		this.fine_money = fine_money;
	}

	public Double getTb_money() {
		return tb_money;
	}

	public void setTb_money(Double tb_money) {
		this.tb_money = tb_money;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTb_unreward() {
		return tb_unreward;
	}

	public void setTb_unreward(String tb_unreward) {
		this.tb_unreward = tb_unreward;
	}

	public String getTb_rewardtype() {
		return tb_rewardtype;
	}

	public void setTb_rewardtype(String tb_rewardtype) {
		this.tb_rewardtype = tb_rewardtype;
	}

	public String getTb_reward() {
		return tb_reward;
	}

	public void setTb_reward(String tb_reward) {
		this.tb_reward = tb_reward;
	}

	public String getRepayment() {
		return repayment;
	}

	public void setRepayment(String repayment) {
		this.repayment = repayment;
	}

	public Double getTb_minmoney() {
		return tb_minmoney;
	}

	public void setTb_minmoney(Double tb_minmoney) {
		this.tb_minmoney = tb_minmoney;
	}

	public Date getYx_time() {
		return yx_time;
	}

	public void setYx_time(Date yx_time) {
		this.yx_time = yx_time;
	}

	public String getBorrowqx() {
		return borrowqx;
	}

	public void setBorrowqx(String borrowqx) {
		this.borrowqx = borrowqx;
	}

	public Double getTb_maxmoney() {
		return tb_maxmoney;
	}

	public void setTb_maxmoney(Double tb_maxmoney) {
		this.tb_maxmoney = tb_maxmoney;
	}

	public String getBorrow_yt() {
		return borrow_yt;
	}

	public void setBorrow_yt(String borrow_yt) {
		this.borrow_yt = borrow_yt;
	}

	public String getBorrow_bt() {
		return borrow_bt;
	}

	public void setBorrow_bt(String borrow_bt) {
		this.borrow_bt = borrow_bt;
	}

	public String getBorrow_sm() {
		return borrow_sm;
	}

	public void setBorrow_sm(String borrow_sm) {
		this.borrow_sm = borrow_sm;
	}

	public Date getBorrow_time() {
		return borrow_time;
	}

	public void setBorrow_time(Date borrow_time) {
		this.borrow_time = borrow_time;
	}

	public String getBorrow_type() {
		return borrow_type;
	}

	public void setBorrow_type(String borrow_type) {
		this.borrow_type = borrow_type;
	}

	public Date getMbsj() {
		return mbsj;
	}

	public void setMbsj(Date mbsj) {
		this.mbsj = mbsj;
	}

	public Date getRealreplay_time() {
		return realreplay_time;
	}

	public void setRealreplay_time(Date realreplay_time) {
		this.realreplay_time = realreplay_time;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public String getSfdxb() {
		return sfdxb;
	}

	public void setSfdxb(String sfdxb) {
		this.sfdxb = sfdxb;
	}

	public String getB_password() {
		return b_password;
	}

	public void setB_password(String b_password) {
		this.b_password = b_password;
	}

	public String getTb_openmessage() {
		return tb_openmessage;
	}

	public void setTb_openmessage(String tb_openmessage) {
		this.tb_openmessage = tb_openmessage;
	}

	public Double getSucces_completion() {
		return succes_completion;
	}

	public void setSucces_completion(Double succes_completion) {
		this.succes_completion = succes_completion;
	}

	public Date getBorrow_fbtime() {
		return borrow_fbtime;
	}

	public void setBorrow_fbtime(Date borrow_fbtime) {
		this.borrow_fbtime = borrow_fbtime;
	}

	public Date getRepay_startime() {
		return repay_startime;
	}

	public void setRepay_startime(Date repay_startime) {
		this.repay_startime = repay_startime;
	}

	public Date getRepay_lasttime() {
		return repay_lasttime;
	}

	public void setRepay_lasttime(Date repay_lasttime) {
		this.repay_lasttime = repay_lasttime;
	}

	public String getDbw() {
		return dbw;
	}

	public void setDbw(String dbw) {
		this.dbw = dbw;
	}

	public String getDbx() {
		return dbx;
	}

	public void setDbx(String dbx) {
		this.dbx = dbx;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Date getRelease_time() {
		return release_time;
	}

	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}

}