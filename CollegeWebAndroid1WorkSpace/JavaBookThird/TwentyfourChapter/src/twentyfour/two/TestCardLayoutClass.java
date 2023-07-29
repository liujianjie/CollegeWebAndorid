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
		super("卡片布局");
		
		cardlayout = new CardLayout();
		cardPanel = new JPanel(cardlayout);
		getContentPane().add(cardPanel, BorderLayout.CENTER);
		String [] labelNames = {"卡片A","卡片B","卡片C","卡片D","卡片E"};
		for(int i = 0; i <labelNames.length; i++){
			//创建代表卡片的标签对象
			final JLabel label = new JLabel(labelNames[i]);
			// 设置标签文本的位置
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("", Font.BOLD, 16));
			label.setForeground(new Color(255,  0 ,0));
			// 向采用卡片布局管理器的面板添加卡片
			cardPanel.add(label,labelNames[i]);
			
		}
		final JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);// 下方
		String [] buttonNames = {"第一个","前一个","卡片A","卡片B","卡片C","后一个","最后一个"};
		for( int i = 0; i < buttonNames.length; i++){
			final JButton button = new JButton(buttonNames[i]);
			buttonPanel.add(button);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = e.getActionCommand();
					if(str.equals("第一个")){
						cardlayout.first(cardPanel);
					}else if(str.equals("前一个")){
						cardlayout.previous(cardPanel);
					}else if(str.equals("卡片A")){
						cardlayout.show(cardPanel,"卡片A");
					}else if(str.equals("卡片B")){
						cardlayout.show(cardPanel,"卡片B");
					}else if(str.equals("卡片C")){
						cardlayout.show(cardPanel,"卡片C");
					}else if(str.equals("后一个")){
						cardlayout.next(cardPanel);
					}else if(str.equals("最后一个")){
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
