package com.ht.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ht.common.BaseAction;
import com.ht.service.IEmpService;
import com.ht.service.IExamineService;
import com.ht.vo.Emp;
import com.ht.vo.Holday;
import com.ht.vo.Jiaban;
import com.ht.vo.Kaoqin;
import com.ht.vo.Zhiban;

public class ExamineAction extends BaseAction{
	IExamineService ex=(IExamineService)getService("xService");
	IEmpService ie=(IEmpService)getService("eService");
	//考勤
	private Kaoqin kaoqin;
	//休假
	private Holday hol;
	//加班
	private Jiaban jia;
	private String jstart;
	
	//值班
	private Zhiban zhiban;
	
	private String status;
	private String jid;
	//修改状态
	private String hid;
	private String eid;
	private String hday;
	private String hkind;
	private String jday;
	
	Emp emp=(Emp)fromSession("teacher");
	
	/******************************/
	//考勤
	public String kaolist(){
		List list=ex.listkao();
		ToRequest("list", list);
		
		List emplist=ex.deptman();
		ToRequest("emplist", emplist);
		
		return "tokaolist";
	}
	
	public String mykaolist(){
		List list=ex.mylistkao(emp.getEname());
		ToRequest("list", list);
		
		List emplist=ex.deptman();
		ToRequest("emplist", emplist);
		
		return "tomykaolist";
	}
	
	public String tokaoadd(){
		List list=ex.toaddkao();
		ToRequest("list", list);
		
		return "toaddkao";
	}
	public String kaoadd(){
		kaoqin.setKstatu(Long.parseLong(0+""));
		ex.addkao(kaoqin);
		return mykaolist();
	}
	
	/******************************/
	//请休假
	public String listhol(){
		List hlist=ex.hollist();
		ToRequest("hlist", hlist);
		
		List emplist=ex.deptman();
		ToRequest("emplist", emplist);
		
		List elist=ie.emplist();
		ToRequest("elist", elist);
		
		return "tolisthol";
	}
	public String mylisthol(){
		List hlist=ex.myhollist(emp.getEid());
		ToRequest("hlist", hlist);
		
		List emplist=ex.deptman();
		ToRequest("emplist", emplist);
		
		List elist=ie.emplist();
		ToRequest("elist", elist);
		
		return "tomylisthol";
	}
	public String toholadd(){
		List list=ex.toaddkao();
		ToRequest("list", list);
		
		return "toaddhol";
	}
	public String addhol(){
		hol.setEid(emp.getEid());
		hol.setHstatu(Long.parseLong(0+""));
		ex.holadd(hol);
		return mylisthol();
	}
	public String gethol(){
		hol=ex.gethol(hol.getHid());
		ToRequest("h", hol);
		List list=ex.toaddkao();
		ToRequest("list", list);
		return "toholupd";
	}
	public String holupd(){
		hol.setHstatu(Long.parseLong(0+""));
		ex.holupd(hol);
		return mylisthol();
	}
	public String holdel(){
		ex.holdel(hol);
		return mylisthol();
	}
	public String toupload(){
		ex.toupload(hol.getHid());
		return mylisthol();
	}
	public String toupdNO(){
		ex.toupdNO(hol.getHid());
		return mylisthol();
	}
	public String toupdholman(){
		if(status.equals("0")){
			ex.toupdYES(Long.parseLong(hid));
			System.out.println(hkind);
			if(hkind.equals("5")){
				ex.toupdhday(Long.parseLong(eid), Long.parseLong(hday));
			}
			
		}else if(status.equals("1")){
			return mylisthol();
		}else{
			ex.toupdholman(Long.parseLong(status), Long.parseLong(hid));
		}
		
		return mylisthol();
	}
	
	/******************************/
	//加班申请
	public String jialist(){
		List jlist=ex.jialist();
		ToRequest("jlist", jlist);
		
		List emplist=ex.deptman();
		ToRequest("emplist", emplist);
		
		List elist=ie.emplist();
		ToRequest("elist", elist);
		
		return "tojialist";
	}
	public String tojiaadd(){
		List list=ex.toaddkao();
		ToRequest("list", list);
		return "toaddjia";
	}
	public String myjiabanlist(){
		List list=ex.myjiaban(emp.getEid());
		ToRequest("list", list);
		
		List emplist=ex.deptman();
		ToRequest("emplist", emplist);
		
		List elist=ie.emplist();
		ToRequest("elist", elist);
		
		return "tomyjiaban";
	}
	public String jiaadd(){
		jia.setJstatu(Long.parseLong(0+""));
		Date date=new Date(jstart);
		jia.setJstart(date);
		ex.jiaadd(jia);
		return myjiabanlist();
	}
	public String getjia(){
		jia=ex.getjia(jia.getJid());
		ToRequest("jban", jia);
		List list=ex.toaddkao();
		ToRequest("list", list);
		return "tojiaupd";
	}
	public String jiaupd(){
		jia.setJstatu(Long.parseLong(0+""));
		ex.jiaupd(jia);
		return myjiabanlist();
	}  
	public String jiadel(){
		ex.jiadel(jia);
		return myjiabanlist();
	}
	public String toupdstatu(){
		ex.toupdstatu(jia.getJid());
		return myjiabanlist();
	}
	public String toupdstatuNO(){
		ex.toupdstatuNO(jia.getJid());
		return myjiabanlist();
	}
	public String toupdjman(){
		if(status.equals("0")){
			ex.toupdstatuYES(Long.parseLong(jid));
			ex.toupdaddhday(Long.parseLong(eid), Long.parseLong(jday));
		}else{
			ex.toupdjman(Long.parseLong(status), Long.parseLong(jid));
		}
		if(status.equals("1")){
			return myjiabanlist();
		}
		return myjiabanlist();
	}
	
	/******************************/
	//值班
	public String zhiban(){
		List list=ex.zhibanlist();
		ToRequest("list", list);
		 
		return "tozhiban";
	}
	
	//' 去 '修改值班
	public String toupd_zhiban(){
		System.out.println("aaaaaaaaaaaa");
		HttpServletRequest req = ServletActionContext.getRequest();
		Long id=Long.parseLong(req.getParameter("id")+"");
		Zhiban zb=ex.selZhibanById(id);
		ToRequest("zb", zb);
		
		return "toupd_zhiban";
	}
	//修改值班
	public String upd_zhiban(){
		System.out.println("进来修改值班");
		boolean bln=ex.updZhiban(zhiban);
		if (bln) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");

		}
		return "flush_zhiban";
	}
	
	
	
	public Kaoqin getKaoqin() {
		return kaoqin;
	}
	public void setKaoqin(Kaoqin kaoqin) {
		this.kaoqin = kaoqin;
	}
	public Holday getHol() {
		return hol;
	}
	public void setHol(Holday hol) {
		this.hol = hol;
	}
	public Jiaban getJia() {
		return jia;
	}
	public void setJia(Jiaban jia) {
		this.jia = jia;
	}
	public String getJstart() {
		return jstart;
	}
	public void setJstart(String jstart) {
		this.jstart = jstart;
	}
	public Zhiban getZhiban() {
		return zhiban;
	}
	public void setZhiban(Zhiban zhiban) {
		this.zhiban = zhiban;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getHday() {
		return hday;
	}

	public void setHday(String hday) {
		this.hday = hday;
	}

	public String getHkind() {
		return hkind;
	}

	public void setHkind(String hkind) {
		this.hkind = hkind;
	}

	public String getJday() {
		return jday;
	}

	public void setJday(String jday) {
		this.jday = jday;
	}
}
