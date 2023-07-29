package QQcloudlet;

import java.util.Vector;

import QQcloudlet.QQweiyun;

public interface QQweiyunjiekou {
	
	public Vector<Vector> selfile(String qqnum,String layout);//查询微云信息
	
	public boolean updfile2(QQweiyun wy);//也是修改值 只不过是增加
	
	public QQweiyun selfile2(String qqnum,String filename,String filelayout);//查询所有微云信息
}
