package snake;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class fenshu extends JFrame{
	public fenshu(snake t){
		super();
		Container con=getContentPane();
		setLayout(null);
		this.setUndecorated(true);//нч╠ъ©Р
		JLabel tou=new JLabel("GAME OVER!!");
		tou.setBounds(150,0,120,40);
		con.add(tou);
		System.out.println(t.count);
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);	
	}
}
