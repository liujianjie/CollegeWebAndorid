package twentyfour.three;


import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGirdLayoutClass extends JFrame{
	
	public TestGirdLayoutClass(){
		super("���񲼾ֹ�����");
		
		final JButton button = new JButton("A");
		final GridBagConstraints gridBag = new GridBagConstraints();
		// ��ʼ��Ϊ��һ�е�һ��
		gridBag.gridy = 0;
		gridBag.gridx = 0;
		
		//��һ�еķֲ�ʽΪ10%
		gridBag.weightx = 10;
		gridBag.fill = GridBagConstraints.HORIZONTAL; 
		getContentPane().add(button, gridBag);
		
		final JButton button2 = new JButton("B");
		final GridBagConstraints gridBag_1 = new GridBagConstraints();
		gridBag_1.gridy = 0;
		gridBag_1.gridx = 1;
		// �����齨����С����
		gridBag_1.insets = new Insets(0, 5, 0, 5);
		// ���õ�һ�еķֲ�ʽΪ20%
		gridBag_1.weightx = 20;
		gridBag_1.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(button2, gridBag_1);

		final JButton button3 = new JButton("C");
		final GridBagConstraints gridBag_2 = new GridBagConstraints();
		gridBag_2.gridy = 0;
		gridBag_2.gridx = 2;
		// ���ռ����
		gridBag_2.gridheight = 2; //
		gridBag_2.insets = new Insets(0, 5, 0, 0);
		// ���õ�һ�еķֲ�ʽΪ30%
		gridBag_2.weightx = 30;
		// ͬʱ��������Ŀ�Ⱥ͸߶�
		gridBag_2.fill = GridBagConstraints.BOTH;
		getContentPane().add(button3, gridBag_2);
		
		final JButton button4 = new JButton("D");
		final GridBagConstraints gridBag_3 = new GridBagConstraints();
		gridBag_3.gridy = 0;
		gridBag_3.gridx = 3;
		// ���ռ4��
		gridBag_3.gridheight = 4; 
		// ������������Ҳ����С����
		gridBag_3.insets = new Insets(0, 5, 0, 5);
		// ���õ�һ�еķֲ�ʽΪ40%
		gridBag_3.weightx = 40;
		// ͬʱ��������Ŀ�Ⱥ͸߶�
		gridBag_3.fill = GridBagConstraints.BOTH;
		getContentPane().add(button4, gridBag_3);
		
		setBounds(100, 100, 500 ,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
//		new TestGirdLayoutClass();
		int i = -1;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.valueOf("01111111111111111111111111111111",2).toString());
	}
}
