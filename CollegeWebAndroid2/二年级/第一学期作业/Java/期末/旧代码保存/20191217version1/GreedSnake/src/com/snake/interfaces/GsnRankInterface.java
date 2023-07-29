package com.snake.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.snake.bean.GsnRankBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.editmap.GsnEditMapRightOpBarListComBoxModel;
import com.snake.mgameconfig.GsnMainGameConstants;

// 排行榜
public class GsnRankInterface extends JPanel{
	// jlist
	
	// 滚动条显式关卡
	private JScrollPane jscrollpane;
	private JPanel jpanel;// 存放label
	
	// 采用Jlist
	private JLabel ranktipla,ranktiptwo;
	public ArrayList<Object> gsnleveldisarrlist;// 只是放入一个名称
	public JList<Object> gsnleveldisjlist;
	public GsnEditMapRightOpBarListComBoxModel jlistmodel;
	
	public GsnRankInterface(){
		
		initview();
		setLayout(null);
		this.setBackground(Color.CYAN);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 固定大小
		
		// 监听事件
		this.addKeyListener(new GsnRankKeyLis());
	}
	// 初始化面板
	public void initview(){
		ranktipla = new JLabel("排          行        榜", JLabel.CENTER);
		gsnleveldisarrlist = new ArrayList<Object>();
		jlistmodel = new GsnEditMapRightOpBarListComBoxModel(gsnleveldisarrlist);
		gsnleveldisjlist = new JList<Object>(jlistmodel);
		// 设置不可点击 以免失去焦点
		gsnleveldisjlist.setFocusable(false);
		
		reAddArraylist();
		
		//关闭横向 开启竖
		jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		// 文字
		jpanel.add(ranktipla, BorderLayout.NORTH);
		// 设置中心
		jpanel.add(gsnleveldisjlist, BorderLayout.CENTER);
		
		// 要把jpanel放入参数才行。。或者viewpoint
		jscrollpane = new JScrollPane(jpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollpane.setPreferredSize(new Dimension(220, 410));
		
		jscrollpane.setBounds(140, 50, 360, 410);
		// 添加到面板
		add(jscrollpane);
	}
	// 重新读取添加list
	public void reAddArraylist(){
		gsnleveldisarrlist.clear();
		String s = "姓名----------------------------分数-----------------------------------时间";
		gsnleveldisarrlist.add(s);
		// 大小
		MaoPao();
		for(int i = 0; i < GsnMainGameConstants.gsnrankbeanarr.length; i++){
			gsnleveldisarrlist.add(GsnMainGameConstants.gsnrankbeanarr[i].getName()+"                   "+
						GsnMainGameConstants.gsnrankbeanarr[i].getSocre()+"                        "+
					GsnMainGameConstants.gsnrankbeanarr[i].getDate());
		}
	}
	// 增加前一个简单的冒泡排序
	public void MaoPao(){
		GsnRankBean temp = new GsnRankBean();
		for(int i = 0; i < GsnMainGameConstants.gsnrankbeanarr.length; i++){
			for(int j = i + 1; j < GsnMainGameConstants.gsnrankbeanarr.length; j++){
				if(GsnMainGameConstants.gsnrankbeanarr[i].getSocre() < GsnMainGameConstants.gsnrankbeanarr[j].getSocre()){
					temp = new GsnRankBean(GsnMainGameConstants.gsnrankbeanarr[i]);
					GsnMainGameConstants.gsnrankbeanarr[i] = GsnMainGameConstants.gsnrankbeanarr[j];
					GsnMainGameConstants.gsnrankbeanarr[j] = temp;
				}
			}
		}
	}
	// 键盘监听 
	class GsnRankKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnRankKeyLis按下VK_ESCAPE键");
			}
		}
	}
}
