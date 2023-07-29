package com.snake.editmap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.snake.bean.GsnMapBarrierMoveBean;
import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapCrossNodeBean;
import com.snake.bean.GsnMapFoodBean;
import com.snake.bean.GsnMapInFoBean;
import com.snake.bean.GsnMapSnakeBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.config.GsnTestIsNumClass;
import com.snake.interfaces.GsnBottomLayerInterface;
import com.snake.mgame.GsnCrossNodeDraw;
import com.snake.mgame.GsnFood;
import com.snake.mgame.GsnMainGameMoveBarrier;
import com.snake.mgameconfig.GsnMainGameConstants;

// 编辑地图右边操作面板
public class GsnEditMapRightOperationJPanel extends JPanel{
	GsnEditmapInterface gsneminter;
	
	public JTabbedPane jtbpane;
	// 各个子面板
	private JPanel basicoppanel,snakeoppanel,mapinfopanel,barrierpanel,crossnodepanel;
	// 子控件
	// 基本操作的
	private int jbsize = 11;// 控件大小
	private JButton[] jbarr;
	
	// 障碍物的
	private int barjbsize = 3;
	private JButton[] barjbarr;
	private JButton baraddyesbt, baralterbt, bardelbt, barrunbt, barpausebt;
	// label和输入
	private JLabel barcurchooselb,barbarijlb,barhwlb,barwidelb,bardirlb,barspeedlb;
	private JTextField barbaritext,barbarjtext,barhtext,barwtext,barwidetext,barspeedtext;
	String bardirst[] = {"上","下", "左", "右"};
	private JComboBox<Object> bardirjcbox;
	// 选择的下拉列表 
	public JComboBox<Object> barjcbox;
	// 编号
	private ArrayList<String> barlist;
	private GsnEditMapRightOpBarListComBoxModel gsneditmapbarlistcbm;
	
	private int bardir = 0;// 方向从jcombobox获取 默认为下0
	
	// 蛇的子控件
	String snakedirst[] = {"上","下", "左", "右"};
	String snakeplayerst[] = {"玩家1", "玩家2"};
	private JComboBox<Object> snakebox;
	private JComboBox<Object> snakedirbox;
	private JLabel snakecurchooselb, snakenodelb,snakeheadlb,snakedirlb;
	private JTextField snakenodetxt,snakeheaditext,snakeheadjtext;
	private JButton snakealterbt;
	
	// 地图信息面板子控件 和食物的bean一起吧
	private JLabel foodlenglb;//
	private JTextField foodlengtext;
	private JLabel mapifauthornamelb,mapifmapnamelb,mapifpwdlb,mapifctimelb,mapiftipslb,mapifbarcountlb,mapiflevelorderlb;
	private JLabel mapifcrossnodecountlb;
	private JTextField mapifauthornametext,mapifmapnametext,mapifpwdtext,mapifctimetext,mapiftipstext,mapifbarcounttext,mapiflevelordertext;
	private JTextField mapifcrossnodecounttext;
//	private JButton mapifcf
	
	// 穿越节点
	private int crossnodejbsize = 3;
	private JButton[] crossnodejbarr; 
	// label和输入
	private JLabel crossnodecurchooselb,crossnodefirstijlb,crossnodesecondijlb;
	private JTextField crossnodefirstitext,crossnodefirstjtext,crossnodeseconditext,crossnodesecondjtext;
	// 选择的下拉列表 
	public JComboBox<Object> crossnodejcbox;
	// 编号
	private ArrayList<String> crossnodelist;
	private GsnEditMapRightOpBarListComBoxModel gsneditmapcrossnodelistcbm;
		
	public GsnEditMapRightOperationJPanel(	GsnEditmapInterface gsneminter){
		this.gsneminter = gsneminter;
		initView();
		setLayoutOfPanle();
		addToPanel();
		setValueToCom();
		setLisToCom();
		
		setDefaultValueToallPanl();
		setBackground(Color.PINK);
		this.setSize(new Dimension(GsnInterfaceParam.EDITMAPRIGHTPANELWIDTH, GsnInterfaceParam.EDITMAPRIGHTPANELHEIGHT));// 220 * 410
	}
	// 操作下拉列表的arraylist
	// 添加一个下拉
	public void valueToBarList(){
		String st = gsneminter.gsnedmmgajpanel.MainGameMoveBarrierlength+"";
		barlist.add(st);
		// 并且将当前选的设置为当前的
		barjcbox.setSelectedItem(st);
		barjcbox.updateUI();// 关键的
	}
	
