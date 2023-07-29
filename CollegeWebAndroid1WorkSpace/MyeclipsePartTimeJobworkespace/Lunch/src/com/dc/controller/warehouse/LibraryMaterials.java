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

	private List list;					//查询数组
	private List list2;					
	private List list3;					
	private String caterials;           //JSON材料
	private String caterialname;		//材料名称
	private String demand;				//材料数量
	private String univalent;			//材料单价
	private String total;				//材料总价
	private Map map;					//map数组
	private Map map2;					//map数组
	private String target;				//链接LibraryMaterials.jsp出库详情
	private String caterialid;			//修改出库详情表的材料id
	private List selectlist;
	private String empid;				//角色ID
	private String warehouseid;			//出库详情id
	private String date;				//新增出库详情单时间
	private String listid;				//新增出库详情单编号
	private String outstate;			//出库状态默认0为未出库,1为出库
	private String empuser;
	private int i;
	/**
	 * 查询出库详情表
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
	 * 出库详情表全部保存
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
		mess.setMessage("提交成功");
		this.getOut().print(StringUtil.transObjectToJson(mess));
	}
	/**
	 * 确定出库,将出库详情表数据更改到原料表中,并更改出库表状态为已完成
	 */
	public String confimOut(){
		WarehouseDao ware=new WarehouseDaoImpl();
		ware.comfirmOut(warehouseid);
		return "selectOutList";
	}
	
	/**
	 * 在出库详情单中显示出库人,出库时间,出库编号
	 * */
	public String selectWare(){
		WarehouseDao ware=new WarehouseDaoImpl();
		selectlist=ware.selectList(empid);
		this.target="/module/checkout/LibraryMaterials.jsp";
		return "ware";
	}
	/***
	 * 查看详情
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
	 * 查询所有员工
	 * */
	public String selectW(){
		WarehouseDao ware=new WarehouseDaoImpl();
		list=ware.selectWare();
		
		this.target="insertw";
		return "/module/checkout/InsertWare.jsp";
	}
	
	/**
	 * 新增出库详情表
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
		 mess.setMessage("新增成功");
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
