package com.snake.mgame;

import java.awt.Graphics;

import com.snake.bean.GsnMapCrossNodeBean;
import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnCrossNodeDraw {
	// bean
	public GsnMapCrossNodeBean gsncnbean;
	public GsnCrossNodeDraw(){
		gsncnbean = new GsnMapCrossNodeBean();
	}
	public void setValueToBean(GsnMapCrossNodeBean g){
		gsncnbean = new GsnMapCrossNodeBean(g);
	}
	// draw
	public void draw(Graphics g){
		// »æÖÆ Á½¸ö
		g.fillRect(gsncnbean.firstpos[1] * GsnMainGameConstants.drawSize, gsncnbean.firstpos[0] * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);
		g.fillRect(gsncnbean.secondpos[1] * GsnMainGameConstants.drawSize, gsncnbean.secondpos[0] * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize);
	}
}
