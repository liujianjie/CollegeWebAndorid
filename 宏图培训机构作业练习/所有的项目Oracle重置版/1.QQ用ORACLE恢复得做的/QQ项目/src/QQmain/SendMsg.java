package QQmain;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import QQ数据库信息.QQMSG;

public class SendMsg {
	public void send(QQMSG msg){
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos=new ObjectOutputStream(bos);
			oos.writeObject(msg);//发出消息
			byte[] b=bos.toByteArray();//转换为字节数组
			DatagramSocket ds=new DatagramSocket();
			InetAddress ipadd=InetAddress.getByName(msg.fruser.getIpadd());//好友ip
			int port=msg.fruser.getPort();//端口
			DatagramPacket dp=new DatagramPacket(b,0,b.length,ipadd,port);
			ds.send(dp);
			ds.close();
		} catch (Exception e) {

		}
	}
}
