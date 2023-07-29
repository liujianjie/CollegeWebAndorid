package com.ht.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ht.common.BaseAction;
import com.ht.service.IStuService;
import com.ht.service.IStumainService;
import com.ht.service.impl.StumainServiceImpl;
import com.ht.vo5.Sback;
import com.ht.vo6.Msg;

public class StuMainAction extends BaseAction{
	IStumainService sm=new StumainServiceImpl();
	HttpServletRequest request=ServletActionContext.getRequest();
	IStuService ss=(IStuService)getService("sService");
	
	private List zblist;
	private List tzlist;
	private List yjlist;
	private int pageCount;
	private int currPage;
	private int totalCount;
	private int totalPage;
	private int pageCount2;
	private int currPage2;
	private int totalCount2;
	private int totalPage2;
	private List lxlist;
	
	public String sellist(){
		//值班表值班表分页
		pageCount=7;
		currPage=1;
		totalCount=sm.zhibanlist().size();
		totalPage=(totalCount+pageCount-1)/pageCount;
		String currpage=request.getParameter("cpage");
		
		if(currpage!=null&&!currpage.equals("")){
			currPage=Integer.parseInt(currpage);
			
		}
		if(currPage<1){
			currPage=1;
		}
		if(currPage>totalPage){
			currPage=totalPage;
		}
		
		//获取为list
		zblist =  sm.zhibanlistpage((currPage-1)*pageCount,pageCount);//就这样设值就可以
		
		//学生通知表 控制10条
		tzlist=sm.tongzhilistpage(0, 15);
		
		//学生意见反馈
		yjlist = sm.yijianlistpage(0,9);//未处理 和 已回复的
		
		//联系电话
		//联系电话表分页
		pageCount2=5;
		currPage2=1;
		totalCount2=sm.lianxilist().size();
		totalPage2=(totalCount2+pageCount2-1)/pageCount2;
		String currpage2=request.getParameter("cpage2");
		
		if(currpage2!=null&&!currpage2.equals("")){
			currPage2=Integer.parseInt(currpage2);
		}
		if(currPage2<1){
			currPage2=1;
		}
		if(currPage2>totalPage2){
			currPage2=totalPage2;
		}
		lxlist=sm.lianxilistpage((currPage2-1)*pageCount2,pageCount2);
		
		return "success";
	}
	//值班list
	public String zblist(){
		//值班表值班表分页
		pageCount=7;
		currPage=1;
		totalCount=sm.zhibanlist().size();
		totalPage=(totalCount+pageCount-1)/pageCount;
		String currpage=request.getParameter("cpage");
		
		if(currpage!=null&&!currpage.equals("")){
			currPage=Integer.parseInt(currpage);
			
		}
		if(currPage<1){
			currPage=1;
		}
		if(currPage>totalPage){
			currPage=totalPage;
		}
		
		//获取为list
		zblist =  sm.zhibanlistpage((currPage-1)*pageCount,pageCount);//就这样设值就可以
		
		return "success";
	}
	//联系list
	public String lxlist(){
		//联系电话表分页
		pageCount2=5;
		currPage2=1;
		totalCount2=sm.lianxilist().size();
		totalPage2=(totalCount2+pageCount2-1)/pageCount2;
		String currpage2=request.getParameter("cpage2");
		
		if(currpage2!=null&&!currpage2.equals("")){
			currPage2=Integer.parseInt(currpage2);
		}
		if(currPage2<1){
			currPage2=1;
		}
		if(currPage2>totalPage2){
			currPage2=totalPage2;
		}
		lxlist=sm.lianxilistpage((currPage2-1)*pageCount2,pageCount2);
		
		return "success";
	}
	
	//公告详情
	private int msgid;
	private Msg msg;
	public String xq(){
		System.out.println("进来了");
		msg=sm.getMsgById(msgid);
		
		return "success";
	}
	//意见详情
	private int sbackid;
	private Sback sback;
	private List stulist;
	public String xq2(){
		sback=sm.getsbk((long)sbackid);
		//学生
		stulist=ss.sellist();
		
		return "success";
	}

	public List getZblist() {
		return zblist;
	}

	public void setZblist(List zblist) {
		this.zblist = zblist;
	}

	public List getTzlist() {
		return tzlist;
	}

	public void setTzlist(List tzlist) {
		this.tzlist = tzlist;
	}

	public List getYjlist() {
		return yjlist;
	}

	public void setYjlist(List yjlist) {
		this.yjlist = yjlist;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List getLxlist() {
		return lxlist;
	}

	public int getMsgid() {
		return msgid;
	}


	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}


	public void setLxlist(List lxlist) {
		this.lxlist = lxlist;
	}

	public int getPageCount2() {
		return pageCount2;
	}

	public void setPageCount2(int pageCount2) {
		this.pageCount2 = pageCount2;
	}

	public int getCurrPage2() {
		return currPage2;
	}

	public void setCurrPage2(int currPage2) {
		this.currPage2 = currPage2;
	}

	public int getTotalCount2() {
		return totalCount2;
	}

	public void setTotalCount2(int totalCount2) {
		this.totalCount2 = totalCount2;
	}

	public int getTotalPage2() {
		return totalPage2;
	}

	public Msg getMsg() {
		return msg;
	}


	public void setMsg(Msg msg) {
		this.msg = msg;
	}


	public void setTotalPage2(int totalPage2) {
		this.totalPage2 = totalPage2;
	}
	public int getSbackid() {
		return sbackid;
	}
	public void setSbackid(int sbackid) {
		this.sbackid = sbackid;
	}
	public Sback getSback() {
		return sback;
	}
	public void setSback(Sback sback) {
		this.sback = sback;
	}

	
}
