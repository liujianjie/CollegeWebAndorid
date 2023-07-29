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
	
	//�ϴ����ļ�����
	private File[] files;
	
	//�ϴ����ļ�����
	private String[] filesFileName;
	
	//�ϴ����ļ�����	  
	private String[] filesContentType;
	
	//��Ŀ����·��
	private String savePath=ServletActionContext.getRequest().getRealPath("student")+"\\";
	
	public String execute(){
		return null;
	}
	//ѧ����Ĳ�����ʼ
	//����ѧ����Ϣ
	public String listsx(){
		
		//��ѯ�����ڶ�ѧ��
		Long status=(long)1;
		list= ss.listbystatus(status);
		size=list.size();
		
		//��ѯ���еİ༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "stulist";
	}
	//���ݰ༶��ѯ��ѧ��
	public String list(){
		
		//��ѯ����ѧ�� ���ݰ༶
		list= ss.listbyclassid(classid);
		size=list.size();
		
		//��ѯ���еİ༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);

		//��ѯ�༶����
		Classes classes=ss.getcls(classid);
		ToRequest("classes", classes);
		
		return "stulist";
	}
	//����ѧ����������Ϣ
	public String seldan(){
		
		stu=ss.get(intenid);
		
		return "stumore";
	}
	//����ѧ����������Ϣ
	public String seldan2(){
		
		stu=ss.get(intenid);
		
		return "stustumore";
	}
	//����ѧ����������Ϣ ȥ�޸�
	public String toalert(){
		try {
			stu=ss.get(intenid);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//������������ �������а༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		List hrslist=ss.selhrslist();
		ToRequest("hrslist", hrslist);
		
		return "stualert";
	}
	//�޸�ѧ����Ϣ
	public String alert(){
		//�����ļ�
		//���汾�ص�·��
			try {
				for(int i=0;i<filesFileName.length;i++){
					try {
					
						FileOutputStream fos=new FileOutputStream(this.savePath+
								stu.getIntenid()+this.filesFileName[i]);
						//��ȡ�ļ�����i
						FileInputStream fil=new FileInputStream(this.files[i]);
						//ÿ�ζ��� д���Ĵ�С
						byte[] b=new byte[1024];
						int real=fil.read(b);
						int ii=0;
						while(real>0){
							fos.write(b, 0, real);
							
							real=fil.read(b);//ÿ�ζ��� д�� �ļ�����ͻ���ȥ�ⲿ�֣���������1kb1kbд�� ֪�� ���벻����
							
							ii++;
						}
						fos.close();fil.close();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//����img·��Ϊimg + name��·��
					stu.setIntenimg("student/"+stu.getIntenid()+filesFileName[i]);
				}
			} catch (RuntimeException e) {
		}
		/*******************
		 * 
		 * ��Ϊ�м�����ϵ �������Ȳ��������Ϣ���޸� �м��м� ��Ȼ��ѷ����Ĺ�������Ϊ��
		 * 
		 * --------------------------------------------------------------*/
		
		//�޸�
		boolean bln=ss.alert(stu);
		
		stu=ss.get(stu.getIntenid());
		
		ToRequest("stu", stu);

		//��ȥѧ��������Ϣ�Ľ���
		return "stumore";
	}
	//ɾ��ѧ��
	public String del(){
		
		stu=ss.get(intenid);
		
		boolean bln=ss.del(stu);
		//����score������ݾ�����ɾ����
		
		return list();
	}
	
	//��У��¼ �ֱ��� �ɼ�����Ŀ�ɼ���̸�ġ��ܽᡢ��ٴ���
	public String stujl(){
		stu=ss.get(intenid);
		//�ҳ�������
		try {
			Classes classes=ss.getcls(stu.getClassid());
			Emp emp=ss.getemp(classes.getEmpteaches());
			ToRequest("emp", emp);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ɼ�
		List scolist=ss.selscore(intenid);
		int scosize=scolist.size();
		
		//��Ŀ
		List prjlist=ss.selprj(intenid);
		int prjsize=prjlist.size();
		//̸��
		List sayslist=ss.selsays(intenid);
		int sayssize=sayslist.size();
		//��ٴ���
		List levlist=ss.sellev(intenid);
		int levsize=levlist.size();
		
		//�ܽ�
		List smylist=ss.selsmy(intenid);
		int smysize=smylist.size();
		//�γ�
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
		//���ҳ��༶ ���� ȥ���ҳ��
		clslist=ss.selclslist();
		//����
		hrslist=ss.selhrslist();
		
		return "stuadd";
	}
	public String toadd(){
		//���ҳ��༶ ���� ȥ���ҳ��
		clslist=ss.selclslist();
		//����
		hrslist=ss.selhrslist();
		
		return "success";
	}
	//�ֶ�
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
		//������ id �Ͷ�ѧУ ���� ְλ ���� ״̬ 6���ֶ�����
		try {
			for(int i=0;i<intennames.length;i++){
			
				Student stu=new Student();
				//��ӿ�ʼ
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
				//����img·��Ϊimg + name��·��
				stu.setIntenimg("student/"+stu.getIntentel()+filesFileName[i]);//13
				boolean bln=ss.add(stu);
				//�ϴ��ļ�
				try {
					FileOutputStream fos=new FileOutputStream(this.savePath+
							stu.getIntentel()+this.filesFileName[i]);
					//��ȡ�ļ�����i
					FileInputStream fil=new FileInputStream(this.files[i]);
					//ÿ�ζ��� д���Ĵ�С
					byte[] b=new byte[1024];
					int real=fil.read(b);
					int ii=0;
					while(real>0){
						fos.write(b, 0, real);
						
						real=fil.read(b);//ÿ�ζ��� д�� �ļ�����ͻ���ȥ�ⲿ�֣���������1kb1kbд�� ֪�� ���벻����
						
						ii++;
					}
					fos.close();fil.close();

				} catch (Exception e) {
				}
				
			}
			} catch (Exception e) {
				System.out.println("������");
		}
		
		return "listsx";
	}
	//Ԥ��ͷ��ͼƬ
	public String ylalert(){
		Student stus=stu;
		//�����ļ�
		//���汾�ص�·��
			try {
				for(int i=0;i<filesFileName.length;i++){
					try {
					
						FileOutputStream fos=new FileOutputStream(this.savePath+
								stu.getIntenid()+this.filesFileName[i]);
						//��ȡ�ļ�����i
						FileInputStream fil=new FileInputStream(this.files[i]);
						//ÿ�ζ��� д���Ĵ�С
						byte[] b=new byte[1024];
						int real=fil.read(b);
						int ii=0;
						while(real>0){
							fos.write(b, 0, real);
							
							real=fil.read(b);//ÿ�ζ��� д�� �ļ�����ͻ���ȥ�ⲿ�֣���������1kb1kbд�� ֪�� ���벻����
							
							ii++;
						}
						fos.close();fil.close();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//����img·��Ϊimg + name��·��
					stu.setIntenimg("student/"+stu.getIntenid()+filesFileName[i]);
				}
			} catch (RuntimeException e) {
				System.out.println("���ļ�");
		}
	
		//�޸�
		boolean bln=ss.alert(stu);
		
		stu=ss.get(stu.getIntenid());
		
		ToRequest("stu", stu);
		
		//���ҳ��༶ ���� ȥ���ҳ��
		clslist=ss.selclslist();
		//����
		hrslist=ss.selhrslist();

		//��ȥ�޸�ҳ��
		return "stualert";
	}
	
	//ѧ����Ĳ�������
	
	//����������ʼ
	
	private Long hourid;
	
	private Hourse hrs;
	
	//�����б�
	public String hrslist(){
		List list = ss.hrslist();
		
		ToRequest("list", list);
		
		return "hrslist";
	}
	//ɾ��
	public String hrsdel(){
		//�Ȳ����
		Hourse hrs=ss.gethrs(hourid);
		
		/***********************************
		 * 
		 * 
		 * �м�����ϵ һ��ҪС�� ����һ��������Ϊnull ��Ȼ���ѧ������һ��ɾ�� ����
		 * 
		 * 
		 * --------------------------------------------------------------*/
		hrs.setStudent(null);

		boolean bln=ss.delhrs(hrs);
		
		return hrslist();
	}
	//ȥ�޸�
	public String hrstoalert(){
		//�Ȳ����
		hrs=ss.gethrs(hourid);
		
		//Ӧ��˳��������ᵥԪ �����ᵥԪ�� ���һ�Ĺ�ϵ
		List EleList=ss.selelelist();	
		ToRequest("elelist", EleList);
		
		//��ѯ�����ڶ���ѧ�� �������������Ա��Ŀ�� 
		Long intenstatus=(long)1;
		List stulist=ss.listbystatus(intenstatus);
		
		//�������������е������Ա
		Set yystudent=hrs.getStudent();
		Iterator it = yystudent.iterator();

		for(;it.hasNext();){
		     Student s = (Student)it.next();
		     for(int j=0;j<stulist.size();j++){
				Map stu=(Map)stulist.get(j);
				Object o=stu.get("INTENID");
				/***********	ObjectתString���� toString	*************/
				String ID=o.toString();
				Long Id=Long.parseLong(ID);
				Long id=s.getIntenid();
				if(Id.equals(id)){//MD Long���;�Ȼ��equals�Ա�
					stulist.remove(j);
				}
			}
		}
		ToRequest("stulist", stulist);
		
		//�������
		List hrslist=ss.selhrslist();
		ToRequest("hrslist", hrslist);
		
		return "hrsalert";
	}
	//�޸�
	public String hrsalert(){
		//System.out.println(hrs.getHourid()+" "+hrs.getEid()+" "+hrs.getHhead()+" "+hrs.getHnumber()+" "+hrs.getHourname());
		
		//��ȡ�����Ա ����ӵ�����hrs�� ���ﵽɾ�������Ա��Ŀ��
		String[] me=request.getParameterValues("member");
		String[] me2=request.getParameterValues("member2");
		
		//ÿ��ѧ�����ҳ���
		/*******************
		 * 
		 * ��Ϊ�м�����ϵ �������Ȳ��������Ϣ���޸� �м��м� ��Ȼ���ѧ���Ĺ�������Ϊ��
		 * 
		 * --------------------------------------------------------------*/
		//Hourse hrss=ss.gethrs(hrs.getHourid());
		Set set = new HashSet();//�༶��Ա����
		
		try {
			if(request.getParameter("member")!=null){
				for(int i=0;i<me.length;i++){
					Long mes=Long.parseLong(me[i]);
					Student stu=ss.get(mes);
					set.add(stu);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("�޳�Ա��");
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
			System.out.println("�޳�Ա��");
		}
		hrs.setStudent(set);

		boolean bln=ss.alerthrs(hrs);
		
		System.out.println(bln);
		
		return hrslist();
	}
	//
	public String hrstoadd(){
		//Ӧ��˳��������ᵥԪ �����ᵥԪ�� ���һ�Ĺ�ϵ
		List EleList=ss.selelelist();	
		ToRequest("elelist", EleList);
		
		//��ѯ�����ڶ���ѧ�� �������������Ա��Ŀ�� 
		Long intenstatus=(long)1;
		List stulist=ss.listbystatus(intenstatus);
		ToRequest("stulist", stulist);
		
		//�������
		List hrslist=ss.selhrslist();
		ToRequest("hrslist", hrslist);
		
		return "hrsadd";
	}
	//��� ���� 
	public String hrsadd(){
		//��ȡ��Ա
		String[] me=request.getParameterValues("member");
		Set set = new HashSet();//�༶��Ա����
		
		try {
			if(request.getParameter("member")!=null){
				for(int i=0;i<me.length;i++){
					Long mes=Long.parseLong(me[i]);
					Student stu=ss.get(mes);
					set.add(stu);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("�޳�Ա��");
		}
		hrs.setStudent(set);
		boolean bln=ss.addhrs(hrs);
		
		System.out.println(bln);
		
		return hrslist();
		
	}
	//��Ԫ��ʼ
	
	private Elements ele;
	
	private int eid;
	private String eename;
	
	//���
	public String eleadd(){
		boolean bln=ss.addele(ele);
		System.out.println(bln);
		
		return "elelist";
	}
	//�޸ĺ�ɾ����ͬһ��
	public String elelist(){
		if(eid!=0&&!eename.equals("")&&eename!=null){
			//�޸�
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

	public String eledel(){//ɾ��

		//�м����Ĺ�ϵ�ı� �޸�ҲҪ�и�����ϵ
		//�Ȳ����
		Elements eles=ss.getele(ele.getEid());
		
		eles.setHourse(null);// һ��Ϊnull ��Ȼ��ɾ����hourse
		
		boolean bln=ss.delele(eles);
		
		System.out.println(bln);
		
		//ȥjspҳ��
		return "elelist";
	}
	//��Ԫ����
	
	//������������
	
	
	//�༶�������ʼ
	
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
		//Ա��list
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
		
		//Ա��list
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		//��ѯ�����ڶ���ѧ�� ������Ӱ༶��Ա��Ŀ�� 
		Long intenstatus=(long)1;
		List stulist=ss.listbystatus(intenstatus);
		
		//����classes�����еİ༶��Ա
		Set yystudent=classes.getStudent();
		Iterator it = yystudent.iterator();

		for(;it.hasNext();){
		     Student s = (Student)it.next();
		     for(int j=0;j<stulist.size();j++){
				Map stu=(Map)stulist.get(j);
				Object o=stu.get("INTENID");
				/***********	ObjectתString���� toString	*************/
				String ID=o.toString();
				Long Id=Long.parseLong(ID);
				Long id=s.getIntenid();
				if(Id.equals(id)){//MD Long���;�Ȼ��equals�Ա�
					stulist.remove(j);
				}
			}
		}

		ToRequest("stulist", stulist);
		
		//�༶
		List clslist=ss.clslist();
		ToRequest("clslist", clslist);
		
		return "clsalert";
	}
	public String clsalert(){
		//��ȡ�༶��Ա ����ӵ�����hrs�� ���ﵽɾ���༶��Ա��Ŀ��
		
		String[] me=request.getParameterValues("member");
		String[] me2=request.getParameterValues("member2");
		
		Set set = new HashSet();//�༶��Ա����
		
		try {
			if(request.getParameter("member")!=null){
				for(int i=0;i<me.length;i++){
					Long mes=Long.parseLong(me[i]);
					Student stu=ss.get(mes);
					set.add(stu);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("�޳�Ա��");
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
			System.out.println("�޳�Ա��");
		}
		//����
		classes.setStudent(set);
		
		boolean bln=ss.alertcls(classes);
		System.out.println(bln);
		return clslist();
	}
	public String clsdel(){

		//�м����Ĺ�ϵ�ı� �޸�ҲҪ�и�����ϵ
		//�Ȳ����
		Classes classes=ss.getcls(classid);
		classes.setStudent(null);// һ��Ϊnull ��Ȼ��ɾ����ѧ��
		
		boolean bln=ss.delcls(classes);
		
		System.out.println(bln);
		
		return clslist();
	}
	
	//�༶���������
	
	//�ɼ��������ʼ
	
	private Long couid;
	private Long scoid;

	private Score sco;
	
	private Float score[];
	private Long stuid[];
	private int size;//�ж���û��ֵ
	
	
	//ɸѡ
	public String scosx(){
		
		//��ѯ�༶ vo ����
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ� vo ����
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//���ҵ�һ���γ̺͵�һ���༶������ �Ż��Ļ����Բ��ҵ�һ���ɼ�

		//���� ֱ�Ӳ�ѯ�����ڶ�ѧ���ĳɼ� ����ī��
		list=ss.scolist();
		size=list.size();
		return "scolist";
	}
	public String scosx2(){//ѧ���б�
		/************************************/
		//����鿴�Լ����ϵĳɼ�
		Student stu=ss.get(studentlogin.getIntenid());
		
		//��ѯ�༶ vo ����
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ� vo ����
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//���ҵ�һ���γ̺͵�һ���༶������ �Ż��Ļ����Բ��ҵ�һ���ɼ�

		//�γ���1 java ��ȡ Ĭ��java
		if(couid==null){
			Course courses=(Course) coslist.get(0);
			list=ss.scolist(stu.getClassid(),courses.getCouid());
		}else{
			list=ss.scolist(stu.getClassid(), couid);
		}
		size=list.size();
		
		//��ȡ�༶
		Classes classes=ss.getcls(stu.getClassid());
		ToRequest("classes", classes);
		
		return "scostulist";
	}
	public String scolist(){
		//classid couid �Զ���ȡ
		System.out.println("scolist");
		list=ss.scolist(classid,couid);
		size=list.size();
		
		System.out.println(list.size());
		
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//�����޸�sconame
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "scolist";
	}
	public String scolist2(){//ѧ����
		//couid �Զ���ȡ
		//classid ��ѧ������
		/************************************/
		Student stu=ss.get(studentlogin.getIntenid());
		classid=stu.getClassid();
		
		list=ss.scolist(classid,couid);
		size=list.size();
		
		System.out.println(list.size());
		
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//�����޸�sconame
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "scostulist";
	}
	public String scotoadd(){
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		size=0;
		sizes=0;

		return "scoadd";
	}
	//ͨ���༶��ȡ���е�ѧ����Ϣ
	public String scotoadd2(){
		
		List scolist=ss.scolist(classid, couid);
		//��scolist��Ϊ�վͱ�ʾ��ֵ��
		size=scolist.size();
		sizes=1;
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//�����޸�sconame
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ȡ����༶������ѧ������
		List classstudent=ss.scoaddclassstudentlist(classid);
		ToRequest("cslist", classstudent);

		//�Զ�����
		System.out.println(classid+" "+couid);
		return "scoadd";
	}
	//��ӳɼ�
	public String scoadd(){
		//��� ��ѭ�����
		for(int i=0;i<score.length;i++){
			Score scores=new Score();
			scores.setSconame(couid);
			scores.setScore(score[i]);
			scores.setStuid(stuid[i]);
			boolean bln=ss.addsco(scores);
			System.out.print(bln);
		}

		//����scolist.jsp
		list=ss.scolist(classid, couid);
		size=list.size();
		
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//�����޸�sconame
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "scolist";
	}

	//�޸�
	public String scoalert(){
		//classid couid �Զ���ȡ �����б�
		System.out.println(sco.getScoid()+" "+sco.getStuid()+" "+sco.getScore()+" "+sco.getSconame());

		//�޸�
		boolean bln=ss.alertsco(sco);
		System.out.println(bln);
		
		//��һ�η���ȫ���ɼ�ҳ��
		System.out.println(classid+" "+couid);
		if(classid==null&&couid==null){
			list=ss.scolist();
			size=list.size();
			System.out.println("1");
		}else{
			list=ss.scolist(classid, couid);
			size=list.size();
			System.out.println("2");
			//��ȡ�༶ �γ̶���
			Classes classes=ss.getcls(classid);
			Course course=ic.getcourse(couid);
			ToRequest("classes", classes);
			ToRequest("course", course);
		}
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//�����޸�sconame
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "scolist";
	}
	//�ɼ����������
	
	//̸�ļ�¼�������ʼ 
	private String intenname;
	private Long ename;//̸�ļ�¼���ð�����id�����
	private Says says;
	private Long sayid;
	private Long state;//״̬
	//ɸѡ
	public String sayssx(){//Ա�� ��ʾ�Լ���̸�ļ�¼
		//��¼id
		/****************************************************/
		//��ѯ������ ����Ա��
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//���µ�̸�ļ�¼
		List sayslist=ss.sayslist(0,10);
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		state=(long)1;
		
		//�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		return "sayslist";
	}
	public String sayssx2(){//��ѯѧ����̸�ļ�¼
		//��ѯԱ���ĺ�
		List teaches=ie.emplist();
		ToRequest("teaches", teaches);
		
		//��ѯ���ѧ����̸�ļ�¼
		/****************************************************/
		List sayslist=ss.saysstulist(studentlogin.getIntenid());
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		
		return "saysstulist";
	}
	//�б�
	public String sayslist(){
		//���ݰ����κ;Ͷ�״̬��
		List sayslist=ss.sayslist(ename,state);
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		
		//��ѯ������ ����Ա��
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//��ȡ�����ζ���
		Emp emp=ss.getemp(ename);
		ToRequest("emp", emp);

		//�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "sayslist";
	}
	
	public String saystoadd(){
		
		//���ݰ༶��ɸѡѧ��
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
		//��������Ϊ���İ����εĺ�
		Student stus=ss.get(says.getSayface());
		Classes classes=ss.getcls(stus.getClassid());
		Emp emps=ss.getemp(classes.getEmpteaches());
		says.setSayempid(emps.getEid());
		boolean bln=ss.addsays(says);
		
		System.out.println(bln);

		//state����ѧ����״̬�����Ǳ�ҵ�����ڶ�
		Student stu=ss.get(says.getSayface());
		state=stu.getIntenstatus();
		List sayslist=ss.sayslist(says.getSayempid(),state);//��ֻ�а�����ʱ
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		//��ѯ������ ����Ա��
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//��ȡ�����ζ���
		Emp emp=ss.getemp(says.getSayempid());
		ToRequest("emp", emp);
		
		//�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "sayslist";
	}
	public String saystoalert(){
		System.out.println(sayid);
		
		//��ѯ
		says=ss.getsays(sayid);
		System.out.println(says.getSayface());
		//��ѯ������ ����Ա��
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//�ҳ�������ѧ��
		Student stus=ss.get(says.getSayface());
		System.out.println(stus.getClassid());
		List student=ss.listbyclassid(stus.getClassid());
		ToRequest("student", student);
		
		//�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "saysalert";
	}
	public String saysalert(){
		//����id��ѯ ���淴��
		Says say=ss.getsays(says.getSayid());
		//��ѯ
		says.setSayback(say.getSayback());
		System.out.println(says.getSaydate());
		boolean bln=ss.alertsays(says);
		System.out.println(bln);
		
		//state����ѧ����״̬�����Ǳ�ҵ�����ڶ�
		Student stu=ss.get(says.getSayface());
		state=stu.getIntenstatus();
		List sayslist=ss.sayslist(says.getSayempid(),state);//��ֻ�а�����ʱ
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		//��ѯ������ ����Ա��
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//��ȡ�����ζ���
		Emp emp=ss.getemp(says.getSayempid());
		ToRequest("emp", emp);
		
		//�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "sayslist";
	}
	//̸�ļ�¼��ɾ��
	public String saysdel(){
		Says say=ss.getsays(sayid);
		boolean bln=ss.delsays(say);
		
		System.out.println(bln);
		
		says=say;
		
		//state����ѧ����״̬�����Ǳ�ҵ�����ڶ�
		Student stu=ss.get(says.getSayface());
		state=stu.getIntenstatus();
		List sayslist=ss.sayslist(says.getSayempid(),state);//��ֻ�а�����ʱ
		size=sayslist.size();
		ToRequest("sayslist", sayslist);
		//��ѯ������ ����Ա��
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		//��ȡ�����ζ���
		Emp emp=ss.getemp(says.getSayempid());
		ToRequest("emp", emp);
		
		//�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "sayslist";
	}
	//ѧ��ȥ����
	public String saystofankui(){
		//����sayid��ѯ
		says=ss.getsays(sayid);
		
		return "saysfankui";
	}
	//ѧ������
	public String saysfankui(){
		Says says2=ss.getsays(says.getSayid());
		
		says2.setSayback(says.getSayback());
		
		boolean bln=ss.alertsays(says2);
		System.out.println(bln);
		
		return sayssx2();
	}
	//ѧ���޸ķ���
	public String saystoalert2(){
		//����sayid��ѯ
		says=ss.getsays(sayid);
		
		return "saysstualert";
	}
	//ѧ���޸�
	public String saysstualert(){
		Says says2=ss.getsays(says.getSayid());
		
		says2.setSayback(says.getSayback());
		
		boolean bln=ss.alertsays(says2);
		System.out.println(bln);
		
		return sayssx2();
	}
	//̸�ļ�¼���������
	
	//ѧ����ҵ�ܽῪʼ
	
	private Summary smy;
	private Long sids;
	
	public String smysx(){
		//���а༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		//���е�ѧ���ܽ�
		list=ss.summarylist();
		
		return "smylist";
	}
	public String smysx2(){//ѧ����ֻ��ѯ�Լ���
		//��¼id
		/****************************************************/
		//�Լ���ѧ���ܽ�
		list=ss.summarystulist(studentlogin.getIntenid());
		
		return "smystulist";
	}
	public String smylist(){
		//ͨ��classid��ȡ�ܽ���
		
		list=ss.summarylist(classid);
		
		//�༶
		Classes classes=ss.getcls(classid);
		String classname=classes.getClassname();
		classid=classes.getClassid();
		ToRequest("classname", classname+"��");

		//���а༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "smylist";
	}
	public String smytoadd(){
		System.out.println(classid);
		//����classid��ѯ���Ѿ���ҵ�İ༶��û�м�¼��ѧ��
		List student=ss.summarytoaddstulist(classid);
		ToRequest("student", student);
		
		return "smyadd";
	}
	public String smyadd(){
		//��ʦ�ɵ�½��
		smy.setSteaches(emplogin.getEid());
		boolean bln=ss.addsmy(smy);
		System.out.println(bln);
		//���а༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		//���е�ѧ���ܽ�
		list=ss.summarylist();
		
		return "smylist";
	}
	public String smytoalert(){
		//��ѯ
		smy=ss.getsmy(sids);
		
		//����classid��ѯ ������ѧ��
		List student=ss.listbyclassid(classid);
		ToRequest("student", student);
		//��ʦ
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		return "smyalert";
	}
	public String smyalert(){
		//��ѯ
		boolean bln=ss.alertsmy(smy);
		System.out.println(bln);
		
		list=ss.summarylist(classid);
		
		//�༶
		Classes classes=ss.getcls(classid);
		String classname=classes.getClassname();
		classid=classes.getClassid();
		ToRequest("classname", classname+"��");

		//���а༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		return "smylist";
	}
	
	//ѧ����ҵ�ܽ����
	
	//ѧ����ҵ��ʼ
	private Job job;
	private Long jobid;
	
	public String jobsx(){
		//��ѯ�༶ �ҳ�������
		List clslist=ss.selclslist();
		
		//��ѯ��һ���༶�İ���������¼�ľ�ҵ���
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
		//ֻͨ����ѯ�༶����ѯ
		List joblist=ss.joblist(classid);
		
		ToRequest("joblist", joblist);
		
		//��ѯ�༶ 
		List selclslist=ss.selclslist();
		ToRequest("clslist", selclslist);
		return "joblist";
	}
	public String jobtoadd(){
		//����classid��ѯ
		List student=ss.jobtoaddstulist(classid);
		ToRequest("student", student);
		//��������ʦ
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		return "jobadd";
	}
	public String jobadd(){
		//���õ�½����ʦ
		job.setJobtea(emplogin.getEid());
		boolean bln=ss.addjob(job);

		//ͨ�� ��¼��������joblist
		List joblist=ss.joblistbytea(job.getJobtea());
		
	
		ToRequest("joblist", joblist);
		//��������ʦ
		List teaches=ss.empteacheslist();
		
		ToRequest("teaches", teaches);
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		return "joblist";
	}
	public String jobtoalert(){
		///����classid��ѯ���Ѿ���ҵ�İ༶��û�м�¼��ѧ��
		List student=ss.listbyclassid(classid);
		ToRequest("student", student);
		
		//��������ʦ
		List teaches=ss.empteacheslist();
		ToRequest("teaches", teaches);
		
		job=ss.getjob(jobid);
		
		return "jobalert";
	}
	public String jobalert(){
		//System.out.println(job.getJobid()+" "+job.getJobaddr()+" "+job.getJobdate()+" "+job.getJobdesc()+" "+job.getJobname()+" "+job.getJobnum()+" "+job.getJobsalary()+" "+job.getJobtea()+" "+job.getJobstu());
		boolean bln=ss.alertjob(job);
		
		//ͨ�� ��¼��������joblist
		List joblist=ss.joblistbytea(job.getJobtea());
		ToRequest("joblist", joblist);
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		return "joblist";
	}
	public String jobdel(){
		job=ss.getjob(jobid);
		boolean bln=ss.deljob(job);
		//ͨ�� ��¼��������joblist
		List joblist=ss.joblistbytea(job.getJobtea());
		ToRequest("joblist", joblist);
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		return "joblist";
	}
	//ѧ����ҵ����
	
	//��Ŀ��翪ʼ
	private Course course;
	private Projectf prj;
	private Long did;
	private String time;
	private long zdls;
	private long teaches;
	private int sizes;//��������¼�������ť
	private int addtolist;//���������������ͷ
	
	public String prjsx(){
		
		addtolist=0;//����귵��list
		
		//��ѯ�༶ vo ����
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ� vo ����
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//��ѯԱ�� �ҳ�ָ����ʦ 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		//���ҵ�һ���γ̺͵�һ���༶������ �Ż��Ļ����Բ��ҵ�һ���ɼ�

		System.out.println("��������Ŀ�ɼ�ɸѡ");
		//���� ֱ�Ӳ�ѯ���е����� ����ī��
		list=ss.prjlist();//����
		size=list.size();
		System.out.println(size);
		
		String addtolist2=request.getParameter("addtolist2");
		if(addtolist2!=null&&!addtolist2.equals("")){
			addtolist=Integer.parseInt(addtolist2);
		}
	
		return "prjlist";
	}
	public String prjsx2(){//ѧ����ѯ
		//��¼id
		/****************************************************/
		Student stu=ss.get(studentlogin.getIntenid());
		
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(stu.getClassid());
		ToRequest("classes", classes);
		
		//��ѯ�༶ vo ����
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ� vo ����
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//��ѯԱ�� �ҳ�ָ����ʦ 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);

		//�����ҳ����ѧ���İ༶��Ŀ Ĭ��1
		if(couid==null){
			Course courses=(Course) coslist.get(0);
			list=ss.prjlist(stu.getClassid(),courses.getCouid());//����
		}else{
			list=ss.prjlist(stu.getClassid(),couid);//����
		}
		size=list.size();
		System.out.println(size);
		
		return "prjstulist";
	}
	//�鿴���� ͬѧ�ĳɼ�
	public String dfslist(){
		list=ss.dfslist(classid, couid);
		//�����ҳ��༶ ��Ŀ���� ָ����ʦ ��ʾʱ�� ��ί��ʦ
		System.out.println(list.size());

		try {
			Map map=(Map)list.get(0);
//			ToRequest("classid", map.get("PCLASSID"));
			ToRequest("pname", map.get("PNAME"));
			ToRequest("pteacher", map.get("PTEACHER"));
			ToRequest("pdate", map.get("PDATE"));
			ToRequest("pteachers", map.get("PTEACHERS"));
			//�鳤
			ToRequest("head", map.get("DHEAD"));
			
			//��ѯԱ�� �ҳ�ָ����ʦ 
			List emplist=ie.emplist();
			ToRequest("emplist", emplist);
			
			//ѧ��
			List student=ss.list();
			ToRequest("student", student);
			
			//��ѯ�༶ vo ����
			List clslist=ss.selclslist();
			ToRequest("clslist", clslist);
			
			//��ѯ�γ� vo ����
			List coslist=ss.selcos();
			ToRequest("coslist", coslist);
			
			//��ȡ�༶ �γ̶���
			Classes classes=ss.getcls(classid);
			Course course=ic.getcourse(couid);
			ToRequest("classes", classes);
			ToRequest("course", course);
		} catch (RuntimeException e) {
			//�д� ûֵ
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
		
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//��ѯ�༶ vo ����
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ� vo ����
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//��ѯԱ�� �ҳ�ָ����ʦ 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		String addtolist2=request.getParameter("addtolist2");
		if(addtolist2!=null&&!addtolist2.equals("")){
			addtolist=Integer.parseInt(addtolist2);
		}
		
		return "prjlist";
	}
	public String prjlist2(){//ѧ��
		//��¼id
		/****************************************************/
		Student stu=ss.get(studentlogin.getIntenid());
		classid=stu.getClassid();
		System.out.println(classid+" "+couid);
	
		list=ss.prjlist(classid,couid);
		size=list.size();
		System.out.println(list.size());
		
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//��ѯ�༶ vo ����
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ� vo ����
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//��ѯԱ�� �ҳ�ָ����ʦ 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "prjstulist";
	}
	
	public String prjtoadd(){
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//��ѯԱ�� �ҳ���ί��ʦ
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		size=0;//�����ж���û�гɼ� �����ǵ�һ�ν� ���Ի���һ������ʹ��
		
		sizes=0;//�����жϰ�ť��ʹ��
		
		return "prjadd";
	}
	public String prjtoadd2(){
		//�����Ƿ��������Ŀ�����Ϣ
		List dfslist=ss.prjlist(classid, couid);
		//��scolist��Ϊ�վͱ�ʾ��ֵ��
		size=dfslist.size();
		sizes=1;
		
		//���ҳ�����ѧ�� ���ݰ༶
		List classstudent=ss.scoaddclassstudentlist(classid);
		ToRequest("cslist", classstudent);
		
		//��ѯ�༶
		List clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//��ѯԱ�� �ҳ�ָ����ʦ 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		//����ѡ�еİ༶ �γ� ָ����ʦ ��ί��ʦ ʱ��
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(classid);
		course=ic.getcourse(couid);
		Emp teacherr=ie.getemp(classes.getEmpteach());//ָ����ʦ ���ɰ༶��Ӧ��
		Emp teachers=ie.getemp(teaches);//��ί��ʦ
		ToRequest("classes", classes);
//		ToRequest("course", course);
		ToRequest("teacherr", teacherr);
		ToRequest("teachers", teachers);
		
		return "prjadd";
	}
	//�޸ĸ�����ӱ�
	public String prjalert(){
		//classid couid �Զ���ȡ �����б�
		
		//����һ�ε�ʱ��ͨ�� pid��ȡ��Ϣ����ȡҪ�޸ĵ���Ϣ���þ���

		//�޸�
		boolean bln=ss.alertprj(prj);
		System.out.println(bln);
		
		//��һ���޸ķ�������
		if(classid==null&&couid==null){
			list=ss.prjlist();
			size=list.size();
			
		}else{//��classid��couid �ͷ��������ѯ
			list=ss.prjlist(classid, couid);
			size=list.size();
			System.out.println("2");
			//��ȡ�༶ �γ̶���
			Classes classes=ss.getcls(classid);
			Course course=ic.getcourse(couid);
			ToRequest("classes", classes);
			ToRequest("course", course);
		}
		//��ѯ�γ�
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);//�����޸�sconame
		
		//��ѯ�༶
		clslist=ss.selclslist();
		ToRequest("clslist", clslist);

		//��ѯԱ�� �ҳ�ָ����ʦ 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "prjlist";
	}
	
	//�ֱ���� ��Ϊ��select ������string[]��ȡ
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
		//�������
		boolean bln=ss.addprj(prj);
		//��ӷ���
		
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
			System.out.println("����ֵ");
		}
				
		//������
		list=ss.prjlist(classid,couid);
		size=list.size();
		System.out.println(list.size());
		
		//��ȡ�༶ �γ̶���
		Classes classes=ss.getcls(classid);
		Course course=ic.getcourse(couid);
		ToRequest("classes", classes);
		ToRequest("course", course);
		
		//��ѯ�༶ vo ����
		clslist=ss.selclslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ� vo ����
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		//��ѯԱ�� �ҳ�ָ����ʦ 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		addtolist=1;//����귵��list
		
		return "prjlist";
	}
	//��Ŀ������
	
	//���������ʼ
	
	private Sback sbk;
	private Long sbackid;
	private Reply rly;
	private Long rid;
	
	//ѧ����
	public String sbksx2(){
		//���ݵ�¼��id�鿴�Լ��ķ���
		list =ss.sbkstulist(studentlogin.getIntenid());
		//�ظ��б� �ж���û�лظ��б�
		List rlylist=ss.replylist();
		ToRequest("rlylist", rlylist);
		//�鿴����ʦ
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		return "sbkstulist";
	}
	public String sbklist(){
		/************���Ҹ��ݵ�¼��ʦid����*************/
		Long statu=(long)0;
		list = ss.sbklist(statu,emplogin.getEid());//δ����
		
		return "sbklist";
	}
	public String sbklist2(){
		Long statu=(long)1;
		list = ss.sbklist2(statu,emplogin.getEid());//�ѻظ�
		
		return "sbklist2";
	}
	public String sbklist3(){
		Long statu=(long)2;
		list = ss.sbklist(statu,emplogin.getEid());//����ʾ
		
		return "sbklist3";
	}
	public String sbktoadd(){
		//�������е���ʦ
		list=ie.emplist();
		
		return "sbkadd";
	}
	public String sbkadd(){
		//״̬Ĭ��Ϊ0 λ����
		Long statu=(long)0;
		sbk.setStatu(statu);
		//�ӵ�½�л�ȡѧ��id
		sbk.setStdid(studentlogin.getIntenid());
		boolean bln=ss.addsbk(sbk);

		System.out.println(bln);
		//����ѧ�����
		return sbksx2();
	}
	//ȥ�ظ�
	public String toreply(){
		//Ϊ�˱���sbackid
		//����sbackid
		
		return "sbkreply";
	}
	//�޸�Ϊ�ظ� ������ת���ѻظ�ҳ��list2
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
	//�޸�Ϊ����ʾ
	public String nodisplay(){
		Sback sback=ss.getsbk(sbackid);
		Long statu=(long)2;
		sback.setStatu(statu);
		boolean bln=ss.updsbkstatu(sback);
		System.out.println(bln);
		
		return sbklist();
	}
	//�޸�Ϊ��ʾ
	public String display(){
		Sback sback=ss.getsbk(sbackid);
		Long statu=(long)0;
		sback.setStatu(statu);
		boolean bln=ss.updsbkstatu(sback);
		System.out.println(bln);
		
		return sbklist();
	}
	//����һ���޸�
	public String sbkreplytoalert(){
		System.out.println("������ȥ�޸�"+rid);
		rly=ss.getrly(rid);
		return "sbkreplyalert";
	}
	public String sbkreplyalert(){
		System.out.println("�������޸�");
		boolean bln=ss.updrly(rly);
		System.out.println(bln);
		return sbklist2();
	}
	//ɾ��
	public String delsback(){
		//ʵ��Ϊ�޸�sempidΪnull
		Sback sbacks=ss.getsbk(sbackid);
		sbacks.setSempid(null);
		boolean bln=ss.updsbkstatu(sbacks);
		System.out.println(bln);
		return sbklist3();
	}
	//�����������
	
	//��ٹ���ʼ
	
	private Long lid;
	private Long lteashr;
	private Long lstushr;
	private Long lstate;
	private Leave lev;
	
	//��ʦ��
	public String levsx(){
	
		//��ʦ��ʾ�Լ���˵����е�����б� ����״̬Ϊ��ͬ��2�������1 �������״̬ ���־�����
		list = ss.levlist(emplogin.getEid());
		
		//����Ա��
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "levlist";
	}
	//ȥѧ���б� �鿴�Լ�������б�
	public String levsx2(){
		//ѧ����ʾ�Լ�������б�
		list=ss.levstulist(studentlogin.getIntenid());//�ȵ�һ�� ��¼���˲�ѯ��¼��
		//��ȡ���� intenid �������
		Student student=ss.get(studentlogin.getIntenid());
		ToRequest("student", student);
		
		return "levstulist";
	}
	//��ʦͬ��
	public String levstatus(){
		
		//�Ȼ�ȡlev����
		Leave lev=ss.getlev(lid);
		//���ö��� �������û����һ�����ʱ���޸�״̬Ϊͬ�� ��������˾�����Ϊ0��
		if(lteashr==0){
			System.out.println("�Ǻ�");
			lev.setLstate(lstate);
		}

		lev.setLshr(lteashr);//����һ����� ֻ�޸������

		boolean bln=ss.updlev(lev);
		System.out.println(bln);

		return levsx();
	}
	//��ʦ��ͬ��
	public String levstatus3(){
		//�Ȼ�ȡlev����
		Leave lev=ss.getlev(lid);
		//�޸�״̬Ϊ��ͬ�� 
		lev.setLstate(lstate);

		boolean bln=ss.updlev(lev);
		System.out.println(bln);

		return levsx();
	}
	//ѧ���ύ
	public String levstatus2(){
		//�Ȼ�ȡlev����
		Leave lev=ss.getlev(lid);
		//���ö��� �������û����һ�����ʱ���޸�״̬Ϊͬ��

		lev.setLstate(lstate);
		lev.setLshr(lstushr);
		
		boolean bln=ss.updlev(lev);
		System.out.println(bln);
		
		return "levsx2";
	}
	
	//ȥ��� �Զ���ȡ��һ������˰�����
	public String levtoadd(){
		System.out.println(intenid+"intenid");
		//��ȡ�Լ���id �ҵ�������
		Student student=ss.get(intenid);
		ToRequest("student", student);
	
		try {
			Classes classes = ss.getcls(student.getClassid());
			ToRequest("classes", classes);
			Emp emp=ie.getemp(classes.getEmpteaches());
			ToRequest("emp", emp);
			
		} catch (RuntimeException e) {
			System.out.println("ѧ����Ϣ������ ����1643��");
		}
		
		return "levadd";
	}
	public String levadd(){
		System.out.println(lev.getLshr());
		lev.setLstate((long)0);//δ�ύ
		
		boolean bln=ss.addlev(lev);
		System.out.println(bln);
		//System.out.println(lev.getLstarttime()-lev.getLendtime());
		return "levsx2";
	}
	//ɾ��
	public String levdel(){
		Leave lev=ss.getlev(lid);
		
		boolean bln=ss.dellev(lev);
		System.out.println(bln);
		
		return "levsx2";
	}
	//ȥ�޸�
	public String levtoalert(){
		lev=ss.getlev(lid);
		
		//�����
		try {
			Student student=ss.get(lev.getLstuid());
			ToRequest("student", student);
			
			Classes classes=ss.getcls(student.getClassid());
			
			Emp emp=ss.getemp(classes.getEmpteaches());
			ToRequest("emp", emp);
		} catch (RuntimeException e) {
			System.out.println("ѧ����Ϣ������ ����1680��");
		}

		return "levalert";
	}
	public String levalert(){

		boolean bln=ss.updlev(lev);
		System.out.println(bln);
		
		return "levsx2";
	}
	
	
	//��ٹ������
	
	//���õ��Կ�ʼ
	
	private Long aid;
	private Long astate;
	private Long ateashr;
	private Long astushr;
	private Application apl;
	//��ʦ��
	public String aplsx(){
	
		//��ʦ��ʾ�Լ���˵����е�����б� ����״̬Ϊ��ͬ��2�������1 �������״̬ ���־�����
		list = ss.apllist(emplogin.getEid());
		
		//����Ա��
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		return "apllist";
	}
	//ȥѧ���б� �鿴�Լ�������б�
	public String aplsx2(){
		//ѧ����ʾ�Լ�������б�
		list=ss.aplstulist(studentlogin.getIntenid());//�ȵ�һ�� ��¼���˲�ѯ��¼��
		
		//��ȡ���� intenid
		Student student=ss.get(studentlogin.getIntenid());
		ToRequest("student", student);
		
		return "aplstulist";
	}
	//��ʦͬ��
	public String aplstatus(){
		//��ȡ����
		System.out.println(aid);
		System.out.println(ateashr);
		System.out.println(astate);
		
		//�Ȼ�ȡlev����
		Application apl=ss.getapl(aid);
		//���ö��� �������û����һ�����ʱ���޸�״̬Ϊͬ��
		if(ateashr==0){
			apl.setAstate(astate);
		}
		apl.setAshr(ateashr);//����һ����� ֻ�޸������

		boolean bln=ss.updapl(apl);
		System.out.println(bln);

		return aplsx();
	}
	//��ʦ��ͬ��
	public String aplstatus3(){
		//��ȡ����
		System.out.println(aid);
		System.out.println(astate);
		
		//�Ȼ�ȡlev����
		Application apl=ss.getapl(aid);
		//�޸�״̬Ϊ��ͬ��
		apl.setAstate(astate);

		boolean bln=ss.updapl(apl);
		System.out.println(bln);
		
		return aplsx();
	}
	//ѧ���ύ
	public String aplstatus2(){
		//��ȡ����
		System.out.println(aid);
		System.out.println(astushr);
		System.out.println(astate);
		//�Ȼ�ȡlev����
		Application apl=ss.getapl(aid);
		//���ö��� �������û����һ�����ʱ���޸�״̬Ϊͬ��

		apl.setAstate(astate);
		apl.setAshr(astushr);
		
		boolean bln=ss.updapl(apl);
		System.out.println(bln);
		
		return "aplsx2";
	}
	//ȥ��� �Զ���ȡ��һ������˰�����
	public String apltoadd(){
		System.out.println(intenid+"intenid");
		//��ȡ�Լ���id �ҵ�������
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
		System.out.println(apl.getAshr());//�����
		apl.setAstate((long)0);//δ�ύ
		
		boolean bln=ss.addapl(apl);
		System.out.println(bln);
		
		return "aplsx2";
	}
	//ɾ��
	public String apldel(){
		Application apl=ss.getapl(aid);
		
		boolean bln=ss.delapl(apl);
		System.out.println(bln);
		
		return "aplsx2";
	}
	//ȥ�޸�
	public String apltoalert(){
		apl=ss.getapl(aid);
		
		//�����
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
	//���õ��Խ���
	
	//���ɱ���
	public String scbb(){
		System.out.println(classid+" "+couid);

		list=ss.dfslist(classid, couid);
		//�����ҳ��༶ ��Ŀ���� ָ����ʦ ��ʾʱ�� ��ί��ʦ
		System.out.println(list.size());

		Map map=(Map)list.get(0);
		ToRequest("classid", map.get("PCLASSID"));
		ToRequest("pname", map.get("PNAME"));
		ToRequest("pteacher", map.get("PTEACHER"));
		ToRequest("pdate", map.get("PDATE"));
		ToRequest("pteachers", map.get("PTEACHERS"));
		
		//�鳤
		ToRequest("head", map.get("DHEAD"));
		
		//��ѯԱ�� �ҳ�ָ����ʦ 
		List emplist=ie.emplist();
		ToRequest("emplist", emplist);
		
		//ѧ��
		List student=ss.list();
		ToRequest("student", student);
		
		//��ѯ�༶ vo ����
		List clslist=ss.clslist();
		ToRequest("clslist", clslist);
		
		//��ѯ�γ� vo ����
		List coslist=ss.selcos();
		ToRequest("coslist", coslist);
		
		Object pteacher=map.get("PTEACHER");//ָ����ʦ
		Object pdate=map.get("PDATE");//��ʾʱ��
		Object pteachers=map.get("PTEACHERS");//��ί��ʦ
		
		//�༶
		String classname="";
		for(int i=0;i<clslist.size();i++){
			Classes classes=(Classes)clslist.get(i);
			if(classid.equals(classes.getClassid())){
				classname=classes.getClassname();
			}
		}
		//��Ŀ
		String couname="";
		for(int i=0;i<coslist.size();i++){
			Course course=(Course)coslist.get(i);
			if(couid.equals(course.getCouid())){
				couname=course.getCouname();
			}
		}
		//ָ����ʦ
		String zdls="";
		String pteacherss=pteacher.toString();
		Long zdlsid=Long.parseLong(pteacherss);
		for(int i=0;i<emplist.size();i++){
			Emp emp=(Emp)emplist.get(i);
			if(zdlsid.equals(emp.getEid())){
				zdls=emp.getEname();
			}
		}
		//��ί��ʦ
		String pwls="";
		String pteachersss=pteachers.toString();
		Long pwlsid=Long.parseLong(pteachersss);
		for(int i=0;i<emplist.size();i++){
			Emp emp=(Emp)emplist.get(i);
			if(pwlsid.equals(emp.getEid())){
				pwls=emp.getEname();
			}
		}
		//��ʼ��ӡ����
		//����HSSFWorkbook����(excel���ĵ�����)
	    HSSFWorkbook wb = new HSSFWorkbook();

		//�����µ�sheet����excel�ı���
		HSSFSheet sheet=wb.createSheet("�ɼ���");
		
		HSSFCellStyle cellStyle = wb.createCellStyle();  
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����    
		HSSFFont font = wb.createFont();    
		font.setFontName("����");    
		font.setFontHeightInPoints((short) 16);//���������С
		cellStyle.setFont(font);//ѡ����Ҫ�õ��������ʽ  
		
		//��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		HSSFRow row1=sheet.createRow(0);
		//������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		HSSFCell cell=row1.createCell(0);
		//���õ�Ԫ������
		cell.setCellValue("�����Զ���ϵ-��ͼ���������Ŀ������ֱ�");
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
		cell.setCellStyle(cellStyle);
		//��sheet�ﴴ���ڶ���
		HSSFRow row2=sheet.createRow(1); 
		HSSFCell cell2=row2.createCell(0);
		//���õ�Ԫ������
		cell2.setCellValue("�༶:"+classname+"        ��Ŀ����:"+couname+"          ָ����ʦ:"+zdls+"         ��ʾʱ��:"+pdate+"        ��ί��ʦ:"+pwls);
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,8));
		HSSFCellStyle cellStyle2 = wb.createCellStyle();  
		cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����    
		HSSFFont font2 = wb.createFont();    
		font2.setFontName("����");    
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ    
		font2.setFontHeightInPoints((short) 12);    
		cellStyle2.setFont(font2);//ѡ����Ҫ�õ��������ʽ  
		
		cell2.setCellStyle(cellStyle2);
       //������Ԫ�����õ�Ԫ������
		//��ʽ3
		HSSFCellStyle cellStyle3 = wb.createCellStyle();  
		cellStyle3.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����    
		HSSFFont font3 = wb.createFont();    
		font3.setFontName("����");    
		font3.setFontHeightInPoints((short) 12);    
		cellStyle3.setFont(font3);//ѡ����Ҫ�õ��������ʽ  
		
		HSSFRow row3=sheet.createRow(2);
		HSSFCell row30=row3.createCell(0);    
		row30.setCellValue("��Ա");
		row30.setCellStyle(cellStyle3);
		HSSFCell row31=row3.createCell(1);    
		row31.setCellValue("��������(50)");
		row31.setCellStyle(cellStyle3);
		HSSFCell row32=row3.createCell(2);    
		row32.setCellValue("�����Ѷ�(10)");
		row32.setCellStyle(cellStyle3);
		HSSFCell row33=row3.createCell(3);    
		row33.setCellValue("��������(10)");
		row33.setCellStyle(cellStyle3);
		HSSFCell row34=row3.createCell(4);    
		row34.setCellValue("��ʾ����(10)");
		row34.setCellStyle(cellStyle3);
		HSSFCell row35=row3.createCell(5);    
		row35.setCellValue("���Ա��(10)");
		row35.setCellStyle(cellStyle3);
		HSSFCell row36=row3.createCell(6);    
		row36.setCellValue("�ش�����(10)");
		row36.setCellStyle(cellStyle3);
		HSSFCell row37=row3.createCell(7);    
		row37.setCellValue("�ܷ�(100)");
		row37.setCellStyle(cellStyle3);
		HSSFCell row38=row3.createCell(8);    
		row38.setCellValue("��ע");
		row38.setCellStyle(cellStyle3);
		//��ʽ4
		HSSFCellStyle cellStyle4 = wb.createCellStyle();  
		cellStyle4.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ���� 
		HSSFFont font4 = wb.createFont();   
		font4.setFontName("����");   
		cellStyle4.setFont(font4);//ѡ����Ҫ�õ��������ʽ  
		
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
			//1.�������ñ�ע�Ŀ�� (ָ���ĸ���Ԫ��)
			sheet.setColumnWidth(row48.getColumnIndex(),180 * 50);
	        try {
	        	row48.setCellValue(maps.get("DREMARK").toString());
			} catch (RuntimeException e) {
				row48.setCellValue("");
			}
			row48.setCellStyle(cellStyle4);
	        //��sheet�ﴴ����4��
		}

		//���������еĿ�
		sheet.setDefaultColumnWidth(13);
		//���Excel�ļ�
		try {
			//������������ C:\Users\Administrator\Desktop ����
			FileOutputStream output=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\"+classname+"��"+couname+"���ɼ�.xls");
			wb.write(output);
			output.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��ȥ��");
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
