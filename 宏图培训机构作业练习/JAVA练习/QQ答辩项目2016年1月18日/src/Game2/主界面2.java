package Game2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ������2 extends JFrame {
	int hua=1;
	JLabel close;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JComboBox cmmusic;
	String musicfile[]={"flourish.mid","guang.mid","popo.mid","eyes on me.mid","qin.mid"};//�����ļ�
	String st[]={"Ĭ��","��������","������","eyes on me","�������"};//Ϊ�������������
	JPanel dong;
	������� zhong=new �������();//�����������
	Sound sound;//����
	Container con;
	 
	public ������2(){
		super("������2015");
		//����ͼƬ
		setIconImage(new ImageIcon("img1/9.GIF").getImage());
		
		//�����ļ�
		//sound=new Sound();
		
		con=getContentPane();
		setLayout(new BorderLayout());
		
		dong=new JPanel();
		dong.setLayout(null);
		zhong.setLayout(null);
		dong.setPreferredSize(new Dimension(100,600));//�Զ���ƫ�ô�С
		zhong.setPreferredSize(new Dimension(600,600));
		close=new JLabel();
		close.setBounds(670,0,30,30);
		con.add(close);
		
		zhong.l1=new JLabel("LEVEL:1");
		dong.add(zhong.l1);
		zhong.l1.setBounds(0,20,100,30);
		Font f=new Font("����",Font.PLAIN,24);
		zhong.l1.setFont(f);
		zhong.l1.setForeground(Color.red);
		
		b1=new JButton("����");
		dong.add(b1);
		b1.setBounds(10,70,80,20);
		
		b2=new JButton("��һ��");
		dong.add(b2);
		b2.setBounds(10,120,80,20);
		
		b3=new JButton("��һ��");
		dong.add(b3);
		b3.setBounds(10,170,80,20);
		
		b4=new JButton("��һ��");
		dong.add(b4);
		b4.setBounds(10,220,80,20);
		
		b5=new JButton("��һ��");
		dong.add(b5);
		b5.setBounds(10,270,80,20);
		
		b6=new JButton("���չ�");
		dong.add(b6);
		b6.setBounds(10,320,80,20);
		
		b7=new JButton("ѡ��");
		dong.add(b7);
		b7.setBounds(10,370,80,20);
		
		b8=new JButton("����");
		dong.add(b8);
		b8.setBounds(10,420,80,20);
		
		b9=new JButton("���ֹ�");
		dong.add(b9);
		b9.setBounds(10,470,80,20);
		b9.setActionCommand("music����");//�����ύ���� Ҫ��Ȼ�ò���
		
		cmmusic=new JComboBox(st);
		cmmusic.setBounds(10,520,80,20);
		dong.add(cmmusic);
		
		ImageIcon z=new ImageIcon("img1/aaaa1.jpg");
		JLabel jl=new JLabel(z);
		jl.setBounds(0,0,100,600);//��ӱ���ͼƬ
		dong.add(jl);
		
		ImageIcon x=new ImageIcon("img1/aaaa.jpg");
		JLabel j2=new JLabel(x);
		j2.setBounds(0,0,600,600);//��ӱ���ͼƬ
		zhong.add(j2);
		
		//��Ȩ
		b1.addActionListener(new A());
		b3.addActionListener(new A());
		b4.addActionListener(new A());
		b5.addActionListener(new A());
		b6.addActionListener(new A());
		b7.addActionListener(new A());
		b8.addActionListener(new A());
		b9.addActionListener(new A());
		cmmusic.addItemListener(new E());//�ڵ�ǰ��ʵ��
		con.add(dong,BorderLayout.EAST);
		con.add(zhong,BorderLayout.CENTER);
		pack();
		//setSize(700,600);
		setVisible(true);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class B extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==close){
				
				dispose();
			}
		}
		
	}
	public static void main(String dsf[]){
		new ������2();
		
	}
	class A implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			if(e.getActionCommand().equals("����")){
				int level=zhong.level;//��ȡ��ǰ�ؿ�����
				zhong.setlevel(level);//��ֵ
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("��һ��")){
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("��һ��")){
				zhong.setlevel(1);
				zhong.l1.setText("LEVEL:1");
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("��һ��")){
				int level=zhong.level;//��ȡ��ǰ�ؿ�����
				if(level<=1){
					JOptionPane.showMessageDialog(null, "û�йؿ�������ǰ�ˣ�");
					
				}else{
					zhong.setlevel(level-1);
					zhong.l1.setText("LEVEL:"+(level-1));
				}
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("��һ��")){
				int level=zhong.level;//��ȡ��ǰ�ؿ�����
				if(level>=12){
					JOptionPane.showMessageDialog(null, "û�йؿ����������ˣ�");
					
				}else{
					zhong.setlevel(level+1);
					zhong.l1.setText("LEVEL:"+(level+1));
				}
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("���չ�")){
				zhong.setlevel(12);
				zhong.l1.setText("LEVEL:12");
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("ѡ��")){
				int level=zhong.level;//��ȡ��ǰ�ؿ�����
				String str=JOptionPane.showInputDialog(null, "������1-12�Ĺؿ�");
				try{
					level=Integer.parseInt(str);
				}catch(NumberFormatException e1){
					//e.printStackTrace();//��ӡ������Ϣ
					JOptionPane.showMessageDialog(null, "������Ĺؿ���Ч��");//����ַ�
					return;
				}
				if(level>=1&&level<=12){
					zhong.setlevel(level);
					zhong.l1.setText("LEVEL:"+(level));
				}else{
					JOptionPane.showMessageDialog(null, "������1-12�Ĺؿ���");//�������
				}
				zhong.requestFocus();
			}else if(e.getActionCommand().equals("����")){
				new Help();
			}else if(e.getActionCommand().equals("music����")){//�ύ���ݡ���������
				String title=b9.getText();
				if(title.equals("���ֹ�")){
					sound.mystop();//�ر�����
					b9.setText("���ֿ�");
				}else{
					sound.loadSound();//�ر�����
					b9.setText("���ֹ�");
					
				}
				zhong.requestFocus();
			}
			
		}
		
	}
	class E implements ItemListener {
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO �Զ����ɵķ������
		int index=cmmusic.getSelectedIndex();//��ȡ���� 0,1,2,3
		sound.setmusic(musicfile[index]);//��������Ӧ�ļ�0,1,2,3
		if(sound.isplay()){
			sound.mystop();//�ж��Ƿ��ٷ� �ڷž͹ص�
		}
		sound.loadSound();//���Ȳ�������0 Ĭ�ϵ�
		zhong.requestFocus();
	}
	}
}