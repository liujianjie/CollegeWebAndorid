package QQmain;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class QQzitipane extends JFrame implements FocusListener{
	
	JComboBox font,fontsize;
	JLabel fntcolor;
	
	String fonts[] = { "Ĭ������","����", "����", "����", "΢���ź�", "��Բ", "����","Helvetica","Trebuchet MS","Verdana","Lucida Family","Arial" };

	String[] fontsizes = { "12", "14", "16", "18", "20", "22", "24" };
	
	QQchat chat;
	public QQzitipane(int x,int y,QQchat chat){
		super();
		//���������ʽ
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
					+ "windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
		this.chat=chat;
		Container con = getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
		this.setUndecorated(true);//�ޱ߿�
		con.setBackground(Color.white);
		//����
		font=new JComboBox(fonts);
		con.add(font);
		
		//�����С
		fontsize=new JComboBox(fontsizes);
		con.add(fontsize);
		
		//������ɫ
		fntcolor=new JLabel("������ɫ");
		con.add(fntcolor);
		fntcolor.setCursor(new Cursor(Cursor.HAND_CURSOR));//����
		
		//����
		addFocusListener(this);
		fntcolor.addMouseListener(new B());
		font.addItemListener(new C());
		fontsize.addItemListener(new C());		
		setSize(445, 30);
		setVisible(true);
		setLocation(x, y);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//��ť
	class B extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			//��ɫ
			if(e.getSource()==fntcolor){
				JColorChooser chooser=new JColorChooser();
				Color color=chooser.showDialog(null, "��ɫѡ��", Color.BLACK);
				chat.t2.setForeground(color);
			}
		}	
	}
	//������
	class C implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==font||e.getSource()==fontsize){
				String fontt=font.getSelectedItem().toString();
				int fsize=Integer.parseInt(fontsize.getSelectedItem().toString());
				chat.t2.setFont(new Font(fontt,Font.PLAIN,fsize));
			}
	
		}
		
	}
	public static void main(String[] args) {
	//	new QQzitipane();
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO �Զ����ɵķ������
		QQzitipane.this.dispose();
	}

}
