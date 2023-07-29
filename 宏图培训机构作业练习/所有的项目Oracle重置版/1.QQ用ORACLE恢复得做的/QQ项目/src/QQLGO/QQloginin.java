package QQLGO;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import QQmain.qqmain;
import QQ���ݿ���Ϣ.QQgame;
import QQ���ݿ���Ϣ.QQuser;
import QQcloudlet.QQweiyun;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;
//������Դ������  23 11 ������
public class QQloginin extends JFrame{
	QQuserInterface qserive=new QQuserimp();
	JLabel xiao,close,bg,xia;
	JLabel face;//ͷ��
	QQuser qq;//�����û���Ϣ
	QQgame qqgame;//��Ϸ��Ϣ
	private static final long serialVersionUID = 1L;
	public QQloginin(QQuser qq,QQgame qqgame) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		super("");
		this.qq=qq;
		this.qqgame=qqgame;
		//���������ʽ
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		Container con=getContentPane();
		// ����ͼƬ
		setIconImage(new ImageIcon("img/tubiao.jpg").getImage());
		this.setUndecorated(true);//�ޱ߿�
		//���ý�������϶��ķ���
		setDragable();

		xiao=new JLabel();
		xiao.setBounds(370,0,29,28);
		con.add(xiao);
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		close=new JLabel();
		close.setBounds(400,0,29,28);
		con.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		xia=new JLabel();
		xia.setBounds(340,0,29,28);
		con.add(xia);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
	
		
		face=new JLabel(new ImageIcon(qq.getFace()));
		face.setBounds(180, 190, 60, 60);
		con.add(face);
		
		JProgressBar progressBar = new JProgressBar();// ��������������
		progressBar.setStringPainted(true);// ������ʾ��ʾ��Ϣ
		progressBar.setIndeterminate(true);// ���ò��ò�ȷ��������
		progressBar.setString("��¼��...");// ������ʾ��Ϣ
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_1.gridy = 1;
		gridBagConstraints_1.gridx = 0;
		progressBar.setBounds(160,265,100,25);
		
		final JButton button = new JButton();
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_2.gridy = 2;
		gridBagConstraints_2.gridx = 1;
		new Progress(progressBar, button).start();// �����߳�ģ��һ��������������
		con.add(progressBar);
		
		
		//����
		xiao.addMouseListener(new A());
		close.addMouseListener(new A());
		xia.addMouseListener(new A());
		/* ����ͼƬ */
		ImageIcon images = new ImageIcon("img/bg3111.png");
		JLabel jl = new JLabel(images);// ͼƬ��ǩ
		con.add(jl);
		bg=new JLabel();
		setSize(430,310);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class Progress extends Thread {// �����߳�ģ��һ��������������
		private final int[] progressValue = { 6, 18, 27, 39, 51, 66, 81,
				100 };// ģ��������ɰٷֱ�
		private JProgressBar progressBar;// ����������
		private JButton button;// ��ɰ�ť����
		
		public Progress(JProgressBar progressBar, JButton button) {
			this.progressBar = progressBar;
			this.button = button;
		}
		
		public void run() {
			// ͨ��ѭ������������ɰٷֱ�
			for (int i = 0; i <progressValue.length; i++) {
				try {
					Thread.sleep(200);// ���߳�����1��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				progressBar.setValue(progressValue[i]);// ����������ɰٷֱ�
			}
			progressBar.setIndeterminate(false);// ���ò���ȷ��������
			progressBar.setString("��¼�ɹ���");// ������ʾ��Ϣ
			//	z�������������
			
			QQloginin.this.dispose();//�رյ���
			new qqmain(qq,qqgame);//�û���Ϣ
			}			
	}
	class A extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==xiao){//��С��
				QQloginin.this.setExtendedState(QQloginin.this.ICONIFIED);//��ֵ̬
				
			}else if(e.getSource()==close){//�ر�
				System.exit(0);
				
			}
			
		}
		public void mouseEntered(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon("img/loginxiao.png"));
				
			}
			if(e.getSource()==close){
				close.setIcon(new ImageIcon("img/loginclose.png"));
				
			}
			if(e.getSource()==xia){
				xia.setIcon(new ImageIcon("img/loginxia.png"));
				
			}
		}
		public void mouseExited(MouseEvent e){
			if(e.getSource()==xiao){
				xiao.setIcon(new ImageIcon(""));//��Ϊԭ����ͼƬ
				
			}
			
			if(e.getSource()==close){
				close.setIcon(new ImageIcon(""));
				
			}
			if(e.getSource()==xia){
				xia.setIcon(new ImageIcon(""));
				
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
				QQloginin.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQloginin.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQloginin.this.getLocation().x + e.getX() - tmp.x,
							QQloginin.this.getLocation().y + e.getY() - tmp.y);
					QQloginin.this.setLocation(loc);
				}
			}
		});
	}
	/***********/

	//public static void main(String[] args) {
	//	new QQloginin(qq);
//	}
}
