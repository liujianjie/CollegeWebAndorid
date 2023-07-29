package com.aaa.action;

import java.io.IOException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.CommentBiz;
import com.aaa.entity.Comment;
import com.aaa.util.PageEntity;
import com.alibaba.fastjson.JSON;

@Controller
@ParentPackage("struts-default")
public class CommentAction extends BaseAction{
	private PageEntity page;
	private Comment comment;
	@Autowired
	private CommentBiz  commentBiz;
	@Action("getAllComment")
    public String getAllComment(){
		if(page==null){page=new PageEntity();}
		PageEntity pageEntity=commentBiz.getAllComment(page);
		String json=JSON.toJSONString(pageEntity);
		try {
			getWrite().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
   	 
    }
	@Action("addComment")
	public String addComment(){
		commentBiz.add(comment);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;}
	@Action("delComment")
	public String delComment(){
		commentBiz.del(comment);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;}
	
	@Action("updateComment")
	public String updateCla(){
		commentBiz.update(comment);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;}
	@Action("getCt")
    public String getCt(){
		String json=JSON.toJSONString(commentBiz.getct());
		try {
			getWrite().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
   	 
    }
	public PageEntity getPage() {
		return page;
	}
	public void setPage(PageEntity page) {
		this.page = page;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	
	
}
