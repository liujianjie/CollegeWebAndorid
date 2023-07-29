package com.snake.interfaces;

import java.awt.BorderLayout;
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
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapInFoBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.editmap.GsnEditMapRightOpBarListComBoxModel;
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
	
	// ����Jlist
	public ArrayList<Object> gsnleveldisarrlist;// ֻ�Ƿ���һ������
	public JList<Object> gsnleveldisjlist;
	public GsnEditMapRightOpBarListComBoxModel jlistmodel;
	
	// Ԥ���� ��ͼ����
//	private GsnCenterInterface previewGameCenterPanel;
	private GsnMainGameJPanel prevewMainGameJpanel;
	
	// Ԥ���� ��ͼ��Ϣ 
	private GsnMapInFoBean mapbean;
	private JPanel mapinfoJpanel;
	private JLabel[] mapinfoJLable;
	private JButton enterbt;
	
	public GsnLevelDisplayInterface(){
		setLayout(null);
		// ���������
//		setDrawMapConstant(5, 1);
		
		initview();
		
		initGamepanel();
		
		
		initMapInfoView();
		
		addLis();
		
		this.setBackground(Color.GREEN);
		this.setSize(new Dimension(640, 480));// 640 * 480 �̶���С
		
		// �����¼�
		this.addKeyListener(new GsnLevelDisplayKeyLis());
	}
	// ����jlist----------------------
	// ���list
	public void clearArrayList(){
		gsnleveldisarrlist.clear();
	}
	// ���¶�ȡ���list
	public void reAddArraylist(){
		// ��С
		for(int i = 0; i < GsnMainGameConstants.gsngamemap.length; i++){
			gsnleveldisarrlist.add((i + 1)+"."+GsnMainGameConstants.gsngamemap[i].gsminfobean.mapname);
		}
	}
	// ����jlist----------------------
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
		gsnleveldisarrlist = new ArrayList<Object>();
		jlistmodel = new GsnEditMapRightOpBarListComBoxModel(gsnleveldisarrlist);
		gsnleveldisjlist = new JList<Object>(jlistmodel);
		// ���ò��ɵ�� ����ʧȥ����
		gsnleveldisjlist.setFocusable(false);
		
		reAddArraylist();
		gsnleveldisjlist.setSelectedIndex(0);// ��һ��ѡ��
		//�رպ��� ������
		jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		// ��������
		jpanel.add(gsnleveldisjlist, BorderLayout.CENTER);
		
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
		GsnLevelActionLis gsla = new GsnLevelActionLis();
		enterbt.addActionListener(gsla);
		
		GsnEditMaplevelDisItemClass gsndis = new GsnEditMaplevelDisItemClass();
		gsnleveldisjlist.addListSelectionListener(gsndis);
	}
	
	// ����
	public void enterGameMap(){
		setDrawMapConstant(10, curlevel);// �����úò���
		// �������ſ� ��Ȼ������Ϊ�ߵ�λ�� �������ͼ����
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingameJPanel.Preview();// ����
		// Ҫ�Ȱ���������������ſ�
		GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameLevelJpanel,GsnBottomLayerInterface.gameCenterJpanel);
		// �������嵥����������ü��� ����Ϊ�Ѿ���ʼ�������ڹ��췽�����ȡ��潹�����в�ͨ��
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingameJPanel.requestFocus();
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
	int chooselevel = -2;
	public void PressNumberDel(){// ��Ϊ�������ּ� ��Ҫ��ת
		if(chooselevel <= GsnMainGameConstants.gsngamemap.length ){
			// ����
			curlevel = chooselevel;
			enterGameMap();
		}
	}
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
					// jlist��Ӧѡ��
					gsnleveldisjlist.setSelectedIndex(curlevel - 1);// �±���ԶСһ��
					setMapInfoBean();// ��ͼ��Ϣ
				}
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				if(curlevel + 1 <= gsnleveldisarrlist.size()){
					setDrawMapConstant(5, curlevel + 1);
					changePreviewMap();
					// jlist��Ӧѡ��
					gsnleveldisjlist.setSelectedIndex(curlevel - 1);// �±���ԶСһ��
					setMapInfoBean();// ��ͼ��Ϣ
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				enterGameMap();
			}
			// ���뵱ǰ�ؿ�
			switch (e.getKeyCode()) {
				case KeyEvent.VK_1:
					chooselevel = 1;
					PressNumberDel();
					break;
				case KeyEvent.VK_2:
					chooselevel = 2;
					PressNumberDel();
					break;
				case KeyEvent.VK_3:
					chooselevel = 3;
					PressNumberDel();
					break;
				case KeyEvent.VK_4:
					chooselevel = 4;
					PressNumberDel();
					break;
				case KeyEvent.VK_5:
					chooselevel = 5;
					PressNumberDel();
					break;
				case KeyEvent.VK_6:
					chooselevel = 6;
					PressNumberDel();
					break;
				case KeyEvent.VK_7:
					chooselevel = 7;
					PressNumberDel();
					break;
				case KeyEvent.VK_8:
					chooselevel = 8;
					PressNumberDel();
					break;		
				case KeyEvent.VK_9:
					chooselevel = 9;
					PressNumberDel();
					break;					
			default:
				break;
			}
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnLevelDisplayKeyLis����VK_ESCAPE��");
			}
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
		
	// ����jlist�ĵ��
	class GsnEditMaplevelDisItemClass implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			// ����ǰ�ؿ���ֵ 
			setDrawMapConstant(5, gsnleveldisjlist.getSelectedIndex() + 1);
			// Ԥ��ͼ���Ÿ���
			changePreviewMap();
			setMapInfoBean();// ��ͼ��Ϣ
		}
		
	}
	// backsetSelectAndView
	public void backSetSelctAndView(int level){
		curlevel = GsnMainGameConstants.currLevel - 1;
		gsnleveldisjlist.setSelectedIndex(GsnMainGameConstants.currLevel - 1);// �±���ԶСһ��
		changePreviewMap();
	}
}
