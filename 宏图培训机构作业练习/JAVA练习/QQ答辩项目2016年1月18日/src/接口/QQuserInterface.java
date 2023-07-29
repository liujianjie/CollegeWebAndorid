package 接口;

import java.util.List;
import java.util.Vector;

import QQLGO.qqhistory;
import QQ数据库信息.QQGAME;
import QQ数据库信息.QQuser;

public interface QQuserInterface {
	public boolean add(QQuser s);//添加信息到数据库
	
	public boolean add(QQGAME g);//游戏信息添加到数据库
	
	public boolean QQID(String qqnum);//查询qq号是不是唯一
	
	public QQuser chkuser(QQuser quer);//对比信息是否正确
	
	public boolean updstate(String qqnum,int state);//改变在线状态
	
	public boolean addhistory(qqhistory qqh);//存历史信息

	public List selhi();	//查询登录历史
	
	public Vector<QQuser> selectusergroupname(String myqq,String groupname);//查询好友信息
	
	public Vector<Vector> selusers(QQuser user);//查询好友 返回好友信息成vector形式
	
	public boolean selhy(String myq,String fyq);//查询好友是否存在自己的列表中
	
	public QQuser selQQuserbyfind(String qqnum);//好友对象
	
	public void addfrid(String myqnum,String fyqnum,String groupname);//添加好友

	public String mimanull(String myqnum);//密码框不为空
	
	public boolean upfrid(String myqq,String hyqq);//删除好友
	
	public boolean movegroup(String myqnum,String fyqnum,String groupname);//移动分组
	
	public boolean upduser(QQuser quser);//修改资料
	public boolean upgameuser(QQGAME quser);//游戏的名称也要修改
	
	public QQuser selzt(String qqnum);//查询状态
	
	public QQuser chkqqnum(QQuser quer);//找回密码的账号是否正确
	public QQuser chkqqziliao(QQuser quer);//找回密码的资料是否正确
	
	public void addscore(String qqname,int score);//改变贪吃蛇的分数

	public boolean chekhui(String qqnum);//是不是会员
	
	public QQGAME shenode(String qqname,QQGAME game);//查询蛇节
	
	public boolean updshenode(String qqnum,int node);//改变蛇节
	
	public int seltxzgk(String qqnum);//查询推箱子关卡数
	
	public boolean savetxzgk(String qqnum,int level);//结束后保存推箱子关卡数
	
	public Vector<Vector> selscore();//分数
	
	public boolean vipzhuce(String qqnum);//会员注册
}