	private void initView(){
		jtbpane = new JTabbedPane();
		basicoppanel = new JPanel();
		snakeoppanel = new JPanel();
		mapinfopanel = new JPanel();
		barrierpanel = new JPanel();
		crossnodepanel = new JPanel();
		
		jbarr = new JButton[jbsize];
		
		// 障碍物的
		barjbarr = new JButton[barjbsize];
		baraddyesbt = new JButton("添加");
		baralterbt = new JButton("修改");
		bardelbt = new JButton("删除");
		barrunbt = new JButton("运行");
		barpausebt = new JButton("暂停");
		
		barlist = new ArrayList<String>();
		gsneditmapbarlistcbm = new GsnEditMapRightOpBarListComBoxModel(barlist);
		barjcbox = new JComboBox<Object>(gsneditmapbarlistcbm);
		
		bardirjcbox = new JComboBox<Object>(bardirst);
		// 标签
		barcurchooselb = new JLabel("当前选择：");
		barbarijlb = new JLabel("初始行列：");
		barhwlb = new JLabel("高和宽：");
		barwidelb = new JLabel("移动范围：");
		bardirlb = new JLabel("移动方向：");
		barspeedlb = new JLabel("移动速度：");
		
		// 文本
		barbaritext = new JTextField(3);
		barbarjtext = new JTextField(3);
		barhtext = new JTextField(3);
		barwtext = new JTextField(3);
		barwidetext = new JTextField(3);
		barspeedtext = new JTextField(3);
		
		// snake的
		snakebox = new  JComboBox<Object>(snakeplayerst);
		snakedirbox = new JComboBox<Object>(snakedirst);
		snakecurchooselb = new JLabel("当前选择");
		snakenodelb = new JLabel("蛇节");
		snakeheadlb = new JLabel("蛇头行列");
		snakedirlb = new JLabel("方向");
		
		snakenodetxt = new JTextField(3);
		snakeheaditext = new JTextField(3);
		snakeheadjtext = new JTextField(3);
		
		snakealterbt = new JButton("修改");
		// 蛇节设置不可编辑
		snakenodetxt.setEditable(false);
		
		// 地图信息的
		foodlenglb = new JLabel("食物数量");
		mapifauthornamelb = new JLabel("作者名称");
		mapifmapnamelb = new JLabel("地图名称");
		mapifpwdlb = new JLabel("地图密码");
		mapifctimelb = new JLabel("创建时间");
		mapiftipslb = new JLabel("地图概要");
		mapifbarcountlb = new JLabel("障碍物数");
		mapifcrossnodecountlb = new JLabel("穿越节点数量");
		mapiflevelorderlb = new JLabel("等级编号");
		
		foodlengtext = new JTextField(10);
		mapifauthornametext = new JTextField(10);
		mapifmapnametext = new JTextField(10);
		mapifpwdtext = new JTextField(10);
		mapifctimetext = new JTextField(10);
		mapiftipstext = new JTextField(10);
		mapifbarcounttext = new JTextField(10);
		mapiflevelordertext = new JTextField(10);
		mapifcrossnodecounttext = new JTextField(10);
		
		mapiflevelordertext.setEditable(false);
		mapifbarcounttext.setEditable(false);
		mapifcrossnodecounttext.setEditable(false);
		
		// 穿越节点
		crossnodejbarr = new JButton[crossnodejbsize];
		crossnodecurchooselb = new JLabel("当前选择");
		crossnodefirstijlb = new JLabel("第一个位置");
		crossnodesecondijlb = new JLabel("第二个位置");
		
		crossnodefirstitext = new JTextField(3);
		crossnodefirstjtext = new JTextField(3);
		crossnodeseconditext = new JTextField(3);
		crossnodesecondjtext = new JTextField(3);
		
		crossnodelist = new ArrayList<String>();
		gsneditmapcrossnodelistcbm = new GsnEditMapRightOpBarListComBoxModel(crossnodelist);
		crossnodejcbox = new JComboBox<Object>(gsneditmapcrossnodelistcbm);
	}
	// 设置布局
	private void setLayoutOfPanle(){
		basicoppanel.setLayout(new GridLayout(jbsize, 1));
		barrierpanel.setLayout(new GridLayout(9, 1));
		snakeoppanel.setLayout(new GridLayout(5, 1));
		mapinfopanel.setLayout(new GridLayout(9, 1));
		crossnodepanel.setLayout(new GridLayout(4, 1));
	}
	// 设置大小
	private void setPanelSize(){
		
	}
	// 添加到面板
	private void addToPanel(){
		jtbpane.add(basicoppanel,"基本操作");
		jtbpane.add(mapinfopanel,"地图信息");
		jtbpane.add(snakeoppanel,"蛇");
		jtbpane.add(barrierpanel,"障碍物");
		jtbpane.add(crossnodepanel,"穿越节点");
		
		add(jtbpane);
		
		//基本操作的
		for(int i = 0; i < jbarr.length; i++){
			jbarr[i] = new JButton();
			basicoppanel.add(jbarr[i]);
		}
		
		// 障碍物的
		// 子面板
		JPanel barjp1 = new JPanel();
		JPanel barjp2 = new JPanel();
		JPanel barjp3 = new JPanel();
		JPanel barjp4 = new JPanel();
		JPanel barjp5 = new JPanel();
		JPanel barjp6 = new JPanel();
		JPanel barjp7 = new JPanel();
		JPanel barjp8 = new JPanel();
		JPanel barjp9 = new JPanel();
		// 第一行
		for(int i = 0; i < barjbarr.length; i++){
			barjbarr[i] = new JButton();
			barjp1.add(barjbarr[i]);
		}
		barjcbox.setSize(new Dimension(80,30));
		barjcbox.setPreferredSize(new Dimension(80,30));
		barjp2.add(barcurchooselb);
		barjp2.add(barjcbox);
		
		// 第二行
		barjp3.add(barbarijlb);
		barjp3.add(barbaritext);
		barjp3.add(barbarjtext);
		
		barjp4.add(barhwlb);
		barjp4.add(barhtext);
		barjp4.add(barwtext);
	
		barjp5.add(barwidelb);
		barjp5.add(barwidetext);
	
		barjp6.add(bardirlb);
		barjp6.add(bardirjcbox);
		
		barjp7.add(barspeedlb);
		barjp7.add(barspeedtext);
		
		barjp8.add(baraddyesbt);
		barjp8.add(baralterbt);
		barjp8.add(bardelbt);
		
		barjp9.add(barrunbt);
		barjp9.add(barpausebt);
		
		barrierpanel.add(barjp1);
		barrierpanel.add(barjp2);
		barrierpanel.add(barjp3);
		barrierpanel.add(barjp4);
		barrierpanel.add(barjp5);
		barrierpanel.add(barjp6);
		barrierpanel.add(barjp7);
		barrierpanel.add(barjp8);
		barrierpanel.add(barjp9);
		
		// 蛇的
		JPanel snakejp1 = new JPanel();
		JPanel snakejp2 = new JPanel();
		JPanel snakejp3 = new JPanel();
		JPanel snakejp4 = new JPanel();
		JPanel snakejp5 = new JPanel();
		snakejp1.add(snakecurchooselb);
		snakejp1.add(snakebox);

		snakejp5.add(snakenodelb);
		snakejp5.add(snakenodetxt);
		
		snakejp2.add(snakeheadlb);
		snakejp2.add(snakeheaditext);
		snakejp2.add(snakeheadjtext);
		
		
		snakejp3.add(snakedirlb);
		snakejp3.add(snakedirbox);
		
		snakejp4.add(snakealterbt);
		
		snakeoppanel.add(snakejp1);
		snakeoppanel.add(snakejp5);
		snakeoppanel.add(snakejp2);
		snakeoppanel.add(snakejp3);
		snakeoppanel.add(snakejp4);
		
		// 地图信息的
		JPanel mapinfojp1 = new JPanel();
		JPanel mapinfojp2 = new JPanel();
		JPanel mapinfojp3 = new JPanel();
		JPanel mapinfojp4 = new JPanel();
		JPanel mapinfojp5 = new JPanel();
		JPanel mapinfojp6 = new JPanel();
		JPanel mapinfojp7 = new JPanel();
		JPanel mapinfojp8 = new JPanel();
		JPanel mapinfojp9 = new JPanel();
		
		mapinfojp1.add(mapifauthornamelb);
		mapinfojp1.add(mapifauthornametext);
		
		mapinfojp2.add(mapifmapnamelb);
		mapinfojp2.add(mapifmapnametext);
		
		mapinfojp3.add(mapifpwdlb);
		mapinfojp3.add(mapifpwdtext);
		
		mapinfojp4.add(mapifctimelb);
		mapinfojp4.add(mapifctimetext);
		
		mapinfojp5.add(mapiftipslb);
		mapinfojp5.add(mapiftipstext);
		
		mapinfojp6.add(foodlenglb);
		mapinfojp6.add(foodlengtext);
		
		mapinfojp7.add(mapifbarcountlb);
		mapinfojp7.add(mapifbarcounttext);
		
		mapinfojp8.add(mapiflevelorderlb);
		mapinfojp8.add(mapiflevelordertext);
		
		mapinfojp9.add(mapifcrossnodecountlb);
		mapinfojp9.add(mapifcrossnodecounttext);
		
		mapinfopanel.add(mapinfojp1);
		mapinfopanel.add(mapinfojp2);
		mapinfopanel.add(mapinfojp3);
		mapinfopanel.add(mapinfojp4);
		mapinfopanel.add(mapinfojp5);
		mapinfopanel.add(mapinfojp6);
		mapinfopanel.add(mapinfojp7);
		mapinfopanel.add(mapinfojp8);
		mapinfopanel.add(mapinfojp9);
		
		// 穿越节点
		JPanel cnjp1 = new JPanel();
		JPanel cnjp2 = new JPanel();
		JPanel cnjp3 = new JPanel();
		JPanel cnjp4 = new JPanel();
		
		crossnodejcbox.setSize(new Dimension(80,30));
		crossnodejcbox.setPreferredSize(new Dimension(80,30));
		cnjp1.add(crossnodecurchooselb);
		cnjp1.add(crossnodejcbox);
		
		cnjp2.add(crossnodefirstijlb);
		cnjp2.add(crossnodefirstitext);
		cnjp2.add(crossnodefirstjtext);
		
		cnjp3.add(crossnodesecondijlb);
		cnjp3.add(crossnodeseconditext);
		cnjp3.add(crossnodesecondjtext);
		
		for(int i = 0; i < crossnodejbarr.length; i++){
			crossnodejbarr[i] = new JButton();
			cnjp4.add(crossnodejbarr[i]);
		}
		
		crossnodepanel.add(cnjp1);
		crossnodepanel.add(cnjp2);
		crossnodepanel.add(cnjp3);
		crossnodepanel.add(cnjp4);
	}
	// 设置值
	private void setValueToCom(){
		// 基本操作
		jbarr[0].setText("有无边界");
		jbarr[1].setText("变为墙");
		jbarr[2].setText("取消墙");
		jbarr[3].setText("添加一个食物");
		jbarr[4].setText("设为移动障碍");
		jbarr[5].setText("设为一组穿越点");
		jbarr[6].setText("定位/不定位鼠标");
		jbarr[7].setText("保存并退出");
		jbarr[8].setText("取消并退出");
		jbarr[9].setText("预览/恢复");
		jbarr[10].setText("修改并退出");
		jbarr[10].setEnabled(false);
		
		// 障碍物
		barjbarr[0].setText("全部运行");
		barjbarr[1].setText("全部暂停");
		barjbarr[2].setText("全部删除");
		
		// 穿越节点
		crossnodejbarr[0].setText("添加");
		crossnodejbarr[1].setText("修改");
		crossnodejbarr[2].setText("删除");
	}
	// 监听
	private void setLisToCom(){
		GsnEditMapRightActionLis btlisone = new GsnEditMapRightActionLis();
		GsnEditMapRightOpJcomBoxLis itemlisone = new GsnEditMapRightOpJcomBoxLis();
		// 基本面板的
		for(int i = 0; i < jbarr.length; i++){
			jbarr[i].addActionListener(btlisone);
		}
		
		// 障碍物的
		bardirjcbox.addItemListener(itemlisone);
		barjcbox.addItemListener(itemlisone);
		baraddyesbt.addActionListener(btlisone);
		baralterbt.addActionListener(btlisone);
		bardelbt.addActionListener(btlisone);
		barpausebt.addActionListener(btlisone);
		barrunbt.addActionListener(btlisone);
		for(int i = 0; i < barjbarr.length; i++){
			barjbarr[i].addActionListener(btlisone);
		}
		
		// 蛇面板
		snakedirbox.addItemListener(itemlisone);
		snakebox.addItemListener(itemlisone);
		snakealterbt.addActionListener(btlisone);
		
		// 穿越节点
		for(int i = 0; i < crossnodejbarr.length; i++){
			crossnodejbarr[i].addActionListener(btlisone);
		}
		crossnodejcbox.addItemListener(itemlisone);
		
		
		// 总面板
		jtbpane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				gsneminter.gsnedmmgajpanel.requestFocus();
			}
		});
	}
	
	// 由预选的设为移动障碍 计算值 并且设置
	public void SetBarFromOrder(int start[], int end[]){
		// start[0] 是列 x
		int calwidth,calheight;
		calheight = end[1] - start[1] + 1;
		calwidth = end[0] - start[0] + 1;
		barbaritext.setText(start[1]+"");
		barbarjtext.setText(start[0]+"");
		barhtext.setText(calheight+"");
		barwtext.setText(calwidth+"");
	}
	// 给各个子面板添加默认值 
	public void setDefaultValueToallPanl(){
		// 障碍物list初始值
		setBarListDefault();
		// 穿越节点list初始值
		setCrossNodeListDefault();
		setBarAttribute(null);
		setCrossNodeAttribute(null);
		// 要设置玩家一 默认值 因为 当用户点击进来的时候
		setSnakeTextValue(0);//玩家一 下标为0
		// 设置地图信息面板 时间 ，食物数量，等级编号，
		setMapInfoTextValue();
		// 其它为了不报错的默认值
		barlastindex = -1;
		// 恢复按钮启动
		setBtEnable();
		
		// 让list清空
	}
	public void setMapInfoTextValue(){
		// 时间为当前 取年月日吧？？
		mapifctimetext.setText(new Date().toLocaleString());// 
		// 等级就当前地图多大吧
		mapiflevelordertext.setText((GsnMainGameConstants.gsngamemap.length+1)+"");
		// 概要
		mapiftipstext.setText("说说你创作的地图特点");
		// 密码
		mapifpwdtext.setText(mapinfopawdtips);
		// 名称
		mapifauthornametext.setText("留下你的大名");
		mapifmapnametext.setText("level："+(1 + GsnMainGameConstants.gsngamemap.length));
		// 这两个要根据地图是编辑还是创建来修改
		// 食物数量 
		setMapDefaultInfoFoodlength();
		setMapDefaultInfoGetBarCount();
		// 穿越
		setMapDefaultInfoGetCrossNodeCount();
	}
	// 重新新建地图的时候 加载的时候各个设回默认
	
	// 得到关卡障碍物数量
	public void setMapInfoGetBarCount(){
		// 根据游戏面板中不是空值的大小
		int count = gsneminter.gsnedmmgajpanel.notNullBarListCount();
		mapifbarcounttext.setText(count+"");
	}
	// 默认障碍物数量
	public void setMapDefaultInfoGetBarCount(){
		mapifbarcounttext.setText(0+"");
	}
	public void setMapDefaultInfoGetCrossNodeCount(){
		mapifcrossnodecounttext.setText(0+"");
	}
	// 默认食物数量
	public void setMapDefaultInfoFoodlength(){
		foodlengtext.setText("2");
	}
	// 根据游戏面板的食物数量 获取，
	public void setMapInfoFoodlength(){
		foodlengtext.setText(gsneminter.gsnedmmgajpanel.MainGamefoodlength+"");
	}
	// 给list清空 留下新的
	public void setBarListDefault(){
		barlist.clear();
		barlist.add("");
		barjcbox.setSelectedIndex(0);
		barjcbox.updateUI();
	}
	// 穿越节点操作start------------------
	// 给list清空 留下新的
	public void setCrossNodeListDefault(){
		crossnodelist.clear();
		crossnodelist.add("");
		crossnodejcbox.setSelectedIndex(0);
		crossnodejcbox.updateUI();
	}
	// 穿越节点操作end------------------
	// bean
	GsnMapBarrierMoveBean gmbarbean;
	GsnMapCrossNodeBean gmcrossnodebean;
	class GsnEditMapRightActionLis implements ActionListener{
		Object obj;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			obj = e.getSource();
			// 基本操作
			// 有边界
			if(obj == jbarr[0])
			{
				// 先取消已选区域
				gsneminter.recoverMapData();
				// 生成边界
				gsneminter.setBorder();
				// 给予game面版并绘画
				gsneminter.gsnedmmgajpanel.initMapData();
				gsneminter.gsnedmmgajpanel.repaint();
			}
			if(obj == jbarr[1])
			{
				// 生成墙
//				gsneminter.setOrderToWall(gsneminter.gsnedmmgajpanel.start,gsneminter.gsnedmmgajpanel.end);
				gsneminter.setOrderToWall();
				// 给予game面版并绘画
				gsneminter.gsnedmmgajpanel.initMapData();
				gsneminter.gsnedmmgajpanel.repaint();
			}
			if(obj == jbarr[2]){
				// 取消墙
				gsneminter.cancelOrderOfWall();
				// 给予game面版并绘画
				gsneminter.gsnedmmgajpanel.initMapData();
				gsneminter.gsnedmmgajpanel.repaint();
			}
			// 添加食物
			if(obj == jbarr[3]){
				// 不能超20
				if(gsneminter.gsnedmmgajpanel.MainGamefoodlength + 1 > 20){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "食物 2~20");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				
				// 重新食物数组 但是要先死亡
				gsneminter.gsnedmmgajpanel.foodDead();
				gsneminter.gsnedmmgajpanel.MainGamefoodlength++;// 加了数组在新建
				gsneminter.gsnedmmgajpanel.foodNew();
				// 也要给mapbean
				gsneminter.gsneditmapbean.gsmfoodbean.foodlength = gsneminter.gsnedmmgajpanel.MainGamefoodlength;
				// 并且设值给map
				setMapInfoFoodlength();
			}
			// 添加移动障碍 
			// 需要移动障碍的选项卡选中
			if(obj == jbarr[4]){
				jtbpane.setSelectedIndex(3);
				// 让障碍物下拉列表为0
				barjcbox.setSelectedIndex(0);
				// 把值传过去，要计算范围 
				SetBarFromOrder(gsneminter.gsnedmmgajpanel.start,gsneminter.gsnedmmgajpanel.end);
			}
			if(obj == jbarr[5]){
				// 判断选择是否超过2个 和这两个的位置
				int size = gsneminter.gsnedmmgajpanel.crossnodequ.size();
				if(size == 2){
					boolean bln = setCrossNodeFromQue();
					if(bln){
						// 添加一个障碍物给list 更新面板
						gsneminter.gsnedmmgajpanel.addOneCrossNodeTolist(gmcrossnodebean);
						// 增加一个数量
						gsneminter.gsnedmmgajpanel.addNewCrossListLength();
						// 并且当前的选择的下拉列表要添加一 
						valueToCrossNodeList();
						// 给地图信息得到数量
						setMapInfoGetCrossNodeCount();
						// 重绘
						gsneminter.gsnedmmgajpanel.repaint();
					}
				}else{
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "只能选两个位置");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
			}
			// 定位鼠标
			if(obj == jbarr[6]){
				gsneminter.gsnedmmgajpanel.setIsPosMouse();
			}
			// 保存并且推出 还有修改并退出！
			if(obj == jbarr[7]){
				// 检测地图值是否可以
				boolean isok = checkMapInfoTextIsOk();
				// 输出maptxt
				if(isok){
					int val = JOptionPane.showConfirmDialog(GsnEditMapRightOperationJPanel.this, "确定创建当前地图，不继续创作了吗");
					if(val == 0){
						editMapExit();
						// 要先处理bug 如果有预选地图的就恢复为0
						
						gsneminter.outNewMap();
						// 返回上一层
						GsnBottomLayerInterface.backLastJPanel();
					}
				}
			}
			// 直接退出 
			if(obj == jbarr[8]){
				// 返回上一层
				int val = JOptionPane.showConfirmDialog(GsnEditMapRightOperationJPanel.this, "确定退出吗");
				if(val == 0){
					editMapExit();
					// 从原始地图中恢复 动态地图 因为预览地图是用dynamic画的 ，这里的操作会影响预览
					GsnMainGameConstants.setDynamicMapData(GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata);
					GsnBottomLayerInterface.backLastJPanel();
				}
			}
			// 预览恢复
			if(obj == jbarr[9]){
				if(!gsneminter.mapTest){
					gsneminter.gsnedmmgajpanel.EditMapPreviewStartDraw();
				}else{
					gsneminter.gsnedmmgajpanel.EditMapPreviewStartRecover();
				}
			}
			// 保存退出 就是修改 要找到位置替换，要不全部更换好了？？？
			if(obj == jbarr[10]){
				// 将大小我5
				// 检测地图值是否可以
				boolean isok = checkMapInfoTextIsOk();
				if(isok){
					// 输出 之前 要转换为char字符 并且换一个数据类型输出
					int val = JOptionPane.showConfirmDialog(GsnEditMapRightOperationJPanel.this, "确定保存修改并退出吗");
					if(val == 0){
						editMapExit();
						// 没有办法了 只能一个新的 一个旧的，旧的map来查询在string的位置删除，新的map来添加
						gsneminter.alterMap();
						System.out.println(mapToStr());
						// 返回上一层
						GsnBottomLayerInterface.backLastJPanel();
					}
				}
			}
			
			// 障碍物的按钮监听
			// 全部运行
			if(obj == barjbarr[0]){
				gsneminter.gsnedmmgajpanel.allBarlisRun();
			}
			// 全部暂停
			if(obj == barjbarr[1]){
				gsneminter.gsnedmmgajpanel.allBarlisPause();
			}
			// 全部删除
			if(obj == barjbarr[2]){
				gsneminter.gsnedmmgajpanel.allBarlisDelete();
				// 情况数据
				setBarAttribute(null);
				// 给地图信息得到障碍物数量
				setMapInfoGetBarCount();
			}
			if(obj == baraddyesbt){
				// 根据当前是否选了一个移动障碍 是的话就提示 先取消选定
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex >= 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "你当前选择了一个障碍物，请修改即可，或者不选择障碍物");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				boolean isaddbln = commonWayOfAddAndAlter();
				if(isaddbln){// 成功了才加
					// 添加一个障碍物给list 并且 再运行 
					gsneminter.gsnedmmgajpanel.addOneBarTolist(gmbarbean);
					gsneminter.gsnedmmgajpanel.isRepeatPaintBar = true;
					// 重绘
					gsneminter.gsnedmmgajpanel.repaint();
					// 增加一个数量
					gsneminter.gsnedmmgajpanel.addNewBarirrLength();
					// 并且当前的选择的下拉列表要添加一 
					valueToBarList();
					// 给地图信息得到障碍物数量
					setMapInfoGetBarCount();
				}
			}
			if(obj == baralterbt){// 如果是修改 要修改在list中的属性
				// 先获取下标，如果没有选下标提示
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "要修改前请先选择一个障碍物");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				// 需要先停止吗？
				// 组成bean 修改
				boolean isalterbln = commonWayOfAddAndAlter();
				if(isalterbln){// 数据正确
					// 添加一个障碍物给list 并且 再运行 
					gsneminter.gsnedmmgajpanel.alterOneBarList(gmbarbean, curindex);
					gsneminter.gsnedmmgajpanel.isRepeatPaintBar = true;
					
					// 还要重新设置障碍物数量  要放在后面
					// 给地图信息得到障碍物数量
					setMapInfoGetBarCount();
				}
			}
			// 删除
			if(obj == bardelbt){
				// 获取下标 进行设置为null
				// 先获取下标，如果没有选下标提示
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "要删除前请先选择一个障碍物");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				gsneminter.gsnedmmgajpanel.giveNullBarTolist(curindex);
				// 并且数据要清空
				setBarAttribute(null);
				// 给地图信息得到障碍物数量
				setMapInfoGetBarCount();
			}
			// 暂停
			if(barpausebt == obj){
				// 根据当前下标来暂停 当然不能是空的
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "要暂停前请先选择一个障碍物");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				// 直接设置吧
				gsneminter.gsnedmmgajpanel.setPauseOrRun(curindex, false);
			}
			// 运行
			if(barrunbt == obj){
				// 根据当前下标来暂停 当然不能是空的
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "要运行前请先选择一个障碍物");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				// 直接设置吧
				gsneminter.gsnedmmgajpanel.setPauseOrRun(curindex, true);
				// 最重要的一点 这个要动的话，那么就要持续绘画
				gsneminter.gsnedmmgajpanel.isRepeatPaintBar = true;
				gsneminter.gsnedmmgajpanel.repaint();
			}
			
			// 蛇面板的按钮
			if(obj == snakealterbt){
				// 获取当前选择蛇的下标
				int snakeplayerindex = snakebox.getSelectedIndex();
				setSnakeInfoByText(snakeplayerindex);
			}
			if(gsneminter.mapTest){
				// 更新 动态地图值，因为预览开始了 ，因为蛇的代码是看与dymatic的同步而操作的
				gsneminter.setDynamicMapdata();
				// 操作完 并且当test为true给予中心面板监听
				gsneminter.gsnedmmgajpanel.requestFocus();
			}
			
			// 穿越节点面板监听
			if(obj == crossnodejbarr[0]){
				// 根据当前是否选了一个移动障碍 是的话就提示 先取消选定
				int curindex = crossnodejcbox.getSelectedIndex() - 1;
				if(curindex >= 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "你当前选择了一个穿越节点，请修改即可，或者不选择");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				boolean isaddbln = commonWayOfAddAndAlterForCrossNodeList();
				if(isaddbln){// 成功了才加
					// 添加一个障碍物给list 更新面板
					gsneminter.gsnedmmgajpanel.addOneCrossNodeTolist(gmcrossnodebean);
					// 增加一个数量
					gsneminter.gsnedmmgajpanel.addNewCrossListLength();
					// 并且当前的选择的下拉列表要添加一 
					valueToCrossNodeList();
					// 给地图信息得到数量
					setMapInfoGetCrossNodeCount();
					// 重绘
					gsneminter.gsnedmmgajpanel.repaint();
					// 清空queue
					gsneminter.gsnedmmgajpanel.crossnodequ.clear();
				}
			}
			if(obj == crossnodejbarr[1]){
				// 先获取下标，如果没有选下标提示
				int curindex = crossnodejcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "要修改前请先选择一个障碍物");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				// 组成bean 修改
				boolean isalterbln = commonWayOfAddAndAlterForCrossNodeList();
				if(isalterbln){// 数据正确
					gsneminter.gsnedmmgajpanel.alterOneCrossNodeList(gmcrossnodebean, curindex);
					// 要删除地图原来的地图值，并设置新地图值
					setMapInfoGetCrossNodeCount();
					// 重绘
					gsneminter.gsnedmmgajpanel.repaint();
				}
			}
			if(obj == crossnodejbarr[2]){
				// 获取下标 进行设置为null
				// 先获取下标，如果没有选下标提示
				int curindex = crossnodejcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "要删除前请先选择一个障碍物");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				gsneminter.gsnedmmgajpanel.giveNullCrossNodeTolist(curindex);
				// 并且数据要清空
				setCrossNodeAttribute(null);
				// 给地图信息得到障碍物数量
				setMapInfoGetCrossNodeCount();
				// 重回
				gsneminter.gsnedmmgajpanel.repaint();
			}
