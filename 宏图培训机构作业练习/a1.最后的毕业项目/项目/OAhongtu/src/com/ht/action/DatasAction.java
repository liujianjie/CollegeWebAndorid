package com.ht.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.Session;

import com.ht.common.BaseAction;
import com.ht.service.IDatasService;
import com.ht.vo.Dept;
import com.ht.vo.Deptmans;
import com.ht.vo.Emp;
import com.ht.vo.Rizhi;
import com.ht.vo.Sroom;
import com.ht.vo.Xuncha;

public class DatasAction extends BaseAction{
	IDatasService ds=(IDatasService)getService("dService");
	//部门
	private Dept dept;
	public String createt; 
	
	private Deptmans mans;

	//巡查
	List listss=new ArrayList();
	public String xdate;
	public String xname;
	private String[] xtime;
	private String[] cls;
	private String[] xcount;
	private String[] xnumber;
	private String[] xclean;
	private String[] xteach;
	private String[] isteach;
	private String[] xstudent;
	private String[] xdoteach; 
	private String times;
	private Date dd;
	//日志
	private Rizhi rizhi;
	//宿舍
	private Sroom sr;
	
	Emp emp=(Emp)fromSession("teacher");
	
	public String execute(){
		System.out.println("cccccccccccc");
		
		return "success";
	}
	//部门list方法 
	public String deptlist(){
		List list=ds.deptlist();
		ToRequest("list", list);
		
		List mlist=ds.manslist();
		ToRequest("mlist", mlist);
		
		return "todept";
	}
	
	public String manlist(){
		List list=ds.manslist();
		ToRequest("mlist", list);
		
		return "todeptadd";
	}
	//添加部门
	public String deptadd(){
		SimpleDateFormat df=new SimpleDateFormat("YYYY/MM/DD");
		Date date=new Date();
		dept.setCreatetime(date);
		System.out.println(date);
		
		dept.setKing(Long.parseLong(1001+""));
		ds.deptadd(dept);
		
		return "tolist";
	}
	
	public String getdept(){
		dept=ds.getdept(dept.getDid());
		ToRequest("d", dept);
		List list=ds.manslist();
		ToRequest("mlist", list);
		
		return "toupd";
	}
	
	public String deptupd(){
		ds.deptupd(dept);
		
		return deptlist();
	}
	
	public String deptdel(){
		ds.deptdel(dept);
		
		return deptlist();
	}
	
	//
	
	public String deptmanlist(){
		List dmlist=ds.manslist();
		ToRequest("dmlist", dmlist);
		
		List list=ds.deptlist();
		ToRequest("list", list);
		
		List elist=ds.emplist();
		ToRequest("elist", elist);
		
		return "todeptmanlist";
	}
	public String deptmanadd(){
		ds.mansadd(mans);
		
		return deptmanlist();
	}
	
	public String deptmandel(){
		ds.mansdel(mans);
		
		return deptmanlist();
	}
	
	/**********************************************************/
	//巡查
	public String xunlist(){
		 listss=ds.xunlist(xname,xdate,times);
		 System.out.println("ssssssssssss");
		return "success";
	}
	
	public String toaddxun(){
		List list=ds.toxuncha();
		ToRequest("cla", list);
		
		return "toxuncha";
	}
	
	//添加巡查
	public String addxuncha(){
		Date date=new Date(xdate);
		Xuncha xun=new Xuncha();
		for (int i = 0; i < cls.length; i++) {
			xun.setXname(xname);
			xun.setXdate(date);
			xun.setXtime(xtime[i]);
			xun.setXclass(cls[i]);
			xun.setXcount(Long.parseLong(xcount[i]));
			xun.setXnumber(Long.parseLong(xnumber[i]));
			xun.setXclean(xclean[i]);
			xun.setXteach(xteach[i]);
			xun.setIsteach(isteach[i]);
			xun.setXstudent(xstudent[i]);
			xun.setXdoteach(xdoteach[i]);
			ds.addxun(xun);
		}
		return "toxunlist";
	}
	
	/**********************************************************/
	//日志
	public String rizhilist(){
		List rlist=ds.rizhilist();
		ToRequest("rlist", rlist);
		
		List list=ds.emplist();
		ToRequest("list", list);
		return "torlist";
	}
	
