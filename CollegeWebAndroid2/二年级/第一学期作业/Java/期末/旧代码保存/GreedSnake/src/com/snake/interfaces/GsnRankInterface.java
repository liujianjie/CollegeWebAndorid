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

// ���а�
public class GsnRankInterface extends JPanel{
	// jlist
	
	// ��������ʽ�ؿ�
	private JScrollPane jscrollpane;
	private JPanel jpanel;// ���label
	
	// ����Jlist
	private JLabel ranktipla,ranktiptwo;
	public ArrayList<Object> gsnleveldisarrlist;// ֻ�Ƿ���һ������
	public JList<Object> gsnleveldisjlist;
	public GsnEditMapRightOpBarListComBoxModel jlistmodel;
	
	public GsnRankInterface(){
		
		initview();
		setLayout(null);
		this.setBackground(Color.CYAN);
		this.setSize(new Dimension(GsnInterfaceParam.INTERFACEWIDTH, GsnInterfaceParam.INTERFACEHEIGHT));// 640 * 480 �̶���С
		
		// �����¼�
		this.addKeyListener(new GsnRankKeyLis());
	}
	// ��ʼ�����
	public void initview(){
		ranktipla = new JLabel("��          ��        ��", JLabel.CENTER);
		gsnleveldisarrlist = new ArrayList<Object>();
		jlistmodel = new GsnEditMapRightOpBarListComBoxModel(gsnleveldisarrlist);
		gsnleveldisjlist = new JList<Object>(jlistmodel);
		// ���ò��ɵ�� ����ʧȥ����
		gsnleveldisjlist.setFocusable(false);
		
		reAddArraylist();
		
		//�رպ��� ������
		jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		// ����
		jpanel.add(ranktipla, BorderLayout.NORTH);
		// ��������
		jpanel.add(gsnleveldisjlist, BorderLayout.CENTER);
		
		// Ҫ��jpanel����������С�������viewpoint
		jscrollpane = new JScrollPane(jpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollpane.setPreferredSize(new Dimension(220, 410));
		
		jscrollpane.setBounds(140, 50, 360, 410);
		// ��ӵ����
		add(jscrollpane);
	}
	// ���¶�ȡ���list
	public void reAddArraylist(){
		gsnleveldisarrlist.clear();
		String s = "����----------------------------����-----------------------------------ʱ��";
		gsnleveldisarrlist.add(s);
		// ��С
		MaoPao();
		for(int i = 0; i < GsnMainGameConstants.gsnrankbeanarr.length; i++){
			gsnleveldisarrlist.add(GsnMainGameConstants.gsnrankbeanarr[i].getName()+"                   "+
						GsnMainGameConstants.gsnrankbeanarr[i].getSocre()+"                        "+
					GsnMainGameConstants.gsnrankbeanarr[i].getDate());
		}
	}
	// ����ǰһ���򵥵�ð������
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
	// ���̼��� 
	class GsnRankKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				GsnBottomLayerInterface.backLastJPanel();
				System.out.println("GsnRankKeyLis����VK_ESCAPE��");
			}
		}
	}
}
