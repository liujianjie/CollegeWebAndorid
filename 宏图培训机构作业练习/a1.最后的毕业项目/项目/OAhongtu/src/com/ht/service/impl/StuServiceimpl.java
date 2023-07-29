package com.ht.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.IStuService;
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

public class StuServiceimpl extends Hibernate_Dao implements IStuService{
	
	//�����Ĳ�ѯ������ʼ
	public List selallsbklist(){
		return listbysql("select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where s.statu in(0,1)");
	}
	
	public List selcos(){		//2.�γ�
		return list("from Course");
	}

	public List sellist() {//ѧ��
		return listbysql("select * from student");
	}
	
	public List selstudentbyname(String intenname) {
		return listbysql("select * from student where intenname='"+intenname+"'");
	}
	//������ҳ������� �Ͱ༶������
	public List empteacheslist() {//������
		return listbysql("select distinct e.ename,e.eid from classes c inner join emp e on e.eid=c.empteaches");
	}
	public List selclslist(){
		return listbysql("select * from classes");
	}
	public List selhrslist(){
		return listbysql("select * from hourse");
	}
	public List selelelist(){
		return listbysql("select * from elements");
	}
	//�����Ĳ�ѯ��������
	
	
	//ѧ����ʼ

	public List listbyclassid(Long classid){
		return listbysql("select * from student where classid="+classid);
	}
	public List list() {
		return list("from Student");
	}
	public List listbystatus(Long intenstatus){
		return listbysql("select * from student where intenstatus="+intenstatus+" order by intenid ");
	}
	public boolean add(Student stu) {
		return addObj(stu);
	}

	public boolean alert(Student stu) {
		return updObj(stu);
	}

	public boolean del(Student stu) {
		return delObj(stu);
	}

	public Student get(Serializable id) {
		return (Student) getObj(Student.class, id);
	}
	//��У��¼
	public List selscore(Long intenid){
		return listbysql("select * from score where stuid="+intenid);
	}
	public List selprj(Long intenid){
		return listbysql("select * from defenses d inner join projectf p on p.pid=d.pid where dmember="+intenid);
	}
	public List selsays(Long intenid){
		return listbysql("select * from says where sayface="+intenid);
	}
	public List selsmy(Long intenid){
		return listbysql("select * from summary where sstuid="+intenid);
	}
	public List sellev(Long intenid){
		return listbysql("select * from leave where lstuid="+intenid);
	}
	//ѧ������
	
	
	//���Ὺʼ
	public boolean addhrs(Hourse hrs) {
		return addObj(hrs);
	}

	public boolean alerthrs(Hourse hrs) {
		
		return updObj(hrs);
	}

	public boolean delhrs(Hourse hrs) {
		return delObj(hrs);
	}

	public Hourse gethrs(Serializable id) {
		return (Hourse) getObj(Hourse.class, id);
	}

	public List hrslist() {
		// TODO Auto-generated method stub
		return list("from Hourse");
	}
	//�������

	//��Ԫ��ʼ
	public boolean addele(Elements ele) {
		return addObj(ele);
	}
	public List elelist() {
		return list("from Elements");
	}
	public boolean alertele(Elements ele) {
		return updObj(ele);
	}
	public Elements getele(Serializable id) {
		return (Elements) getObj(Elements.class, id);
	}
	public boolean delele(Elements ele) {
		return delObj(ele);
	}
	//��Ԫ����

	//�༶��ʼ
	public boolean addcls(Classes cls) {
		return addObj(cls);
	}

	public boolean alertcls(Classes cls) {
		return updObj(cls);
	}
	
	public List clslistbysql() {
		return listbysql("select * from classes");
	}
	public List clslist(){
		return list("from Classes");
	}
	public boolean delcls(Classes cls) {
		return delObj(cls);
	}

	public Classes getcls(Serializable id) {
		//��ȷ��д��Ϊ
		return (Classes)getObj(Classes.class, id);
	}
	//�༶����

