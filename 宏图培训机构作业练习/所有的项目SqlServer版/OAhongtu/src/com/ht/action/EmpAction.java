package com.ht.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ht.common.BaseAction;
import com.ht.service.IDatasService;
import com.ht.service.IEmpService;
import com.ht.vo.Education;
import com.ht.vo.Emp;
import com.ht.vo.Family;
import com.ht.vo.Jobs;
import com.ht.vo.Userroot;
import com.ht.vo5.Student;

public class EmpAction extends BaseAction{
	IEmpService ie=(IEmpService)getService("eService");
	IDatasService ds=(IDatasService)getService("dService");
	//级联对象
	private Emp emp;
	
	private String emptry;
	//文件上传
	private File fil;
	private String filFileName;
	private String filContentType;
	
	//将文件保存到服务器项目imgs文件中
	private String savepath=ServletActionContext.getRequest().getRealPath("imgs")+"\\";
	// 工作经历
	private String[] jid;
	private String[] comp;
	private String[] cjob;
	private String[] cstart;
	private String[] cend;
	private String[] cpeople;
	private String[] cpho;
	//家庭成员
	private String[] fid;
	private String[] famname;
	private String[] famjob;
	private String[] famfre;
	private String[] fampho;
	//教育经历
	private String[] edid;
	private String[] edustart;
	private String[] eduend;
	private String[] edusch;
	private String[] edustd;
	
	private String[] eid;
	
	//查看详情参数
	private String viewid;
	
	//员工权限
	private String userid;
	private String[] mid;
	
	private String stuid;
	
	public String list(){
		List list=ie.emplist();
		ToRequest("list", list);
		
		List dlist=ds.deptlist();
		ToRequest("dlist", dlist);
		return "toemplist";
	}
	
	public String toempadd(){
		List dlist=ie.toaddemp();
		ToRequest("dlist", dlist);
		return "toaddemp";
	}
	
