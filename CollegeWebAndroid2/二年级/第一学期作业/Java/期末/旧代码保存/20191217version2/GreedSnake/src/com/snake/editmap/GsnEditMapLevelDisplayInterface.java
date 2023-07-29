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
// �ؿ�ѡ���Լ���ϢԤ������
public class GsnEditMapLevelDisplayInterface extends JPanel{
	// �ӿؼ�
	// ��������ʽ�ؿ�
	private JScrollPane jscrollpane;
	private JPanel jpanel;// ���label
	
	// ����Jlist
	public ArrayList<Object> gsneditmapleveldisarrlist;// ֻ�Ƿ���һ������
	public JList<Object> gsneditmapleveldisjlist;
	public GsnEditMapRightOpBarListComBoxModel jlistmodel;
	public JButton newmapjb;
	
	// Ԥ���� ��ͼ����
	private GsnMainGameJPanel prevewMainGameJpanel;
	
	// Ԥ���� ��ͼ��Ϣ 
	private GsnMapInFoBean mapbean;
	private JPanel mapinfoJpanel;
	private JLabel[] mapinfoJLable;
	private JButton alterbt,deletebt;
	
	public GsnMapReadAndOut gsnmaprao;
	
	// ���¶�ȡ��ͼ
	public void reReadNewMap(){
		gsnmaprao.readMapText();
		gsnmaprao.changeMap();
	}
	public GsnEditMapLevelDisplayInterface(){
		setLayout(null);
		// ���������
		
		initview();
		
		initGamepanel();
		
		
		setJListBkColor();

		initMapInfoView();
		
		addLis();
		
		gsnmaprao = new GsnMapReadAndOut();
		
		this.setBackground(Color.GREEN);
		this.setSize(new Dimension(640, 480));// 640 * 480 �̶���С
		
		// �����¼�
		this.addKeyListener(new GsnLevelDisplayKeyLis());
	}
	
	// ����jlist----------------------
	// ���list
	public void clearArrayList(){
		gsneditmapleveldisarrlist.clear();
	}
	// ���¶�ȡ���list
	public void reAddArraylist(){
		// ��С
		for(int i = 0; i < GsnMainGameConstants.gsngamemap.length; i++){
			gsneditmapleveldisarrlist.add((i + 1)+"."+GsnMainGameConstants.gsngamemap[i].gsminfobean.mapname);
		}
	}
	
