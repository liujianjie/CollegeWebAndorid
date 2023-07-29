package com.ht.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Forengmessage implements Serializable {

	private String m_id;
	private String m_title;
	private String m_content;
	private String m_userid;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date m_time;
	private String m_type;
	private String m_statu;

	public Forengmessage() {
		// TODO Auto-generated constructor stub
	}

	public Forengmessage(String m_id, String m_title, String m_content, String m_userid, Date m_time, String m_type,
			String m_statu) {
		super();
		this.m_id = m_id;
		this.m_title = m_title;
		this.m_content = m_content;
		this.m_userid = m_userid;
		this.m_time = m_time;
		this.m_type = m_type;
		this.m_statu = m_statu;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public String getM_content() {
		return m_content;
	}

	public void setM_content(String m_content) {
		this.m_content = m_content;
	}

	public String getM_userid() {
		return m_userid;
	}

	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}

	public Date getM_time() {
		return m_time;
	}

	public void setM_time(Date m_time) {
		this.m_time = m_time;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}

	public String getM_statu() {
		return m_statu;
	}

	public void setM_statu(String m_statu) {
		this.m_statu = m_statu;
	}

}
