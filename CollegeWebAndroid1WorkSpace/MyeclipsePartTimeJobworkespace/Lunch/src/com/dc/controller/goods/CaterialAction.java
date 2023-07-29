package com.dc.controller.goods;

import com.dc.dao.goods.CaterialDao;
import com.dc.dao.goods.CaterialDaoImpl;
import com.dc.entity.Message;
import com.dc.util.BaseAction;

public class CaterialAction extends BaseAction{
	private String caterialname;		//材料名称
	private String target;				//材料状态
	/**
	 * 在jsp页面显示材料是否充足
	 * */
	public void  updatestate(){
		CaterialDao caterialDao=new CaterialDaoImpl();
		boolean result=caterialDao.updatecaterial(caterialname);
		 Message mess=new Message();
		 if(result){
			 mess.setState(true);
			 mess.setMessage("材料补充成功!");
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
