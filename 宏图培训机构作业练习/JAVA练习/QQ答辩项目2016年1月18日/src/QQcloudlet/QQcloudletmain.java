package QQcloudlet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.management.JMException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import QQ���ݿ���Ϣ.QQuser;

public class QQcloudletmain extends JFrame{
	JLabel bg,close,xiao,face,nicheng,shangchuang,xiazai,shuxing,wode,bofang;
	JLabel j1,j2,j3,j4,j5,j6;//�����ļ�������
	QQweiyun a1,a2,a3,a4,a5,a6;//����Ƿ�Ϊ��
	QQuser qquser;
	QQweiyunfafang qservice=new QQweiyunfafang();
	QQweiyun wy;
	QQuser mqq;
	JPanel p2;
	JPopupMenu pop;
	JMenuItem it1,it2,it3;//�ϴ�����
	JPopupMenu pop1;
	JMenuItem it11,it22,it33;//�򿪷�ʽ
	JTabbedPane tabp;
	//��Դ
	public Vector<Vector> tilte,datas,tilte2,datas2,tilte3,datas3;//���� ����
	Vector<Vector> vv,vv2,vv3;
	DefaultTableModel tab,tab2,tab3;
	JTable table,table2,table3;
	public QQcloudletmain(QQuser mqq){
		super("");
		this.mqq=mqq;
		this.qquser=mqq;
		//���������ʽ
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
		
		Container con=getContentPane();
		con.setLayout(null);
		xiao=new JLabel(new ImageIcon(""));
		xiao.setBounds(740, 0, 29, 28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		close=new JLabel(new ImageIcon(""));
		close.setBounds(770, 0, 29, 28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		face=new JLabel(new ImageIcon(mqq.getFace()));
		p1.add(face);
		
		nicheng=new JLabel(mqq.getQqname());
		nicheng.setFont(new Font("����",Font.BOLD,20));
		p1.add(nicheng);
		
		shangchuang=new JLabel(new ImageIcon("QQweiyun/shangchuagn.png"));
		p1.add(shangchuang);
		shangchuang.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		p1.setBounds(10, 30,800, 70);
		con.add(p1);
		//�ҵ���Դ

		//________________________________________
		//������
		tabp = new JTabbedPane();//ѡ�
		Vector title=new Vector();
		title.add("�ļ���");
		title.add("�ļ�����");
		this.tilte=title;
		Vector datas=new Vector();
		
		tab=new DefaultTableModel();
		tab.setDataVector(datas, title);
		table=new JTable(tab);
		
		//����
		tab.setRowCount(0);
		vv=qservice.selfile(mqq.getQqnum(), "��Ƶ");
		for(int i=0;i<vv.size();i++){
			Vector<Vector> us=vv.get(i);//��ȡ
			tab.addRow(us);//����������
		}
		
		//������
		//JScrollPane sp1=new JScrollPane(table);
		tabp.add(table,"  ��Ƶ  ");
		
		Vector title2=new Vector();
		title2.add("�ļ���");
		title2.add("�ļ�����");
		this.tilte2=title2;
		Vector datas2=new Vector();
		tab2=new DefaultTableModel();
		tab2.setDataVector(datas2, title2);
		table2=new JTable(tab2);
		//����
		tab2.setRowCount(0);
		vv2=qservice.selfile(mqq.getQqnum(), "ͼƬ");	
		for(int i=0;i<vv2.size();i++){
			Vector<Vector> us=vv2.get(i);//��ȡ
			tab2.addRow(us);//����������
		}
		tabp.add(table2,"  ͼƬ  ");
		
		Vector title3=new Vector();
		title3.add("�ļ���");
		title3.add("�ļ�����");
		this.tilte3=title3;
		Vector datas3=new Vector();
		
		tab3=new DefaultTableModel();
		tab3.setDataVector(datas3, title3);
		table3=new JTable(tab3);
		
		//����
		tab3.setRowCount(0);		
		vv3=qservice.selfile(mqq.getQqnum(), " �ĵ� ");
		for(int i=0;i<vv3.size();i++){
			Vector<Vector> us=vv3.get(i);//��ȡ
			tab3.addRow(us);//����������
		}
		tabp.add(table3,"  �ĵ�  ");
		
		
		con.add(tabp);
		tabp.setBounds(10,160,780,380);
		
		
		wode=new JLabel(new ImageIcon("QQweiyun/�ҵ���Դ.png"));
		wode.setBounds(10,100,164,57);
		con.add(wode);
		//����
		p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,15));
		
		bofang=new JLabel(new ImageIcon("QQweiyun/��.png"));
		p2.add(bofang);
		
		shuxing=new JLabel(new ImageIcon("QQweiyun/����.png"));
//		shuxing.setFont(new Font("����",Font.PLAIN,23));
//		shuxing.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		p2.add(shuxing);
		
		xiazai=new JLabel(new ImageIcon("QQweiyun/����.png"));
		xiazai.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		p2.add(xiazai);
		
		p2.setBounds(10, 540, 780, 60);
		con.add(p2);
		// ����ͼƬ
		setIconImage(new ImageIcon("QQweiyun/weiyun.png").getImage());
		this.setUndecorated(true);//�ޱ߿�
		//���ý�������϶��ķ���
		setDragable();
		
		bg=new JLabel(new ImageIcon("QQweiyun/weiyuntou.png"));
		bg.setBounds(0, 0, 800,32);
		con.add(bg);
		
		//����
		bofang.addMouseListener(new A());
		shuxing.addMouseListener(new A());
		xiazai.addMouseListener(new A());
		shangchuang.addMouseListener(new A());
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		pop=new JPopupMenu();
		it1=new JMenuItem("�ϴ���Ƶ");
		it2=new JMenuItem("�ϴ�ͼƬ");
		it3=new JMenuItem("�ϴ��ĵ�");
		pop.add(it1);
		pop.addSeparator();
		pop.add(it2);
		pop.addSeparator();
		pop.add(it3);
		it1.addActionListener(new B());
		it2.addActionListener(new B());
		it3.addActionListener(new B());
		setSize(800,600);
		setVisible(true);
		setLocationRelativeTo(null);	
	}
	

