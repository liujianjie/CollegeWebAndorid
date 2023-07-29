
//Java����׶���˹����
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TetrisFrame extends JFrame implements ActionListener {
	static JMenu game = new JMenu("��Ϸ");
	JMenuItem newgame = game.add("����Ϸ");
	JMenuItem pause = game.add("��ͣ");
	JMenuItem goon = game.add("����");
	JMenuItem exit = game.add("�˳�");
	static JMenu help = new JMenu("����");
	JMenuItem about = help.add("����");
	Tetrisblok a = new Tetrisblok();
	static TetrisMp3 mp3sound;

	public TetrisFrame() {
		mp3sound = new TetrisMp3("��������2.mp3");
		ImageIcon bgimg = new ImageIcon("image/ͼ��.jpg");
		JLabel jpanelbgimg = new JLabel(bgimg);// ��ͼƬ����һ����ǩ��
		jpanelbgimg.setBounds(0, 0, 320, 395);// ���Ͻ�x�����Ͻ�y�����½�x�����½�y
		a.add(jpanelbgimg);// ��ӱ�ǩ����ͼƬ
		a.setBorder(new EmptyBorder(-5, 0, -5, 0));// �������ı߽磬�����û�к�ȣ����������϶��ʹ����ͼƬ������
		addKeyListener(a);
		this.add(a);
		newgame.addActionListener(this); // ����Ϸ�˵���
		pause.addActionListener(this); // ��ͣ�˵���
		goon.addActionListener(this); // �����˵���
		about.addActionListener(this); // ���ڲ˵���
		exit.addActionListener(this); // �˳��˵���
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newgame) // ����Ϸ�˵���
		{
			a.newGame();
		} else if (e.getSource() == pause) // ��ͣ�˵���
		{
			a.pauseGame();
		} else if (e.getSource() == goon) // �����˵���
		{
			a.continueGame();
		} else if (e.getSource() == about) // ���ڲ˵���
		{
			DisplayToast("���Ҽ��ƶ������ϼ���ת");
			
		} else if (e.getSource() == exit) // �˳��˵���
		{
			System.exit(0);
		}
	}

	public void DisplayToast(String str) {
		JOptionPane.showMessageDialog(null, str, "��ʾ", JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		TetrisFrame frame = new TetrisFrame();
		JMenuBar menu = new JMenuBar();
		frame.setJMenuBar(menu);
		menu.add(game);
		menu.add(help);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������ť����
		frame.setSize(320, 395);
		frame.setTitle("����˹����1.0��");
		// frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setResizable(false);
		// ��������ѭ�����š� ���˵������������������Ҳ�������mp3�ļ�ʹ�������Ƚ��鷳������mp3תwav�ļ�������audio���µ���ѭ������wav�ļ�����
		// �������� ѭ������ʹ�����̣߳����棬�������������ֹͣ
		mp3sound.loop();
	}
}
