package org.ht.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Informations implements Serializable{
	private Integer id;
	private String title;
	private String content;
	private Integer replyCount;
	private Integer viewCount;
	private Date reportTime;
	private Date lastposttime;
	private List<Replies> replieies;
	public Informations() {
	}
	public Informations(Integer id, String title, String content, Integer replyCount, Integer viewCount,
			Date reportTime, Date lastposttime, List<Replies> replieies) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.replyCount = replyCount;
		this.viewCount = viewCount;
		this.reportTime = reportTime;
		this.lastposttime = lastposttime;
		this.replieies = replieies;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Date getLastposttime() {
		return lastposttime;
	}
	public void setLastposttime(Date lastposttime) {
		this.lastposttime = lastposttime;
	}
	public List<Replies> getReplieies() {
		return replieies;
	}
	public void setReplieies(List<Replies> replieies) {
		this.replieies = replieies;
	}
}
