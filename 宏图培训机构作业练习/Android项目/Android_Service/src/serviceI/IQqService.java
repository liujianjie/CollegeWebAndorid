package serviceI;

import java.util.List;

import vo.AndroidQqDynamic;
import vo.AndroidQqHy;
import vo.AndroidQqMessage;
import vo.AndroidQqUser;

public interface IQqService {
	//注册
	public boolean addUser(AndroidQqUser qquser);
	//修改
	public boolean alertUser(AndroidQqUser qquser);
	//登录 是否有用户
	public List selUser(String qqZhanghao,String mima);
	//登录 修改状态
	public boolean UpdUserStatu(Long qqId);
	//用户信息 查询个人信息
	public AndroidQqUser getUser(Long qqId);
	//好友信息 查询用户的好友列表的id
	public List selhy(Long qqId);
	//获取好友信息 获取好友的bean构成list
	public AndroidQqHy getQqhy(Long hyid);
	//添加好友之发起好友添加 就是先添加数据
	public boolean addQqhy(AndroidQqHy qqhy);
	//添加好友之查询有关自己好友的数据列表
	public List selQqhyOfmy(Long qqId);
	//修改数据 状态为1
	public boolean updHaoYouStatu(AndroidQqHy qqhy);
	//获取动态 查询好友动态的id
	public List seldynamic(List qqhyidlist,int CurrPage,int PageCount);
	//获取动态实际信息 获取好友的bean构成list
	public AndroidQqDynamic getdynamic(Long dyId);
	//添加动态
	public boolean addQqDt(AndroidQqDynamic qqdynamic);
	//发送信息 添加
	public boolean addMsg(AndroidQqMessage msg);
	//接收信息 查询
	public AndroidQqMessage getMsg(Long mId);
	//在聊天界面时 获取的消息列表
	public List getChartList(Long qqId,Long hyId);
	//在消息页面    获取消息列表
	public List getmidOfMsg(Long qqId);
	//添加好友查询用户列表
	public List selUserList(String xinxi);
	
	//删除好友
	public List getHyList(Long hyqqId,Long qqId);
	public boolean delHyuser(Long hyId);
	
	//获取单独一个消息
	public List getMsgXq(Long qq_id,Long m_jsid);
}