	//�ɼ������ɾ���� �� ��ʼ
	public List scolist(){
		return listbysql("select o.*,c.classname,s.intenname,u.couname from score o,classes" +
				" c,student s,course u  where "+
				" c.classid=s.classid and o.stuid=s.intenid and o.sconame=u.couid and s.intenstatus=1");
	}
	public List scolist(Long classid, Long couid) {

		return listbysql("select o.*,c.classname,s.intenname,u.couname from score o,classes" +
				" c,student s,course u  where sconame="+couid+" and stuid in(select intenid from " +
				"student where Classid=(select classid from classes where classid="+classid+"))" +
				" and c.classid=s.classid and o.stuid=s.intenid and o.sconame=u.couid");
	}
	public boolean addsco(Score sco) {
		return addObj(sco);
	}

	public boolean alertsco(Score sco) {
		return updObj(sco);
	}

	public Score getsco(Serializable id) {
		return (Score)getObj(Score.class, id);
	}
	//��ӳɼ�ʱ����ѧ����ɸѡ
	public List scoaddclassstudentlist(Long classid) {
		return listbysql("select s.intenname,c.classname,c.classid," +
				"s.intenid from student s inner join classes c on " +
				"c.classid=s.classid where s.classid="+classid+"");
	}
	
	//�ɼ������
	
	//̸�ļ�¼��ʼ
	public List saystoaddstulist(Long classid){
		return listbysql("select * from student where intenid not in(select sayface from says) and classid="+classid+"");
	}
	public boolean addsays(Says says) {
		return addObj(says);
	}

	public boolean alertsays(Says says) {
		return updObj(says);
	}

	public Says getsays(Serializable id) {
		return (Says) getObj(Says.class, id);
	}
	public List sayslist(int start,int end){//���µ�̸�ļ�¼
		return pagelistbysql("select s.*,t.intenname,t.classid from says s inner join student t on t.intenid=s.sayface order by sayid desc ", start, end);
	}//�����ڶ�
	public List sayslist(Long sayempid,Long state){//��ֻ�а�����
		return listbysql("select s.*,t.intenname,t.intenid,t.classid from says s inner join student t on s.sayface=t.intenid where sayempid="+sayempid+" and t.intenstatus="+state+"");
	}
	public List saysstulist(Long sayface){//ѧ����ѯ
		
		return listbysql("select s.*,t.intenname,t.intenid from says s inner join student t on s.sayface=t.intenid where sayface="+sayface);
	}
	public Emp getemp(Serializable id){//�����ζ���
		return (Emp)getObj(Emp.class, id);
	}
	public boolean delsays(Says says){//
		return delObj(says);
	}
	//̸�ļ�¼�����
	
	//ѧ���ܽῪʼ
	public List summarylist(){
		
		return listbysql("select s.*,t.intenname,e.ename,t.classid from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches");
	}
	public List summarylist(Long classid)//�༶ɸѡ
	{
		return listbysql("select s.*,t.intenname,e.ename from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches where sstuid in(select intenid from student s where classid=(select classid from classes where classid="+classid+"))");
	}
	public List summarystulist(Long sstuid){//ѧ��idɸѡ
		return listbysql("select s.*,t.intenname,e.ename from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches where sstuid="+sstuid);
	}
	public List summarytoaddstulist(Long classid){
		return listbysql("select * from student where intenid not in(select sstuid from summary) and classid="+classid+"");
	}//ȥ��ӵ�ѧ��
	public boolean addsmy(Summary smy){
		return addObj(smy);
	}
	public Summary getsmy(Serializable id){
		return (Summary) getObj(Summary.class, id);
	}
	public boolean alertsmy(Summary smy){
		return updObj(smy);
	}
	//ѧ���ܽ����

	//ѧ����ҵ����ʼ

	public boolean addjob(Job job) {
		return addObj(job);
	}

	public boolean alertjob(Job job) {
		return updObj(job);
	}

	public Job getjob(Serializable id) {
		return (Job)getObj(Job.class, id);
	}

	public List joblist(Long classid) {
		return listbysql("select j.*,s.intenname,e.ename from job j inner join student s on s.intenid=j.jobstu inner join emp e on e.eid=j.jobtea where jobtea=(select empteaches from classes where classid="+classid+")");
	}//�༶

