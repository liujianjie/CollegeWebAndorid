package QQmain;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import QQ���ݿ���Ϣ.QQMSG;

public class SendMsg {
	public void send(QQMSG msg){
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos=new ObjectOutputStream(bos);
			oos.writeObject(msg);//������Ϣ
			byte[] b=bos.toByteArray();//ת��Ϊ�ֽ�����
			DatagramSocket ds=new DatagramSocket();
			InetAddress ipadd=InetAddress.getByName(msg.fruser.getIpadd());//����ip
			int port=msg.fruser.getPort();//�˿�
			DatagramPacket dp=new DatagramPacket(b,0,b.length,ipadd,port);
			ds.send(dp);
			ds.close();
		} catch (Exception e) {

		}
	}
}
