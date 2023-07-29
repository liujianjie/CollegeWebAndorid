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
	private AndroidQqUser qquser;//添加
	private ResultFail result;//失败用
	private Long qqId;
	
	private Long hyId;//好友主键
	private AndroidQqHyList qqhylist;//返回好友列表
	private List qqhyidlist;//QQ好友的共有多少列表
	
	private AndroidQqHy qqhy;//QQ好友
	
	private List qqdtzonglist;//所有的好友动态list
	private AndroidQqDynamicList qqdtlist;//返回好友动态列表
	private AndroidQqDynamic qqdynamic;//添加
	
	private int PageCount;//动态一行多少个
	private int CurrPage;//页数
	
	private AndroidQqMessage msg;//发送消息
	private AndroidQqMessageList chartlist;//消息列表
	private AndroidQqMessageList msglist;//聊天消息列表
	IQqService ss = new QqServiceImp();
	
	//1.添加用户 用上面定义的qquser来直接获取
	public String zhuce(){
		try{
			PrintWriter out = response.getWriter();
			System.out.println("进来了注册");
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
	//1.2修改用户信息
	public String alertqquser(){
		try{
			PrintWriter out = response.getWriter();
			System.out.println("进来了修改");
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
	//上传头像
	//上传的文件对象
	private File[] file;
	//上传的文件名称
	//private String[] fileFileName;
	private String[] qq_touxiang;//重置的qq头像照片
	//上传的文件类型	  
	private String []fileContentType;
	//获取系统盘符路径的分隔符（windows:\ linux:/）
	//private String savePath="E:"+System.getProperty("file.separator");
	//将文件保存到项目发布路径
	//先获取项目发布路径：ServletActionContext.getRequest().getRealPath("files")
	private String savePath=ServletActionContext.getRequest().getRealPath("image")+"\\";
	public String updfile(){
		System.out.println("进来了。。。");
		//保存文件
		//保存本地的路径
		for(int i=0;i<file.length;i++){
			try {
				System.out.println(qq_touxiang[i]);
				FileOutputStream fos=new FileOutputStream(this.savePath+qq_touxiang[i]);
				//读取文件对象i
				FileInputStream fil=new FileInputStream(this.file[i]);
				//每次读入 写出的大小
				byte[] b=new byte[1024];
				int real=fil.read(b);
				int ii=0;
				while(real>0){
					fos.write(b, 0, real);
					
					real=fil.read(b);//每次读入 写出 文件对象就会少去这部分，所以这样1kb1kb写出 知道 读入不了了
					
					ii++;
				}
				System.out.println(ii);
				fos.close();fil.close();
				//返回json
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
	
	//2.登录 修改状态获取信息能获取自己个人信息
	public String execute() {
		System.out.println("进来了QQ服务器");
		try{
			PrintWriter out = response.getWriter();
			//查询 封装到信息给json
			
			List list=ss.selUser(zhanghao,mima);
			if(list.size()!=0){
				System.out.println("登录成功");
				Map usermap = (Map)list.get(0);
				Long qqId = Long.parseLong(usermap.get("QQ_ID")+"");
				//QQ状态改为上线
				boolean bln=ss.UpdUserStatu(qqId);
				System.out.println(bln);
				//根据id获取用户信息
				AndroidQqUser qqusers = ss.getUser(qqId);
				qqusers.setResult(1);//设置结果
				//封装成jsonobject
				out.print(JSON.toJSONString(qqusers));
			}else{
				//登录失败
				System.out.println("登录失败");
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
	//2.2获取用户信息
	public String selqquser(){
		System.out.println("获取值"+qqId);
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
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
	//3.查询好友列表
	public String selhaoyou(){
		System.out.println("进来了查询好友"+qqId);
		try{
			PrintWriter out = response.getWriter();
			//根据qq_id查询好友 封装为Arraylist
			List hylist = ss.selhy(qqId);
			if(hylist.size()!=0){
				//将hylist遍历到指定的bean
				List qqhylists = new ArrayList<AndroidQqHy>();
				for(int i=0;i<hylist.size();i++){
					Map map = (Map)hylist.get(i);
					Long hyid = Long.parseLong(map.get("HY_ID")+"");
					qqhy = ss.getQqhy(hyid);
					qqhylists.add(qqhy);
				}
				qqhylist = new AndroidQqHyList(1, qqhylists);
				out.print(JSON.toJSONString(qqhylist));
			}else{//没有好友
				result = new ResultFail(0);
				out.print(JSON.toJSONString(result));
			}
			out.close();
		}catch (Exception e) {
		}
		return null;
	}
	//4.获取好友动态列表一开始的5个
	public String dynamic(){
		try{
			System.out.println(CurrPage);
			System.out.println(PageCount);
			PrintWriter out = response.getWriter();
			//根据qq_id查询好友 封装为Arraylist
			List hylist = ss.selhy(qqId);//有3个字段，主要获取myqq_id和hyqq_id
			//根据myqq_id或者hyqq_id查找动态 根据qqId筛选好友的
			qqhyidlist = new ArrayList();//QQ好友id列表
			for(int i=0;i<hylist.size();i++){
				Map hymap = (Map)hylist.get(i);
				Long hyqq_id = Long.parseLong(hymap.get("HYQQ_ID")+"");
				Long myqq_id = Long.parseLong(hymap.get("MYQQ_ID")+"");
				if(hyqq_id==qqId){//如果自己为好友
					System.out.println("进来吧hyqq_id");
					qqhyidlist.add(myqq_id);
				}else if(myqq_id==qqId){
					System.out.println("进来吧myqq_id");
					qqhyidlist.add(hyqq_id);
				}
			}
			qqhyidlist.add(qqId);//加上我
			List dynamiclist = ss.seldynamic(qqhyidlist,(CurrPage-1)*PageCount,PageCount);//QQ好友动态 是开始第几个和结束的
			List dynamiclists = new ArrayList<AndroidQqDynamic>(dynamiclist.size());//转换为dynamic对象list
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
	//5.添加动态接口
	//上传的文件名称
	private String[] dynamicnamephoto;
	public String adddynamic(){
		//返回json
		try {
			PrintWriter out = response.getWriter();
			boolean bln= ss.addQqDt(qqdynamic);
			System.out.println(bln);		
			//上传成功并重新获取刷新页面
			if(bln){
				result = new ResultFail(1);
			}else{
				result = new ResultFail(0);
			}
			out.print(JSON.toJSONString(result));
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//在页面需要 图片的上传 分割 qqdynamic.dyPhotos
//			String photos[]=qqdynamic.getDyPhotos().split(",");
//			for(int i=0;i<photos.length-1;i++){//末尾的不要
//				
//			}
		return null;
	}
	//5.保存图片 多张
	public String saveDtPhotos(){
		try {
			PrintWriter out = response.getWriter();
			System.out.println(file[0].getName());
			FileOutputStream fos=new FileOutputStream(this.savePath+dynamicnamephoto[0]);
			//读取文件对象i
			FileInputStream fil=new FileInputStream(this.file[0]);
			//每次读入 写出的大小
			byte[] b=new byte[1024];
			int real=fil.read(b);
			int ii=0;
			while(real>0){
				fos.write(b, 0, real);
				
				real=fil.read(b);//每次读入 写出 文件对象就会少去这部分，所以这样1kb1kb写出 知道 读入不了了
				
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
	//6.发送消息 就是添加消息
	public String sendMessage(){
		try{
			PrintWriter out = response.getWriter();
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       		Date dd=new Date();
       		msg.setMDate(dd);
			boolean bln = ss.addMsg(msg);
			System.out.println(bln);
			//返回成功等待图片取消 添加到list中
			if(bln){
				result = new ResultFail(1);//成功
			}else{
				result = new ResultFail(0);//失败 就弹出失败的哪个图片
			}
			out.print(JSON.toJSONString(result));
			
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return null;
	}
	//7.获取消息列表去除重复数据 分组 
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
	//7.获取消息 查询接受者是自己id的消息 并且发送者的id也要有 MJsid 和qqid
	public String receiveMessage(){
		System.out.println(qqId);
		System.out.println(hyId);
		try{
			PrintWriter out = response.getWriter();
			//查询消息的id
			List list = ss.getChartList(qqId,hyId);
			List msglists = new ArrayList<AndroidQqMessage>();
			for(int i=0;i<list.size();i++){
				Map map = (Map) list.get(i);
				Long id = Long.parseLong(map.get("M_ID")+"");
				System.out.println(id);
				AndroidQqMessage msgs=ss.getMsg(id);
				msglists.add(msgs);
			}
			if(msglists.size()!=0){//有消息
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
	//8.添加好友 发起 别搞混 myqq字段放入我 因为是我发起的
	public String becomeQqhy(){//状态为0
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
	//9.获取好友邀请接口 查询有自己的好友添加 hyid 和 状态为0就行 和第3个很像 但是第四个是获取好友列表 这个是获取申请列表
	public String selhaoyouOfmy(){
		System.out.println(qqId);
		//状态为1的自己信息
		try{
			PrintWriter out = response.getWriter();
			
			List list = ss.selQqhyOfmy(qqId);//这里面放的是列表
			if(list.size()!=0){
				//得到List对象
				List hysqlist=new ArrayList<AndroidQqHy>();
				for(int i=0;i<list.size();i++){
					Map map = (Map)list.get(i);
					Long hy_id = Long.parseLong(map.get("HY_ID")+"");
					qqhy=ss.getQqhy(hy_id);
					hysqlist.add(qqhy);
				} 
				qqhylist = new AndroidQqHyList(1, hysqlist);
				out.print(JSON.toJSONString(qqhylist));
			}else{//没有好友申请
				result = new ResultFail(0);
				out.print(JSON.toJSONString(result));
			}
			out.close();
		}catch(Exception e){
			
		}
		return null;
	}
	//10.同意添加或者拒绝好友接口 就是修改状态 传入hy_id
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
			if(bln){//成功失败
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
	//11.根据查询信息获取好友信息
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
			}else{//没有
				result = new ResultFail(0);
				out.print(JSON.toJSONString(result));
			}
			
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//删除好友
	private Long hyqqId;
	public String DelHaoYou(){
		try{
			PrintWriter out = response.getWriter();
			List list = ss.getHyList(hyqqId,qqId);
			Map map = (Map) list.get(0);
			Long hy_id = Long.parseLong(map.get("HY_ID")+"");
			boolean bln = ss.delHyuser(hy_id);
			System.out.println(bln);
			if(bln){//成功失败
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
	//获取好友
	public String gethyuser(){
		try{
			PrintWriter out = response.getWriter();
			List list = ss.getHyList(hyqqId,qqId);
			Map map = (Map) list.get(0);
			Long hy_id = Long.parseLong(map.get("HY_ID")+"");
			AndroidQqHy bln = ss.getQqhy(hy_id);
			System.out.println(bln);
			if(bln!=null){//成功失败
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
	//保存好友
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
			if(bln){//成功失败
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
	//获取消息详情
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
			if(qqmessage!=null){//成功失败
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

	public AndroidQqUser getQquser() {//用户注册
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
