package twentythree.one.three;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import twentythree.one.two.TestTablePane;

public class TestDesktopPane extends JFrame {
	JDesktopPane destop;
	InternalFrame in1,in2,in3;
	public TestDesktopPane(){
		super("������� �� �ڲ�����");
		
//		in1 = new InternalFrame("in1");
//		in2 = new InternalFrame("in2");
//		in3 = new InternalFrame("in3");
		
		destop = new JDesktopPane();
		// �����ڲ������϶�ģʽ ����ѽ ����
	
		
		getContentPane().add(destop, BorderLayout.CENTER);
		final JLabel backlabel = new JLabel();
		URL resource = TestTablePane.class.getResource("34.jpg");
		ImageIcon ic = new ImageIcon(resource);
		backlabel.setIcon(ic);
		// �����������ʾλ�úʹ�С
		backlabel.setBounds(0, 0, ic.getIconWidth(), ic.getIconHeight());
		
		// ����ǩ�����ӵ�ָ������λ�� ��ײ� Ŷ
		destop.add(backlabel, new Integer(Integer.MIN_VALUE));
		
		//������ק��ʽ �����ػ�
		destop.setDragMode(JDesktopPane.LIVE_DRAG_MODE); 
		getContentPane().add(destop, BorderLayout.CENTER);
		
		
		// �ڲ��� �ð�ť����
		JPanel p1 = new JPanel();
		JButton b1 = new JButton("in1");
		JButton b2 = new JButton("in2");
		JButton b3 = new JButton("in3");
		p1.add(b1);p1.add(b2);p1.add(b3);

		b3.addActionListener(new ButtonCreateInframe("in3",in3));
		b2.addActionListener(new ButtonCreateInframe("in2",in2));
		b1.addActionListener(new ButtonCreateInframe("in1",in1));
		
		getContentPane().add(p1, BorderLayout.SOUTH);
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestDesktopPane();
	}
	
	//�̳��ڲ��� �ѳ�ʼ����Ϣ��������
	private class InternalFrame extends JInternalFrame{
		public InternalFrame(String title){
			super(title);
			setResizable(true);
			setClosable(true);
			setIconifiable(true);
			setMaximizable(true);
			// ���ͼƬ��·��
			URL resource = TestTablePane.class.getResource("img1.png");
			ImageIcon ic = new ImageIcon(resource);
			setFrameIcon(ic);
		}
	}

	public class ButtonCreateInframe implements ActionListener{
		InternalFrame inframe;
		String title;
		public ButtonCreateInframe(String title,InternalFrame inframe){
			this.title = title;
			this.inframe = inframe;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(inframe == null || inframe.isClosed()){
				// ��ȡ�������������ڲ����� ��ǰ���������ʾ��
				JInternalFrame[] allframes = destop.getAllFrames();
				// ������������ӵ���ڲ���������� ÿ��xλ�õ���titleBarhight ��ô��  yҲ���ŵ��ӣ�
//				int titleBarhight = 0 * allframes.length;
				int titleBarhight = 30 * allframes.length;
				int x = 10 + titleBarhight, y = x;
				int width = 250, height = 180;
				inframe = new InternalFrame(title);
				// ���ô������ʾλ�ü���С
				inframe.setBounds(x, y , width, height);
				inframe.setVisible(true);
				
				destop.add(inframe); // ��ӵ�����
				
			}
			try {
				// ѡ�д���
				inframe.setSelected(true);// �����
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
