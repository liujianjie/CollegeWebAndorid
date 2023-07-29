package com.ht.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ht.common.BaseAction;
import com.ht.service.ICaiwuService;
import com.ht.vo.Emp;
import com.ht.vo4.JiaoqingZhuangtai;

import com.ht.vo4.Salary;
import com.ht.vo4.Shouru;
import com.ht.vo4.Xuefei;
import com.ht.vo4.Zhichu;

public class CaiwuAction extends BaseAction {

	ICaiwuService ics = (ICaiwuService) getService("cService");

	private Shouru sh;

	private Zhichu zh;

	private Xuefei xu;
	
	
	//json
	private Float f;
	
	//��֤ѧ��
	private int yz;
	//���а༶
//	private List listAllClass;
	//����ѧ��ID
	private int stuid;
	
//	private int now_year;
//	private int now_month;
	
	//��֤Ա��
	private int yz_yg;
	
	

//����
	
	// ��ѯ�����б�
	public String shouru() {	//Ĭ�ϲ�ɸѡ
		
//		System.out.println("������shouru");
		
		List list = ics.shouru_list();
		System.out.println("����������size: "+list.size());
		 
		List list2 = ics.total_shouru();
		Map map = (Map)list2.get(0);

		ToRequest("list", list);
		ToRequest("map", map);
		return "totable1";
	}
	
	
	public String shouru1() {//��ʱ����ң�Ĭ�ϲ�ɸѡ��
		
//		System.out.println("������shouru1");
		HttpServletRequest req = ServletActionContext.getRequest();
		String f1=req.getParameter("ff1");
		String f2=req.getParameter("ff2");
		

		List list = ics.shouru_list1(f1,f2);
		System.out.println("size: "+list.size());
		 
//		List list2 = ics.total_shouru();
//		Map map = (Map)list2.get(0);

		ToRequest("list", list);
		
		int num1=Integer.parseInt(f1);
		int num2=Integer.parseInt(f2);
		ToRequest("num1", num1);
		ToRequest("num2", num2);
//		ToRequest("map", map);
		
		return "totable1";
	}
	
	public String shouru2() {//����Ŀ����
		
		 System.out.println("������shouru2");
		 HttpServletRequest req = ServletActionContext.getRequest();
		String f3=req.getParameter("ff3");

		List list = ics.shouru_list2(f3);
		System.out.println("size: "+list.size());
		 
//		List list2 = ics.total_shouru();
//		Map map = (Map)list2.get(0);

		ToRequest("list", list);
		
		int num3=Integer.parseInt(f3);
		ToRequest("num3", num3);
//		ToRequest("map", map);
		return "totable1";
	}

	
	// ����һ������
	public String add1() {
//		System.out.println("������add1");
		
		System.out.println("ʱ�䣺 "+sh.getShoufei_time().toLocaleString());
		
		
		Date d=sh.getShoufei_time();

		int d1=d.getYear()+1900;
		int d2=d.getMonth()+1;
		sh.setS_year(d1);
		sh.setS_month(d2);
		
//		String time=sh.getShoufei_time().toLocaleString();
//		String year=time.substring(0, 4);
//		String month=time.substring(5, 7);
//		System.out.println(year);
//		System.out.println(month);
//		sh.setS_year(Integer.parseInt(year));
//		sh.setS_month(Integer.parseInt(month));
//
//		Date d = new Date();
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = df.format(d);
		
//		Long syear=Long.parseLong(time.substring(0, 4));
//		Long smonth=Long.parseLong(time.substring(5, 7));
		
//		 SimpleDateFormat  sf  = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//		 Date dd;
//		try {
//			dd = sf.parse(time);
////			sh.setShouruTime(dd);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//
		boolean bln = ics.shouru_add(sh);
		if (bln) {
			System.out.println("��ӳɹ�");
		} else {
			System.out.println("���ʧ��");
		}
		return "flush_table1";
	
	}

