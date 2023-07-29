package com.snake.interfaces;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapInFoBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.mgame.GsnMainGameJPanel;
import com.snake.mgame.GsnMainGameScoreJPanel;
import com.snake.mgameconfig.GsnMainGameConstants;

import sun.net.www.content.image.jpeg;
// �ؿ�ѡ���Լ���ϢԤ������
public class GsnLevelDisplayInterface extends JPanel{
	// �ӿؼ�
	// ��������ʽ�ؿ�
	private JScrollPane jscrollpane;
	private JPanel jpanel;// ���label
	
	// label����
	private JLabel[] jlarr;
	private JPanel[] jpanelarr;
	
	// Ԥ���� ��ͼ����
//	private GsnCenterInterface previewGameCenterPanel;
	private GsnMainGameJPanel prevewMainGameJpanel;
	
	// Ԥ���� ��ͼ��Ϣ 
	private GsnMapInFoBean mapbean;
	private JPanel mapinfoJpanel;
	private JLabel[] mapinfoJLable;
	private JButton enterbt;
	// �ռ�
	public void giveJLabelSpace(){
		jlarr = new JLabel[GsnMainGameConstants.gsngamemap.length];
		jpanelarr = new JPanel[GsnMainGameConstants.gsngamemap.length];
	}
	public void giveJLabelValue(){
		for(int i = 0; i < jlarr.length; i++){
			jpanelarr[i] = new JPanel();
			jlarr[i] = new JLabel();// ��ͼ����
//			jpanelarr[i].setSize(150, 40);
//			jpanelarr[i].setBounds(0, 0, 150, 40);
//			jpanelarr[i].setBackground(Color.CYAN);
//			jpanelarr[i].setLayout(new FlowLayout());
//			jpanelarr[i].add(jlarr[i]);
//			jpanel.add(jpanelarr[i]);
			jlarr[i].setPreferredSize(new Dimension(200, 30));
			jlarr[i].setText((i + 1)+"."+GsnMainGameConstants.gsngamemap[i].gsminfobean.mapname);
			jlarr[i].setOpaque(true); 
			jpanel.add(jlarr[i]);
		}
	}
	// ���û滭��ͼ����ֵ
	public void setDrawMapConstant(int size, int level){
		curlevel = level;
		// ����ͼ�λ滭��С
		GsnMainGameConstants.setDrawSize(size);
		GsnMainGameConstants.currLevel = level;
	}
	public void initGamepanel(){
		prevewMainGameJpanel = new GsnMainGameJPanel();
		prevewMainGameJpanel.setnewSize(GsnInterfaceParam.GAMEPRIVEWIDTH,GsnInterfaceParam.GAMEPRIVEHEIGHT);
		prevewMainGameJpanel.setBounds(290, 50, GsnInterfaceParam.GAMEPRIVEWIDTH, GsnInterfaceParam.GAMEPRIVEHEIGHT);
		
		// Ԥ��
		prevewMainGameJpanel.Preview();
		add(prevewMainGameJpanel);
	}
	// �ؿ�ѡ��
	public void initview(){
		//�رպ��� ������
		jpanel = new JPanel();
		jpanel.setSize(new Dimension(220, 410));
//		jpanel.setPreferredSize(new Dimension(220, 30));
		// ����Ϊ�ؿ����ȵ���
//		jpanel.setLayout(new GridLayout(GsnMainGameConstants.gsngamemap.length, 1));
		BoxLayout boxla =  new BoxLayout(jpanel, BoxLayout.Y_AXIS);
		jpanel.setLayout(boxla);
		
		// Ҫ��jpanel����������С�������viewpoint
		jscrollpane = new JScrollPane(jpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollpane.setPreferredSize(new Dimension(220, 410));
		
		jscrollpane.setBounds(50, 50, 220, 410);
		// ��ӵ����
		add(jscrollpane);
	}
	// ��ͼ��Ϣ
	public void setMapInfoBean(){// ���õ�ǰѡ��ؿ��ĵ�ͼbean
		mapbean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsminfobean;
		mapinfoJLable[0].setText("��ͼ���ߣ�"+mapbean.authorname);
		mapinfoJLable[1].setText("��ͼ���ƣ�"+mapbean.mapname);
		mapinfoJLable[2].setText("����ʱ�䣺"+mapbean.creationtime);
		mapinfoJLable[3].setText("��ͼ��Ҫ��"+mapbean.tips);
	}
	public void setEnterButtonSt(String st){
		enterbt.setText(st);
	}
	public void initMapInfoView(){
		mapbean = new GsnMapInFoBean();
		
		mapinfoJpanel = new JPanel();
		mapinfoJpanel.setLayout(new GridLayout(5, 1));
		mapinfoJLable = new JLabel[4];
		for(int i = 0; i < mapinfoJLable.length; i++){
			mapinfoJLable[i] = new JLabel();
			mapinfoJpanel.add(mapinfoJLable[i]);
		}
		setMapInfoBean();
		
		enterbt = new JButton();
		setEnterButtonSt("��ʼ��Ϸ");
		mapinfoJpanel.add(enterbt);
		
		this.add(mapinfoJpanel);
		mapinfoJpanel.setBounds(290, 275, GsnInterfaceParam.GAMEMAPINFOWIDTH, GsnInterfaceParam.GAMEMAPINFOHEIGHT);
	}
	// ��Ӽ���
	public void addLis(){
//		GsnLevelMouseLis gsms = new GsnLevelMouseLis();
		GsnLevelActionLis gsla = new GsnLevelActionLis();
//		for(int i = 0; i < jlarr.length; i++){
//			jlarr[i].addMouseListener(gsms);
//		}
		enterbt.addActionListener(gsla);
	}
	public GsnLevelDisplayInterface(){
		setLayout(null);
		// ���������
//		setDrawMapConstant(5, 1);
		
		initview();
		
		initGamepanel();
		
		giveJLabelSpace();
		
		giveJLabelValue();
		
		initMapInfoView();
		
		setJLabelBkColor();
		
		addLis();
		
		this.setBackground(Color.GREEN);
		this.setSize(new Dimension(640, 480));// 640 * 480 �̶���С
		
		// �����¼�
		this.addKeyListener(new GsnLevelDisplayKeyLis());
	}
	// ��Jabel���ñ�����ɫ ���ݵ�ǰѡ��Ĺؿ�
	public void setJLabelBkColor(){
		for(int i = 0; i < jlarr.length; i++){
			jlarr[i].setBackground(null);
		}
		// ��ǰ�ؿ���ɫ�� ����û��
		jlarr[GsnMainGameConstants.currLevel - 1].setBackground(Color.ORANGE);
	}
	// ��jlabel��� ��ť����
	class GsnLevelMouseLis extends MouseAdapter{
		Object obj;
		@Override
		public void mouseClicked(MouseEvent e) {
			obj = e.getSource();
			
		}
	}
	// ��  ��Jbutton���ü���
	class GsnLevelActionLis implements ActionListener{
		Object obj;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			obj = e.getSource();
			if(obj == enterbt)
			{
				enterGameMap();
			}
		}
	}
	
