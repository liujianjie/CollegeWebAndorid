package com.dc.controller.duty;
import java.util.List;
import com.dc.dao.duty.DutyDAO;
import com.dc.dao.duty.DutyDAOImpl;
import com.dc.util.BaseAction;

public class DutyAciton extends BaseAction{
	private String  dutyid;
	public void  open(){
		DutyDAO d=new DutyDAOImpl();
		d.open(dutyid);
		this.getOut().print("{\"state\":1,\"message\":\"��ְ���ܽ���\"}");
	}
	public void close(){
		DutyDAO d=new DutyDAOImpl();
		List list=d.findemp(dutyid);
		if(!list.isEmpty()){
			this.getOut().print("{\"state\":0,\"message\":\"��ְ���ܽ���\"}");
		}else{
			d.close(dutyid);
			this.getOut().print("{\"state\":1,\"message\":\"��ְ���ܽ���\"}");
		}
	}
	public String getDutyid() {
		return dutyid;
	}
	public void setDutyid(String dutyid) {
		this.dutyid = dutyid;
	}
	
	
}
