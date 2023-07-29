package com.ht.service;

import java.util.List;

import com.ht.vo.Holday;
import com.ht.vo.Jiaban;
import com.ht.vo.Kaoqin;
import com.ht.vo.Zhiban;

public interface IExamineService {
	public List listkao();
	public List mylistkao(String ename);
	public List toaddkao();
	public boolean addkao(Kaoqin kao);
	
	//���ݼ�
	public List hollist();
	public List myhollist(long id);
	public boolean holadd(Holday hol);
	public Holday gethol(long id);
	public boolean holupd(Holday hol);
	public boolean holdel(Holday hol);
	public boolean toupload(long id);
	public boolean toupdNO(long id);
	public boolean toupdYES(long id);
	public boolean toupdholman(long hmid, long hid);
	public boolean toupdhday(long eid,long hday);
	public boolean toupdaddhday(long eid,long jday);
	
	//�Ӱ�
	public List jialist();
	public List myjiaban(long eid);
	public List deptman();
	public boolean jiaadd(Jiaban jia);
	public Jiaban getjia(long id);
	public boolean jiaupd(Jiaban jia);
	public boolean jiadel(Jiaban jia);
	public boolean toupdstatu(long id);
	public boolean toupdstatuYES(long id);
	public boolean toupdstatuNO(long id);
	public boolean toupdjman(long jid,long sid);
	
	//ֵ��
	public List zhibanlist();
	//��ѯֵ�൥����¼
	public Zhiban selZhibanById(Long id);
	//�޸�ֵ��
	public boolean updZhiban(Zhiban zh);
}
