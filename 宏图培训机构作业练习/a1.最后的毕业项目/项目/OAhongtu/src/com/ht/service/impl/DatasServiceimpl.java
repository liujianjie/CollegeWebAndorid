package com.ht.service.impl;

import java.util.Date;
import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.IDatasService;
import com.ht.vo.Dept;
import com.ht.vo.Deptmans;
import com.ht.vo.Rizhi;
import com.ht.vo.Sroom;
import com.ht.vo.Xuncha;

public class DatasServiceimpl extends Hibernate_Dao implements IDatasService{

	public List deptlist() {
		// TODO Auto-generated method stub
		return list("from Dept");
	}

	public boolean deptadd(Dept dept) {
		// TODO Auto-generated method stub
		//return executesql("insert into dept values ('seq_datas.nextval','"+dept.getDname()+"','"+dept.getStatus()+"',to_date('"+dept.getCreatetime()+"','YYYY-MM-DD'),'"+dept.getDeptman()+"','"+dept.getKing()+"')");
		return addObj(dept);
	}

	public List manslist() {
		// TODO Auto-generated method stub
		return list("from Deptmans");
	}

	public boolean deptdel(Dept dept) {
		// TODO Auto-generated method stub
		return delObj(dept);
	}

	public boolean deptupd(Dept dept) {
		// TODO Auto-generated method stub
		return updObj(dept);
	}

	public Dept getdept(long id) {
		// TODO Auto-generated method stub
		return (Dept)getObj(Dept.class, id);
	}

	public boolean addxun(Xuncha xun) {
		// TODO Auto-generated method stub
		return addObj(xun);
	}

	public List toxuncha() {
		// TODO Auto-generated method stub
		return list("from Classes");
	}

	public List xunlist(String xname,String xdate,String xtime) {
		String sql="select * from xuncha where 1=1";
		if(xname!=null&&!"".equals(xname)){
			sql+=" and xname='"+xname+"'";
		}
		if(xdate!=null&&!"".equals(xdate)){
			sql+=" and xdate=to_date('"+xdate+"','YYYY/MM/DD')";
		}
		if(xtime!=null&&!"".equals(xtime)){
			sql+=" and xtime=' "+xtime+"'";
		}
		return listbysql(sql);
	}

	public boolean addrizhi(Rizhi rizhi) {
		// TODO Auto-generated method stub
		return addObj(rizhi);
	}

	public List rizhilist() {
		// TODO Auto-generated method stub
		return list("from Rizhi");
	}

	public Rizhi getrizhi(long id) {
		// TODO Auto-generated method stub
		return (Rizhi)getObj(Rizhi.class, id);
	}

	public boolean rizhidel(Rizhi rizhi) {
		// TODO Auto-generated method stub
		return delObj(rizhi);
	}

	public boolean rizhiupd(Rizhi rizhi) {
		// TODO Auto-generated method stub
		return updObj(rizhi);
	}

	public List listroom() {
		// TODO Auto-generated method stub
		return list("from Sroom");
	}

	public boolean addroom(Sroom sr) {
		// TODO Auto-generated method stub
		return addObj(sr);
	}

	public List toaddroom() {
		// TODO Auto-generated method stub
		return list("from Hourse");
	}

	public Sroom getroom(long id) {
		// TODO Auto-generated method stub
		return (Sroom)getObj(Sroom.class, id);
	}

	public boolean roomdel(Sroom sr) {
		// TODO Auto-generated method stub
		return delObj(sr);
	}

	public boolean roomupd(Sroom sr) {
		// TODO Auto-generated method stub
		return updObj(sr);
	}

	public List emplist() {
		// TODO Auto-generated method stub
		return list("from Emp");
	}

	public List myrizhi(long eid) {
		// TODO Auto-generated method stub
		return listbysql("select * from rizhi where eid="+eid);
	}

	public List mylistroom(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from sroom where empid="+id);
	}

	public boolean mansdel(Deptmans mans) {
		// TODO Auto-generated method stub
		return delObj(mans);
	}

	public boolean mansadd(Deptmans mans) {
		// TODO Auto-generated method stub
		return addObj(mans);
	}

}