	// ����jlist----------------------
	// ���û滭��ͼ����ֵ
	public void setDrawMapConstant(int size, int level){
		editmapdisplaycurlevel = level;
		// ����ͼ�λ滭��С
		GsnMainGameConstants.setDrawSize(size);
		GsnMainGameConstants.currLevel = level;
	}
	public void initGamepanel(){
		prevewMainGameJpanel = new GsnMainGameJPanel();
		prevewMainGameJpanel.setnewSize(GsnInterfaceParam.GAMEPRIVEWIDTH,GsnInterfaceParam.GAMEPRIVEHEIGHT);
		prevewMainGameJpanel.setBounds(290, 50, GsnInterfaceParam.GAMEPRIVEWIDTH, GsnInterfaceParam.GAMEPRIVEHEIGHT);
		
		// Ԥ��
		prevewMainGameJpanel.Preview();
		add(prevewMainGameJpanel);
	}
	// �ؿ�ѡ��
	public void initview(){
		newmapjb = new JButton("�½���ͼ");
		gsneditmapleveldisarrlist = new ArrayList<Object>();
		jlistmodel = new GsnEditMapRightOpBarListComBoxModel(gsneditmapleveldisarrlist);
		gsneditmapleveldisjlist = new JList<Object>(jlistmodel);
		
		// ���ò��ɵ�� ����ʧȥ����
		gsneditmapleveldisjlist.setFocusable(false);
		
		reAddArraylist();
		gsneditmapleveldisjlist.setSelectedIndex(0);// ��һ��ѡ��
		//�رպ��� ������
		jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		jpanel.add(newmapjb, BorderLayout.NORTH);
		// ��������
		jpanel.add(gsneditmapleveldisjlist, BorderLayout.CENTER);
		
		// Ҫ��jpanel����������С�������viewpoint
		jscrollpane = new JScrollPane(jpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollpane.setPreferredSize(new Dimension(220, 410));
		
		jscrollpane.setBounds(50, 50, 220, 410);
		// ��ӵ����
		add(jscrollpane);
	}
	// ��ͼ��Ϣ
	public void setMapInfoBean(){// ���õ�ǰѡ��ؿ��ĵ�ͼbean
		mapbean = GsnMainGameConstants.gsngamemap[GsnMainGameConstants.currLevel - 1].gsminfobean;
		mapinfoJLable[0].setText("��ͼ���ߣ�"+mapbean.authorname);
		mapinfoJLable[1].setText("��ͼ���ƣ�"+mapbean.mapname);
		mapinfoJLable[2].setText("����ʱ�䣺"+mapbean.creationtime);
		mapinfoJLable[3].setText("��ͼ��Ҫ��"+mapbean.tips);
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
		setEnterButtonSt("�޸ĵ�ͼ");
		
		deletebt = new JButton();
		deletebt.setText("ɾ����ͼ");
		
		jp.add(alterbt);
		jp.add(deletebt);
		mapinfoJpanel.add(jp);
		this.add(mapinfoJpanel);
		mapinfoJpanel.setBounds(290, 275, GsnInterfaceParam.GAMEMAPINFOWIDTH, GsnInterfaceParam.GAMEMAPINFOHEIGHT);
	}
	public void setEnterButtonSt(String st){
		alterbt.setText(st);
	}
	// ��Ӽ���
	public void addLis(){
		GsnLevelActionLis gsla = new GsnLevelActionLis();
		alterbt.addActionListener(gsla);
		newmapjb.addActionListener(gsla);
		deletebt.addActionListener(gsla);
		GsnEditMaplevelDisItemClass gsndis = new GsnEditMaplevelDisItemClass();
		gsneditmapleveldisjlist.addListSelectionListener(gsndis);
	}
	// ��Jabel���ñ�����ɫ ���ݵ�ǰѡ��Ĺؿ�
	public void setJListBkColor(){
		gsneditmapleveldisjlist.setSelectionBackground(Color.ORANGE);
	}
	// ��֤����
	public boolean checkMapPwd(){
		// ����������
		String stpwd = JOptionPane.showInputDialog(GsnEditMapLevelDisplayInterface.this, "������ؿ�����");
		if(stpwd != null){
			if(stpwd.equals(GsnMainGameConstants.gsngamemap[editmapdisplaycurlevel - 1].gsminfobean.mappwd)){
				return true;
			}else{
				JOptionPane.showMessageDialog(GsnEditMapLevelDisplayInterface.this, "�ؿ���������޷����в���");
				return false;
			}
		}
		return false;
	}
	// ����
	public void alterGameMap(){
		if(checkMapPwd()){
			setDrawMapConstant(10, editmapdisplaycurlevel);// �����úò���
			// ���޸ĵ���������������ſ�
			GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gsneditmapleveldisplayJpanel, GsnBottomLayerInterface.gameEditMapJpanel);
			// �������嵥����������ü��� ����Ϊ�Ѿ���ʼ�������ڹ��췽�����ȡ��潹�����в�ͨ��
			GsnBottomLayerInterface.gameEditMapJpanel.setMapDataByLevel();
			GsnBottomLayerInterface.gameEditMapJpanel.gsnedmmgajpanel.requestFocus();
		}else{
			this.requestFocus();
		}
	}
	// ��������Ĺؿ�ͼƬ
	public void changePreviewMap(){
		// ������ͼ֮ǰ��Ҫ�ȹ�֮ǰ�� �� �ϰ��� ʳ����߳�
		prevewMainGameJpanel.endThread();
		// �滭�ؿ�
		prevewMainGameJpanel.Preview();
		prevewMainGameJpanel.repaint();
	}
	
	// �½��ؿ�
	public void newMap(){
		setDrawMapConstant(10, editmapdisplaycurlevel);// �����úò���
		// ��Ϊ��
		GsnBottomLayerInterface.gameEditMapJpanel.Reinit();
		GsnBottomLayerInterface.updateJPanel(GsnBottomLayerInterface.gsneditmapleveldisplayJpanel, GsnBottomLayerInterface.gameEditMapJpanel);
		GsnBottomLayerInterface.gameEditMapJpanel.gsnedmmgajpanel.requestFocus();
	}
	
