package com.ht.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.ht.common.BaseAction;
import com.ht.service.ICourseService;
import com.ht.service.IEmpService;
import com.ht.vo.Dept;
import com.ht.vo.Emp;
import com.ht.vo2.Course;
import com.ht.vo2.Courseplan;
import com.ht.vo2.Discuss;
import com.ht.vo2.Dutys;
import com.ht.vo2.Fed;
import com.ht.vo2.Feedback;
import com.ht.vo2.Saveyear;
import com.ht.vo5.Classes;
import com.ht.vo5.Student;

public class CourseAction extends BaseAction {
	IEmpService ie=(IEmpService)getService("eService");
	ICourseService ic = (ICourseService) getService("couService");
	private Course course;
	private Courseplan courseplan;
	private Discuss discuss;
	private Fed fed;
	private Feedback feedback;
	private long ff;
	private Dutys dutys;
	
	private long loginkind;
	private String username;
	private long password;
	private long classid;
	private long stuid;
	private long empid;
	private long year;
	private long month;
	private long teaid;
	private long stuclassid;
	private Saveyear saveyear;
	private List lists = new ArrayList();
	/**
	 * 登录
	 */
	public String login() {
		System.out.println(loginkind + "用户名  " + username + "密码：" + password);
		if (loginkind == 0) {// 教工
			// 查询员工
			Emp teacher = ic.findlogin(password);
			if (teacher!=null && teacher.getEname().equals(username)) {// 有此人
				ToSession("teacher", teacher);
				List list=ie.emprootlist(password);
				ToSession("rootlist", list);
				ToSession("login", loginkind);
				return "tologin";
			}else{
				return "backlogin";
			}
		} else if (loginkind == 1) {// 学生
			// 查询学生
			Student stu = ic.findlogin1(password);
			if (stu!=null && stu.getIntenname().equals(username)) {// 有此人
				ToSession("stu", stu);
				
				List list=ie.emprootlist(password);
				ToSession("rootlist", list);
				
				ToSession("login", loginkind);
				return "tologin";
			}else{
				return "backlogin";
			}
		}
		return null;
	}

	/**
	 * 课程管理
	 */
	// 课程管理列表显示
	private List list;
	private int couid;
	private String couname;
	public String list() {
		System.out.println(couid+" "+couname);
		//如果couid或couname有值则为修改
		if(couname!=null&&!couname.equals("")&&couid!=0){
			Course cour=new Course();
			cour.setCouid((long)couid);
			cour.setCouname(couname);
			ic.updcourse(cour);
		}
		System.out.println("课程列表");
		list = ic.listcourse();
			
		return "success";
	}

	// 课程添加
	public String couadd() {
	
		ic.addcourse(course);
		return "tolist";
	}

	// 去修改
	public String toupdcou() {
	
		Course cour = ic.toupdcou(course.getCouid());
		ToRequest("course", cour);
		return "toupdcou";
	}

	// 修改
	public String updcou() {
		ic.updcourse(course);
		return "tolist";
	}

	// 课程删除
	public String delcourse(){		
		ic.delcourse(course);
		return "tolist";
	}

	/**
	 * 课程进度管理
	 */
	// 查询显示关联表字段
	public String listcourse() {
		// 查询课程
		List list = ic.listcourse();
		ToRequest("list", list);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// 查询班级
//		List listclass = ic.listclass();
		System.out.println("当前登录教员id为："+empid);
		List listclass=ic.findclassbyid(empid);
		ToRequest("listclass", listclass);
		return "tocpadd";
	}
	
	Emp emp=(Emp)fromSession("teacher");
	
	
	// 课程进度列表显示
	public String cplist() {
		List list = ic.listcourseplan(emp.getEid());
		ToRequest("list", list);
		// 查询课程
		List listcourse = ic.listcourse();
		ToRequest("listcourse", listcourse);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// 查询班级
		List listclass = ic.listclass();
		ToRequest("listclass", listclass);
		return "tocplist";
	}

