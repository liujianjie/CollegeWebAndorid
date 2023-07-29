package pack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class T1 extends JFrame{
	JLabel jl;
	JLabel pa[];
	
	JPanel jp1;
	public T1(){
		super("T1");
		setLayout(null);
		jp1 = new JPanel();
		jp1.setBackground(Color.YELLOW);
		jp1.setLayout(null);
		jp1.setSize(new Dimension(80, 80));
		jp1.setBounds(30,30, 110, 110);
		generateJlabel();
		
		add(jp1);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(new Dimension(300,300));
		setVisible(true);
		
	}
	Color c[] = {Color.MAGENTA,Color.BLUE,Color.CYAN,Color.PINK,Color.GREEN,Color.ORANGE,Color.ORANGE,Color.RED,Color.MAGENTA,Color.PINK};
	Random ran = new Random();
	public void generateJlabel(){
		// ���ɵ�
		int palen = ran.nextInt(18) + 60;
		pa = new JLabel[palen];
		Font f = new Font("����", 0, 5);
		for(int i = 0; i < palen; i++){
			pa[i] = new JLabel("��",JLabel.CENTER);
			pa[i].setBounds((110 - 30) / 2, (110 - 30) / 2, 25, 25);
			// ������ɫ
			pa[i].setFont(f);
			pa[i].setForeground(c[ran.nextInt(c.length)]);
			jp1.add(pa[i]);
		}
		jp1.updateUI();
		for(int i = 0; i < palen; i++){
			MyThread my = new MyThread(i);
			my.start();
		}
	}
	public static void main(String[] args) {
		new T1();
	}
	int count = 0;
	class MyThread extends Thread{
		int lbid;
		public MyThread(int id){
			lbid = id;
		}
		boolean isout = false;
		@Override
		public void run() {
			// 1.���� xy
			int x = Math.random() > 0.5 ? ran.nextInt(5) * 1 : ran.nextInt(5) * (-1);
			int y = Math.random() > 0.5 ? ran.nextInt(5) * 1 : ran.nextInt(5) * (-1);
			int speed = ran.nextInt(30) + 20;// �ٶ� 20 - 50��
			while(true){
				// ����ԭ�ص� ���� x y��0 ��
				if(x == 0 && y == 0){
					System.out.println(x+" , "+y);
					break;
				}
				int yx = (int) (pa[lbid].getX() + x);
				int yy =(int) (pa[lbid].getY() + y);
				// ����һֱ�ƶ� ���ݷ��� 
				pa[lbid].setBounds(yx, yy, 25, 25);
				if(isout == false){
					System.out.println(x+" , "+y);
				}
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jp1.updateUI();
				// �е�û����ȫ�˳�
				if(yx > jp1.getX() + 80 || yy > jp1.getY() + 80){
					count++;
					break;
				}
			}
			System.out.println(count);
			isout = true;
		}
	}
}