	// ��ǰ����Ĺؿ� Ĭ��1
	int editmapdisplaycurlevel = 1;
	// Ҫ���� ��Ϊ��ӵ�ʱ������
	public void setEditMapLevelCurLevelForadd(){
		editmapdisplaycurlevel = GsnMainGameConstants.gsngamemap.length;
		setDrawMapConstant(5, editmapdisplaycurlevel);// ��ǰ�ȼ������
		changePreviewMap();
	}
	// �޸ĵ�ʱ�� Ҳ�����һ�� ��Ϊ�ŵ�����ȥ��
	public void setEditMapLevelCurLevelForAlter(){
		editmapdisplaycurlevel = GsnMainGameConstants.gsngamemap.length;
		setDrawMapConstant(5, editmapdisplaycurlevel);// ��ǰ�ȼ������
		changePreviewMap();
	}
	int chooselevel = -2;
	public void PressNumberDel(){// ��Ϊ�������ּ� ��Ҫ��ת
		if(chooselevel <= GsnMainGameConstants.gsngamemap.length ){
			// ����
			editmapdisplaycurlevel = chooselevel;
			alterGameMap();
		}
	}
	// ���̼��� ѡ��˵���
	class GsnLevelDisplayKeyLis extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			// ����ؿ�
			if(e.getKeyCode() == KeyEvent.VK_UP){
				// ���ùؿ� ������� 0 ������
				if(editmapdisplaycurlevel - 1 > 0){
					setDrawMapConstant(5, editmapdisplaycurlevel - 1);
					changePreviewMap();// ������ʽ�ĵ�ͼ
					// jlist��Ӧѡ��
					gsneditmapleveldisjlist.setSelectedIndex(editmapdisplaycurlevel - 1);// �±���ԶСһ��
					setMapInfoBean();// ��ͼ��Ϣ
				}
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				// ���Լ�
				if(editmapdisplaycurlevel + 1 <= gsneditmapleveldisarrlist.size()){
					setDrawMapConstant(5, editmapdisplaycurlevel + 1);
					changePreviewMap();
//					// jlist��Ӧѡ��
					gsneditmapleveldisjlist.setSelectedIndex(editmapdisplaycurlevel - 1);
					setMapInfoBean();// ��ͼ��Ϣ
				}
			}
			// �޸ĵ�ǰ�ؿ�
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
				System.out.println("GsnLevelDisplayKeyLis����VK_ESCAPE��");
			}
		}
	}
	
	// Jbutton���ü���
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
				// �½�
				newMap();
			}else if(obj == deletebt){
				// ɾ���˵�ͼ 
				
				// ��ȷ������
				if(checkMapPwd()){
					// ɾ�������������ݵ�ǰѡ��Ĺؿ�
					gsnmaprao.delMap();
					// ����Ҫ����ui ���޸�һ��
					// ����� ���¶�ȡ
					reReadNewMap();
					// �����ҲҪ��������Ԥ���Ĺؿ����� �����һ����
					setEditMapLevelCurLevelForadd();
					
					// �����Ҫ������UI ���ǹؿ�ѡ��
					clearArrayList();
					reAddArraylist();
					//�������һ��
					gsneditmapleveldisjlist.setSelectedIndex(GsnMainGameConstants.gsngamemap.length - 1);
					gsneditmapleveldisjlist.updateUI();
					
					// Ԥ����ͼ��
					GsnBottomLayerInterface.gameLevelJpanel.clearArrayList();
					GsnBottomLayerInterface.gameLevelJpanel.reAddArraylist();
					//���õ�һ���ؿ�ѡ��
					GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.setSelectedIndex(0);
					GsnBottomLayerInterface.gameLevelJpanel.gsnleveldisjlist.updateUI();
				}
				// ���û����
				GsnEditMapLevelDisplayInterface.this.requestFocus();
			}
			
		}
	}
	// ����jlist�ĵ��
	class GsnEditMaplevelDisItemClass implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			// ����ǰ�ؿ���ֵ 
			setDrawMapConstant(5, gsneditmapleveldisjlist.getSelectedIndex() + 1);
			// Ԥ��ͼ���Ÿ���
			changePreviewMap();
			setMapInfoBean();// ��ͼ��Ϣ
		}
		
	}
}
