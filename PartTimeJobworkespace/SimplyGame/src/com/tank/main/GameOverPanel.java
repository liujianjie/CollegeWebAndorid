package com.tank.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tank.main.GameMainPanel.B;
import com.tank.main.GameMainPanel.C;

public class GameOverPanel  extends JPanel{
	
	JLabel jl;
	public GameOverPanel(){
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		jl = new JLabel("GAME OVER!YOU GET POINTS:");
		jl.setBounds(0,70,600,60);
		jl.setBounds(0,250,700,100);
		Font f2 = new Font("ËÎÌו",Font.PLAIN,34);
		jl.setFont(f2);
		jl.setForeground(Color.red);
		this.add(jl);
	}
	public void setGameOVerString(int point){
		jl.setText("GAME OVER!YOU GET POINTS:"+point);
	}
}
