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
	//ѧ����Ĳ顢��ɾ��
	public List list();
	public List listbystatus(Long intenstatus);//ͨ��ѧ��״̬��ѯ ��ҵ ���� �ڶ� �ڶ�1 ��ҵ2
	public List listbyclassid(Long classid);//���ݰ༶
	public boolean add(Student stu);
	public boolean del(Student stu);
	public Student get(Serializable id);
	public boolean alert(Student stu);
	//ѧ����¼ �ɼ� ��Ŀ���ɼ� ̸�� �ܽ� ��ٴ���
	public List selscore(Long intenid);
	public List selprj(Long intenid);
	public List selsays(Long intenid);
	public List selsmy(Long intenid);
	public List sellev(Long intenid);
	
	//��������ɾ�ġ���
	public List hrslist();
	public boolean addhrs(Hourse hrs);
	public boolean delhrs(Hourse hrs);
	public Hourse gethrs(Serializable id);
	public boolean alerthrs(Hourse hrs);
	
	//��Ԫ��Ĳ�
	public List elelist();
	public boolean addele(Elements ele);
	public boolean alertele(Elements ele);
	public Elements getele(Serializable id);
	public boolean delele(Elements ele);
	
	//�༶�����ɾ���� ��
	public List clslist();//hql
	public List clslistbysql();
	public boolean addcls(Classes cls);
	public boolean delcls(Classes cls);
	public Classes getcls(Serializable id);
	public boolean alertcls(Classes cls);
	
	//�ɼ���������� ��
	public List scolist(Long classid,Long couid);//�а༶�пγ�
	public List scolist();//���гɼ�
	public boolean addsco(Score sco);
	public Score getsco(Serializable id);
	public boolean alertsco(Score sco);
	//Ϊ��Ӳ�ѯ��
	public List scoaddclassstudentlist(Long classid);//����ѧ��

	//̸�ļ�¼���� ɾ���� ��
	public List saystoaddstulist(Long classid);//ȥ��� �༶ɸѡ ����û�м�¼��ѧ��
	public boolean addsays(Says says);
	public Says getsays(Serializable id);
	public boolean alertsays(Says says);
	public boolean delsays(Says says);
	public List sayslist(Long sayempid,Long state);//��ֻ�а�����
	public List saysstulist(Long sayface);//ѧ����ѯ
	public Emp getemp(Serializable id);//�����ζ���
	public List sayslist(int start,int end);//����״̬��̸�ļ�¼
	
	//ѧ���ܽ����
	public List summarylist();//���е�
	public List summarylist(Long classid);//�༶ɸѡ
	public List summarytoaddstulist(Long classid);//ȥ��� �༶ɸѡ ����û�м�¼��ѧ��
	public List summarystulist(Long sstuid);//ѧ��idɸѡ
	public boolean addsmy(Summary smy);
	public Summary getsmy(Serializable id);
	public boolean alertsmy(Summary smy);
	
	//ѧ����ҵ����
	public List joblist(Long classid);//�༶
	public List joblistbytea(Long jobtea);//��¼��
	public boolean addjob(Job job);
	public Job getjob(Serializable id);
	public boolean alertjob(Job job);
	public boolean deljob(Job job);
	public List jobtoaddstulist(Long classid);//ȥ��� �༶ɸѡ ����û�м�¼��ѧ��
	
	//��Ŀ������
	public List dfslist(Long classid,Long couid);//�а༶�пγ� �� ��������
	public List prjlist();//���������¼������Ϣ
	public List prjlist(Long classid,Long couid);//���� ����
	public boolean addprj(Projectf prj);
	public Projectf getprj(Serializable id);
	public boolean alertprj(Projectf prj);
	public boolean adddfs(Defenses dfs);//�ӱ�
	
	//�����������
	public List sbkstulist(Long stdid);//ȫ��������� ѧ��ֻ��ʾ�Լ���Ҫ����һ��stdid
	public List sbklist(Long statu,Long sempid);//δ����������� ����ʾ������� û�лظ���
	public List sbklist2(Long statu,Long sempid);//�ظ�������� �лظ���  �������ǲ�ͬ��
	public List replylist();//�ظ��б�
	public Sback getsbk(Serializable id);
	public boolean addsbk(Sback sbk);
	public boolean delsbk(Sback sbk);
	public boolean updsbkstatu(Sback sbk);
	public boolean addrly(Reply rly);
	public Reply getrly(Serializable id);
	public boolean updrly(Reply rly);

	//���
	public List levlist(Long lshr);//���������ʦ��ȫ������б� 
	public List levstulist(Long lstuid);//ѧ��ֵ��ʾ�Լ���Ҫ����һ��lstuid
	public Leave getlev(Long lid);
	public boolean updlev(Leave lev);//�޸�״̬Ҳ�����
	public boolean addlev(Leave lev);
	public boolean dellev(Leave lev);
	
	//���õ���
	public List apllist(Long ashr);//���������ʦ��ȫ������б� 
	public List aplstulist(Long astuid);//ѧ��ֵ��ʾ�Լ���Ҫ����һ��lstuid
	public Application getapl(Long Aid);
	public boolean updapl(Application apl);//�޸�״̬Ҳ�����
	public boolean addapl(Application apl);
	public boolean delapl(Application apl);
	
	//�����Ĳ�ѯ������ʼ
//	public List selcls();		//1.�༶
	public List selcos();		//2.�γ�
//	public List selhrs();		//3.����
	public List selstudentbyname(String intenname);//4.ѧ������
	public List empteacheslist();//5.������
	
	//6.�༶
	//û�м�����ѯ�Ĳ�ѯ�༶������
	public List selclslist();
	public List selhrslist();
	public List selelelist();
	//�����Ĳ�ѯ��������
	public List sellist();
	//���е��ѻظ�����δ������������
	public List selallsbklist();
	
}
