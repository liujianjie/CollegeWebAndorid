package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.jmx.snmp.UserAcl;
import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import serviceI.IQqService;
import serviceImp.QqServiceImp;
import sun.org.mozilla.javascript.internal.json.JsonParser;
import vo.AndroidQqDynamic;
import vo.AndroidQqDynamicList;
import vo.AndroidQqHy;
import vo.AndroidQqHyList;
import vo.AndroidQqMessage;
import vo.AndroidQqMessageList;
import vo.AndroidQqUser;
import vo.AndroidQqUserList;
import vo.ResultFail;
import vo.ResultDynamic;

public class QQ_Service {
	HttpServletResponse response=ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	private String zhanghao;
	private String mima;
	private AndroidQqUser qquser;//���
	private ResultFail result;//ʧ����
	private Long qqId;
	
	private Long hyId;//��������
	private AndroidQqHyList qqhylist;//���غ����б�
	private List qqhyidlist;//QQ���ѵĹ��ж����б�
	
	private AndroidQqHy qqhy;//QQ����
	
	private List qqdtzonglist;//���еĺ��Ѷ�̬list
	private AndroidQqDynamicList qqdtlist;//���غ��Ѷ�̬�б�
	private AndroidQqDynamic qqdynamic;//���
	
	private int PageCount;//��̬һ�ж��ٸ�
	private int CurrPage;//ҳ��
	
	private AndroidQqMessage msg;//������Ϣ
	private AndroidQqMessageList chartlist;//��Ϣ�б�
	private AndroidQqMessageList msglist;//������Ϣ�б�
	IQqService ss = new QqServiceImp();
	
