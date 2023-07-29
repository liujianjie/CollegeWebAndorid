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

// 最底层面板
public class GsnBottomLayerInterface extends JFrame{
	// 记录出现面板的顺序
	public static Stack<JPanel> orderjpanel;
	
	// 全部子面板
	public static JPanel gameMainmenuJpanel;
	public static GsnLevelDisplayInterface gameLevelJpanel;
	public static GsnCenterInterface gameCenterJpanel;
	public static JPanel gameDevelperIntroJpanel,gameHelpJpanel;
	public static GsnRankInterface gameRankJpanel;
	public static GsnResultAndScoreInterface gameResultAndScoreJpanel;
	public static GsnEditMapLevelDisplayInterface gsneditmapleveldisplayJpanel;
	public static GsnEditmapInterface gameEditMapJpanel;
	// 基层面板
	public static Container con;
	
    // 一开始就要读取地图数据
	public GsnMapReadAndOut gm;
    
	public GsnBottomLayerInterface(){
		super("");
		this.setUndecorated(true);// 无边框
		
		// 初始化数据
		stratProduceOfSize();
		stratProduceOfJPanel();
		stratProduceOfJPanelOp();
		stratProduceOfData();
		// 全屏
		setSize(GsnInterfaceParam.allwidth,GsnInterfaceParam.allheight);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new GsnBottomLayerInterface();
	}
	
	// 初始化工作 start----------------------------
	protected void stratProduceOfSize(){// 屏幕大小
		// 1.获取当前屏幕分辨率
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Dimension scrnsize = toolkit.getScreenSize();
	    GsnInterfaceParam.allwidth = (int)scrnsize.getWidth();
	    GsnInterfaceParam.allheight = (int)scrnsize.getHeight();
	    
	    // 2.初始化读取文件化为地图
	    gm = new GsnMapReadAndOut();
	    gm.readMapText();
	    gm.changeMap();// 地图
	    
	    gm.readRank();// 排行榜
	    
	    // 游戏设置。。。
	}
	protected void stratProduceOfJPanel(){// 初始化面板
		con = getContentPane();
		con.setLayout(null);
		gameMainmenuJpanel = new GsnMainMenuInterface();// 初始面板
		// 其它面板
		gameCenterJpanel = new GsnCenterInterface();// 要在GsnLevelDisplayInterface之前实例化，因为游戏面板初始化蛇的时候会调用分数面板使用，此时没有new 会null
		gameLevelJpanel = new GsnLevelDisplayInterface();
		
		gameDevelperIntroJpanel = new GsnDeveloperIntroduceInterface();
		gameEditMapJpanel = new GsnEditmapInterface(1);
		gameHelpJpanel = new GsnHelpInterface();
		gameResultAndScoreJpanel = new GsnResultAndScoreInterface();
		gameRankJpanel = new GsnRankInterface();
		gsneditmapleveldisplayJpanel = new GsnEditMapLevelDisplayInterface();
		
		// 要定位在中心
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
	protected void stratProduceOfJPanelOp(){// 面板操作
		con.add(gameMainmenuJpanel);
		con.add(gameLevelJpanel);
		con.add(gameCenterJpanel);
		con.add(gameDevelperIntroJpanel);
		con.add(gameEditMapJpanel);
		con.add(gameHelpJpanel);
		con.add(gameResultAndScoreJpanel);
		con.add(gameRankJpanel);
		con.add(gsneditmapleveldisplayJpanel);
		
		//背景色
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
		
		// 需要给面板添加焦点才可 实现按钮监听
		gameMainmenuJpanel.setFocusable(true); //
		gameMainmenuJpanel.requestFocus();
	}
	protected void stratProduceOfData(){// 数据操作
		orderjpanel = new Stack<JPanel>();
		// 初始化为这个面板
		orderjpanel.push(gameMainmenuJpanel);
	}
	// 初始化工作end----------------------------
	
	// 更新面板
	public static void updateJPanel(JPanel jp1, JPanel jp2){// static为了其它面板能直接调用
		jp1.setVisible(false);
		jp2.setVisible(true);
		con.update(jp2.getGraphics());
		jp2.requestFocus();
		orderjpanel.add(jp2);// 添加到stack堆栈
	}
	// 不保存到stack中，并且出栈 center游戏面板
	public static void updateJPanelNotSave(JPanel jp1, JPanel jp2){// static为了其它面板能直接调用 
		jp1.setVisible(false);
		jp2.setVisible(true);
		con.update(jp2.getGraphics());
		jp2.requestFocus();
		orderjpanel.clear();// 清空
		orderjpanel.add(gameMainmenuJpanel);// 添加level选项
		orderjpanel.add(jp2);
	}
	// 当前栈不保存
	public static void updateJPanelNotSaveCur(JPanel jp1, JPanel jp2){// static为了其它面板能直接调用 
		jp1.setVisible(false);
		jp2.setVisible(true);
		con.update(jp2.getGraphics());
		jp2.requestFocus();
		orderjpanel.clear();// 清空
		orderjpanel.add(gameMainmenuJpanel);// 添加level选项
		orderjpanel.add(jp2);
	}
	// 回到上一个面板
	public static void backLastJPanel(){
		orderjpanel.pop().setVisible(false);//  最顶上的消失
		orderjpanel.peek().setVisible(true);// 当前的面板显式
		orderjpanel.peek().requestFocus();// 并且得到监听
	}
}
