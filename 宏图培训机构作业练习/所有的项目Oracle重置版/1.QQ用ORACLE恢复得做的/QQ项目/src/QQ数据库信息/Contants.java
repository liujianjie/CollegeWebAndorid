package QQ数据库信息;

public class Contants {//在线状态
	
	public static final int STATE_DownLINE=0;//离线
	public static final int on_line=1;//在线
	public static final int Off_line=2;//离开
	public static final int busy=3;//忙碌
	public static final int HIDE=4;//隐身
	
	//分组
	public static final String friend="好友";
	public static final String family="家人";
	public static final String schoolmate="同学";
	public static final String blacklist="黑名单";
	
	public static final int CMD_INLINE=1000;//上线通知
	public static final int CMD_OFFLINE=1001;//下线通知
	public static final int CMD_BUSY=1002;//忙碌通知
	public static final int CMD_LEAVE=1003;//离开通知
	public static final int CMD_HIDE=1009;//隐身通知
	//消息记录
	public static final int CMD_CHAT=1004;//聊天通知
	public static final int CMD_SHKAE=1005;//抖动通知
	public static final int CMD_ADDFRIEND=1006;//添加好友通知
	public static final int CMD_DELFRIEND=1007;//删除好友通知
	public static final int CMD_SENDFILE=1008;//发送文件通知
	public static final int CMD_AGRRN=1010;//同意添加
	public static final int CMD_NO=1011;//拒绝添加
	public static final int CMD_FILEAGRRN=1012;//同意接受
	public static final int CMD_FILENO=1013;//拒绝接受
	
	//其它的
	public static final int CMD_FLUSH=1014;//拒绝接受	
}
