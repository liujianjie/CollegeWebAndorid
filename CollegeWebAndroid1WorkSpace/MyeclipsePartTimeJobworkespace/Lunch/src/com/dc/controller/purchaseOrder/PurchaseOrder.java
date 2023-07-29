package com.dc.controller.purchaseOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.dc.dao.purchaseOrder.PurchaseOrderDao;
import com.dc.dao.purchaseOrder.PurchaseOrderDaoImpl;
import com.dc.dao.warehouse.WarehouseDao;
import com.dc.dao.warehouse.WarehouseDaoImpl;
import com.dc.entity.Message;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class PurchaseOrder extends BaseAction{
	private List list;					//��ѯ����
	private List list2;
	private List list3;
	private PageEntity page;			//������ҳ
	private String nowpage;				//�����ҳ��
	private String pageN;				//������ҳ�ж�
	private String target;				//����struts2
	private Map map;
	private String poid;
	private String caterials;
	private String empid;
	private int i;
	private List selectlist;
	private Map map2;
	
	/**
	 * �����ѯ
	 * */
	public String findPurchaseOrder(){
		int pageN=0;
		if(StringUtil.checkNotNull(nowpage)){
			pageN=Integer.parseInt(nowpage);
		}else{
			pageN=1;
		}
		PageEntity page1=new PageEntity();
		page1.setNowpage(pageN);
		PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		list=pur.findPurchase(page1);
		System.out.println(list);
		this.page=page1;
		this.target="/module/purchaseOrder/PurchaseOrder.jsp";
		return "select";
	}
	
	/**
	 * �鿴���������
	 * */
	public String findPur(){
		PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		list=new ArrayList();
		list=pur.selectPurchase();
		map=pur.findPurchaseById(poid);
		list3=pur.findemp();
		this.target="/module/purchaseOrder/Purchase.jsp";
		return "find";
	}
	/**
	 * ���������ȫ������
	 * */
	public void updateAllLibraryMaterials(){
		PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		JSONArray json=new JSONArray();
		json=JSONArray.fromObject(caterials);
		List list=json.toList(json, HashMap.class);
		if(StringUtil.checkNotNull(poid)){
			pur.updateLibrary(list,poid);
		}else{
			pur.insertLibrary(list);
		}
		
		Message mess=new Message();
		mess.setState(true);
		mess.setMessage("�ύ�ɹ�");
		this.getOut().print(StringUtil.transObjectToJson(mess));
	}
	
	/**
	 * �������������
	 * */
	 public void insertWare(){
		 PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		 i=pur.insertWare(empid);
		 Message mess=new Message();
		 mess.setState(true);
		 mess.setMessage("�����ɹ�");
		 this.getOut().print(StringUtil.transObjectToJson(mess));
	 }
	 /**
		 * ȷ������,��������������ݸ��ĵ�ԭ�ϱ���,�����Ľ����״̬Ϊ�����
		 */
	public String confimOut(){
		PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		pur.comfirmOut(poid);
		return "selectOutList";
	}
	/**
	 * �ڽ������鵥����ʾ������,����ʱ��,������
	 * */
	public String selectWare(){
		PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		selectlist=pur.selectList(empid);
		this.target="/module/purchaseOrder/Purchase.jsp";
		return "ware";
	}
	/***
	 * �鿴����
	 */
    public String findPur2(){
		PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		list=pur.selectPurchase2(poid);
		list2=pur.selectPurchase();
		map2=pur.findPurchaseById(poid);
		this.target="/module/purchaseOrder/PurchaseB.jsp";
		return "select";
	}
    /**
	 * ��ѯ����Ա��
	 * */
	public String selectW(){
		PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		list=pur.selectWare();
		
		this.target="insertw";
		return "/module/purchaseOrder/InsertPurchase.jsp";
	}
	public Map getMap2() {
		return map2;
	}

	public void setMap2(Map map2) {
		this.map2 = map2;
	}

	public List getSelectlist() {
		return selectlist;
	}

	public void setSelectlist(List selectlist) {
		this.selectlist = selectlist;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getPoid() {
		return poid;
	}

	public void setPoid(String poid) {
		this.poid = poid;
	}

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public PageEntity getPage() {
		return page;
	}
	public void setPage(PageEntity page) {
		this.page = page;
	}
	public String getNowpage() {
		return nowpage;
	}
	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}
	public String getPageN() {
		return pageN;
	}
	public void setPageN(String pageN) {
		this.pageN = pageN;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List getList3() {
		return list3;
	}

	public void setList3(List list3) {
		this.list3 = list3;
	}

	public String getCaterials() {
		return caterials;
	}

	public void setCaterials(String caterials) {
		this.caterials = caterials;
	}

	public List getList2() {
		return list2;
	}

	public void setList2(List list2) {
		this.list2 = list2;
	}

	

}