	// "ȥ"�޸�һ������
	public String toupd1() {
		System.out.println("������aaaa");
		 HttpServletRequest req = ServletActionContext.getRequest();
		 String id=req.getParameter("id");
		Shouru shouru= ics.selShouruById(Integer.parseInt(id));
		
		ToRequest("shouru", shouru);
		return "to_upd1";
	}
//
	// �޸�һ������
	public String upd1() {
		System.out.println("����upd1..........");

		boolean bln = ics.shouru_upd(sh);
		if (bln) {
			System.out.println("�޸ĳɹ�");
		} else {
			System.out.println("�޸�ʧ��");
		}
		return "flush_table1";
	}
//
//	// ɾ��һ������
	public String del1() {
		System.out.println("����del");
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = req.getParameter("id");
		System.out.println("ɾ��id  "+id);
		Shouru shouru = ics.selShouruById((Integer.parseInt(id))); 
//
		boolean bln = ics.shouru_del(shouru);
		if (bln) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
		return "flush_table1";
	
	}

// ��ѯ֧��
	// ��ѯ֧���б�
	public String zhichu() {//��ɸѡ
//		System.out.println("������zhichu");
		List list = ics.zhichu_list();
		System.out.println("size: "+list.size());

		List list2 = ics.total_zhichu();
		// System.out.println("size: "+list.size());
		Map map = (Map)list2.get(0);

		ToRequest("list", list);
		ToRequest("map", map);
		return "totable2";
	}
	
	public String zhichu1() {//��ʱ�����
		
//		System.out.println("������zhichu1");
		HttpServletRequest req = ServletActionContext.getRequest();
		String f1=req.getParameter("ff1");
		String f2=req.getParameter("ff2");
		System.out.println(f1);
		System.out.println(f2);

		List list = ics.zhichu_list1(f1,f2);
		System.out.println("size: "+list.size());
		 
//		List list2 = ics.total_zhichu();
//		Map map = (Map)list2.get(0);

		ToRequest("list", list);
		
		int num1=Integer.parseInt(f1);
		int num2=Integer.parseInt(f2);
		
		ToRequest("num1", num1);
		ToRequest("num2", num2);
//		ToRequest("map", map);
		return "totable2";
	}
	
	public String zhichu2() {//����Ŀ����
		
//		 System.out.println("������zhichu2");
		 HttpServletRequest req = ServletActionContext.getRequest();
		String f3=req.getParameter("ff3");

		List list = ics.zhichu_list2(f3);
		System.out.println("size: "+list.size());
		 
//		List list2 = ics.total_zhichu();
//		Map map = (Map)list2.get(0);

		ToRequest("list", list);
		
		int num3=Integer.parseInt(f3);
		ToRequest("num3", num3);
//		ToRequest("map", map);
		return "totable2";
	}

	
	
	
	// ���һ��֧��
	public String add2() {
//		System.out.println("����add2");
		System.out.println("ʱ�䣺 "+zh.getZhichu_time().toLocaleString());
		
		Date d=zh.getZhichu_time();
		int d1=d.getYear()+1900;
		int d2=d.getMonth()+1;
		System.out.println("d1:  "+d1);
		System.out.println("d2:  "+d2);
		zh.setZ_year(d1);
		zh.setZ_month(d2);
		
		
		
		boolean bln = ics.zhichu_add(zh);
		if (bln) {
			System.out.println("��ӳɹ�2");
		} else {
			System.out.println("���ʧ��2");
		}
		return "flush_table2";
	
	}
//
//	// "ȥ"�޸�һ��֧��
	public String toupd2() {
		System.out.println("����toupd2");
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = req.getParameter("id");
		System.out.println(id);
		Zhichu zhichu = ics.selZhichuById(Integer.parseInt(id));
		ToRequest("zhichu", zhichu);
		return "to_upd2";
		
	}
//
//	// �޸�ĳ��֧��
	public String upd2() {
		System.out.println("����upd2");
		boolean bln = ics.zhichu_upd(zh);
		if (bln) {
			System.out.println("�޸ĳɹ�2");
		} else {
			System.out.println("�޸�ʧ��2");
		}
		return "flush_table2";
	
	}
//
//	// ɾ��ĳ��֧��
	public String del2() {
		System.out.println("����del2");
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = req.getParameter("id");
		Zhichu zhichu = ics.selZhichuById(Integer.parseInt(id));
		boolean bln = ics.zhichu_del(zhichu);
		if (bln) {
			System.out.println("ɾ���ɹ�2");
		} else {
			System.out.println("ɾ��ʧ��2");
		}
		return "flush_table2";
		
	}

	
	
// ��ѯѧ��
	
