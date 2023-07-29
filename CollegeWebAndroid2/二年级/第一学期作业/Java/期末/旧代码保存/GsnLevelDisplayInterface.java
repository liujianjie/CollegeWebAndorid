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
// 关卡选择以及信息预览界面
public class GsnLevelDisplayInterface extends JPanel{
	// 子控件
	// 滚动条显式关卡
	private JScrollPane jscrollpane;
	private JPanel jpanel;// 存放label
	
	// label数量
	private JLabel[] jlarr;
	private JPanel[] jpanelarr;
	
	// 预览的 地图界面
//	private GsnCenterInterface previewGameCenterPanel;
	private GsnMainGameJPanel prevewMainGameJpanel;
	
	// 预览的 地图信息 
	private GsnMapInFoBean mapbean;
	private JPanel mapinfoJpanel;
	private JLabel[] mapinfoJLable;
	private JButton enterbt;
	// 空间
	public void giveJLabelSpace(){
		jlarr = new JLabel[GsnMainGameConstants.gsngamemap.length];
		jpanelarr = new JPanel[GsnMainGameConstants.gsngamemap.length];
	}
	public void giveJLabelValue(){
		for(int i = 0; i < jlarr.length; i++){
			jpanelarr[i] = new JPanel();
			jlarr[i] = new JLabel();// 地图名称
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
	// 设置绘画地图常量值
	public void setDrawMapConstant(int size, int level){
		curlevel = level;
		// 设置图形绘画大小
		GsnMainGameConstants.setDrawSize(size);
		GsnMainGameConstants.currLevel = level;
	}
	public void initGamepanel(){
		prevewMainGameJpanel = new GsnMainGameJPanel();
		prevewMainGameJpanel.setnewSize(GsnInterfaceParam.GAMEPRIVEWIDTH,GsnInterfaceParam.GAMEPRIVEHEIGHT);
		prevewMainGameJpanel.setBounds(290, 50, GsnInterfaceParam.GAMEPRIVEWIDTH, GsnInterfaceParam.GAMEPRIVEHEIGHT);
		
		// 预览
		prevewMainGameJpanel.Preview();
		add(prevewMainGameJpanel);
	}
	// 关卡选项
	public void initview(){
		//关闭横向 开启竖
		jpanel = new JPanel();
		jpanel.setSize(new Dimension(220, 410));
//		jpanel.setPreferredSize(new Dimension(220, 30));
		// 设置为关卡长度的行
//		jpanel.setLayout(new GridLayout(GsnMainGameConstants.gsngamemap.length, 1));
		BoxLayout boxla =  new BoxLayout(jpanel, BoxLayout.Y_AXIS);
		jpanel.setLayout(boxla);
		
		// 要把jpanel放入参数才行。。或者viewpoint
		jscrollpane = new JScrollPane(jpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollpane.setPreferredSize(new Dimension(220, 410));
		
		jscrollpane.setBounds(50, 50, 220, 410);
		// 添加到面板
		add(jscrollpane);
	}
	// 地图信息
	public void setMapInfoBean(){// 设置当前选择关卡的地图bean
		mapbean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsminfobean;
		mapinfoJLable[0].setText("地图作者："+mapbean.authorname);
		mapinfoJLable[1].setText("地图名称："+mapbean.mapname);
		mapinfoJLable[2].setText("创作时间："+mapbean.creationtime);
		mapinfoJLable[3].setText("地图概要："+mapbean.tips);
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
		setEnterButtonSt("开始游戏");
		mapinfoJpanel.add(enterbt);
		
		this.add(mapinfoJpanel);
		mapinfoJpanel.setBounds(290, 275, GsnInterfaceParam.GAMEMAPINFOWIDTH, GsnInterfaceParam.GAMEMAPINFOHEIGHT);
	}
	// 添加监听
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
		// 先设置这个
//		setDrawMapConstant(5, 1);
		
		initview();
		
		initGamepanel();
		
		giveJLabelSpace();
		
		giveJLabelValue();
		
		initMapInfoView();
		
		setJLabelBkColor();
		
		addLis();
		
		this.setBackground(Color.GREEN);
		this.setSize(new Dimension(640, 480));// 640 * 480 固定大小
		
		// 监听事件
		this.addKeyListener(new GsnLevelDisplayKeyLis());
	}
	// 给Jabel设置背景颜色 根据当前选择的关卡
	public void setJLabelBkColor(){
		for(int i = 0; i < jlarr.length; i++){
			jlarr[i].setBackground(null);
		}
		// 当前关卡颜色有 其它没有
		jlarr[GsnMainGameConstants.currLevel - 1].setBackground(Color.ORANGE);
	}
	// 给jlabel添加 按钮监听
	class GsnLevelMouseLis extends MouseAdapter{
		Object obj;
		@Override
		public void mouseClicked(MouseEvent e) {
			obj = e.getSource();
			
		}
	}
	// 。  给Jbutton设置监听
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
	
	// 进入
	public void enterGameMap(){
		setDrawMapConstant(10, curlevel);// 先设置好参数
		// 要先把中心面板跳出来才可
		GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameLevelJpanel,GsnBottomLayerInterface.gameCenterJpanel);
		// 里面的面板单独提出来设置监听 。因为已经初始化过，在构造方法里获取面版焦点是行不通的
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingameJPanel.requestFocus();
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingameJPanel.Preview();// 启动
	}
	// 更新浏览的关卡图片
	public void changePreviewMap(){
		// 更换地图之前需要先关之前的 蛇 障碍物 食物的线程
		prevewMainGameJpanel.endThread();
		// 绘画关卡
		prevewMainGameJpanel.Preview();
		prevewMainGameJpanel.repaint();
	}
	// 当前浏览的关卡
	int curlevel = 1;// 默认为1
	// 键盘监听 选择菜单项
	class GsnLevelDisplayKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			// 浏览关卡
			if(e.getKeyCode() == KeyEvent.VK_UP){
				// 设置关卡 如果小于 0 就设置
				if(curlevel - 1 > 0){
					setDrawMapConstant(5, curlevel - 1);
					changePreviewMap();// 更换显式的地图
					setJLabelBkColor();// 关卡标签背景颜色
					setMapInfoBean();// 地图信息
				}
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				if(curlevel + 1 <= jlarr.length){
					setDrawMapConstant(5, curlevel + 1);
					changePreviewMap();
					setJLabelBkColor();
					setMapInfoBean();// 地图信息
				}
			}
			// 进入当前关卡
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				enterGameMap();
			}
			if(e.getKeyCode() == KeyEvent.VK_1){
				System.out.println("GsnLevelDisplayKeyLis按下1键");
				// 设置关卡
				curlevel = 1;
				// 进入关卡
				enterGameMap();
			}else if(e.getKeyCode() == KeyEvent.VK_2){
				System.out.println("GsnLevelDisplayKeyLis按下1键");
				// 设置关卡
				curlevel = 2;
				enterGameMap();// 先设置好参数
			}else if(e.getKeyCode() == KeyEvent.VK_3){
				System.out.println("GsnLevelDisplayKeyLis按下1键");
				// 设置关卡
				curlevel = 3;
				// 进入关卡
				enterGameMap();
			}else if(e.getKeyCode() == KeyEvent.VK_4){
				System.out.println("GsnLevelDisplayKeyLis按下1键");
				// 设置关卡
				curlevel = 4;
				// 进入关卡
				enterGameMap();
			}else if(e.getKeyCode() == KeyEvent.VK_5){
				System.out.println("GsnLevelDisplayKeyLis按下1键");
				// 设置关卡
				curlevel = 5;
				// 进入关卡
				enterGameMap();
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnLevelDisplayKeyLis按下VK_ESCAPE键");
			}
		}
	}
}