	public String empadd(){
		try {
				//将临时文件写入到指定的保存路径
				FileOutputStream fos = new FileOutputStream(this.savepath +this.filFileName);
				//读取服务器上的临时文件 
				FileInputStream fis = new FileInputStream(fil);
				byte[] bs = new byte[1024];
				int real = fis.read(bs);
				while(real > 0){
				fos.write(bs, 0, real);
				real = fis.read(bs);
				}
				fos.close();
				fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-DD");
		System.out.println(emptry);
		Date etrys=new Date(emptry);
		emp.setEtry(etrys);
		System.out.println(filFileName);
		emp.setFace(filFileName);
		
		emp.setEstatus(Long.parseLong(0+""));
		ie.empadd(emp);
		
		
		//添加工作经历
		for (int i = 0; i < cjob.length; i++) {
			Jobs job=new Jobs();
			System.out.println(cjob.length);
			System.out.println(emp.getEid()+"员工id......");
			job.setEid(emp.getEid());
			System.out.println(job.getEid());
			System.out.println(comp[i]);
			job.setJcompany(comp[i]);
			job.setJedu(cjob[i]);
			
			Date jstart=new Date(cstart[i]);
			job.setJstart(jstart);
			Date jend=new Date(cend[i]);
			job.setJend(jend);
			job.setJpeople(cpeople[i]);
			job.setJtel(cpho[i]);
			ie.jobadd(job);
		}
		//添加家庭成员
		for (int j = 0; j < famname.length; j++) {
			Family fam=new Family();
			fam.setEid(emp.getEid()); 
			fam.setFname(famname[j]);
			fam.setFjob(famjob[j]);
			fam.setFrelation(famfre[j]);
			fam.setFtel(fampho[j]); 
			ie.famadd(fam);
		}
		//添加教育经历
		for (int k = 0; k < edusch.length; k++) {
			Education edus=new Education();
			edus.setEid(emp.getEid());
			Date estart=new Date(edustart[k]);
			edus.setEdstart(estart);
			Date eend=new Date(eduend[k]);
			edus.setEdend(eend);
			edus.setEdschool(edusch[k]);
			edus.setEdu(edustd[k]);
			ie.eduadd(edus);
		}
		
		return list();
	}

	public String getemps(){
		emp=ie.getemp(emp.getEid());
		ToRequest("emps", emp);
		
		List dlist=ie.toaddemp();
		ToRequest("dlist", dlist);
		
		List famlist=ie.famlist(emp.getEid());
		ToRequest("famlist", famlist);
		
		List joblist=ie.joblist(emp.getEid());
		ToRequest("joblist", joblist);
		
		List edulist=ie.edulist(emp.getEid());
		ToRequest("edulist", edulist);
		System.out.println(viewid);
		if("1".equals(viewid)){
			System.out.println(viewid);
			return "toviewemp";
		}else{
			return "toempupd";
		}
	}
	
	public String empupd(){ 
		try {
			//将临时文件写入到指定的保存路径
			FileOutputStream fos = new FileOutputStream(this.savepath +this.filFileName);
			//读取服务器上的临时文件 
			FileInputStream fis = new FileInputStream(fil);
			byte[] bs = new byte[1024];
			int real = fis.read(bs);
			while(real > 0){
			fos.write(bs, 0, real);
			real = fis.read(bs);
			}
			fos.close();
			fis.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		Date date=new Date(emptry);
		emp.setEtry(date);
		emp.setFace(filFileName);
		System.out.println(filFileName+"ssssssss");
		
		ie.empupd(emp);
		
		return list();
	}
	public String updfam(){
		//修改家庭成员
		for (int j = 0; j < famname.length; j++) {
			Family fam=new Family();
			fam.setFid(Long.parseLong(fid[j]));
			fam.setEid(Long.parseLong(eid[j])); 
			fam.setFname(famname[j]);
			fam.setFjob(famjob[j]);
			fam.setFrelation(famfre[j]);
			fam.setFtel(fampho[j]); 
			ie.famupd(fam);
		}
		return list();
	}
	
	public String updjob(){
		//修改工作经历
		for (int i = 0; i < cjob.length; i++) {
			Jobs job=new Jobs();
			job.setJid(Long.parseLong(jid[i]));
			job.setEid(Long.parseLong(eid[i]));
			System.out.println(job.getEid());
			System.out.println(comp[i]);
			job.setJcompany(comp[i]);
			job.setJedu(cjob[i]);
			
			Date jstart=new Date(cstart[i]);
			job.setJstart(jstart);
			Date jend=new Date(cend[i]);
			job.setJend(jend);
			job.setJpeople(cpeople[i]);
			job.setJtel(cpho[i]);
			ie.jobupd(job);
		}
		return list();
	}
	
	public String updedu(){
		//修改教育经历
		for (int k = 0; k < edusch.length; k++) {
			Education edus=new Education();
			edus.setEdid(Long.parseLong(edid[k]));
			edus.setEid(Long.parseLong(eid[k]));
			Date estart=new Date(edustart[k]);
			edus.setEdstart(estart);
			Date eend=new Date(eduend[k]);
			edus.setEdend(eend);
			edus.setEdschool(edusch[k]);
			edus.setEdu(edustd[k]);
			ie.eduupd(edus);
		}
		return list();
	}
	
	/****************************************/
	//权限管理
	//员工权限
	public String rootlist(){
		List list=ie.emplist();
		ToRequest("list", list);
		
		List dlist=ds.deptlist();
		ToRequest("dlist", dlist);
		
		return "torootlist";
	}
	
	public String rootemplist(){
		ToRequest("uid", userid);
		List rlist=ie.emprootlist(Long.parseLong(userid));
		ToRequest("rlist", rlist);
		
		return "torootemplist";
	}
	
	public String saverootemp(){
		ie.delemproot(Long.parseLong(userid));
		Userroot uroot=new Userroot();
		System.out.println(mid.length);
		for (int i = 0; i < mid.length; i++) {
			uroot.setUserid(Long.parseLong(userid));
			uroot.setMid(mid[i]);
			ie.saveemproot(uroot);
		}
		
		return rootlist();
	}
	
	//学生权限
	public String stulist(){
		Emp emp=(Emp)fromSession("teacher");
		
		List clalist=ie.getcla(emp.getEid());//需要当前登录用户
		List slit=new ArrayList();
		for (int i = 0; i < clalist.size(); i++) {
			Map map=(Map)clalist.get(i);
			System.out.println(map.get("CLASSNAME"));
			System.out.println(map.get("CLASSID"));
			List stulist=ie.stulist(Long.parseLong(map.get("CLASSID").toString()));
			slit.addAll(stulist);
		}
		ToRequest("stulist",slit);
		ToRequest("clalist", clalist);
		
		return "tostulist";
	}
	
	public String sturoot(){
		List stlist=ie.emprootlist(Long.parseLong(stuid));
		ToRequest("stlist", stlist);
		ToRequest("studentid", stuid);
		
		return "tosturoot";
	}
	public String saverootstu(){
		ie.delemproot(Long.parseLong(stuid));
		Userroot uroot=new Userroot();
		System.out.println(mid.length);
		for (int i = 0; i < mid.length; i++) {
			uroot.setUserid(Long.parseLong(stuid));
			uroot.setMid(mid[i]);
			ie.saveemproot(uroot);
		}
		
		return stulist();
	}
	
	/****************************************/
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	
	public File getFil() {
		return fil;
	}

	public void setFil(File fil) {
		this.fil = fil;
	}

	public String getFilFileName() {
		return filFileName;
	}

	public void setFilFileName(String filFileName) {
		this.filFileName = filFileName;
	}

	public String getFilContentType() {
		return filContentType;
	}

	public void setFilContentType(String filContentType) {
		this.filContentType = filContentType;
	}

	
	public String[] getComp() {
		return comp;
	}

	public void setComp(String[] comp) {
		this.comp = comp;
	}

	public String[] getCjob() {
		return cjob;
	}

	public void setCjob(String[] cjob) {
		this.cjob = cjob;
	}

	public String[] getCstart() {
		return cstart;
	}

	public void setCstart(String[] cstart) {
		this.cstart = cstart;
	}

	public String[] getCend() {
		return cend;
	}

	public void setCend(String[] cend) {
		this.cend = cend;
	}

	public String[] getCpeople() {
		return cpeople;
	}

	public void setCpeople(String[] cpeople) {
		this.cpeople = cpeople;
	}

	public String[] getCpho() {
		return cpho;
	}

	public void setCpho(String[] cpho) {
		this.cpho = cpho;
	}

	public String[] getFamname() {
		return famname;
	}

	public void setFamname(String[] famname) {
		this.famname = famname;
	}

	public String[] getFamjob() {
		return famjob;
	}

	public void setFamjob(String[] famjob) {
		this.famjob = famjob;
	}

	public String[] getFamfre() {
		return famfre;
	}

	public void setFamfre(String[] famfre) {
		this.famfre = famfre;
	}

	public String[] getFampho() {
		return fampho;
	}

	public void setFampho(String[] fampho) {
		this.fampho = fampho;
	}

	public String[] getEdustart() {
		return edustart;
	}

	public void setEdustart(String[] edustart) {
		this.edustart = edustart;
	}

	public String[] getEduend() {
		return eduend;
	}

	public void setEduend(String[] eduend) {
		this.eduend = eduend;
	}

	public String[] getEdusch() {
		return edusch;
	}

	public void setEdusch(String[] edusch) {
		this.edusch = edusch;
	}

	public String[] getEdustd() {
		return edustd;
	}

	public void setEdustd(String[] edustd) {
		this.edustd = edustd;
	}

	public String getEmptry() {
		return emptry;
	}

	public void setEmptry(String emptry) {
		this.emptry = emptry;
	}

	public String[] getJid() {
		return jid;
	}

	public void setJid(String[] jid) {
		this.jid = jid;
	}

	public String[] getFid() {
		return fid;
	}

	public void setFid(String[] fid) {
		this.fid = fid;
	}

	public String[] getEdid() {
		return edid;
	}

	public void setEdid(String[] edid) {
		this.edid = edid;
	}

	public String[] getEid() {
		return eid;
	}

	public void setEid(String[] eid) {
		this.eid = eid;
	}

	public String getViewid() {
		return viewid;
	}

	public void setViewid(String viewid) {
		this.viewid = viewid;
	}


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String[] getMid() {
		return mid;
	}

	public void setMid(String[] mid) {
		this.mid = mid;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
}
