package com.dc.controller.Function;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.dc.dao.Function.FunDAO;
import com.dc.dao.Function.FunDAOImpl;
import com.dc.dao.pinlun.PinLunDAO;
import com.dc.dao.pinlun.PinLunDAOImpl;
import com.dc.entity.Message;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;

public class FunctionsAction extends BaseAction{
    private String functionid;
    private String state;
    private Map map;//功能信息
    private List list;//下拉框
    private List list2;//子级功能
    private List list3;//功能树的结果集
    private List parentfun;//父级功能
    private List statelist;
    private String target;
    private String functionname;
    private String functionurl;
    private String functiondec;
    private String functionparentid;
    private String parentid;//父级id页面传参需要
    private String nowpage;
    private PageEntity page;
    /**
     * 根据id查询所有的功能信息
     */
    public String FindFunctionByid(){
    	FunDAO user=new FunDAOImpl();
        map=user.findFunctionsByid(functionid);
        list=user.findFunctions(functionid);//下拉框
        statelist=user.FindState();
        this.target="/module/Function/UpdateFunction.jsp";
        return "success";
    }
    /**
     * 查询父功能
     */
    public String SelParentFunction(){
    	int pageN=0;
	    if(com.dc.util.StringUtil.checkNotNull(nowpage)){
	    	pageN=Integer.parseInt(nowpage);
	    }else{
	    	pageN=1;
	    }
		PageEntity page1=new PageEntity();
		page1.setNowpage(pageN);
		FunDAO user=new FunDAOImpl();
		parentfun=user.FindParentFunction(page1);
        this.page=page1;
        this.target="/module/Function/Selectfunction.jsp";
        return "success";
    }
    /***
     * 根据父功能查询子功能
     * @return
     */
    public String SelFunction(){
		int pageN=0;
	    if(com.dc.util.StringUtil.checkNotNull(nowpage)){
	    	pageN=Integer.parseInt(nowpage);
	    }else{
	    	pageN=1;
	    }
		PageEntity page1=new PageEntity();
		page1.setNowpage(pageN);
		FunDAO user=new FunDAOImpl();
		list2=user.Selfunction(functionid,page1);
        this.page=page1;
        this.target="/module/Function/SelectSonFun.jsp";
        return "success";
    }
    /***
     * 新增或修改功能
     * @return
     */
    public void InsertFunction(){
    	FunDAO user=new FunDAOImpl();
    	HttpSession session=this.getSession();
        Map map=(Map) session.getAttribute("userinfo");
        String userid=map.get("emp_id").toString();
        String username=map.get("emp_user").toString();
    	if(com.dc.util.StringUtil.checkNotNull(functionid)){
        	boolean result=user.updateFunction(functionname, functiondec, functionurl,state, functionparentid,userid,username,functionid);
    		Message mess=new Message();
   		    if(result){
   			 mess.setState(true);
   			 mess.setMessage("修改成功");
   			 this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
   		     } 
        }else{
        	boolean result=user.insertFunction(functionname, functiondec, functionurl,state, functionparentid,userid,username);
        	Message mess=new Message();
   		    if(result){
   			 mess.setState(true);
   			 mess.setMessage("新增成功");
   			 this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
   		 } 
        }
    }
    /***
     * 功能树
     */
    public void FunctionTree(){
    	FunDAO user=new FunDAOImpl();
        list3=user.FindALLFunctions();
        JSONArray json=new JSONArray();
        json=JSONArray.fromObject(list3);
        this.getOut().print(json.toString());
    }
    
    
    /***
     * 启用禁用功能
     * @return
     */
    public void UpdateState(){
    	FunDAO user=new FunDAOImpl();
    	boolean result=user.upOrDown(state, functionid);
    	Message mess=new Message();
		if(result){
		    mess.setState(true);
			mess.setMessage("状态修改成功");
        }else{
        	mess.setState(false);
        	mess.setMessage("状态修改失败");
        }
		 this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
    } 
    /***
     * 唯一性校验校验功能名
     */
    public void CheckFunction(){
    	FunDAO user=new FunDAOImpl();
  	  boolean result=user.checkFunctions(functionname, functionid);
		  Message mess=new Message();
		  mess.setState(result);
		  if(result){
			mess.setMessage("该功能名已存在请重新输入");
		  }else{
			mess.setMessage("该功能名可以使用");  
		  }
		  this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
    }
    
    
    
    
	public List getStatelist() {
		return statelist;
	}
	public void setStatelist(List statelist) {
		this.statelist = statelist;
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
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List getParentfun() {
		return parentfun;
	}
	public void setParentfun(List parentfun) {
		this.parentfun = parentfun;
	}
	public List getList3() {
		return list3;
	}
	public void setList3(List list3) {
		this.list3 = list3;
	}
	public List getList2() {
		return list2;
	}
	public void setList2(List list2) {
		this.list2 = list2;
	}
	public String getFunctionname() {
		return functionname;
	}
	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}
	public String getFunctionurl() {
		return functionurl;
	}
	public void setFunctionurl(String functionurl) {
		this.functionurl = functionurl;
	}
	public String getFunctiondec() {
		return functiondec;
	}
	public void setFunctiondec(String functiondec) {
		this.functiondec = functiondec;
	}
	public String getFunctionparentid() {
		return functionparentid;
	}
	public void setFunctionparentid(String functionparentid) {
		this.functionparentid = functionparentid;
	}
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getFunctionid() {
		return functionid;
	}
	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
    
}
