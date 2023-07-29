package QQmain;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import QQFind.QQfind;
import QQGAME.QQGame1;
import QQUPuser.QQupuser;
import QQcloudlet.QQcloudletmain;
import QQ���ݿ���Ϣ.Contants;
import QQ���ݿ���Ϣ.QQGAME;
import QQ���ݿ���Ϣ.QQMSG;
import QQ���ݿ���Ϣ.QQuser;
import QQcloudlet.QQweiyun;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;
//������ɫ�Ǹ����� ���� �һ����� �������Ͽ���ʾ �ռ� ��Ϸ���� �ȵ�
public class qqmain extends JFrame{
	public JLabel xiao,close,xia,zt,fond,face,nicheng,levels,weiyun,text;
	JList list1,list2,list3,list4;
	Vector<QQuser> vec1,vec2,vec3,vec4;
	QQuserInterface qservice=new QQuserimp();//���غ�����Ϣ
	public QQuser qquser,fruser;//������Ϣ
	public QQGAME qqusergame;
	JPopupMenu popmenu,popmenu2;
	JMenuItem it1,it2,it3,it4,it5,it7,it6,it9,it8;//�˵���
	//Ψһ�����촰�� qq�� �����촰��
	Map<String, QQchat> chats=new HashMap<String,QQchat>();
	JPopupMenu pop,traypop2;//����ʽ�˵�
	JMenuItem itt1,itt2,itt3,itt4;
	JLabel mainxia,pifu,youxi,bg1,music;
	TrayIcon tray;//����ͼ��
	PopupMenu traypop;
	MenuItem tt1,tt2,tt3,tt4,tt5,tt6;
	JTextArea ta1;
//	JMenuItem tt11,tt22,tt33,tt44;
	public qqmain(QQuser qqh,QQGAME qqusergame){
		super();
		//���������ʽ
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
		/***********/
		this.qquser=qqh;//Ѿ�� ��仰һ��Ҫ�� ����
		this.qqusergame=qqusergame;
		//------------------------------------------
		//���˺ŵ��ǳƴ���ȥ
		qqusergame.setQqname(qqh.getQqname());
		qqusergame.setQqnum(qqh.getQqnum());
		Container con=getContentPane();//�����в���
		// ����ͼƬ
		setIconImage(new ImageIcon("img/touxiang1.png").getImage());
		this.setUndecorated(true);//�ޱ߿�
		//���ý�������϶��ķ���
		setDragable();
		caidan();//���ѹ���˵���
		
//		traypop2();
		
		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(220, 0, 29, 28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(250, 0, 29, 28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		face=new JLabel(new ImageIcon(qqh.getFace()));//�����ݿ��л�ȡͷ�� qqh����β�
		face.setBounds(10, 50,60 ,60 );
		con.add(face);
		face.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		//����״̬
		zt=new JLabel(new ImageIcon("img/s_online.png"));
		zt.setBounds(140,46,15,15);
		con.add(zt);
				
		nicheng=new JLabel(qqh.getQqname());//�����ݿ��л�ȡ�ǳ� qqh����β�
		nicheng.setBounds(80, 40, 60,30);
		nicheng.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		con.add(nicheng);
		nicheng.setToolTipText(qqh.getQqname());
		nicheng.setForeground(Color.WHITE);//��ɫ
		
		//������
		pop=new JPopupMenu();
		itt1=new JMenuItem("��������",new ImageIcon("img/s_online.png"));//��������
		itt2=new JMenuItem("����",new ImageIcon("img/s_hide.png"));
		itt3=new JMenuItem("æµ",new ImageIcon("img/s_busy.png"));
		itt4=new JMenuItem("�뿪",new ImageIcon("img/s_leave.png"));
		pop.add(itt1);
		pop.addSeparator();
		pop.add(itt2);
		pop.addSeparator();
		pop.add(itt3);
		pop.addSeparator();
		pop.add(itt4);
		
		
		levels=new JLabel("LV" + qqh.getLevels());//�����ݿ��л�ȡ�ȼ�qqh����β�
		levels.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		levels.setBounds(80, 55, 100, 50);
		con.add(levels);
		levels.setForeground(Color.yellow);//��ɫ
		
		text=new JLabel(qqh.getMark());//�����ݿ��л�ȡ����ǩ��qqh����β�
		text.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		text.setBounds(80, 80, 200, 50);
		con.add(text);
		text.setForeground(Color.WHITE);//��ɫ
		//ѡ�
		JTabbedPane tab = new JTabbedPane();
		//�½��б�
		list1=new JList();
		list2=new JList();
		list3=new JList();
		list4=new JList();
		//�ı��б���Ϣ 
		this.brush();
		tab.add("  ����  ",list1 );
		tab.add("  ����  ",list2);
		tab.add("  ͬѧ  ",list3);
		tab.add("  ������  ",list4);
		//tab.setForeground(Color.BLUE);
		tab.setBounds(0,135,280,430);
		con.add(tab);
		
		//���Һ���
		fond=new JLabel(new ImageIcon());
		fond.setBounds(157,570,50,17);
		con.add(fond);
		fond.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		//��Ϸ��Ƥ�� ��������
		pifu=new JLabel(new ImageIcon("img/pif.png"));
		pifu.setBounds(250, 110, 20, 20);
		con.add(pifu);
		pifu.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		youxi=new JLabel(new ImageIcon("img/qqyouxi.png"));
		youxi.setBounds(215, 105, 28, 28);
		con.add(youxi);
		youxi.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		music=new JLabel(new ImageIcon("img/QQmusic2.png"));
		music.setBounds(180, 110, 20, 20);
		con.add(music);
		music.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		weiyun=new JLabel(new ImageIcon("img/weiyun2.png"));
		weiyun.setBounds(145, 110, 20, 20);
		con.add(weiyun);
		weiyun.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		mainxia=new JLabel(new ImageIcon("img/QQmainxia.png"));
		mainxia.setBounds(0,565,280,35);
		con.add(mainxia);
		
		//����
		weiyun.addMouseListener(new A());
		music.addMouseListener(new A());
		face.addMouseListener(new A());
		pifu.addMouseListener(new A());
		youxi.addMouseListener(new A());
		fond.addMouseListener(new A());
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		list1.addMouseListener(new A());
		list2.addMouseListener(new A());
		list3.addMouseListener(new A());
		list4.addMouseListener(new A());//��list�ӵ��ǵ����˵�����
		this.addWindowListener(new window());
		zt.addMouseListener(new A());
		itt1.addActionListener(new Action());
		itt2.addActionListener(new Action());
		itt3.addActionListener(new Action());
		itt4.addActionListener(new Action());//��4���ǲ˵���ѡ�����
//		
//		System.out.println(wy.getQqnum());
		//��Ļ��С
		Toolkit tk=Toolkit.getDefaultToolkit();
		int x=(int)tk.getScreenSize().width;
		setSize(280,600);
		//����ͼƬ
		bg1=new JLabel(new ImageIcon("img/man6.png"));
		con.add(bg1);
		
		setVisible(true);
		setLocation(x-320,50);
		
		new D().start();//�߳�
		if(qquser.getStatus()==Contants.on_line){//����
			this.notic(Contants.CMD_INLINE);//����֪ͨ
			zt.setIcon(new ImageIcon("img/s_online.png"));
		}else if(qquser.getStatus()==Contants.HIDE){//����
			//����Ҫ
			zt.setIcon(new ImageIcon("img/s_hide.png"));
		}else if(qquser.getStatus()==Contants.busy){//æµ
			this.notic(Contants.CMD_BUSY);//����֪ͨ
			zt.setIcon(new ImageIcon("img/s_busy.png"));
		}else if(qquser.getStatus()==Contants.Off_line){//�뿪
			this.notic(Contants.CMD_LEAVE);//����֪ͨ
			zt.setIcon(new ImageIcon("img/s_leave.png"));
		}
		
	}	
	//״̬�ı�ֵ Ӧ��֪ͨ��Щ�ˣ� ���� ͬѧ ����
	public void notic(int cmd){
		for(int i=0;i<vec1.size();i++){
			QQuser qq=vec1.get(i);
			if(qq.getStatus()!=Contants.STATE_DownLINE){//�������ߵ�
				QQMSG msg=new QQMSG();
				msg.setCmd(cmd);
				msg.setMyuser(qquser);//���Լ�
				msg.setFruser(qq);//������
				new SendMsg().send(msg);
			}
			
		}
		for(int i=0;i<vec2.size();i++){
			QQuser qq=vec2.get(i);
			if(qq.getStatus()!=Contants.STATE_DownLINE){//�������ߵ�
				QQMSG msg=new QQMSG();
				msg.setCmd(cmd);
				msg.setMyuser(qquser);//���Լ�
				msg.setFruser(qq);//������
				new SendMsg().send(msg);
			}
			
		}
		for(int i=0;i<vec3.size();i++){
			QQuser qq=vec3.get(i);
			if(qq.getStatus()!=Contants.STATE_DownLINE){//�������ߵ�
				QQMSG msg=new QQMSG();
				msg.setCmd(cmd);
				msg.setMyuser(qquser);//���Լ�
				msg.setFruser(qq);//������
				new SendMsg().send(msg);
			}
		}
		for(int i=0;i<vec4.size();i++){
			QQuser qq=vec4.get(i);
			if(qq.getStatus()!=Contants.STATE_DownLINE){//�������ߵ�
				QQMSG msg=new QQMSG();
				msg.setCmd(cmd);
				msg.setMyuser(qquser);//���Լ�
				msg.setFruser(qq);//������
				new SendMsg().send(msg);
			}
			
		}
	}
	
	//��������ͼƬ����
	public void createTrayIcon(){
		traypop();//���̲˵���
		Image img=new ImageIcon(qquser.getFace()).getImage();
		tray=new TrayIcon(img,"QQ:"+qquser.getQqname()
					+"("+qquser.getQqnum()+")",traypop);
		tray.setImageAutoSize(true);
		tray.addMouseListener(new A());
	}
	//���ڹر�
	class window extends WindowAdapter{
		@Override
		public void windowIconified(WindowEvent e) {
			SystemTray sys=SystemTray.getSystemTray();
			if(tray!=null){
				sys.remove(tray);//�Ƴ�
				
			}
			createTrayIcon();
			try {
				sys.add(tray);
				qqmain.this.setVisible(false);
			} catch (AWTException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			
		}
		@Override
		public void windowClosing(WindowEvent e) {
			qservice.updstate(qquser.getQqnum(), Contants.STATE_DownLINE);//����
			//��������
			notic(Contants.CMD_OFFLINE);//����������Ϣ
		}

	}
	//���̲˵���
	public void traypop(){
		traypop=new PopupMenu();
		tt5=new MenuItem("�������");
		tt6=new MenuItem("�˳�");
		traypop.add(tt5);
		traypop.add(tt6);
		tt5.addActionListener(new Action());
		tt6.addActionListener(new Action());//��6����������ѡ�����
	}
	//����ʽ�˵�
	public void caidan(){
		popmenu=new JPopupMenu();//�˵�
		popmenu2=new JPopupMenu();//�˵�
		it1=new JMenuItem("���ͼ�ʱ��Ϣ");
		it2=new JMenuItem("ɾ������");
		it3=new JMenuItem("��������");
		it4=new JMenuItem("��������");
		it5=new JMenuItem("��������");
		it6=new JMenuItem("����ͬѧ");
		it7=new JMenuItem("����������");
		it8=new JMenuItem("�鿴��������");
		it9=new JMenuItem("�޸�����");
		popmenu2.add(it8);
		popmenu2.add(it9);
		popmenu.add(it1);
		popmenu.add(it2);
		popmenu.add(it3);
		popmenu.add(it4);
		popmenu.add(it5);
		popmenu.add(it6);
		popmenu.add(it7);	
	//	popmenu.addMouseListener(new A());
		it1.addActionListener(new Action());
		it2.addActionListener(new Action());
		it3.addActionListener(new Action());
		it4.addActionListener(new Action());
		it5.addActionListener(new Action());
		it6.addActionListener(new Action());
		it7.addActionListener(new Action());//��7���ǲ˵���ѡ�����
		it8.addActionListener(new Action());
		it9.addActionListener(new Action());//��7���ǲ˵���ѡ�����
	}
	//�����촰�ڵķ���
	public QQchat openchat(String frqqnum,QQMSG msg){
		QQchat chat=chats.get(frqqnum);//��ȡ��ֵ�ж��Ƿ����
		if(chat==null){//û��
			if(msg==null){//�Լ��򿪵������� main��  ���ǵ�������
				//������ͨ��main�е����촰��
				chat=new QQchat(qquser,fruser);//������
			}else{
				//���� �Զ����������촰�� �ұ�ɺ���
				chat=new QQchat(msg.getFruser(),msg.getMyuser());//������
			}
			chats.put(frqqnum,chat);//�����ֵ��
		}
		if(!chat.isVisible()){//����������ص�
			chat.setVisible(true);//��ʾ
			chat.t1.setText("");//���
		}
		return chat;
	}
	
	//�ҵ�ip�Ͷ˿�
	class D extends Thread{//�߳� һֱ������Ϣ
		public void run() {
			try {
				int port=qquser.getPort();
				DatagramSocket ds=new DatagramSocket(port);//����������
				while(true){
					byte[] b=new byte[1024*80];//ÿ�ν���80�ֽ� 40��
					DatagramPacket dp=new DatagramPacket(b, b.length);//������Ϣ			
					ds.receive(dp);//����
					//ת��
					ByteArrayInputStream bis=new ByteArrayInputStream(b,0,dp.getLength());
					ObjectInputStream bos=new ObjectInputStream(bis);
					//�õ���Ϣ����
					QQMSG msg=(QQMSG)bos.readObject();
					int cmd=msg.cmd;
					//�ж�Ϊʲô��Ϣ����
					if(cmd==Contants.CMD_FLUSH){//�����޸�
						brush();
						System.out.println("sdfdsf");
					}
					else if(cmd==Contants.CMD_CHAT){//����֪ͨ
						//�������촰�� ��QQ���ѵ�����ϵ�������� ���ҵ�QQ�Ŵ洢��Ϣ
						QQchat chat=openchat(msg.myuser.getQqnum(),msg);//��QQ�Ŵ洢��Ϣ
						//������ʾ�����촰���� ��ʱ �ұ��QQ���� ����Ϣ
						chat.appendView(msg.myuser.getQqname(),msg.doc);
					}else if(cmd==Contants.CMD_SHKAE){//����֪ͨ
						QQchat chat=openchat(msg.myuser.getQqnum(),msg);
						chat.shake();
						chat.appendView(msg.myuser.getQqname(),msg.doc);
	
					}else if(cmd==Contants.CMD_ADDFRIEND){//��Ӻ���֪ͨ
						//�������
						new Sound("system.wav");
						String message=msg.getMyuser().getQqname()+"�����Ϊ���ѣ��Ƿ����?";
						int	j=JOptionPane.showConfirmDialog(null, message, "��Ӻ���", JOptionPane.OK_CANCEL_OPTION);
						QQMSG mm=new QQMSG();
						mm.setMyuser(msg.getFruser());
						mm.setFruser(msg.getMyuser());
						if(j==0){
							//ȷ�� ͬ�� ����ѱ����������������
							qservice.addfrid(msg.getMyuser().getQqnum(), msg.getFruser().getQqnum(), "����");
							//Ĭ����ӵ������� �������Ƿ����ʱ�ƶ�����
							brush();
							mm.setCmd(Contants.CMD_AGRRN);//ͬ�����Ϣ
							
						}else if(j==2){
							mm.setCmd(Contants.CMD_NO);//�ܾ�����Ϣ
							
						}
						new SendMsg().send(mm);
					}else if(cmd==Contants.CMD_INLINE){//����֪ͨ
						new Sound("Global.wav");//����
						brush();//ˢ�����
						new TipUi(msg.getMyuser());//����
						
					}else if(cmd==Contants.CMD_OFFLINE){//����֪ͨ
						brush();//ˢ�����
						
					}else if(cmd==Contants.CMD_BUSY){//æµ֪ͨ
						brush();
						
					}else if(cmd==Contants.CMD_LEAVE){//�뿪֪ͨ
						brush();
						
					}else if(cmd==Contants.CMD_HIDE){//����֪ͨ
						brush();
						
					}else if(cmd==Contants.CMD_NO){//�ܾ����
						JOptionPane.showMessageDialog(null, msg.getMyuser()+"�ܾ�����");
					}else if(cmd==Contants.CMD_AGRRN){//ͬ�����
						JOptionPane.showMessageDialog(null, msg.getMyuser().getQqname()+"ͬ�⽫����Ӻ���");
						brush();
					}else if(cmd==Contants.CMD_DELFRIEND){//ɾ������
						brush();
						
					}else if(cmd==Contants.CMD_SENDFILE){//�����ļ�
						int j=JOptionPane.showConfirmDialog(null, msg.getMyuser().getQqname()+"���㷢����"+msg.getFilename()+"�ļ��Ƿ���ܣ�","�����ļ�",JOptionPane.OK_CANCEL_OPTION);
						QQMSG mm=new QQMSG();
						mm.setMyuser(msg.getFruser());//
						mm.setFruser(msg.getMyuser());//
						//ͬ��ܾ�
						if(j==0){
							FileDialog fd=new FileDialog(qqmain.this,"�����ļ�",FileDialog.SAVE);//�����ļ�
							fd.setFile(msg.getFilename());//Ĭ������
							fd.show();
							String filename=fd.getDirectory()+"\\"+fd.getFile();
							File f=new File(filename);
							if(!f.exists()){
								f.createNewFile();//����
								
							}
							FileOutputStream fout=new FileOutputStream(f);
							//ѭ������
							//ѭ����ȡ�ļ�
							//while(fout.write(msg.getB())!=-1){
							
							fout.write(msg.getB());
							
							fout.close();
							//����ͬ��֪ͨ
							mm.setCmd(Contants.CMD_FILEAGRRN);
						}else if(j==2){
							//���;ܾ�֪ͨ
							mm.setCmd(Contants.CMD_FILENO);
						}
						new SendMsg().send(mm);
					}else if(cmd==Contants.CMD_FILEAGRRN){//ͬ������ļ�
						JOptionPane.showMessageDialog(null, msg.getMyuser().getQqname()+"�����������ļ�");
						
					}else if(cmd==Contants.CMD_FILENO){//�ܾ������ļ�
						JOptionPane.showConfirmDialog(null, msg.getMyuser().getQqname()+"�ܾ����������ļ�");
						
					}
				
				}
			} catch (Exception e) {

			}
		}
		
	}

	class Action implements ActionListener{
		//�Ƿ����˵���
		public void actionPerformed(ActionEvent e) {
			//����ͼ��
			
			if(e.getSource()==tt5){
				qqmain.this.setVisible(true);
				qqmain.this.setState(JFrame.NORMAL);//Ĭ��״̬
	
			}
			else if(e.getSource()==tt6){
				qservice.updstate(qquser.getQqnum(), Contants.STATE_DownLINE);//����
				//��������
				notic(Contants.CMD_OFFLINE);//������Ϣ
				System.exit(0);
	
			}
			
			if(e.getSource()==itt1){//����˵���ı�����û���״̬
				QQuser jieshou=qservice.selzt(qquser.getQqnum());
				//�ı�ͼƬ
				zt.setIcon(new ImageIcon("img/s_online.png"));
				if(jieshou.getStatus()!=Contants.on_line){//�����û�һֱΪ����״̬
				qservice.updstate(qquser.getQqnum(),Contants.on_line);
				notic(Contants.CMD_INLINE);//����		
				System.out.println(qquser.getStatus());
				}
			}else if(e.getSource()==itt2){
				zt.setIcon(new ImageIcon("img/s_hide.png"));
				qservice.updstate(qquser.getQqnum(),Contants.HIDE);
				notic(Contants.CMD_HIDE);//����
			}else if(e.getSource()==itt3){
				zt.setIcon(new ImageIcon("img/s_busy.png"));
				qservice.updstate(qquser.getQqnum(),Contants.busy);
				notic(Contants.CMD_BUSY);//æµ
			}else if(e.getSource()==itt4){
				zt.setIcon(new ImageIcon("img/s_leave.png"));
				qservice.updstate(qquser.getQqnum(),Contants.Off_line);
			//	System.out.println("�뿪״̬");
				notic(Contants.CMD_LEAVE);//�뿪
			}
			
			
			if(e.getSource()==it1){
				openchat(fruser.getQqnum(),null);//�����촰�� ��¼��QQ��Ϊ���ѵ�
			}else if(e.getSource()==it2){
				//ɾ������
				qservice.upfrid(qquser.getQqnum(), fruser.getQqnum());
				brush();
				//����֪ͨ ɾ������
				QQMSG mm=new QQMSG();
				mm.setMyuser(qquser);
				mm.setFruser(fruser);
				mm.setCmd(Contants.CMD_DELFRIEND);
				new SendMsg().send(mm);
			}else if(e.getSource()==it3){
				new QqfriendInfo(fruser);
				
			}else if(e.getSource()==it4){
				qservice.movegroup(qquser.getQqnum(), fruser.getQqnum(), "����");
				brush();
			}else if(e.getSource()==it5){
				qservice.movegroup(qquser.getQqnum(), fruser.getQqnum(), "����");
				brush();
			}else if(e.getSource()==it6){
				qservice.movegroup(qquser.getQqnum(), fruser.getQqnum(), "ͬѧ");
				brush();
			}else if(e.getSource()==it7){
				qservice.movegroup(qquser.getQqnum(), fruser.getQqnum(), "������");
				brush();
			}else if(e.getSource()==it8){
				new QqfriendInfo(qquser);
			}else if(e.getSource()==it9){
				new QQupuser(qquser,qqmain.this);
			}

		}
	}
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==face){
//				new QQupuser(qquser,qqmain.this);
				popmenu2.show(face, e.getX(), e.getY());
			}
			//�������ͼ����ʾmain
			if(e.getSource()==tray&&e.getButton()==1){
				qqmain.this.setVisible(true);
				qqmain.this.setState(JFrame.NORMAL);//Ĭ��״̬
				
			}
			//main�й���
			if(e.getSource()==weiyun){
				new QQcloudletmain(qquser);
				
			}else if(e.getSource()==music){
				String url = "E:/��ͼ�γ�/JAVA�Ͽ�����/QQ/qqƤ��/�ṷ����";
				java.net.URI uri = java.net.URI.create(url);
				// ��ȡ��ǰϵͳ������չ
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						dp.browse(uri);
					} catch (Exception e1) {

					}// ��ȡϵͳĬ�������������
				}
				
			}else if(e.getSource()==fond){
				new QQfind(qquser);
			}else if(e.getSource()==pifu){//Ƥ��
				//���ͼƬ
				Random r=new Random();
				int i=r.nextInt(5);//0-4
				String str[]={"img/main2.jpg","img/main3.jpg","img/main4.jpg","img/main5.jpg","img/man6.png"};
				bg1.setIcon(new ImageIcon(str[i]));//�±�
			}else if(e.getSource()==youxi){//��Ϸ
				new QQGame1(qqusergame);
			}
			if(e.getSource()==zt){
				pop.show(zt, e.getX(), e.getY());
				
			}
			else if(e.getSource()==xiao){//��С��
				qqmain.this.setExtendedState(qqmain.this.ICONIFIED);//��ֵ̬
				
			}else if(e.getSource()==close){//�ر�		
				qservice.updstate(qquser.getQqnum(), Contants.STATE_DownLINE);//����
				//��������
				notic(Contants.CMD_OFFLINE);//������Ϣ
				System.exit(0);
			}
			//�����˵�
			if(e.getSource()==list1){//�б�
				if(list1.getSelectedIndex()>=0){
				fruser=vec1.get(list1.getSelectedIndex());
				if(e.getButton()==3){//�Ҽ�
					popmenu.show(list1, e.getX(), e.getY());
					
				}
				//˫�����
				if(e.getButton()==1&&e.getClickCount()==2){
					openchat(fruser.getQqnum(),null);//�����촰�� QQ��Ϊ���ѵ�
				}
				}
			}
			
