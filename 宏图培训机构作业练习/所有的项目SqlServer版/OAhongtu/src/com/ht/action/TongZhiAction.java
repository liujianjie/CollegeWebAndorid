package com.ht.action;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ht.common.BaseAction;
import com.ht.service.ITongZhiService;
import com.ht.vo.Emp;
import com.ht.vo6.Msg;



public class TongZhiAction extends BaseAction{
	ITongZhiService itz=(ITongZhiService)getService("tService");
	
	
	private List list;
	
	private Long msgid;
	private Msg msg;
	
	private List listEmp;
	
	String leixing;
	
	//��ѯԱ��֪ͨ
	public String list1(){
		list=itz.TongZhilist1();
		ToRequest("list", list);
		ToRequest("num", 1);
		
		return "totongzhi";
	}
	//��ѯѧ��֪ͨ
	public String list2(){
		
		System.out.println("������");
		
		list=itz.TongZhilist2();
		
		ToRequest("list", list);
		ToRequest("num", 2);
		
		return "totongzhi";
	}
	
	
	//�鿴����Ա������(�ѷ���)
	public String list3(){
		
		System.out.println("������list3");		
		
		list=itz.TongZhilist3();
		
		ToRequest("list", list);
		ToRequest("num", 1);
		
		return "totongzhi2";
	}
	//�鿴����ѧ������
	public String list4(){
		
		System.out.println("������list4");
		
		list=itz.TongZhilist4();
		
		ToRequest("list", list);
		ToRequest("num", 2);
		
		return "totongzhi2";
	}
	
	

//��ѯδ��������
	public String release(){
		
		System.out.println("������");
		
		list =itz.release();
		
		
		return "release";
	}
	
	//��ѯ����Ա��(f1)
	public String selAllEmp(){
		System.out.println("������111111111111111");
		 listEmp=itz.findAllEmp();
		 System.out.println("size: "+listEmp.size());
		return "success";
		
	}
	
	
	
	//ȥ�޸Ĺ���ҳ��
	public String toupd(){
		System.out.println("������toupd");
		HttpServletRequest req=ServletActionContext.getRequest();
		String id=req.getParameter("id");
		System.out.println("id:"+id);
		
		Msg m=itz.getMsgById(Integer.parseInt(id));
		listEmp=itz.findAllEmp();
		ToRequest("m", m);
		ToRequest("listEmp", listEmp);
		
		return "tongzhi_upd";
	}
	
	//�޸Ĺ���
	public String upd(){
		System.out.println("�����ˡ���������������������");
				
		boolean bln=itz.updTongzhi(msg);
		if(bln){
			System.out.println("�޸Ĺ���ɹ�");
		}else{
			System.out.println("�޸Ĺ���ʧ��");
		}
		
		//��֪ͨ����
		List listType=itz.selTongzhiType(msg.getMsgid());
		Map map=(Map)listType.get(0);
		BigDecimal b=(BigDecimal)map.get("MSGFACE");
		int i=b.intValue();
		System.out.println("�������ͣ� "+i);
		if(i==1){
			return "flush_tongzhi1";
		}else if(i==2){
			return "flush_tongzhi2";
		}
		
		return null;
	}
	
	
//��ӹ���
	public String add(){
		msg.setMsgstatus(0);
	
		boolean bln= itz.TongZhiadd(msg);
		if(bln){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("���ʧ��");
		}
		

		if(msg.getMsgface()==1){
			return "flush_tongzhi1";
		}else if(msg.getMsgface()==2){
			return "flush_tongzhi2";
			
		}
		return null;
	}
	
	
//��������
	public String fabu(){
		System.out.println("6666666666666");
		HttpServletRequest req=ServletActionContext.getRequest();
		String strid=req.getParameter("id");
		System.out.println("id="+strid);
		
		int id=Integer.parseInt(strid);
		
		//�ķ���״̬
		boolean bln1=itz.updStatus(id);
		if(bln1){
			System.out.println("�޸ĳɹ�");
		}else{
			System.out.println("�޸�ʧ��");
		}
		//�ѷ����˸ĳɵ�ǰ��½�û�
		Emp emp=(Emp)req.getSession().getAttribute("teacher");
		String ename=emp.getEname();
		boolean bln3=itz.upd_faburen(id, ename);
		if(bln3){
			System.out.println("�޸ķ����˳ɹ�");
		}else{
			System.out.println("�޸ķ�����ʧ��");
		}
		
		//��ȡϵͳ��ǰʱ��
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
		
		System.out.println("ϵͳʱ�䣺"+time);
		
//		
		//���淢��ʱ��
		boolean bln2=itz.saveFabuTime(id, time);
		if(bln2){
			System.out.println("����ɹ�");
		}else{
			System.out.println("����ʧ��");
		}
		
//		//��֪ͨ����
		List listType=itz.selTongzhiType(id);
		Map map=(Map)listType.get(0);
		BigDecimal b=(BigDecimal)map.get("MSGFACE");
		int i=b.intValue();
		System.out.println("�������ͣ� "+i);
		if(i==1){
			return "flush_tongzhi1";
		}else if(i==2){
			return "flush_tongzhi2";
		}
		
		return null;
	}
	
	
	//ɾ��֪ͨ
	public String del(){		
		
		HttpServletRequest req=ServletActionContext.getRequest();
		String id=req.getParameter("id");
		
		//��֪ͨ����
		List listType=itz.selTongzhiType(Integer.parseInt(id));
		
		System.out.println("size��С��"+listType.size());
		
		Map map=(Map)listType.get(0);
		BigDecimal b=(BigDecimal)map.get("MSGFACE");
		int i=b.intValue();
		System.out.println("�������ͣ� "+i);
		
		Msg m=itz.getMsgById(Integer.parseInt(id));
		boolean bln=itz.delTongzhi(m);
		if(bln){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
		
		
		if(i==1){
			return "flush_tongzhi1";
		}else if(i==2){
			return "flush_tongzhi2";
		}
		
		return null;
	}
	
	
	public String upGG(){		
		//����֪ͨ;
		int i=msg.getMsgid();
		System.out.println(i+" shah ");
		
		System.out.println(msg);
		Msg ms=itz.getMsgById(i);
		
		this.ToRequest("ms",ms);
		return release();
	}
	
	//�鿴֪ͨ����	
	public String xq(){
		
//		System.out.println(msg.getMsgid());
//		itz.xq(msg);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		System.out.println(id);
		
		Msg msg=itz.getMsgById(Integer.parseInt(id));
		ToRequest("msg", msg);
		return "details";
	}
	
	
	
	
	public String toadd(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		System.out.println("ҳ�洫�����ģ�"+id);
		int num=Integer.parseInt(id);
		ToRequest("num", num);
		System.out.println("num:  "+num);
		return "addpage";
	}
	
	
	public Long getMsgid() {
		return msgid;
	}
	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}
	public Msg getMsg() {
		return msg;
	}
	public void setMsg(Msg msg) {
		this.msg = msg;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public List getListEmp() {
		return listEmp;
	}
	public void setListEmp(List listEmp) {
		this.listEmp = listEmp;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
		
	
	
	
}
