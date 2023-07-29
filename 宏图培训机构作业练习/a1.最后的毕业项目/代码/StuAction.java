package com.ht.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;

import com.ht.common.BaseAction;
import com.ht.service.ICourseService;
import com.ht.service.IEmpService;
import com.ht.service.IStuService;
import com.ht.service.impl.CourseServiceImpl;
import com.ht.service.impl.EmpServiceimpl;
import com.ht.service.impl.StuServiceimpl;
import com.ht.vo.Emp;
import com.ht.vo2.Course;
import com.ht.vo5.Application;
import com.ht.vo5.Classes;
import com.ht.vo5.Defenses;
import com.ht.vo5.Elements;
import com.ht.vo5.Hourse;
import com.ht.vo5.Job;
import com.ht.vo5.Leave;
import com.ht.vo5.Projectf;
import com.ht.vo5.Reply;
import com.ht.vo5.Says;
import com.ht.vo5.Sback;
import com.ht.vo5.Score;
import com.ht.vo5.Student;
import com.ht.vo5.Summary;

public class StuAction extends BaseAction{
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	Student studentlogin=(Student) session.getAttribute("stu");
	Emp emplogin=(Emp)session.getAttribute("teacher");
	
	IStuService ss=(IStuService)getService("sService");
	IEmpService ie=(IEmpService)getService("eService");
	ICourseService ic=(ICourseService)getService("couService");
	
//	ICourseService ic=new CourseServiceImpl();
//  IStuService ss=new StuServiceimpl();
//  IEmpService ie=new EmpServiceimpl();
	
	private List list;
	private Student stu;
	private Long intenid;
	
	//上传的文件对象
	private File[] files;
	
	//上传的文件名称
	private String[] filesFileName;
	
	//上传的文件类型	  
	private String[] filesContentType;
	
	//项目发布路径
	private String savePath=ServletActionContext.getRequest().getRealPath("student")+"\\";
	
