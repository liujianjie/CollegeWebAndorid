package org.ht.controller;

import java.util.List;

import org.ht.pojo.Informations;
import org.ht.pojo.Replies;
import org.ht.service.InformationsService;
import org.ht.service.RepliesService;
import org.ht.service.impl.InformationsServiceImpl;
import org.ht.service.impl.RepliesServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class InfoAction extends ActionSupport {
	private InformationsService infoService = new InformationsServiceImpl();
	private RepliesService reService= new RepliesServiceImpl();
	private List<Informations> infos;
	private Informations info;
	private Integer infoId;
	private Replies replies;

	public String infos() throws Exception {
		infos = infoService.findInfos();
		return SUCCESS;
	}

	public String toReplies() throws Exception {
		info = infoService.findById(infoId);
		return SUCCESS;
	}

	public String addRep() {
		reService.addRep(replies);
		return SUCCESS;

	}

	public Replies getReplies() {
		return replies;
	}

	public void setReplies(Replies replies) {
		this.replies = replies;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Informations getInfo() {
		return info;
	}

	public void setInfo(Informations info) {
		this.info = info;
	}

	public List<Informations> getInfos() {
		return infos;
	}

	public void setInfos(List<Informations> infos) {
		this.infos = infos;
	}

}
