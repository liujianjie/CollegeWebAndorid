package Game2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



// �������� ���   ���� 1.�ж����� 2.ԭ��ը�� 3.���߼ӳ� 4.˫�ˡ��������� 
/*
	1.�ж�����  ը���������˵�������ͬ����
	2.ԭ��ը�� ��
	3.���߼ӳ� ����ǵ���1 �Ͷ�ż���ը�� ����2�Ͷ�Щ���淶Χ�������
	4.˫�� ��֪���ܲ���ʵ�� ���߳� ��


*/
public class �������  extends JPanel{	
	int hua=1;
	int up=1;
	int down=2;
	int left=3;
	int right=4;
	int upp;
	int direction=down;//Ĭ������
	//�ı�
	int zhadan;//�жϻ�ը��ͼƬ
	int jiazhadan;//�жϻ���ը��ͼƬ
	int zha=9;
	int zhasi,zhasj,zhaxi,zhaxj,zhazi,zhazj,zhayi,zhayj;//�����Աߵ�����
	int zhasi2,zhasj2,zhaxi2,zhaxj2,zhazi2,zhazj2,zhayi2,zhayj2;//����߻�������
	int zhasi3,zhasj3,zhaxi3,zhaxj3,zhazi3,zhazj3,zhayi3,zhayj3;//����߻�������2
	int baozha=4;
	int huoyan=4;//����ͼƬ
	boolean bao2=false;//�жϱ����
	boolean bao=false;//�ж��ܲ��ܱ��� ��
	boolean baowan=false;//�ж��ܲ��ܱ�
	boolean baowan11=false;//�ж��ܲ��ܱ�
	boolean baowan2=false;//�жϱ���
	boolean baowan3=false;//�����ನ
	boolean baowan4=false;//���ӱ�Ϊ�ݵ�
	int zhai,zhaj;//��ȡը��λ��
	boolean yige=false;//ֻ����һ��ը��
	boolean jiayige=false;//�����һ��ը��
	boolean daoju1=false;//���߰�1
	boolean daoju2=false;//���߰�2
	boolean daoju3=false;//���߰�3
	boolean daoju4=false;//���߰�4
	boolean daoju11=false;//��Χ������ж�
	boolean daoju22=false;//���淶Χ������ж�
	boolean daoju33=false;//���淶Χ������ж�
	boolean daoju44=false;//���淶Χ������ж�
	boolean daoju111=false;//��Χ������ж�
	boolean daoju222=false;//���淶Χ������ж�
	boolean daoju333=false;//���淶Χ������ж�
	boolean daoju444=false;//���淶Χ������ж�
	int daojutu1=10;//������ͼ1
	int daojutu2=11;//������ͼ2
	boolean jiadaoju1=false;//�Ƿ�ӵ�����1
	boolean jiadaoju11=false;//�Ƿ�ӵ�����1��1
	boolean jiadaoju2=false;//�Ƿ�ӵ�����2
	int i=0;//��ǿ
	int yuanshi111,yuanshi222,yuanshi333,yuanshi444;//Ϊ��������ʹ��
	
	int ren=5;//��λ�˵�λ��
	int reni,renj;//�˵�ǰλ��
	int qian1i,qian1j;
	
	//�ݵ� ���Ӵ����ֵ
	int caodi=2;
	int xiangzi=3;
	int mudidi=4;
	int hong=9;
	int yuanshimap[][];
	
	int level=12;
	int map[][];//��ȡ��ͼ��С
	