	// 课程进度列表查看（领导）
	public String cplist1() {
		List list = ic.listcourseplan();
		ToRequest("list", list);
		// 查询课程
		List listcourse = ic.listcourse();
		ToRequest("listcourse", listcourse);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// 查询班级
		List listclass = ic.listclass();
		ToRequest("listclass", listclass);
		return "tocplist1";
	}
	
	// 课程进度添加
	/**
	 * @return
	 */
	public String cpadd() {
		courseplan.setCpcontents(0+"");
		courseplan.setEmpid(courseplan.getEmpid());
		ic.addcourseplan(courseplan);
		return cplist();
	}

	// 课程进度 去修改
	public String toupdcp() {
		Courseplan cp = ic.toupdcp(courseplan.getCpid());
		ToRequest("courseplan", cp);
		// 查询课程
		List list = ic.listcourse();
		ToRequest("list", list);
		// 查询员工
//		List listemp = ic.listemp();
//		ToRequest("listemp", listemp);
		
		// 查询班级
		List listclass=ic.findclassbyid(emp.getEid());
		ToRequest("listclass", listclass);
		return "toupdcp";
	}

	// 修改
	public String updcp() {
		ic.updcp(courseplan);
		return cplist();
	}

	// 课程进度删除
	public String delcourseplan() {
		ic.delcourseplan(courseplan);
		return cplist();
	}

	/**
	 * 研讨会管理
	 */
	// 查询显示关联表字段
	public String listdept() {
		
		// 查询部门（到场人员）
		List listdept = ic.listdept();
		ToRequest("listdept", listdept);
		
		// 查询部门下的员工（到场人员）
//		List listdeptemp = ic.deptemp();
//		ToRequest("listdeptemp", listdeptemp);

		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		
		return "todisadd";
	}

	// 研讨会列表显示
	public String dislist() {
		List list = ic.listdis();
		ToRequest("list", list);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "todislist";
	}
	
	// 研讨会列表查看（领导）
	public String dislist1() {
		System.out.println("研讨会领导查看。。。。。。。。。");
		List list = ic.listdis();
		ToRequest("list", list);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "todislist1";
	}

	// 研讨会添加
	public String disadd() {
		System.out.println("添加进来了。。。。。。。。。。。");
		System.out.println("到场人员为："+discuss.getEmpid());
		ic.adddis(discuss);
		return dislist();
	}

	// 研讨会 去修改
	public String toupddis() {
		Discuss dis = ic.toupddis(discuss.getDisid());
		ToRequest("discuss", dis);
		
		// 查询部门下的员工
//		List listdeptemp = ic.deptemp();
//		ToRequest("listdeptemp", listdeptemp);
		
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// 查询部门（到场人员）
		List listdept = ic.listdept();
		ToRequest("listdept", listdept);
		
		return "toupddis";
	}

	// 研讨会修改
	public String upddis() {
		ic.upddis(discuss);
		return dislist();
	}

	// 研讨会删除
	public String deldiscuss() {
		ic.deldis(discuss);
		return dislist();
	}

	// 研讨会详情查看
	public String viewdis() {
		Discuss dis = ic.toupddis(discuss.getDisid());
		ToRequest("discuss", dis);
		// 查询部门下的员工
		List listdeptemp = ic.deptemp();
		ToRequest("listdeptemp", listdeptemp);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "viewdis";
	}
	
	// 研讨会详情查看(领导)
	public String viewdis1() {
		Discuss dis = ic.toupddis(discuss.getDisid());
		ToRequest("discuss", dis);
		// 查询部门下的员工
		List listdeptemp = ic.deptemp();
		ToRequest("listdeptemp", listdeptemp);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "viewdis1";
	}

