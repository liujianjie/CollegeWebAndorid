package com.dc.controller.Pinlun;

import java.util.List;
import java.util.Map;

import com.dc.dao.pinlun.QTPinlunDAO;
import com.dc.dao.pinlun.QTPinlunDAOImpl;
import com.dc.entity.Message;
import com.dc.util.BaseAction;

/**
 * 前台评论功能
 * @author Administrator
 *
 */
public class CommentAction extends BaseAction{
    private String orderid;
    private String target;
    private List list;
    private List plist;
    private Map map;
    private List meal;
    private String commentcontent;
    private String mealid;
    private String mealname;
    private String check;
    /**
     * 查询菜品信息，菜品相关评论
     * @return
     */
    public String FindOrder(){
    	QTPinlunDAO user=new QTPinlunDAOImpl();
    	list=user.FindOrder(orderid);
    	plist=user.FindPinlun(orderid);
    	meal=user.FindOrder(orderid);
    	this.target="/module/Pinlun/OrderPl.jsp";
    	return "success";
    }
    /**
     * 根据食物id进行评论
     */
    public void insertPl(){
    	QTPinlunDAO user=new QTPinlunDAOImpl();
    	boolean result=user.InsertPL(orderid, commentcontent,check, mealid);
		 Message mess=new Message();
		 if(result){
			 mess.setState(true);
			 mess.setMessage("评论成功");
			 this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
		 } 
    }
    public String CustomerPl(){
    	QTPinlunDAO user=new QTPinlunDAOImpl();
    	map=user.findmeal(mealid);
    	this.target="/module/Pinlun/CustomerPl.jsp";
    	return "success";
    }
    
    
    
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public String getMealid() {
		return mealid;
	}
	public void setMealid(String mealid) {
		this.mealid = mealid;
	}
	public List getMeal() {
		return meal;
	}

	public void setMeal(List meal) {
		this.meal = meal;
	}

	public List getPlist() {
		return plist;
	}

	public void setPlist(List plist) {
		this.plist = plist;
	}

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getMealname() {
		return mealname;
	}
	public void setMealname(String mealname) {
		this.mealname = mealname;
	}
    
}
