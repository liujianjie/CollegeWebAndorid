package QQ数据库信息;

import java.io.Serializable;

import javax.swing.text.StyledDocument;

public class QQMSG implements Serializable{
	public int cmd;//发送指令
	public QQuser myuser;//自己的信息
	public QQuser fruser;//对方的信息
	public StyledDocument doc;//发送的消息内容
	public String Filename;//发送的文件名称
	public byte[] b;//文件
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public QQuser getMyuser() {
		return myuser;
	}
	public void setMyuser(QQuser myuser) {
		this.myuser = myuser;
	}
	public QQuser getFruser() {
		return fruser;
	}
	public void setFruser(QQuser fruser) {
		this.fruser = fruser;
	}
	public StyledDocument getDoc() {
		return doc;
	}
	public void setDoc(StyledDocument doc) {
		this.doc = doc;
	}
	public String getFilename() {
		return Filename;
	}
	public void setFilename(String Filename) {
		this.Filename =Filename;
	}
	public byte[] getB() {
		return b;
	}
	public void setB(byte[] b) {
		this.b = b;
	}

}
