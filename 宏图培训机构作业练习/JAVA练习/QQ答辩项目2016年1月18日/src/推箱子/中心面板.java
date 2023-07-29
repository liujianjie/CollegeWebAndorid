package ������;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import QQ���ݿ���Ϣ.QQGAME;
import �ӿ�.QQuserInterface;
import ����ʵ�ֽӿ�.QQuserimp;

public class �������  extends JPanel{
	int hua=1;
	int up=1;
	int down=2;
	int left=3;
	int right=4;
	int direction=down;//Ĭ������
	
	int ren=5;//��λ�˵�λ��
	int reni,renj;//�˵�ǰλ��
	int qian1i,qian1j,qian2i,qian2j;//��ǰһ��ǰ����λ��
	
	//�ݵ� ���Ӵ����ֵ
	int caodi=2;
	int xiangzi=3;
	int mudidi=4;
	int hong=9;
	int yuanshimap[][];
	QQuserInterface qservice=new QQuserimp();//�ؿ���
	int level;
	int map[][];//��ȡ��ͼ��С
	//����
	Stack<step> steps=new Stack<step>();
	
	JLabel l1;
	//����ͼƬ
	Image img[]={new ImageIcon("img1/.gif").getImage(),//0
			new ImageIcon("img1/1.gif").getImage(),//1
			new ImageIcon("img1/2.jpg").getImage(),//2
			new ImageIcon("img1/9.jpg").getImage(),//3
			new ImageIcon("img1/4a.GIF").getImage(),//4
			new ImageIcon("img1/5.gif").getImage(),//5
			new ImageIcon("img1/6.gif").getImage(),//6
			new ImageIcon("img1/7.gif").getImage(),//7
			new ImageIcon("img1/8.gif").getImage(),//8
			new ImageIcon("img1/9a.GIF").getImage(),//9
			new ImageIcon("img1/aaaa.jpg").getImage()};//10
	//���캯��
	public �������(QQGAME qqgame){
		level=qservice.seltxzgk(qqgame.getQqnum());	
		System.out.println(level);
		this.initGame();
		this.addKeyListener(new B());//��Ȩ�������¼�
		this.addMouseListener(new C());//��Ȩ������¼� 
		
	}
	public void setText(){
		l1.setText("LEVEL:"+level);
	}
	//���󽹵�̳�����¼�
	class C extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO �Զ����ɵķ������
			�������.this.requestFocus();
			hua=2;
			�������.this.repaint();
		}
		
	}
	//�̳м�ֵ
	class B extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO �Զ����ɵķ������
			if(e.getKeyCode()==e.VK_UP){
				  direction=up;
			  }
			  if(e.getKeyCode()==e.VK_DOWN){
				  direction=down;
			  }
			  if(e.getKeyCode()==e.VK_LEFT){
				  direction=left;
			  }
			  if(e.getKeyCode()==e.VK_RIGHT){
				  direction=right;
			  }
			  
			gethanglie();//��ȡ����
			move();
			�������.this.repaint();//���»滭
			//����
			boolean bin=iswin();
			if(bin){
				JOptionPane.showMessageDialog(null, "��ϲ���أ�");
				if(level<=11){
					steps.clear();//��ղ��� ��ֹ��һ������
					setText();//���صȼ���
					level+=1;//��һ
					initGame();//��Ϸ��ʼ��
					�������.this.repaint();
				}else{
					JOptionPane.showMessageDialog(null, "��ϲͨ�أ�");
					
					return;
				}
			}
		}
		
	}
	//���岽��
	class step{
		private int map_data[][]=new int[20][20];
		private int fangxiang;
		public int[][] getMap_data() {
			return map_data;
		}
		public void setMap_data(int[][] map_data) {
			this.map_data = map_data;
		}
		public int getFangxiang() {
			return fangxiang;
		}
		public void setFangxiang(int fangxiang) {
			this.fangxiang = fangxiang;
		}
	
	}
	//��Ҫ���÷���
	public void huiyibu(){
		if(steps.size()<=0){
			JOptionPane.showMessageDialog(null, "û�в�����Է�����!");
			return;
		}
		step s=steps.pop();//�Ӷ�ջ��ȡ���������
		this.map=s.getMap_data();
		this.direction=s.getFangxiang();//һ��һ����� 
		this.repaint();//���»���
		
	}
	//�ж��Ƿ�ͨ��
	public boolean iswin(){
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(map[i][j]==xiangzi){//�����һ����ɫ����
					return false;
				}
			}
		}
		return true;
		
	}
	//��¼���跽��
	public void JLstep(){
		int d[][]=new int[20][20];
		step s=new step();
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				d[i][j]=map[i][j];
				s.setMap_data(d);//��¼��ͼ����
			}
		}
		s.setFangxiang(this.direction);//��¼����
		steps.push(s);//�ѵõ��Ĳ���ѹջ
		
	}
	//�ж��ܷ������
	public void move(){
		//���ǰһ���ǲݵػ�Ŀ�ĵ�
		if(map[qian1i][qian1j]==caodi||map[qian1i][qian1j]==mudidi){
			JLstep();
			int yuanshi=getyuanshi(reni,renj);//����
			map[reni][renj]=yuanshi;//��չ��λ��Ϊԭ�������� �ݻ�Ŀ�ĵ�
			map[qian1i][qian1j]=ren;//ǰһ���Ϊ��
		}
		//���Ǯһ�������ӻ���ɫ����
		if(map[qian1i][qian1j]==xiangzi||map[qian1i][qian1j]==hong){
			if(map[qian2i][qian2j]==caodi){//���жϵڶ����Ƿ�Ϊ�ݵ�
				JLstep();
				int yuanshi=getyuanshi(reni,renj);
				map[reni][renj]=yuanshi;//��չ��λ��Ϊԭ�������� �ݻ�Ŀ�ĵ�
				map[qian1i][qian1j]=ren;//ǰһ��Ϊ��
				map[qian2i][qian2j]=xiangzi;//qian����Ϊ����
			}
			else if(map[qian2i][qian2j]==mudidi){//����ڶ���ΪĿ�ĵ�
				JLstep();
				int yuanshi=getyuanshi(reni,renj);
				map[reni][renj]=yuanshi;//��չ��λ��Ϊԭ�������� �ݻ�Ŀ�ĵ�
				map[qian1i][qian1j]=ren;//ǰһ��Ϊ��
				map[qian2i][qian2j]=hong;//qian����Ϊ������
				
			}
			
			
		}
		
	}
	public int getyuanshi(int i,int j){
		//��ԭʼ��ͼ�л�ȡֵ
		int value=yuanshimap[i][j];
		//ֻ���˺����Ӳ��ܱ�Ϊ�ݵ�
		if(value==ren||value==xiangzi){
			value=caodi;
		}
		//�����ӱ�ΪĿ�ĵ�
		if(value==hong){
			value=mudidi;
		}
		return value;//����ֵ
	}
	public void gethanglie(){
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(map[i][j]==5){
					reni=i;
					renj=j;//��ȡ�˵�λ���к���
				}	
			}
		}
		if(direction==up){//��ȡ���ƶ���λ���к���
			qian1i=reni-1;
			qian1j=renj;
			qian2i=reni-2;
			qian2j=renj;
		}else if(direction==down){
			qian1i=reni+1;
			qian1j=renj;
			qian2i=reni+2;
			qian2j=renj;
		}else if(direction==left){
			qian1i=reni;
			qian1j=renj-1;
			qian2i=reni;
			qian2j=renj-2;
		}else if(direction==right){
			qian1i=reni;
			qian1j=renj+1;
			qian2i=reni;
			qian2j=renj+2;
		}
	}
	//��Ϸ��ʼ����ʵ�ַ���
	public void initGame(){
		this.direction=down;//Ĭ������ �����һ���͹��ص���������
		map=DiTu.getMap(level);//�����ͼֵ
		yuanshimap=DiTu.getMap(level);//��ȡ��ǰλ��
	}
	
	//����Ҫ��ı�ؿ���ͼ��Ϣ
	public void setlevel(int level){
		this.level=level;//��¼�������Ĺؿ�
		initGame();//��ȡ��ͼ��Ϣ
		this.repaint();//���»滭
		steps.clear();//��ղ����ֹѡ�غ󷵻���һ��
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paint(g);
		if(hua==2){
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				int zhi=map[i][j];//��ֵ
				int top=i*30;
				int left1=j*30;
				if(zhi==ren){
					if(direction==up){
						g.drawImage(img[8],left1,top,this);
					}else if(direction==down){
						g.drawImage(img[5],left1,top,this);
					}else if(direction==left){
						g.drawImage(img[6],left1,top,this);
					}else if(direction==right){
						g.drawImage(img[7],left1,top,this);
					}
				}else{
				g.drawImage(img[zhi],left1,top,this);}
				 
			}
			
		}
		//������ȡ����
		//�������.this.requestFocus();//�û�����ͼ�ͻ�ȡ����
	}
	}
}