	/**
	 * 教员反馈管理
	 */
	// 教员反馈主表
	// 查询显示关联表字段
	public String listfed() {
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		//查询年份
//		List years=ic.listyear();
//		ToRequest("years", years);
		return "tofedadd";
	}

	// 教员反馈列表显示
	public String fedlist() {

		List list = ic.listfed();
		ToRequest("list", list); 
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		//查询班级
//		System.out.println(fed.getClassid());
		List cla=ic.listclass();
		ToRequest("class", cla);
		
		return "tofedlist";
	}
	
	public String frm(){
		lists=ic.findclassbyid(empid);
		System.out.println(lists.size());
		return "success";
	}
	
	// 教员反馈添加
	public String fedadd() {
		fed.setNum(Long.parseLong(2 + ""));
		fed.setFedstate(Long.parseLong(0 + ""));
//		saveyear.setYearname(fed.getFedtime());
//		ic.addyear(saveyear);
		ic.addfed(fed);
		return fedlist();
	}

	// 教员反馈删除
	public String delfed() {
		ic.delfed(fed);
		return fedlist();
	}

	// 教员反馈 去修改
	public String toupdfed() {
		Fed ff = ic.toupdfed(fed.getFedid());
		ToRequest("fed", ff);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		//根据教师id查询该教员对象
		Emp emps=ic.findemp(fed.getEmpid());
		ToRequest("emps", emps);
		//根据id查询班级
		Classes clas=ic.findclass(fed.getClassid());
		ToRequest("clas", clas);
		//根据教师id查询其所教的班级
		List listclass=ic.findclassbyid(fed.getEmpid());
		ToRequest("listclass", listclass);
		return "toupdfed";
	}

	// 教员反馈 修改
	public String updfed() {
		ic.updfed(fed);
		return fedlist();
	}

	// 学生反馈入口
	public String stufedlist() {
		Student stu=(Student)fromSession("stu");
		
		// 查询状态为反馈中的数据
		List list = ic.liststufed(stuclassid);
		
		List flist=new ArrayList();
		List findfed=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Map map=(Map)list.get(i);
			if(map.get("FEDID")!=null){
				List feedlist=ic.isfeed(Long.parseLong(map.get("FEDID").toString()), stu.getIntenid());
				
				for (int j = 0; j < feedlist.size(); j++) {
					Map maps=(Map)feedlist.get(j);
					System.out.println(maps.get("FDID")+"dddddd");
					if(maps.get("FDID")!=null){
						List findstufed=ic.findstufed(Long.parseLong(maps.get("FDID").toString()));
						findfed.addAll(findstufed);
					}
				}
				flist.addAll(feedlist);
				System.out.println(findfed.size()+"11111111111");
			}
		}
		if(list.size()!=flist.size()){
			System.out.println(list.removeAll(findfed)+"ssssssssssssssss");
			list.remove(findfed);
			ToRequest("list", list);
		}
	
		
		// 查询员工
		List listemp = ic.listemp();
		
		ToRequest("listemp", listemp);
		return "tostufedlist";
	}

	// 反馈表
	public String feed() {
		//根据当前登录用户的班级id 查找其所在的班级
		Classes cs=ic.findclass(classid);
		ToRequest("cs", cs);
		// 将emp对象传到feed页面，以便自动显示教员名称
		Emp emp = ic.findemp(fed.getEmpid());
		ToRequest("emp", emp);
		// 将fed对象传到feed页面
		System.out.println("fedid:" + ff);
		Fed ffs = ic.findfed(ff);
		ToRequest("fed", ffs);
		
		ToRequest("fdid", ff);
		return "tofeed";
	}

	private String feedid;
	// 提交后保存反馈
	public String feedsave() {
		ic.updnum(fed.getFedid());
		Date date=new Date();
		feedback.setTimes(date);
		feedback.setStuid(stuid);
		feedback.setCid(classid);
		feedback.setEmpid(empid);
		feedback.setFeedyear(year);
		feedback.setFeedmonth(month);
		feedback.setFdid(Long.parseLong(feedid));
		feedback.setSum(feedback.getS1()+feedback.getS2()+feedback.getS3()+feedback.getS4()+feedback.getS5()+feedback.getS6()+feedback.getS7()+feedback.getS8());
		ic.savefeed(feedback);
		return stufedlist();
	}
	
