package com.dc.controller.goods;

import com.dc.dao.goods.CaterialDao;
import com.dc.dao.goods.CaterialDaoImpl;
import com.dc.entity.Message;
import com.dc.util.BaseAction;

public class CaterialAction extends BaseAction{
	private String caterialname;		//��������
	private String target;				//����״̬
	/**
	 * ��jspҳ����ʾ�����Ƿ����
	 * */
	public void  updatestate(){
		CaterialDao caterialDao=new CaterialDaoImpl();
		boolean result=caterialDao.updatecaterial(caterialname);
		 Message mess=new Message();
		 if(result){
			 mess.setState(true);
			 mess.setMessage("���ϲ���ɹ�!");
			 this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
		 } 
		
	}
	
	
	

	public String getCaterialname() {
		return caterialname;
	}

	public void setCaterialname(String caterialname) {
		this.caterialname = caterialname;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	

}
