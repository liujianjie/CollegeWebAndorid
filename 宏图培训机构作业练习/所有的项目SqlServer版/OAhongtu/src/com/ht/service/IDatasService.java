package com.ht.service;

import java.util.Date;
import java.util.List;

import com.ht.vo.Dept;
import com.ht.vo.Deptmans;
import com.ht.vo.Rizhi;
import com.ht.vo.Sroom;
import com.ht.vo.Xuncha;


public interface IDatasService {
	//����
	public List deptlist();
	public boolean deptadd(Dept dept);
	public Dept getdept(long id);
	public boolean deptupd(Dept dept);
	public boolean deptdel(Dept dept);
	
	public List manslist();
	public boolean mansdel(Deptmans mans);
	public boolean mansadd(Deptmans mans);
	//�༶Ѳ��
	public List xunlist(String xname,String xdate,String xtime);
	public List toxuncha();
	public boolean addxun(Xuncha xun);
	//��־
	public List rizhilist();
	public List myrizhi(long eid);
	public boolean addrizhi(Rizhi rizhi);
	public Rizhi getrizhi(long id);
	public boolean rizhiupd(Rizhi rizhi);
	public boolean rizhidel(Rizhi rizhi);
	//����Ѳ��
	public List listroom();
	public List mylistroom(long id);
	public List toaddroom();
	public boolean addroom(Sroom sr);
	public Sroom getroom(long id);
	public boolean roomupd(Sroom sr);
	public boolean roomdel(Sroom sr);
	public List emplist();
	
}
