package QQ���ݿ���Ϣ;

import java.io.Serializable;

import javax.swing.text.StyledDocument;

public class QQMSG implements Serializable{
	public int cmd;//����ָ��
	public QQuser myuser;//�Լ�����Ϣ
	public QQuser fruser;//�Է�����Ϣ
	public StyledDocument doc;//���͵���Ϣ����
	public String Filename;//���͵��ļ�����
	public byte[] b;//�ļ�
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