	public String execute(){
		return null;
	}
	//学生表的操作开始
	//所有学生信息
	public String listsx(){
		
		//查询所有在读学生
		Long status=(long)1;
		list= ss.listbystatus(status);
		size=list.size();
		
		//查询所有的班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "stulist";
	}
	//根据班级查询的学生
	public String list(){
		
		//查询所有学生 根据班级
		list= ss.listbyclassid(classid);
		size=list.size();
		
		//查询所有的班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);

		//查询班级对象
		Classes classes=ss.getcls(classid);
		ToRequest("classes", classes);
		
		return "stulist";
	}
	//单个学生的所有信息
	public String seldan(){
		
		stu=ss.get(intenid);
		
		return "stumore";
	}
	//单个学生的所有信息
	public String seldan2(){
		
		stu=ss.get(intenid);
		
		return "stustumore";
	}
	//单个学生的所有信息 去修改
	public String toalert(){
		try {
			stu=ss.get(intenid);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//查找所有宿舍 查找所有班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		List hrslist=ss.selhrslist();
		ToRequest("hrslist", hrslist);
		
		return "stualert";
	}
	//修改学生信息
	public String alert(){
		//保存文件
		//保存本地的路径
			try {
				for(int i=0;i<filesFileName.length;i++){
					try {
					
						FileOutputStream fos=new FileOutputStream(this.savePath+
								stu.getIntenid()+this.filesFileName[i]);
						//读取文件对象i
						FileInputStream fil=new FileInputStream(this.files[i]);
						//每次读入 写出的大小
						byte[] b=new byte[1024];
						int real=fil.read(b);
						int ii=0;
						while(real>0){
							fos.write(b, 0, real);
							
							real=fil.read(b);//每次读入 写出 文件对象就会少去这部分，所以这样1kb1kb写出 知道 读入不了了
							
							ii++;
						}
						fos.close();fil.close();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//设置img路径为img + name的路径
					stu.setIntenimg("student/"+stu.getIntenid()+filesFileName[i]);
				}
			} catch (RuntimeException e) {
		}
		/*******************
		 * 
		 * 因为有级联关系 必须是先查出表级联信息再修改 切记切记 不然会把分数的关联键设为空
		 * 
		 * --------------------------------------------------------------*/
		
		//修改
		boolean bln=ss.alert(stu);
		
		stu=ss.get(stu.getIntenid());
		
		ToRequest("stu", stu);

		//回去学生个人信息的界面
		return "stumore";
	}
	//删除学生
	public String del(){
		
		stu=ss.get(intenid);
		
		boolean bln=ss.del(stu);
		//关于score表的数据就让他删除吧
		
		return list();
	}
	
	//在校记录 分别是 成绩、项目成绩、谈心、总结、请假次数
	public String stujl(){
		stu=ss.get(intenid);
		//找出班主任
		try {
			Classes classes=ss.getcls(stu.getClassid());
			Emp emp=ss.getemp(classes.getEmpteaches());
			ToRequest("emp", emp);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//成绩
		List scolist=ss.selscore(intenid);
		int scosize=scolist.size();
		
		//项目
		List prjlist=ss.selprj(intenid);
		int prjsize=prjlist.size();
		//谈心
		List sayslist=ss.selsays(intenid);
		int sayssize=sayslist.size();
		//请假次数
		List levlist=ss.sellev(intenid);
		int levsize=levlist.size();
		
		//总结
		List smylist=ss.selsmy(intenid);
		int smysize=smylist.size();
		//课程
		List coslist=ss.selcos();
		int cossize=coslist.size();
		
		ToRequest("scolist", scolist);
		ToRequest("prjlist", prjlist);
		ToRequest("sayslist", sayslist);
		ToRequest("levlist", levlist);
		ToRequest("smylist", smylist);
		ToRequest("coslist", coslist);
		ToRequest("scosize", scosize);
		ToRequest("prjsize", prjsize);
		ToRequest("sayssize", sayssize);
		ToRequest("levsize", levsize);
		ToRequest("smysize", smysize);
		ToRequest("cossize", cossize);
		
		return "stujl";
	}
	
	
	private List clslist;
	private List hrslist;
	public String toadd1(){
		//查找出班级 宿舍 去添加页面
		clslist=ss.selclslist();
		//宿舍
		hrslist=ss.selhrslist();
		
		return "stuadd";
	}
	public String toadd(){
		//查找出班级 宿舍 去添加页面
		clslist=ss.selclslist();
		//宿舍
		hrslist=ss.selhrslist();
		
		return "success";
	}
	//字段
	private Long[] classids;
	private Long[] hourids;
	private String[] intennames;
	private String[] intensexs;
	private String[] intenages;
	private String[] intenbirs;
	private String[] intenfats;
	private String[] intentels;
	private String[] intenfatels;
	private String[] intenaddrs;
	private String[] intentimes;
	
	public String add(){
		//其中有 id 就读学校 爱好 职位 疑问 状态 6个手动设置
		try {
			for(int i=0;i<intennames.length;i++){
			
				Student stu=new Student();
				//添加开始
				stu.setIntenname(intennames[i]);//1
				stu.setIntensex(intensexs[i]);//2
				stu.setIntenage(Long.parseLong(intenages[i]));//3
				stu.setIntenbir(intenbirs[i]);//4
				stu.setIntenfat(intenfats[i]);//5
				stu.setIntentel(intentels[i]);//6
				stu.setIntenfatel(intenfatels[i]);//7
				stu.setIntenaddr(intenaddrs[i]);//8
				stu.setIntentime(intentimes[i]);//9
				stu.setClassid(classids[i]);//10
				stu.setHourid(hourids[i]);//11
				stu.setIntenstatus((long)1);//12
				//设置img路径为img + name的路径
				stu.setIntenimg("student/"+stu.getIntentel()+filesFileName[i]);//13
				boolean bln=ss.add(stu);
				//上传文件
				try {
					FileOutputStream fos=new FileOutputStream(this.savePath+
							stu.getIntentel()+this.filesFileName[i]);
					//读取文件对象i
					FileInputStream fil=new FileInputStream(this.files[i]);
					//每次读入 写出的大小
					byte[] b=new byte[1024];
					int real=fil.read(b);
					int ii=0;
					while(real>0){
						fos.write(b, 0, real);
						
						real=fil.read(b);//每次读入 写出 文件对象就会少去这部分，所以这样1kb1kb写出 知道 读入不了了
						
						ii++;
					}
					fos.close();fil.close();

				} catch (Exception e) {
				}
				
			}
			} catch (Exception e) {
				System.out.println("无数据");
		}
		
		return "listsx";
	}
	//预览头像图片
	public String ylalert(){
		Student stus=stu;
		//保存文件
		//保存本地的路径
			try {
				for(int i=0;i<filesFileName.length;i++){
					try {
					
						FileOutputStream fos=new FileOutputStream(this.savePath+
								stu.getIntenid()+this.filesFileName[i]);
						//读取文件对象i
						FileInputStream fil=new FileInputStream(this.files[i]);
						//每次读入 写出的大小
						byte[] b=new byte[1024];
						int real=fil.read(b);
						int ii=0;
						while(real>0){
							fos.write(b, 0, real);
							
							real=fil.read(b);//每次读入 写出 文件对象就会少去这部分，所以这样1kb1kb写出 知道 读入不了了
							
							ii++;
						}
						fos.close();fil.close();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//设置img路径为img + name的路径
					stu.setIntenimg("student/"+stu.getIntenid()+filesFileName[i]);
				}
			} catch (RuntimeException e) {
				System.out.println("无文件");
		}
	
		//修改
		boolean bln=ss.alert(stu);
		
		stu=ss.get(stu.getIntenid());
		
		ToRequest("stu", stu);
		
		//查找出班级 宿舍 去添加页面
		clslist=ss.selclslist();
		//宿舍
		hrslist=ss.selhrslist();

		//回去修改页面
		return "stualert";
	}
	
	//学生表的操作结束
	
	//宿舍表操作开始
	
	private Long hourid;
	
	private Hourse hrs;
	
	//宿舍列表
	public String hrslist(){
		List list = ss.hrslist();
		
		ToRequest("list", list);
		
		return "hrslist";
	}
	//删除
	public String hrsdel(){
		//先查出来
		Hourse hrs=ss.gethrs(hourid);
		
		/***********************************
		 * 
		 * 
		 * 有级联关系 一定要小心 这里一定得设置为null 不然会把学生数据一起删除 恩恩
		 * 
		 * 
		 * --------------------------------------------------------------*/
		hrs.setStudent(null);

		boolean bln=ss.delhrs(hrs);
		
		return hrslist();
	}
	//去修改
	public String hrstoalert(){
		//先查出来
		hrs=ss.gethrs(hourid);
		
		//应该顺便得有宿舍单元 跟宿舍单元是 多对一的关系
		List EleList=ss.selelelist();	
		ToRequest("elelist", EleList);
		
		//查询所有在读的学生 以来添加宿舍人员的目的 
		Long intenstatus=(long)1;
		List stulist=ss.listbystatus(intenstatus);
		
		//处理宿舍中已有的宿舍成员
		Set yystudent=hrs.getStudent();
		Iterator it = yystudent.iterator();

		for(;it.hasNext();){
		     Student s = (Student)it.next();
		     for(int j=0;j<stulist.size();j++){
				Map stu=(Map)stulist.get(j);
				Object o=stu.get("INTENID");
				/***********	Object转String必须 toString	*************/
				String ID=o.toString();
				Long Id=Long.parseLong(ID);
				Long id=s.getIntenid();
				if(Id.equals(id)){//MD Long类型竟然是equals对比
					stulist.remove(j);
				}
			}
		}
		ToRequest("stulist", stulist);
		
		//查出宿舍
		List hrslist=ss.selhrslist();
		ToRequest("hrslist", hrslist);
		
		return "hrsalert";
	}
	//修改
	public String hrsalert(){
		//System.out.println(hrs.getHourid()+" "+hrs.getEid()+" "+hrs.getHhead()+" "+hrs.getHnumber()+" "+hrs.getHourname());
		
		//获取宿舍成员 在添加到宿舍hrs里 来达到删除宿舍成员的目的
		String[] me=request.getParameterValues("member");
		String[] me2=request.getParameterValues("member2");
		
		//每个学生得找出来
		/*******************
		 * 
		 * 因为有级联关系 必须是先查出表级联信息再修改 切记切记 不然会把学生的关联键设为空
		 * 
		 * --------------------------------------------------------------*/
		//Hourse hrss=ss.gethrs(hrs.getHourid());
		Set set = new HashSet();//班级成员集合
		
		try {
			if(request.getParameter("member")!=null){
				for(int i=0;i<me.length;i++){
					Long mes=Long.parseLong(me[i]);
					Student stu=ss.get(mes);
					set.add(stu);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("无成员了");
		}
		try {
			if(request.getParameter("member2")!=null){
				for(int i=0;i<me2.length;i++){
					Long mes=Long.parseLong(me2[i]);
					Student stu=ss.get(mes);
					set.add(stu);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("无成员了");
		}
		hrs.setStudent(set);

		boolean bln=ss.alerthrs(hrs);
		
		System.out.println(bln);
		
		return hrslist();
	}
	//
	public String hrstoadd(){
		//应该顺便得有宿舍单元 跟宿舍单元是 多对一的关系
		List EleList=ss.selelelist();	
		ToRequest("elelist", EleList);
		
		//查询所有在读的学生 以来添加宿舍人员的目的 
		Long intenstatus=(long)1;
		List stulist=ss.listbystatus(intenstatus);
		ToRequest("stulist", stulist);
		
		//查出宿舍
		List hrslist=ss.selhrslist();
		ToRequest("hrslist", hrslist);
		
		return "hrsadd";
	}
	//添加 宿舍 
	public String hrsadd(){
		//获取成员
		String[] me=request.getParameterValues("member");
		Set set = new HashSet();//班级成员集合
		
		try {
			if(request.getParameter("member")!=null){
				for(int i=0;i<me.length;i++){
					Long mes=Long.parseLong(me[i]);
					Student stu=ss.get(mes);
					set.add(stu);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("无成员了");
		}
		hrs.setStudent(set);
		boolean bln=ss.addhrs(hrs);
		
		System.out.println(bln);
		
		return hrslist();
		
	}
	//单元开始
	
	private Elements ele;
	
	private int eid;
	private String eename;
	
	//添加
	public String eleadd(){
		boolean bln=ss.addele(ele);
		System.out.println(bln);
		
		return "elelist";
	}
	//修改和删除在同一个
	public String elelist(){
		if(eid!=0&&!eename.equals("")&&eename!=null){
			//修改
			ele=ss.getele((long)eid);
			Elements eles=new Elements();
			eles.setHourse(ele.getHourse());
			eles.setEid((long)eid);
			eles.setEname(eename);
			boolean bln=ss.alertele(eles);
			
			System.out.println(bln);
		}
		list=ss.selelelist();
		
		return "success";
	}

	public String eledel(){//删除

		//有级联的关系的表 修改也要有附属关系
		//先查出来
		Elements eles=ss.getele(ele.getEid());
		
		eles.setHourse(null);// 一定为null 不然会删除掉hourse
		
		boolean bln=ss.delele(eles);
		
		System.out.println(bln);
		
		//去jsp页面
		return "elelist";
	}
	//单元结束
	
	//宿舍表操作结束
	
	
	//班级表操作开始
	
	private Classes classes;
	
	private Long classid;
	
	public String clslist(){
		
		list= ss.clslist();
		System.out.println(list.size());
		
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		return "clslist";
	}
	public String clstoadd(){
		//员工list
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "clsadd";
	}
	public String clsadd(){
		boolean bln=ss.addcls(classes);
		System.out.println(bln);
		return clslist();
	}
	public String clstoalert(){
		classes=ss.getcls(classid);
		
		//员工list
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		//查询所有在读的学生 以来添加班级人员的目的 
		Long intenstatus=(long)1;
		List stulist=ss.listbystatus(intenstatus);
		
		//处理classes中已有的班级成员
		Set yystudent=classes.getStudent();
		Iterator it = yystudent.iterator();

		for(;it.hasNext();){
		     Student s = (Student)it.next();
		     for(int j=0;j<stulist.size();j++){
				Map stu=(Map)stulist.get(j);
				Object o=stu.get("INTENID");
				/***********	Object转String必须 toString	*************/
				String ID=o.toString();
				Long Id=Long.parseLong(ID);
				Long id=s.getIntenid();
				if(Id.equals(id)){//MD Long类型竟然是equals对比
					stulist.remove(j);
				}
			}
		}

		ToRequest("stulist", stulist);
		
		//班级
		List clslist=ss.clslist();
		ToRequest("clslist", clslist);
		
		return "clsalert";
	}
	public String clsalert(){
		//获取班级成员 在添加到宿舍hrs里 来达到删除班级成员的目的
		
		String[] me=request.getParameterValues("member");
		String[] me2=request.getParameterValues("member2");
		
		Set set = new HashSet();//班级成员集合
		
		try {
			if(request.getParameter("member")!=null){
				for(int i=0;i<me.length;i++){
					Long mes=Long.parseLong(me[i]);
					Student stu=ss.get(mes);
					set.add(stu);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("无成员了");
		}
		try {
			if(request.getParameter("member2")!=null){
				for(int i=0;i<me2.length;i++){
					Long mes=Long.parseLong(me2[i]);
					Student stu=ss.get(mes);
					set.add(stu);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("无成员了");
		}
		//设置
		classes.setStudent(set);
		
		boolean bln=ss.alertcls(classes);
		System.out.println(bln);
		return clslist();
	}
	public String clsdel(){

		//有级联的关系的表 修改也要有附属关系
		//先查出来
		Classes classes=ss.getcls(classid);
		classes.setStudent(null);// 一定为null 不然会删除掉学生
		
		boolean bln=ss.delcls(classes);
		
		System.out.println(bln);
		
		return clslist();
	}
	
	//班级表操作结束
	
	//成绩表操作开始
	
	private Long couid;
	private Long scoid;

	private Score sco;
	
	private Float score[];
	private Long stuid[];
	private int size;//判断有没有值
	
	
	//筛选
	public String scosx(){
		
		//查询班级 vo 对象
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程 vo 对象
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查找第一个课程和第一个班级的数据 优化的话可以查找第一个成绩

		//算了 直接查询所有在读学生的成绩 懒得墨迹
		list=ss.scolist();
		size=list.size();
		return "scolist";
	}
	public String scosx2(){//学生列表
		/************************************/
		//登入查看自己班上的成绩
		Student stu=ss.get(studentlogin.getIntenid());
		
		//查询班级 vo 对象
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程 vo 对象
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查找第一个课程和第一个班级的数据 优化的话可以查找第一个成绩

		//课程用1 java 获取 默认java
		if(couid==null){
			Course courses=(Course) coslist.get(0);
			list=ss.scolist(stu.getClassid(),courses.getCouid());
		}else{
			list=ss.scolist(stu.getClassid(), couid);
		}
		size=list.size();
		
		//获取班级
		Classes classes=ss.getcls(stu.getClassid());
		ToRequest("classes", classes);
		
		return "scostulist";
	}
	public String scolist(){
		//classid couid 自动获取
		System.out.println("scolist");
		list=ss.scolist(classid,couid);
		size=list.size();
		
		System.out.println(list.size());
		
		//获取班级 课程对象
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//用来修改sconame
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "scolist";
	}
	public String scolist2(){//学生的
		//couid 自动获取
		//classid 用学生来查
		/************************************/
		Student stu=ss.get(studentlogin.getIntenid());
		classid=stu.getClassid();
		
		list=ss.scolist(classid,couid);
		size=list.size();
		
		System.out.println(list.size());
		
		//获取班级 课程对象
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//用来修改sconame
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "scostulist";
	}
	public String scotoadd(){
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		size=0;
		sizes=0;

		return "scoadd";
	}
	//通过班级获取所有的学生信息
	public String scotoadd2(){
		
		List scolist=ss.scolist(classid, couid);
		//当scolist不为空就表示有值了
		size=scolist.size();
		sizes=1;
		//获取班级 课程对象
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//用来修改sconame
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//获取这个班级的所有学生而已
		List classstudent=ss.scoaddclassstudentlist(classid);
		ToRequest("cslist", classstudent);

		//自动保存
		System.out.println(classid+" "+couid);
		return "scoadd";
	}
	//添加成绩
	public String scoadd(){
		//添加 用循环添加
		for(int i=0;i<score.length;i++){
			Score scores=new Score();
			scores.setSconame(couid);
			scores.setScore(score[i]);
			scores.setStuid(stuid[i]);
			boolean bln=ss.addsco(scores);
			System.out.print(bln);
		}

		//返回scolist.jsp
		list=ss.scolist(classid, couid);
		size=list.size();
		
		//获取班级 课程对象
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//用来修改sconame
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "scolist";
	}

	//修改
	public String scoalert(){
		//classid couid 自动获取 返回列表
		System.out.println(sco.getScoid()+" "+sco.getStuid()+" "+sco.getScore()+" "+sco.getSconame());

		//修改
		boolean bln=ss.alertsco(sco);
		System.out.println(bln);
		
		//第一次返回全部成绩页面
		System.out.println(classid+" "+couid);
		if(classid==null&&couid==null){
			list=ss.scolist();
			size=list.size();
			System.out.println("1");
		}else{
			list=ss.scolist(classid, couid);
			size=list.size();
			System.out.println("2");
			//获取班级 课程对象
			Classes classes=ss.getcls(classid);
			Course course=ic.getcourse(couid);
			ToRequest("classes", classes);
			ToRequest("course", course);
		}
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//用来修改sconame
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "scolist";
	}
	//成绩表操作结束
	
	//谈心记录表操作开始 
	private String intenname;
	private Long ename;//谈心记录是用班主任id保存的
	private Says says;
	private Long sayid;
	private Long state;//状态
	//筛选
	public String sayssx(){//员工 显示自己的谈心记录
		//登录id
		/****************************************************/
		//查询班主任 就是员工
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//最新的谈心记录
		List sayslist=ss.sayslist(0,10);
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		state=(long)1;
		
		//班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		return "sayslist";
	}
	public String sayssx2(){//查询学生的谈心记录
		//查询员工的好
		List teaches=ie.emplist();
		ToRequest("teaches", teaches);
		
		//查询这个学生的谈心记录
		/****************************************************/
		List sayslist=ss.saysstulist(studentlogin.getIntenid());
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		
		return "saysstulist";
	}
	//列表
	public String sayslist(){
		//根据班主任和就读状态来
		List sayslist=ss.sayslist(ename,state);
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		
		//查询班主任 就是员工
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//获取班主任对象
		Emp emp=ss.getemp(ename);
		ToRequest("emp", emp);

		//班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "sayslist";
	}
	
	public String saystoadd(){
		
		//根据班级来筛选学生
		List student=ss.saystoaddstulist(classid);
		ToRequest("student", student);
		
		return "saysadd";
	}
	public String saysadd(){
// 		System.out.println(says.getSayface()+" "+says.getSayempid()+" "+says.getSayscon()+" "+says.getSayspro()+" "+says.getSayback());
//		Date date=new Date();
//		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//		String datea=df.format(date);
//		says.setSaydate(datea);
		//还是设置为他的班主任的好
		Student stus=ss.get(says.getSayface());
		Classes classes=ss.getcls(stus.getClassid());
		Emp emps=ss.getemp(classes.getEmpteaches());
		says.setSayempid(emps.getEid());
		boolean bln=ss.addsays(says);
		
		System.out.println(bln);

		//state根据学生的状态来定是毕业还是在读
		Student stu=ss.get(says.getSayface());
		state=stu.getIntenstatus();
		List sayslist=ss.sayslist(says.getSayempid(),state);//当只有班主任时
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		//查询班主任 就是员工
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//获取班主任对象
		Emp emp=ss.getemp(says.getSayempid());
		ToRequest("emp", emp);
		
		//班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "sayslist";
	}
	public String saystoalert(){
		System.out.println(sayid);
		
		//查询
		says=ss.getsays(sayid);
		System.out.println(says.getSayface());
		//查询班主任 就是员工
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//找出这个班的学生
		Student stus=ss.get(says.getSayface());
		System.out.println(stus.getClassid());
		List student=ss.listbyclassid(stus.getClassid());
		ToRequest("student", student);
		
		//班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "saysalert";
	}
	public String saysalert(){
		//根据id查询 保存反馈
		Says say=ss.getsays(says.getSayid());
		//查询
		says.setSayback(say.getSayback());
		System.out.println(says.getSaydate());
		boolean bln=ss.alertsays(says);
		System.out.println(bln);
		
		//state根据学生的状态来定是毕业还是在读
		Student stu=ss.get(says.getSayface());
		state=stu.getIntenstatus();
		List sayslist=ss.sayslist(says.getSayempid(),state);//当只有班主任时
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		//查询班主任 就是员工
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//获取班主任对象
		Emp emp=ss.getemp(says.getSayempid());
		ToRequest("emp", emp);
		
		//班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "sayslist";
	}
	//谈心记录的删除
	public String saysdel(){
		Says say=ss.getsays(sayid);
		boolean bln=ss.delsays(say);
		
		System.out.println(bln);
		
		says=say;
		
		//state根据学生的状态来定是毕业还是在读
		Student stu=ss.get(says.getSayface());
		state=stu.getIntenstatus();
		List sayslist=ss.sayslist(says.getSayempid(),state);//当只有班主任时
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		//查询班主任 就是员工
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//获取班主任对象
		Emp emp=ss.getemp(says.getSayempid());
		ToRequest("emp", emp);
		
		//班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "sayslist";
	}
	//学生去反馈
	public String saystofankui(){
		//根据sayid查询
		says=ss.getsays(sayid);
		
		return "saysfankui";
	}
	//学生反馈
	public String saysfankui(){
		Says says2=ss.getsays(says.getSayid());
		
		says2.setSayback(says.getSayback());
		
		boolean bln=ss.alertsays(says2);
		System.out.println(bln);
		
		return sayssx2();
	}
	//学生修改反馈
	public String saystoalert2(){
		//根据sayid查询
		says=ss.getsays(sayid);
		
		return "saysstualert";
	}
	//学生修改
	public String saysstualert(){
		Says says2=ss.getsays(says.getSayid());
		
		says2.setSayback(says.getSayback());
		
		boolean bln=ss.alertsays(says2);
		System.out.println(bln);
		
		return sayssx2();
	}
	//谈心记录表操作结束
	
	//学生毕业总结开始
	
	private Summary smy;
	private Long sids;
	
	public String smysx(){
		//所有班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		//所有的学生总结
		list=ss.summarylist();
		
		return "smylist";
	}
	public String smysx2(){//学生的只查询自己的
		//登录id
		/****************************************************/
		//自己的学生总结
		list=ss.summarystulist(studentlogin.getIntenid());
		
		return "smystulist";
	}
	public String smylist(){
		//通过classid获取总结数
		
		list=ss.summarylist(classid);
		
		//班级
		Classes classes=ss.getcls(classid);
		String classname=classes.getClassname();
		classid=classes.getClassid();
		ToRequest("classname", classname+"的");

		//所有班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "smylist";
	}
	public String smytoadd(){
		System.out.println(classid);
		//根据classid查询出已经毕业的班级和没有记录的学生
		List student=ss.summarytoaddstulist(classid);
		ToRequest("student", student);
		
		return "smyadd";
	}
	public String smyadd(){
		//老师由登陆的
		smy.setSteaches(emplogin.getEid());
		boolean bln=ss.addsmy(smy);
		System.out.println(bln);
		//所有班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		//所有的学生总结
		list=ss.summarylist();
		
		return "smylist";
	}
	public String smytoalert(){
		//查询
		smy=ss.getsmy(sids);
		
		//根据classid查询 这个班的学生
		List student=ss.listbyclassid(classid);
		ToRequest("student", student);
		//老师
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		return "smyalert";
	}
	public String smyalert(){
		//查询
		boolean bln=ss.alertsmy(smy);
		System.out.println(bln);
		
		list=ss.summarylist(classid);
		
		//班级
		Classes classes=ss.getcls(classid);
		String classname=classes.getClassname();
		classid=classes.getClassid();
		ToRequest("classname", classname+"的");

		//所有班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "smylist";
	}
	
	//学生毕业总结结束
	
	//学生就业开始
	private Job job;
	private Long jobid;
	
	public String jobsx(){
		//查询班级 找出班主任
		List clslist=ss.selclslist();
		
		//查询第一个班级的班主任所记录的就业情况
		if(clslist.size()!=0){
			Map map=(Map)clslist.get(0);
			Object o=map.get("CLASSID");
			String classids=o.toString();
			classid=Long.parseLong(classids);
			List joblist=ss.joblist(classid);
			
			ToRequest("joblist", joblist);
		}
		List selclslist=ss.selclslist();
		ToRequest("clslist", selclslist);
		return "joblist";
	}
	public String joblist(){
		//只通过查询班级来查询
		List joblist=ss.joblist(classid);
		
		ToRequest("joblist", joblist);
		
		//查询班级 
		List selclslist=ss.selclslist();
		ToRequest("clslist", selclslist);
		return "joblist";
	}
	public String jobtoadd(){
		//根据classid查询
		List student=ss.jobtoaddstulist(classid);
		ToRequest("student", student);
		//班主任老师
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		return "jobadd";
	}
	public String jobadd(){
		//设置登陆的老师
		job.setJobtea(emplogin.getEid());
		boolean bln=ss.addjob(job);

		//通过 记录人来查找joblist
		List joblist=ss.joblistbytea(job.getJobtea());
		
	
		ToRequest("joblist", joblist);
		//班主任老师
		List teaches=ss.empteacheslist();
		
		ToRequest("teaches", teaches);
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		return "joblist";
	}
	public String jobtoalert(){
		///根据classid查询出已经毕业的班级和没有记录的学生
		List student=ss.listbyclassid(classid);
		ToRequest("student", student);
		
		//班主任老师
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		job=ss.getjob(jobid);
		
		return "jobalert";
	}
	public String jobalert(){
		//System.out.println(job.getJobid()+" "+job.getJobaddr()+" "+job.getJobdate()+" "+job.getJobdesc()+" "+job.getJobname()+" "+job.getJobnum()+" "+job.getJobsalary()+" "+job.getJobtea()+" "+job.getJobstu());
		boolean bln=ss.alertjob(job);
		
		//通过 记录人来查找joblist
		List joblist=ss.joblistbytea(job.getJobtea());
		ToRequest("joblist", joblist);
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		return "joblist";
	}
	public String jobdel(){
		job=ss.getjob(jobid);
		boolean bln=ss.deljob(job);
		//通过 记录人来查找joblist
		List joblist=ss.joblistbytea(job.getJobtea());
		ToRequest("joblist", joblist);
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		return "joblist";
	}
	//学生就业结束
	
	//项目答辩开始
	private Course course;
	private Projectf prj;
	private Long did;
	private String time;
	private long zdls;
	private long teaches;
	private int sizes;//用来控制录入这个按钮
	private int addtolist;//用来控制添加完有头
	
	public String prjsx(){
		
		addtolist=0;//添加完返回list
		
		//查询班级 vo 对象
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程 vo 对象
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查询员工 找出指导老师 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		//查找第一个课程和第一个班级的数据 优化的话可以查找第一个成绩

		System.out.println("进来了项目成绩筛选");
		//算了 直接查询所有的主表 懒得墨迹
		list=ss.prjlist();//主表
		size=list.size();
		System.out.println(size);
		
		String addtolist2=request.getParameter("addtolist2");
		if(addtolist2!=null&&!addtolist2.equals("")){
			addtolist=Integer.parseInt(addtolist2);
		}
	
		return "prjlist";
	}
	public String prjsx2(){//学生查询
		//登录id
		/****************************************************/
		Student stu=ss.get(studentlogin.getIntenid());
		
		//获取班级 课程对象
		Classes classes=ss.getcls(stu.getClassid());
		ToRequest("classes", classes);
		
		//查询班级 vo 对象
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程 vo 对象
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查询员工 找出指导老师 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);

		//算了找出这个学生的班级科目 默认1
		if(couid==null){
			Course courses=(Course) coslist.get(0);
			list=ss.prjlist(stu.getClassid(),courses.getCouid());//主表
		}else{
			list=ss.prjlist(stu.getClassid(),couid);//主表
		}
		size=list.size();
		System.out.println(size);
		
		return "prjstulist";
	}
	//查看更多 同学的成绩
	public String dfslist(){
		list=ss.dfslist(classid, couid);
		//单独找出班级 项目名称 指导老师 演示时间 评委老师
		System.out.println(list.size());

		try {
			Map map=(Map)list.get(0);
//			ToRequest("classid", map.get("PCLASSID"));
			ToRequest("pname", map.get("PNAME"));
			ToRequest("pteacher", map.get("PTEACHER"));
			ToRequest("pdate", map.get("PDATE"));
			ToRequest("pteachers", map.get("PTEACHERS"));
			//组长
			ToRequest("head", map.get("DHEAD"));
			
			//查询员工 找出指导老师 
			List emplist=ie.emplist();
			ToRequest("emplist", emplist);
			
			//学生
			List student=ss.list();
			ToRequest("student", student);
			
			//查询班级 vo 对象
			List clslist=ss.selclslist();
			ToRequest("clslist", clslist);
			
			//查询课程 vo 对象
			List coslist=ss.selcos();
			ToRequest("coslist", coslist);
			
			//获取班级 课程对象
			Classes classes=ss.getcls(classid);
			Course course=ic.getcourse(couid);
			ToRequest("classes", classes);
			ToRequest("course", course);
		} catch (RuntimeException e) {
			//有错 没值
			return "error";
		}
		
		return "prjdfs";
	}
	public String prjlist(){
		addtolist=0;
		System.out.println(classid+" "+couid);
	
		list=ss.prjlist(classid,couid);
		size=list.size();
		System.out.println(list.size());
		
		//获取班级 课程对象
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//查询班级 vo 对象
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程 vo 对象
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查询员工 找出指导老师 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		String addtolist2=request.getParameter("addtolist2");
		if(addtolist2!=null&&!addtolist2.equals("")){
			addtolist=Integer.parseInt(addtolist2);
		}
		
		return "prjlist";
	}
	public String prjlist2(){//学生
		//登录id
		/****************************************************/
		Student stu=ss.get(studentlogin.getIntenid());
		classid=stu.getClassid();
		System.out.println(classid+" "+couid);
	
		list=ss.prjlist(classid,couid);
		size=list.size();
		System.out.println(list.size());
		
		//获取班级 课程对象
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//查询班级 vo 对象
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程 vo 对象
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查询员工 找出指导老师 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "prjstulist";
	}
	
	public String prjtoadd(){
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查询员工 找出评委老师
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		size=0;//用来判断有没有成绩 而这是第一次进 所以还需一个参数使用
		
		sizes=0;//用来判断按钮的使用
		
		return "prjadd";
	}
	public String prjtoadd2(){
		//看看是否存在了项目答辩信息
		List dfslist=ss.prjlist(classid, couid);
		//当scolist不为空就表示有值了
		size=dfslist.size();
		sizes=1;
		
		//查找出所有学生 根据班级
		List classstudent=ss.scoaddclassstudentlist(classid);
		ToRequest("cslist", classstudent);
		
		//查询班级
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查询员工 找出指导老师 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		//保存选中的班级 课程 指导老师 评委老师 时间
		//获取班级 课程对象
		Classes classes=ss.getcls(classid);
		course=ic.getcourse(couid);
		Emp teacherr=ie.getemp(classes.getEmpteach());//指导老师 是由班级对应的
		Emp teachers=ie.getemp(teaches);//评委老师
		ToRequest("classes", classes);
//		ToRequest("course", course);
		ToRequest("teacherr", teacherr);
		ToRequest("teachers", teachers);
		
		return "prjadd";
	}
	//修改父表和子表
	public String prjalert(){
		//classid couid 自动获取 返回列表
		
		//当第一次的时候通过 pid获取信息来获取要修改的信息设置就行

		//修改
		boolean bln=ss.alertprj(prj);
		System.out.println(bln);
		
		//第一次修改返回所有
		if(classid==null&&couid==null){
			list=ss.prjlist();
			size=list.size();
			
		}else{//有classid和couid 就返回这个查询
			list=ss.prjlist(classid, couid);
			size=list.size();
			System.out.println("2");
			//获取班级 课程对象
			Classes classes=ss.getcls(classid);
			Course course=ic.getcourse(couid);
			ToRequest("classes", classes);
			ToRequest("course", course);
		}
		//查询课程
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//用来修改sconame
		
		//查询班级
		clslist=ss.selclslist();
		ToRequest("clslist", clslist);

		//查询员工 找出指导老师 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "prjlist";
	}
	
	//字表分数 因为是select 都得用string[]获取
	private Defenses dfs;
	private Long[] dmembers;
	private String[] dfunctions;
	private String[] ddifficultys;
	private String[] dbeanutifuls;
	private String[] ddemos;
	private String[] dexpresss;
	private String[] danswers;
	private String[] dscores;
	private String[] dremarks;
	
	public String prjadd(){
		//父表添加
		boolean bln=ss.addprj(prj);
		//添加分数
		
		try {
			for(int i=0;i<dmembers.length;i++){
				float dfunction=Float.parseFloat(dfunctions[i]);
				float ddifficulty=Float.parseFloat(ddifficultys[i]);
				float dbeanutiful=Float.parseFloat(dbeanutifuls[i]);
				float ddemo=Float.parseFloat(ddemos[i]);
				float dexpress=Float.parseFloat(dexpresss[i]);
				float danswer=Float.parseFloat(danswers[i]);
				float dscore=Float.parseFloat(dscores[i]);
				Defenses defes=new Defenses();
				defes.setPid(prj.getPid());
				defes.setDmember(dmembers[i]);
				defes.setDfunction(dfunction);
				defes.setDdifficulty(ddifficulty);
				defes.setDbeanutiful(dbeanutiful);
				defes.setDdemo(ddemo);
				defes.setDexpress(dexpress);
				defes.setDanswer(danswer);
				defes.setDscore(dscore);
				defes.setDremark(dremarks[i]);
				boolean blns=ss.adddfs(defes);
				System.out.println(blns);
			}
		} catch (RuntimeException e) {
			System.out.println("不够值");
		}
				
		//添加完后
		list=ss.prjlist(classid,couid);
		size=list.size();
		System.out.println(list.size());
		
		//获取班级 课程对象
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//查询班级 vo 对象
		clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//查询课程 vo 对象
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//查询员工 找出指导老师 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		addtolist=1;//添加完返回list
		
		return "prjlist";
	}
	//项目答辩结束
	
	//意见反馈开始
	
	private Sback sbk;
	private Long sbackid;
	private Reply rly;
	private Long rid;
	
	//学生的
	public String sbksx2(){
		//根据登录的id查看自己的反馈
		list =ss.sbkstulist(studentlogin.getIntenid());
		//回复列表 判断有没有回复列表
		List rlylist=ss.replylist();
		ToRequest("rlylist", rlylist);
		//查看的老师
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		return "sbkstulist";
	}
	public String sbklist(){
		/************并且根据登录老师id来查*************/
		Long statu=(long)0;
		list = ss.sbklist(statu,emplogin.getEid());//未处理
		
		return "sbklist";
	}
	public String sbklist2(){
		Long statu=(long)1;
		list = ss.sbklist2(statu,emplogin.getEid());//已回复
		
		return "sbklist2";
	}
	public String sbklist3(){
		Long statu=(long)2;
		list = ss.sbklist(statu,emplogin.getEid());//不显示
		
		return "sbklist3";
	}
	public String sbktoadd(){
		//查找所有的老师
		list=ie.emplist();
		
		return "sbkadd";
	}
	public String sbkadd(){
		//状态默认为0 位处理
		Long statu=(long)0;
		sbk.setStatu(statu);
		//从登陆中获取学生id
		sbk.setStdid(studentlogin.getIntenid());
		boolean bln=ss.addsbk(sbk);

		System.out.println(bln);
		//返回学生意见
		return sbksx2();
	}
	//去回复
	public String toreply(){
		//为了保存sbackid
		//保存sbackid
		
		return "sbkreply";
	}
	//修改为回复 并且跳转到已回复页面list2
	public String sbkreply(){
		rly.setReid(emplogin.getEid());
		boolean bln=ss.addrly(rly);
		System.out.println(bln);
		
		Sback sback=ss.getsbk(rly.getSbackid());
		Long statu=(long)1;
		sback.setStatu(statu);
		boolean bln2=ss.updsbkstatu(sback);
		System.out.println(bln2);
		
		return sbklist2();
	}
	//修改为不显示
	public String nodisplay(){
		Sback sback=ss.getsbk(sbackid);
		Long statu=(long)2;
		sback.setStatu(statu);
		boolean bln=ss.updsbkstatu(sback);
		System.out.println(bln);
		
		return sbklist();
	}
	//修改为显示
	public String display(){
		Sback sback=ss.getsbk(sbackid);
		Long statu=(long)0;
		sback.setStatu(statu);
		boolean bln=ss.updsbkstatu(sback);
		System.out.println(bln);
		
		return sbklist();
	}
	//还差一个修改
	public String sbkreplytoalert(){
		System.out.println("进来了去修改"+rid);
		rly=ss.getrly(rid);
		return "sbkreplyalert";
	}
	public String sbkreplyalert(){
		System.out.println("进来了修改");
		boolean bln=ss.updrly(rly);
		System.out.println(bln);
		return sbklist2();
	}
	//删除
	public String delsback(){
		//实质为修改sempid为null
		Sback sbacks=ss.getsbk(sbackid);
		sbacks.setSempid(null);
		boolean bln=ss.updsbkstatu(sbacks);
		System.out.println(bln);
		return sbklist3();
	}
	//意见反馈结束
	
	//请假管理开始
	
	private Long lid;
	private Long lteashr;
	private Long lstushr;
	private Long lstate;
	private Leave lev;
	
	//老师的
	public String levsx(){
	
		//老师显示自己审核的所有的请假列表 并且状态为不同意2和审核中1 根据审核状态 来分就行了
		list = ss.levlist(emplogin.getEid());
		
		//查找员工
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "levlist";
	}
	//去学生列表 查看自己的请假列表
	public String levsx2(){
		//学生显示自己的请假列表
		list=ss.levstulist(studentlogin.getIntenid());//先第一个 登录号了查询登录的
		//获取对象 intenid 用来添加
		Student student=ss.get(studentlogin.getIntenid());
		ToRequest("student", student);
		
		return "levstulist";
	}
	//老师同意
	public String levstatus(){
		
		//先获取lev对象
		Leave lev=ss.getlev(lid);
		//设置对象 但是如果没有下一审核人时就修改状态为同意 至于审核人就让他为0吧
		if(lteashr==0){
			System.out.println("呵呵");
			lev.setLstate(lstate);
		}

		lev.setLshr(lteashr);//有下一审核人 只修改审核人

		boolean bln=ss.updlev(lev);
		System.out.println(bln);

		return levsx();
	}
	//老师不同意
	public String levstatus3(){
		//先获取lev对象
		Leave lev=ss.getlev(lid);
		//修改状态为不同意 
		lev.setLstate(lstate);

		boolean bln=ss.updlev(lev);
		System.out.println(bln);

		return levsx();
	}
	//学生提交
	public String levstatus2(){
		//先获取lev对象
		Leave lev=ss.getlev(lid);
		//设置对象 但是如果没有下一审核人时就修改状态为同意

		lev.setLstate(lstate);
		lev.setLshr(lstushr);
		
		boolean bln=ss.updlev(lev);
		System.out.println(bln);
		
		return "levsx2";
	}
	
	//去添加 自动获取下一个审核人班主任
	public String levtoadd(){
		System.out.println(intenid+"intenid");
		//获取自己的id 找到班主任
		Student student=ss.get(intenid);
		ToRequest("student", student);
	
		try {
			Classes classes = ss.getcls(student.getClassid());
			ToRequest("classes", classes);
			Emp emp=ie.getemp(classes.getEmpteaches());
			ToRequest("emp", emp);
			
		} catch (RuntimeException e) {
			System.out.println("学生信息不完善 我在1643行");
		}
		
		return "levadd";
	}
	public String levadd(){
		System.out.println(lev.getLshr());
		lev.setLstate((long)0);//未提交
		
		boolean bln=ss.addlev(lev);
		System.out.println(bln);
		//System.out.println(lev.getLstarttime()-lev.getLendtime());
		return "levsx2";
	}
	//删除
	public String levdel(){
		Leave lev=ss.getlev(lid);
		
		boolean bln=ss.dellev(lev);
		System.out.println(bln);
		
		return "levsx2";
	}
	//去修改
	public String levtoalert(){
		lev=ss.getlev(lid);
		
		//审核人
		try {
			Student student=ss.get(lev.getLstuid());
			ToRequest("student", student);
			
			Classes classes=ss.getcls(student.getClassid());
			
			Emp emp=ss.getemp(classes.getEmpteaches());
			ToRequest("emp", emp);
		} catch (RuntimeException e) {
			System.out.println("学生信息不完善 我在1680行");
		}

		return "levalert";
	}
	public String levalert(){

		boolean bln=ss.updlev(lev);
		System.out.println(bln);
		
		return "levsx2";
	}
	
	
	//请假管理结束
	
	//备用电脑开始
	
	private Long aid;
	private Long astate;
	private Long ateashr;
	private Long astushr;
	private Application apl;
	//老师的
	public String aplsx(){
	
		//老师显示自己审核的所有的请假列表 并且状态为不同意2和审核中1 根据审核状态 来分就行了
		list = ss.apllist(emplogin.getEid());
		
		//查找员工
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "apllist";
	}
	//去学生列表 查看自己的请假列表
	public String aplsx2(){
		//学生显示自己的请假列表
		list=ss.aplstulist(studentlogin.getIntenid());//先第一个 登录号了查询登录的
		
		//获取对象 intenid
		Student student=ss.get(studentlogin.getIntenid());
		ToRequest("student", student);
		
		return "aplstulist";
	}
	//老师同意
	public String aplstatus(){
		//获取对象
		System.out.println(aid);
		System.out.println(ateashr);
		System.out.println(astate);
		
		//先获取lev对象
		Application apl=ss.getapl(aid);
		//设置对象 但是如果没有下一审核人时就修改状态为同意
		if(ateashr==0){
			apl.setAstate(astate);
		}
		apl.setAshr(ateashr);//有下一审核人 只修改审核人

		boolean bln=ss.updapl(apl);
		System.out.println(bln);

		return aplsx();
	}
	//老师不同意
	public String aplstatus3(){
		//获取对象
		System.out.println(aid);
		System.out.println(astate);
		
		//先获取lev对象
		Application apl=ss.getapl(aid);
		//修改状态为不同意
		apl.setAstate(astate);

		boolean bln=ss.updapl(apl);
		System.out.println(bln);
		
		return aplsx();
	}
	//学生提交
	public String aplstatus2(){
		//获取对象
		System.out.println(aid);
		System.out.println(astushr);
		System.out.println(astate);
		//先获取lev对象
		Application apl=ss.getapl(aid);
		//设置对象 但是如果没有下一审核人时就修改状态为同意

		apl.setAstate(astate);
		apl.setAshr(astushr);
		
		boolean bln=ss.updapl(apl);
		System.out.println(bln);
		
		return "aplsx2";
	}
	//去添加 自动获取下一个审核人班主任
	public String apltoadd(){
		System.out.println(intenid+"intenid");
		//获取自己的id 找到班主任
		Student student=ss.get(intenid);
		ToRequest("student", student);
		
		Classes classes=ss.getcls(student.getClassid());
		ToRequest("classes", classes);
		
		Emp emp=ie.getemp(classes.getEmpteaches());
		System.out.println(emp.getEname()+"ename");
		ToRequest("emp", emp);
		
		return "apladd";
	}
	public String apladd(){
		System.out.println(apl.getAshr());//审核人
		apl.setAstate((long)0);//未提交
		
		boolean bln=ss.addapl(apl);
		System.out.println(bln);
		
		return "aplsx2";
	}
	//删除
	public String apldel(){
		Application apl=ss.getapl(aid);
		
		boolean bln=ss.delapl(apl);
		System.out.println(bln);
		
		return "aplsx2";
	}
	//去修改
	public String apltoalert(){
		apl=ss.getapl(aid);
		
		//审核人
		Student student=ss.get(apl.getAstuid());
		ToRequest("student", student);
		
		Classes classes=ss.getcls(student.getClassid());
		
		Emp emp=ss.getemp(classes.getEmpteaches());
		ToRequest("emp", emp);

		return "aplalert";
	}
	public String aplalert(){

		boolean bln=ss.updapl(apl);
		System.out.println(bln);
		
		return "aplsx2";
	}
	//备用电脑结束
	
	//生成报表
	public String scbb(){
		System.out.println(classid+" "+couid);

		list=ss.dfslist(classid, couid);
		//单独找出班级 项目名称 指导老师 演示时间 评委老师
		System.out.println(list.size());

		Map map=(Map)list.get(0);
		ToRequest("classid", map.get("PCLASSID"));
		ToRequest("pname", map.get("PNAME"));
		ToRequest("pteacher", map.get("PTEACHER"));
		ToRequest("pdate", map.get("PDATE"));
		ToRequest("pteachers", map.get("PTEACHERS"));
		
		//组长
		ToRequest("head", map.get("DHEAD"));
		
		//查询员工 找出指导老师 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		//学生
		List student=ss.list();
		ToRequest("student", student);
		
		//查询班级 vo 对象
		List clslist=ss.clslist();
		ToRequest("clslist", clslist);
		
		//查询课程 vo 对象
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		Object pteacher=map.get("PTEACHER");//指导老师
		Object pdate=map.get("PDATE");//演示时间
		Object pteachers=map.get("PTEACHERS");//评委老师
		
		//班级
		String classname="";
		for(int i=0;i<clslist.size();i++){
			Classes classes=(Classes)clslist.get(i);
			if(classid.equals(classes.getClassid())){
				classname=classes.getClassname();
			}
		}
		//科目
		String couname="";
		for(int i=0;i<coslist.size();i++){
			Course course=(Course)coslist.get(i);
			if(couid.equals(course.getCouid())){
				couname=course.getCouname();
			}
		}
		//指导老师
		String zdls="";
		String pteacherss=pteacher.toString();
		Long zdlsid=Long.parseLong(pteacherss);
		for(int i=0;i<emplist.size();i++){
			Emp emp=(Emp)emplist.get(i);
			if(zdlsid.equals(emp.getEid())){
				zdls=emp.getEname();
			}
		}
		//评委老师
		String pwls="";
		String pteachersss=pteachers.toString();
		Long pwlsid=Long.parseLong(pteachersss);
		for(int i=0;i<emplist.size();i++){
			Emp emp=(Emp)emplist.get(i);
			if(pwlsid.equals(emp.getEid())){
				pwls=emp.getEname();
			}
		}
		//开始打印报表
		//创建HSSFWorkbook对象(excel的文档对象)
	    HSSFWorkbook wb = new HSSFWorkbook();

		//建立新的sheet对象（excel的表单）
		HSSFSheet sheet=wb.createSheet("成绩表");
		
		HSSFCellStyle cellStyle = wb.createCellStyle();  
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
		HSSFFont font = wb.createFont();    
		font.setFontName("黑体");    
		font.setFontHeightInPoints((short) 16);//设置字体大小
		cellStyle.setFont(font);//选择需要用到的字体格式  
		
		//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1=sheet.createRow(0);
		//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell=row1.createCell(0);
		//设置单元格内容
		cell.setCellValue("电子自动化系-宏图软件教育项目答辩评分表");
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
		cell.setCellStyle(cellStyle);
		//在sheet里创建第二行
		HSSFRow row2=sheet.createRow(1); 
		HSSFCell cell2=row2.createCell(0);
		//设置单元格内容
		cell2.setCellValue("班级:"+classname+"        项目名称:"+couname+"          指导老师:"+zdls+"         演示时间:"+pdate+"        评委老师:"+pwls);
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,8));
		HSSFCellStyle cellStyle2 = wb.createCellStyle();  
		cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
		HSSFFont font2 = wb.createFont();    
		font2.setFontName("仿宋");    
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示    
		font2.setFontHeightInPoints((short) 12);    
		cellStyle2.setFont(font2);//选择需要用到的字体格式  
		
		cell2.setCellStyle(cellStyle2);
       //创建单元格并设置单元格内容
		//样式3
		HSSFCellStyle cellStyle3 = wb.createCellStyle();  
		cellStyle3.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
		HSSFFont font3 = wb.createFont();    
		font3.setFontName("黑体");    
		font3.setFontHeightInPoints((short) 12);    
		cellStyle3.setFont(font3);//选择需要用到的字体格式  
		
		HSSFRow row3=sheet.createRow(2);
		HSSFCell row30=row3.createCell(0);    
		row30.setCellValue("成员");
		row30.setCellStyle(cellStyle3);
		HSSFCell row31=row3.createCell(1);    
		row31.setCellValue("功能完善(50)");
		row31.setCellStyle(cellStyle3);
		HSSFCell row32=row3.createCell(2);    
		row32.setCellValue("技术难度(10)");
		row32.setCellStyle(cellStyle3);
		HSSFCell row33=row3.createCell(3);    
		row33.setCellValue("界面美观(10)");
		row33.setCellStyle(cellStyle3);
		HSSFCell row34=row3.createCell(4);    
		row34.setCellValue("演示方法(10)");
		row34.setCellStyle(cellStyle3);
		HSSFCell row35=row3.createCell(5);    
		row35.setCellValue("语言表达(10)");
		row35.setCellStyle(cellStyle3);
		HSSFCell row36=row3.createCell(6);    
		row36.setCellValue("回答问题(10)");
		row36.setCellStyle(cellStyle3);
		HSSFCell row37=row3.createCell(7);    
		row37.setCellValue("总分(100)");
		row37.setCellStyle(cellStyle3);
		HSSFCell row38=row3.createCell(8);    
		row38.setCellValue("备注");
		row38.setCellStyle(cellStyle3);
		//样式4
		HSSFCellStyle cellStyle4 = wb.createCellStyle();  
		cellStyle4.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中 
		HSSFFont font4 = wb.createFont();   
		font4.setFontName("黑体");   
		cellStyle4.setFont(font4);//选择需要用到的字体格式  
		
		for(int i=0;i<list.size();i++){
			Map maps=(Map)list.get(i);
			int j=i+3;
			//4
			HSSFRow row4=sheet.createRow(j);
			HSSFCell row40=row4.createCell(0);    
			row40.setCellValue(maps.get("INTENNAME").toString());
			row40.setCellStyle(cellStyle4);
			HSSFCell row41=row4.createCell(1);    
			row41.setCellValue(maps.get("DFUNCTION").toString());
			row41.setCellStyle(cellStyle4);
			HSSFCell row42=row4.createCell(2);    
			row42.setCellValue(maps.get("DDIFFICULTY").toString());
			row42.setCellStyle(cellStyle4);
			HSSFCell row43=row4.createCell(3);    
			row43.setCellValue(maps.get("DBEANUTIFUL").toString());
			row43.setCellStyle(cellStyle4);
			HSSFCell row44=row4.createCell(4);    
			row44.setCellValue(maps.get("DDEMO").toString());
			row44.setCellStyle(cellStyle4);
			HSSFCell row45=row4.createCell(5);    
			row45.setCellValue(maps.get("DEXPRESS").toString());
			row45.setCellStyle(cellStyle4);
			HSSFCell row46=row4.createCell(6);    
			row46.setCellValue(maps.get("DANSWER").toString());
			row46.setCellStyle(cellStyle4);
			HSSFCell row47=row4.createCell(7);    
			row47.setCellValue(maps.get("DSCORE").toString());
			row47.setCellStyle(cellStyle4);
			HSSFCell row48=row4.createCell(8);    
			//1.用来设置备注的宽度 (指定哪个单元格)
			sheet.setColumnWidth(row48.getColumnIndex(),180 * 50);
	        try {
	        	row48.setCellValue(maps.get("DREMARK").toString());
			} catch (RuntimeException e) {
				row48.setCellValue("");
			}
			row48.setCellStyle(cellStyle4);
	        //在sheet里创建第4行
		}

		//设置所有列的宽
		sheet.setDefaultColumnWidth(13);
		//输出Excel文件
		try {
			//可以设置名称 C:\Users\Administrator\Desktop 桌面
			FileOutputStream output=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\"+classname+"的"+couname+"答辩成绩.xls");
			wb.write(output);
			output.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("回去啊");
		return dfslist();
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Long getIntenid() {
		return intenid;
	}
	public void setIntenid(Long intenid) {
		this.intenid = intenid;
	}
	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	public String[] getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}
	public String[] getFilesContentType() {
		return filesContentType;
	}
	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}
	public Long getHourid() {
		return hourid;
	}
	public void setHourid(Long hourid) {
		this.hourid = hourid;
	}
	public Hourse getHrs() {
		return hrs;
	}
	public void setHrs(Hourse hrs) {
		this.hrs = hrs;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Long getClassid() {
		return classid;
	}
	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public Elements getEle() {
		return ele;
	}
	public void setEle(Elements ele) {
		this.ele = ele;
	}
	public Long getCouid() {
		return couid;
	}
	public void setCouid(Long couid) {
		this.couid = couid;
	}
	
	public Long getScoid() {
		return scoid;
	}
	public void setScoid(Long scoid) {
		this.scoid = scoid;
	}
	public Score getSco() {
		return sco;
	}
	public void setSco(Score sco) {
		this.sco = sco;
	}

	public Float[] getScore() {
		return score;
	}
	public void setScore(Float[] score) {
		this.score = score;
	}
	public Long[] getStuid() {
		return stuid;
	}
	public void setStuid(Long[] stuid) {
		this.stuid = stuid;
	}
	public String getIntenname() {
		return intenname;
	}
	public void setIntenname(String intenname) {
		this.intenname = intenname;
	}
	public Long getEname() {
		return ename;
	}
	public void setEname(Long ename) {
		this.ename = ename;
	}
	public Says getSays() {
		return says;
	}
	public void setSays(Says says) {
		this.says = says;
	}
	public Long getSayid() {
		return sayid;
	}
	public void setSayid(Long sayid) {
		this.sayid = sayid;
	}
	
	public Summary getSmy() {
		return smy;
	}
	public void setSmy(Summary smy) {
		this.smy = smy;
	}
	public Long getSids() {
		return sids;
	}
	public void setSids(Long sids) {
		this.sids = sids;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Long getJobid() {
		return jobid;
	}
	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Projectf getPrj() {
		return prj;
	}
	public void setPrj(Projectf prj) {
		this.prj = prj;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public Sback getSbk() {
		return sbk;
	}
	public void setSbk(Sback sbk) {
		this.sbk = sbk;
	}
	public Long getSbackid() {
		return sbackid;
	}
	public void setSbackid(Long sbackid) {
		this.sbackid = sbackid;
	}
	public Reply getRly() {
		return rly;
	}
	public void setRly(Reply rly) {
		this.rly = rly;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public long getTeaches() {
		return teaches;
	}
	public void setTeaches(long teaches) {
		this.teaches = teaches;
	}
	public long getZdls() {
		return zdls;
	}
	public void setZdls(long zdls) {
		this.zdls = zdls;
	}
	public Defenses getDfs() {
		return dfs;
	}
	public void setDfs(Defenses dfs) {
		this.dfs = dfs;
	}

	public Long[] getDmembers() {
		return dmembers;
	}
	public void setDmembers(Long[] dmembers) {
		this.dmembers = dmembers;
	}

	public String[] getDfunctions() {
		return dfunctions;
	}
	public void setDfunctions(String[] dfunctions) {
		this.dfunctions = dfunctions;
	}
	public String[] getDdifficultys() {
		return ddifficultys;
	}
	public void setDdifficultys(String[] ddifficultys) {
		this.ddifficultys = ddifficultys;
	}
	public String[] getDbeanutifuls() {
		return dbeanutifuls;
	}
	public void setDbeanutifuls(String[] dbeanutifuls) {
		this.dbeanutifuls = dbeanutifuls;
	}
	public String[] getDdemos() {
		return ddemos;
	}
	public void setDdemos(String[] ddemos) {
		this.ddemos = ddemos;
	}
	public String[] getDexpresss() {
		return dexpresss;
	}
	public void setDexpresss(String[] dexpresss) {
		this.dexpresss = dexpresss;
	}
	public String[] getDanswers() {
		return danswers;
	}
	public void setDanswers(String[] danswers) {
		this.danswers = danswers;
	}
	public String[] getDscores() {
		return dscores;
	}
	public void setDscores(String[] dscores) {
		this.dscores = dscores;
	}
	public String[] getDremarks() {
		return dremarks;
	}
	public void setDremarks(String[] dremarks) {
		this.dremarks = dremarks;
	}
	public Long getLid() {
		return lid;
	}
	public void setLid(Long lid) {
		this.lid = lid;
	}

	public Long getLstate() {
		return lstate;
	}
	public void setLstate(Long lstate) {
		this.lstate = lstate;
	}
	public Leave getLev() {
		return lev;
	}
	public void setLev(Leave lev) {
		this.lev = lev;
	}
	public Long getLstushr() {
		return lstushr;
	}
	public void setLstushr(Long lstushr) {
		this.lstushr = lstushr;
	}
	public Long getLteashr() {
		return lteashr;
	}
	public void setLteashr(Long lteashr) {
		this.lteashr = lteashr;
	}
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public Long getAstate() {
		return astate;
	}
	public void setAstate(Long astate) {
		this.astate = astate;
	}
	public Long getAteashr() {
		return ateashr;
	}
	public void setAteashr(Long ateashr) {
		this.ateashr = ateashr;
	}
	public Long getAstushr() {
		return astushr;
	}
	public void setAstushr(Long astushr) {
		this.astushr = astushr;
	}
	public Application getApl() {
		return apl;
	}
	public void setApl(Application apl) {
		this.apl = apl;
	}
	public Long[] getClassids() {
		return classids;
	}
	public void setClassids(Long[] classids) {
		this.classids = classids;
	}
	public Long[] getHourids() {
		return hourids;
	}
	public void setHourids(Long[] hourids) {
		this.hourids = hourids;
	}
	public String[] getIntennames() {
		return intennames;
	}
	public void setIntennames(String[] intennames) {
		this.intennames = intennames;
	}
	public String[] getIntensexs() {
		return intensexs;
	}
	public void setIntensexs(String[] intensexs) {
		this.intensexs = intensexs;
	}
	public String[] getIntenages() {
		return intenages;
	}
	public void setIntenages(String[] intenages) {
		this.intenages = intenages;
	}
	public String[] getIntenbirs() {
		return intenbirs;
	}
	public void setIntenbirs(String[] intenbirs) {
		this.intenbirs = intenbirs;
	}
	public String[] getIntenfats() {
		return intenfats;
	}
	public void setIntenfats(String[] intenfats) {
		this.intenfats = intenfats;
	}
	public String[] getIntentels() {
		return intentels;
	}
	public void setIntentels(String[] intentels) {
		this.intentels = intentels;
	}
	public String[] getIntenfatels() {
		return intenfatels;
	}
	public void setIntenfatels(String[] intenfatels) {
		this.intenfatels = intenfatels;
	}
	public String[] getIntenaddrs() {
		return intenaddrs;
	}
	public void setIntenaddrs(String[] intenaddrs) {
		this.intenaddrs = intenaddrs;
	}

	public String[] getIntentimes() {
		return intentimes;
	}
	public void setIntentimes(String[] intentimes) {
		this.intentimes = intentimes;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEename() {
		return eename;
	}
	public void setEename(String eename) {
		this.eename = eename;
	}
	public List getClslist() {
		return clslist;
	}
	public void setClslist(List clslist) {
		this.clslist = clslist;
	}
	public List getHrslist() {
		return hrslist;
	}
	public void setHrslist(List hrslist) {
		this.hrslist = hrslist;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	public int getSizes() {
		return sizes;
	}
	public void setSizes(int sizes) {
		this.sizes = sizes;
	}
	public Student getStudentlogin() {
		return studentlogin;
	}
	public void setStudentlogin(Student studentlogin) {
		this.studentlogin = studentlogin;
	}
	public Emp getEmplogin() {
		return emplogin;
	}
	public void setEmplogin(Emp emplogin) {
		this.emplogin = emplogin;
	}
	public int getAddtolist() {
		return addtolist;
	}
	public void setAddtolist(int addtolist) {
		this.addtolist = addtolist;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

}
