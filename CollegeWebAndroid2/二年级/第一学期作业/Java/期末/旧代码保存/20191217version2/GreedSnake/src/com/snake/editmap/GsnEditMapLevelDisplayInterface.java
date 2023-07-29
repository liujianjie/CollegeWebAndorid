package com.snake.editmap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.snake.bean.GsnMapBean;
import com.snake.bean.GsnMapInFoBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.interfaces.GsnBottomLayerInterface;
import com.snake.iomap.GsnMapReadAndOut;
import com.snake.mgame.GsnMainGameJPanel;
import com.snake.mgame.GsnMainGameScoreJPanel;
import com.snake.mgameconfig.GsnMainGameConstants;
import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import sun.net.www.content.image.jpeg;
// 关卡选择以及信息预览界面
public class GsnEditMapLevelDisplayInterface extends JPanel{
	// 子控件
	// 滚动条显式关卡
	private JScrollPane jscrollpane;
	private JPanel jpanel;// 存放label
	
	// 采用Jlist
	public ArrayList<Object> gsneditmapleveldisarrlist;// 只是放入一个名称
	public JList<Object> gsneditmapleveldisjlist;
	public GsnEditMapRightOpBarListComBoxModel jlistmodel;
	public JButton newmapjb;
	
	// 预览的 地图界面
	private GsnMainGameJPanel prevewMainGameJpanel;
	
	// 预览的 地图信息 
	private GsnMapInFoBean mapbean;
	private JPanel mapinfoJpanel;
	private JLabel[] mapinfoJLable;
	private JButton alterbt,deletebt;
	
	public GsnMapReadAndOut gsnmaprao;
	
	// 重新读取地图
	public void reReadNewMap(){
		gsnmaprao.readMapText();
		gsnmaprao.changeMap();
	}
	public GsnEditMapLevelDisplayInterface(){
		setLayout(null);
		// 先设置这个
		
		initview();
		
		initGamepanel();
		
		
		setJListBkColor();

		initMapInfoView();
		
		addLis();
		
		gsnmaprao = new GsnMapReadAndOut();
		
		this.setBackground(Color.GREEN);
		this.setSize(new Dimension(640, 480));// 640 * 480 固定大小
		
		// 监听事件
		this.addKeyListener(new GsnLevelDisplayKeyLis());
	}
	
	// 操作jlist----------------------
	// 清空list
	public void clearArrayList(){
		gsneditmapleveldisarrlist.clear();
	}
	// 重新读取添加list
	public void reAddArraylist(){
		// 大小
		for(int i = 0; i < GsnMainGameConstants.gsngamemap.length; i++){
			gsneditmapleveldisarrlist.add((i + 1)+"."+GsnMainGameConstants.gsngamemap[i].gsminfobean.mapname);
		}
	}
	