			if(e.getSource()==list2){//�б�
				if(list2.getSelectedIndex()>=0){
				fruser=vec2.get(list2.getSelectedIndex());
				if(e.getButton()==3){//�Ҽ�
					popmenu.show(list2, e.getX(), e.getY());
					
				}
				//˫�����
				if(e.getButton()==1&&e.getClickCount()==2){
					openchat(fruser.getQqnum(),null);//�����촰�� QQ��Ϊ���ѵ�
				}
				}
			}
			
			if(e.getSource()==list3){//�б�
				if(list3.getSelectedIndex()>=0){
				fruser=vec3.get(list3.getSelectedIndex());
				if(e.getButton()==3){//�Ҽ�
					popmenu.show(list3, e.getX(), e.getY());
					
				}
				//˫�����
				if(e.getButton()==1&&e.getClickCount()==2){
					openchat(fruser.getQqnum(),null);//�����촰�� QQ��Ϊ���ѵ�
				}
				}
			}
			
			if(e.getSource()==list4){//�б�
				if(list4.getSelectedIndex()>=0){
				fruser=vec4.get(list4.getSelectedIndex());
				if(e.getButton()==3){//�Ҽ�
					popmenu.show(list4, e.getX(), e.getY());
					
				}
				//˫�����
				if(e.getButton()==1&&e.getClickCount()==2){
					openchat(fruser.getQqnum(),null);//�����촰�� QQ��Ϊ���ѵ�
				}
				}
				
			}
		}	
		public void mouseEntered(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon("img/loginxiao.png"));
				
			}
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/loginclose.png"));
				
			}
		}
		public void mouseExited(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon("img/xiao1.png"));//ԭ����ͼƬ
				
			}
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/close1.png"));//ԭ����ͼƬ
				
			}
		}
	}
	public void brush(){
		vec1=qservice.selectusergroupname(qquser.getQqnum(),Contants.friend);//����
		//vec1=qservice.selectusergroupname("6208","����");//����
		vec2=qservice.selectusergroupname(qquser.getQqnum(),Contants.family);//����
		vec3=qservice.selectusergroupname(qquser.getQqnum(),Contants.schoolmate);//ͬѧ
		vec4=qservice.selectusergroupname(qquser.getQqnum(),Contants.blacklist);//������
		//������� �к����б���Ϣ�Ĵ���
		list1.setModel(new B(vec1));
		list1.setCellRenderer(new C(vec1));
		
		list2.setModel(new B(vec2));
		list2.setCellRenderer(new C(vec2));
		
		list3.setModel(new B(vec3));
		list3.setCellRenderer(new C(vec3));
		
		list4.setModel(new B(vec4));
		list4.setCellRenderer(new C(vec4));
		
	}
	
	//�б�ģ��
	class B extends AbstractListModel{
		Vector<QQuser> vv=new Vector<QQuser>();
		//���췽��
		public B(Vector<QQuser> users){
			this.vv=users;	
		}
		@Override
		public int getSize() {
			// TODO �Զ����ɵķ������
			return vv.size();//���غ��Ѷ��ٵĴ�С
		}

		@Override
		public Object getElementAt(int index) {
			// TODO �Զ����ɵķ������
			return null;
		}
	}
	//��̬�ı�list���� �б��ֵ
	class C extends DefaultListCellRenderer{
		Vector<QQuser> datas=new Vector<QQuser>();
		public C(Vector<QQuser> users){
			this.datas=users;
			
		}
		//�����ķ���
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus){
			//JList �����ݲŽ�ȥ
		//	System.out.println("ɵ��");
			if(index>=0&&index<=datas.size()){
				QQuser quser=datas.get(index);
				String icon=quser.getFace();//ͼƬ·��
			//	System.out.println("ɵ��");
				//����ͷ��
				//����status���ı�ͼ��״̬
				if(quser.getStatus()==Contants.STATE_DownLINE||
						quser.getStatus()==Contants.HIDE){//���߻�����
					icon=icon.substring(0, icon.indexOf("."));
					icon=icon+"_h.png";
				//	System.out.println("hhhhhhhhh");
				}else if(quser.getStatus()==Contants.on_line){
					//���߲��ж�
				}else if(quser.getStatus()==Contants.busy){
					//æµ ��Ҫ����
					icon=icon.substring(0,icon.indexOf("."));
					icon=icon+"_w.png";
				}else if(quser.getStatus()==Contants.Off_line){
					//�뿪
					icon=icon.substring(0,icon.indexOf("."));
					icon=icon+"_l.png";
					//System.out.println("hhe");
				}
				//����ͼƬ
				setIcon(new ImageIcon(icon));
				// ��jlist����QQ�ź�ǩ��
				setText(quser.getQqname() + "(" + quser.getQqnum() + ")\n"
						+ quser.getMark());
			}
			//������꾭������ʽ
			if (isSelected) {// �����ѡ����
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			}
			else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			return this;
		}
		
	}

	/***********/
	//���ý�������϶��ķ���
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				qqmain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				qqmain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(qqmain.this.getLocation().x + e.getX() - tmp.x,
							qqmain.this.getLocation().y + e.getY() - tmp.y);
					qqmain.this.setLocation(loc);
				}
			}
		});
	}
	/***********/

}
