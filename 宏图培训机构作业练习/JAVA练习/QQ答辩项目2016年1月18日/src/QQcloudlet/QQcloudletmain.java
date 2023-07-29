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

import QQ数据库信息.QQuser;

public class QQcloudletmain extends JFrame{
	JLabel bg,close,xiao,face,nicheng,shangchuang,xiazai,shuxing,wode,bofang;
	JLabel j1,j2,j3,j4,j5,j6;//接收文件的名称
	QQweiyun a1,a2,a3,a4,a5,a6;//检测是否为空
	QQuser qquser;
	QQweiyunfafang qservice=new QQweiyunfafang();
	QQweiyun wy;
	QQuser mqq;
	JPanel p2;
	JPopupMenu pop;
	JMenuItem it1,it2,it3;//上传类型
	JPopupMenu pop1;
	JMenuItem it11,it22,it33;//打开方式
	JTabbedPane tabp;
	//资源
	public Vector<Vector> tilte,datas,tilte2,datas2,tilte3,datas3;//标题 数据
	Vector<Vector> vv,vv2,vv3;
	DefaultTableModel tab,tab2,tab3;
	JTable table,table2,table3;
	public QQcloudletmain(QQuser mqq){
		super("");
		this.mqq=mqq;
		this.qquser=mqq;
		//设置组件样式
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
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		close=new JLabel(new ImageIcon(""));
		close.setBounds(770, 0, 29, 28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		face=new JLabel(new ImageIcon(mqq.getFace()));
		p1.add(face);
		
		nicheng=new JLabel(mqq.getQqname());
		nicheng.setFont(new Font("宋体",Font.BOLD,20));
		p1.add(nicheng);
		
		shangchuang=new JLabel(new ImageIcon("QQweiyun/shangchuagn.png"));
		p1.add(shangchuang);
		shangchuang.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		
		p1.setBounds(10, 30,800, 70);
		con.add(p1);
		//我的资源

		//________________________________________
		//表格的列
		tabp = new JTabbedPane();//选项卡
		Vector title=new Vector();
		title.add("文件名");
		title.add("文件类型");
		this.tilte=title;
		Vector datas=new Vector();
		
		tab=new DefaultTableModel();
		tab.setDataVector(datas, title);
		table=new JTable(tab);
		
		//返回
		tab.setRowCount(0);
		vv=qservice.selfile(mqq.getQqnum(), "视频");
		for(int i=0;i<vv.size();i++){
			Vector<Vector> us=vv.get(i);//读取
			tab.addRow(us);//加入数据中
		}
		
		//滚动条
		//JScrollPane sp1=new JScrollPane(table);
		tabp.add(table,"  视频  ");
		
		Vector title2=new Vector();
		title2.add("文件名");
		title2.add("文件类型");
		this.tilte2=title2;
		Vector datas2=new Vector();
		tab2=new DefaultTableModel();
		tab2.setDataVector(datas2, title2);
		table2=new JTable(tab2);
		//返回
		tab2.setRowCount(0);
		vv2=qservice.selfile(mqq.getQqnum(), "图片");	
		for(int i=0;i<vv2.size();i++){
			Vector<Vector> us=vv2.get(i);//读取
			tab2.addRow(us);//加入数据中
		}
		tabp.add(table2,"  图片  ");
		
		Vector title3=new Vector();
		title3.add("文件名");
		title3.add("文件类型");
		this.tilte3=title3;
		Vector datas3=new Vector();
		
		tab3=new DefaultTableModel();
		tab3.setDataVector(datas3, title3);
		table3=new JTable(tab3);
		
		//返回
		tab3.setRowCount(0);		
		vv3=qservice.selfile(mqq.getQqnum(), " 文档 ");
		for(int i=0;i<vv3.size();i++){
			Vector<Vector> us=vv3.get(i);//读取
			tab3.addRow(us);//加入数据中
		}
		tabp.add(table3,"  文档  ");
		
		
		con.add(tabp);
		tabp.setBounds(10,160,780,380);
		
		
		wode=new JLabel(new ImageIcon("QQweiyun/我的资源.png"));
		wode.setBounds(10,100,164,57);
		con.add(wode);
		//下面
		p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,15));
		