	// 操作jlist----------------------
	// 设置绘画地图常量值
	public void setDrawMapConstant(int size, int level){
		editmapdisplaycurlevel = level;
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
		newmapjb = new JButton("新建地图");
		gsneditmapleveldisarrlist = new ArrayList<Object>();
		jlistmodel = new GsnEditMapRightOpBarListComBoxModel(gsneditmapleveldisarrlist);
		gsneditmapleveldisjlist = new JList<Object>(jlistmodel);
		
		// 设置不可点击 以免失去焦点
		gsneditmapleveldisjlist.setFocusable(false);
		
		reAddArraylist();
		gsneditmapleveldisjlist.setSelectedIndex(0);// 第一个选中
		//关闭横向 开启竖
		jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		jpanel.add(newmapjb, BorderLayout.NORTH);
		// 设置中心
		jpanel.add(gsneditmapleveldisjlist, BorderLayout.CENTER);
		
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
		
		JPanel jp = new JPanel();
		alterbt = new JButton();
		setEnterButtonSt("修改地图");
		
		deletebt = new JButton();
		deletebt.setText("删除地图");
		
		jp.add(alterbt);
		jp.add(deletebt);
		mapinfoJpanel.add(jp);
		this.add(mapinfoJpanel);
		mapinfoJpanel.setBounds(290, 275, GsnInterfaceParam.GAMEMAPINFOWIDTH, GsnInterfaceParam.GAMEMAPINFOHEIGHT);
	}
	public void setEnterButtonSt(String st){
		alterbt.setText(st);
	}
	// 添加监听
	public void addLis(){
		GsnLevelActionLis gsla = new GsnLevelActionLis();
		alterbt.addActionListener(gsla);
		newmapjb.addActionListener(gsla);
		deletebt.addActionListener(gsla);
		GsnEditMaplevelDisItemClass gsndis = new GsnEditMaplevelDisItemClass();
		gsneditmapleveldisjlist.addListSelectionListener(gsndis);
	}
	// 给Jabel设置背景颜色 根据当前选择的关卡
	public void setJListBkColor(){
		gsneditmapleveldisjlist.setSelectionBackground(Color.ORANGE);
	}
	// 验证密码
	public boolean checkMapPwd(){
		// 先输入密码
		String stpwd = JOptionPane.showInputDialog(GsnEditMapLevelDisplayInterface.this, "请输入关卡密码");
		if(stpwd != null){
			if(stpwd.equals(GsnMainGameConstants.gsngamemap[editmapdisplaycurlevel - 1].gsminfobean.mappwd)){
				return true;
			}else{
				JOptionPane.showMessageDialog(GsnEditMapLevelDisplayInterface.this, "关卡密码错误，无法进行操作");
				return false;
			}
		}
		return false;
	}
	// 进入
	public void alterGameMap(){
		if(checkMapPwd()){
			setDrawMapConstant(10, editmapdisplaycurlevel);// 先设置好参数
			// 把修改的中心面板跳出来才可
			GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gsneditmapleveldisplayJpanel, GsnBottomLayerInterface.gameEditMapJpanel);
			// 里面的面板单独提出来设置监听 。因为已经初始化过，在构造方法里获取面版焦点是行不通的
			GsnBottomLayerInterface.gameEditMapJpanel.setMapDataByLevel();
			GsnBottomLayerInterface.gameEditMapJpanel.gsnedmmgajpanel.requestFocus();
		}else{
			this.requestFocus();
		}
	}
	// 更新浏览的关卡图片
	public void changePreviewMap(){
		// 更换地图之前需要先关之前的 蛇 障碍物 食物的线程
		prevewMainGameJpanel.endThread();
		// 绘画关卡
		prevewMainGameJpanel.Preview();
		prevewMainGameJpanel.repaint();
	}
	
	// 新建关卡
	public void newMap(){
		setDrawMapConstant(10, editmapdisplaycurlevel);// 先设置好参数
		// 让为空
		GsnBottomLayerInterface.gameEditMapJpanel.Reinit();
		GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gsneditmapleveldisplayJpanel, GsnBottomLayerInterface.gameEditMapJpanel);
		GsnBottomLayerInterface.gameEditMapJpanel.gsnedmmgajpanel.requestFocus();
	}
	
	// 当前浏览的关卡 默认1
	int editmapdisplaycurlevel = 1;
	// 要设置 因为添加的时候会更新
	public void setEditMapLevelCurLevelForadd(){
		editmapdisplaycurlevel = GsnMainGameConstants.gsngamemap.length;
		setDrawMapConstant(5, editmapdisplaycurlevel);// 当前等级最高了
		changePreviewMap();
	}
	// 修改的时候 也是最后一个 因为放到下面去了
	public void setEditMapLevelCurLevelForAlter(){
		editmapdisplaycurlevel = GsnMainGameConstants.gsngamemap.length;
		setDrawMapConstant(5, editmapdisplaycurlevel);// 当前等级最高了
		changePreviewMap();
	}
	int chooselevel = -2;
	public void PressNumberDel(){// 因为按下数字键 需要跳转
		if(chooselevel <= GsnMainGameConstants.gsngamemap.length ){
			// 赋予
			editmapdisplaycurlevel = chooselevel;
			alterGameMap();
		}
	}
	// 键盘监听 选择菜单项
	class GsnLevelDisplayKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			// 浏览关卡
			if(e.getKeyCode() == KeyEvent.VK_UP){
				// 设置关卡 如果大于 0 就设置
				if(editmapdisplaycurlevel - 1 > 0){
					setDrawMapConstant(5, editmapdisplaycurlevel - 1);
					changePreviewMap();// 更换显式的地图
					// jlist对应选择
					gsneditmapleveldisjlist.setSelectedIndex(editmapdisplaycurlevel - 1);// 下标永远小一个
					setMapInfoBean();// 地图信息
				}
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				// 可以加
				if(editmapdisplaycurlevel + 1 <= gsneditmapleveldisarrlist.size()){
					setDrawMapConstant(5, editmapdisplaycurlevel + 1);
					changePreviewMap();
//					// jlist对应选择
					gsneditmapleveldisjlist.setSelectedIndex(editmapdisplaycurlevel - 1);
					setMapInfoBean();// 地图信息
				}
			}
			// 修改当前关卡
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				alterGameMap();
			}
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
	
	// Jbutton设置监听
	class GsnLevelActionLis implements ActionListener{
		Object obj;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			obj = e.getSource();
			if(obj == alterbt)
			{
				alterGameMap();
			}else if( obj == newmapjb){
				// 新建
				newMap();
			}else if(obj == deletebt){
				// 删除此地图 
				
				// 先确认密码
				if(checkMapPwd()){
					// 删除。。。。根据当前选择的关卡
					gsnmaprao.delMap();
					// 并且要更新ui 像修改一样
					// 输出完 重新读取
					reReadNewMap();
					// 输出完也要更新坐标预览的关卡数量 就最后一个吧
					setEditMapLevelCurLevelForadd();
					
					// 输出完要给更新UI 就是关卡选择
					clearArrayList();
					reAddArraylist();
					//设置最后一个
					gsneditmapleveldisjlist.setSelectedIndex(GsnMainGameConstants.gsngamemap.length - 1);
					gsneditmapleveldisjlist.updateUI();
					
					// 预览地图的
					GsnBottomLayerInterface.gameLevelJpanel.clearArrayList();
					GsnBottomLayerInterface.gameLevelJpanel.reAddArraylist();
					//设置第一个关卡选中
					GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.setSelectedIndex(0);
					GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.updateUI();
				}
				// 设置会监听
				GsnEditMapLevelDisplayInterface.this.requestFocus();
			}
			
		}
	}
	// 设置jlist的点击
	class GsnEditMaplevelDisItemClass implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			// 给当前关卡数值 
			setDrawMapConstant(5, gsneditmapleveldisjlist.getSelectedIndex() + 1);
			// 预览图跟着更新
			changePreviewMap();
			setMapInfoBean();// 地图信息
		}
		
	}
}