	// ����
	public void enterGameMap(){
		setDrawMapConstant(10, curlevel);// �����úò���
		// Ҫ�Ȱ���������������ſ�
		GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameLevelJpanel,GsnBottomLayerInterface.gameCenterJpanel);
		// �������嵥����������ü��� ����Ϊ�Ѿ���ʼ�������ڹ��췽�����ȡ��潹�����в�ͨ��
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingameJPanel.requestFocus();
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingameJPanel.Preview();// ����
	}
	// ��������Ĺؿ�ͼƬ
	public void changePreviewMap(){
		// ������ͼ֮ǰ��Ҫ�ȹ�֮ǰ�� �� �ϰ��� ʳ����߳�
		prevewMainGameJpanel.endThread();
		// �滭�ؿ�
		prevewMainGameJpanel.Preview();
		prevewMainGameJpanel.repaint();
	}
	// ��ǰ����Ĺؿ�
	int curlevel = 1;// Ĭ��Ϊ1
	// ���̼��� ѡ��˵���
	class GsnLevelDisplayKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			// ����ؿ�
			if(e.getKeyCode() == KeyEvent.VK_UP){
				// ���ùؿ� ���С�� 0 ������
				if(curlevel - 1 > 0){
					setDrawMapConstant(5, curlevel - 1);
					changePreviewMap();// ������ʽ�ĵ�ͼ
					setJLabelBkColor();// �ؿ���ǩ������ɫ
					setMapInfoBean();// ��ͼ��Ϣ
				}
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				if(curlevel + 1 <= jlarr.length){
					setDrawMapConstant(5, curlevel + 1);
					changePreviewMap();
					setJLabelBkColor();
					setMapInfoBean();// ��ͼ��Ϣ
				}
			}
			// ���뵱ǰ�ؿ�
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				enterGameMap();
			}
			if(e.getKeyCode() == KeyEvent.VK_1){
				System.out.println("GsnLevelDisplayKeyLis����1��");
				// ���ùؿ�
				curlevel = 1;
				// ����ؿ�
				enterGameMap();
			}else if(e.getKeyCode() == KeyEvent.VK_2){
				System.out.println("GsnLevelDisplayKeyLis����1��");
				// ���ùؿ�
				curlevel = 2;
				enterGameMap();// �����úò���
			}else if(e.getKeyCode() == KeyEvent.VK_3){
				System.out.println("GsnLevelDisplayKeyLis����1��");
				// ���ùؿ�
				curlevel = 3;
				// ����ؿ�
				enterGameMap();
			}else if(e.getKeyCode() == KeyEvent.VK_4){
				System.out.println("GsnLevelDisplayKeyLis����1��");
				// ���ùؿ�
				curlevel = 4;
				// ����ؿ�
				enterGameMap();
			}else if(e.getKeyCode() == KeyEvent.VK_5){
				System.out.println("GsnLevelDisplayKeyLis����1��");
				// ���ùؿ�
				curlevel = 5;
				// ����ؿ�
				enterGameMap();
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnLevelDisplayKeyLis����VK_ESCAPE��");
			}
		}
	}
}
