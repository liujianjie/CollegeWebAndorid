package twentythree.two.three;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import twentythree.one.two.TestTablePane;

public class DoMyselfMenu extends JFrame{
	public DoMyselfMenu(){
		super("���Ƹ��Ի��˵�");
		URL resource = TestTablePane.class.getResource("img1.png");
		ImageIcon ic = new ImageIcon(resource);
		// 1.�˵���
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		// 2.�˵�����
		JMenu menu = new JMenu("�ļ���F��");
		// 4.1��ݼ�
		menu.setMnemonic('F');
		menubar.add(menu);
		JMenu menu2 = new JMenu("�༭��E��");
		menu2.setMnemonic('E');
		menubar.add(menu2);
		JMenu menu3 = new JMenu("������H��");
		menu3.setMnemonic('H');
		menubar.add(menu3);
		
		// 3.�˵������
		JMenuItem menuitem1 = new JMenuItem("�½�(N)");
		menuitem1.setMnemonic('N'); 
		// 4.2 ������
		// ���ü�����Ϊ Ctrl+N     ����û�� VK_R CRTL_MASK ALT_MASK û�� ����                                         
		menuitem1.setAccelerator(KeyStroke.getKeyStroke("5"));
		menuitem1.addActionListener(new ItemListener());
		menu.add(menuitem1);
		// 4.3 �ָ���
		menu.addSeparator();
		
		
		// 4.4** �˵�������Ӳ˵� ������Ӳ˵���
		JMenu opendmenu2 = new JMenu("��(O)");
		opendmenu2.setMnemonic('O');
		menu.add(opendmenu2);
		
		// �Ӳ˵������ 
		JMenuItem openitem = new JMenuItem("δ�򿪹��ģ�N��");
		openitem.setMnemonic('N');
		openitem.setAccelerator(KeyStroke.getKeyStroke("6"));
		openitem.addActionListener(new ItemListener());
		opendmenu2.add(openitem);
		
		JMenuItem openeditem3 = new JMenuItem("�մ򿪹��ģ�C��");
		openeditem3.setMnemonic('C');
		openeditem3.setAccelerator(KeyStroke.getKeyStroke("7"));
		openeditem3.addActionListener(new ItemListener());
		openeditem3.setEnabled(false);// ���ò�����
		opendmenu2.add(openeditem3);
		
		JMenuItem menuitem = new JMenuItem("����");
		menu.add(menuitem);
		menuitem = new JMenuItem("�˳�");
		menu.add(menuitem);
		menuitem = new JMenuItem("����");
		menuitem.setIcon(ic);
		menu2.add(menuitem);
		menuitem = new JMenuItem("����");
		menuitem.setIcon(ic);
		menu2.add(menuitem);
		menuitem = new JMenuItem("ճ��");
		menuitem.setIcon(ic);
		menu2.add(menuitem);
		menu2.insertSeparator(2); // ��ڶ����˵���ӷָ��� 4.3
		
		// 4.4** �˵�������Ӳ˵� ������Ӳ˵���
		JMenu attributeMenu = new JMenu("����(A)");
		attributeMenu.setIcon(ic);
		attributeMenu.setMnemonic('A');
		menu2.add(attributeMenu);
		
		JMenu Fontmenu = new JMenu("���壨F��");
		Fontmenu.setIcon(ic);
		Fontmenu.setMnemonic('F');
		menu2.add(Fontmenu);
		
		// 5.1��ѡ��
		JCheckBoxMenuItem bcheckbo = new JCheckBoxMenuItem("�Ӵ�(B)");
		bcheckbo.setMnemonic('B');
		bcheckbo.setAccelerator(KeyStroke.getKeyStroke('7'));
		bcheckbo.addActionListener(new ItemListener());
		Fontmenu.add(bcheckbo);
		JCheckBoxMenuItem iCheckbo = new JCheckBoxMenuItem("б��(I)");
		iCheckbo.setMnemonic('I');
		iCheckbo.setAccelerator(KeyStroke.getKeyStroke('8'));
		iCheckbo.addActionListener(new ItemListener());
		Fontmenu.add(iCheckbo);
		
		
		// 5.2��ѡ��
		ButtonGroup attribtgroup = new ButtonGroup();
		JRadioButtonMenuItem rradiobut = new JRadioButtonMenuItem("ֻ����R��");
		rradiobut.setMnemonic('R');
		rradiobut.setAccelerator(KeyStroke.getKeyStroke("P"));
		attribtgroup.add(rradiobut);
		rradiobut.setSelected(true);
		rradiobut.addActionListener(new ItemListener());
		// ��ӵ����Բ˵���
		attributeMenu.add(rradiobut);
		
		JRadioButtonMenuItem editadiobut = new JRadioButtonMenuItem("�༭��E��");
		editadiobut.setMnemonic('E');
		editadiobut.setAccelerator(KeyStroke.getKeyStroke("Q"));
		attribtgroup.add(editadiobut);
		editadiobut.addActionListener(new ItemListener());
		// ��ӵ����Բ˵���
		attributeMenu.add(editadiobut);
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DoMyselfMenu();
	}
	
	class ItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