//			gsneminter.gsnedmmgajpanel.requestFocus();
		}
	}
	// map
	public String mapToStr(){
		StringBuilder sb = new StringBuilder();
		for(int m = 0; m < 41; m++){
			for(int n = 0; n < 60; n++){
				sb.append((char)(GsnMainGameConstants.dynamicmapdata[m][n] + '0'));// 要转换为字符
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	// 地图的默认值
	String mapinfopawdtips = "很重要，修改地图需要地图密码哦";
	public boolean checkMapInfoTextIsOk(){
		GsnMapInFoBean gsnmifb = new GsnMapInFoBean();
		gsnmifb.authorname = mapifauthornametext.getText().toString().trim();
		gsnmifb.mapname = mapifmapnametext.getText().toString().trim();
		gsnmifb.mappwd = mapifpwdtext.getText().toString().trim();
		gsnmifb.creationtime = mapifctimetext.getText().toString().trim();
		gsnmifb.tips = mapiftipstext.getText().toString().trim();
		gsnmifb.barcount = Integer.valueOf(mapifbarcounttext.getText().toString());
		gsnmifb.levelorder = Integer.valueOf(mapiflevelordertext.getText().toString());
		gsnmifb.crossnodecount = Integer.valueOf(mapifcrossnodecounttext.getText().toString());
		GsnMapFoodBean gsnfoodbean = new GsnMapFoodBean();
		String foodlength;
		foodlength = foodlengtext.getText().toString().trim();
		// 1.不能空
		if(foodlength.equals("") || 
				gsnmifb.authorname.equals("") || gsnmifb.mapname.equals("") || 
				gsnmifb.mappwd.equals("") || gsnmifb.creationtime.equals("") || 
				gsnmifb.tips.equals("")){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "地图信息不可为空");
			jtbpane.setSelectedIndex(1);
			return false;
		}
		// 2.不能大
		gsnfoodbean.foodlength = Integer.valueOf(foodlength);
		if(gsnfoodbean.foodlength > 20 || gsnfoodbean.foodlength < 2){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "食物数量在2 ~ 20之间");
			jtbpane.setSelectedIndex(1);
			return false;
		}
		if(gsnmifb.barcount > 20){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "障碍物数量不可超过20个");
			jtbpane.setSelectedIndex(2);
			return false;
		}
		if(gsnmifb.crossnodecount > 15){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "穿越节点不可超过15组");
			jtbpane.setSelectedIndex(4);
			return false;
		}
		// 3.不能超字符
		if(gsnmifb.authorname.length() > 20 || gsnmifb.mapname.length() > 20 || 
				gsnmifb.mappwd.length() > 20|| 
				gsnmifb.tips.length() > 20 ){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "地图信息的字符长度不可超过20个");
			jtbpane.setSelectedIndex(1);
			return false;
		}
		// 密码一定要设置
		if(gsnmifb.mappwd.equals(mapinfopawdtips)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "密码请重新设置");
			jtbpane.setSelectedIndex(1);
			mapifpwdtext.requestFocus();
			return false;
		}
		// 设置要输出的 mapinfbean,很重要！！！！
		gsneminter.setGsnEditMapBean(gsnmifb,gsnfoodbean);
		return true;
	}
	public void setSnakeInfoByText(int snakeplayerindex){
		String headist,headjst;
		int dirint;
		headist = snakeheaditext.getText().toString();
		headjst = snakeheadjtext.getText().toString();
		dirint = snakedirbox.getSelectedIndex();// 方向
		
		// 不能为空 
		if(headist.trim().equals("") || headjst.trim().equals("")){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "数值不可为空");
			return;
		}
		// 不能为字符
		// 要是数字
		if(!GsnTestIsNumClass.isNumeric(headist) || !GsnTestIsNumClass.isNumeric(headjst)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "数值不能是字母");
			return;
		}
		// 头不能越界
		
		// 不能越界
		boolean bln = calSnakeByText(snakeplayerindex, Integer.valueOf(headist), Integer.valueOf(headjst), dirint);
		if(bln){
			// 设置失败因为越界
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "组成的蛇节不能越界");
			return;
		}
	}
	// 根据头结点和节点和方向确定蛇节 还有设置地图值
	// 返回是否越界
	public boolean calSnakeByText(int player,int headi, int headj, int dir){
		int ai[] = new int[2];
		int aj[] = new int[2];
		// 先保存
		ai[0] = headi;
		aj[0] = headj;
		switch (dir) {
			case 0:
				ai[1] = headi + 1;
				aj[1] = headj;
			break;
			case 1:
				ai[1] = headi - 1;
				aj[1] = headj;
			break;
			case 2:
				ai[1] = headi;
				aj[1] = headj + 1;
			break;
			case 3:
				ai[1] = headi;
				aj[1] = headj - 1;
			break;			
		default:
			break;
		}
		// 判断是否越界
		if(ai[0] < 0 || ai[0] > 40 || ai[1] < 0 || ai[1] > 40 ||
				aj[0] < 0 || aj[0] > 59 || aj[1] < 0 || aj[1] > 59){
			return true;
		}
		// 重新组成bean赋予给 中心面的snake 并初始化，然后再给游戏面板
		GsnMapSnakeBean gsnamapsnake = new GsnMapSnakeBean();
		gsnamapsnake.snmapdirection = dir;
		gsnamapsnake.snmapi[0] = ai[0];
		gsnamapsnake.snmapj[0] = aj[0];
		gsnamapsnake.snmapi[1] = ai[1];
		gsnamapsnake.snmapj[1] = aj[1];
		// 很严重的错误！！！！！！！！蛇节没有设置 导致错误！
		gsnamapsnake.snnode = 2;
		// 中心面
		gsneminter.gsneditmapbean.gsmsnakebean[player] = gsnamapsnake;
		// 清楚地图中原来的位置
		gsneminter.gsnedmmgajpanel.deleteSnakeYuanZhi(player);
		// 赋予 游戏面板 位置
		gsneminter.gsnedmmgajpanel.setRunSnakePos();
		// 更新地图值
		gsneminter.gsnedmmgajpanel.fromSnakePosSetVal();
		// 重新绘画
		gsneminter.gsnedmmgajpanel.repaint();
		return false;
	}
	// 根据玩家几来设置文本宽值
	public void setSnakeTextValue(int player){
		snakenodetxt.setText("2");// 蛇节默认为2先不可改变
//		snakeheaditext.setText(gsneminter.gsnedmmgajpanel.gsnsnake[player].snactuali[0]+"");
//		snakeheadjtext.setText(gsneminter.gsnedmmgajpanel.gsnsnake[player].snactualj[0]+"");
//		snakedirbox.setSelectedIndex(gsneminter.gsnedmmgajpanel.gsnsnake[player].direction);
		
		snakeheaditext.setText(gsneminter.gsneditmapbean.gsmsnakebean[player].snmapi[0]+"");
		snakeheadjtext.setText(gsneminter.gsneditmapbean.gsmsnakebean[player].snmapj[0]+"");
		snakedirbox.setSelectedIndex(gsneminter.gsneditmapbean.gsmsnakebean[player].snmapdirection);
	}
	// 下拉框的监听
	String bardirstperse = "";
	int barlastindex = -1;//记录被选择的上一个障碍物下标 为了恢复颜色
	class GsnEditMapRightOpJcomBoxLis implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			// 如果是障碍物下拉列表
			if(e.getSource() == bardirjcbox){
				// 获取下标 给 bardir
				bardirstperse = e.getItem().toString();
				switch (bardirstperse) {
					case "上":
						bardir = 0;
						break;
					case "下":
						bardir = 1;
						break;
					case "左":
						bardir = 2;
						break;
					case "右":
						bardir = 3;
						break;
				default:
					break;
				}
			}
			// 如果是选择当前下拉列表
			if(e.getSource() == barjcbox){
				// 更改框的值 ,先在游戏面板中获取到movebean来 然后再设
				// 要减去1 因为 第一个为空，要处理这个，并且可能不太好
				int index = barjcbox.getSelectedIndex() - 1;
				if(index < 0){
					// 没有选为空
					setBarAttribute(null);
					// 恢复颜色
					if(barlastindex != -1){
						gsneminter.gsnedmmgajpanel.setisDrawColorForBar(barlastindex, false);
						// 因为面板的障碍物被点击了然后不动，但这里设置了颜色回去 那边就也跟着移动把
						gsneminter.gsnedmmgajpanel.setBarOneMoveByIndex(barlastindex);
						barlastindex = -1;//代表上一个未选
					}
				}else{
					// 换的时候就进行恢复上一个颜色 再设置新选的颜色-1代表上一个未有
					if(barlastindex != - 1){
						gsneminter.gsnedmmgajpanel.setisDrawColorForBar(barlastindex, false);
						// 因为面板的障碍物被点击了然后不动，但这里设置了颜色回去 那边就也跟着移动把
						gsneminter.gsnedmmgajpanel.setBarOneMoveByIndex(barlastindex);
					}
					barlastindex = index;
					// 并且给下拉列表中被选择的设置颜色
					gsneminter.gsnedmmgajpanel.setisDrawColorForBar(index, true);
					GsnMainGameMoveBarrier gsnbarbean = gsneminter.gsnedmmgajpanel.getNodeByIndexOfBarList(index);
					setBarAttribute(gsnbarbean);
					gsneminter.gsnedmmgajpanel.repaint();
					// 如果为空，并且地图上选了点 不是0000就设置值
//					if(gsnbarbean == null){
//						
//					}
				}
			}
			if(e.getSource() == snakebox){
				int index = snakebox.getSelectedIndex();
				setSnakeTextValue(index);
			}
			if(gsneminter.mapTest){
				// 更新 动态地图值，因为预览开始了
				gsneminter.setDynamicMapdata();
				// 操作完 并且当test为true给予中心面板监听
				gsneminter.gsnedmmgajpanel.requestFocus();
			}
			// 如果是 穿越item
			if(e.getSource() == crossnodejcbox){
				// 更改框的值 ,先在游戏面板中获取到movebean来 然后再设
				// 要减去1 因为 第一个为空，要处理这个，并且可能不太好
				int index = crossnodejcbox.getSelectedIndex() - 1;
				if(index < 0){
					// 没有选为空
					setCrossNodeAttribute(null);
				}else{
					GsnCrossNodeDraw gsnbarbean = gsneminter.gsnedmmgajpanel.getNodeByIndexOfCrossNodeList(index);
					setCrossNodeAttribute(gsnbarbean);
					gsneminter.gsnedmmgajpanel.repaint();
				}
			}
			gsneminter.gsnedmmgajpanel.requestFocus();
		}
	}
	// 障碍物属性 添加和修改判断的通用方法
	public boolean commonWayOfAddAndAlter(){
		// 障碍物的
		String barist,barjst,barwidthst,barheightst,barwidest,barspeedst;
		int bari,barj,barwidth,barheight,barwide,barspeed;
		// 获取输入的值 然后添加到游戏面板的数量中，并且增加一个数量
		// 方向只要从下拉获取 
		barist = barbaritext.getText().toString();
		barjst = barbarjtext.getText().toString();
		barheightst = barhtext.getText().toString();
		barwidthst = barwtext.getText().toString();
		barwidest = barwidetext.getText().toString();
		barspeedst = barspeedtext.getText().toString();
		// 有为空
		if(barist.trim().equals("") || barjst.trim().equals("") ||barheightst.trim().equals("")
				||barwidthst.trim().equals("") ||barspeedst.trim().equals("") 
				||barwidest.trim().equals("")){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "值不能为空");
			return false;
		}
		// 要是数字
		if(!GsnTestIsNumClass.isNumeric(barist) || !GsnTestIsNumClass.isNumeric(barjst)||
				!GsnTestIsNumClass.isNumeric(barheightst) || !GsnTestIsNumClass.isNumeric(barwidthst) ||
				!GsnTestIsNumClass.isNumeric(barspeedst)||
				!GsnTestIsNumClass.isNumeric(barwidest)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "不能是字母");
			return false;
		}
		// 转换
		bari = Integer.valueOf(barist);
		barj = Integer.valueOf(barjst);
		barheight = Integer.valueOf(barheightst);
		barwidth = Integer.valueOf(barwidthst);
		barspeed = Integer.valueOf(barspeedst);
		barwide = Integer.valueOf(barwidest);
		// 提醒不要太大
		if(bari < 0 || bari > 41){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "bari 应在 1 ~ 40 之间");
			return false;
		}
		if(barj < 0 || barj > 60){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "bari 应在 1 ~ 59之间");
			return false;
		}
		if(bari + barheight > 41){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "物体的高度占据  不能超过 41 ");
			return false;
		}
		if(barj + barwidth > 60){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "物体的宽度占据  不能超过 60");
			return false;
		}
		if(barspeed < 100 || barspeed > 2000){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "速度应在 100 ~ 2000之间");
			return false;
		}
		// 还要判断是否合法，就是够不够它 移动过去 不能有墙 不能有蛇  以及高度宽度 有没有越界 上面判断了
		
		// 设置值进去
		gmbarbean = new GsnMapBarrierMoveBean();
		gmbarbean.bari = bari;
		gmbarbean.barj = barj;
		gmbarbean.barheight = barheight;
		gmbarbean.barwidth = barwidth;
		gmbarbean.barspeed = barspeed;
		gmbarbean.barwide = barwide;// 犯了错 没有给范围 一直运行不起来
		
		gmbarbean.bardir = bardir;

		System.out.println("gmbarbean.bardir:"+barwide);
		// 不能有蛇的位置
		if(isTakeSnakePos(gmbarbean)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "所设范围内有蛇出生地 请重新调整");
			return false;
		}
		// 移动的时候不能越界
		if(isMoveOverBoundary(gmbarbean)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "移动范围越界 请重新调整");
			return false;
		}
		// 有时候是从基本面板过来的 就要把预选范围恢复 添加成功后
		gsneminter.cancelOrderOfWall();// 取消墙 因为是根据49来决定的，所以需要在添加成功前完成，因为障碍物会计算值为1
		// 给予game面版并绘画
		gsneminter.gsnedmmgajpanel.initMapData();
		return true;
	}
	// 设置障碍物属性
	public void setBarAttribute(GsnMainGameMoveBarrier gsnbarbean){
		if(gsnbarbean == null){
			barbaritext.setText("");
			barbarjtext.setText("");
			barhtext.setText("");
			barwtext.setText("");
			barwidetext.setText("");
			barspeedtext.setText("");
			// 方向默认为上
			bardirjcbox.setSelectedIndex(0);
		}else{
			barbaritext.setText(gsnbarbean.gsnmbarbean.bari+"");
			barbarjtext.setText(gsnbarbean.gsnmbarbean.barj+"");
			barhtext.setText(gsnbarbean.gsnmbarbean.barheight+"");
			barwtext.setText(gsnbarbean.gsnmbarbean.barwidth+"");
			barwidetext.setText(gsnbarbean.gsnmbarbean.barwide+"");
			barspeedtext.setText(gsnbarbean.gsnmbarbean.barspeed+"");
			// 方向改变
			bardirjcbox.setSelectedIndex(gsnbarbean.gsnmbarbean.bardir);
		}
	}
	// 设置边界 要不要判断有没有蛇。
	// 移动障碍检测方法
	// 判断地图中是否有蛇的存在是就提示
	public boolean isTakeSnakePos(GsnMapBarrierMoveBean bean){
		// 获取移动区域范围矩阵
		int bari = bean.bari, barj = bean.barj;
		for(int i = 0; i < bean.barheight; i++){
			// 左上角节点的i
			bari = bean.bari + i;
			for(int j = 0; j < bean.barwidth; j++){
				barj = bean.barj + j;
				if(gsneminter.gsnedmmgajpanel.currmapdata[bari][barj] == 2 ||
						gsneminter.gsnedmmgajpanel.currmapdata[bari][barj] == 3 ){
					return true;
				}
			}
		}
		return false;
	}
	// 判断移动的时候是否越界 根据方向范围
	public boolean isMoveOverBoundary(GsnMapBarrierMoveBean bean){
		// 获取移动区域范围矩阵
		int bari = bean.bari, barj = bean.barj;
		switch (bean.bardir) {
			case 0:
				// 往上
				if(bari - bean.barwide < 0){
					return true;
				}
				break;
			case 1:
				// 往下时
				if(bari + bean.barheight - 1 + bean.barwide > 40){
					return true;
				}
				break;
			case 2:
				// 往左时
				if(barj - bean.barwide < 0){
					return true;
				}
				break;
			case 3:
				// 往右时
				if(barj + bean.barwidth - 1 + bean.barwide > 59){
					return true;
				}
				break;				
			default:
				break;
		}
		return false;
	}
	// 重新加载地图的时候需要设置默认值给各个框start------------
	public void setSnakeBybean(GsnMapSnakeBean gsnbean[]){
		snakebox.setSelectedIndex(0);// 选中就会更新吧 // 不会
		setSnakeTextValue(0);// 重用代码就行
//		setSnakeTextValue(1);
	}
	public void Alter(){
		setBtEnable();
		setMapInfoBybean(gsneminter.gsneditmapbean);
		setBarBoxIndexOfAlter(gsneminter.gsneditmapbean);
		setSnakeBybean(gsneminter.gsneditmapbean.gsmsnakebean);// 
		setCrossCodeBoxIndexOfAlter(gsneminter.gsneditmapbean);
		// 其它默认值
		barlastindex = -1;
		
	}
	public void setBtEnable(){
		if(gsneminter.flag == 1){
			jbarr[10].setEnabled(false);
			jbarr[7].setEnabled(true);
		}else{
			jbarr[10].setEnabled(true);
			jbarr[7].setEnabled(false);
		}
	}
	public void setMapInfoBybean(GsnMapBean map){
		mapifauthornametext.setText(map.gsminfobean.authorname);
		mapifmapnametext.setText(map.gsminfobean.mapname);
		mapifctimetext.setText(map.gsminfobean.creationtime);// 
		// 等级就当前地图多大吧
		mapiflevelordertext.setText(map.gsminfobean.levelorder+"");
		// 概要
		mapiftipstext.setText(map.gsminfobean.tips);
		// 密码
		mapifpwdtext.setText(map.gsminfobean.mappwd);
		mapifbarcounttext.setText(map.gsminfobean.barcount+"");
		foodlengtext.setText(map.gsmfoodbean.foodlength+"");
		mapifcrossnodecounttext.setText(map.gsminfobean.crossnodecount+"");
	}
	// 设置移动的障碍物的值 和下标这些
	public void setBarBoxIndexOfAlter(GsnMapBean map){// 设置障碍物的下标
		// 先清空
		barlist.clear();
		// 要有一个默认的
		barlist.add("");
		for(int i = 0; i < map.gsminfobean.barcount; i++){
			barlist.add(i+1+"");
		}
		// 要更新
		barjcbox.updateUI();
	}
	// 重新加载地图的时候需要设置默认值给各个框end------------
	
	
	// 公共方法向外
	public void setSnakeTextValue(){
		int index = snakebox.getSelectedIndex();
		setSnakeTextValue(index);
	}
	
	
	// 穿越节点操作start-----------------
	public boolean setCrossNodeFromQue(){// 从面板获取的两个位置 添加
		int fist[] = gsneminter.gsnedmmgajpanel.crossnodequ.poll();
		int second[] = gsneminter.gsnedmmgajpanel.crossnodequ.poll();
		
		// 设置值进去
		gmcrossnodebean = new GsnMapCrossNodeBean();
		gmcrossnodebean.firstpos[0] = fist[0];
		gmcrossnodebean.firstpos[1] = fist[1];
		gmcrossnodebean.secondpos[0] = second[0];
		gmcrossnodebean.secondpos[1] = second[1];
		
		// 不能有蛇的位置
		if(isTakeSnakePosForCrossNode(gmcrossnodebean)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "所设范围内有其它请重新调整");
			return false;
		}
		
		// 有时候是从基本面板过来的 就要把预选范围恢复 添加成功后
		gsneminter.cancelOrderOfWall();//
		// 给予game面版并绘画
		gsneminter.gsnedmmgajpanel.initMapData();
		return true;
	}
	// 穿越节点属性 添加和修改判断的通用方法
	public boolean commonWayOfAddAndAlterForCrossNodeList(){
		String firstist,firstjst,secondeist,secondejst;
		int firsti,firstj,secondei,secondej;
		// 获取输入的值 然后添加到游戏面板的数量中，并且增加一个数量
		// 方向只要从下拉获取 
		firstist = crossnodefirstitext.getText().toString();
		firstjst = crossnodefirstjtext.getText().toString();
		secondeist = crossnodeseconditext.getText().toString();
		secondejst = crossnodesecondjtext.getText().toString();
		// 有为空
		if(firstist.trim().equals("") || firstjst.trim().equals("") ||secondeist.trim().equals("")
				||secondejst.trim().equals("")){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "值不能为空");
			return false;
		}
		// 要是数字
		if(!GsnTestIsNumClass.isNumeric(firstist) || !GsnTestIsNumClass.isNumeric(firstjst)||
				!GsnTestIsNumClass.isNumeric(secondeist) || !GsnTestIsNumClass.isNumeric(secondejst)
				){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "不能是字母");
			return false;
		}
		// 转换
		firsti = Integer.valueOf(firstist);
		firstj = Integer.valueOf(firstjst);
		secondei = Integer.valueOf(secondeist);
		secondej = Integer.valueOf(secondejst);
		// 提醒不要太大
		if(firsti < 0 || firsti > 41 || secondei < 0 || secondei > 41){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "i 应在 1 ~ 40 之间");
			return false;
		}
		if(firstj < 0 || firstj > 60 || secondej < 0 || secondej > 60){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "j 应在 1 ~ 59之间");
			return false;
		}
		// 不能有墙 不能有蛇 上面判断了
		
		// 设置值进去
		gmcrossnodebean = new GsnMapCrossNodeBean();
		gmcrossnodebean.firstpos[0] = firsti;
		gmcrossnodebean.firstpos[1] = firstj;
		gmcrossnodebean.secondpos[0] = secondei;
		gmcrossnodebean.secondpos[1] = secondej;

		// 不能有蛇的位置
		if(isTakeSnakePosForCrossNode(gmcrossnodebean)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "所设范围内有其它请重新调整");
			return false;
		}
		
		// 有时候是从基本面板过来的 就要把预选范围恢复 添加成功后
		gsneminter.cancelOrderOfWall();//
		// 给予game面版并绘画
		gsneminter.gsnedmmgajpanel.initMapData();
		return true;
	}
	public boolean isTakeSnakePosForCrossNode(GsnMapCrossNodeBean bean){
		// 不是平地 并且不是预选 为了两个都适合
		if(!(gsneminter.gsnedmmgajpanel.currmapdata[bean.firstpos[0]][bean.firstpos[1]] == 0 
				|| gsneminter.gsnedmmgajpanel.currmapdata[bean.firstpos[0]][bean.firstpos[1]] == 49)){
			return true;
		}
		if(!(gsneminter.gsnedmmgajpanel.currmapdata[bean.secondpos[0]][bean.secondpos[1]] != 0 ||
				gsneminter.gsnedmmgajpanel.currmapdata[bean.secondpos[0]][bean.secondpos[1]] != 49)){
			return true;
		}
		return false;
	}
	// 添加一个下拉
	public void valueToCrossNodeList(){
		String st = gsneminter.gsnedmmgajpanel.crossnodelength+"";
		crossnodelist.add(st);
		// 并且将当前选的设置为当前的
		crossnodejcbox.setSelectedItem(st);
		crossnodejcbox.updateUI();// 关键的
	}
	// 得到数量
	public void setMapInfoGetCrossNodeCount(){
		// 根据游戏面板中不是空值的大小
		int count = gsneminter.gsnedmmgajpanel.notNullCrossNodeCount();
		mapifcrossnodecounttext.setText(count+"");
	}
	// 设置障碍物属性
	public void setCrossNodeAttribute(GsnCrossNodeDraw gsnbean){
		if(gsnbean == null){
			crossnodefirstitext.setText("");
			crossnodefirstjtext.setText("");
			crossnodeseconditext.setText("");
			crossnodesecondjtext.setText("");
		}else{
			crossnodefirstitext.setText(gsnbean.gsncnbean.firstpos[0]+"");
			crossnodefirstjtext.setText(gsnbean.gsncnbean.firstpos[1]+"");
			crossnodeseconditext.setText(gsnbean.gsncnbean.secondpos[0]+"");
			crossnodesecondjtext.setText(gsnbean.gsncnbean.secondpos[1]+"");
		}
	}
	// 修改的时候
	public void setCrossCodeBoxIndexOfAlter(GsnMapBean map){// 设置障碍物的下标
		// 先清空
		crossnodelist.clear();
		// 要有一个默认的
		crossnodelist.add("");
		for(int i = 0; i < map.gsminfobean.crossnodecount; i++){
			crossnodelist.add(i+1+"");
		}
		// 要更新
		crossnodejcbox.updateUI();
	}
	// 由预选的设为穿越
	public void SetCrossTextFromQueue(){
		int fist[] = null, second[] = null;
		Iterator<int[]> it = gsneminter.gsnedmmgajpanel.crossnodequ.iterator();
		if(it.hasNext()){
			fist = it.next();
		}
		if(it.hasNext()){
			second = it.next();
		}
		if(fist != null){
			crossnodefirstitext.setText(fist[0]+"");
			crossnodefirstjtext.setText(fist[1]+"");
		}
		if(second != null){
			crossnodeseconditext.setText(second[0]+"");
			crossnodesecondjtext.setText(second[1]+"");
		}
		// 清空
//		gsneminter.gsnedmmgajpanel.crossnodequ.clear();
	}
	// 穿越节点操作end-------------------
	
	// 退出地图编辑方法
	public void editMapExit(){
//		gsneminter.gsnedmmgajpanel.setIsPosMouse();
		// 将所有都停止线程结束
		gsneminter.gsnedmmgajpanel.endThread();
		// 停止不知道有没有用？？？ 一直邮错误
		gsneminter.gsnedmmgajpanel.EditMapPreviewStartRecover();
		GsnMainGameConstants.setDrawSize(5);
	}
}
