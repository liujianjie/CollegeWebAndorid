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
	 * ��¼
	 */
	public String login() {
		System.out.println(loginkind + "�û���  " + username + "���룺" + password);
		if (loginkind == 0) {// �̹�
			// ��ѯԱ��
			Emp teacher = ic.findlogin(password);
			if (teacher!=null && teacher.getEname().equals(username)) {// �д���
				ToSession("teacher", teacher);
				List list=ie.emprootlist(password);
				ToSession("rootlist", list);
				ToSession("login", loginkind);
				return "tologin";
			}else{
				return "backlogin";
			}
		} else if (loginkind == 1) {// ѧ��
			// ��ѯѧ��
			Student stu = ic.findlogin1(password);
			if (stu!=null && stu.getIntenname().equals(username)) {// �д���
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
	 * �γ̹���
	 */
	// �γ̹����б���ʾ
	private List list;
	private int couid;
	private String couname;
	public String list() {
		System.out.println(couid+" "+couname);
		//���couid��couname��ֵ��Ϊ�޸�
		if(couname!=null&&!couname.equals("")&&couid!=0){
			Course cour=new Course();
			cour.setCouid((long)couid);
			cour.setCouname(couname);
			ic.updcourse(cour);
		}
		System.out.println("�γ��б�");
		list = ic.listcourse();
			
		return "success";
	}

	// �γ����
	public String couadd() {
	
		ic.addcourse(course);
		return "tolist";
	}

	// ȥ�޸�
	public String toupdcou() {
	
		Course cour = ic.toupdcou(course.getCouid());
		ToRequest("course", cour);
		return "toupdcou";
	}

	// �޸�
	public String updcou() {
		ic.updcourse(course);
		return "tolist";
	}

	// �γ�ɾ��
	public String delcourse(){		
		ic.delcourse(course);
		return "tolist";
	}

	/**
	 * �γ̽��ȹ���
	 */
	// ��ѯ��ʾ�������ֶ�
	public String listcourse() {
		// ��ѯ�γ�
		List list = ic.listcourse();
		ToRequest("list", list);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// ��ѯ�༶
//		List listclass = ic.listclass();
		System.out.println("��ǰ��¼��ԱidΪ��"+empid);
		List listclass=ic.findclassbyid(empid);
		ToRequest("listclass", listclass);
		return "tocpadd";
	}
	
	Emp emp=(Emp)fromSession("teacher");
	
	
	// �γ̽����б���ʾ
	public String cplist() {
		List list = ic.listcourseplan(emp.getEid());
		ToRequest("list", list);
		// ��ѯ�γ�
		List listcourse = ic.listcourse();
		ToRequest("listcourse", listcourse);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// ��ѯ�༶
		List listclass = ic.listclass();
		ToRequest("listclass", listclass);
		return "tocplist";
	}

	// �γ̽����б�鿴���쵼��
	public String cplist1() {
		List list = ic.listcourseplan();
		ToRequest("list", list);
		// ��ѯ�γ�
		List listcourse = ic.listcourse();
		ToRequest("listcourse", listcourse);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// ��ѯ�༶
		List listclass = ic.listclass();
		ToRequest("listclass", listclass);
		return "tocplist1";
	}
	
	// �γ̽������
	/**
	 * @return
	 */
	public String cpadd() {
		courseplan.setCpcontents(0+"");
		courseplan.setEmpid(courseplan.getEmpid());
		ic.addcourseplan(courseplan);
		return cplist();
	}

	// �γ̽��� ȥ�޸�
	public String toupdcp() {
		Courseplan cp = ic.toupdcp(courseplan.getCpid());
		ToRequest("courseplan", cp);
		// ��ѯ�γ�
		List list = ic.listcourse();
		ToRequest("list", list);
		// ��ѯԱ��
//		List listemp = ic.listemp();
//		ToRequest("listemp", listemp);
		
		// ��ѯ�༶
		List listclass=ic.findclassbyid(emp.getEid());
		ToRequest("listclass", listclass);
		return "toupdcp";
	}

	// �޸�
	public String updcp() {
		ic.updcp(courseplan);
		return cplist();
	}

	// �γ̽���ɾ��
	public String delcourseplan() {
		ic.delcourseplan(courseplan);
		return cplist();
	}

	/**
	 * ���ֻ����
	 */
	// ��ѯ��ʾ�������ֶ�
	public String listdept() {
		
		// ��ѯ���ţ�������Ա��
		List listdept = ic.listdept();
		ToRequest("listdept", listdept);
		
		// ��ѯ�����µ�Ա����������Ա��
//		List listdeptemp = ic.deptemp();
//		ToRequest("listdeptemp", listdeptemp);

		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		
		return "todisadd";
	}

	// ���ֻ��б���ʾ
	public String dislist() {
		List list = ic.listdis();
		ToRequest("list", list);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "todislist";
	}
	
	// ���ֻ��б�鿴���쵼��
	public String dislist1() {
		System.out.println("���ֻ��쵼�鿴������������������");
		List list = ic.listdis();
		ToRequest("list", list);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "todislist1";
	}

	// ���ֻ����
	public String disadd() {
		System.out.println("��ӽ����ˡ���������������������");
		System.out.println("������ԱΪ��"+discuss.getEmpid());
		ic.adddis(discuss);
		return dislist();
	}

	// ���ֻ� ȥ�޸�
	public String toupddis() {
		Discuss dis = ic.toupddis(discuss.getDisid());
		ToRequest("discuss", dis);
		
		// ��ѯ�����µ�Ա��
//		List listdeptemp = ic.deptemp();
//		ToRequest("listdeptemp", listdeptemp);
		
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// ��ѯ���ţ�������Ա��
		List listdept = ic.listdept();
		ToRequest("listdept", listdept);
		
		return "toupddis";
	}

	// ���ֻ��޸�
	public String upddis() {
		ic.upddis(discuss);
		return dislist();
	}

	// ���ֻ�ɾ��
	public String deldiscuss() {
		ic.deldis(discuss);
		return dislist();
	}

	// ���ֻ�����鿴
	public String viewdis() {
		Discuss dis = ic.toupddis(discuss.getDisid());
		ToRequest("discuss", dis);
		// ��ѯ�����µ�Ա��
		List listdeptemp = ic.deptemp();
		ToRequest("listdeptemp", listdeptemp);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "viewdis";
	}
	
	// ���ֻ�����鿴(�쵼)
	public String viewdis1() {
		Discuss dis = ic.toupddis(discuss.getDisid());
		ToRequest("discuss", dis);
		// ��ѯ�����µ�Ա��
		List listdeptemp = ic.deptemp();
		ToRequest("listdeptemp", listdeptemp);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "viewdis1";
	}

	/**
	 * ��Ա��������
	 */
	// ��Ա��������
	// ��ѯ��ʾ�������ֶ�
	public String listfed() {
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		//��ѯ���
//		List years=ic.listyear();
//		ToRequest("years", years);
		return "tofedadd";
	}

	// ��Ա�����б���ʾ
	public String fedlist() {

		List list = ic.listfed();
		ToRequest("list", list); 
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		//��ѯ�༶
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
	
	// ��Ա�������
	public String fedadd() {
		fed.setNum(Long.parseLong(2 + ""));
		fed.setFedstate(Long.parseLong(0 + ""));
//		saveyear.setYearname(fed.getFedtime());
//		ic.addyear(saveyear);
		ic.addfed(fed);
		return fedlist();
	}

	// ��Ա����ɾ��
	public String delfed() {
		ic.delfed(fed);
		return fedlist();
	}

	// ��Ա���� ȥ�޸�
	public String toupdfed() {
		Fed ff = ic.toupdfed(fed.getFedid());
		ToRequest("fed", ff);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		//���ݽ�ʦid��ѯ�ý�Ա����
		Emp emps=ic.findemp(fed.getEmpid());
		ToRequest("emps", emps);
		//����id��ѯ�༶
		Classes clas=ic.findclass(fed.getClassid());
		ToRequest("clas", clas);
		//���ݽ�ʦid��ѯ�����̵İ༶
		List listclass=ic.findclassbyid(fed.getEmpid());
		ToRequest("listclass", listclass);
		return "toupdfed";
	}

	// ��Ա���� �޸�
	public String updfed() {
		ic.updfed(fed);
		return fedlist();
	}

	// ѧ���������
	public String stufedlist() {
		Student stu=(Student)fromSession("stu");
		
		// ��ѯ״̬Ϊ�����е�����
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
	
		
		// ��ѯԱ��
		List listemp = ic.listemp();
		
		ToRequest("listemp", listemp);
		return "tostufedlist";
	}

	// ������
	public String feed() {
		//���ݵ�ǰ��¼�û��İ༶id ���������ڵİ༶
		Classes cs=ic.findclass(classid);
		ToRequest("cs", cs);
		// ��emp���󴫵�feedҳ�棬�Ա��Զ���ʾ��Ա����
		Emp emp = ic.findemp(fed.getEmpid());
		ToRequest("emp", emp);
		// ��fed���󴫵�feedҳ��
		System.out.println("fedid:" + ff);
		Fed ffs = ic.findfed(ff);
		ToRequest("fed", ffs);
		
		ToRequest("fdid", ff);
		return "tofeed";
	}

	private String feedid;
	// �ύ�󱣴淴��
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
 * �ϼ��쵼�鿴����
 */
	//�鿴ѧ�����ύ�ķ�������У����
	public String viewfeed(){ 
		// ��ѯfed��
		List listfed = ic.listfed();
		ToRequest("listfed", listfed); 
		// ��ѯfeedback��
		List listfeed = ic.liststu();
		ToRequest("listfeed", listfeed);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// ��ѯ�༶
		List listclass = ic.listclass();
		ToRequest("listclass", listclass);
		//��ѯѧ��
		List liststudent=ic.liststudent();
		ToRequest("liststudent", liststudent);
		return "viewfeed";
	}
	//�鿴ѧ�����ύ�ķ������飨У����
	public String viewfeedback2(){
		//���ݰ༶id����feedback
		System.out.println(".........................................������............................................");
		System.out.println("////"+fed.getFedtime());
		System.out.println("////"+fed.getFedmonth());
		System.out.println("////"+fed.getEmpid());
		System.out.println("////"+fed.getClassid());
		 List listfeed=ic.findfeed1(fed.getFedtime(),fed.getFedmonth(),fed.getEmpid(),fed.getClassid());
		 ToRequest("listfeed", listfeed);
			// ��ѯԱ��
			List listemp = ic.listemp();
			ToRequest("emp", listemp);
			// ��ѯ�༶
			List listclass = ic.listclass();
			ToRequest("class", listclass);
			//��ѯѧ��
			List liststudent=ic.liststudent();
			ToRequest("student", liststudent);
		return "viewfeed4";
	}
	//�鿴ѧ��������У����
	public String viewfeedback(){
		//����id����feedback����
		 feedback=ic.findfeed(feedback.getFid());
		 ToRequest("feedback", feedback);
		// ����id��ѯԱ��
			Emp listemp = ic.findemp(empid);
			ToRequest("emp", listemp);
			// ����id��ѯ�༶
			Classes listclass = ic.findclass(classid);
			ToRequest("class", listclass);
			//����id��ѯѧ��
			Student liststudent=ic.findstudent(stuid);
			ToRequest("student", liststudent);
		return "viewfeed1";
	}
	
	/**
	 * ��Ա�鿴����
	 */
	//�鿴ѧ�����ύ�ķ���������Ա��
	public String viewfeed2(){ 
		// ��ѯfed��
		List listfed = ic.listfed1(teaid);
		ToRequest("listfed", listfed); 
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		// ��ѯ�༶
		List listclass = ic.listclass();
		ToRequest("listclass", listclass);
		return "viewfeed5";
	}
	
	//�鿴ѧ�����ύ�ķ�������Ա��
	public String viewfeed1(){
		// ��ѯfed��
//		List listfed = ic.listfed();
//		ToRequest("listfed", listfed);
		//
//		System.out.println("��ǰ��¼�û�ID:"+teaid);
//		List list=ic.findteacher(teaid);
//		System.out.println("��С��С:"+list.size());
//		ToRequest("listfeed", list);
		// ��ѯfeedback��
//		List listfeed = ic.liststu();
//		ToRequest("listfeed", listfeed);
//		// ��ѯԱ��
//		List listemp = ic.listemp();
//		ToRequest("listemp", listemp);
//		// ��ѯ�༶
//		List listclass = ic.listclass();
//		ToRequest("listclass", listclass);
//		//��ѯѧ��
//		List liststudent=ic.liststudent();
//		ToRequest("liststudent", liststudent);
//		return "viewfeed2";
		
		//���ݰ༶id����feedback
		System.out.println(".........................................������............................................");
		System.out.println("////"+fed.getFedtime());
		System.out.println("////"+fed.getFedmonth());
		System.out.println("////"+fed.getEmpid());
		System.out.println("////"+fed.getClassid());
		 List listfeed=ic.findfeed1(fed.getFedtime(),fed.getFedmonth(),teaid,fed.getClassid());
		 ToRequest("listfeed", listfeed);
			// ��ѯ�༶
			List listclass = ic.listclass();
			ToRequest("listclass", listclass);
		return "viewfeed2";
	}
	
	//�鿴ѧ����������ʦ��
	public String viewfeedback1(){
		//����id����feedback����
		 feedback=ic.findfeed(feedback.getFid());
		 ToRequest("feedback", feedback);
		// ����id��ѯԱ��
			Emp listemp = ic.findemp(empid);
			ToRequest("emp", listemp);
			// ����id��ѯ�༶
			Classes listclass = ic.findclass(classid);
			ToRequest("class", listclass);
			//����id��ѯѧ��
			Student liststudent=ic.findstudent(stuid);
			ToRequest("student", liststudent);
		return "viewfeed3";
	}
	


	/**
	 * ֵ�����
	 * 
	 * @return
	 */
	// ��ѯ��ʾ�������ֶ�
	public String listempduty() {
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "todutysadd";
	}

	// ֵ���б���ʾ
	public String dutyslist() {
		List list = ic.listduty();
		ToRequest("list", list);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "todutyslist";
	}

	public String mydutyslist() {
		
		List list = ic.mydutylist(emp.getEid());
		ToRequest("list", list);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "tomydutys";
	}

	// ֵ�����
	public String dutysadd() {
		ic.addduty(dutys);
		return mydutyslist();
	}

	// ֵ�� ȥ�޸�
	public String toupddutys() {
		Dutys ds = ic.toupdduty(dutys.getDsid());
		ToRequest("dutys", ds);
		// ��ѯԱ��
		List listemp = ic.listemp();
		ToRequest("listemp", listemp);
		return "toupddutys";
	}

	// ֵ���޸�
	public String upddutys() {
		ic.updduty(dutys);
		return dutyslist();
	}

	// ֵ��ɾ��
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
