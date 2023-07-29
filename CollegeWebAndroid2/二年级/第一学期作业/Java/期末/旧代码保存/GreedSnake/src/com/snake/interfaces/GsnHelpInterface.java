package com.snake.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.snake.config.GsnInterfaceParam;

// �������
public class GsnHelpInterface extends JPanel{
	JPanel centerpanel;
	
	JPanel labeljp[];
	
	JLabel infoLabel1[],infoLabel2[],infoLabel3[],infoLabel4[],infoLabel5[];
	
	Font f;
	
	public GsnHelpInterface(){
		setLayout(null);
		
		centerpanel = new JPanel();
		centerpanel.setOpaque(false);
		centerpanel.setLayout(new GridLayout(5, 1));
		initfont();
		giveSpace();
		addCom();
		
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
		
		infoLabel1 = new JLabel[2];
		infoLabel2 = new JLabel[2];
		infoLabel3 = new JLabel[2];
		infoLabel4 = new JLabel[2];
		infoLabel5 = new JLabel[2];
		
		infoLabel1[0] = new JLabel("��  ��  1��",JLabel.CENTER);	
		infoLabel1[0].setFont(f);
		infoLabel1[1] = new JLabel("W�� S�� A�� D��",JLabel.LEFT);	
		infoLabel1[1].setFont(f);
		
		infoLabel2[0] = new JLabel("��  ��  2��",JLabel.CENTER);	
		infoLabel2[0].setFont(f);
		infoLabel2[1] = new JLabel("���� ���� ���� ����",JLabel.LEFT);	
		infoLabel2[1].setFont(f);
		
		infoLabel3[0] = new JLabel("����ģʽ��",JLabel.CENTER);	
		infoLabel3[0].setFont(f);
		infoLabel3[1] = new JLabel("�����ö�ķֳ�����а�",JLabel.LEFT);	
		infoLabel3[1].setFont(f);
		
		infoLabel4[0] = new JLabel("˫��ģʽ��",JLabel.CENTER);	
		infoLabel4[0].setFont(f);
		infoLabel4[1] = new JLabel("�������Ҿ�������˭���õķ����",JLabel.LEFT);	
		infoLabel4[1].setFont(f);
		
		infoLabel5[0] = new JLabel("����ģʽ��",JLabel.CENTER);	
		infoLabel5[0].setFont(f);
		infoLabel5[1] = new JLabel("�������Ծ�������˭���õķ����",JLabel.LEFT);	
		infoLabel5[1].setFont(f);
	}
	public void addCom(){
		labeljp[0].add(infoLabel1[0]);
		labeljp[0].add(infoLabel1[1]);
		
		labeljp[1].add(infoLabel2[0]);
		labeljp[1].add(infoLabel2[1]);
		
		labeljp[2].add(infoLabel3[0]);
		labeljp[2].add(infoLabel3[1]);
		
		labeljp[3].add(infoLabel4[0]);
		labeljp[3].add(infoLabel4[1]);
		
		labeljp[4].add(infoLabel5[0]);
		labeljp[4].add(infoLabel5[1]);
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
		}
	}
}