	//1.����û� �����涨���qquser��ֱ�ӻ�ȡ
	public String zhuce(){
		try{
			PrintWriter out = response.getWriter();
			System.out.println("������ע��");
			System.out.println(qquser.getQqAddress()+qquser.getQqZhanghao());
			boolean bln=ss.addUser(qquser);
			if(bln){
				result=new ResultFail(1);
			}else{
				result=new ResultFail(0);
			}
			out.print(JSON.toJSONString(result));
			
			out.close();
		}catch (Exception e) {
		}
		return null;
	}
	//1.2�޸��û���Ϣ
	public String alertqquser(){
		try{
			PrintWriter out = response.getWriter();
			System.out.println("�������޸�");
			boolean bln=ss.alertUser(qquser);
			if(bln){
				result=new ResultFail(1);
			}else{
				result=new ResultFail(0);
			}
			out.print(JSON.toJSONString(result));
			
			out.close();
		}catch (Exception e) {
		}
		return null;
	}
	//�ϴ�ͷ��
	//�ϴ����ļ�����
	private File[] file;
	//�ϴ����ļ�����
	//private String[] fileFileName;
	private String[] qq_touxiang;//���õ�qqͷ����Ƭ
	//�ϴ����ļ�����	  
	private String []fileContentType;
	//��ȡϵͳ�̷�·���ķָ�����windows:\ linux:/��
	//private String savePath="E:"+System.getProperty("file.separator");
	//���ļ����浽��Ŀ����·��
	//�Ȼ�ȡ��Ŀ����·����ServletActionContext.getRequest().getRealPath("files")
	private String savePath=ServletActionContext.getRequest().getRealPath("image")+"\\";
	public String updfile(){
		System.out.println("�����ˡ�����");
		//�����ļ�
		//���汾�ص�·��
		for(int i=0;i<file.length;i++){
			try {
				System.out.println(qq_touxiang[i]);
				FileOutputStream fos=new FileOutputStream(this.savePath+qq_touxiang[i]);
				//��ȡ�ļ�����i
				FileInputStream fil=new FileInputStream(this.file[i]);
				//ÿ�ζ��� д���Ĵ�С
				byte[] b=new byte[1024];
				int real=fil.read(b);
				int ii=0;
				while(real>0){
					fos.write(b, 0, real);
					
					real=fil.read(b);//ÿ�ζ��� д�� �ļ�����ͻ���ȥ�ⲿ�֣���������1kb1kbд�� ֪�� ���벻����
					
					ii++;
				}
				System.out.println(ii);
				fos.close();fil.close();
				//����json
				PrintWriter out = response.getWriter();
				result = new ResultFail(1);
				out.print(JSON.toJSONString(result));
				out.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//2.��¼ �޸�״̬��ȡ��Ϣ�ܻ�ȡ�Լ�������Ϣ
	public String execute() {
		System.out.println("������QQ������");
		try{
			PrintWriter out = response.getWriter();
			//��ѯ ��װ����Ϣ��json
			
			List list=ss.selUser(zhanghao,mima);
			if(list.size()!=0){
				System.out.println("��¼�ɹ�");
				Map usermap = (Map)list.get(0);
				Long qqId = Long.parseLong(usermap.get("QQ_ID")+"");
				//QQ״̬��Ϊ����
				boolean bln=ss.UpdUserStatu(qqId);
				System.out.println(bln);
				//����id��ȡ�û���Ϣ
				AndroidQqUser qqusers = ss.getUser(qqId);
				qqusers.setResult(1);//���ý��
				//��װ��jsonobject
				out.print(JSON.toJSONString(qqusers));
			}else{
				//��¼ʧ��
				System.out.println("��¼ʧ��");
				result=new ResultFail(0);
				System.out.println(JSON.toJSONString(result));
				out.print(JSON.toJSONString(result));
			}
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//2.2��ȡ�û���Ϣ
	public String selqquser(){
		System.out.println("��ȡֵ"+qqId);
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			AndroidQqUser qquser = ss.getUser(qqId);
			if(qquser!=null){
				qquser.setResult(1);
				out.print(JSON.toJSONString(qquser));
			}else{
				qquser.setResult(0);
				out.print(JSON.toJSONString(qquser));
			}		
			out.close();
		
		return null;
	}
	//3.��ѯ�����б�
	public String selhaoyou(){
		System.out.println("�����˲�ѯ����"+qqId);
		try{
			PrintWriter out = response.getWriter();
			//����qq_id��ѯ���� ��װΪArraylist
			List hylist = ss.selhy(qqId);
			if(hylist.size()!=0){
				//��hylist������ָ����bean
				List qqhylists = new ArrayList<AndroidQqHy>();
				for(int i=0;i<hylist.size();i++){
					Map map = (Map)hylist.get(i);
					Long hyid = Long.parseLong(map.get("HY_ID")+"");
					qqhy = ss.getQqhy(hyid);
					qqhylists.add(qqhy);
				}
				qqhylist = new AndroidQqHyList(1, qqhylists);
				out.print(JSON.toJSONString(qqhylist));
			}else{//û�к���
				result = new ResultFail(0);
				out.print(JSON.toJSONString(result));
			}
			out.close();
		}catch (Exception e) {
		}
		return null;
	}
	//4.��ȡ���Ѷ�̬�б�һ��ʼ��5��
	public String dynamic(){
		try{
			System.out.println(CurrPage);
			System.out.println(PageCount);
			PrintWriter out = response.getWriter();
			//����qq_id��ѯ���� ��װΪArraylist
			List hylist = ss.selhy(qqId);//��3���ֶΣ���Ҫ��ȡmyqq_id��hyqq_id
			//����myqq_id����hyqq_id���Ҷ�̬ ����qqIdɸѡ���ѵ�
			qqhyidlist = new ArrayList();//QQ����id�б�
			for(int i=0;i<hylist.size();i++){
				Map hymap = (Map)hylist.get(i);
				Long hyqq_id = Long.parseLong(hymap.get("HYQQ_ID")+"");
				Long myqq_id = Long.parseLong(hymap.get("MYQQ_ID")+"");
				if(hyqq_id==qqId){//����Լ�Ϊ����
					System.out.println("������hyqq_id");
					qqhyidlist.add(myqq_id);
				}else if(myqq_id==qqId){
					System.out.println("������myqq_id");
					qqhyidlist.add(hyqq_id);
				}
			}
			qqhyidlist.add(qqId);//������
			List dynamiclist = ss.seldynamic(qqhyidlist,(CurrPage-1)*PageCount,PageCount);//QQ���Ѷ�̬ �ǿ�ʼ�ڼ����ͽ�����
			List dynamiclists = new ArrayList<AndroidQqDynamic>(dynamiclist.size());//ת��Ϊdynamic����list
			for(int j=0;j<dynamiclist.size();j++){
				Map map = (Map)dynamiclist.get(j);
				Long dyId=Long.parseLong(map.get("DY_ID")+"");
				AndroidQqDynamic dy = ss.getdynamic(dyId);
				dynamiclists.add(dy);
			}
			qqdtlist = new AndroidQqDynamicList(1,dynamiclists);
			out.print(JSON.toJSONString(qqdtlist));
			
			out.close();
		}catch (Exception e) {
		}
		
		return null;
	}
	//5.��Ӷ�̬�ӿ�
	//�ϴ����ļ�����
	private String[] dynamicnamephoto;
	public String adddynamic(){
		//����json
		try {
			PrintWriter out = response.getWriter();
			boolean bln= ss.addQqDt(qqdynamic);
			System.out.println(bln);		
			//�ϴ��ɹ������»�ȡˢ��ҳ��
			if(bln){
				result = new ResultFail(1);
			}else{
				result = new ResultFail(0);
			}
			out.print(JSON.toJSONString(result));
			out.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//��ҳ����Ҫ ͼƬ���ϴ� �ָ� qqdynamic.dyPhotos
//			String photos[]=qqdynamic.getDyPhotos().split(",");
//			for(int i=0;i<photos.length-1;i++){//ĩβ�Ĳ�Ҫ
//				
//			}
		return null;
	}
	//5.����ͼƬ ����
	public String saveDtPhotos(){
		try {
			PrintWriter out = response.getWriter();
			System.out.println(file[0].getName());
			FileOutputStream fos=new FileOutputStream(this.savePath+dynamicnamephoto[0]);
			//��ȡ�ļ�����i
			FileInputStream fil=new FileInputStream(this.file[0]);
			//ÿ�ζ��� д���Ĵ�С
			byte[] b=new byte[1024];
			int real=fil.read(b);
			int ii=0;
			while(real>0){
				fos.write(b, 0, real);
				
				real=fil.read(b);//ÿ�ζ��� д�� �ļ�����ͻ���ȥ�ⲿ�֣���������1kb1kbд�� ֪�� ���벻����
				
				ii++;
			}
			System.out.println(ii);
			fos.close();fil.close();
			result = new ResultFail(1);
			out.print(JSON.toJSONString(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//6.������Ϣ ���������Ϣ
	public String sendMessage(){
		try{
			PrintWriter out = response.getWriter();
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       		Date dd=new Date();
       		msg.setMDate(dd);
			boolean bln = ss.addMsg(msg);
			System.out.println(bln);
			//���سɹ��ȴ�ͼƬȡ�� ��ӵ�list��
			if(bln){
				result = new ResultFail(1);//�ɹ�
			}else{
				result = new ResultFail(0);//ʧ�� �͵���ʧ�ܵ��ĸ�ͼƬ
			}
			out.print(JSON.toJSONString(result));
			
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return null;
	}
	//7.��ȡ��Ϣ�б�ȥ���ظ����� ���� 
	public String selMessageList(){
		System.out.println(qqId);
		try{
			PrintWriter out = response.getWriter();
			List list=ss.getmidOfMsg(qqId);
			List charts = new ArrayList<AndroidQqMessage>();
			for(int j=0;j<list.size();j++){
				msg=new AndroidQqMessage();
				Map map = (Map)list.get(j);
				msg.setQqId(Long.parseLong(map.get("QQ_ID")+""));
				msg.setQqZhanghao(map.get("QQ_ZHANGHAO")+"");
				msg.setQqName(map.get("QQ_NAME")+"");
				msg.setQqTouxiang(map.get("QQ_TOUXIANG")+"");
				msg.setMJsid(Long.parseLong(map.get("M_JSID")+""));
				msg.setMZhanghao(map.get("M_ZHANGHAO")+"");
				msg.setMName(map.get("M_NAME")+"");
				msg.setMTouxiang(map.get("M_TOUXIANG")+"");
				charts.add(msg);
			}
			if(charts.size()!=0){
				chartlist = new AndroidQqMessageList(1, charts);
				out.print(JSON.toJSONString(chartlist));
			}else{
				result = new ResultFail(0);
				out.println(JSON.toJSONString(result));
			}
			out.close();
		}catch(Exception e){
		}	
		return null;
	}
	//7.��ȡ��Ϣ ��ѯ���������Լ�id����Ϣ ���ҷ����ߵ�idҲҪ�� MJsid ��qqid
	public String receiveMessage(){
		System.out.println(qqId);
		System.out.println(hyId);
		try{
			PrintWriter out = response.getWriter();
			//��ѯ��Ϣ��id
			List list = ss.getChartList(qqId,hyId);
			List msglists = new ArrayList<AndroidQqMessage>();
			for(int i=0;i<list.size();i++){
				Map map = (Map) list.get(i);
				Long id = Long.parseLong(map.get("M_ID")+"");
				System.out.println(id);
				AndroidQqMessage msgs=ss.getMsg(id);
				msglists.add(msgs);
			}
			if(msglists.size()!=0){//����Ϣ
				msglist = new AndroidQqMessageList(1, msglists);
				out.print(JSON.toJSONString(msglist));
			}else{
				result = new ResultFail(0);
				out.println(JSON.toJSONString(result));
			}
			out.close();
		}catch(Exception e){
		}	
		return null;
	}
	//8.��Ӻ��� ���� ���� myqq�ֶη����� ��Ϊ���ҷ����
	public String becomeQqhy(){//״̬Ϊ0
		try{
			PrintWriter out = response.getWriter();
			boolean bln=ss.addQqhy(qqhy);
			if(bln){
				result=new ResultFail(1);
			}else{
				result=new ResultFail(0);
			}
			out.print(JSON.toJSONString(result));
			out.close();
		}catch(Exception e){
		}
		return null;
	}
	//9.��ȡ��������ӿ� ��ѯ���Լ��ĺ������ hyid �� ״̬Ϊ0���� �͵�3������ ���ǵ��ĸ��ǻ�ȡ�����б� ����ǻ�ȡ�����б�
	public String selhaoyouOfmy(){
		System.out.println(qqId);
		//״̬Ϊ1���Լ���Ϣ
		try{
			PrintWriter out = response.getWriter();
			
			List list = ss.selQqhyOfmy(qqId);//������ŵ����б�
			if(list.size()!=0){
				//�õ�List����
				List hysqlist=new ArrayList<AndroidQqHy>();
				for(int i=0;i<list.size();i++){
					Map map = (Map)list.get(i);
					Long hy_id = Long.parseLong(map.get("HY_ID")+"");
					qqhy=ss.getQqhy(hy_id);
					hysqlist.add(qqhy);
				} 
				qqhylist = new AndroidQqHyList(1, hysqlist);
				out.print(JSON.toJSONString(qqhylist));
			}else{//û�к�������
				result = new ResultFail(0);
				out.print(JSON.toJSONString(result));
			}
			out.close();
		}catch(Exception e){
			
		}
		return null;
	}
	//10.ͬ����ӻ��߾ܾ����ѽӿ� �����޸�״̬ ����hy_id
	private int hystatu;
	public String UpdHaoYou(){
		System.out.println(hyId);
		System.out.println(hystatu);
		try{
			PrintWriter out = response.getWriter();
			AndroidQqHy qqhys = ss.getQqhy(hyId);
			qqhys.setHyStatu((long)hystatu);
			boolean bln=ss.updHaoYouStatu(qqhys);
			System.out.println(bln);
			if(bln){//�ɹ�ʧ��
				result = new ResultFail(1);
			}else{
				result = new ResultFail(0);
			}
			out.print(JSON.toJSONString(result));
			
			out.close();
		}catch(Exception e){
		}
		return null;
	}
	//11.���ݲ�ѯ��Ϣ��ȡ������Ϣ
	private String xinxi;
	private AndroidQqUserList userlist;
	public String seluserlist(){
		System.out.println(xinxi);	
		try{
			PrintWriter out = response.getWriter();
			
			List list = ss.selUserList(xinxi);
			List<AndroidQqUser> userlists = new ArrayList<AndroidQqUser>(); 
			if(list.size()!=0){
				for(int i=0;i<list.size();i++){
					Map map = (Map) list.get(i);
					Long id = Long.parseLong(map.get("QQ_ID")+"");
					AndroidQqUser qquser= ss.getUser(id);
					userlists.add(qquser);
				}
				userlist = new AndroidQqUserList(1, userlists);
				out.print(JSON.toJSONString(userlist));
			}else{//û��
				result = new ResultFail(0);
				out.print(JSON.toJSONString(result));
			}
			
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//ɾ������
	private Long hyqqId;
	public String DelHaoYou(){
		try{
			PrintWriter out = response.getWriter();
			List list = ss.getHyList(hyqqId,qqId);
			Map map = (Map) list.get(0);
			Long hy_id = Long.parseLong(map.get("HY_ID")+"");
			boolean bln = ss.delHyuser(hy_id);
			System.out.println(bln);
			if(bln){//�ɹ�ʧ��
				result = new ResultFail(1);
			}else{
				result = new ResultFail(0);
			}
			out.print(JSON.toJSONString(result));
			
			out.close();
		}catch(Exception e){
		}
		return null;
	}
	//��ȡ����
	public String gethyuser(){
		try{
			PrintWriter out = response.getWriter();
			List list = ss.getHyList(hyqqId,qqId);
			Map map = (Map) list.get(0);
			Long hy_id = Long.parseLong(map.get("HY_ID")+"");
			AndroidQqHy bln = ss.getQqhy(hy_id);
			System.out.println(bln);
			if(bln!=null){//�ɹ�ʧ��
				bln.setResult(1);
			}else{
				bln.setResult(0);
			}
			out.print(JSON.toJSONString(bln));
			
			out.close();
		}catch(Exception e){
		}
		return null;
	}
	//�������
	private int myqqfenzu;
	private int hyqqfenzu;
	public String savehaoyou(){
		try{
			PrintWriter out = response.getWriter();
			AndroidQqHy android=ss.getQqhy(hyId);
			android.setMyqqFengzu((long)myqqfenzu);
			android.setHyqqFengzu((long)hyqqfenzu);
			boolean bln = ss.updHaoYouStatu(android);
			System.out.println(bln);
			if(bln){//�ɹ�ʧ��
				result = new ResultFail(1);
			}else{
				result = new ResultFail(0);
			}
			out.print(JSON.toJSONString(result));
			
			out.close();
		}catch(Exception e){
		}
		return null;
	}
	//��ȡ��Ϣ����
	private Long mJsid;
	public String getMsgXq(){
		System.out.println(mJsid);
		System.out.println(qqId);
		try{
			PrintWriter out = response.getWriter();
			List list = ss.getMsgXq(qqId, mJsid);
			Map map = (Map)list.get(0);
			Long m_id = Long.parseLong(map.get("M_ID")+"");
			AndroidQqMessage qqmessage=ss.getMsg(m_id);
			if(qqmessage!=null){//�ɹ�ʧ��
				qqmessage.setResult(1);
			}else{
				qqmessage.setResult(0);
			}
			out.print(JSON.toJSONString(qqmessage));
			
			out.close();
		}catch(Exception e){
		}
		return null;
	}
	
	public Long getmJsid() {
		return mJsid;
	}
	public void setmJsid(Long mJsid) {
		this.mJsid = mJsid;
	}
	public int getMyqqfenzu() {
		return myqqfenzu;
	}
	public void setMyqqfenzu(int myqqfenzu) {
		this.myqqfenzu = myqqfenzu;
	}
	public int getHyqqfenzu() {
		return hyqqfenzu;
	}
	public void setHyqqfenzu(int hyqqfenzu) {
		this.hyqqfenzu = hyqqfenzu;
	}
	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

	public Long getQqId() {
		return qqId;
	}

	public void setQqId(Long qqId) {
		this.qqId = qqId;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

//	public String[] getFileFileName() {
//		return fileFileName;
//	}
//
//	public void setFileFileName(String[] fileFileName) {
//		this.fileFileName = fileFileName;
//	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public String[] getQq_touxiang() {
		return qq_touxiang;
	}

	public void setQq_touxiang(String[] qq_touxiang) {
		this.qq_touxiang = qq_touxiang;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public AndroidQqUser getQquser() {//�û�ע��
		return qquser;
	}

	public void setQquser(AndroidQqUser qquser) {
		this.qquser = qquser;
	}

	public int getPageCount() {
		return PageCount;
	}

	public void setPageCount(int pageCount) {
		PageCount = pageCount;
	}

	public int getCurrPage() {
		return CurrPage;
	}

	public void setCurrPage(int currPage) {
		CurrPage = currPage;
	}

	public AndroidQqDynamic getQqdynamic() {
		return qqdynamic;
	}

	public void setQqdynamic(AndroidQqDynamic qqdynamic) {
		this.qqdynamic = qqdynamic;
	}

	public AndroidQqMessage getMsg() {
		return msg;
	}

	public void setMsg(AndroidQqMessage msg) {
		this.msg = msg;
	}

	public AndroidQqHy getQqhy() {
		return qqhy;
	}

	public void setQqhy(AndroidQqHy qqhy) {
		this.qqhy = qqhy;
	}

	public Long getHyId() {
		return hyId;
	}

	public void setHyId(Long hyId) {
		this.hyId = hyId;
	}

	public String getXinxi() {
		return xinxi;
	}

	public void setXinxi(String xinxi) {
		this.xinxi = xinxi;
	}
	public int getHystatu() {
		return hystatu;
	}
	public void setHystatu(int hystatu) {
		this.hystatu = hystatu;
	}
	public Long getHyqqId() {
		return hyqqId;
	}
	public void setHyqqId(Long hyqqId) {
		this.hyqqId = hyqqId;
	}
	public String[] getDynamicnamephoto() {
		return dynamicnamephoto;
	}
	public void setDynamicnamephoto(String[] dynamicnamephoto) {
		this.dynamicnamephoto = dynamicnamephoto;
	}
	
}