	JLabel l1;
	//����ͼƬ
	Image img[]={new ImageIcon("img2/.gif").getImage(),//0����
			new ImageIcon("img2/1.gif").getImage(),//1����
			new ImageIcon("img2/2.jpg").getImage(),//2�ݵ�
			new ImageIcon("img2/3.gif").getImage(),//3����
			new ImageIcon("img2/����.png").getImage(),//4����
			new ImageIcon("img2/5.gif").getImage(),//5��
			new ImageIcon("img2/6.gif").getImage(),//6
			new ImageIcon("img2/7.gif").getImage(),//7
			new ImageIcon("img2/8.gif").getImage(),//8
			new ImageIcon("img2/ը��.png").getImage()//9ը��
			,new ImageIcon("img2/����1.png").getImage(),//����1 10
			new ImageIcon("img2/����2.png").getImage()};//����2 11
	//���캯��
	public �������(){
		this.initGame();
		this.addKeyListener(new B());//��Ȩ�������¼�
		this.addMouseListener(new C());//��Ȩ������¼� 
		D a=new D();//�߳�
		a.start();
		
	}
	public void setText(){
		l1.setText("LEVEL:"+(level+1));
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
			if(e.getKeyCode()==38){
				  //System.out.println("��");
				  direction=up;
			  }
			  if(e.getKeyCode()==40){
				 // System.out.println("��");
				  direction=down;
			  }
			  if(e.getKeyCode()==37){
				 // System.out.println("��");
				  direction=left;
			  }
			  if(e.getKeyCode()==39){
				  //System.out.println("��");
				  direction=right;
			  }
			  if(e.getKeyCode()==32){//ը��
				  if(yige==false){//һ��ը��
					  direction=upp;
			  			yige=true;
				  }
				  //�񵽼�ը�����ߺ��һ��ը��
				  if(jiadaoju2){
					 if(jiayige==false){
						direction=upp;
						jiayige=true;
					}
				  }
			  }
			  
			gethanglie();//��ȡ����
			�������.this.repaint();//���»滭
			move();
		}	
	}
	public int getyuanshi1(int i,int j){
		//�ӵ�ͼ�л�ȡֵ �ı�
		//int value=map[i][j];
		//if(value==hong||value==4){//ը���ͻ����Ϊ�ݵ�
		//	value=caodi;
		//}
		//���˵�ը������������
		int value=map[i][j];
		if(jiayige){//
			if(jiazhadan==7){//�����ը���͸ı�
				value=hong;
				jiazhadan=6;
				bao2=true;//���Ա�ը��
				System.out.println("dfsfsd");
			}
		}
		return value;//����ֵ
	}
	//�ж��ܷ������
	public void move(){
		//���ǰһ���ǲݵ�
		if(map[qian1i][qian1j]==caodi){
			int yuanshi=getyuanshi(reni,renj);//����
			map[reni][renj]=yuanshi;//��չ��λ��Ϊԭ�������� �ݻ���ը��
			map[qian1i][qian1j]=ren;//ǰһ���Ϊ��	
		}
		
		//���ǰһ���ǵ���1
		if(map[qian1i][qian1j]==daojutu1){
			int yuanshi=getyuanshi(reni,renj);//����
			map[reni][renj]=yuanshi;//��չ��λ��Ϊԭ�������� �ݻ���ը��
			map[qian1i][qian1j]=ren;//ǰһ���Ϊ��	
			
			//��ô˵�˾ͼ��˵�������ô���ж���
			//����1Ϊ������ǿ
			jiadaoju1=true;
			i++;
			if(i==2){
				jiadaoju11=true;//�ټ�ǿ
			}
		}
		//���ǰһ���ǵ���2
		if(map[qian1i][qian1j]==daojutu2){
			int yuanshi=getyuanshi(reni,renj);//����
			map[reni][renj]=yuanshi;//��չ��λ��Ϊԭ�������� �ݻ���ը��
			map[qian1i][qian1j]=ren;//ǰһ���Ϊ��	
			
			//��ô˵�˾ͼ��˵�������ô���ж���
			jiadaoju2=true;//����2Ϊ���ը��
			
		}

	}

	public int getyuanshi(int i,int j){
		//�ӵ�ͼ�л�ȡֵ �ı�
		int value=map[i][j];
		//ֻ���˲��ܱ�Ϊ�ݵ�
		if(value==ren){
			value=caodi;
		}
		//ը������������
		if(yige){//һ��ʼֻ��һ��ը��
		if(zhadan==7){//�����ը���͸ı�
			value=hong;
			zhadan=6;
			bao2=true;//���Ա�ը��
			
		}
		}
		
		//����ǵ���ͼ1
		if(value==daojutu1){
			value=caodi;//���زݵ�
		}//����ǵ���ͼ2
		if(value==daojutu2){
			value=caodi;//���زݵ�
		}
		return value;//����ֵ
		
		//ը����ը��һ��30*30�Ļ�������ݵ� �ݵر�ɻ���ͼƬ(��ɼ����ݵ�Ҫ) ������زݵ�
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
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				if(map[i][j]==9){
					zhai=i;
					zhaj=j;//��ȡը����λ���к���
				}	
			}
		}
		if(direction==up){//��ȡ���ƶ���λ���к���
			qian1i=reni-1;
			qian1j=renj;
		}else if(direction==down){
			qian1i=reni+1;
			qian1j=renj;
		}else if(direction==left){
			qian1i=reni;
			qian1j=renj-1;
		}else if(direction==right){
			qian1i=reni;
			qian1j=renj+1;
		}
		zhasi=zhai+1;//��
		zhasj=zhaj;
		zhaxi=zhai-1;//��
		zhaxj=zhaj;
		zhazi=zhai;//��
		zhazj=zhaj-1;
		zhayi=zhai;
		zhayj=zhaj+1;//��
		zhasi2=zhai+2;//��
		zhasj2=zhaj;
		zhaxi2=zhai-2;//��
		zhaxj2=zhaj;
		zhazi2=zhai;//��
		zhazj2=zhaj-2;
		zhayi2=zhai;
		zhayj2=zhaj+2;//��
		zhasi3=zhai+3;//��
		zhasj3=zhaj;
		zhaxi3=zhai-3;//��
		zhaxj3=zhaj;
		zhazi3=zhai;//��
		zhazj3=zhaj-3;
		zhayi3=zhai;
		zhayj3=zhaj+3;//��
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
	}
	
	//ʵ��ը����ըҪ�ӳ� �����߳�Ҫ�и�
	class D extends Thread{
		@Override
		public void run() {
			//��ը
			while(true){//һֱ�˶�
				if(bao2){
					//System.out.println("gyhgkjh ");
					
					try{//��ʼ
						Thread.sleep(2000);//Ҫ��ը
					}catch(Exception e){
						e.printStackTrace();
					}
					move2();

					bao=true;//��ը��ͼƬ
					bao2=false;//�´β�������
					repaint();//�ػ�
					try{//����λ�ݵ�
						Thread.sleep(200);//�Ѿ���ը�� ���ݵ�ͼƬ
					}catch(Exception e){
						e.printStackTrace();
					}
					baowan=true;
					baowan11=true;
					baowan3=true;
					repaint();//�ػ� ȥ������
					baowan3=false;
					move();
				}
			}	
		}
		//ը����ը�ķ�Χ
		public void move2(){//�ĸ���Χ
			if(map[zhasi][zhasj]==caodi){//���ã���������ΪҪ�жϵ��߰�
				map[zhasi][zhasj]=4;
				//���˵���������
				if(jiadaoju1){
					if(map[zhasi2][zhasj2]==caodi){
						map[zhasi2][zhasj2]=4;
						//���˵����������1
						/*if(jiadaoju11){
							if(map[zhasi3][zhasj3]==caodi){
								map[zhasi3][zhasj3]=4;
								
							}else if(map[zhasi3][zhasj3]==xiangzi){
								map[zhasi3][zhasj3]=4;
								daoju111=true;//���Ա�Ϊ���� ���ӡ�����
							}
						}*/
					}else if(map[zhasi2][zhasj2]==xiangzi){
						map[zhasi2][zhasj2]=4;
						daoju11=true;//���Ա�Ϊ���� ���ӡ�����
					}
				}
				
			}else if(map[zhasi][zhasj]==xiangzi){
				map[zhasi][zhasj]=4;
				daoju1=true;//���Ա�Ϊ���� ���ӡ�����
			}
			//ը��ը����Ϊ�ݵ� �����ȱ�Ϊ���� ��λ�ݵ�
			if(map[zhasi][zhasj]==daojutu1||map[zhasi][zhasj]==daojutu2){
				map[zhasi][zhasj]=4;
				
			}
			//ը��2ը����Ϊ�ݵ� �����ȱ�Ϊ���� ��λ�ݵ�
			if(map[zhasi2][zhasj2]==daojutu1||map[zhasi2][zhasj2]==daojutu2){
				map[zhasi2][zhasj2]=4;
				
			}
				//if(map[zhasi][zhasj]==map[qian1i][qian1j]){
					//JOptionPane.showMessageDialog(null, "ʧ��");
				//}
			if(map[zhaxi][zhaxj]==caodi){
				map[zhaxi][zhaxj]=4;
				//���˵���������
				if(jiadaoju1){
					if(map[zhaxi2][zhaxj2]==caodi){
						map[zhaxi2][zhaxj2]=4;
						//���˵���2������
						/*if(jiadaoju11){
							if(map[zhaxi3][zhaxj3]==caodi){
								map[zhaxi3][zhaxj3]=4;
							}else if(map[zhaxi3][zhaxj3]==xiangzi){
								map[zhaxi3][zhaxj3]=4;
								daoju222=true;//���Ա�Ϊ���� ���ӡ�����
							}
						}*/
					}else if(map[zhaxi2][zhaxj2]==xiangzi){
						map[zhaxi2][zhaxj2]=4;
						daoju22=true;//���Ա�Ϊ���� ���ӡ�����
					}
				}
				
			}else if(map[zhaxi][zhaxj]==xiangzi){
				map[zhaxi][zhaxj]=4;
				daoju2=true;//���Ա�Ϊ���� ���ӡ�����
			}
			//ը��ը����Ϊ�ݵ� �����ȱ�Ϊ���� ��λ�ݵ�
			if(map[zhaxi][zhaxj]==daojutu1||map[zhaxi][zhaxj]==daojutu2){
				map[zhaxi][zhaxj]=4;
				
			}
			
			//ը��ը����Ϊ�ݵ� �����ȱ�Ϊ���� ��λ�ݵ�
			if(map[zhaxi2][zhaxj2]==daojutu1||map[zhaxi2][zhaxj2]==daojutu2){
				map[zhaxi2][zhaxj2]=4;
				
			}

				//if(map[zhaxi][zhaxj]==map[qian1i][qian1j]){
					//JOptionPane.showMessageDialog(null, "ʧ��");
				//}
			if(map[zhazi][zhazj]==caodi){
				map[zhazi][zhazj]=4;
				//���˵���������
				if(jiadaoju1){
					if(map[zhazi2][zhazj2]==caodi){
						map[zhazi2][zhazj2]=4;
						//���˵���2������
						/*if(jiadaoju11){
							if(map[zhazi3][zhazj3]==caodi){
								map[zhazi3][zhazj3]=4;
							}else if(map[zhazi3][zhazj3]==xiangzi){
								map[zhazi3][zhazj3]=4;
								daoju333=true;//���Ա�Ϊ���� ���ӡ�����
							}
						}*/
					}else if(map[zhazi2][zhazj2]==xiangzi){
						map[zhazi2][zhazj2]=4;
						daoju33=true;//���Ա�Ϊ���� ���ӡ�����
					}
				}
				
			}else if(map[zhazi][zhazj]==xiangzi){
				map[zhazi][zhazj]=4;
				daoju3=true;//���Ա�Ϊ���� ���ӡ�����
			}
			//ը��ը����Ϊ�ݵ� �����ȱ�Ϊ���� ��λ�ݵ�
			if(map[zhazi][zhazj]==daojutu1||map[zhazi][zhazj]==daojutu2){
				map[zhazi][zhazj]=4;
				
			}
			
			//ը��ը����Ϊ�ݵ� �����ȱ�Ϊ���� ��λ�ݵ�
			if(map[zhazi2][zhazj2]==daojutu1||map[zhazi2][zhazj2]==daojutu2){
				map[zhazi2][zhazj2]=4;
				
			}
				//if(map[zhazi][zhazj]==map[qian1i][qian1j]){
					//JOptionPane.showMessageDialog(null, "ʧ��");
				//}
			if(map[zhayi][zhayj]==caodi){
				map[zhayi][zhayj]=4;
				//���˵���������
				if(jiadaoju1){
					if(map[zhayi2][zhayj2]==caodi){
						map[zhayi2][zhayj2]=4;
						//���˵���2������
						/*if(jiadaoju11){
							if(map[zhayi3][zhayj3]==caodi){
								map[zhayi3][zhayj3]=4;
							}else if(map[zhayi3][zhayj3]==xiangzi){
								map[zhayi3][zhayj3]=4;
								daoju444=true;//���Ա�Ϊ���� ���ӡ�����
							}
						}*/
					}else if(map[zhayi2][zhayj2]==xiangzi){
						map[zhayi2][zhayj2]=4;
						daoju44=true;//���Ա�Ϊ���� ���ӡ�����
					}
				}
				
			}else if(map[zhayi][zhayj]==xiangzi){
				map[zhayi][zhayj]=4;
				daoju4=true;//���Ա�Ϊ���� ���ӡ�����
			}
			//ը��ը����Ϊ�ݵ� �����ȱ�Ϊ���� ��λ�ݵ�
			if(map[zhayi][zhayj]==daojutu1||map[zhayi][zhayj]==daojutu2){
				map[zhayi][zhayj]=4;
				
			}
			
			//ը��ը����Ϊ�ݵ� �����ȱ�Ϊ���� ��λ�ݵ�
			if(map[zhayi2][zhayj2]==daojutu1||map[zhayi2][zhayj2]==daojutu2){
				map[zhayi2][zhayj2]=4;
				
			}
				//if(map[zhayi][zhayj]==map[qian1i][qian1j]){
				//	JOptionPane.showMessageDialog(null, "ʧ��");//��Ҳ��֪��Ϊʲô Ҫ+1 -1 �����ճ��ˡ�������
			//	}
		}
		//���߷���
		public int daoju(){
			int a=new Random().nextInt(5);
			if(a==1){
				a=caodi;//�ݵ�
			}
			else if(a==0){
				a=daojutu2;//����2
			}else if(a==3){
				a=caodi;//�ݵ�
			}
			else if(a==2){
				a=daojutu1;//����1
			}else if(a==4){
				a=caodi;//�ݵ�
			}
			
			return a;
		}
		//�ж��ܷ������
		public void move(){//�������ӱ�Ϊ���ߺͱ�Ϊ�ݵ�
			if(baowan){
				int yuanshi=getyuanshi(zhai,zhaj);//����
				map[zhai][zhaj]=yuanshi;//ը����λ��Ϊԭ�������� ��
				//���淶Χ
				int yuanshi1=getyuanshi(zhasi,zhasj);//����
				if(daoju1){
					int a=daoju();//�����
					map[zhasi][zhasj]=a;//���ӵ�λ��Ϊ������ 
				}else{
					map[zhasi][zhasj]=yuanshi1;//�����λ��Ϊԭ�������� ��
					
				}
				
				int yuanshi2=getyuanshi(zhaxi,zhaxj);//����
				if(daoju2){
					int a=daoju();
					map[zhaxi][zhaxj]=a;//���ӵ�λ��Ϊ������ 
				}else{
					map[zhaxi][zhaxj]=yuanshi2;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
					
				}
				
				int yuanshi3=getyuanshi(zhazi,zhazj);//����
				if(daoju3){
					int a=daoju();
					map[zhazi][zhazj]=a;//���ӵ�λ��Ϊ������ 
				}else{
					map[zhazi][zhazj]=yuanshi3;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
					
				}

				int yuanshi4=getyuanshi(zhayi,zhayj);//����
				if(daoju4){
					int a=daoju();
					map[zhayi][zhayj]=a;//���ӵ�λ��Ϊ������ 
				}else{
					map[zhayi][zhayj]=yuanshi4;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
					
				}
				//���淶Χ���ӷ�Χ���
				int yuanshi11=getyuanshi(zhasi2,zhasj2);//����
				if(daoju11){
					int a=daoju();//�����
					map[zhasi2][zhasj2]=a;//���ӵ�λ��Ϊ������ 
				}else{
					map[zhasi2][zhasj2]=yuanshi11;//�����λ��Ϊԭ�������� ��
					
				}
				int yuanshi22=getyuanshi(zhaxi2,zhaxj2);//����
				if(daoju22){
					int a=daoju();
					map[zhaxi2][zhaxj2]=a;//���ӵ�λ��Ϊ������ 
				}else{
					map[zhaxi2][zhaxj2]=yuanshi22;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
					
				}
				int yuanshi33=getyuanshi(zhazi2,zhazj2);//����
				if(daoju33){
					int a=daoju();
					map[zhazi2][zhazj2]=a;//���ӵ�λ��Ϊ������ 
				}else{
					map[zhazi2][zhazj2]=yuanshi33;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
					
				}
				int yuanshi44=getyuanshi(zhayi2,zhayj2);//����
				if(daoju44){
					int a=daoju();
					map[zhayi2][zhayj2]=a;//���ӵ�λ��Ϊ������ 
				}else{
					map[zhayi2][zhayj2]=yuanshi44;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
					
				}
				}
				daoju1=false;
				daoju2=false;
				daoju3=false;
				daoju4=false;
				daoju11=false;
				daoju22=false;
				daoju33=false;
				daoju44=false;
				daoju111=false;
				daoju222=false;
				daoju333=false;
				daoju444=false;
				baowan=false;
				baowan4=true;
			}
		public int getyuanshi(int i,int j){
			//�ӵ�ͼ�л�ȡֵ �ı�
			int value=map[i][j];
			if(value==hong||value==4){//ը���ͻ����Ϊ�ݵ�
				value=caodi;
				
			}
			return value;//����ֵ
		}
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
					}else if(direction==upp){
							g.drawImage(img[9],left1,top,this);//ը��
							zhadan=7;//��value��ȡΪը��ͼƬ
							jiazhadan=7;//��value��ȡ�ӵ���ը��ͼƬ
					}
				}else{
					g.drawImage(img[zhi],left1,top,this);
				}
				if(zhi==zha){//ը��λ��
					if(bao){
						g.drawImage(img[4],left1,top,this);//ը����ըΪ����ͼƬ
						yige=false;//һ��ը��
						jiayige=false;//j��һ��ը��
					}
					bao=false;
				}
				if(zhi==4){//����λ�� 
					if(baowan3){
						g.drawImage(img[2],left1,top,this);//���ݵظ��ǻ���
						
						//System.out.println("dsfdsfds");
					}
					//baowan3=false;
				}
				
			}
		}
		
	}
	}
}