	//��ѯ���а༶
	public String findAllClass(){	
		System.out.println("������");
		
		List listAllClass=ics.selAllClass();
		System.out.println(listAllClass.size());
		ToRequest("listAllClass", listAllClass);
		return "toadd_xuefei";
	}
	
/*
 * 
 * */
	//��˰༶ѧ��
	public String selStuByClass(){	
		System.out.println("����������");
		
		HttpServletRequest req = ServletActionContext.getRequest();
		int cid=Integer.parseInt(req.getParameter("cid"));
		 st_list=ics.selStuByClass(cid);
		
		System.out.println("������: "+st_list.size());
		
		return "success";
	}
	//st_list
	private List st_list;
	
	
	//��ѧ���б�
	public String xuefei(){
//		System.out.println("������xuefei");
		
		List list1 = ics.xuefei_list();  	//��ѧ�ѽ��ɱ�
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String id1=req.getParameter("id1");
		String id2=req.getParameter("id2");
		System.out.println(id1);
		System.out.println(id2);
		
		List list2=ics.jiaoqing_list(id1, id2); //�����״̬��
		System.out.println("size:  "+list2.size());
		List list3=ics.selAllClass();	//��ѯ���а༶
		
		if(id1!=null&&id2!=null){
			int num1=Integer.parseInt(id1);
			int num2=Integer.parseInt(id2);
			ToRequest("num1", num1);
			ToRequest("num2", num2);
		}
		
//		System.out.println(num1+"aaaaaaaa");
//		System.out.println(num2+"bbbbbbbbb");
//		
		
		ToRequest("list1", list1);
		ToRequest("list2", list2);
		ToRequest("list3", list3);
		return "totable(xuefei)";
	}
	


	
// ����һ��ѧ��
	//��֤ѧ���Ƿ����
	public String yanzheng(){
		System.out.println("������%%%%%%%%%");
		HttpServletRequest req = ServletActionContext.getRequest();
		String id1=req.getParameter("id1");
		String id2=req.getParameter("id2");
		
		List list=ics.IsContainStu(id1, id2);
		
		
		if(list.size()==1){
			Map map=(Map)list.get(0);
			BigDecimal b=(BigDecimal)map.get("INTENID");
			 stuid=b.intValue();
			System.out.println(stuid+"...........");
			yz=1;
		}else if(list.size()==0){
			yz=0;
		}
		
		return "success";
	}
	
	
//���ѧ��
	public String xuefei_add() {
//		System.out.println("����............");

		// ��ѧ�ѱ����һ������
		Long id=xu.getStuid();
		
		List listStuname=ics.selStuName(id);
		Map map_name=(Map)listStuname.get(0);
		String stuname=map_name.get("INTENNAME").toString();
		System.out.println("ѧ������: "+stuname);
		xu.setStuname(stuname);		//����ѧ������
		
		List listStuclass=ics.selStuClass(id);
		Map map_class=(Map)listStuclass.get(0);
		String stuclass=map_class.get("CLASSNAME").toString();
		System.out.println("ѧ���༶: "+stuclass);
		xu.setStuclass(stuclass);	//����ѧ���༶
		
		boolean bln1 = ics.xuefei_add(xu);
		if (bln1) {
			System.out.println("ѧ����ӳɹ�");
		} else {
			System.out.println("ѧ�����ʧ��");
		}

		// ������������һ������
		System.out.println("ʱ�䣺 "+xu.getXuefeiTime().toLocaleString());
		Date d=xu.getXuefeiTime();
		int d1=d.getYear()+1900;
		int d2=d.getMonth()+1;
		System.out.println("d1:  "+d1);
		System.out.println("d2:  "+d2);
		
		Shouru shou = new Shouru();
		shou.setShoufei_xiangmu(0);
		shou.setShoufei_jine(xu.getJine());
		shou.setJingshouren(xu.getJingshouren());
		shou.setShoufei_time(d);
		shou.setS_year(d1);
		shou.setS_month(d2);
		
		boolean bln2 = ics.shouru_add(shou);
		if (bln2) {
			System.out.println("������ӳɹ�");
		} else {
			System.out.println("�������ʧ��");
		}

		// �Ƿ�Ҫ������״̬�� ����/��������

		List list3 = ics.selCount(xu.getStuid(), xu.getXueqiId());
		Map map1 = (Map) list3.get(0);
		BigDecimal b1 = (BigDecimal) map1.get("SUM_COUNT");
		Float f1 = b1.floatValue();
		System.out.println(f1 + "   ����������������");

		// ���ܽɷ�
		List list = ics.selXueqiJiaofei(xu.getStuid(), xu.getXueqiId());
		Map map2 = (Map) list.get(0);
		BigDecimal b2 = (BigDecimal) map2.get("SUM_JINE");
		Float f2 = b2.floatValue();

		System.out.println(f2 + "@@@@@@");

		if (f1 == 0) {   //�޽ɷѼ�¼
			if (xu.getXueqiId() == 1) {
				if (f2 < 10000) {
					System.out.println("to here");
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("δ����");

					boolean bln3 = ics.jiaoqing_add(jiao);
					if (bln3) {
						System.out.println("������ӳɹ�");
					} else {
						System.out.println("�������ʧ��");

					}

				} else {
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("�ѽ���");

					boolean bln4 = ics.jiaoqing_add(jiao);
					if (bln4) {
						System.out.println("����2��ӳɹ�");
					} else {
						System.out.println("����2���ʧ��");

					}
				}
				
			} else if (xu.getXueqiId() == 2) {
				if (f2 < 7800) {
					System.out.println("to here");
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("δ����");

					boolean bln3 = ics.jiaoqing_add(jiao);
					if (bln3) {
						System.out.println("������ӳɹ�");
					} else {
						System.out.println("�������ʧ��");

					}

				} else {
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("�ѽ���");

					boolean bln4 = ics.jiaoqing_add(jiao);
					if (bln4) {
						System.out.println("����2��ӳɹ�");
					} else {
						System.out.println("����2���ʧ��");

					}
				}
				
			} else {
				if (f2 < 8800) {
					System.out.println("to here");
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("δ����");

					boolean bln3 = ics.jiaoqing_add(jiao);
					if (bln3) {
						System.out.println("������ӳɹ�");
					} else {
						System.out.println("�������ʧ��");

					}

				} else {
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("�ѽ���");

					boolean bln4 = ics.jiaoqing_add(jiao);
					if (bln4) {
						System.out.println("����2��ӳɹ�");
					} else {
						System.out.println("����2���ʧ��");

					}
				}
			}

		} else { //�нɷѼ�¼

			if (xu.getXueqiId() == 1) {
				if (f2 >= 10000) {

					boolean bln5 = ics.jiaoqingstatus_upd(xu.getStuid(), xu
							.getXueqiId());
					if (bln5) {
						System.out.println("����3��ӳɹ�");
					} else {
						System.out.println("����3���ʧ��");

					}
				}
				
			} else if (xu.getXueqiId() == 2) {
				if (f2 >= 7800) {

					boolean bln5 = ics.jiaoqingstatus_upd(xu.getStuid(), xu
							.getXueqiId());
					if (bln5) {
						System.out.println("����3��ӳɹ�");
					} else {
						System.out.println("����3���ʧ��");

					}
				}
				
			}else{
				if (f2 >= 8800) {

					boolean bln5 = ics.jiaoqingstatus_upd(xu.getStuid(), xu
							.getXueqiId());
					if (bln5) {
						System.out.println("����3��ӳɹ�");
					} else {
						System.out.println("����3���ʧ��");

					}
				}
			}

		}

		return "flush_table(xuefei)";
	}
	
	
	/*
	 * 
	 * */
	
