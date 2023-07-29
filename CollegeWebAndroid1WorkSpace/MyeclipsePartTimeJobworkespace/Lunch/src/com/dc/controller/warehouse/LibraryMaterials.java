package com.dc.controller.warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import com.dc.dao.warehouse.WarehouseDao;
import com.dc.dao.warehouse.WarehouseDaoImpl;
import com.dc.entity.Message;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class LibraryMaterials extends BaseAction{

	private List list;					//��ѯ����
	private List list2;					
	private List list3;					
	private String caterials;           //JSON����
	private String caterialname;		//��������
	private String demand;				//��������
	private String univalent;			//���ϵ���
	private String total;				//�����ܼ�
	private Map map;					//map����
	private Map map2;					//map����
	private String target;				//����LibraryMaterials.jsp��������
	private String caterialid;			//�޸ĳ��������Ĳ���id
	private List selectlist;
	private String empid;				//��ɫID
	private String warehouseid;			//��������id
	private String date;				//�����������鵥ʱ��
	private String listid;				//�����������鵥���
	private String outstate;			//����״̬Ĭ��0Ϊδ����,1Ϊ����
	private String empuser;
	private int i;
	/**
	 * ��ѯ���������
	 * */
	public String findLibraryMaterials(){
		
		WarehouseDao ware=new WarehouseDaoImpl();
		list=ware.selectLibraryMaterials();
		map=ware.findWarehouseById(warehouseid);
		list3=ware.findemp();
		this.target="/module/checkout/LibraryMaterials.jsp";
		return "select";
	}
	
	
	/**
	 * ���������ȫ������
	 * */
	public void updateAllLibraryMaterials(){
		WarehouseDao ware=new WarehouseDaoImpl();
		JSONArray json=new JSONArray();
		json=JSONArray.fromObject(caterials);
		List list=json.toList(json, HashMap.class);
		if(StringUtil.checkNotNull(warehouseid)){
			ware.updateLibrary(list,warehouseid);
		}else{
			ware.insertLibrary(list);
		}
		
		Message mess=new Message();
		mess.setState(true);
		mess.setMessage("�ύ�ɹ�");
		this.getOut().print(StringUtil.transObjectToJson(mess));
	}
	/**
	 * ȷ������,��������������ݸ��ĵ�ԭ�ϱ���,�����ĳ����״̬Ϊ�����
	 */
	public String confimOut(){
		WarehouseDao ware=new WarehouseDaoImpl();
		ware.comfirmOut(warehouseid);
		return "selectOutList";
	}
	
	/**
	 * �ڳ������鵥����ʾ������,����ʱ��,������
	 * */
	public String selectWare(){
		WarehouseDao ware=new WarehouseDaoImpl();
		selectlist=ware.selectList(empid);
		this.target="/module/checkout/LibraryMaterials.jsp";
		return "ware";
	}
	/***
	 * �鿴����
	 */
    public String findLibraryMaterials2(){
		WarehouseDao ware=new WarehouseDaoImpl();
		list=ware.selectLibraryMaterials2(warehouseid);
		list2=ware.selectLibraryMaterials();
		map2=ware.findWarehouseById(warehouseid);
		this.target="/module/checkout/LibrayMaterialsB.jsp";
		return "select";
	}
	/**
	 * ��ѯ����Ա��
	 * */
	public String selectW(){
		WarehouseDao ware=new WarehouseDaoImpl();
		list=ware.selectWare();
		
		this.target="insertw";
		return "/module/checkout/InsertWare.jsp";
	}
	
	/**
	 * �������������
	 * */
	 public void insertWare(){
		 WarehouseDao ware=new WarehouseDaoImpl();
		// HttpSession hs=this.getSession();
		// Map map=(Map) hs.getAttribute("userinfo");
		 //String empid=map.get("emp_id").toString();
		 //String empuser=map.get("emp_user").toString();
		 i=ware.insertWare(empid);
		 Message mess=new Message();
		 mess.setState(true);
		 mess.setMessage("�����ɹ�");
		 this.getOut().print(StringUtil.transObjectToJson(mess));

		 
	 }

	 
	 
	public List getList2() {
		return list2;
	}
	public void setList2(List list2) {
		this.list2 = list2;
	}
	public Map getMap2() {
		return map2;
	}
	public List getList3() {
		return list3;
	}
	public void setList3(List list3) {
		this.list3 = list3;
	}
	public void setMap2(Map map2) {
		this.map2 = map2;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public List getSelectlist() {
		return selectlist;
	}
	public void setSelectlist(List selectlist) {
		this.selectlist = selectlist;
	}
	public String getCaterialid() {
		return caterialid;
	}
	public void setCaterialid(String caterialid) {
		this.caterialid = caterialid;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getCaterialname() {
		return caterialname;
	}
	public void setCaterialname(String caterialname) {
		this.caterialname = caterialname;
	}
	public String getDemand() {
		return demand;
	}
	public void setDemand(String demand) {
		this.demand = demand;
	}
	public String getUnivalent() {
		return univalent;
	}
	public void setUnivalent(String univalent) {
		this.univalent = univalent;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCaterials() {
		return caterials;
	}
	public void setCaterials(String caterials) {
		this.caterials = caterials;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getListid() {
		return listid;
	}
	public void setListid(String listid) {
		this.listid = listid;
	}
	public String getOutstate() {
		return outstate;
	}
	public void setOutstate(String outstate) {
		this.outstate = outstate;
	}
	public String getEmpuser() {
		return empuser;
	}
	public void setEmpuser(String empuser) {
		this.empuser = empuser;
	}


	
}
