package QQmain;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


import javax.swing.text.Element;

import QQ���ݿ���Ϣ.Contants;
import QQ���ݿ���Ϣ.QQMSG;
import QQ���ݿ���Ϣ.QQuser;

public class QQchat extends JFrame{
	QQuser myq;
	QQuser hyq;
	JLabel xiao,close,bg,face,qname,mark,myqqx,hyqqx,biaoqing,dd,pane,A,jietu,cancel,send;
	JLabel chatad;
	JLabel sendfile;
	// �ı����
	JTextPane t1, t2,ddtext;
	
	Icon bqs[]=new ImageIcon[96];
	QQbiaoqingpane a;
	QQzitipane b;
	Container con;
	//�����ж� Ҫ��Ҫ���˱���
	boolean s=false;
	public QQchat(QQuser myq,QQuser hyq){
		super();
		this.myq=myq;
		this.hyq=hyq;
		con=getContentPane();
		con.setLayout(null);
		con.setBackground(new Color(236,240,238));
		//����ͼ��
		setIconImage(new ImageIcon(myq.getFace()).getImage()); 
		this.setUndecorated(true);//�ޱ߿�
		//���ý�������϶��ķ���
		setDragable();

		xiao=new JLabel(new ImageIcon("img/xiao1.png"));
		xiao.setBounds(528, 0, 29, 28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		close=new JLabel(new ImageIcon("img/close1.png"));
		close.setBounds(558, 0, 29, 28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		face=new JLabel(new ImageIcon(hyq.getFace()));
		face.setBounds(0, 0, 60, 60);
		con.add(face);
		
		qname=new JLabel(hyq.getQqname());
		qname.setBounds(65, 3, 200, 38);
		qname.setFont(new Font("����",Font.PLAIN,20));
		con.add(qname);
		
		mark=new JLabel(hyq.getMark());
		mark.setBounds(65, 35, 200, 30);
		con.add(mark);
		
		t1=new JTextPane();
		t1.setBackground(new Color(236,240,238));
		JScrollPane pan1 = new JScrollPane(t1);
//		pan1.setOpaque(false);
//		pan1.getViewport().setOpaque(false);
		pan1.setBackground(new Color(0, 0, 0, 0));
		pan1.setBounds(0, 62, 445, 290);
		con.add(pan1);
//		t1.setEditable(false);
//		t1.setOpaque(false);
//		t1.setBackground(new Color(0, 0, 0, 0));
		pan1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//����QQ��
		String qqx1="img/qqxboy.jpg";
		if(hyq.getSex().equals("Ů")){
			qqx1="img/qqxgirl.jpg";;
		}
		hyqqx=new JLabel(new ImageIcon(qqx1));
		hyqqx.setBounds(445, 63, 140, 220);
		con.add(hyqqx);
		
		//QQ��
		String qqx2="img/qqxboy.jpg";
		if(myq.getSex().equals("Ů")){
			qqx2="img/qqxgirl.jpg";;
		}
		myqqx=new JLabel(new ImageIcon(qqx2));
		myqqx.setBounds(445, 285, 140, 220);
		con.add(myqqx);
		//�м����
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT,10,1));
		p1.setBackground(new Color(233,243,243));
		//����ͼƬ
		A=new JLabel(new ImageIcon("img/ziti.png"));
		p1.add(A);
		
		//����
		biaoqing=new JLabel(new ImageIcon("img/biaoqing.png"));
		p1.add(biaoqing);
		
		//����
		dd=new JLabel(new ImageIcon("img/dd.png"));
		p1.add(dd);
		dd.setToolTipText("����ѷ��ʹ��ڶ���");
		
		//��ͼ
		jietu=new JLabel(new ImageIcon("img/��ͼͼƬ.png"));
		p1.add(jietu);
		
		// �����ļ�
		sendfile=new JLabel(new ImageIcon("img/wenjian.png"));
		sendfile.setToolTipText("����ѷ����ļ�");
		p1.add(sendfile);
			
		p1.setBounds(0, 352, 445, 24);
		con.add(p1);
		
		//����
		t2=new JTextPane();
		JScrollPane pan2 = new JScrollPane(t2);
		
//		pan2.setOpaque(false);
//		pan2.getViewport().setOpaque(false);
//		pan2.setBackground(new Color(0, 0, 0, 0));
		t2.setBackground(new Color(236,240,238));
		pan2.setBounds(0,376, 445, 104);
		con.add(pan2);
		t2.setOpaque(false);
		t2.setBackground(new Color(0, 0, 0, 0));
		pan2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
		
		//�������
		JPanel p3=new JPanel();
//		p3.setOpaque(false);
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));
//		p3.setBackground(new Color(0, 0, 0, 0));
		// ȡ��
		cancel = new JLabel(new ImageIcon("img/cancel.png"));
		p3.add(cancel);

		// ����
		send = new JLabel(new ImageIcon("img/send.png"));
		p3.add(send);
		
		//����
		sendfile.addMouseListener(new A());
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		dd.addMouseListener(new A());
		cancel.addMouseListener(new A());
		send.addMouseListener(new A());
		biaoqing.addMouseListener(new A());
		jietu.addMouseListener(new A());
		A.addMouseListener(new A());

		p3.setBounds(0,480,445,30);
		con.add(p3);
		/* ����ͼƬ */
		ImageIcon images = new ImageIcon("img/bgimagetou.png");
		JLabel jl = new JLabel(images);// ͼƬ��ǩ
		jl.setBounds(0,0,588,510);
		con.add(jl);
		t2.addKeyListener(new C());
		setSize(588,510);//526
		setVisible(true);
		setLocationRelativeTo(null);
	}


	//���ڶ�������
	public void shake(){
		Point p=QQchat.this.getLocationOnScreen();
		for(int i=0;i<20;i++){
			if(i%2==0){
				QQchat.this.setLocation(p.x-5,p.y-5);
			}else{
				QQchat.this.setLocation(p.x+5,p.y+5);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
	}
	class C implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER){
//					send.doclik();
				}
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO �Զ����ɵķ������
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO �Զ����ɵķ������
			
		}
		
		
	}
	//����ƶ�
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//�ļ�
			if(e.getSource()==sendfile){
				FileDialog fd=new FileDialog(QQchat.this,"ѡ���ļ�",FileDialog.LOAD);//��ȡ�ļ�
				fd.show();
				String filepath=fd.getDirectory()+"\\"+fd.getFile();//�ļ�·��
				//�ж�
				if(fd.getFile()!=null){
					File file=new File(filepath);
					byte b[]=new byte[(int)file.length()];//80k
					try {
						FileInputStream finput=new FileInputStream(file);
						//ѭ����ȡ�ļ�
						//while(finput.read(b)!=-1){
							
						//}
						if(file.length()>1024*64){//64k
							JOptionPane.showMessageDialog(null, "�ļ�����");
						//}
						}else{
							finput.read(b);
						}
						finput.close();
						
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					//�����ļ���Ϣ֪ͨ
					QQMSG msg=new QQMSG();
					msg.setCmd(Contants.CMD_SENDFILE);
					msg.setMyuser(myq);//���Լ�
					msg.setFruser(hyq);//������
					msg.setB(b);
					msg.setFilename(fd.getFile());
					new SendMsg().send(msg);

				}
			}
			
			if(e.getSource()==xiao){//��С��
				QQchat.this.setExtendedState(QQchat.this.ICONIFIED);//��ֵ̬
				
			}else if(e.getSource()==close){//�ر�
			//	dispose();
				QQchat.this.setVisible(false);//����
			}else if(e.getSource()==dd){
			//����
				shake();
				QQMSG msg=new QQMSG();
				ddtext=new JTextPane();
				ddtext.setText("  �Ҹ��㷢����һ������");
				ddtext.setFont(new Font("΢���ź�",Font.BOLD,18));
				msg.cmd=Contants.CMD_SHKAE;
				msg.fruser=hyq;
				msg.myuser=myq;
				msg.doc=ddtext.getStyledDocument();
				new SendMsg().send(msg);
			}
			//����
			if(e.getSource()==biaoqing){
				a=new QQbiaoqingpane(QQchat.this);//�б�Ҫ
			}
			//����
			if(e.getSource()==A){
				b=new QQzitipane(e.getXOnScreen()-25, e.getYOnScreen()-42,QQchat.this); 
				
			}
			//��ͼ
			if(e.getSource()==jietu){
				QQjietu a=new QQjietu();
				a.doStart();
			}
			if(e.getSource()==cancel){
				QQchat.this.setVisible(false);//����
				
			}else if(e.getSource()==send){
				//��ʾ���Լ��������
				appendView(myq.getQqname(), t2.getStyledDocument());
				
				//�����ѿ�������
				QQMSG msg=new QQMSG();
				msg.cmd=Contants.CMD_CHAT;//������Ϣ����
				msg.doc=t2.getStyledDocument();
				msg.myuser=myq;
				msg.fruser=hyq;
				new SendMsg().send(msg);//������Ϣ
				//��շ��Ϳ�
				t2.setText("");
				//����
				t2.requestFocus();
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
	
	// �ѷ��Ϳ�������ύ�����տ� (�Լ����ǳƣ����Ϳ������)
	public void appendView(String name, StyledDocument xx) {
			try {
				//��Ӧ��Ϊ��� ��һ�仰
			//	int wo=3;
				// ��ȡ���տ���ĵ������ݣ�
				StyledDocument vdoc = t1.getStyledDocument();// ��ȡ���տ������

				// ��ʽ��ʱ��
				Date date = new Date();// ��ȡϵͳ��ǰʱ��
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // ������ʾʱ����ĸ�ʽ
				String time = sdf.format(date);// ��ȡʱ����
				// ����һ�����Լ���
				SimpleAttributeSet as = new SimpleAttributeSet();
				// ��ʾ˭˵
				// vdoc.getLength()��ȡ���տ��е�ԭ�����ݵĳ���
				String s = name + "  " + time + "\n";
				// saveRecord(name,s);//���������¼
				// ��ʾ�����տ�
				vdoc.insertString(vdoc.getLength(), s, as);
				int end = 0;
				// ������ʾ������
				while (end < xx.getLength()) {
					// ���һ��Ԫ��
					Element e0 = xx.getCharacterElement(end);
					// ��ȡ��Ӧ�ķ��
					SimpleAttributeSet as1 = new SimpleAttributeSet();
					StyleConstants.setForeground(as1, StyleConstants
							.getForeground(e0.getAttributes()));
					StyleConstants.setFontSize(as1, StyleConstants.getFontSize(e0
							.getAttributes()));
					StyleConstants.setFontFamily(as1, StyleConstants
							.getFontFamily(e0.getAttributes()));
					// ��ȡ��Ԫ�ص�����
					s = e0.getDocument().getText(end, e0.getEndOffset() - end);
					// ��Ԫ�ؼӵ��������
					if ("icon".equals(e0.getName())) {
						vdoc.insertString(vdoc.getLength(), s, e0.getAttributes());
					} else {
						vdoc.insertString(vdoc.getLength(), s, as1);
						// saveRecord(name,s+"\n");//���������¼
					}
					// getEndOffset�����������ǻ�ȡ��ǰԪ�صĳ���
					end = e0.getEndOffset();
				}
				// ����һ�����С����������������������������������������������
				vdoc.insertString(vdoc.getLength(), "\n\n", as);
				// ������ʾ��ͼ���ַ���λ�õ��ĵ���β���Ա���ͼ����
				t1.setCaretPosition(vdoc.getLength());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				QQchat.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQchat.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQchat.this.getLocation().x + e.getX() - tmp.x,
							QQchat.this.getLocation().y + e.getY() - tmp.y);
					QQchat.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
}
