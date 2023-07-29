package com.tank.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tank.configure.BlueSquareParam;
import com.tank.configure.MissileParam;
import com.tank.configure.TankParam;
import com.tank.configure.YellowSquareParam;


public class GameMainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image ima;
	Image ima1;
	
	JLabel JPoint;
	public static int point = 0;
	
	//Tank
	TankThread thr = new TankThread();
	BlueSquareThread bluesq = new BlueSquareThread();
	Thread thread1,thread2;
	private static TankParam tank;
	
	//�ӵ�
	private List<MissileParam> missiles = new ArrayList<MissileParam> ();
	public List<MissileParam> getMissiles() {
		return missiles;
	}
	private MissileParam missile;
	public void setMs(MissileParam ms){
		this.missile = ms;
	}
	
	//BuleSquare
	public List<BlueSquareParam> bluesqlist = new ArrayList<BlueSquareParam> ();
	private static BlueSquareParam bsquare;
	
	//YellowSquare
	private static YellowSquareParam ysquare;
	
	//param
	public static boolean gameover = true;
	GameMainIterFace gamemain;
	
	//���캯��
	public GameMainPanel(GameMainIterFace gamemain){
		this.setBackground(Color.WHITE);
		
		this.gamemain = gamemain;
		
		//������ֵ �ʹ���ֵ
		thread1 = new Thread(thr);
		thread2 = new Thread(bluesq);
//		new Thread(new BlueSquareThread()).start();
		this.addKeyListener(new B());//��Ȩ�������¼�
		this.addMouseListener(new C());//��Ȩ������¼� 
		
	}
	//���÷�����
	public void setPoint(int point){
		JPoint.setText("POINT:"+point);
	}
	public void addPoint(){
		point = point + 10;
	}
	//��ʼ
	public void gamestart(){
		startresetcommon();
		if(!thread1.isAlive()){
			thread1.start();
		}if(!thread2.isAlive()){
			thread2.start();
		}
	}
    //���¿�ʼ
    public void reset(){
    	startresetcommon();
    	if(!thread1.isAlive()){
			thread1.start();
		}if(!thread2.isAlive()){
			thread2.start();
		}
		gamemain.panel.setVisible(true);
		gamemain.removeGameOver();
    	repaint();
    }
    public void startresetcommon(){
    	bluesqlist.clear();
		missiles.clear();
    	gameover = false;
    	tank = new TankParam(410,GameMainPanel.this.getHeight()/2 - 10 ,this);
		bsquare = new BlueSquareParam();
		ysquare = new YellowSquareParam();
    }
    //��Ϸ���� �л�panel
    public void GameOver(){
    	gamemain.panel.setVisible(false);
    	gamemain.setGameOver(point);
    }
    private boolean Missilecollision(BlueSquareParam bs,MissileParam ms){
    	if(bs.bsquarex < ms.misx && ms.misx < bs.bsquarex + 40 && bs.bsquarey < ms.misy && ms.misy < bs.bsquarey + 40){
    		return true;
    	}
    	return false;
    }
    private boolean MissilecollisionYelSqu(MissileParam ms){
    	if(ysquare.ysx < ms.misx && ms.misx < ysquare.ysx + 20 && ysquare.ysy < ms.misy && ms.misy < ysquare.ysy + 20){
    		return true;
    	}
    	return false;
    }
    private boolean Tankcollision(BlueSquareParam bs){
    	//���Ͻ�
		if(bs.bsquarex <= tank.tankx && tank.tankx < bs.bsquarex + 40 && bs.bsquarey < tank.tanky && tank.tanky < bs.bsquarey + 40){
//			System.out.println("��ײ���� ���Ͻ�");
			gameover = true;
		}
		//���Ͻ�
		if(bs.bsquarex < tank.tankx + 20 && tank.tankx + 20 < bs.bsquarex + 40 && bs.bsquarey < tank.tanky && tank.tanky <bs.bsquarey + 40){
//			System.out.println("��ײ���� ���Ͻ�");
			gameover = true;
		}
		//���½�
		if(bs.bsquarex < tank.tankx && tank.tankx < bs.bsquarex + 40 && bs.bsquarey < tank.tanky + 20 && tank.tanky + 20 <bs.bsquarey + 40){
//			System.out.println("��ײ���� ���½�");
			gameover = true;
		}
		//���½�
		if(bs.bsquarex < tank.tankx + 20 && tank.tankx + 20 < bs.bsquarex + 40 && bs.bsquarey < tank.tanky + 20 && tank.tanky + 20 < bs.bsquarey + 40){
//			System.out.println("��ײ���� ���½�");
			gameover = true;
		}
		return gameover;
    }
    static int count = 1;
	public void paint(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paint(g);
		if(!gameover){
			tank.draw(g);
			if((point+1) % 9 == 0){
				ysquare.draw(g);
			}
			for(int i = 0;i < missiles.size(); i++){
				MissileParam ms = missiles.get(i);
				System.out.println(count++);
				//�ж��ӵ��Ƿ񻹴���ڣ�������Ǵ��ģ����Ƴ�
				if(!ms.isLive()){
					missiles.remove(ms);
				}
				else{
					ms.draw(g);
					//�ӵ��� yellow
					boolean bln2 = MissilecollisionYelSqu(ms);
					if(bln2){
						ysquare.cleandraw(g);
						//�ӵ�Ҳ����
						ms.cleandraw(g);
						missiles.remove(ms);// zhel xiao chu le
						addPoint();
						setPoint(point);
						System.out.println(point);
						bln2 = false;
					}
					//�ж��ӵ���square
					for(int j = 0;j < bluesqlist.size(); j++){
						BlueSquareParam bs = bluesqlist.get(j);
						boolean bln = Missilecollision(bs,ms);
						if(bln){
							bs.cleandraw(g);
							bluesqlist.remove(bs);
							//�ӵ�Ҳ����
							ms.cleandraw(g);
							missiles.remove(ms);
							//add one opoint
							point++;
							setPoint(point);
						}
					}
				}
				
			}
			for(int i = 0;i < bluesqlist.size(); i++){
				BlueSquareParam bs = bluesqlist.get(i);
				bs.draw(g,tank.tankx, tank.tanky);
				boolean  bln = Tankcollision(bs);
				if(bln){
					GameOver();
				}
	//			if(bs.bsquarex <= tank.tankx && tank.tankx < bs.bsquarex + 40 && bs.bsquarey <= tank.tanky && tank.tanky < bs.bsquarey){
	//				System.out.println("��ײ����");
	//			}
			}
		}
	}
	
	//���ӵ��߳�
    private class TankThread implements Runnable{

        @Override
        public void run() {
            while(true){
            	
	                try {
	                    Thread.sleep(40);//50ms �ػ�
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                if(!gameover){
	                	repaint();
	                }
            }
        }

    }
    
    //square �߳�
    private class BlueSquareThread implements Runnable{

        @Override
        public void run() {
            while(true){
            	
                try {
                    Thread.sleep(3000);//50ms �ػ�
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(!gameover){
	                addbluesqlist();
	                repaint();
                }
            }
        }
    }
    public void addbluesqlist(){
    	bluesqlist.add(new BlueSquareParam());
    	bluesqlist.add(new BlueSquareParam());
    }
    
    //���󽹵�̳�����¼�
  	class C extends MouseAdapter{
  		@Override
  		public void mouseClicked(MouseEvent e) {
  			// TODO �Զ����ɵķ������
  			GameMainPanel.this.requestFocus();
  			GameMainPanel.this.repaint();
  		}
  		
  	}
  	//�̳м�ֵ
  	class B extends KeyAdapter{
  		@Override
          public void keyPressed(KeyEvent e) {
  			tank.keyMonitor(e);
          }

          @Override
          public void keyReleased(KeyEvent e) {
          	tank.keyReleased(e);
          }   
  	}
}