/**
 * 上级领导查看反馈
 */
	//查看学生已提交的反馈报表（校长）
	public String viewfeed(){ 
		// 查询fed表
		List listfed = ic.listfed();
		ToRequest("listfed", listfed); 
		// 查询feedback表
		List listfeed = ic.liststu();
		ToRequest("listfeed", listfeed);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// 查询班级
		List listclass = ic.listclass();
		ToRequest("listclass", listclass);
		//查询学生
		List liststudent=ic.liststudent();
		ToRequest("liststudent", liststudent);
		return "viewfeed";
	}
	//查看学生已提交的反馈详情（校长）
	public String viewfeedback2(){
		//根据班级id查找feedback
		System.out.println(".........................................进来了............................................");
		System.out.println("////"+fed.getFedtime());
		System.out.println("////"+fed.getFedmonth());
		System.out.println("////"+fed.getEmpid());
		System.out.println("////"+fed.getClassid());
		 List listfeed=ic.findfeed1(fed.getFedtime(),fed.getFedmonth(),fed.getEmpid(),fed.getClassid());
		 ToRequest("listfeed", listfeed);
			// 查询员工
			List listemp = ic.listemp();
			ToRequest("emp", listemp);
			// 查询班级
			List listclass = ic.listclass();
			ToRequest("class", listclass);
			//查询学生
			List liststudent=ic.liststudent();
			ToRequest("student", liststudent);
		return "viewfeed4";
	}
	//查看学生反馈（校长）
	public String viewfeedback(){
		//根据id查找feedback对象
		 feedback=ic.findfeed(feedback.getFid());
		 ToRequest("feedback", feedback);
		// 根据id查询员工
			Emp listemp = ic.findemp(empid);
			ToRequest("emp", listemp);
			// 根据id查询班级
			Classes listclass = ic.findclass(classid);
			ToRequest("class", listclass);
			//根据id查询学生
			Student liststudent=ic.findstudent(stuid);
			ToRequest("student", liststudent);
		return "viewfeed1";
	}
	
	/**
	 * 教员查看反馈
	 */
	//查看学生已提交的反馈报表（教员）
	public String viewfeed2(){ 
		// 查询fed表
		List listfed = ic.listfed1(teaid);
		ToRequest("listfed", listfed); 
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// 查询班级
		List listclass = ic.listclass();
		ToRequest("listclass", listclass);
		return "viewfeed5";
	}
	
	//查看学生已提交的反馈（教员）
	public String viewfeed1(){
		// 查询fed表
//		List listfed = ic.listfed();
//		ToRequest("listfed", listfed);
		//
//		System.out.println("当前登录用户ID:"+teaid);
//		List list=ic.findteacher(teaid);
//		System.out.println("大小大小:"+list.size());
//		ToRequest("listfeed", list);
		// 查询feedback表
//		List listfeed = ic.liststu();
//		ToRequest("listfeed", listfeed);
//		// 查询员工
//		List listemp = ic.listemp();
//		ToRequest("listemp", listemp);
//		// 查询班级
//		List listclass = ic.listclass();
//		ToRequest("listclass", listclass);
//		//查询学生
//		List liststudent=ic.liststudent();
//		ToRequest("liststudent", liststudent);
//		return "viewfeed2";
		
		//根据班级id查找feedback
		System.out.println(".........................................进来了............................................");
		System.out.println("////"+fed.getFedtime());
		System.out.println("////"+fed.getFedmonth());
		System.out.println("////"+fed.getEmpid());
		System.out.println("////"+fed.getClassid());
		 List listfeed=ic.findfeed1(fed.getFedtime(),fed.getFedmonth(),teaid,fed.getClassid());
		 ToRequest("listfeed", listfeed);
			// 查询班级
			List listclass = ic.listclass();
			ToRequest("listclass", listclass);
		return "viewfeed2";
	}
	
	//查看学生反馈（老师）
	public String viewfeedback1(){
		//根据id查找feedback对象
		 feedback=ic.findfeed(feedback.getFid());
		 ToRequest("feedback", feedback);
		// 根据id查询员工
			Emp listemp = ic.findemp(empid);
			ToRequest("emp", listemp);
			// 根据id查询班级
			Classes listclass = ic.findclass(classid);
			ToRequest("class", listclass);
			//根据id查询学生
			Student liststudent=ic.findstudent(stuid);
			ToRequest("student", liststudent);
		return "viewfeed3";
	}
	


	/**
	 * 值班管理
	 * 
	 * @return
	 */
	// 查询显示关联表字段
	public String listempduty() {
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "todutysadd";
	}

	// 值班列表显示
	public String dutyslist() {
		List list = ic.listduty();
		ToRequest("list", list);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "todutyslist";
	}

	public String mydutyslist() {
		
		List list = ic.mydutylist(emp.getEid());
		ToRequest("list", list);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "tomydutys";
	}

	// 值班添加
	public String dutysadd() {
		ic.addduty(dutys);
		return mydutyslist();
	}

	// 值班 去修改
	public String toupddutys() {
		Dutys ds = ic.toupdduty(dutys.getDsid());
		ToRequest("dutys", ds);
		// 查询员工
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "toupddutys";
	}

	// 值班修改
	public String upddutys() {
		ic.updduty(dutys);
		return dutyslist();
	}

	// 值班删除
	public String deldutys() {
		ic.delduty(dutys);
		return dutyslist();
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Courseplan getCourseplan() {
		return courseplan;
	}

	public void setCourseplan(Courseplan courseplan) {
		this.courseplan = courseplan;
	}

	public Discuss getDiscuss() {
		return discuss;
	}

	public void setDiscuss(Discuss discuss) {
		this.discuss = discuss;
	}

	public Fed getFed() {
		return fed;
	}

	public void setFed(Fed fed) {
		this.fed = fed;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public long getFf() {
		return ff;
	}

	public void setFf(long ff) {
		this.ff = ff;
	}

	public Dutys getDutys() {
		return dutys;
	}

	public void setDutys(Dutys dutys) {
		this.dutys = dutys;
	}

	public long getLoginkind() {
		return loginkind;
	}

	public void setLoginkind(long loginkind) {
		this.loginkind = loginkind;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getPassword() {
		return password;
	}

	public void setPassword(long password) {
		this.password = password;
	}

	public long getClassid() {
		return classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public long getStuid() {
		return stuid;
	}

	public void setStuid(long stuid) {
		this.stuid = stuid;
	}

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public long getMonth() {
		return month;
	}

	public void setMonth(long month) {
		this.month = month;
	}

	public long getTeaid() {
		return teaid;
	}

	public void setTeaid(long teaid) {
		this.teaid = teaid;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}


	public int getCouid() {
		return couid;
	}

	public void setCouid(int couid) {
		this.couid = couid;
	}

	public String getCouname() {
		return couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	public List getLists() {
		return lists;
	}

	public void setLists(List lists) {
		this.lists = lists;
	}

	public long getStuclassid() {
		return stuclassid;
	}

	public void setStuclassid(long stuclassid) {
		this.stuclassid = stuclassid;
	}

	public String getFeedid() {
		return feedid;
	}

	public void setFeedid(String feedid) {
		this.feedid = feedid;
	}

	public Saveyear getSaveyear() {
		return saveyear;
	}

	public void setSaveyear(Saveyear saveyear) {
		this.saveyear = saveyear;
	}



}