	//��ԃ���¹���
	public String selSalay(){
		System.out.println("������selSalay");
		
		//��ȡϵͳ��ǰʱ��
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		System.out.println("ϵͳʱ�䣺"+time);
		
		String year=time.substring(0, 4);
		String month=time.substring(5, 7);
		System.out.println("��ݣ�"+year);
		System.out.println("�·ݣ�"+month);
//		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			Date dd=dft.parse(time);
//			int d1=dd.getYear()+1990;
//			int m1=dd.getMonth()+1;
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String id1=req.getParameter("id1");
		String id2=req.getParameter("id2");
//		System.out.println("id1== "+id1);
//		System.out.println("id2== "+id2);
		
		if(id1==null&&id2==null){
			
			ToRequest("num1", year);
			ToRequest("num2", month);
			List list=ics.selSalaryList(year, month);
			ToRequest("list", list);
		}
		
		
		if(id1!=null&&id2!=null){
			int num1=Integer.parseInt(id1);
			int num2=Integer.parseInt(id2);
			ToRequest("num1", num1);
			ToRequest("num2", num2);
			List list=ics.selSalaryList(id1, id2);
			ToRequest("list", list);
		}
		
		
		
		return "tosalary";
	}
	
	//����ҳ���ѯ
	public String selSalay2(){
		System.out.println("������selSalay");
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String id1=req.getParameter("id1");
		String id2=req.getParameter("id2");
//		System.out.println("id1== "+id1);
//		System.out.println("id2== "+id2);
		
		List list=ics.selSalaryList(id1, id2);
		
		if(id1!=null&&id2!=null){
			int num1=Integer.parseInt(id1);
			int num2=Integer.parseInt(id2);
			ToRequest("num1", num1);
			ToRequest("num2", num2);
		}
		
		ToRequest("list", list);
		
		return "tosalary_xiangxi";
	}
	
