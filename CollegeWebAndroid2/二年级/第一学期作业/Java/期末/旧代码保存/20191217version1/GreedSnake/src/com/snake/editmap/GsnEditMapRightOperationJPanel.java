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

// �༭��ͼ�ұ߲������
public class GsnEditMapRightOperationJPanel extends JPanel{
	GsnEditmapInterface gsneminter;
	
	public JTabbedPane jtbpane;
	// ���������
	private JPanel basicoppanel,snakeoppanel,mapinfopanel,barrierpanel,crossnodepanel;
	// �ӿؼ�
	// ����������
	private int jbsize = 11;// �ؼ���С
	private JButton[] jbarr;
	
	// �ϰ����
	private int barjbsize = 3;
	private JButton[] barjbarr;
	private JButton baraddyesbt, baralterbt, bardelbt, barrunbt, barpausebt;
	// label������
	private JLabel barcurchooselb,barbarijlb,barhwlb,barwidelb,bardirlb,barspeedlb;
	private JTextField barbaritext,barbarjtext,barhtext,barwtext,barwidetext,barspeedtext;
	String bardirst[] = {"��","��", "��", "��"};
	private JComboBox<Object> bardirjcbox;
	// ѡ��������б� 
	public JComboBox<Object> barjcbox;
	// ���
	private ArrayList<String> barlist;
	private GsnEditMapRightOpBarListComBoxModel gsneditmapbarlistcbm;
	
	private int bardir = 0;// �����jcombobox��ȡ Ĭ��Ϊ��0
	
	// �ߵ��ӿؼ�
	String snakedirst[] = {"��","��", "��", "��"};
	String snakeplayerst[] = {"���1", "���2"};
	private JComboBox<Object> snakebox;
	private JComboBox<Object> snakedirbox;
	private JLabel snakecurchooselb, snakenodelb,snakeheadlb,snakedirlb;
	private JTextField snakenodetxt,snakeheaditext,snakeheadjtext;
	private JButton snakealterbt;
	
	// ��ͼ��Ϣ����ӿؼ� ��ʳ���beanһ���
	private JLabel foodlenglb;//
	private JTextField foodlengtext;
	private JLabel mapifauthornamelb,mapifmapnamelb,mapifpwdlb,mapifctimelb,mapiftipslb,mapifbarcountlb,mapiflevelorderlb;
	private JLabel mapifcrossnodecountlb;
	private JTextField mapifauthornametext,mapifmapnametext,mapifpwdtext,mapifctimetext,mapiftipstext,mapifbarcounttext,mapiflevelordertext;
	private JTextField mapifcrossnodecounttext;
//	private JButton mapifcf
	
	// ��Խ�ڵ�
	private int crossnodejbsize = 3;
	private JButton[] crossnodejbarr; 
	// label������
	private JLabel crossnodecurchooselb,crossnodefirstijlb,crossnodesecondijlb;
	private JTextField crossnodefirstitext,crossnodefirstjtext,crossnodeseconditext,crossnodesecondjtext;
	// ѡ��������б� 
	public JComboBox<Object> crossnodejcbox;
	// ���
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
	// ���������б��arraylist
	// ���һ������
	public void valueToBarList(){
		String st = gsneminter.gsnedmmgajpanel.MainGameMoveBarrierlength+"";
		barlist.add(st);
		// ���ҽ���ǰѡ������Ϊ��ǰ��
		barjcbox.setSelectedItem(st);
		barjcbox.updateUI();// �ؼ���
	}
	
