package com.snake.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.snake.bean.GsnRankBean;
import com.snake.config.GsnInterfaceParam;
import com.snake.iomap.GsnInputAndOut;
import com.snake.iomap.GsnMapReadAndOut;
import com.snake.mgameconfig.GsnMainGameConstants;

// 成绩 和 结果面板
public class GsnResultAndScoreInterface extends JPanel{
	// score
	// 很遗憾，恭喜，别灰心，平局
	JLabel resulttip;
	// 闯关失败,PLAYER1胜利，电脑胜利 分数多少多少。。
	JLabel resultjl;
	// 输入姓名：
	JLabel inputjl;
	public JTextField inputnamejf;
	// tips2 按1重新开始，按2重选关卡，按esc返回主界面，
	JLabel tips1;
	
	GsnMapReadAndOut gsin;
	Font f;
	JPanel centerjp;
	int isOkInput = 0;
	public GsnResultAndScoreInterface(){
		gsin = new GsnMapReadAndOut();
		setLayout(null);
		initfont();
		initComp();
		
		add(centerjp);
		centerjp.setBounds((GsnInterfaceParam.INTERFACEWIDTH - 350) / 2, (GsnInterfaceParam.INTERFACEHEIGHT - 280) / 2, 350, 280);
		
		this.setBackground(Color.CYAN);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 固定大小
		
		// 监听事件
		this.addKeyListener(new GsnResultAndScoreKeyLis());
	}
	public void initfont(){
		f = new Font("楷体", 1, 15);
	}
	public void initComp(){
		centerjp = new JPanel();
		centerjp.setOpaque(false);
		centerjp.setLayout(new GridLayout(4, 1));
		
		resulttip = new JLabel("",JLabel.CENTER);
		resultjl = new JLabel("",JLabel.CENTER);
		
		JPanel jp = new JPanel();
		jp.setBackground(Color.CYAN);// 与一致
		inputjl = new JLabel("输入姓名：");
		inputnamejf = new JTextField(10);
		
		jp.add(inputjl);
		jp.add(inputnamejf);
		
		tips1 = new JLabel("tips2 按1重选关卡，按esc回到主菜单",JLabel.CENTER);
		
		centerjp.add(resulttip);
		centerjp.add(resultjl);
		centerjp.add(jp);
		centerjp.add(tips1);
		
		resulttip.setFont(f);
		resultjl.setFont(f);
		inputjl.setFont(f);
		tips1.setFont(f);
		
		inputnamejf.addKeyListener(new GsnResultAndScoreKeyLis2());
	}
	// 设置结果显示
	public void setResultString(String s1,String s2){
		resulttip.setText(s1);
		resultjl.setText(s2);
	}
	public boolean checkInput(){
		return false;
	}
	public void jin(){
		// 设置jilist
		inputnamejf.setFocusable(false);// 失去焦点
		inputnamejf.setEnabled(false);// 失去
	}
	// 标签内容清空
	public void clearContext(){
		// 设置jilist
		inputnamejf.setText("");
		inputnamejf.setFocusable(true);
		inputnamejf.setEnabled(true);
		GsnResultAndScoreInterface.this.requestFocus();
	}
	// 是0分 是就不要监听
	public void ZeroScore(){
		// 设置jilist
		inputnamejf.setFocusable(false);// 失去焦点
		inputnamejf.setEnabled(false);// 失去
	}
	// 键盘监听
	class GsnResultAndScoreKeyLis2 extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				System.out.println("GsnResultAndScoreKeyLis按下VK_ENTER键");
				// 判断是否输入姓名
				String st = inputnamejf.getText().toString();
				if(st.trim().equals("") || st.length() > 10){
					int v = JOptionPane.showConfirmDialog(GsnResultAndScoreInterface.this, "是否不保存当前成绩");
					if(v == 0){
						jin();
						GsnResultAndScoreInterface.this.requestFocus();
						
					}else{
						// 获取焦点
						inputnamejf.requestFocus();
					}
				}else{
					int c = JOptionPane.showConfirmDialog(GsnResultAndScoreInterface.this, "确定此名吗?");
					if(c == 0){
						// 给予加10长度
						StringBuffer sb = new StringBuffer();
						if(st.length() < 10){
							sb.append(st);
							while(sb.length() < 22){
								sb.append(" ");
							}
						}
						String scorest = resultjl.getText().toString();
						// 处理
						scorest = scorest.substring(scorest.indexOf("SCORE:") + 6, scorest.length());
						int score = Integer.valueOf(scorest);
						// 输出排行榜
						GsnRankBean gsn = new GsnRankBean();
						gsn.setName(sb.toString());
						gsn.setSocre(score);
						gsn.setDate(new Date().toLocaleString());
						
						gsin.outRank(gsn);
						// 再重新读
						gsin.readRank();
						
						jin();
						
						// 同时 面板获取焦点
						GsnResultAndScoreInterface.this.requestFocus();
						
						// 更新排行榜
						GsnBottomLayerInterface.gameRankJpanel.reAddArraylist();
						GsnBottomLayerInterface.gameRankJpanel.gsnleveldisjlist.setSelectedIndex(1);// 第一个选中
						GsnBottomLayerInterface.gameRankJpanel.gsnleveldisjlist.updateUI();
					}else{
						inputnamejf.requestFocus();
					}
				}
			}
		}
	}
	class GsnResultAndScoreKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			// 分数清空
			if(e.getKeyCode() == KeyEvent.VK_1){
				clearContext();
				GsnMainGameConstants.setDrawSize(5);
				GsnBottomLayerInterface.updateJPanelNotSave(GsnBottomLayerInterface.gameResultAndScoreJpanel,GsnBottomLayerInterface.gameLevelJpanel);
				GsnBottomLayerInterface.gameLevelJpanel.backSetSelctAndView(0);
				System.out.println("GsnResultAndScoreKeyLis按下2键");
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				clearContext();
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnResultAndScoreKeyLis按下ESC键");
			}
		}
	}
}
