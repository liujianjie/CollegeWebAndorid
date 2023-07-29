package com.dc.controller.Pinlun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.dc.dao.pinlun.PinLunDAO;
import com.dc.dao.pinlun.PinLunDAOImpl;
import com.dc.entity.Message;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;


/**
 * 后台评论
 * @author Administrator
 *
 */
public class PinlunAction extends BaseAction{
	 private List plist;
     private String target;
     private String nowpage;
     private PageEntity page;
     private String commentid;
     private Map pmap;
     private String commentreplay;
     private String commentcontent;
     private Map usermap;
     /**
      * 查询评论
      * @return
      */
	 public String  SelectPl(){
		int pageN=0;
	    if(com.dc.util.StringUtil.checkNotNull(nowpage)){
	    	pageN=Integer.parseInt(nowpage);
	    }else{
	    	pageN=1;
	    }
		PageEntity page1=new PageEntity();
		page1.setNowpage(pageN);
		PinLunDAO pl=new PinLunDAOImpl();
		Map map1=new HashMap();
		map1.put("commentreplay", commentreplay);
		map1.put("commentcontent", commentcontent);
        plist=pl.SelAllpinlun(map1,page1);
        this.usermap=map1;
        this.page=page1;
        this.target="/module/Pinlun/Plselect.jsp";
        return "success";
	 }
	 /**
	  * 删除评论
	  */
	 public void delPl(){
		 PinLunDAO pl=new PinLunDAOImpl();
		 boolean result=pl.deletePinlun(commentid);
		 Message mess=new Message();
		 if(result){
			 mess.setState(true);
			 mess.setMessage("删除成功");
			 this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
		 } 
	 }
	 /**
	  * 根据评论id进行查询
	  * @return
	  */
	 public String findPl(){
		 PinLunDAO pl=new PinLunDAOImpl();
		 pmap=pl.SelPinlun(commentid);
		 this.target="/module/Pinlun/Huifu.jsp";
	     return "success";
	 }
	 /**
	  * 根据评论id进行修改
	  */
    public void updatePl(){
    	 PinLunDAO pl=new PinLunDAOImpl();
    	 HttpSession session=this.getSession();
         Map map=(Map) session.getAttribute("userinfo");
         String empid=map.get("emp_id").toString();
		 boolean result=pl.updatePinlun(commentreplay,commentid,empid);
		 Message mess=new Message();
		 if(result){
			 mess.setState(true);
			 mess.setMessage("回复成功");
			 this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
		 } 
    }
	 
	 
	 
	 
    
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public Map getUsermap() {
		return usermap;
	}
	public void setUsermap(Map usermap) {
		this.usermap = usermap;
	}
	public String getCommentreplay() {
		return commentreplay;
	}
	public void setCommentreplay(String commentreplay) {
		this.commentreplay = commentreplay;
	}
	public Map getPmap() {
		return pmap;
	}
	public void setPmap(Map pmap) {
		this.pmap = pmap;
	}
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public List getPlist() {
		return plist;
	}

	public void setPlist(List plist) {
		this.plist = plist;
	}
	public String getNowpage() {
		return nowpage;
	}


	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}


	public PageEntity getPage() {
		return page;
	}


	public void setPage(PageEntity page) {
		this.page = page;
	}
}