	class B implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==it1){
				FileDialog fd=new FileDialog(QQcloudletmain.this,"ѡ���ļ�",FileDialog.LOAD);//��ȡ�ļ�
				fd.show();
				String filepath=fd.getDirectory()+"\\"+fd.getFile();//�ļ�·��
				if(fd.getFile()!=null){
					File file=new File(filepath);//Դ�ļ�
					//��
					try {
					FileInputStream infile = new FileInputStream(file);
					File tofile=new File("E:\\"+fd.getFile());//Ŀ���ļ�
					//ʵ�л������ д
					FileOutputStream outfile=new FileOutputStream(tofile);
					byte b[]=new byte[1024*1024];
					if(!tofile.exists()){
						tofile.createNewFile();//����
						
					}
					//ѭ��
					while(infile.read(b)!=-1){
						outfile.write(b);
					}
					//�ر�
					infile.close();
					outfile.close();
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					// ��ʽ��ʱ��
					Date date = new Date();// ��ȡϵͳ��ǰʱ��
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ������ʾʱ����ĸ�ʽ
					String time = sdf.format(date);// ��ȡʱ����
					//��ȡ�ļ�������
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(mqq.getQqnum());
					wy.setQqname(mqq.getQqname());
					wy.setFilepath(fd.getDirectory()+"\\"+fd.getFile());//�ļ�·��
					wy.setFilenames(fd.getFile());
					wy.setDate(time);
					wy.setFilelayout("��Ƶ");
					boolean shi=qservice.updfile2(wy);
					if(shi){
						JOptionPane.showMessageDialog(null, "�ϴ��ɹ�");
						//����
						tab.setRowCount(0);
//						tab2.setRowCount(0);
//						tab3.setRowCount(0);
						vv=qservice.selfile(mqq.getQqnum(), "��Ƶ");
//						vv2=qservice.selfile(mqq.getQqnum(), "ͼƬ");
//						vv3=qservice.selfile(mqq.getQqnum(), "�ĵ�");
						for(int i=0;i<vv.size();i++){
							Vector<Vector> us=vv.get(i);//��ȡ
							tab.addRow(us);//����������
						}
//						for(int i=0;i<vv2.size();i++){
//							Vector<Vector> us=vv2.get(i);//��ȡ
//							tab2.addRow(us);//����������
//						}
//						for(int i=0;i<vv3.size();i++){
//							Vector<Vector> us=vv3.get(i);//��ȡ
//							tab3.addRow(us);//����������
//						}
					}
				}
			}
			if(e.getSource()==it2){
				FileDialog fd=new FileDialog(QQcloudletmain.this,"ѡ���ļ�",FileDialog.LOAD);//��ȡ�ļ�
				fd.show();
				String filepath=fd.getDirectory()+"\\"+fd.getFile();//�ļ�·��
				if(fd.getFile()!=null){
					File file=new File(filepath);//Դ�ļ�
					//��
					try {
					FileInputStream infile = new FileInputStream(file);
					File tofile=new File("E:\\"+fd.getFile());//Ŀ���ļ�
					//ʵ�л������ д
					FileOutputStream outfile=new FileOutputStream(tofile);
					byte b[]=new byte[1024*1024];
					if(!tofile.exists()){
						tofile.createNewFile();//����
						
					}
					//ѭ��
					while(infile.read(b)!=-1){
						outfile.write(b);
					}
					//�ر�
					infile.close();
					outfile.close();
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					// ��ʽ��ʱ��
					Date date = new Date();// ��ȡϵͳ��ǰʱ��
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ������ʾʱ����ĸ�ʽ
					String time = sdf.format(date);// ��ȡʱ����
					//��ȡ�ļ�������
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(mqq.getQqnum());
					wy.setQqname(mqq.getQqname());
					wy.setFilepath(fd.getDirectory()+"\\"+fd.getFile());//�ļ�·��
					wy.setFilenames(fd.getFile());
					wy.setDate(time);
					wy.setFilelayout("ͼƬ");
					boolean shi=qservice.updfile2(wy);
					if(shi){
						JOptionPane.showMessageDialog(null, "�ϴ��ɹ�");
						//����
//						tab.setRowCount(0);
						tab2.setRowCount(0);
//						tab3.setRowCount(0);
//						vv=qservice.selfile(mqq.getQqnum(), "��Ƶ");
						vv2=qservice.selfile(mqq.getQqnum(), "ͼƬ");
//						vv3=qservice.selfile(mqq.getQqnum(), "�ĵ�");
//						for(int i=0;i<vv.size();i++){
//							Vector<Vector> us=vv.get(i);//��ȡ
//							tab.addRow(us);//����������
//						}
						for(int i=0;i<vv2.size();i++){
							Vector<Vector> us=vv2.get(i);//��ȡ
							tab2.addRow(us);//����������
						}
//						for(int i=0;i<vv3.size();i++){
//							Vector<Vector> us=vv3.get(i);//��ȡ
//							tab3.addRow(us);//����������
//						}
					}
				}
			}
			if(e.getSource()==it3){
				FileDialog fd=new FileDialog(QQcloudletmain.this,"ѡ���ļ�",FileDialog.LOAD);//��ȡ�ļ�
				fd.show();
				String filepath=fd.getDirectory()+"\\"+fd.getFile();//�ļ�·��
				if(fd.getFile()!=null){
					File file=new File(filepath);//Դ�ļ�
					//��
					try {
					FileInputStream infile = new FileInputStream(file);
					File tofile=new File("E:\\"+fd.getFile());//Ŀ���ļ�
					//ʵ�л������ д
					FileOutputStream outfile=new FileOutputStream(tofile);
					byte b[]=new byte[1024*1024];
					if(!tofile.exists()){
						tofile.createNewFile();//����
						
					}
					//ѭ��
					while(infile.read(b)!=-1){
						outfile.write(b);
					}
					//�ر�
					infile.close();
					outfile.close();
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					// ��ʽ��ʱ��
					Date date = new Date();// ��ȡϵͳ��ǰʱ��
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ������ʾʱ����ĸ�ʽ
					String time = sdf.format(date);// ��ȡʱ����
					//��ȡ�ļ�������
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(mqq.getQqnum());
					wy.setQqname(mqq.getQqname());
					wy.setFilepath(fd.getDirectory()+"\\"+fd.getFile());//�ļ�·��
					wy.setFilenames(fd.getFile());
					wy.setDate(time);
					wy.setFilelayout("�ĵ�");
					boolean shi=qservice.updfile2(wy);
					if(shi){
						JOptionPane.showMessageDialog(null, "�ϴ��ɹ�");
						//����
//						tab.setRowCount(0);
//						tab2.setRowCount(0);
						tab3.setRowCount(0);
//						vv=qservice.selfile(mqq.getQqnum(), "��Ƶ");
//						vv2=qservice.selfile(mqq.getQqnum(), "ͼƬ");
						vv3=qservice.selfile(mqq.getQqnum(), "�ĵ�");
//						for(int i=0;i<vv.size();i++){
//							Vector<Vector> us=vv.get(i);//��ȡ
//							tab.addRow(us);//����������
//						}
//						for(int i=0;i<vv2.size();i++){
//							Vector<Vector> us=vv2.get(i);//��ȡ
//							tab2.addRow(us);//����������
//						}
						for(int i=0;i<vv3.size();i++){
							Vector<Vector> us=vv3.get(i);//��ȡ
							tab3.addRow(us);//����������
						}
					}
				}
			}
		}
	}
	class A extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//����
			if(e.getSource()==bofang){
				if(tabp.getSelectedIndex()==0){
					Vector user=vv.get(table.getSelectedRow());//ѡ�е�����
					String names=user.get(0).toString();//��һ�е��ļ���
					String url = "E:/"+names;
					java.net.URI uri = java.net.URI.create(url);
					//System.out.println("asfsdf");
					// ��ȡ��ǰϵͳ������չ
					java.awt.Desktop dp = java.awt.Desktop.getDesktop();
					// �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
					if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							dp.browse(uri);
						} catch (Exception e1) {
	
						}// ��ȡϵͳĬ�������������
					}
				}
				if(tabp.getSelectedIndex()==1){
					Vector user2=vv2.get(table2.getSelectedRow());//ѡ�е�����
					String names2=user2.get(0).toString();//��һ�е��ļ���
					String url2 = "E:/"+names2;
					java.net.URI uri2 = java.net.URI.create(url2);
					// ��ȡ��ǰϵͳ������չ
					java.awt.Desktop dp2 = java.awt.Desktop.getDesktop();
					// �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
					//System.out.println("asfsdf");
					if (dp2.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							dp2.browse(uri2);
						} catch (Exception e1) {
	
						}// ��ȡϵͳĬ�������������
					}
				}
				if(tabp.getSelectedIndex()==2){
					Vector user3=vv3.get(table3.getSelectedRow());//ѡ�е�����
					String names3=user3.get(0).toString();//��һ�е��ļ���
					String url3 = "E:/"+names3;
					java.net.URI uri3 = java.net.URI.create(url3);
					// ��ȡ��ǰϵͳ������չ
					System.out.println("asfsdf");
					java.awt.Desktop dp3 = java.awt.Desktop.getDesktop();
					// �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
					if (dp3.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							dp3.browse(uri3);
						} catch (Exception e1) {
	
						}// ��ȡϵͳĬ�������������
					}
				}
			}
			
			if(e.getSource()==shangchuang){
				pop.show(shangchuang,e.getX(),e.getY());
				
			}
			if(e.getSource()==shuxing){
				try {
					if(tabp.getSelectedIndex()==0){
						Vector user=vv.get(table.getSelectedRow());//ѡ�е�����
						String names=user.get(0).toString();//��һ�е��ļ���
						String filelayout=user.get(1).toString();//��һ�е��ļ���
						if(names!=null&&filelayout.equals("��Ƶ")){
							QQweiyun wy=new QQweiyun();
							wy=qservice.selfile2(qquser.getQqnum(), names, "��Ƶ");
							JOptionPane.showMessageDialog(null, "�ļ����ͣ�"+wy.getFilelayout()+"���ļ����ƣ�"+wy.getFilenames()+""
									+ ",�ϴ�·����"+wy.getFilepath()+",�ϴ�ʱ��:"+wy.getDate());
						}
					}
					if(tabp.getSelectedIndex()==1){
						Vector user2=vv2.get(table2.getSelectedRow());//ѡ�е�����
						String names2=user2.get(0).toString();//��һ�е��ļ���
						String filelayout2=user2.get(1).toString();//��һ�е��ļ���
						if(names2!=null&&filelayout2.equals("ͼƬ")){
							QQweiyun wy2=new QQweiyun();
							wy2=qservice.selfile2(qquser.getQqnum(), names2, "ͼƬ");
							JOptionPane.showMessageDialog(null, "�ļ����ͣ�"+wy2.getFilelayout()+"���ļ����ƣ�"+wy2.getFilenames()+""
									+ ",�ϴ�·����"+wy2.getFilepath()+",�ϴ�ʱ��:"+wy2.getDate());
							System.out.println("2");
						}
					}
					if(tabp.getSelectedIndex()==2){
						Vector user3=vv3.get(table3.getSelectedRow());//ѡ�е�����
						String names3=user3.get(0).toString();//��һ�е��ļ���
						String filelayout3=user3.get(1).toString();//��һ�е��ļ���
						if(names3!=null&&filelayout3.equals("�ĵ�")){
							QQweiyun wy3=new QQweiyun();
							wy3=qservice.selfile2(qquser.getQqnum(), names3, "�ĵ�");
							JOptionPane.showMessageDialog(null, "�ļ����ͣ�"+wy3.getFilelayout()+"���ļ����ƣ�"+wy3.getFilenames()+""
									+ ",�ϴ�·����"+wy3.getFilepath()+",�ϴ�ʱ��:"+wy3.getDate());
							System.out.println("3");
						}
					}
					
				} catch (Exception e1) {
					
				}
				
			}
			if(e.getSource()==xiazai){
				if(tabp.getSelectedIndex()==0){
					Vector user=vv.get(table.getSelectedRow());//ѡ�е�����
					String names=user.get(0).toString();//��һ�е��ļ���
					FileDialog fd=new FileDialog(QQcloudletmain.this,"ѡ���ļ�",FileDialog.SAVE);//��ȡ�ļ�
					fd.setFile(names);//Ĭ������
					fd.show();
					String filepath=fd.getDirectory()+"\\"+fd.getFile();//�ļ�·��
					if(fd.getFile()!=null){
						File tofile=new File(filepath);//Ŀ��·��
						File file=new File("E:/"+names);//Դ�ļ�·��
						//��
						try {
						FileInputStream infile = new FileInputStream(file);
						
						//ʵ�л������ д
						FileOutputStream outfile=new FileOutputStream(tofile);
						byte b[]=new byte[1024*1024];
						if(!tofile.exists()){
							tofile.createNewFile();//����
							
						}
						//ѭ��
						while(infile.read(b)!=-1){
							outfile.write(b);
						}
						JOptionPane.showMessageDialog(null, "�������");
						//�ر�
						infile.close();
						outfile.close();
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
					}
				}
				if(tabp.getSelectedIndex()==1){
					Vector user2=vv2.get(table2.getSelectedRow());//ѡ�е�����
					String names2=user2.get(0).toString();//��һ�е��ļ���
					FileDialog fd2=new FileDialog(QQcloudletmain.this,"ѡ���ļ�",FileDialog.SAVE);//��ȡ�ļ�
					fd2.setFile(names2);//Ĭ������
					fd2.show();
					String filepath2=fd2.getDirectory()+"\\"+fd2.getFile();//�ļ�·��
					if(fd2.getFile()!=null){
						File tofile2=new File(filepath2);//Ŀ��·��
						File file2=new File("E:/"+names2);//Դ�ļ�·��
						//��
						try {
						FileInputStream infile2 = new FileInputStream(file2);
						
						//ʵ�л������ д
						FileOutputStream outfile2=new FileOutputStream(tofile2);
						byte b[]=new byte[1024*1024];
						if(!tofile2.exists()){
							tofile2.createNewFile();//����
							
						}
						//ѭ��
						while(infile2.read(b)!=-1){
							outfile2.write(b);
						}
						JOptionPane.showMessageDialog(null, "�������");
						//�ر�
						infile2.close();
						outfile2.close();
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
					}
				}
				if(tabp.getSelectedIndex()==2){
					Vector user3=vv3.get(table3.getSelectedRow());//ѡ�е�����
					String names3=user3.get(0).toString();//��һ�е��ļ���
					FileDialog fd3=new FileDialog(QQcloudletmain.this,"ѡ���ļ�",FileDialog.SAVE);//��ȡ�ļ�
					fd3.setFile(names3);//Ĭ������
					fd3.show();
					String filepath3=fd3.getDirectory()+"\\"+fd3.getFile();//�ļ�·��
					if(fd3.getFile()!=null){
						File tofile3=new File(filepath3);//Ŀ��·��
						File file3=new File("E:/"+names3);//Դ�ļ�·��
						//��
						try {
						FileInputStream infile3 = new FileInputStream(file3);
						
						//ʵ�л������ д
						FileOutputStream outfile3=new FileOutputStream(tofile3);
						byte b[]=new byte[1024*1024];
						if(!tofile3.exists()){
							tofile3.createNewFile();//����
							
						}
						//ѭ��
						while(infile3.read(b)!=-1){
							outfile3.write(b);
						}
						JOptionPane.showMessageDialog(null, "�������");
						//�ر�
						infile3.close();
						outfile3.close();
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
					}
				}
//				JOptionPane.showMessageDialog(null, "�������");
			}
			
			if(e.getSource()==xiao){//��С��
				QQcloudletmain.this.setExtendedState(QQcloudletmain.this.ICONIFIED);//��ֵ̬
				
			}else if(e.getSource()==close){//�ر�		
				dispose();
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
				xiao.setIcon(new ImageIcon(""));//ԭ����ͼƬ
				
			}
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon(""));//ԭ����ͼƬ
				
			}
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
				QQcloudletmain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQcloudletmain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQcloudletmain.this.getLocation().x + e.getX() - tmp.x,
							QQcloudletmain.this.getLocation().y + e.getY() - tmp.y);
					QQcloudletmain.this.setLocation(loc);
				}
			}
		});
	}
	/***********/

}