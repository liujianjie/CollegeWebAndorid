package �Ӱ�;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class �򿪱����ļ� extends JFrame{
	JLabel kj;
	public �򿪱����ļ�(){
		super();
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		kj=new JLabel("�Ǻ�");
		con.add(kj);
		kj.addMouseListener(new A());
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}
	public static void main(String[] args) {
		new �򿪱����ļ�();
	}
	class A extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == kj) {
				//String url = "E:/��ͼ��ҵ��ϰ/html��ϰ/������htmlҷ����������2015917�����Ŀ/��ҳ.html";
				String url = "F:/�Ǻ�/����������html��Ϸ/51CTO����-������Ϸ/Core/index.html";
				java.net.URI uri = java.net.URI.create(url);
				// ��ȡ��ǰϵͳ������չ
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						dp.browse(uri);
					} catch (Exception e1) {

					}// ��ȡϵͳĬ�������������
				}
			}
		}
	}
	
}