	//�鿴��������
	public String selSalay_xiangxi(){
		System.out.println("������selSalay_xiangxi");
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String id1=req.getParameter("id1");
		String id2=req.getParameter("id2");
		
		List list=ics.selSalaryList(id1, id2);
		
		ToRequest("list", list);
		
		return "tosalary_xiangxi";
	}
	
	//ȥ���ҳ��
	public String toadd_salary(){
		System.out.println("����toadd_salary");
		List list=ics.selAllEmpName();
		ToRequest("list", list);
		return "salary_add";
	}
	
	

	
	
//�ֲ�ˢ��1
	public String selByYear(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String year=req.getParameter("id");
		System.out.println("��ݣ� "+year);
		List list=ics.selMoneyByYear(year);
		Map map=(Map)list.get(0);
		BigDecimal b=(BigDecimal)map.get("SUM_YEAR");
		f=b.floatValue();
		System.out.println("�ܶ "+f);

		return "success";
	}
////�ֲ�ˢ��2
	public String selByYearMonth(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String year=req.getParameter("id1");
		String month=req.getParameter("id2");

		List list=ics.selMoneyByYearMonth(year,month);
		Map map=(Map)list.get(0);
		BigDecimal b=(BigDecimal)map.get("SUM_YEAR");
		f=b.floatValue();
		System.out.println("�ܶ "+f);

		return "success";
	}
	
////�ֲ�ˢ��11
	public String selByYear2(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String year=req.getParameter("id");
		System.out.println("��ݣ� "+year);
		List list=ics.selMoneyByYear2(year);
		Map map=(Map)list.get(0);
		BigDecimal b=(BigDecimal)map.get("SUM_YEAR");
		f=b.floatValue();
		System.out.println("�ܶ "+f);

		return "success";
	}
////�ֲ�ˢ��22
	public String selByYearMonth2(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String year=req.getParameter("id1");
		String month=req.getParameter("id2");

		List list=ics.selMoneyByYearMonth2(year,month);
		Map map=(Map)list.get(0);
		BigDecimal b=(BigDecimal)map.get("SUM_YEAR");
		f=b.floatValue();
		System.out.println("�ܶ "+f);

		return "success";
	}
	

	
	
	
	public Shouru getSh() {
		return sh;
	}

	public void setSh(Shouru sh) {
		this.sh = sh;
	}

	public Zhichu getZh() {
		return zh;
	}

	public void setZh(Zhichu zh) {
		this.zh = zh;
	}

	public Xuefei getXu() {
		return xu;
	}

	public void setXu(Xuefei xu) {
		this.xu = xu;
	}


	


	public Float getF() {
		return f;
	}


	public void setF(Float f) {
		this.f = f;
	}


	public int getYz() {
		return yz;
	}


	public void setYz(int yz) {
		this.yz = yz;
	}


	public int getStuid() {
		return stuid;
	}


	public void setStuid(int stuid) {
		this.stuid = stuid;
	}


	public int getYz_yg() {
		return yz_yg;
	}


	public void setYz_yg(int yz_yg) {
		this.yz_yg = yz_yg;
	}


	


//	public List getListAllClass() {
//		return listAllClass;
//	}
//
//
//	public void setListAllClass(List listAllClass) {
//		this.listAllClass = listAllClass;
//	}
	
	//ֵ���
	private List zblist;
	public List getZblist() {
		return zblist;
	}


	public void setZblist(List zblist) {
		this.zblist = zblist;
	} 
	
	//֪ͨ
	private List tzlist;
	public List getTzlist() {
		return tzlist;
	}


	public void setTzlist(List tzlist) {
		this.tzlist = tzlist;
	}
	
	//ͨѶ¼
	private List phonelist;
	public List getPhonelist() {
		return phonelist;
	}
	
	public void setPhonelist(List phonelist) {
		this.phonelist = phonelist;
	}
	
	//ѧ�����
	private List yjlist;


	
	
	//�����ҳ����
	private int pageCount;
	private int pageCount2;
	private int currPage;
	private int totalCount;
	private int totalPage;
	