		bofang=new JLabel(new ImageIcon("QQweiyun/打开.png"));
		p2.add(bofang);
		
		shuxing=new JLabel(new ImageIcon("QQweiyun/属性.png"));
//		shuxing.setFont(new Font("宋体",Font.PLAIN,23));
//		shuxing.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		p2.add(shuxing);
		
		xiazai=new JLabel(new ImageIcon("QQweiyun/下载.png"));
		xiazai.setCursor(new Cursor(Cursor.HAND_CURSOR));//手型
		p2.add(xiazai);
		
		p2.setBounds(10, 540, 780, 60);
		con.add(p2);
		// 窗口图片
		setIconImage(new ImageIcon("QQweiyun/weiyun.png").getImage());
		this.setUndecorated(true);//无边框
		//设置界面可以拖动的方法
		setDragable();
		
		bg=new JLabel(new ImageIcon("QQweiyun/weiyuntou.png"));
		bg.setBounds(0, 0, 800,32);
		con.add(bg);
		
		//监听
		bofang.addMouseListener(new A());
		shuxing.addMouseListener(new A());
		xiazai.addMouseListener(new A());
		shangchuang.addMouseListener(new A());
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		pop=new JPopupMenu();
		it1=new JMenuItem("上传视频");
		it2=new JMenuItem("上传图片");
		it3=new JMenuItem("上传文档");
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
				FileDialog fd=new FileDialog(QQcloudletmain.this,"选择文件",FileDialog.LOAD);//读取文件
				fd.show();
				String filepath=fd.getDirectory()+"\\"+fd.getFile();//文件路径
				if(fd.getFile()!=null){
					File file=new File(filepath);//源文件
					//读
					try {
					FileInputStream infile = new FileInputStream(file);
					File tofile=new File("E:\\"+fd.getFile());//目标文件
					//实列化输出流 写
					FileOutputStream outfile=new FileOutputStream(tofile);
					byte b[]=new byte[1024*1024];
					if(!tofile.exists()){
						tofile.createNewFile();//创建
						
					}
					//循环
					while(infile.read(b)!=-1){
						outfile.write(b);
					}
					//关闭
					infile.close();
					outfile.close();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					// 格式化时间
					Date date = new Date();// 获取系统当前时间
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置显示时分秒的格式
					String time = sdf.format(date);// 获取时分秒
					//获取文件的属性
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(mqq.getQqnum());
					wy.setQqname(mqq.getQqname());
					wy.setFilepath(fd.getDirectory()+"\\"+fd.getFile());//文件路径
					wy.setFilenames(fd.getFile());
					wy.setDate(time);
					wy.setFilelayout("视频");
					boolean shi=qservice.updfile2(wy);
					if(shi){
						JOptionPane.showMessageDialog(null, "上传成功");
						//返回
						tab.setRowCount(0);
//						tab2.setRowCount(0);
//						tab3.setRowCount(0);
						vv=qservice.selfile(mqq.getQqnum(), "视频");
//						vv2=qservice.selfile(mqq.getQqnum(), "图片");
//						vv3=qservice.selfile(mqq.getQqnum(), "文档");
						for(int i=0;i<vv.size();i++){
							Vector<Vector> us=vv.get(i);//读取
							tab.addRow(us);//加入数据中
						}
//						for(int i=0;i<vv2.size();i++){
//							Vector<Vector> us=vv2.get(i);//读取
//							tab2.addRow(us);//加入数据中
//						}
//						for(int i=0;i<vv3.size();i++){
//							Vector<Vector> us=vv3.get(i);//读取
//							tab3.addRow(us);//加入数据中
//						}
					}
				}
			}
			if(e.getSource()==it2){
				FileDialog fd=new FileDialog(QQcloudletmain.this,"选择文件",FileDialog.LOAD);//读取文件
				fd.show();
				String filepath=fd.getDirectory()+"\\"+fd.getFile();//文件路径
				if(fd.getFile()!=null){
					File file=new File(filepath);//源文件
					//读
					try {
					FileInputStream infile = new FileInputStream(file);
					File tofile=new File("E:\\"+fd.getFile());//目标文件
					//实列化输出流 写
					FileOutputStream outfile=new FileOutputStream(tofile);
					byte b[]=new byte[1024*1024];
					if(!tofile.exists()){
						tofile.createNewFile();//创建
						
					}
					//循环
					while(infile.read(b)!=-1){
						outfile.write(b);
					}
					//关闭
					infile.close();
					outfile.close();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					// 格式化时间
					Date date = new Date();// 获取系统当前时间
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置显示时分秒的格式
					String time = sdf.format(date);// 获取时分秒
					//获取文件的属性
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(mqq.getQqnum());
					wy.setQqname(mqq.getQqname());
					wy.setFilepath(fd.getDirectory()+"\\"+fd.getFile());//文件路径
					wy.setFilenames(fd.getFile());
					wy.setDate(time);
					wy.setFilelayout("图片");
					boolean shi=qservice.updfile2(wy);
					if(shi){
						JOptionPane.showMessageDialog(null, "上传成功");
						//返回
//						tab.setRowCount(0);
						tab2.setRowCount(0);
//						tab3.setRowCount(0);
//						vv=qservice.selfile(mqq.getQqnum(), "视频");
						vv2=qservice.selfile(mqq.getQqnum(), "图片");
//						vv3=qservice.selfile(mqq.getQqnum(), "文档");
//						for(int i=0;i<vv.size();i++){
//							Vector<Vector> us=vv.get(i);//读取
//							tab.addRow(us);//加入数据中
//						}
						for(int i=0;i<vv2.size();i++){
							Vector<Vector> us=vv2.get(i);//读取
							tab2.addRow(us);//加入数据中
						}
//						for(int i=0;i<vv3.size();i++){
//							Vector<Vector> us=vv3.get(i);//读取
//							tab3.addRow(us);//加入数据中
//						}
					}
				}
			}
			if(e.getSource()==it3){
				FileDialog fd=new FileDialog(QQcloudletmain.this,"选择文件",FileDialog.LOAD);//读取文件
				fd.show();
				String filepath=fd.getDirectory()+"\\"+fd.getFile();//文件路径
				if(fd.getFile()!=null){
					File file=new File(filepath);//源文件
					//读
					try {
					FileInputStream infile = new FileInputStream(file);
					File tofile=new File("E:\\"+fd.getFile());//目标文件
					//实列化输出流 写
					FileOutputStream outfile=new FileOutputStream(tofile);
					byte b[]=new byte[1024*1024];
					if(!tofile.exists()){
						tofile.createNewFile();//创建
						
					}
					//循环
					while(infile.read(b)!=-1){
						outfile.write(b);
					}
					//关闭
					infile.close();
					outfile.close();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					// 格式化时间
					Date date = new Date();// 获取系统当前时间
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置显示时分秒的格式
					String time = sdf.format(date);// 获取时分秒
					//获取文件的属性
					QQweiyun wy=new QQweiyun();
					wy.setQqnum(mqq.getQqnum());
					wy.setQqname(mqq.getQqname());
					wy.setFilepath(fd.getDirectory()+"\\"+fd.getFile());//文件路径
					wy.setFilenames(fd.getFile());
					wy.setDate(time);
					wy.setFilelayout("文档");
					boolean shi=qservice.updfile2(wy);
					if(shi){
						JOptionPane.showMessageDialog(null, "上传成功");
						//返回
//						tab.setRowCount(0);
//						tab2.setRowCount(0);
						tab3.setRowCount(0);
//						vv=qservice.selfile(mqq.getQqnum(), "视频");
//						vv2=qservice.selfile(mqq.getQqnum(), "图片");
						vv3=qservice.selfile(mqq.getQqnum(), "文档");
//						for(int i=0;i<vv.size();i++){
//							Vector<Vector> us=vv.get(i);//读取
//							tab.addRow(us);//加入数据中
//						}
//						for(int i=0;i<vv2.size();i++){
//							Vector<Vector> us=vv2.get(i);//读取
//							tab2.addRow(us);//加入数据中
//						}
						for(int i=0;i<vv3.size();i++){
							Vector<Vector> us=vv3.get(i);//读取
							tab3.addRow(us);//加入数据中
						}
					}
				}
			}
		}
	}
	class A extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//功能
			if(e.getSource()==bofang){
				if(tabp.getSelectedIndex()==0){
					Vector user=vv.get(table.getSelectedRow());//选中的数据
					String names=user.get(0).toString();//第一列的文件名
					String url = "E:/"+names;
					java.net.URI uri = java.net.URI.create(url);
					//System.out.println("asfsdf");
					// 获取当前系统桌面扩展
					java.awt.Desktop dp = java.awt.Desktop.getDesktop();
					// 判断系统桌面是否支持要执行的功能
					if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							dp.browse(uri);
						} catch (Exception e1) {
	
						}// 获取系统默认浏览器打开链接
					}
				}
				if(tabp.getSelectedIndex()==1){
					Vector user2=vv2.get(table2.getSelectedRow());//选中的数据
					String names2=user2.get(0).toString();//第一列的文件名
					String url2 = "E:/"+names2;
					java.net.URI uri2 = java.net.URI.create(url2);
					// 获取当前系统桌面扩展
					java.awt.Desktop dp2 = java.awt.Desktop.getDesktop();
					// 判断系统桌面是否支持要执行的功能
					//System.out.println("asfsdf");
					if (dp2.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							dp2.browse(uri2);
						} catch (Exception e1) {
	
						}// 获取系统默认浏览器打开链接
					}
				}
				if(tabp.getSelectedIndex()==2){
					Vector user3=vv3.get(table3.getSelectedRow());//选中的数据
					String names3=user3.get(0).toString();//第一列的文件名
					String url3 = "E:/"+names3;
					java.net.URI uri3 = java.net.URI.create(url3);
					// 获取当前系统桌面扩展
					System.out.println("asfsdf");
					java.awt.Desktop dp3 = java.awt.Desktop.getDesktop();
					// 判断系统桌面是否支持要执行的功能
					if (dp3.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							dp3.browse(uri3);
						} catch (Exception e1) {
	
						}// 获取系统默认浏览器打开链接
					}
				}
			}
			
			if(e.getSource()==shangchuang){
				pop.show(shangchuang,e.getX(),e.getY());
				
			}
			if(e.getSource()==shuxing){
				try {
					if(tabp.getSelectedIndex()==0){
						Vector user=vv.get(table.getSelectedRow());//选中的数据
						String names=user.get(0).toString();//第一列的文件名
						String filelayout=user.get(1).toString();//第一列的文件名
						if(names!=null&&filelayout.equals("视频")){
							QQweiyun wy=new QQweiyun();
							wy=qservice.selfile2(qquser.getQqnum(), names, "视频");
							JOptionPane.showMessageDialog(null, "文件类型："+wy.getFilelayout()+"，文件名称："+wy.getFilenames()+""
									+ ",上传路径："+wy.getFilepath()+",上传时间:"+wy.getDate());
						}
					}
					if(tabp.getSelectedIndex()==1){
						Vector user2=vv2.get(table2.getSelectedRow());//选中的数据
						String names2=user2.get(0).toString();//第一列的文件名
						String filelayout2=user2.get(1).toString();//第一列的文件名
						if(names2!=null&&filelayout2.equals("图片")){
							QQweiyun wy2=new QQweiyun();
							wy2=qservice.selfile2(qquser.getQqnum(), names2, "图片");
							JOptionPane.showMessageDialog(null, "文件类型："+wy2.getFilelayout()+"，文件名称："+wy2.getFilenames()+""
									+ ",上传路径："+wy2.getFilepath()+",上传时间:"+wy2.getDate());
							System.out.println("2");
						}
					}
					if(tabp.getSelectedIndex()==2){
						Vector user3=vv3.get(table3.getSelectedRow());//选中的数据
						String names3=user3.get(0).toString();//第一列的文件名
						String filelayout3=user3.get(1).toString();//第一列的文件名
						if(names3!=null&&filelayout3.equals("文档")){
							QQweiyun wy3=new QQweiyun();
							wy3=qservice.selfile2(qquser.getQqnum(), names3, "文档");
							JOptionPane.showMessageDialog(null, "文件类型："+wy3.getFilelayout()+"，文件名称："+wy3.getFilenames()+""
									+ ",上传路径："+wy3.getFilepath()+",上传时间:"+wy3.getDate());
							System.out.println("3");
						}
					}
					
				} catch (Exception e1) {
					
				}
				
			}
			if(e.getSource()==xiazai){
				if(tabp.getSelectedIndex()==0){
					Vector user=vv.get(table.getSelectedRow());//选中的数据
					String names=user.get(0).toString();//第一列的文件名
					FileDialog fd=new FileDialog(QQcloudletmain.this,"选择文件",FileDialog.SAVE);//读取文件
					fd.setFile(names);//默认名字
					fd.show();
					String filepath=fd.getDirectory()+"\\"+fd.getFile();//文件路径
					if(fd.getFile()!=null){
						File tofile=new File(filepath);//目标路径
						File file=new File("E:/"+names);//源文件路径
						//读
						try {
						FileInputStream infile = new FileInputStream(file);
						
						//实列化输出流 写
						FileOutputStream outfile=new FileOutputStream(tofile);
						byte b[]=new byte[1024*1024];
						if(!tofile.exists()){
							tofile.createNewFile();//创建
							
						}
						//循环
						while(infile.read(b)!=-1){
							outfile.write(b);
						}
						JOptionPane.showMessageDialog(null, "下载完成");
						//关闭
						infile.close();
						outfile.close();
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					}
				}
				if(tabp.getSelectedIndex()==1){
					Vector user2=vv2.get(table2.getSelectedRow());//选中的数据
					String names2=user2.get(0).toString();//第一列的文件名
					FileDialog fd2=new FileDialog(QQcloudletmain.this,"选择文件",FileDialog.SAVE);//读取文件
					fd2.setFile(names2);//默认名字
					fd2.show();
					String filepath2=fd2.getDirectory()+"\\"+fd2.getFile();//文件路径
					if(fd2.getFile()!=null){
						File tofile2=new File(filepath2);//目标路径
						File file2=new File("E:/"+names2);//源文件路径
						//读
						try {
						FileInputStream infile2 = new FileInputStream(file2);
						
						//实列化输出流 写
						FileOutputStream outfile2=new FileOutputStream(tofile2);
						byte b[]=new byte[1024*1024];
						if(!tofile2.exists()){
							tofile2.createNewFile();//创建
							
						}
						//循环
						while(infile2.read(b)!=-1){
							outfile2.write(b);
						}
						JOptionPane.showMessageDialog(null, "下载完成");
						//关闭
						infile2.close();
						outfile2.close();
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					}
				}
				if(tabp.getSelectedIndex()==2){
					Vector user3=vv3.get(table3.getSelectedRow());//选中的数据
					String names3=user3.get(0).toString();//第一列的文件名
					FileDialog fd3=new FileDialog(QQcloudletmain.this,"选择文件",FileDialog.SAVE);//读取文件
					fd3.setFile(names3);//默认名字
					fd3.show();
					String filepath3=fd3.getDirectory()+"\\"+fd3.getFile();//文件路径
					if(fd3.getFile()!=null){
						File tofile3=new File(filepath3);//目标路径
						File file3=new File("E:/"+names3);//源文件路径
						//读
						try {
						FileInputStream infile3 = new FileInputStream(file3);
						
						//实列化输出流 写
						FileOutputStream outfile3=new FileOutputStream(tofile3);
						byte b[]=new byte[1024*1024];
						if(!tofile3.exists()){
							tofile3.createNewFile();//创建
							
						}
						//循环
						while(infile3.read(b)!=-1){
							outfile3.write(b);
						}
						JOptionPane.showMessageDialog(null, "下载完成");
						//关闭
						infile3.close();
						outfile3.close();
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					}
				}
//				JOptionPane.showMessageDialog(null, "下载完成");
			}
			
			if(e.getSource()==xiao){//最小化
				QQcloudletmain.this.setExtendedState(QQcloudletmain.this.ICONIFIED);//静态值
				
			}else if(e.getSource()==close){//关闭		
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
				xiao.setIcon(new ImageIcon(""));//原来的图片
				
			}
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon(""));//原来的图片
				
			}
		}
	}
	
	
	/***********/
	//设置界面可以拖动的方法
	
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