package com.ht.action;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ht.common.BaseAction;
import com.ht.service.ITongZhiService;
import com.ht.vo.Emp;
import com.ht.vo6.Msg;



public class TongZhiAction extends BaseAction{
	ITongZhiService itz=(ITongZhiService)getService("tService");
	
	
	private List list;
	
	private Long msgid;
	private Msg msg;
	
	private List listEmp;
	
	String leixing;
	
	//查询员工通知
	public String list1(){
		list=itz.TongZhilist1();
		ToRequest("list", list);
		ToRequest("num", 1);
		
		return "totongzhi";
	}
	//查询学生通知
	public String list2(){
		
		System.out.println("进来了");
		
		list=itz.TongZhilist2();
		
		ToRequest("list", list);
		ToRequest("num", 2);
		
		return "totongzhi";
	}
	
	
	//查看所有员工公告(已发布)
	public String list3(){
		
		System.out.println("进来了list3");		
		
		list=itz.TongZhilist3();
		
		ToRequest("list", list);
		ToRequest("num", 1);
		
		return "totongzhi2";
	}
	//查看所有学生公告
	public String list4(){
		
		System.out.println("进来了list4");
		
		list=itz.TongZhilist4();
		
		ToRequest("list", list);
		ToRequest("num", 2);
		
		return "totongzhi2";
	}
	
	

//查询未发布公告
	public String release(){
		
		System.out.println("马超来了");
		
		list =itz.release();
		
		
		return "release";
	}
	
	//查询所有员工(f1)
	public String selAllEmp(){
		System.out.println("进来了111111111111111");
		 listEmp=itz.findAllEmp();
		 System.out.println("size: "+listEmp.size());
		return "success";
		
	}
	
	
	
	//去修改公告页面
	public String toupd(){
		System.out.println("进来了toupd");
		HttpServletRequest req=ServletActionContext.getRequest();
		String id=req.getParameter("id");
		System.out.println("id:"+id);
		
		Msg m=itz.getMsgById(Integer.parseInt(id));
		listEmp=itz.findAllEmp();
		ToRequest("m", m);
		ToRequest("listEmp", listEmp);
		
		return "tongzhi_upd";
	}
	
	//修改公告
	public String upd(){
		System.out.println("进来了。。。。。。。。。。。");
				
		boolean bln=itz.updTongzhi(msg);
		if(bln){
			System.out.println("修改公告成功");
		}else{
			System.out.println("修改公告失败");
		}
		
		//查通知类型
		List listType=itz.selTongzhiType(msg.getMsgid());
		Map map=(Map)listType.get(0);
		BigDecimal b=(BigDecimal)map.get("MSGFACE");
		int i=b.intValue();
		System.out.println("公告类型： "+i);
		if(i==1){
			return "flush_tongzhi1";
		}else if(i==2){
			return "flush_tongzhi2";
		}
		
		return null;
	}
	
	
//添加公告
	public String add(){
		msg.setMsgstatus(0);
	
		boolean bln= itz.TongZhiadd(msg);
		if(bln){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		

		if(msg.getMsgface()==1){
			return "flush_tongzhi1";
		}else if(msg.getMsgface()==2){
			return "flush_tongzhi2";
			
		}
		return null;
	}
	
	
//发布公告
	public String fabu(){
		System.out.println("6666666666666");
		HttpServletRequest req=ServletActionContext.getRequest();
		String strid=req.getParameter("id");
		System.out.println("id="+strid);
		
		int id=Integer.parseInt(strid);
		
		//改发布状态
		boolean bln1=itz.updStatus(id);
		if(bln1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		//把发布人改成当前登陆用户
		Emp emp=(Emp)req.getSession().getAttribute("teacher");
		String ename=emp.getEname();
		boolean bln3=itz.upd_faburen(id, ename);
		if(bln3){
			System.out.println("修改发布人成功");
		}else{
			System.out.println("修改发布人失败");
		}
		
		//获取系统当前时间
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		
		System.out.println("系统时间："+time);
		
//		
		//保存发布时间
		boolean bln2=itz.saveFabuTime(id, time);
		if(bln2){
			System.out.println("保存成功");
		}else{
			System.out.println("保存失败");
		}
		
//		//查通知类型
		List listType=itz.selTongzhiType(id);
		Map map=(Map)listType.get(0);
		BigDecimal b=(BigDecimal)map.get("MSGFACE");
		int i=b.intValue();
		System.out.println("公告类型： "+i);
		if(i==1){
			return "flush_tongzhi1";
		}else if(i==2){
			return "flush_tongzhi2";
		}
		
		return null;
	}
	
	
	//删除通知
	public String del(){		
		
		HttpServletRequest req=ServletActionContext.getRequest();
		String id=req.getParameter("id");
		
		//查通知类型
		List listType=itz.selTongzhiType(Integer.parseInt(id));
		
		System.out.println("size大小："+listType.size());
		
		Map map=(Map)listType.get(0);
		BigDecimal b=(BigDecimal)map.get("MSGFACE");
		int i=b.intValue();
		System.out.println("公告类型： "+i);
		
		Msg m=itz.getMsgById(Integer.parseInt(id));
		boolean bln=itz.delTongzhi(m);
		if(bln){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		
		
		if(i==1){
			return "flush_tongzhi1";
		}else if(i==2){
			return "flush_tongzhi2";
		}
		
		return null;
	}
	
	
	public String upGG(){		
		//发布通知;
		int i=msg.getMsgid();
		System.out.println(i+" shah ");
		
		System.out.println(msg);
		Msg ms=itz.getMsgById(i);
		
		this.ToRequest("ms",ms);
		return release();
	}
	
	//查看通知详情	
	public String xq(){
		
//		System.out.println(msg.getMsgid());
//		itz.xq(msg);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		System.out.println(id);
		
		Msg msg=itz.getMsgById(Integer.parseInt(id));
		ToRequest("msg", msg);
		return "details";
	}
	
	
	
	
	public String toadd(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		System.out.println("页面传过来的："+id);
		int num=Integer.parseInt(id);
		ToRequest("num", num);
		System.out.println("num:  "+num);
		return "addpage";
	}
	
	
	public Long getMsgid() {
		return msgid;
	}
	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}
	public Msg getMsg() {
		return msg;
	}
	public void setMsg(Msg msg) {
		this.msg = msg;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public List getListEmp() {
		return listEmp;
	}
	public void setListEmp(List listEmp) {
		this.listEmp = listEmp;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
		
	
	
	
}
