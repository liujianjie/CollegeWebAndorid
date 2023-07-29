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

// �ɼ� �� ������
public class GsnResultAndScoreInterface extends JPanel{
	// score
	// ���ź�����ϲ������ģ�ƽ��
	JLabel resulttip;
	// ����ʧ��,PLAYER1ʤ��������ʤ�� �������ٶ��١���
	JLabel resultjl;
	// ����������
	JLabel inputjl;
	public JTextField inputnamejf;
	// tips2 ��1���¿�ʼ����2��ѡ�ؿ�����esc���������棬
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
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 �̶���С
		
		// �����¼�
		this.addKeyListener(new GsnResultAndScoreKeyLis());
	}
	public void initfont(){
		f = new Font("����", 1, 15);
	}
	public void initComp(){
		centerjp = new JPanel();
		centerjp.setOpaque(false);
		centerjp.setLayout(new GridLayout(4, 1));
		
		resulttip = new JLabel("",JLabel.CENTER);
		resultjl = new JLabel("",JLabel.CENTER);
		
		JPanel jp = new JPanel();
		jp.setBackground(Color.CYAN);// ��һ��
		inputjl = new JLabel("����������");
		inputnamejf = new JTextField(10);
		
		jp.add(inputjl);
		jp.add(inputnamejf);
		
		tips1 = new JLabel("tips2 ��1��ѡ�ؿ�����esc�ص����˵�",JLabel.CENTER);
		
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
	// ���ý����ʾ
	public void setResultString(String s1,String s2){
		resulttip.setText(s1);
		resultjl.setText(s2);
	}
	public boolean checkInput(){
		return false;
	}
	public void jin(){
		// ����jilist
		inputnamejf.setFocusable(false);// ʧȥ����
		inputnamejf.setEnabled(false);// ʧȥ
	}
	// ��ǩ�������
	public void clearContext(){
		// ����jilist
		inputnamejf.setText("");
		inputnamejf.setFocusable(true);
		inputnamejf.setEnabled(true);
		GsnResultAndScoreInterface.this.requestFocus();
	}
	// ��0�� �ǾͲ�Ҫ����
	public void ZeroScore(){
		// ����jilist
		inputnamejf.setFocusable(false);// ʧȥ����
		inputnamejf.setEnabled(false);// ʧȥ
	}
	// ���̼���
	class GsnResultAndScoreKeyLis2 extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				System.out.println("GsnResultAndScoreKeyLis����VK_ENTER��");
				// �ж��Ƿ���������
				String st = inputnamejf.getText().toString();
				if(st.trim().equals("") || st.length() > 10){
					int v = JOptionPane.showConfirmDialog(GsnResultAndScoreInterface.this, "�Ƿ񲻱��浱ǰ�ɼ�");
					if(v == 0){
						jin();
						GsnResultAndScoreInterface.this.requestFocus();
						
					}else{
						// ��ȡ����
						inputnamejf.requestFocus();
					}
				}else{
					int c = JOptionPane.showConfirmDialog(GsnResultAndScoreInterface.this, "ȷ��������?");
					if(c == 0){
						// �����10����
						StringBuffer sb = new StringBuffer();
						if(st.length() < 10){
							sb.append(st);
							while(sb.length() < 22){
								sb.append(" ");
							}
						}
						String scorest = resultjl.getText().toString();
						// ����
						scorest = scorest.substring(scorest.indexOf("SCORE:") + 6, scorest.length());
						int score = Integer.valueOf(scorest);
						// ������а�
						GsnRankBean gsn = new GsnRankBean();
						gsn.setName(sb.toString());
						gsn.setSocre(score);
						gsn.setDate(new Date().toLocaleString());
						
						gsin.outRank(gsn);
						// �����¶�
						gsin.readRank();
						
						jin();
						
						// ͬʱ ����ȡ����
						GsnResultAndScoreInterface.this.requestFocus();
						
						// �������а�
						GsnBottomLayerInterface.gameRankJpanel.reAddArraylist();
						GsnBottomLayerInterface.gameRankJpanel.gsnleveldisjlist.setSelectedIndex(1);// ��һ��ѡ��
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
			// �������
			if(e.getKeyCode() == KeyEvent.VK_1){
				clearContext();
				GsnMainGameConstants.setDrawSize(5);
				GsnBottomLayerInterface.updateJPanelNotSave(GsnBottomLayerInterface.gameResultAndScoreJpanel,GsnBottomLayerInterface.gameLevelJpanel);
				GsnBottomLayerInterface.gameLevelJpanel.backSetSelctAndView(0);
				System.out.println("GsnResultAndScoreKeyLis����2��");
			}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				clearContext();
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnResultAndScoreKeyLis����ESC��");
			}
		}
	}
}