	//��ѯֵ���
	public String info(){
		 pageCount=6;
		 pageCount2=5;
		 currPage=1;
		 totalCount= ics.countZhiban();
		 totalPage=(totalCount+pageCount-1)/pageCount;
		 System.out.println("��ҳ����"+totalPage);
		 
		 HttpServletRequest req = ServletActionContext.getRequest();
		 String cpage=req.getParameter("cpage");
		 String pcount=req.getParameter("pcount");
		 if(cpage!=null&&pcount!=null){
			 currPage=Integer.parseInt(cpage);
			 pageCount=Integer.parseInt(pcount);
		 }
		 if(currPage<1){
			 currPage=1;
		 }
		 if(currPage>totalPage){
			 currPage=totalPage;
		 }
		//��ֵ��
		 zblist=ics.selZhiban(currPage,pageCount);
		 System.out.println("size:" +zblist.size());
		//�鷢��֪ͨ
		 tzlist=ics.selTongzhi();
		 //��ͨѶ¼
		 phonelist=ics.selTel(currPage,pageCount2);
		 //��ѧ�����
		 yjlist=ics.yijianlistpage(0, 8);
		 System.out.println("���size:"+yjlist.size());
		 
		return "success";
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getCurrPage() {
		return currPage;
	}


	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPageCount2() {
		return pageCount2;
	}


	public void setPageCount2(int pageCount2) {
		this.pageCount2 = pageCount2;
	}


	public List getYjlist() {
		return yjlist;
	}


	public void setYjlist(List yjlist) {
		this.yjlist = yjlist;
	}


	//��ԃ���¹���
//	public String selectSalary(){
//		System.out.println("������selSalay");
//		
//		//��ȡϵͳ��ǰʱ��
//		Date d = new Date();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = df.format(d);
//		System.out.println("ϵͳʱ�䣺"+time);
//		
//		String year=time.substring(0, 4);
//		String month=time.substring(5, 7);
//		System.out.println("��ݣ�"+year);
//		System.out.println("�·ݣ�"+month);
////		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		try {
////			Date dd=dft.parse(time);
////			int d1=dd.getYear()+1990;
////			int m1=dd.getMonth()+1;
////			
////		} catch (ParseException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		
//		
//		ToRequest("year", year);
//		ToRequest("month", month);
//		
//		List list=ics.selAllEmp();
//		//Emp e=(Emp)list.get(0);
//		//System.out.println(e.getEid());
//		ToRequest("list", list);
//		
//		return "tosalary";
//	}
	
	//���ʷ������
	public String salarylist(){
		System.out.println("����salarylist");
		
		// ��ȡϵͳ��ǰʱ��
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		System.out.println("ϵͳʱ�䣺" + time);
		
		String year = time.substring(0, 4);
		String month = time.substring(5, 7);
		
		
		int ye=Integer.parseInt(year);
		int mo=Integer.parseInt(month)-1;
		System.out.println("��ݣ�" + ye);
		System.out.println("�·ݣ�" + mo);
		
		ToRequest("ye", ye);
		ToRequest("mo", mo);
		
		return "slist";
	}
	
	//�����¹��ʷ������
	public String selLastMonthInfo(){
		System.out.println("������selLastMonthInfo");
		HttpServletRequest req = ServletActionContext.getRequest();
		int y=Integer.parseInt(req.getParameter("year"));
		int m=Integer.parseInt(req.getParameter("month"));
		 lastmonth_list=ics.selSalaryJiesuan(y, m);
		System.out.println("size:  "+lastmonth_list.size());
		return "success";
	}
	//last month
	private List lastmonth_list;
	public List getLastmonth_list() {
		return lastmonth_list;
	}
	public void setLastmonth_list(List lastmonth_list) {
		this.lastmonth_list = lastmonth_list;
	}
	
	//�б�ҳ�水ʱ��ɸѡ
	public String selSalaryByTime(){
		System.out.println("������selLastMonthInfo");
		HttpServletRequest req = ServletActionContext.getRequest();
		int y=Integer.parseInt(req.getParameter("year"));
		int m=Integer.parseInt(req.getParameter("month"));
		bytime_list=ics.selSalaryJiesuan(y, m);
		return "success";
	}
	//bytime_list
	private List bytime_list;
	public List getBytime_list() {
		return bytime_list;
	}
	public void setBytime_list(List bytime_list) {
		this.bytime_list = bytime_list;
	}
	
	
//����Ա���б�
	public String selectSalary2() {

		System.out.println("������selectSalary2");
		HttpServletRequest req = ServletActionContext.getRequest();
		
		System.out.println("��  "+req.getParameter("y"));
		System.out.println("��  "+req.getParameter("m"));
		
		int y=Integer.parseInt(req.getParameter("y"));
		int m=Integer.parseInt(req.getParameter("m"));
		//��֤�����Ƿ����
		int num=ics.isJiesuan(y, m);
		if(num==0){
			System.out.println("����û�н���");
			n=0;
		}else{
			
			System.out.println("�����Ѿ�����");
			n=1;
		}
		
		String id = req.getParameter("id");
		System.out.println(id);
		
		// ������Ա��������ְ�񡢵�н�����ڲ����Լ����¿�������
		salary_list = ics.selSalaryInfo(id);

		return "success";
	}
	
	//�Ƿ����
	private int n;
	
	//����Ա��������Ϣ
	private List salary_list;

	public List getSalary_list() {
		return salary_list;
	}

	public void setSalary_list(List salary_list) {
		this.salary_list = salary_list;
	}
	
	
// ���㹤��
	public String count_salary() {
		System.out.println("���˺�̨");
		HttpServletRequest req = ServletActionContext.getRequest();
		String str = req.getParameter("id");
		System.out.println(str);
		String[] s = str.split(",");
		String eid = s[0];
		
		// ���н����������
		List listEmp = ics.selSalaryInfo(eid);
		Map map = (Map) listEmp.get(0);
		
		String dname=map.get("SALARY_DNAME").toString();	//����
		
		String ename=map.get("SALARY_ENAME").toString();	//����
		
		String jwork=map.get("SALARY_JWORK").toString();	//ְ��
		
		BigDecimal b1 = (BigDecimal) map.get("SALARY_MONEY");
		float dixin = b1.floatValue(); 		// ��н
		
		System.out.println("���ţ� "+dname);
		System.out.println("������ "+ename);
		System.out.println("ְ�� "+jwork);
		System.out.println("��н��" + dixin);

		String y = req.getParameter("y");
		String m = req.getParameter("m");
		String t_k = req.getParameter("ipt_k");
		String t1 = req.getParameter("ipt1");
		String t2 = req.getParameter("ipt2");
		String t3 = req.getParameter("ipt3");
		String t4 = req.getParameter("ipt4");
		String t5 = req.getParameter("ipt5");
		
		System.out.println("y: "+y);
		System.out.println("m: "+m);
		System.out.println("����t_k:" + t_k);
		System.out.println("t1:" + t1);
//		System.out.println("t2:" + t2);
//		System.out.println("t3:" + t3);
//		System.out.println("t4:" + t4);
//		System.out.println("t5:" + t5);
		
		//�������� ����
		int kh=Integer.parseInt(t_k);	
		
		int a=0;
		if(!t1.equals("")){
			a = Integer.parseInt(t1); // ���¼�
		}
		
		int b=0;
		if(!t2.equals("")){
			b = Integer.parseInt(t2);   // 	δ����
		}

		float c=0;
		if(!t3.equals("")){
			c = Float.parseFloat(t3);   // Υ�ͷ���
		}
		
		float d=0;
		if(!t4.equals("")){
			d = Float.parseFloat(t4);   // �ٵ�����
		}
		
		float e=0;
		if(!t5.equals("")){
			e = Float.parseFloat(t5);   // ��������
		}
	
	
//		System.out.println("����:" + kh+"��");
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
		System.out.println("d:" + d);
		System.out.println("e:" + e);

		
	//			f	   f    f       i         i   i     f   f
		 float sum= dixin + e -(dixin / kh) * ( a + b) -( c + d );
		
		 BigDecimal bd=new BigDecimal(sum);
		  ft =bd.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
		  System.out.println("�ܹ��ʣ� "+ft);
		  
		  //�����ʱ�����Ա���Ĺ�����Ϣ
		  Salary sy=new Salary();	
		  
//		  System.out.println("���е�����");
//		  
		  sy.setEmpid(Long.parseLong(eid));
		  sy.setDname(dname);
		  sy.setEname(ename);
		  sy.setJwork(jwork);
		  sy.setDixin(dixin);
		  sy.setKaoheN((Long.parseLong(t_k)));
		  sy.setBingshijiaN(Long.parseLong(a+""));
		  sy.setWeichuqinN(Long.parseLong(b+""));
		  sy.setWeijiF(c);
		  sy.setChidaoF(d);
		  sy.setOtherSalary(e);
		  sy.setYear(Long.parseLong(y));
		  sy.setMonth(Long.parseLong(m));
		  sy.setTotalSalary(ft);
		  Emp emp=(Emp)fromSession("teacher");
		  if(emp==null){
			  System.out.println("δ��¼");
		  }
		  sy.setPerson(emp.getEname());
		
		  sy.setStatus("δ����");
		  
//		  System.out.println("***********");
		  
		  boolean bln=ics.addSalaryEachEmp(sy);
		  if(bln){
			  System.out.println("��ӳɹ�");
			  sta2=1;
		  }else{
			  System.out.println("���ʧ��");
		  }
		  
		 return "success";
	}
	
	//�ж��Ƿ����ɹ�
	private int sta2;
	public int getSta2() {
		return sta2;
	}

	public void setSta2(int sta2) {
		this.sta2 = sta2;
	}
	
	
	//json ���� �ܹ���
	private float ft;
	public float getFt() {
		return ft;
	}

	public void setFt(float ft) {
		this.ft = ft;
	}
	
	
	

	
//ȥ����ҳ��
	public String fafang(){
		 
		 System.out.println("����fafang");
		
		return "flist";
	}
	
//���ط��Ź����б�
	public String fafanglist(){
		
		System.out.println("����fafanglist");
		
		HttpServletRequest req = ServletActionContext.getRequest();
		int y=Integer.parseInt(req.getParameter("year"));
		int m=Integer.parseInt(req.getParameter("month"));
		
		list_jiesuan=ics.selSalaryJiesuan(y,m); //������˵�
		
		return "success";
	}
	//list
	private List list_jiesuan;

	public List getList_jiesuan() {
		return list_jiesuan;
	}


	public void setList_jiesuan(List list_jiesuan) {
		this.list_jiesuan = list_jiesuan;
	}
	
	
//�ķ���״̬
	public String updFafang(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String id=req.getParameter("id");
		System.out.println("ID��ֵ�� "+id);
		String []s=id.split(",");
		int eid=Integer.parseInt(s[0]);
		int y=Integer.parseInt(s[1]);
		int m=Integer.parseInt(s[2]);
		
		System.out.println("eid: "+eid);
		System.out.println("y: "+y);
		System.out.println("m: "+m);
		
		boolean bln=ics.updFafangStatus(eid, y, m);
		if(bln){
			  System.out.println("���ĳɹ�");
			  sta=1;
		 }else{
			  System.out.println("����ʧ��");
		 }
		
	//��֧�������������
		
		//��ȡϵͳʱ��
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		
		System.out.println("ϵͳʱ�� : "+time);
		
		int year = Integer.parseInt(time.substring(0, 4));
		int month = Integer.parseInt(time.substring(5, 7));
		System.out.println("�꣺ "+year);
		System.out.println("�£� "+month);
		
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd;
		try {
			 dd=dft.parse(time);
			 
			Zhichu zhi=new Zhichu();
			zhi.setZhichu_xiangmu(0);
			//���֧�����
			List ff_list=ics.selFangfaJine(eid, y, m);
			Map map=(Map)ff_list.get(0);
			BigDecimal b=(BigDecimal)map.get("TOTAL_SALARY");
			float f=b.floatValue();
			System.out.println("֧���� "+f);
			
			zhi.setZhichu_jine(f);
			//������
			Emp emp=(Emp)fromSession("teacher");
			zhi.setJingshouren(emp.getEname());
				
			zhi.setZhichu_time(dd);
			
			zhi.setZ_year(year);
			zhi.setZ_month(month);
			//���֧��
			boolean bln2=ics.zhichu_add(zhi);
			if(bln2){
				  System.out.println("֧����������ݳɹ�");
				  
			 }else{
				  System.out.println("֧�����������ʧ��");
			 }
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "success";
	}
	
	//�ж��Ƿ񷢷ųɹ�
	private int sta;
	public int getSta() {
		return sta;
	}


	public void setSta(int sta) {
		this.sta = sta;
	}

	//��Ա����н
	public String selDixin(){
		System.out.println("���н��");
		HttpServletRequest req = ServletActionContext.getRequest();
		String eid=req.getParameter("id");
		if(eid==null){
			System.out.println("������null");
		}
		dixin_list=ics.selSalaryInfo(eid);
		return "success";
	}
	//dixin_list
	private List dixin_list;
	public List getDixin_list() {
		return dixin_list;
	}
	public void setDixin_list(List dixin_list) {
		this.dixin_list = dixin_list;
	}
	
	//�޸ĵ�н
	public String updDixin(){
		System.out.println("��������");
		HttpServletRequest req = ServletActionContext.getRequest();
		int eid=Integer.parseInt(req.getParameter("eid"));
		float money=Float.parseFloat(req.getParameter("dixin"));
		
		boolean bln=ics.updEmpDixin(eid, money);
		if(bln){
			  System.out.println("���ĵ�н�ɹ�");
			  sta3=1;
		  }else{
			  System.out.println("���ĵ�нʧ��");
			  sta3=0;
		  }
		
		return "success";
	}
	//��н�޸�״̬
	private int sta3;
	public int getSta3() {
		return sta3;
	}
	public void setSta3(int sta3) {
		this.sta3 = sta3;
	}


	public List getSt_list() {
		return st_list;
	}


	public void setSt_list(List st_list) {
		this.st_list = st_list;
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}

	
	
}