	public String myrizhi(){
		List Elist=ds.myrizhi(emp.getEid());
		ToRequest("Elist", Elist);
		
		List list=ds.emplist();
		ToRequest("list", list);
		return "tomyrizhi";
	}
	public String addrizhi(){
		
		rizhi.setEid(emp.getEid());
		System.out.println(rizhi.getRdate()); 
		ds.addrizhi(rizhi);
		return myrizhi();
	}
	
	public String fromrizhi(){
		rizhi=ds.getrizhi(rizhi.getRid());
		ToRequest("rzhi", rizhi);
		return "torizhiupd";
	}
	public String rizhiupd(){
		rizhi.setEid(Long.parseLong(13+""));
		ds.rizhiupd(rizhi);
		return rizhilist();
	}
	public String rizhidel(){
		ds.rizhidel(rizhi);
		return rizhilist();
	}
	
	/*****************************************/
	//宿舍巡查
	public String roomlist(){
		List rlist=ds.listroom();
		ToRequest("rlist", rlist);
		
		List room=ds.toaddroom();
		ToRequest("room", room);
		
		List elist=ds.emplist();
		ToRequest("elist", elist);

		return "toroomlist";
	}
	public String myroomlist(){
		List rlist=ds.mylistroom(emp.getEid());
		ToRequest("rlist", rlist);
		
		List room=ds.toaddroom();
		ToRequest("room", room);
		
		List elist=ds.emplist();
		ToRequest("elist", elist);

		return "tomyroomlist";
	}
	public String toaddroom(){
		List room=ds.toaddroom();
		ToRequest("room", room);
		return "toroomadd";
	}
	public String roomadd(){
		sr.setEmpid(emp.getEid());
		ds.addroom(sr);         
		return myroomlist();
	}
	public String fromroom(){
		sr=ds.getroom(sr.getSrid());   
		ToRequest("rs", sr);
		List room=ds.toaddroom();
		ToRequest("room", room);
		return "toroomupd";
	}
	public String roomupd(){
		sr.setEmpid(Long.parseLong(1007+""));
		ds.roomupd(sr);      
		return myroomlist();
	}
	public String roomdel(){
		ds.roomdel(sr);   
		return myroomlist();
	}
	
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept; 
	}

	public String getCreatet() {
		return createt;
	}

	public void setCreatet(String createt) {
		this.createt = createt;
	}

	public String getXdate() {
		return xdate;
	}

	public void setXdate(String xdate) {
		this.xdate = xdate;
	}
	public String getXname() {
		return xname;
	}
	public void setXname(String xname) {
		this.xname = xname;
	}
	public String[] getXtime() {
		return xtime;
	}
	public void setXtime(String[] xtime) {
		this.xtime = xtime;
	}
	public String[] getCls() {
		return cls;
	}
	public void setCls(String[] cls) {
		this.cls = cls;
	}
	public String[] getXcount() {
		return xcount;
	}
	public void setXcount(String[] xcount) {
		this.xcount = xcount;
	}
	public String[] getXnumber() {
		return xnumber;
	}
	public void setXnumber(String[] xnumber) {
		this.xnumber = xnumber;
	}
	public String[] getXclean() {
		return xclean;
	}
	public void setXclean(String[] xclean) {
		this.xclean = xclean;
	}
	public String[] getXteach() {
		return xteach;
	}
	public void setXteach(String[] xteach) {
		this.xteach = xteach;
	}
	public String[] getIsteach() {
		return isteach;
	}
	public void setIsteach(String[] isteach) {
		this.isteach = isteach;
	}
	public String[] getXstudent() {
		return xstudent;
	}
	public void setXstudent(String[] xstudent) {
		this.xstudent = xstudent;
	}
	public String[] getXdoteach() {
		return xdoteach;
	}
	public void setXdoteach(String[] xdoteach) {
		this.xdoteach = xdoteach;
	}

	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Date getDd() {
		return dd;
	}
	public void setDd(Date dd) {
		this.dd = dd;
	}
	public Rizhi getRizhi() {
		return rizhi;
	}
	public void setRizhi(Rizhi rizhi) {
		this.rizhi = rizhi;
	}
	public Sroom getSr() {
		return sr;
	}
	public void setSr(Sroom sr) {
		this.sr = sr;
	}
	public List getListss() {
		return listss;
	}
	public void setListss(List listss) {
		this.listss = listss;
	}
	public Deptmans getMans() {
		return mans;
	}
	public void setMans(Deptmans mans) {
		this.mans = mans;
	}
}
