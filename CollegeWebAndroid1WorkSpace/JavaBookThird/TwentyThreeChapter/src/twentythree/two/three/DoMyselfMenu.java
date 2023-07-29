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
		super("定制个性化菜单");
		URL resource = TestTablePane.class.getResource("img1.png");
		ImageIcon ic = new ImageIcon(resource);
		// 1.菜单栏
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		// 2.菜单对象
		JMenu menu = new JMenu("文件（F）");
		// 4.1快捷键
		menu.setMnemonic('F');
		menubar.add(menu);
		JMenu menu2 = new JMenu("编辑（E）");
		menu2.setMnemonic('E');
		menubar.add(menu2);
		JMenu menu3 = new JMenu("帮助（H）");
		menu3.setMnemonic('H');
		menubar.add(menu3);
		
		// 3.菜单项对象
		JMenuItem menuitem1 = new JMenuItem("新建(N)");
		menuitem1.setMnemonic('N'); 
		// 4.2 加速器
		// 设置加速器为 Ctrl+N     但是没用 VK_R CRTL_MASK ALT_MASK 没用 气人                                         
		menuitem1.setAccelerator(KeyStroke.getKeyStroke("5"));
		menuitem1.addActionListener(new ItemListener());
		menu.add(menuitem1);
		// 4.3 分隔线
		menu.addSeparator();
		
		
		// 4.4** 菜单可以添加菜单 不必添加菜单项
		JMenu opendmenu2 = new JMenu("打开(O)");
		opendmenu2.setMnemonic('O');
		menu.add(opendmenu2);
		
		// 子菜单项的子 
		JMenuItem openitem = new JMenuItem("未打开过的（N）");
		openitem.setMnemonic('N');
		openitem.setAccelerator(KeyStroke.getKeyStroke("6"));
		openitem.addActionListener(new ItemListener());
		opendmenu2.add(openitem);
		
		JMenuItem openeditem3 = new JMenuItem("刚打开过的（C）");
		openeditem3.setMnemonic('C');
		openeditem3.setAccelerator(KeyStroke.getKeyStroke("7"));
		openeditem3.addActionListener(new ItemListener());
		openeditem3.setEnabled(false);// 设置不可用
		opendmenu2.add(openeditem3);
		
		JMenuItem menuitem = new JMenuItem("保存");
		menu.add(menuitem);
		menuitem = new JMenuItem("退出");
		menu.add(menuitem);
		menuitem = new JMenuItem("剪切");
		menuitem.setIcon(ic);
		menu2.add(menuitem);
		menuitem = new JMenuItem("复制");
		menuitem.setIcon(ic);
		menu2.add(menuitem);
		menuitem = new JMenuItem("粘贴");
		menuitem.setIcon(ic);
		menu2.add(menuitem);
		menu2.insertSeparator(2); // 向第二个菜单添加分割线 4.3
		
		// 4.4** 菜单可以添加菜单 不必添加菜单项
		JMenu attributeMenu = new JMenu("属性(A)");
		attributeMenu.setIcon(ic);
		attributeMenu.setMnemonic('A');
		menu2.add(attributeMenu);
		
		JMenu Fontmenu = new JMenu("字体（F）");
		Fontmenu.setIcon(ic);
		Fontmenu.setMnemonic('F');
		menu2.add(Fontmenu);
		
		// 5.1复选框
		JCheckBoxMenuItem bcheckbo = new JCheckBoxMenuItem("加粗(B)");
		bcheckbo.setMnemonic('B');
		bcheckbo.setAccelerator(KeyStroke.getKeyStroke('7'));
		bcheckbo.addActionListener(new ItemListener());
		Fontmenu.add(bcheckbo);
		JCheckBoxMenuItem iCheckbo = new JCheckBoxMenuItem("斜体(I)");
		iCheckbo.setMnemonic('I');
		iCheckbo.setAccelerator(KeyStroke.getKeyStroke('8'));
		iCheckbo.addActionListener(new ItemListener());
		Fontmenu.add(iCheckbo);
		
		
		// 5.2单选框
		ButtonGroup attribtgroup = new ButtonGroup();
		JRadioButtonMenuItem rradiobut = new JRadioButtonMenuItem("只读（R）");
		rradiobut.setMnemonic('R');
		rradiobut.setAccelerator(KeyStroke.getKeyStroke("P"));
		attribtgroup.add(rradiobut);
		rradiobut.setSelected(true);
		rradiobut.addActionListener(new ItemListener());
		// 添加到属性菜单中
		attributeMenu.add(rradiobut);
		
		JRadioButtonMenuItem editadiobut = new JRadioButtonMenuItem("编辑（E）");
		editadiobut.setMnemonic('E');
		editadiobut.setAccelerator(KeyStroke.getKeyStroke("Q"));
		attribtgroup.add(editadiobut);
		editadiobut.addActionListener(new ItemListener());
		// 添加到属性菜单中
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
