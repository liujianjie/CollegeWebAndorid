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
// 关卡选择以及信息预览界面
public class GsnLevelDisplayInterface extends JPanel{
	// 子控件
	// 滚动条显式关卡
	private JScrollPane jscrollpane;
	private JPanel jpanel;// 存放label
	
	// 采用Jlist
	public ArrayList<Object> gsnleveldisarrlist;// 只是放入一个名称
	public JList<Object> gsnleveldisjlist;
	public GsnEditMapRightOpBarListComBoxModel jlistmodel;
	
	// 预览的 地图界面
//	private GsnCenterInterface previewGameCenterPanel;
	private GsnMainGameJPanel prevewMainGameJpanel;
	
	// 预览的 地图信息 
	private GsnMapInFoBean mapbean;
	private JPanel mapinfoJpanel;
	private JLabel[] mapinfoJLable;
	private JButton enterbt;
	
	public GsnLevelDisplayInterface(){
		setLayout(null);
		// 先设置这个
//		setDrawMapConstant(5, 1);
		
		initview();
		
		initGamepanel();
		
		
		initMapInfoView();
		
		addLis();
		
		this.setBackground(Color.GREEN);
		this.setSize(new Dimension(640, 480));// 640 * 480 固定大小
		
		// 监听事件
		this.addKeyListener(new GsnLevelDisplayKeyLis());
	}
	// 操作jlist----------------------
	// 清空list
	public void clearArrayList(){
		gsnleveldisarrlist.clear();
	}
	// 重新读取添加list
	public void reAddArraylist(){
		// 大小
		for(int i = 0; i < GsnMainGameConstants.gsngamemap.length; i++){
			gsnleveldisarrlist.add((i + 1)+"."+GsnMainGameConstants.gsngamemap[i].gsminfobean.mapname);
		}
	}
	// 操作jlist----------------------
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
		gsnleveldisarrlist = new ArrayList<Object>();
		jlistmodel = new GsnEditMapRightOpBarListComBoxModel(gsnleveldisarrlist);
		gsnleveldisjlist = new JList<Object>(jlistmodel);
		// 设置不可点击 以免失去焦点
		gsnleveldisjlist.setFocusable(false);
		
		reAddArraylist();
		gsnleveldisjlist.setSelectedIndex(0);// 第一个选中
		//关闭横向 开启竖
		jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		// 设置中心
		jpanel.add(gsnleveldisjlist, BorderLayout.CENTER);
		
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
		GsnLevelActionLis gsla = new GsnLevelActionLis();
		enterbt.addActionListener(gsla);
		
		GsnEditMaplevelDisItemClass gsndis = new GsnEditMaplevelDisItemClass();
		gsnleveldisjlist.addListSelectionListener(gsndis);
	}
	
	// 进入
	public void enterGameMap(){
		setDrawMapConstant(10, curlevel);// 先设置好参数
		// 先启动才可 不然报错，因为蛇的位置 面板出来就检测了
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingameJPanel.Preview();// 启动
		// 要先把中心面板跳出来才可
		GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gameLevelJpanel,GsnBottomLayerInterface.gameCenterJpanel);
		// 里面的面板单独提出来设置监听 。因为已经初始化过，在构造方法里获取面版焦点是行不通的
		GsnBottomLayerInterface.gameCenterJpanel.gsnmaingameJPanel.requestFocus();
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
	int chooselevel = -2;
	public void PressNumberDel(){// 因为按下数字键 需要跳转
		if(chooselevel <= GsnMainGameConstants.gsngamemap.length ){
			// 赋予
			curlevel = chooselevel;
			enterGameMap();
		}
	}
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
					// jlist对应选择
					gsnleveldisjlist.setSelectedIndex(curlevel - 1);// 下标永远小一个
					setMapInfoBean();// 地图信息
				}
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				if(curlevel + 1 <= gsnleveldisarrlist.size()){
					setDrawMapConstant(5, curlevel + 1);
					changePreviewMap();
					// jlist对应选择
					gsnleveldisjlist.setSelectedIndex(curlevel - 1);// 下标永远小一个
					setMapInfoBean();// 地图信息
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				enterGameMap();
			}
			// 进入当前关卡
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
				System.out.println("GsnLevelDisplayKeyLis按下VK_ESCAPE键");
			}
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
		
	// 设置jlist的点击
	class GsnEditMaplevelDisItemClass implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			// 给当前关卡数值 
			setDrawMapConstant(5, gsnleveldisjlist.getSelectedIndex() + 1);
			// 预览图跟着更新
			changePreviewMap();
			setMapInfoBean();// 地图信息
		}
		
	}
	// backsetSelectAndView
	public void backSetSelctAndView(int level){
		curlevel = GsnMainGameConstants.currLevel - 1;
		gsnleveldisjlist.setSelectedIndex(GsnMainGameConstants.currLevel - 1);// 下标永远小一个
		changePreviewMap();
	}
}
