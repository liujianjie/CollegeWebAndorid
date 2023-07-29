package com.snake.interfaces;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.snake.config.GsnInterfaceParam;
import com.snake.editmap.GsnEditMapLevelDisplayInterface;
import com.snake.editmap.GsnEditmapInterface;
import com.snake.iomap.GsnMapReadAndOut;

// ��ײ����
public class GsnBottomLayerInterface extends JFrame{
	// ��¼��������˳��
	public static Stack<JPanel> orderjpanel;
	
	// ȫ�������
	public static JPanel gameMainmenuJpanel;
	public static GsnLevelDisplayInterface gameLevelJpanel;
	public static GsnCenterInterface gameCenterJpanel;
	public static JPanel gameDevelperIntroJpanel,gameHelpJpanel;
	public static GsnRankInterface gameRankJpanel;
	public static GsnResultAndScoreInterface gameResultAndScoreJpanel;
	public static GsnEditMapLevelDisplayInterface gsneditmapleveldisplayJpanel;
	public static GsnEditmapInterface gameEditMapJpanel;
	// �������
	public static Container con;
	
    // һ��ʼ��Ҫ��ȡ��ͼ����
	public GsnMapReadAndOut gm;
    
	public GsnBottomLayerInterface(){
		super("");
		this.setUndecorated(true);// �ޱ߿�
		
		// ��ʼ������
		stratProduceOfSize();
		stratProduceOfJPanel();
		stratProduceOfJPanelOp();
		stratProduceOfData();
		// ȫ��
		setSize(GsnInterfaceParam.allwidth,GsnInterfaceParam.allheight);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new GsnBottomLayerInterface();
	}
	
	// ��ʼ������ start----------------------------
	protected void stratProduceOfSize(){// ��Ļ��С
		// 1.��ȡ��ǰ��Ļ�ֱ���
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Dimension scrnsize = toolkit.getScreenSize();
	    GsnInterfaceParam.allwidth = (int)scrnsize.getWidth();
	    GsnInterfaceParam.allheight = (int)scrnsize.getHeight();
	    
	    // 2.��ʼ����ȡ�ļ���Ϊ��ͼ
	    gm = new GsnMapReadAndOut();
	    gm.readMapText();
	    gm.changeMap();// ��ͼ
	    
	    gm.readRank();// ���а�
	    
	    // ��Ϸ���á�����
	}
	protected void stratProduceOfJPanel(){// ��ʼ�����
		con = getContentPane();
		con.setLayout(null);
		gameMainmenuJpanel = new GsnMainMenuInterface();// ��ʼ���
		// �������
		gameCenterJpanel = new GsnCenterInterface();// Ҫ��GsnLevelDisplayInterface֮ǰʵ��������Ϊ��Ϸ����ʼ���ߵ�ʱ�����÷������ʹ�ã���ʱû��new ��null
		gameLevelJpanel = new GsnLevelDisplayInterface();
		
		gameDevelperIntroJpanel = new GsnDeveloperIntroduceInterface();
		gameEditMapJpanel = new GsnEditmapInterface(1);
		gameHelpJpanel = new GsnHelpInterface();
		gameResultAndScoreJpanel = new GsnResultAndScoreInterface();
		gameRankJpanel = new GsnRankInterface();
		gsneditmapleveldisplayJpanel = new GsnEditMapLevelDisplayInterface();
		
		// Ҫ��λ������
		gameMainmenuJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
		gameLevelJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
		gameCenterJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);

		gameResultAndScoreJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
		gameRankJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
		
		gameDevelperIntroJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
		gameEditMapJpanel.setBounds((GsnInterfaceParam.allwidth - gameEditMapJpanel.getWidth()) / 2,(GsnInterfaceParam.allheight - gameEditMapJpanel.getHeight()) / 2,gameEditMapJpanel.getWidth(), gameEditMapJpanel.getHeight());
		gameHelpJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
		gameResultAndScoreJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
		gameRankJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
		gsneditmapleveldisplayJpanel.setBounds((GsnInterfaceParam.allwidth - GsnInterfaceParam.INTERFACEWIDTH) / 2,(GsnInterfaceParam.allheight - GsnInterfaceParam.INTERFACEHEIGHT) / 2,GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT);
	}
	protected void stratProduceOfJPanelOp(){// ������
		con.add(gameMainmenuJpanel);
		con.add(gameLevelJpanel);
		con.add(gameCenterJpanel);
		con.add(gameDevelperIntroJpanel);
		con.add(gameEditMapJpanel);
		con.add(gameHelpJpanel);
		con.add(gameResultAndScoreJpanel);
		con.add(gameRankJpanel);
		con.add(gsneditmapleveldisplayJpanel);
		
		//����ɫ
		con.setBackground(Color.BLACK);
		gameRankJpanel.setVisible(false);
		gameResultAndScoreJpanel.setVisible(false);
		gameDevelperIntroJpanel.setVisible(false);
		gameEditMapJpanel.setVisible(false);
		gameHelpJpanel.setVisible(false);
		gameLevelJpanel.setVisible(false);
		gameCenterJpanel.setVisible(false);
		gsneditmapleveldisplayJpanel.setVisible(false);
		gameMainmenuJpanel.setVisible(true);
		
		// ��Ҫ�������ӽ���ſ� ʵ�ְ�ť����
		gameMainmenuJpanel.setFocusable(true); //
		gameMainmenuJpanel.requestFocus();
	}
	protected void stratProduceOfData(){// ���ݲ���
		orderjpanel = new Stack<JPanel>();
		// ��ʼ��Ϊ������
		orderjpanel.push(gameMainmenuJpanel);
	}
	// ��ʼ������end----------------------------
	
	// �������
	public static void updateJPanel(JPanel jp1, JPanel jp2){// staticΪ�����������ֱ�ӵ���
		jp1.setVisible(false);
		jp2.setVisible(true);
		con.update(jp2.getGraphics());
		jp2.requestFocus();
		orderjpanel.add(jp2);// ��ӵ�stack��ջ
	}
	// �����浽stack�У����ҳ�ջ center��Ϸ���
	public static void updateJPanelNotSave(JPanel jp1, JPanel jp2){// staticΪ�����������ֱ�ӵ��� 
		jp1.setVisible(false);
		jp2.setVisible(true);
		con.update(jp2.getGraphics());
		jp2.requestFocus();
		orderjpanel.clear();// ���
		orderjpanel.add(gameMainmenuJpanel);// ���levelѡ��
		orderjpanel.add(jp2);
	}
	// ��ǰջ������
	public static void updateJPanelNotSaveCur(JPanel jp1, JPanel jp2){// staticΪ�����������ֱ�ӵ��� 
		jp1.setVisible(false);
		jp2.setVisible(true);
		con.update(jp2.getGraphics());
		jp2.requestFocus();
		orderjpanel.clear();// ���
		orderjpanel.add(gameMainmenuJpanel);// ���levelѡ��
		orderjpanel.add(jp2);
	}
	// �ص���һ�����
	public static void backLastJPanel(){
		orderjpanel.pop().setVisible(false);//  ��ϵ���ʧ
		orderjpanel.peek().setVisible(true);// ��ǰ�������ʽ
		orderjpanel.peek().requestFocus();// ���ҵõ�����
	}
}
