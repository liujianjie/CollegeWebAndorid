package com.ht.service;

import java.util.List;
import java.util.Set;

import com.ht.vo.Emp;
import com.ht.vo4.JiaoqingZhuangtai;

import com.ht.vo4.Salary;
import com.ht.vo4.Shouru;
import com.ht.vo4.Xuefei;
import com.ht.vo4.Zhichu;

public interface ICaiwuService {
//����
	//��ѯ�����б�
	public List shouru_list();
	public List shouru_list1(String f1,String f2);
	public List shouru_list2(String f3);
	//��ѯ������
	public List total_shouru();
	//���һ������
	public boolean shouru_add(Shouru sh);
	//��ѯ��������
	public  Shouru selShouruById(int id);
	//�޸ĵ�������
	public boolean shouru_upd(Shouru sh);
	//ɾ��һ������
	public boolean shouru_del(Shouru sh);
	
	
	
//֧��	
	//��ѯ֧���б�
	public List zhichu_list();
	public List zhichu_list1(String f1,String f2);
	public List zhichu_list2(String f3);
	//��ѯ֧���ܶ�
	public List total_zhichu();
	//���һ��֧��
	public boolean zhichu_add(Zhichu zh);
	//��ѯ����֧��
	public Zhichu selZhichuById(int id);
	//�޸�һ��֧��
	public boolean zhichu_upd(Zhichu zh);
	//ɾ��һ��֧��
	public boolean zhichu_del(Zhichu zh);
	
//ѧ��
	//��ѯѧ���б�
	public List xuefei_list();
	//��ѯ���а༶
	public List selAllClass();
	//��ѯѧ�Ѽ�����
	
	
	//���һ��ѧ�Ѽ�¼
	public List IsContainStu(String id1,String id2);
	public boolean xuefei_add(Xuefei xu);//���
	
  //�Ƿ�Ҫ������״̬�� ����/�������� ������
	public List selCount(Long stuid,Long xueqi_id);
	public List selXueqiJiaofei(Long id1,Long id2);
	public boolean jiaoqing_add(JiaoqingZhuangtai jiao);
	public boolean jiaoqingstatus_upd(Long id1,Long id2);
	public List jiaoqing_list(String id1,String id2);
	
	//����
	public List selSalaryList(String year,String month);
	//��ѯԱ����Ϣ
	public Emp getEmpById(Long id);
	//����ְ���н��
	public List selXinziByJob(String job);

	//������Ա������
	public List selAllEmpName();
	
//�ֲ�ˢ��1
	public List selMoneyByYear(String year);
//�ֲ�ˢ��2
	public List selMoneyByYearMonth(String year,String month);
	
//�ֲ�ˢ��11
	public List selMoneyByYear2(String year);
//�ֲ�ˢ��22
	public List selMoneyByYearMonth2(String year,String month);
	
	//����Id��ѧ������
	public List selStuName(Long id);
	//����id��༶����
	public List selStuClass(Long id);

	//��֤Ա���Ƿ����
	public List checkIsJiesuan(int empid,int year,int month);
	
	
	//��ѯֵ��
	public List selZhiban(int cpage,int pcount);
	//���ѷ���֪ͨ
	public List selTongzhi();
	//��ͨѶ¼
	public List selTel(int cpage,int pcount);
	
	//��ֵ���ܼ�¼
	public int countZhiban();
	//��ѧ�����
	public List yijianlistpage(int start, int pageCount);
	
//������Ա��
	public List selAllEmp();
//�鹤�ʻ�����Ϣ	
	public List selSalaryInfo(String eid);
	//�����ʱ����������
	public boolean addSalaryEachEmp(Salary s);
	//���Ź����б�
	public List selSalaryJiesuan(int y,int m);
	//�Ĺ��ʷ���״̬
	public boolean updFafangStatus(int eid,int y,int m);
	
	//�޸�ĳԱ���ĵ�н
	public boolean updEmpDixin(int eid,float money);
	
	//��֤�����Ƿ����
	public int isJiesuan(int y,int m);
	
	
	//��ĳ�༶ѧ��
	public List selStuByClass(int classid);
	
	//�鷢�Ź��ʵĽ��
	public List selFangfaJine(int eid,int y,int m);
}
