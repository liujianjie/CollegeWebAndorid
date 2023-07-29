package com.snake.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.snake.bean.GsnSettingBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.editmap.GsnEditMapRightOpBarListComBoxModel;
import com.snake.iomap.GsnMapReadAndOut;
import com.snake.mgameconfig.GsnMainGameConstants;

// �������
public class GsnSettingInterface extends JPanel{
	JPanel centerpanel;
	
	JPanel labeljp[];
	
	JLabel infoLabel[];
	JComboBox<Object> jcbox[];
	
	Font f;
	
	String voiceitem[] = {"��","��"};
	String gamesizeitem[] = {""};
	String languageitem[] = {"����","Ӣ��"};
	
	// list
	private ArrayList<Integer> comcountlist;
	private GsnEditMapRightOpBarListComBoxModel comcountlistcbm;
	
	JButton jb1,jb2;
	
	GsnMapReadAndOut gsro;
	public GsnSettingInterface(){
		setLayout(null);
		
		gsro = new GsnMapReadAndOut();
		
		centerpanel = new JPanel();
		centerpanel.setOpaque(false);
		centerpanel.setLayout(new GridLayout(5, 1));
		initfont();
		giveSpace();
		setValue();
		
		addListen();
		centerpanel.setBounds((GsnInterfaceParam.INTERFACEWIDTH - 600) / 2, (GsnInterfaceParam.INTERFACEHEIGHT - 400) / 2, 600, 400);
		add(centerpanel);
		this.setBackground(Color.CYAN);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 �̶���С
		
		// �����¼�
		this.addKeyListener(new GsnHelpKeyLis());
	}
	public void initfont(){
		f = new Font("����", 1, 15);
	}
	public void giveSpace(){
		labeljp = new JPanel[5];
		for(int i = 0; i < labeljp.length; i++){
			labeljp[i] = new JPanel();
			labeljp[i].setOpaque(false);
			centerpanel.add(labeljp[i]);
		}
		
		infoLabel = new JLabel[4];
		infoLabel[0] = new JLabel("������",JLabel.CENTER);	
		infoLabel[0].setFont(f);
		
		infoLabel[1] = new JLabel("����������",JLabel.CENTER);	
		infoLabel[0].setFont(f);
		
		infoLabel[2] = new JLabel("��Ϸ����",JLabel.CENTER);	
		infoLabel[0].setFont(f);
		
		infoLabel[3] = new JLabel("���ԣ�",JLabel.CENTER);
		infoLabel[0].setFont(f);
		
		jcbox = new JComboBox[4];
		jcbox[0] = new JComboBox<Object>(voiceitem);
		
		jcbox[2] = new JComboBox<Object>(gamesizeitem);
		
		jcbox[3] = new JComboBox<Object>(languageitem);
		
		comcountlist = new ArrayList<>();
		comcountlistcbm = new GsnEditMapRightOpBarListComBoxModel(comcountlist);
		
		jcbox[1] = new JComboBox<Object>(comcountlistcbm);


		labeljp[0].add(infoLabel[0]);
		labeljp[1].add(infoLabel[1]);
		labeljp[2].add(infoLabel[2]);
		labeljp[3].add(infoLabel[3]);
		labeljp[0].add(jcbox[0]);
		labeljp[1].add(jcbox[1]);
		labeljp[2].add(jcbox[2]);
		labeljp[3].add(jcbox[3]);
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("�ָ�Ĭ��");
		labeljp[4].add(jb1);
		labeljp[4].add(jb2);
	}
	public void addListen(){
		MyactionclickLis m = new MyactionclickLis();
		MyItemLis mi = new MyItemLis();
		jb1.addActionListener(m );
		jb2.addActionListener(m );
		
		for(int i = 0; i < jcbox.length; i++){
			jcbox[i].addItemListener(mi);
		}
	}
	public void setValue(){
		comcountlist.add(1);
		comcountlist.add(2);
		comcountlist.add(3);
	}
	// ����ѡ��
	public void setComcountBoxSel(){
		jcbox[1].setSelectedIndex(GsnMainGameConstants.snakecomputercount - 1);// Ҫ��1
		jcbox[1].updateUI();
	}
	class MyactionclickLis implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == jb1){
				GsnSettingBean gs = new GsnSettingBean();
				gs.computercount = (Integer)jcbox[1].getSelectedItem();
				gsro.outSetting(gs);
				//�ٶ�ȡ����
				gsro.readSetting();
			}else if(e.getSource() == jb2){
				jcbox[1].setSelectedIndex(0);
			}

			GsnSettingInterface.this.requestFocus();
		}
	}
	class MyItemLis implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			GsnSettingInterface.this.requestFocus();
		}
	}
	// ���̼��� 
	class GsnHelpKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_1){
				System.out.println("GsnHelpKeyLis����1��");
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnHelpKeyLis����VK_ESCAPE��");
			}
			GsnSettingInterface.this.requestFocus();
		}
	}
}
