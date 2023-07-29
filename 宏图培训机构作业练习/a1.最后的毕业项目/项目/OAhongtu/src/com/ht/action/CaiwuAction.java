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
	
	//验证学生
	private int yz;
	//所有班级
//	private List listAllClass;
	//返回学生ID
	private int stuid;
	
//	private int now_year;
//	private int now_month;
	
	//验证员工
	private int yz_yg;
	
	

//收入
	
	// 查询收入列表
	public String shouru() {	//默认不筛选
		
//		System.out.println("进来了shouru");
		
		List list = ics.shouru_list();
		System.out.println("收入表的数据size: "+list.size());
		 
		List list2 = ics.total_shouru();
		Map map = (Map)list2.get(0);

		ToRequest("list", list);
		ToRequest("map", map);
		return "totable1";
	}
	
	
	public String shouru1() {//按时间查找（默认不筛选）
		
//		System.out.println("进来了shouru1");
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
	
	public String shouru2() {//按项目查找
		
		 System.out.println("进来了shouru2");
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

	
	// 新增一笔收入
	public String add1() {
//		System.out.println("进来了add1");
		
		System.out.println("时间： "+sh.getShoufei_time().toLocaleString());
		
		
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
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		return "flush_table1";
	
	}

	// "去"修改一笔收入
	public String toupd1() {
		System.out.println("进来了aaaa");
		 HttpServletRequest req = ServletActionContext.getRequest();
		 String id=req.getParameter("id");
		Shouru shouru= ics.selShouruById(Integer.parseInt(id));
		
		ToRequest("shouru", shouru);
		return "to_upd1";
	}
//
	// 修改一笔收入
	public String upd1() {
		System.out.println("进了upd1..........");

		boolean bln = ics.shouru_upd(sh);
		if (bln) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
		return "flush_table1";
	}
//
//	// 删除一笔收入
	public String del1() {
		System.out.println("进了del");
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = req.getParameter("id");
		System.out.println("删除id  "+id);
		Shouru shouru = ics.selShouruById((Integer.parseInt(id))); 
//
		boolean bln = ics.shouru_del(shouru);
		if (bln) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "flush_table1";
	
	}

// 查询支出
	// 查询支出列表
	public String zhichu() {//不筛选
//		System.out.println("进来了zhichu");
		List list = ics.zhichu_list();
		System.out.println("size: "+list.size());

		List list2 = ics.total_zhichu();
		// System.out.println("size: "+list.size());
		Map map = (Map)list2.get(0);

		ToRequest("list", list);
		ToRequest("map", map);
		return "totable2";
	}
	
	public String zhichu1() {//按时间查找
		
//		System.out.println("进来了zhichu1");
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
	
	public String zhichu2() {//按项目查找
		
//		 System.out.println("进来了zhichu2");
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

	
	
	
	// 添加一笔支出
	public String add2() {
//		System.out.println("进了add2");
		System.out.println("时间： "+zh.getZhichu_time().toLocaleString());
		
		Date d=zh.getZhichu_time();
		int d1=d.getYear()+1900;
		int d2=d.getMonth()+1;
		System.out.println("d1:  "+d1);
		System.out.println("d2:  "+d2);
		zh.setZ_year(d1);
		zh.setZ_month(d2);
		
		
		
		boolean bln = ics.zhichu_add(zh);
		if (bln) {
			System.out.println("添加成功2");
		} else {
			System.out.println("添加失败2");
		}
		return "flush_table2";
	
	}
//
//	// "去"修改一笔支出
	public String toupd2() {
		System.out.println("进了toupd2");
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = req.getParameter("id");
		System.out.println(id);
		Zhichu zhichu = ics.selZhichuById(Integer.parseInt(id));
		ToRequest("zhichu", zhichu);
		return "to_upd2";
		
	}
//
//	// 修改某笔支出
	public String upd2() {
		System.out.println("进了upd2");
		boolean bln = ics.zhichu_upd(zh);
		if (bln) {
			System.out.println("修改成功2");
		} else {
			System.out.println("修改失败2");
		}
		return "flush_table2";
	
	}
//
//	// 删除某笔支出
	public String del2() {
		System.out.println("进了del2");
		HttpServletRequest req = ServletActionContext.getRequest();
		String id = req.getParameter("id");
		Zhichu zhichu = ics.selZhichuById(Integer.parseInt(id));
		boolean bln = ics.zhichu_del(zhichu);
		if (bln) {
			System.out.println("删除成功2");
		} else {
			System.out.println("删除失败2");
		}
		return "flush_table2";
		
	}

	
	
// 查询学费
	
	//查询所有班级
	public String findAllClass(){	
		System.out.println("进来了");
		
		List listAllClass=ics.selAllClass();
		System.out.println(listAllClass.size());
		ToRequest("listAllClass", listAllClass);
		return "toadd_xuefei";
	}
	
/*
 * 
 * */
	//查此班级学生
	public String selStuByClass(){	
		System.out.println("进来了这里");
		
		HttpServletRequest req = ServletActionContext.getRequest();
		int cid=Integer.parseInt(req.getParameter("cid"));
		 st_list=ics.selStuByClass(cid);
		
		System.out.println("数据量: "+st_list.size());
		
		return "success";
	}
	//st_list
	private List st_list;
	
	
	//查学费列表
	public String xuefei(){
//		System.out.println("进来了xuefei");
		
		List list1 = ics.xuefei_list();  	//查学费缴纳表
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String id1=req.getParameter("id1");
		String id2=req.getParameter("id2");
		System.out.println(id1);
		System.out.println(id2);
		
		List list2=ics.jiaoqing_list(id1, id2); //查缴清状态表
		System.out.println("size:  "+list2.size());
		List list3=ics.selAllClass();	//查询所有班级
		
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
	


	
// 新增一笔学费
	//验证学生是否存在
	public String yanzheng(){
		System.out.println("进来了%%%%%%%%%");
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
	
	
//添加学费
	public String xuefei_add() {
//		System.out.println("进了............");

		// 往学费表插入一条数据
		Long id=xu.getStuid();
		
		List listStuname=ics.selStuName(id);
		Map map_name=(Map)listStuname.get(0);
		String stuname=map_name.get("INTENNAME").toString();
		System.out.println("学生姓名: "+stuname);
		xu.setStuname(stuname);		//保存学生姓名
		
		List listStuclass=ics.selStuClass(id);
		Map map_class=(Map)listStuclass.get(0);
		String stuclass=map_class.get("CLASSNAME").toString();
		System.out.println("学生班级: "+stuclass);
		xu.setStuclass(stuclass);	//保存学生班级
		
		boolean bln1 = ics.xuefei_add(xu);
		if (bln1) {
			System.out.println("学费添加成功");
		} else {
			System.out.println("学费添加失败");
		}

		// 往收入表里插入一条数据
		System.out.println("时间： "+xu.getXuefeiTime().toLocaleString());
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
			System.out.println("收入添加成功");
		} else {
			System.out.println("收入添加失败");
		}

		// 是否要往缴清状态表 插入/更改数据

		List list3 = ics.selCount(xu.getStuid(), xu.getXueqiId());
		Map map1 = (Map) list3.get(0);
		BigDecimal b1 = (BigDecimal) map1.get("SUM_COUNT");
		Float f1 = b1.floatValue();
		System.out.println(f1 + "   。。。。。。。。");

		// 查总缴费
		List list = ics.selXueqiJiaofei(xu.getStuid(), xu.getXueqiId());
		Map map2 = (Map) list.get(0);
		BigDecimal b2 = (BigDecimal) map2.get("SUM_JINE");
		Float f2 = b2.floatValue();

		System.out.println(f2 + "@@@@@@");

		if (f1 == 0) {   //无缴费记录
			if (xu.getXueqiId() == 1) {
				if (f2 < 10000) {
					System.out.println("to here");
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("未缴清");

					boolean bln3 = ics.jiaoqing_add(jiao);
					if (bln3) {
						System.out.println("缴清添加成功");
					} else {
						System.out.println("缴清添加失败");

					}

				} else {
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("已缴清");

					boolean bln4 = ics.jiaoqing_add(jiao);
					if (bln4) {
						System.out.println("缴清2添加成功");
					} else {
						System.out.println("缴清2添加失败");

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
					
					jiao.setStatus("未缴清");

					boolean bln3 = ics.jiaoqing_add(jiao);
					if (bln3) {
						System.out.println("缴清添加成功");
					} else {
						System.out.println("缴清添加失败");

					}

				} else {
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("已缴清");

					boolean bln4 = ics.jiaoqing_add(jiao);
					if (bln4) {
						System.out.println("缴清2添加成功");
					} else {
						System.out.println("缴清2添加失败");

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
					
					jiao.setStatus("未缴清");

					boolean bln3 = ics.jiaoqing_add(jiao);
					if (bln3) {
						System.out.println("缴清添加成功");
					} else {
						System.out.println("缴清添加失败");

					}

				} else {
					JiaoqingZhuangtai jiao = new JiaoqingZhuangtai();
					jiao.setStuid(xu.getStuid());
					jiao.setXueqiId(xu.getXueqiId());
					
					jiao.setStuname(xu.getStuname());
					jiao.setStuclass(xu.getStuclass());
					
					jiao.setStatus("已缴清");

					boolean bln4 = ics.jiaoqing_add(jiao);
					if (bln4) {
						System.out.println("缴清2添加成功");
					} else {
						System.out.println("缴清2添加失败");

					}
				}
			}

		} else { //有缴费记录

			if (xu.getXueqiId() == 1) {
				if (f2 >= 10000) {

					boolean bln5 = ics.jiaoqingstatus_upd(xu.getStuid(), xu
							.getXueqiId());
					if (bln5) {
						System.out.println("缴清3添加成功");
					} else {
						System.out.println("缴清3添加失败");

					}
				}
				
			} else if (xu.getXueqiId() == 2) {
				if (f2 >= 7800) {

					boolean bln5 = ics.jiaoqingstatus_upd(xu.getStuid(), xu
							.getXueqiId());
					if (bln5) {
						System.out.println("缴清3添加成功");
					} else {
						System.out.println("缴清3添加失败");

					}
				}
				
			}else{
				if (f2 >= 8800) {

					boolean bln5 = ics.jiaoqingstatus_upd(xu.getStuid(), xu
							.getXueqiId());
					if (bln5) {
						System.out.println("缴清3添加成功");
					} else {
						System.out.println("缴清3添加失败");

					}
				}
			}

		}

		return "flush_table(xuefei)";
	}
	
	
	/*
	 * 
	 * */
	
	//查詢当月工资
	public String selSalay(){
		System.out.println("进来了selSalay");
		
		//获取系统当前时间
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		System.out.println("系统时间："+time);
		
		String year=time.substring(0, 4);
		String month=time.substring(5, 7);
		System.out.println("年份："+year);
		System.out.println("月份："+month);
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
	
	//详情页面查询
	public String selSalay2(){
		System.out.println("进来了selSalay");
		
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
	
	//查看工资详情
	public String selSalay_xiangxi(){
		System.out.println("进来了selSalay_xiangxi");
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String id1=req.getParameter("id1");
		String id2=req.getParameter("id2");
		
		List list=ics.selSalaryList(id1, id2);
		
		ToRequest("list", list);
		
		return "tosalary_xiangxi";
	}
	
	//去添加页面
	public String toadd_salary(){
		System.out.println("进了toadd_salary");
		List list=ics.selAllEmpName();
		ToRequest("list", list);
		return "salary_add";
	}
	
	

	
	
//局部刷新1
	public String selByYear(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String year=req.getParameter("id");
		System.out.println("年份： "+year);
		List list=ics.selMoneyByYear(year);
		Map map=(Map)list.get(0);
		BigDecimal b=(BigDecimal)map.get("SUM_YEAR");
		f=b.floatValue();
		System.out.println("总额： "+f);

		return "success";
	}
////局部刷新2
	public String selByYearMonth(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String year=req.getParameter("id1");
		String month=req.getParameter("id2");

		List list=ics.selMoneyByYearMonth(year,month);
		Map map=(Map)list.get(0);
		BigDecimal b=(BigDecimal)map.get("SUM_YEAR");
		f=b.floatValue();
		System.out.println("总额： "+f);

		return "success";
	}
	
////局部刷新11
	public String selByYear2(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String year=req.getParameter("id");
		System.out.println("年份： "+year);
		List list=ics.selMoneyByYear2(year);
		Map map=(Map)list.get(0);
		BigDecimal b=(BigDecimal)map.get("SUM_YEAR");
		f=b.floatValue();
		System.out.println("总额： "+f);

		return "success";
	}
////局部刷新22
	public String selByYearMonth2(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String year=req.getParameter("id1");
		String month=req.getParameter("id2");

		List list=ics.selMoneyByYearMonth2(year,month);
		Map map=(Map)list.get(0);
		BigDecimal b=(BigDecimal)map.get("SUM_YEAR");
		f=b.floatValue();
		System.out.println("总额： "+f);

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
	
	//值班表
	private List zblist;
	public List getZblist() {
		return zblist;
	}


	public void setZblist(List zblist) {
		this.zblist = zblist;
	} 
	
	//通知
	private List tzlist;
	public List getTzlist() {
		return tzlist;
	}


	public void setTzlist(List tzlist) {
		this.tzlist = tzlist;
	}
	
	//通讯录
	private List phonelist;
	public List getPhonelist() {
		return phonelist;
	}
	
	public void setPhonelist(List phonelist) {
		this.phonelist = phonelist;
	}
	
	//学生意见
	private List yjlist;


	
	
	//定义分页变量
	private int pageCount;
	private int pageCount2;
	private int currPage;
	private int totalCount;
	private int totalPage;
	
	//查询值班表
	public String info(){
		 pageCount=6;
		 pageCount2=5;
		 currPage=1;
		 totalCount= ics.countZhiban();
		 totalPage=(totalCount+pageCount-1)/pageCount;
		 System.out.println("总页数："+totalPage);
		 
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
		//查值班
		 zblist=ics.selZhiban(currPage,pageCount);
		 System.out.println("size:" +zblist.size());
		//查发布通知
		 tzlist=ics.selTongzhi();
		 //查通讯录
		 phonelist=ics.selTel(currPage,pageCount2);
		 //查学生意见
		 yjlist=ics.yijianlistpage(0, 8);
		 System.out.println("意见size:"+yjlist.size());
		 
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


	//查詢当月工资
//	public String selectSalary(){
//		System.out.println("进来了selSalay");
//		
//		//获取系统当前时间
//		Date d = new Date();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = df.format(d);
//		System.out.println("系统时间："+time);
//		
//		String year=time.substring(0, 4);
//		String month=time.substring(5, 7);
//		System.out.println("年份："+year);
//		System.out.println("月份："+month);
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
	
	//工资发放情况
	public String salarylist(){
		System.out.println("进了salarylist");
		
		// 获取系统当前时间
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		System.out.println("系统时间：" + time);
		
		String year = time.substring(0, 4);
		String month = time.substring(5, 7);
		
		
		int ye=Integer.parseInt(year);
		int mo=Integer.parseInt(month)-1;
		System.out.println("年份：" + ye);
		System.out.println("月份：" + mo);
		
		ToRequest("ye", ye);
		ToRequest("mo", mo);
		
		return "slist";
	}
	
	//查上月工资发放情况
	public String selLastMonthInfo(){
		System.out.println("进来了selLastMonthInfo");
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
	
	//列表页面按时间筛选
	public String selSalaryByTime(){
		System.out.println("进来了selLastMonthInfo");
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
	
	
//加载员工列表
	public String selectSalary2() {

		System.out.println("进来了selectSalary2");
		HttpServletRequest req = ServletActionContext.getRequest();
		
		System.out.println("年  "+req.getParameter("y"));
		System.out.println("月  "+req.getParameter("m"));
		
		int y=Integer.parseInt(req.getParameter("y"));
		int m=Integer.parseInt(req.getParameter("m"));
		//验证本月是否结算
		int num=ics.isJiesuan(y, m);
		if(num==0){
			System.out.println("此月没有结算");
			n=0;
		}else{
			
			System.out.println("此月已经结算");
			n=1;
		}
		
		String id = req.getParameter("id");
		System.out.println(id);
		
		// 查所有员工姓名、职务、底薪、所在部门以及当月考核天数
		salary_list = ics.selSalaryInfo(id);

		return "success";
	}
	
	//是否结算
	private int n;
	
	//保存员工基本信息
	private List salary_list;

	public List getSalary_list() {
		return salary_list;
	}

	public void setSalary_list(List salary_list) {
		this.salary_list = salary_list;
	}
	
	
// 计算工资
	public String count_salary() {
		System.out.println("进了后台");
		HttpServletRequest req = ServletActionContext.getRequest();
		String str = req.getParameter("id");
		System.out.println(str);
		String[] s = str.split(",");
		String eid = s[0];
		
		// 查底薪、考核天数
		List listEmp = ics.selSalaryInfo(eid);
		Map map = (Map) listEmp.get(0);
		
		String dname=map.get("SALARY_DNAME").toString();	//部门
		
		String ename=map.get("SALARY_ENAME").toString();	//姓名
		
		String jwork=map.get("SALARY_JWORK").toString();	//职务
		
		BigDecimal b1 = (BigDecimal) map.get("SALARY_MONEY");
		float dixin = b1.floatValue(); 		// 底薪
		
		System.out.println("部门： "+dname);
		System.out.println("姓名： "+ename);
		System.out.println("职务： "+jwork);
		System.out.println("底薪：" + dixin);

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
		System.out.println("考核t_k:" + t_k);
		System.out.println("t1:" + t1);
//		System.out.println("t2:" + t2);
//		System.out.println("t3:" + t3);
//		System.out.println("t4:" + t4);
//		System.out.println("t5:" + t5);
		
		//考核天数 必填
		int kh=Integer.parseInt(t_k);	
		
		int a=0;
		if(!t1.equals("")){
			a = Integer.parseInt(t1); // 病事假
		}
		
		int b=0;
		if(!t2.equals("")){
			b = Integer.parseInt(t2);   // 	未出勤
		}

		float c=0;
		if(!t3.equals("")){
			c = Float.parseFloat(t3);   // 违纪罚款
		}
		
		float d=0;
		if(!t4.equals("")){
			d = Float.parseFloat(t4);   // 迟到罚款
		}
		
		float e=0;
		if(!t5.equals("")){
			e = Float.parseFloat(t5);   // 其他工资
		}
	
	
//		System.out.println("考核:" + kh+"天");
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
		System.out.println("d:" + d);
		System.out.println("e:" + e);

		
	//			f	   f    f       i         i   i     f   f
		 float sum= dixin + e -(dixin / kh) * ( a + b) -( c + d );
		
		 BigDecimal bd=new BigDecimal(sum);
		  ft =bd.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
		  System.out.println("总工资： "+ft);
		  
		  //往工资表插入此员工的工资信息
		  Salary sy=new Salary();	
		  
//		  System.out.println("运行到这了");
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
			  System.out.println("未登录");
		  }
		  sy.setPerson(emp.getEname());
		
		  sy.setStatus("未发放");
		  
//		  System.out.println("***********");
		  
		  boolean bln=ics.addSalaryEachEmp(sy);
		  if(bln){
			  System.out.println("添加成功");
			  sta2=1;
		  }else{
			  System.out.println("添加失败");
		  }
		  
		 return "success";
	}
	
	//判断是否结算成功
	private int sta2;
	public int getSta2() {
		return sta2;
	}

	public void setSta2(int sta2) {
		this.sta2 = sta2;
	}
	
	
	//json 保存 总工资
	private float ft;
	public float getFt() {
		return ft;
	}

	public void setFt(float ft) {
		this.ft = ft;
	}
	
	
	

	
//去发放页面
	public String fafang(){
		 
		 System.out.println("进了fafang");
		
		return "flist";
	}
	
//加载发放工资列表
	public String fafanglist(){
		
		System.out.println("进了fafanglist");
		
		HttpServletRequest req = ServletActionContext.getRequest();
		int y=Integer.parseInt(req.getParameter("year"));
		int m=Integer.parseInt(req.getParameter("month"));
		
		list_jiesuan=ics.selSalaryJiesuan(y,m); //结算好了的
		
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
	
	
//改发放状态
	public String updFafang(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String id=req.getParameter("id");
		System.out.println("ID的值： "+id);
		String []s=id.split(",");
		int eid=Integer.parseInt(s[0]);
		int y=Integer.parseInt(s[1]);
		int m=Integer.parseInt(s[2]);
		
		System.out.println("eid: "+eid);
		System.out.println("y: "+y);
		System.out.println("m: "+m);
		
		boolean bln=ics.updFafangStatus(eid, y, m);
		if(bln){
			  System.out.println("更改成功");
			  sta=1;
		 }else{
			  System.out.println("更改失败");
		 }
		
	//往支出表里插入数据
		
		//获取系统时间
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		
		System.out.println("系统时间 : "+time);
		
		int year = Integer.parseInt(time.substring(0, 4));
		int month = Integer.parseInt(time.substring(5, 7));
		System.out.println("年： "+year);
		System.out.println("月： "+month);
		
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd;
		try {
			 dd=dft.parse(time);
			 
			Zhichu zhi=new Zhichu();
			zhi.setZhichu_xiangmu(0);
			//获得支出金额
			List ff_list=ics.selFangfaJine(eid, y, m);
			Map map=(Map)ff_list.get(0);
			BigDecimal b=(BigDecimal)map.get("TOTAL_SALARY");
			float f=b.floatValue();
			System.out.println("支出金额： "+f);
			
			zhi.setZhichu_jine(f);
			//经手人
			Emp emp=(Emp)fromSession("teacher");
			zhi.setJingshouren(emp.getEname());
				
			zhi.setZhichu_time(dd);
			
			zhi.setZ_year(year);
			zhi.setZ_month(month);
			//添加支出
			boolean bln2=ics.zhichu_add(zhi);
			if(bln2){
				  System.out.println("支出表插入数据成功");
				  
			 }else{
				  System.out.println("支出表插入数据失败");
			 }
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "success";
	}
	
	//判断是否发放成功
	private int sta;
	public int getSta() {
		return sta;
	}


	public void setSta(int sta) {
		this.sta = sta;
	}

	//查员工底薪
	public String selDixin(){
		System.out.println("查底薪了");
		HttpServletRequest req = ServletActionContext.getRequest();
		String eid=req.getParameter("id");
		if(eid==null){
			System.out.println("进来是null");
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
	
	//修改底薪
	public String updDixin(){
		System.out.println("。。。。");
		HttpServletRequest req = ServletActionContext.getRequest();
		int eid=Integer.parseInt(req.getParameter("eid"));
		float money=Float.parseFloat(req.getParameter("dixin"));
		
		boolean bln=ics.updEmpDixin(eid, money);
		if(bln){
			  System.out.println("更改底薪成功");
			  sta3=1;
		  }else{
			  System.out.println("更改底薪失败");
			  sta3=0;
		  }
		
		return "success";
	}
	//底薪修改状态
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
