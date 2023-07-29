package com.snake.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.snake.config.GsnInterfaceParam;
import com.snake.mgameconfig.GsnMainGameConstants;

// ������˵�
public class GsnMainMenuInterface extends JPanel{
	
	protected JLabel jlarr[] ;
	public GsnMainMenuInterface(){
		setLayout(null);
		jlarr = new JLabel[8];// ��Ҫ8��
		jlarr[0] = new JLabel("",JLabel.CENTER);// ��һ��Ҫ���м�
		jlarr[0].setBounds(200, 30, 240, 50);// ����
		add(jlarr[0]);
		for(int i = 1; i < jlarr.length; i++){
			jlarr[i] = new JLabel("",JLabel.LEFT);
			jlarr[i].setBounds(200, (50 * i) + 30, 240, 50);// ����
			add(jlarr[i]);
		}
		jlarr[0].setText("GREED SNAKE");
		jlarr[1].setText("1.SINGLE MODE");
		jlarr[2].setText("2.DOUBLE MODE");
		jlarr[3].setText("3.VS  CS MODE");
		jlarr[4].setText("4.EDIT   MAP");
		jlarr[5].setText("5.SCORE  RANK");
		jlarr[6].setText("6.GAME HELP");
		jlarr[7].setText("7.DEVELPOER INTRODUCE");
		this.setBackground(Color.WHITE);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 �̶���С
		// �����¼�
		this.addKeyListener(new GsnMainMenuKeyLis());
	}
	// ���̼��� ѡ��˵���
	class GsnMainMenuKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_1){
				GsnMainGameConstants.setDrawSize(5);
				GsnMainGameConstants.gamemode = 1;
				GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameMainmenuJpanel,GsnBottomLayerInterface.gameLevelJpanel);
				System.out.println("GsnMainMenuKeyLis����1��");
			}else if(e.getKeyCode() == KeyEvent.VK_2){
				GsnMainGameConstants.setDrawSize(5);
				GsnMainGameConstants.gamemode = 2;
				GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameMainmenuJpanel,GsnBottomLayerInterface.gameLevelJpanel);
				System.out.println("GsnMainMenuKeyLis����2��");
			}else if(e.getKeyCode() == KeyEvent.VK_3){
				GsnMainGameConstants.setDrawSize(5);
				GsnMainGameConstants.gamemode = 3;
				GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameMainmenuJpanel,GsnBottomLayerInterface.gameLevelJpanel);
				System.out.println("GsnMainMenuKeyLis����3��");
			}else if(e.getKeyCode() == KeyEvent.VK_4){
				// ģʽΪ2
				GsnMainGameConstants.gamemode = 2;
				GsnMainGameConstants.setDrawSize(5);
				GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameMainmenuJpanel,GsnBottomLayerInterface.gsneditmapleveldisplayJpanel);
				System.out.println("GsnMainMenuKeyLis����4��");
			}else if(e.getKeyCode() == KeyEvent.VK_5){
				GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameMainmenuJpanel,GsnBottomLayerInterface.gameRankJpanel);
				System.out.println("GsnMainMenuKeyLis����5��");
			}else if(e.getKeyCode() == KeyEvent.VK_6){
				GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameMainmenuJpanel,GsnBottomLayerInterface.gameHelpJpanel);
				System.out.println("GsnMainMenuKeyLis����6��");
			}else if(e.getKeyCode() == KeyEvent.VK_7){
				GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameMainmenuJpanel,GsnBottomLayerInterface.gameDevelperIntroJpanel);
				System.out.println("GsnMainMenuKeyLis����7��");
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				// ȷ���˳���
				int chos = JOptionPane.showConfirmDialog(GsnMainMenuInterface.this, "ȷ���˳���");
				if(chos == 0){
					System.exit(0);
					System.out.println("�˳�");
				}
				System.out.println("GsnMainMenuKeyLis����VK_ESCAPE��");
			}
		}
	}
	
}

//GsnMainMenuInterface.this.setVisible(false);
//GsnDeveloperIntroduceInterface gpan = new GsnDeveloperIntroduceInterface();
//gpan.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
//GsnBottomLayerInterface.con.add(gpan);
//
//GsnBottomLayerInterface.con.update(getGraphics());
//gpan.requestFocus();