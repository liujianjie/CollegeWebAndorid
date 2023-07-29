package org.ht.pojo;

import java.io.Serializable;
import java.util.Date;

public class Replies implements Serializable {
	private Integer id;
	private String content;
	private Date replytime;
	private Integer infoId;

	public Replies() {
	}

	public Replies(Integer id, String content, Date replytime, Integer infoId) {
		this.id = id;
		this.content = content;
		this.replytime = replytime;
		this.infoId = infoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReplytime() {
		return replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

}
