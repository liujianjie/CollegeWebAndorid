package QQcloudlet;

import java.util.Vector;

import QQcloudlet.QQweiyun;

public interface QQweiyunjiekou {
	
	public Vector<Vector> selfile(String qqnum,String layout);//��ѯ΢����Ϣ
	
	public boolean updfile2(QQweiyun wy);//Ҳ���޸�ֵ ֻ����������
	
	public QQweiyun selfile2(String qqnum,String filename,String filelayout);//��ѯ����΢����Ϣ
}
