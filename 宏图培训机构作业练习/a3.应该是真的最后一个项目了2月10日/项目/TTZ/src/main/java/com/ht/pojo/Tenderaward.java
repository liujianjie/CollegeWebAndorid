package com.ht.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Tenderaward implements Serializable {
	private String taward_id;// Ͷ�꽱�����
	private String tborrowing_id;// �����
	private String tmembers_id;// ��Ա���
	private String trecharge_id;// ��ֵ��¼���
	private String ttender_id;// Ͷ���¼���
	private Integer treward;// ������
	private String tnote;// ��ע
	private String trewardtype;// ��������
	private Date tcreationtime;// ����ʱ��

	public Tenderaward() {

	}

	public Tenderaward(String taward_id, String tborrowing_id, String tmembers_id, String trecharge_id,
			String ttender_id, Integer treward, String tnote, String trewardtype, Date tcreationtime) {
		this.taward_id = taward_id;
		this.tborrowing_id = tborrowing_id;
		this.tmembers_id = tmembers_id;
		this.trecharge_id = trecharge_id;
		this.ttender_id = ttender_id;
		this.treward = treward;
		this.tnote = tnote;
		this.trewardtype = trewardtype;
		this.tcreationtime = tcreationtime;
	}

	public String getTaward_id() {
		return taward_id;
	}

	public void setTaward_id(String taward_id) {
		this.taward_id = taward_id;
	}

	public String getTborrowing_id() {
		return tborrowing_id;
	}

	public void setTborrowing_id(String tborrowing_id) {
		this.tborrowing_id = tborrowing_id;
	}

	public String getTmembers_id() {
		return tmembers_id;
	}

	public void setTmembers_id(String tmembers_id) {
		this.tmembers_id = tmembers_id;
	}

	public String getTrecharge_id() {
		return trecharge_id;
	}

	public void setTrecharge_id(String trecharge_id) {
		this.trecharge_id = trecharge_id;
	}

	public String getTtender_id() {
		return ttender_id;
	}

	public void setTtender_id(String ttender_id) {
		this.ttender_id = ttender_id;
	}

	public Integer getTreward() {
		return treward;
	}

	public void setTreward(Integer treward) {
		this.treward = treward;
	}

	public String getTnote() {
		return tnote;
	}

	public void setTnote(String tnote) {
		this.tnote = tnote;
	}

	public String getTrewardtype() {
		return trewardtype;
	}

	public void setTrewardtype(String trewardtype) {
		this.trewardtype = trewardtype;
	}

	public Date getTcreationtime() {
		return tcreationtime;
	}

	public void setTcreationtime(Date tcreationtime) {
		this.tcreationtime = tcreationtime;
	}
}