	public List joblist(Long intenid, Long classid) {
		return listbysql("select j.*,s.intenname,e.ename from job j inner join student s on s.intenid=j.jobstu inner join emp e on e.eid=j.jobtea where jobtea=(select empteaches from classes where classid="+classid+") and jobstu="+intenid+"");
	}//��¼�˺� ѧ��
	public List joblistbytea(Long jobtea){
		return listbysql("select j.*,s.intenname,e.ename from job j inner join student s on s.intenid=j.jobstu inner join emp e on e.eid=j.jobtea where jobtea="+jobtea);
		
	}//��¼��
	public boolean deljob(Job job){
		
		return delObj(job);
	}
	public List jobtoaddstulist(Long classid){//û�м�¼��ѧ��
		return listbysql("select * from student where intenid not in(select jobstu from job) and classid="+classid+"");
	}
	//ѧ����ҵ�������
	
	//��Ŀ��翪ʼ
	public boolean adddfs(Defenses dfs){
		
		return addObj(dfs);
	}//�ӱ�
	public boolean addprj(Projectf prj) {
		return addObj(prj);
	}

	public boolean alertprj(Projectf prj) {
		return updObj(prj);
	}

	public Projectf getprj(Serializable id) {
		return (Projectf) getObj(Projectf.class, id);
	}

	public List dfslist(Long classid, Long couid) {//��ѯ
		return listbysql("select d.*,p.*,s.intenname from defenses d inner join projectf p on p.pid=d.pid inner join student s on d.dmember=s.intenid where p.pclassid="+classid+" and p.pname="+couid+" order by did");
	}
	public List prjlist() {
		return listbysql("select * from projectf");
	}
	public List prjlist(Long classid,Long couid){
		
		return listbysql("select * from projectf p where p.pclassid="+classid+" and p.pname="+couid+"");
	}//���� ����
	
	//��Ŀ������
	

	//�����������ʼ
	public List sbkstulist(Long stdid){// ѧ��ֻ��ʾ�Լ���Ҫ����һ��stdid
		
		return listbysql("select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where stdid="+stdid);
	}

	public List sbklist(Long statu,Long sempid) {//��ʦ��ȫ���������
		return listbysql("select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where s.statu="+statu+" and s.sempid="+sempid+"");
	}

	public List sbklist2(Long statu,Long sempid) {
		return listbysql("select s.*,t.intenname,r.rcon,r.rid from sback s inner join student t on t.intenid=s.stdid inner join reply r on r.sbackid=s.sbackid where s.statu="+statu+" and s.sempid="+sempid+"");
	}
	public List replylist(){
		return list("from Reply");
	}//�ظ��б�
	public boolean addsbk(Sback sbk){
		
		return addObj(sbk);
	}
	public Sback getsbk(Serializable id){
		return (Sback)getObj(Sback.class, id);
	}
	public boolean updsbkstatu(Sback sbk) {
		return updObj(sbk);
	}
	public boolean delsbk(Sback sbk){
		return delObj(sbk);
	}
	public boolean addrly(Reply rly){
		
		return addObj(rly);
	}
	public Reply getrly(Serializable id){
		return (Reply)getObj(Reply.class, id);
	}
	public boolean updrly(Reply rly){
		return updObj(rly);
	}
	//��������������

	//��ٹ���ʼ
	public List levlist(Long lshr){//�������ʦ�� ״̬ 1����� 2��ͬ��
		return listbysql("select l.*,s.intenname from leave l inner join student s on s.intenid=l.lstuid where lshr="+lshr+" and lstate in(1,2)");
	}
	public List levstulist(Long lstuid){//ѧ��ֵ
		return listbysql("select * from leave where lstuid="+lstuid);
	}
	public Leave getlev(Long lid){
		return (Leave) getObj(Leave.class, lid);
		
	}
	public boolean updlev(Leave lev){
		return updObj(lev);
	}
	public boolean addlev(Leave lev){
		return addObj(lev);
	}
	public boolean dellev(Leave lev){
		return delObj(lev);
	}
	//��ٹ������
	
	//���õ��Կ�ʼ
	public List apllist(Long ashr){
		return listbysql("select a.*,s.intenname from application a inner join student s on s.intenid=a.astuid where ashr="+ashr+" and astate in(1,2) ");
	}
	public List aplstulist(Long astuid){
		return listbysql("select * from application where astuid="+astuid);
	}
	public Application getapl(Long Aid){
		return (Application)getObj(Application.class, Aid);
	}
	public boolean updapl(Application apl){
		return updObj(apl);
	}
	public boolean addapl(Application apl){
		return addObj(apl);
	}
	public boolean delapl(Application apl){
		return delObj(apl);
	}
	
	//���õ��Խ���

}
