package com.ht.service;

import java.io.Serializable;
import java.util.List;

import com.ht.vo.Emp;
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

public interface IStuService {
	//学生表的查、增删改
	public List list();
	public List listbystatus(Long intenstatus);//通过学生状态查询 毕业 或者 在读 在读1 毕业2
	public List listbyclassid(Long classid);//根据班级
	public boolean add(Student stu);
	public boolean del(Student stu);
	public Student get(Serializable id);
	public boolean alert(Student stu);
	//学生记录 成绩 项目答辩成绩 谈心 总结 请假次数
	public List selscore(Long intenid);
	public List selprj(Long intenid);
	public List selsays(Long intenid);
	public List selsmy(Long intenid);
	public List sellev(Long intenid);
	
	//宿舍表的增删改、查
	public List hrslist();
	public boolean addhrs(Hourse hrs);
	public boolean delhrs(Hourse hrs);
	public Hourse gethrs(Serializable id);
	public boolean alerthrs(Hourse hrs);
	
	//单元表的查
	public List elelist();
	public boolean addele(Elements ele);
	public boolean alertele(Elements ele);
	public Elements getele(Serializable id);
	public boolean delele(Elements ele);
	
	//班级表的增删、改 查
	public List clslist();//hql
	public List clslistbysql();
	public boolean addcls(Classes cls);
	public boolean delcls(Classes cls);
	public Classes getcls(Serializable id);
	public boolean alertcls(Classes cls);
	
	//成绩表的增、改 查
	public List scolist(Long classid,Long couid);//有班级有课程
	public List scolist();//所有成绩
	public boolean addsco(Score sco);
	public Score getsco(Serializable id);
	public boolean alertsco(Score sco);
	//为添加查询的
	public List scoaddclassstudentlist(Long classid);//所有学生

	//谈心记录表增 删、改 查
	public List saystoaddstulist(Long classid);//去添加 班级筛选 并且没有记录的学生
	public boolean addsays(Says says);
	public Says getsays(Serializable id);
	public boolean alertsays(Says says);
	public boolean delsays(Says says);
	public List sayslist(Long sayempid,Long state);//当只有班主任
	public List saysstulist(Long sayface);//学生查询
	public Emp getemp(Serializable id);//班主任对象
	public List sayslist(int start,int end);//最新状态的谈心记录
	
	//学生总结管理
	public List summarylist();//所有的
	public List summarylist(Long classid);//班级筛选
	public List summarytoaddstulist(Long classid);//去添加 班级筛选 并且没有记录的学生
	public List summarystulist(Long sstuid);//学生id筛选
	public boolean addsmy(Summary smy);
	public Summary getsmy(Serializable id);
	public boolean alertsmy(Summary smy);
	
	//学生就业管理
	public List joblist(Long classid);//班级
	public List joblistbytea(Long jobtea);//记录人
	public boolean addjob(Job job);
	public Job getjob(Serializable id);
	public boolean alertjob(Job job);
	public boolean deljob(Job job);
	public List jobtoaddstulist(Long classid);//去添加 班级筛选 并且没有记录的学生
	
	//项目答辩管理
	public List dfslist(Long classid,Long couid);//有班级有课程 的 级联主表
	public List prjlist();//所有主表记录基本信息
	public List prjlist(Long classid,Long couid);//主表 条件
	public boolean addprj(Projectf prj);
	public Projectf getprj(Serializable id);
	public boolean alertprj(Projectf prj);
	public boolean adddfs(Defenses dfs);//子表
	
	//意见反馈管理
	public List sbkstulist(Long stdid);//全部意见反馈 学生只显示自己的要加上一个stdid
	public List sbklist(Long statu,Long sempid);//未处理意见反馈 不显示意见反馈 没有回复的
	public List sbklist2(Long statu,Long sempid);//回复意见反馈 有回复列  这两个是不同的
	public List replylist();//回复列表
	public Sback getsbk(Serializable id);
	public boolean addsbk(Sback sbk);
	public boolean delsbk(Sback sbk);
	public boolean updsbkstatu(Sback sbk);
	public boolean addrly(Reply rly);
	public Reply getrly(Serializable id);
	public boolean updrly(Reply rly);

	//请假
	public List levlist(Long lshr);//审核人是老师的全部请假列表 
	public List levstulist(Long lstuid);//学生值显示自己的要加上一个lstuid
	public Leave getlev(Long lid);
	public boolean updlev(Leave lev);//修改状态也用这个
	public boolean addlev(Leave lev);
	public boolean dellev(Leave lev);
	
	//备用电脑
	public List apllist(Long ashr);//审核人是老师的全部请假列表 
	public List aplstulist(Long astuid);//学生值显示自己的要加上一个lstuid
	public Application getapl(Long Aid);
	public boolean updapl(Application apl);//修改状态也用这个
	public boolean addapl(Application apl);
	public boolean delapl(Application apl);
	
	//公共的查询方法开始
//	public List selcls();		//1.班级
	public List selcos();		//2.课程
//	public List selhrs();		//3.宿舍
	public List selstudentbyname(String intenname);//4.学生对象
	public List empteacheslist();//5.班主任
	
	//6.班级
	//没有级联查询的查询班级和宿舍
	public List selclslist();
	public List selhrslist();
	public List selelelist();
	//公共的查询方法结束
	public List sellist();
	//所有的已回复或者未处理的意见反馈
	public List selallsbklist();
	
}