	private void initView(){
		jtbpane = new JTabbedPane();
		basicoppanel = new JPanel();
		snakeoppanel = new JPanel();
		mapinfopanel = new JPanel();
		barrierpanel = new JPanel();
		crossnodepanel = new JPanel();
		
		jbarr = new JButton[jbsize];
		
		// �ϰ����
		barjbarr = new JButton[barjbsize];
		baraddyesbt = new JButton("���");
		baralterbt = new JButton("�޸�");
		bardelbt = new JButton("ɾ��");
		barrunbt = new JButton("����");
		barpausebt = new JButton("��ͣ");
		
		barlist = new ArrayList<String>();
		gsneditmapbarlistcbm = new GsnEditMapRightOpBarListComBoxModel(barlist);
		barjcbox = new JComboBox<Object>(gsneditmapbarlistcbm);
		
		bardirjcbox = new JComboBox<Object>(bardirst);
		// ��ǩ
		barcurchooselb = new JLabel("��ǰѡ��");
		barbarijlb = new JLabel("��ʼ���У�");
		barhwlb = new JLabel("�ߺͿ�");
		barwidelb = new JLabel("�ƶ���Χ��");
		bardirlb = new JLabel("�ƶ�����");
		barspeedlb = new JLabel("�ƶ��ٶȣ�");
		
		// �ı�
		barbaritext = new JTextField(3);
		barbarjtext = new JTextField(3);
		barhtext = new JTextField(3);
		barwtext = new JTextField(3);
		barwidetext = new JTextField(3);
		barspeedtext = new JTextField(3);
		
		// snake��
		snakebox = new  JComboBox<Object>(snakeplayerst);
		snakedirbox = new JComboBox<Object>(snakedirst);
		snakecurchooselb = new JLabel("��ǰѡ��");
		snakenodelb = new JLabel("�߽�");
		snakeheadlb = new JLabel("��ͷ����");
		snakedirlb = new JLabel("����");
		
		snakenodetxt = new JTextField(3);
		snakeheaditext = new JTextField(3);
		snakeheadjtext = new JTextField(3);
		
		snakealterbt = new JButton("�޸�");
		// �߽����ò��ɱ༭
		snakenodetxt.setEditable(false);
		
		// ��ͼ��Ϣ��
		foodlenglb = new JLabel("ʳ������");
		mapifauthornamelb = new JLabel("��������");
		mapifmapnamelb = new JLabel("��ͼ����");
		mapifpwdlb = new JLabel("��ͼ����");
		mapifctimelb = new JLabel("����ʱ��");
		mapiftipslb = new JLabel("��ͼ��Ҫ");
		mapifbarcountlb = new JLabel("�ϰ�����");
		mapifcrossnodecountlb = new JLabel("��Խ�ڵ�����");
		mapiflevelorderlb = new JLabel("�ȼ����");
		
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
		
		// ��Խ�ڵ�
		crossnodejbarr = new JButton[crossnodejbsize];
		crossnodecurchooselb = new JLabel("��ǰѡ��");
		crossnodefirstijlb = new JLabel("��һ��λ��");
		crossnodesecondijlb = new JLabel("�ڶ���λ��");
		
		crossnodefirstitext = new JTextField(3);
		crossnodefirstjtext = new JTextField(3);
		crossnodeseconditext = new JTextField(3);
		crossnodesecondjtext = new JTextField(3);
		
		crossnodelist = new ArrayList<String>();
		gsneditmapcrossnodelistcbm = new GsnEditMapRightOpBarListComBoxModel(crossnodelist);
		crossnodejcbox = new JComboBox<Object>(gsneditmapcrossnodelistcbm);
	}
	// ���ò���
	private void setLayoutOfPanle(){
		basicoppanel.setLayout(new GridLayout(jbsize, 1));
		barrierpanel.setLayout(new GridLayout(9, 1));
		snakeoppanel.setLayout(new GridLayout(5, 1));
		mapinfopanel.setLayout(new GridLayout(9, 1));
		crossnodepanel.setLayout(new GridLayout(4, 1));
	}
	// ���ô�С
	private void setPanelSize(){
		
	}
	// ��ӵ����
	private void addToPanel(){
		jtbpane.add(basicoppanel,"��������");
		jtbpane.add(mapinfopanel,"��ͼ��Ϣ");
		jtbpane.add(snakeoppanel,"��");
		jtbpane.add(barrierpanel,"�ϰ���");
		jtbpane.add(crossnodepanel,"��Խ�ڵ�");
		
		add(jtbpane);
		
		//����������
		for(int i = 0; i < jbarr.length; i++){
			jbarr[i] = new JButton();
			basicoppanel.add(jbarr[i]);
		}
		
		// �ϰ����
		// �����
		JPanel barjp1 = new JPanel();
		JPanel barjp2 = new JPanel();
		JPanel barjp3 = new JPanel();
		JPanel barjp4 = new JPanel();
		JPanel barjp5 = new JPanel();
		JPanel barjp6 = new JPanel();
		JPanel barjp7 = new JPanel();
		JPanel barjp8 = new JPanel();
		JPanel barjp9 = new JPanel();
		// ��һ��
		for(int i = 0; i < barjbarr.length; i++){
			barjbarr[i] = new JButton();
			barjp1.add(barjbarr[i]);
		}
		barjcbox.setSize(new Dimension(80,30));
		barjcbox.setPreferredSize(new Dimension(80,30));
		barjp2.add(barcurchooselb);
		barjp2.add(barjcbox);
		
		// �ڶ���
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
		
		// �ߵ�
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
		
		// ��ͼ��Ϣ��
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
		
		// ��Խ�ڵ�
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
	// ����ֵ
	private void setValueToCom(){
		// ��������
		jbarr[0].setText("���ޱ߽�");
		jbarr[1].setText("��Ϊǽ");
		jbarr[2].setText("ȡ��ǽ");
		jbarr[3].setText("���һ��ʳ��");
		jbarr[4].setText("��Ϊ�ƶ��ϰ�");
		jbarr[5].setText("��Ϊһ�鴩Խ��");
		jbarr[6].setText("��λ/����λ���");
		jbarr[7].setText("���沢�˳�");
		jbarr[8].setText("ȡ�����˳�");
		jbarr[9].setText("Ԥ��/�ָ�");
		jbarr[10].setText("�޸Ĳ��˳�");
		jbarr[10].setEnabled(false);
		
		// �ϰ���
		barjbarr[0].setText("ȫ������");
		barjbarr[1].setText("ȫ����ͣ");
		barjbarr[2].setText("ȫ��ɾ��");
		
		// ��Խ�ڵ�
		crossnodejbarr[0].setText("���");
		crossnodejbarr[1].setText("�޸�");
		crossnodejbarr[2].setText("ɾ��");
	}
	// ����
	private void setLisToCom(){
		GsnEditMapRightActionLis btlisone = new GsnEditMapRightActionLis();
		GsnEditMapRightOpJcomBoxLis itemlisone = new GsnEditMapRightOpJcomBoxLis();
		// ��������
		for(int i = 0; i < jbarr.length; i++){
			jbarr[i].addActionListener(btlisone);
		}
		
		// �ϰ����
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
		
		// �����
		snakedirbox.addItemListener(itemlisone);
		snakebox.addItemListener(itemlisone);
		snakealterbt.addActionListener(btlisone);
		
		// ��Խ�ڵ�
		for(int i = 0; i < crossnodejbarr.length; i++){
			crossnodejbarr[i].addActionListener(btlisone);
		}
		crossnodejcbox.addItemListener(itemlisone);
		
		
		// �����
		jtbpane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				gsneminter.gsnedmmgajpanel.requestFocus();
			}
		});
	}
	
	// ��Ԥѡ����Ϊ�ƶ��ϰ� ����ֵ ��������
	public void SetBarFromOrder(int start[], int end[]){
		// start[0] ���� x
		int calwidth,calheight;
		calheight = end[1] - start[1] + 1;
		calwidth = end[0] - start[0] + 1;
		barbaritext.setText(start[1]+"");
		barbarjtext.setText(start[0]+"");
		barhtext.setText(calheight+"");
		barwtext.setText(calwidth+"");
	}
	// ��������������Ĭ��ֵ 
	public void setDefaultValueToallPanl(){
		// �ϰ���list��ʼֵ
		setBarListDefault();
		// ��Խ�ڵ�list��ʼֵ
		setCrossNodeListDefault();
		setBarAttribute(null);
		setCrossNodeAttribute(null);
		// Ҫ�������һ Ĭ��ֵ ��Ϊ ���û����������ʱ��
		setSnakeTextValue(0);//���һ �±�Ϊ0
		// ���õ�ͼ��Ϣ��� ʱ�� ��ʳ���������ȼ���ţ�
		setMapInfoTextValue();
		// ����Ϊ�˲������Ĭ��ֵ
		barlastindex = -1;
		// �ָ���ť����
		setBtEnable();
		
		// ��list���
	}
	public void setMapInfoTextValue(){
		// ʱ��Ϊ��ǰ ȡ�����հɣ���
		mapifctimetext.setText(new Date().toLocaleString());// 
		// �ȼ��͵�ǰ��ͼ����
		mapiflevelordertext.setText((GsnMainGameConstants.gsngamemap.length+1)+"");
		// ��Ҫ
		mapiftipstext.setText("˵˵�㴴���ĵ�ͼ�ص�");
		// ����
		mapifpwdtext.setText(mapinfopawdtips);
		// ����
		mapifauthornametext.setText("������Ĵ���");
		mapifmapnametext.setText("level��"+(1 + GsnMainGameConstants.gsngamemap.length));
		// ������Ҫ���ݵ�ͼ�Ǳ༭���Ǵ������޸�
		// ʳ������ 
		setMapDefaultInfoFoodlength();
		setMapDefaultInfoGetBarCount();
		// ��Խ
		setMapDefaultInfoGetCrossNodeCount();
	}
	// �����½���ͼ��ʱ�� ���ص�ʱ��������Ĭ��
	
	// �õ��ؿ��ϰ�������
	public void setMapInfoGetBarCount(){
		// ������Ϸ����в��ǿ�ֵ�Ĵ�С
		int count = gsneminter.gsnedmmgajpanel.notNullBarListCount();
		mapifbarcounttext.setText(count+"");
	}
	// Ĭ���ϰ�������
	public void setMapDefaultInfoGetBarCount(){
		mapifbarcounttext.setText(0+"");
	}
	public void setMapDefaultInfoGetCrossNodeCount(){
		mapifcrossnodecounttext.setText(0+"");
	}
	// Ĭ��ʳ������
	public void setMapDefaultInfoFoodlength(){
		foodlengtext.setText("2");
	}
	// ������Ϸ����ʳ������ ��ȡ��
	public void setMapInfoFoodlength(){
		foodlengtext.setText(gsneminter.gsnedmmgajpanel.MainGamefoodlength+"");
	}
	// ��list��� �����µ�
	public void setBarListDefault(){
		barlist.clear();
		barlist.add("");
		barjcbox.setSelectedIndex(0);
		barjcbox.updateUI();
	}
	// ��Խ�ڵ����start------------------
	// ��list��� �����µ�
	public void setCrossNodeListDefault(){
		crossnodelist.clear();
		crossnodelist.add("");
		crossnodejcbox.setSelectedIndex(0);
		crossnodejcbox.updateUI();
	}
	// ��Խ�ڵ����end------------------
	// bean
	GsnMapBarrierMoveBean gmbarbean;
	GsnMapCrossNodeBean gmcrossnodebean;
	class GsnEditMapRightActionLis implements ActionListener{
		Object obj;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			obj = e.getSource();
			// ��������
			// �б߽�
			if(obj == jbarr[0])
			{
				// ��ȡ����ѡ����
				gsneminter.recoverMapData();
				// ���ɱ߽�
				gsneminter.setBorder();
				// ����game��沢�滭
				gsneminter.gsnedmmgajpanel.initMapData();
				gsneminter.gsnedmmgajpanel.repaint();
			}
			if(obj == jbarr[1])
			{
				// ����ǽ
//				gsneminter.setOrderToWall(gsneminter.gsnedmmgajpanel.start,gsneminter.gsnedmmgajpanel.end);
				gsneminter.setOrderToWall();
				// ����game��沢�滭
				gsneminter.gsnedmmgajpanel.initMapData();
				gsneminter.gsnedmmgajpanel.repaint();
			}
			if(obj == jbarr[2]){
				// ȡ��ǽ
				gsneminter.cancelOrderOfWall();
				// ����game��沢�滭
				gsneminter.gsnedmmgajpanel.initMapData();
				gsneminter.gsnedmmgajpanel.repaint();
			}
			// ���ʳ��
			if(obj == jbarr[3]){
				// ���ܳ�20
				if(gsneminter.gsnedmmgajpanel.MainGamefoodlength + 1 > 20){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "ʳ�� 2~20");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				
				// ����ʳ������ ����Ҫ������
				gsneminter.gsnedmmgajpanel.foodDead();
				gsneminter.gsnedmmgajpanel.MainGamefoodlength++;// �����������½�
				gsneminter.gsnedmmgajpanel.foodNew();
				// ҲҪ��mapbean
				gsneminter.gsneditmapbean.gsmfoodbean.foodlength = gsneminter.gsnedmmgajpanel.MainGamefoodlength;
				// ������ֵ��map
				setMapInfoFoodlength();
			}
			// ����ƶ��ϰ� 
			// ��Ҫ�ƶ��ϰ���ѡ�ѡ��
			if(obj == jbarr[4]){
				jtbpane.setSelectedIndex(3);
				// ���ϰ��������б�Ϊ0
				barjcbox.setSelectedIndex(0);
				// ��ֵ����ȥ��Ҫ���㷶Χ 
				SetBarFromOrder(gsneminter.gsnedmmgajpanel.start,gsneminter.gsnedmmgajpanel.end);
			}
			if(obj == jbarr[5]){
				// �ж�ѡ���Ƿ񳬹�2�� ����������λ��
				int size = gsneminter.gsnedmmgajpanel.crossnodequ.size();
				if(size == 2){
					boolean bln = setCrossNodeFromQue();
					if(bln){
						// ���һ���ϰ����list �������
						gsneminter.gsnedmmgajpanel.addOneCrossNodeTolist(gmcrossnodebean);
						// ����һ������
						gsneminter.gsnedmmgajpanel.addNewCrossListLength();
						// ���ҵ�ǰ��ѡ��������б�Ҫ���һ 
						valueToCrossNodeList();
						// ����ͼ��Ϣ�õ�����
						setMapInfoGetCrossNodeCount();
						// �ػ�
						gsneminter.gsnedmmgajpanel.repaint();
					}
				}else{
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "ֻ��ѡ����λ��");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
			}
			// ��λ���
			if(obj == jbarr[6]){
				gsneminter.gsnedmmgajpanel.setIsPosMouse();
			}
			// ���沢���Ƴ� �����޸Ĳ��˳���
			if(obj == jbarr[7]){
				// ����ͼֵ�Ƿ����
				boolean isok = checkMapInfoTextIsOk();
				// ���maptxt
				if(isok){
					int val = JOptionPane.showConfirmDialog(GsnEditMapRightOperationJPanel.this, "ȷ��������ǰ��ͼ����������������");
					if(val == 0){
						editMapExit();
						// Ҫ�ȴ���bug �����Ԥѡ��ͼ�ľͻָ�Ϊ0
						
						gsneminter.outNewMap();
						// ������һ��
						GsnBottomLayerInterface.backLastJPanel();
					}
				}
			}
			// ֱ���˳� 
			if(obj == jbarr[8]){
				// ������һ��
				int val = JOptionPane.showConfirmDialog(GsnEditMapRightOperationJPanel.this, "ȷ���˳���");
				if(val == 0){
					editMapExit();
					// ��ԭʼ��ͼ�лָ� ��̬��ͼ ��ΪԤ����ͼ����dynamic���� ������Ĳ�����Ӱ��Ԥ��
					GsnMainGameConstants.setDynamicMapData(GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].mapdata);
					GsnBottomLayerInterface.backLastJPanel();
				}
			}
			// Ԥ���ָ�
			if(obj == jbarr[9]){
				if(!gsneminter.mapTest){
					gsneminter.gsnedmmgajpanel.EditMapPreviewStartDraw();
				}else{
					gsneminter.gsnedmmgajpanel.EditMapPreviewStartRecover();
				}
			}
			// �����˳� �����޸� Ҫ�ҵ�λ���滻��Ҫ��ȫ���������ˣ�����
			if(obj == jbarr[10]){
				// ����С��5
				// ����ͼֵ�Ƿ����
				boolean isok = checkMapInfoTextIsOk();
				if(isok){
					// ��� ֮ǰ Ҫת��Ϊchar�ַ� ���һ�һ�������������
					int val = JOptionPane.showConfirmDialog(GsnEditMapRightOperationJPanel.this, "ȷ�������޸Ĳ��˳���");
					if(val == 0){
						editMapExit();
						// û�а취�� ֻ��һ���µ� һ���ɵģ��ɵ�map����ѯ��string��λ��ɾ�����µ�map�����
						gsneminter.alterMap();
						System.out.println(mapToStr());
						// ������һ��
						GsnBottomLayerInterface.backLastJPanel();
					}
				}
			}
			
			// �ϰ���İ�ť����
			// ȫ������
			if(obj == barjbarr[0]){
				gsneminter.gsnedmmgajpanel.allBarlisRun();
			}
			// ȫ����ͣ
			if(obj == barjbarr[1]){
				gsneminter.gsnedmmgajpanel.allBarlisPause();
			}
			// ȫ��ɾ��
			if(obj == barjbarr[2]){
				gsneminter.gsnedmmgajpanel.allBarlisDelete();
				// �������
				setBarAttribute(null);
				// ����ͼ��Ϣ�õ��ϰ�������
				setMapInfoGetBarCount();
			}
			if(obj == baraddyesbt){
				// ���ݵ�ǰ�Ƿ�ѡ��һ���ƶ��ϰ� �ǵĻ�����ʾ ��ȡ��ѡ��
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex >= 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "�㵱ǰѡ����һ���ϰ�����޸ļ��ɣ����߲�ѡ���ϰ���");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				boolean isaddbln = commonWayOfAddAndAlter();
				if(isaddbln){// �ɹ��˲ż�
					// ���һ���ϰ����list ���� ������ 
					gsneminter.gsnedmmgajpanel.addOneBarTolist(gmbarbean);
					gsneminter.gsnedmmgajpanel.isRepeatPaintBar = true;
					// �ػ�
					gsneminter.gsnedmmgajpanel.repaint();
					// ����һ������
					gsneminter.gsnedmmgajpanel.addNewBarirrLength();
					// ���ҵ�ǰ��ѡ��������б�Ҫ���һ 
					valueToBarList();
					// ����ͼ��Ϣ�õ��ϰ�������
					setMapInfoGetBarCount();
				}
			}
			if(obj == baralterbt){// ������޸� Ҫ�޸���list�е�����
				// �Ȼ�ȡ�±꣬���û��ѡ�±���ʾ
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "Ҫ�޸�ǰ����ѡ��һ���ϰ���");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				// ��Ҫ��ֹͣ��
				// ���bean �޸�
				boolean isalterbln = commonWayOfAddAndAlter();
				if(isalterbln){// ������ȷ
					// ���һ���ϰ����list ���� ������ 
					gsneminter.gsnedmmgajpanel.alterOneBarList(gmbarbean, curindex);
					gsneminter.gsnedmmgajpanel.isRepeatPaintBar = true;
					
					// ��Ҫ���������ϰ�������  Ҫ���ں���
					// ����ͼ��Ϣ�õ��ϰ�������
					setMapInfoGetBarCount();
				}
			}
			// ɾ��
			if(obj == bardelbt){
				// ��ȡ�±� ��������Ϊnull
				// �Ȼ�ȡ�±꣬���û��ѡ�±���ʾ
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "Ҫɾ��ǰ����ѡ��һ���ϰ���");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				gsneminter.gsnedmmgajpanel.giveNullBarTolist(curindex);
				// ��������Ҫ���
				setBarAttribute(null);
				// ����ͼ��Ϣ�õ��ϰ�������
				setMapInfoGetBarCount();
			}
			// ��ͣ
			if(barpausebt == obj){
				// ���ݵ�ǰ�±�����ͣ ��Ȼ�����ǿյ�
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "Ҫ��ͣǰ����ѡ��һ���ϰ���");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				// ֱ�����ð�
				gsneminter.gsnedmmgajpanel.setPauseOrRun(curindex, false);
			}
			// ����
			if(barrunbt == obj){
				// ���ݵ�ǰ�±�����ͣ ��Ȼ�����ǿյ�
				int curindex = barjcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "Ҫ����ǰ����ѡ��һ���ϰ���");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				// ֱ�����ð�
				gsneminter.gsnedmmgajpanel.setPauseOrRun(curindex, true);
				// ����Ҫ��һ�� ���Ҫ���Ļ�����ô��Ҫ�����滭
				gsneminter.gsnedmmgajpanel.isRepeatPaintBar = true;
				gsneminter.gsnedmmgajpanel.repaint();
			}
			
			// �����İ�ť
			if(obj == snakealterbt){
				// ��ȡ��ǰѡ���ߵ��±�
				int snakeplayerindex = snakebox.getSelectedIndex();
				setSnakeInfoByText(snakeplayerindex);
			}
			if(gsneminter.mapTest){
				// ���� ��̬��ͼֵ����ΪԤ����ʼ�� ����Ϊ�ߵĴ����ǿ���dymatic��ͬ����������
				gsneminter.setDynamicMapdata();
				// ������ ���ҵ�testΪtrue��������������
				gsneminter.gsnedmmgajpanel.requestFocus();
			}
			
			// ��Խ�ڵ�������
			if(obj == crossnodejbarr[0]){
				// ���ݵ�ǰ�Ƿ�ѡ��һ���ƶ��ϰ� �ǵĻ�����ʾ ��ȡ��ѡ��
				int curindex = crossnodejcbox.getSelectedIndex() - 1;
				if(curindex >= 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "�㵱ǰѡ����һ����Խ�ڵ㣬���޸ļ��ɣ����߲�ѡ��");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				boolean isaddbln = commonWayOfAddAndAlterForCrossNodeList();
				if(isaddbln){// �ɹ��˲ż�
					// ���һ���ϰ����list �������
					gsneminter.gsnedmmgajpanel.addOneCrossNodeTolist(gmcrossnodebean);
					// ����һ������
					gsneminter.gsnedmmgajpanel.addNewCrossListLength();
					// ���ҵ�ǰ��ѡ��������б�Ҫ���һ 
					valueToCrossNodeList();
					// ����ͼ��Ϣ�õ�����
					setMapInfoGetCrossNodeCount();
					// �ػ�
					gsneminter.gsnedmmgajpanel.repaint();
					// ���queue
					gsneminter.gsnedmmgajpanel.crossnodequ.clear();
				}
			}
			if(obj == crossnodejbarr[1]){
				// �Ȼ�ȡ�±꣬���û��ѡ�±���ʾ
				int curindex = crossnodejcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "Ҫ�޸�ǰ����ѡ��һ���ϰ���");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				// ���bean �޸�
				boolean isalterbln = commonWayOfAddAndAlterForCrossNodeList();
				if(isalterbln){// ������ȷ
					gsneminter.gsnedmmgajpanel.alterOneCrossNodeList(gmcrossnodebean, curindex);
					// Ҫɾ����ͼԭ���ĵ�ͼֵ���������µ�ͼֵ
					setMapInfoGetCrossNodeCount();
					// �ػ�
					gsneminter.gsnedmmgajpanel.repaint();
				}
			}
			if(obj == crossnodejbarr[2]){
				// ��ȡ�±� ��������Ϊnull
				// �Ȼ�ȡ�±꣬���û��ѡ�±���ʾ
				int curindex = crossnodejcbox.getSelectedIndex() - 1;
				if(curindex < 0){
					JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "Ҫɾ��ǰ����ѡ��һ���ϰ���");
//					gsneminter.gsnedmmgajpanel.requestFocus();
					return;
				}
				gsneminter.gsnedmmgajpanel.giveNullCrossNodeTolist(curindex);
				// ��������Ҫ���
				setCrossNodeAttribute(null);
				// ����ͼ��Ϣ�õ��ϰ�������
				setMapInfoGetCrossNodeCount();
				// �ػ�
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
				sb.append((char)(GsnMainGameConstants.dynamicmapdata[m][n] + '0'));// Ҫת��Ϊ�ַ�
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	// ��ͼ��Ĭ��ֵ
	String mapinfopawdtips = "����Ҫ���޸ĵ�ͼ��Ҫ��ͼ����Ŷ";
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
		// 1.���ܿ�
		if(foodlength.equals("") || 
				gsnmifb.authorname.equals("") || gsnmifb.mapname.equals("") || 
				gsnmifb.mappwd.equals("") || gsnmifb.creationtime.equals("") || 
				gsnmifb.tips.equals("")){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��ͼ��Ϣ����Ϊ��");
			jtbpane.setSelectedIndex(1);
			return false;
		}
		// 2.���ܴ�
		gsnfoodbean.foodlength = Integer.valueOf(foodlength);
		if(gsnfoodbean.foodlength > 20 || gsnfoodbean.foodlength < 2){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "ʳ��������2 ~ 20֮��");
			jtbpane.setSelectedIndex(1);
			return false;
		}
		if(gsnmifb.barcount > 20){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "�ϰ����������ɳ���20��");
			jtbpane.setSelectedIndex(2);
			return false;
		}
		if(gsnmifb.crossnodecount > 15){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��Խ�ڵ㲻�ɳ���15��");
			jtbpane.setSelectedIndex(4);
			return false;
		}
		// 3.���ܳ��ַ�
		if(gsnmifb.authorname.length() > 20 || gsnmifb.mapname.length() > 20 || 
				gsnmifb.mappwd.length() > 20|| 
				gsnmifb.tips.length() > 20 ){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��ͼ��Ϣ���ַ����Ȳ��ɳ���20��");
			jtbpane.setSelectedIndex(1);
			return false;
		}
		// ����һ��Ҫ����
		if(gsnmifb.mappwd.equals(mapinfopawdtips)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��������������");
			jtbpane.setSelectedIndex(1);
			mapifpwdtext.requestFocus();
			return false;
		}
		// ����Ҫ����� mapinfbean,����Ҫ��������
		gsneminter.setGsnEditMapBean(gsnmifb,gsnfoodbean);
		return true;
	}
	public void setSnakeInfoByText(int snakeplayerindex){
		String headist,headjst;
		int dirint;
		headist = snakeheaditext.getText().toString();
		headjst = snakeheadjtext.getText().toString();
		dirint = snakedirbox.getSelectedIndex();// ����
		
		// ����Ϊ�� 
		if(headist.trim().equals("") || headjst.trim().equals("")){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��ֵ����Ϊ��");
			return;
		}
		// ����Ϊ�ַ�
		// Ҫ������
		if(!GsnTestIsNumClass.isNumeric(headist) || !GsnTestIsNumClass.isNumeric(headjst)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��ֵ��������ĸ");
			return;
		}
		// ͷ����Խ��
		
		// ����Խ��
		boolean bln = calSnakeByText(snakeplayerindex, Integer.valueOf(headist), Integer.valueOf(headjst), dirint);
		if(bln){
			// ����ʧ����ΪԽ��
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��ɵ��߽ڲ���Խ��");
			return;
		}
	}
	// ����ͷ���ͽڵ�ͷ���ȷ���߽� �������õ�ͼֵ
	// �����Ƿ�Խ��
	public boolean calSnakeByText(int player,int headi, int headj, int dir){
		int ai[] = new int[2];
		int aj[] = new int[2];
		// �ȱ���
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
		// �ж��Ƿ�Խ��
		if(ai[0] < 0 || ai[0] > 40 || ai[1] < 0 || ai[1] > 40 ||
				aj[0] < 0 || aj[0] > 59 || aj[1] < 0 || aj[1] > 59){
			return true;
		}
		// �������bean����� �������snake ����ʼ����Ȼ���ٸ���Ϸ���
		GsnMapSnakeBean gsnamapsnake = new GsnMapSnakeBean();
		gsnamapsnake.snmapdirection = dir;
		gsnamapsnake.snmapi[0] = ai[0];
		gsnamapsnake.snmapj[0] = aj[0];
		gsnamapsnake.snmapi[1] = ai[1];
		gsnamapsnake.snmapj[1] = aj[1];
		// �����صĴ��󣡣��������������߽�û������ ���´���
		gsnamapsnake.snnode = 2;
		// ������
		gsneminter.gsneditmapbean.gsmsnakebean[player] = gsnamapsnake;
		// �����ͼ��ԭ����λ��
		gsneminter.gsnedmmgajpanel.deleteSnakeYuanZhi(player);
		// ���� ��Ϸ��� λ��
		gsneminter.gsnedmmgajpanel.setRunSnakePos();
		// ���µ�ͼֵ
		gsneminter.gsnedmmgajpanel.fromSnakePosSetVal();
		// ���»滭
		gsneminter.gsnedmmgajpanel.repaint();
		return false;
	}
	// ������Ҽ��������ı���ֵ
	public void setSnakeTextValue(int player){
		snakenodetxt.setText("2");// �߽�Ĭ��Ϊ2�Ȳ��ɸı�
//		snakeheaditext.setText(gsneminter.gsnedmmgajpanel.gsnsnake[player].snactuali[0]+"");
//		snakeheadjtext.setText(gsneminter.gsnedmmgajpanel.gsnsnake[player].snactualj[0]+"");
//		snakedirbox.setSelectedIndex(gsneminter.gsnedmmgajpanel.gsnsnake[player].direction);
		
		snakeheaditext.setText(gsneminter.gsneditmapbean.gsmsnakebean[player].snmapi[0]+"");
		snakeheadjtext.setText(gsneminter.gsneditmapbean.gsmsnakebean[player].snmapj[0]+"");
		snakedirbox.setSelectedIndex(gsneminter.gsneditmapbean.gsmsnakebean[player].snmapdirection);
	}
	// ������ļ���
	String bardirstperse = "";
	int barlastindex = -1;//��¼��ѡ�����һ���ϰ����±� Ϊ�˻ָ���ɫ
	class GsnEditMapRightOpJcomBoxLis implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			// ������ϰ��������б�
			if(e.getSource() == bardirjcbox){
				// ��ȡ�±� �� bardir
				bardirstperse = e.getItem().toString();
				switch (bardirstperse) {
					case "��":
						bardir = 0;
						break;
					case "��":
						bardir = 1;
						break;
					case "��":
						bardir = 2;
						break;
					case "��":
						bardir = 3;
						break;
				default:
					break;
				}
			}
			// �����ѡ��ǰ�����б�
			if(e.getSource() == barjcbox){
				// ���Ŀ��ֵ ,������Ϸ����л�ȡ��movebean�� Ȼ������
				// Ҫ��ȥ1 ��Ϊ ��һ��Ϊ�գ�Ҫ������������ҿ��ܲ�̫��
				int index = barjcbox.getSelectedIndex() - 1;
				if(index < 0){
					// û��ѡΪ��
					setBarAttribute(null);
					// �ָ���ɫ
					if(barlastindex != -1){
						gsneminter.gsnedmmgajpanel.setisDrawColorForBar(barlastindex, false);
						// ��Ϊ�����ϰ��ﱻ�����Ȼ�󲻶�����������������ɫ��ȥ �Ǳ߾�Ҳ�����ƶ���
						gsneminter.gsnedmmgajpanel.setBarOneMoveByIndex(barlastindex);
						barlastindex = -1;//������һ��δѡ
					}
				}else{
					// ����ʱ��ͽ��лָ���һ����ɫ ��������ѡ����ɫ-1������һ��δ��
					if(barlastindex != - 1){
						gsneminter.gsnedmmgajpanel.setisDrawColorForBar(barlastindex, false);
						// ��Ϊ�����ϰ��ﱻ�����Ȼ�󲻶�����������������ɫ��ȥ �Ǳ߾�Ҳ�����ƶ���
						gsneminter.gsnedmmgajpanel.setBarOneMoveByIndex(barlastindex);
					}
					barlastindex = index;
					// ���Ҹ������б��б�ѡ���������ɫ
					gsneminter.gsnedmmgajpanel.setisDrawColorForBar(index, true);
					GsnMainGameMoveBarrier gsnbarbean = gsneminter.gsnedmmgajpanel.getNodeByIndexOfBarList(index);
					setBarAttribute(gsnbarbean);
					gsneminter.gsnedmmgajpanel.repaint();
					// ���Ϊ�գ����ҵ�ͼ��ѡ�˵� ����0000������ֵ
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
				// ���� ��̬��ͼֵ����ΪԤ����ʼ��
				gsneminter.setDynamicMapdata();
				// ������ ���ҵ�testΪtrue��������������
				gsneminter.gsnedmmgajpanel.requestFocus();
			}
			// ����� ��Խitem
			if(e.getSource() == crossnodejcbox){
				// ���Ŀ��ֵ ,������Ϸ����л�ȡ��movebean�� Ȼ������
				// Ҫ��ȥ1 ��Ϊ ��һ��Ϊ�գ�Ҫ������������ҿ��ܲ�̫��
				int index = crossnodejcbox.getSelectedIndex() - 1;
				if(index < 0){
					// û��ѡΪ��
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
	// �ϰ������� ��Ӻ��޸��жϵ�ͨ�÷���
	public boolean commonWayOfAddAndAlter(){
		// �ϰ����
		String barist,barjst,barwidthst,barheightst,barwidest,barspeedst;
		int bari,barj,barwidth,barheight,barwide,barspeed;
		// ��ȡ�����ֵ Ȼ����ӵ���Ϸ���������У���������һ������
		// ����ֻҪ��������ȡ 
		barist = barbaritext.getText().toString();
		barjst = barbarjtext.getText().toString();
		barheightst = barhtext.getText().toString();
		barwidthst = barwtext.getText().toString();
		barwidest = barwidetext.getText().toString();
		barspeedst = barspeedtext.getText().toString();
		// ��Ϊ��
		if(barist.trim().equals("") || barjst.trim().equals("") ||barheightst.trim().equals("")
				||barwidthst.trim().equals("") ||barspeedst.trim().equals("") 
				||barwidest.trim().equals("")){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "ֵ����Ϊ��");
			return false;
		}
		// Ҫ������
		if(!GsnTestIsNumClass.isNumeric(barist) || !GsnTestIsNumClass.isNumeric(barjst)||
				!GsnTestIsNumClass.isNumeric(barheightst) || !GsnTestIsNumClass.isNumeric(barwidthst) ||
				!GsnTestIsNumClass.isNumeric(barspeedst)||
				!GsnTestIsNumClass.isNumeric(barwidest)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��������ĸ");
			return false;
		}
		// ת��
		bari = Integer.valueOf(barist);
		barj = Integer.valueOf(barjst);
		barheight = Integer.valueOf(barheightst);
		barwidth = Integer.valueOf(barwidthst);
		barspeed = Integer.valueOf(barspeedst);
		barwide = Integer.valueOf(barwidest);
		// ���Ѳ�Ҫ̫��
		if(bari < 0 || bari > 41){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "bari Ӧ�� 1 ~ 40 ֮��");
			return false;
		}
		if(barj < 0 || barj > 60){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "bari Ӧ�� 1 ~ 59֮��");
			return false;
		}
		if(bari + barheight > 41){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "����ĸ߶�ռ��  ���ܳ��� 41 ");
			return false;
		}
		if(barj + barwidth > 60){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "����Ŀ��ռ��  ���ܳ��� 60");
			return false;
		}
		if(barspeed < 100 || barspeed > 2000){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "�ٶ�Ӧ�� 100 ~ 2000֮��");
			return false;
		}
		// ��Ҫ�ж��Ƿ�Ϸ������ǹ������� �ƶ���ȥ ������ǽ ��������  �Լ��߶ȿ�� ��û��Խ�� �����ж���
		
		// ����ֵ��ȥ
		gmbarbean = new GsnMapBarrierMoveBean();
		gmbarbean.bari = bari;
		gmbarbean.barj = barj;
		gmbarbean.barheight = barheight;
		gmbarbean.barwidth = barwidth;
		gmbarbean.barspeed = barspeed;
		gmbarbean.barwide = barwide;// ���˴� û�и���Χ һֱ���в�����
		
		gmbarbean.bardir = bardir;

		System.out.println("gmbarbean.bardir:"+barwide);
		// �������ߵ�λ��
		if(isTakeSnakePos(gmbarbean)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "���跶Χ�����߳����� �����µ���");
			return false;
		}
		// �ƶ���ʱ����Խ��
		if(isMoveOverBoundary(gmbarbean)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "�ƶ���ΧԽ�� �����µ���");
			return false;
		}
		// ��ʱ���Ǵӻ����������� ��Ҫ��Ԥѡ��Χ�ָ� ��ӳɹ���
		gsneminter.cancelOrderOfWall();// ȡ��ǽ ��Ϊ�Ǹ���49�������ģ�������Ҫ����ӳɹ�ǰ��ɣ���Ϊ�ϰ�������ֵΪ1
		// ����game��沢�滭
		gsneminter.gsnedmmgajpanel.initMapData();
		return true;
	}
	// �����ϰ�������
	public void setBarAttribute(GsnMainGameMoveBarrier gsnbarbean){
		if(gsnbarbean == null){
			barbaritext.setText("");
			barbarjtext.setText("");
			barhtext.setText("");
			barwtext.setText("");
			barwidetext.setText("");
			barspeedtext.setText("");
			// ����Ĭ��Ϊ��
			bardirjcbox.setSelectedIndex(0);
		}else{
			barbaritext.setText(gsnbarbean.gsnmbarbean.bari+"");
			barbarjtext.setText(gsnbarbean.gsnmbarbean.barj+"");
			barhtext.setText(gsnbarbean.gsnmbarbean.barheight+"");
			barwtext.setText(gsnbarbean.gsnmbarbean.barwidth+"");
			barwidetext.setText(gsnbarbean.gsnmbarbean.barwide+"");
			barspeedtext.setText(gsnbarbean.gsnmbarbean.barspeed+"");
			// ����ı�
			bardirjcbox.setSelectedIndex(gsnbarbean.gsnmbarbean.bardir);
		}
	}
	// ���ñ߽� Ҫ��Ҫ�ж���û���ߡ�
	// �ƶ��ϰ���ⷽ��
	// �жϵ�ͼ���Ƿ����ߵĴ����Ǿ���ʾ
	public boolean isTakeSnakePos(GsnMapBarrierMoveBean bean){
		// ��ȡ�ƶ�����Χ����
		int bari = bean.bari, barj = bean.barj;
		for(int i = 0; i < bean.barheight; i++){
			// ���Ͻǽڵ��i
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
	// �ж��ƶ���ʱ���Ƿ�Խ�� ���ݷ���Χ
	public boolean isMoveOverBoundary(GsnMapBarrierMoveBean bean){
		// ��ȡ�ƶ�����Χ����
		int bari = bean.bari, barj = bean.barj;
		switch (bean.bardir) {
			case 0:
				// ����
				if(bari - bean.barwide < 0){
					return true;
				}
				break;
			case 1:
				// ����ʱ
				if(bari + bean.barheight - 1 + bean.barwide > 40){
					return true;
				}
				break;
			case 2:
				// ����ʱ
				if(barj - bean.barwide < 0){
					return true;
				}
				break;
			case 3:
				// ����ʱ
				if(barj + bean.barwidth - 1 + bean.barwide > 59){
					return true;
				}
				break;				
			default:
				break;
		}
		return false;
	}
	// ���¼��ص�ͼ��ʱ����Ҫ����Ĭ��ֵ��������start------------
	public void setSnakeBybean(GsnMapSnakeBean gsnbean[]){
		snakebox.setSelectedIndex(0);// ѡ�оͻ���°� // ����
		setSnakeTextValue(0);// ���ô������
//		setSnakeTextValue(1);
	}
	public void Alter(){
		setBtEnable();
		setMapInfoBybean(gsneminter.gsneditmapbean);
		setBarBoxIndexOfAlter(gsneminter.gsneditmapbean);
		setSnakeBybean(gsneminter.gsneditmapbean.gsmsnakebean);// 
		setCrossCodeBoxIndexOfAlter(gsneminter.gsneditmapbean);
		// ����Ĭ��ֵ
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
		// �ȼ��͵�ǰ��ͼ����
		mapiflevelordertext.setText(map.gsminfobean.levelorder+"");
		// ��Ҫ
		mapiftipstext.setText(map.gsminfobean.tips);
		// ����
		mapifpwdtext.setText(map.gsminfobean.mappwd);
		mapifbarcounttext.setText(map.gsminfobean.barcount+"");
		foodlengtext.setText(map.gsmfoodbean.foodlength+"");
		mapifcrossnodecounttext.setText(map.gsminfobean.crossnodecount+"");
	}
	// �����ƶ����ϰ����ֵ ���±���Щ
	public void setBarBoxIndexOfAlter(GsnMapBean map){// �����ϰ�����±�
		// �����
		barlist.clear();
		// Ҫ��һ��Ĭ�ϵ�
		barlist.add("");
		for(int i = 0; i < map.gsminfobean.barcount; i++){
			barlist.add(i+1+"");
		}
		// Ҫ����
		barjcbox.updateUI();
	}
	// ���¼��ص�ͼ��ʱ����Ҫ����Ĭ��ֵ��������end------------
	
	
	// ������������
	public void setSnakeTextValue(){
		int index = snakebox.getSelectedIndex();
		setSnakeTextValue(index);
	}
	
	
	// ��Խ�ڵ����start-----------------
	public boolean setCrossNodeFromQue(){// ������ȡ������λ�� ���
		int fist[] = gsneminter.gsnedmmgajpanel.crossnodequ.poll();
		int second[] = gsneminter.gsnedmmgajpanel.crossnodequ.poll();
		
		// ����ֵ��ȥ
		gmcrossnodebean = new GsnMapCrossNodeBean();
		gmcrossnodebean.firstpos[0] = fist[0];
		gmcrossnodebean.firstpos[1] = fist[1];
		gmcrossnodebean.secondpos[0] = second[0];
		gmcrossnodebean.secondpos[1] = second[1];
		
		// �������ߵ�λ��
		if(isTakeSnakePosForCrossNode(gmcrossnodebean)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "���跶Χ�������������µ���");
			return false;
		}
		
		// ��ʱ���Ǵӻ����������� ��Ҫ��Ԥѡ��Χ�ָ� ��ӳɹ���
		gsneminter.cancelOrderOfWall();//
		// ����game��沢�滭
		gsneminter.gsnedmmgajpanel.initMapData();
		return true;
	}
	// ��Խ�ڵ����� ��Ӻ��޸��жϵ�ͨ�÷���
	public boolean commonWayOfAddAndAlterForCrossNodeList(){
		String firstist,firstjst,secondeist,secondejst;
		int firsti,firstj,secondei,secondej;
		// ��ȡ�����ֵ Ȼ����ӵ���Ϸ���������У���������һ������
		// ����ֻҪ��������ȡ 
		firstist = crossnodefirstitext.getText().toString();
		firstjst = crossnodefirstjtext.getText().toString();
		secondeist = crossnodeseconditext.getText().toString();
		secondejst = crossnodesecondjtext.getText().toString();
		// ��Ϊ��
		if(firstist.trim().equals("") || firstjst.trim().equals("") ||secondeist.trim().equals("")
				||secondejst.trim().equals("")){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "ֵ����Ϊ��");
			return false;
		}
		// Ҫ������
		if(!GsnTestIsNumClass.isNumeric(firstist) || !GsnTestIsNumClass.isNumeric(firstjst)||
				!GsnTestIsNumClass.isNumeric(secondeist) || !GsnTestIsNumClass.isNumeric(secondejst)
				){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "��������ĸ");
			return false;
		}
		// ת��
		firsti = Integer.valueOf(firstist);
		firstj = Integer.valueOf(firstjst);
		secondei = Integer.valueOf(secondeist);
		secondej = Integer.valueOf(secondejst);
		// ���Ѳ�Ҫ̫��
		if(firsti < 0 || firsti > 41 || secondei < 0 || secondei > 41){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "i Ӧ�� 1 ~ 40 ֮��");
			return false;
		}
		if(firstj < 0 || firstj > 60 || secondej < 0 || secondej > 60){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "j Ӧ�� 1 ~ 59֮��");
			return false;
		}
		// ������ǽ �������� �����ж���
		
		// ����ֵ��ȥ
		gmcrossnodebean = new GsnMapCrossNodeBean();
		gmcrossnodebean.firstpos[0] = firsti;
		gmcrossnodebean.firstpos[1] = firstj;
		gmcrossnodebean.secondpos[0] = secondei;
		gmcrossnodebean.secondpos[1] = secondej;

		// �������ߵ�λ��
		if(isTakeSnakePosForCrossNode(gmcrossnodebean)){
			JOptionPane.showMessageDialog(GsnEditMapRightOperationJPanel.this, "���跶Χ�������������µ���");
			return false;
		}
		
		// ��ʱ���Ǵӻ����������� ��Ҫ��Ԥѡ��Χ�ָ� ��ӳɹ���
		gsneminter.cancelOrderOfWall();//
		// ����game��沢�滭
		gsneminter.gsnedmmgajpanel.initMapData();
		return true;
	}
	public boolean isTakeSnakePosForCrossNode(GsnMapCrossNodeBean bean){
		// ����ƽ�� ���Ҳ���Ԥѡ Ϊ���������ʺ�
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
	// ���һ������
	public void valueToCrossNodeList(){
		String st = gsneminter.gsnedmmgajpanel.crossnodelength+"";
		crossnodelist.add(st);
		// ���ҽ���ǰѡ������Ϊ��ǰ��
		crossnodejcbox.setSelectedItem(st);
		crossnodejcbox.updateUI();// �ؼ���
	}
	// �õ�����
	public void setMapInfoGetCrossNodeCount(){
		// ������Ϸ����в��ǿ�ֵ�Ĵ�С
		int count = gsneminter.gsnedmmgajpanel.notNullCrossNodeCount();
		mapifcrossnodecounttext.setText(count+"");
	}
	// �����ϰ�������
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
	// �޸ĵ�ʱ��
	public void setCrossCodeBoxIndexOfAlter(GsnMapBean map){// �����ϰ�����±�
		// �����
		crossnodelist.clear();
		// Ҫ��һ��Ĭ�ϵ�
		crossnodelist.add("");
		for(int i = 0; i < map.gsminfobean.crossnodecount; i++){
			crossnodelist.add(i+1+"");
		}
		// Ҫ����
		crossnodejcbox.updateUI();
	}
	// ��Ԥѡ����Ϊ��Խ
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
		// ���
//		gsneminter.gsnedmmgajpanel.crossnodequ.clear();
	}
	// ��Խ�ڵ����end-------------------
	
	// �˳���ͼ�༭����
	public void editMapExit(){
//		gsneminter.gsnedmmgajpanel.setIsPosMouse();
		// �����ж�ֹͣ�߳̽���
		gsneminter.gsnedmmgajpanel.endThread();
		// ֹͣ��֪����û���ã����� һֱ�ʴ���
		gsneminter.gsnedmmgajpanel.EditMapPreviewStartRecover();
		GsnMainGameConstants.setDrawSize(5);
	}
}
