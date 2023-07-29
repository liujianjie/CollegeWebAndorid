package twentyfour.two;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TestCardLayoutClass extends JFrame{
	private JPanel cardPanel;
	private CardLayout cardlayout;
	
	public TestCardLayoutClass(){
		super("��Ƭ����");
		
		cardlayout = new CardLayout();
		cardPanel = new JPanel(cardlayout);
		getContentPane().add(cardPanel, BorderLayout.CENTER);
		String [] labelNames = {"��ƬA","��ƬB","��ƬC","��ƬD","��ƬE"};
		for(int i = 0; i <labelNames.length; i++){
			//��������Ƭ�ı�ǩ����
			final JLabel label = new JLabel(labelNames[i]);
			// ���ñ�ǩ�ı���λ��
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("", Font.BOLD, 16));
			label.setForeground(new Color(255,  0 ,0));
			// ����ÿ�Ƭ���ֹ������������ӿ�Ƭ
			cardPanel.add(label,labelNames[i]);
			
		}
		final JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);// �·�
		String [] buttonNames = {"��һ��","ǰһ��","��ƬA","��ƬB","��ƬC","��һ��","���һ��"};
		for( int i = 0; i < buttonNames.length; i++){
			final JButton button = new JButton(buttonNames[i]);
			buttonPanel.add(button);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = e.getActionCommand();
					if(str.equals("��һ��")){
						cardlayout.first(cardPanel);
					}else if(str.equals("ǰһ��")){
						cardlayout.previous(cardPanel);
					}else if(str.equals("��ƬA")){
						cardlayout.show(cardPanel,"��ƬA");
					}else if(str.equals("��ƬB")){
						cardlayout.show(cardPanel,"��ƬB");
					}else if(str.equals("��ƬC")){
						cardlayout.show(cardPanel,"��ƬC");
					}else if(str.equals("��һ��")){
						cardlayout.next(cardPanel);
					}else if(str.equals("���һ��")){
						cardlayout.last(cardPanel);
					}
					
				}
			});
		}
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestCardLayoutClass();
	}
}
