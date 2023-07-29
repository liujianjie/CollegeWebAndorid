package com.snake.mgame;

import java.awt.Graphics;
import java.util.Random;

import com.snake.mgameconfig.GsnMainGameConstants;

public class GsnFood extends Thread{
	public int curi;
	public int curj;
	boolean islive;// 是否还存在
	boolean controlStart = true;//控制开始
	boolean isrun;// 是否启动线程
	long updatetime;// 更新位置时间
	int state;// 什么样的食物，有毒食物，有毒但加速食物，普通食物，高级食物
	
	public int curCount;// 记录是更新多少次的，为了标记bfs时候是否更新了
	
	Random ran = new Random();
	public GsnFood(){
		islive = false;
		isrun = false;
	}
	public void generate(){// 创造食物
		if(!islive){
			curi = ran.nextInt(41);
			curj = ran.nextInt(60);// 第一次生成
			while(checkNotInOtherShape()){// 重新生成
				curi = ran.nextInt(41);
				curj = ran.nextInt(60);
			}
//			System.out.println(curi+" "+curj+" testgeneratefoodiandj");
			islive = true;
		}
	}
	public boolean checkNotInOtherShape(){// 检测是否在在平地中
		if(GsnMainGameConstants.dynamicmapdata[curi][curj] == 0){
			return false;
		}
		return true;
	}
	// 死亡重新创造
	public void deadUpdate(){
		islive = false;
		generate();
	}
	public void draw(Graphics g){
		if(islive){
			g.fillRoundRect(curj * GsnMainGameConstants.drawSize, curi * GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize, GsnMainGameConstants.drawSize
					, 8, 8);
		}
	}
	// 开始更新
	public void startUpdate(){// 更新
		isrun = true;
	}
	public void endUpdate(){// 不跟新
		isrun = false;
	}
	public void endThread(){
		controlStart = false;
		isrun = false;
//		stop();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(controlStart){
			System.out.print("");
			// 休眠多少秒来更新食物位置
			if(isrun){
				updatetime = (long)ran.nextInt(6000) + 12000;// 12~16s浮动
//				System.out.println(updatetime);
				try {
					Thread.sleep(updatetime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				// 先睡再更新 ，并且睡完如果是暂停的就不要更新
				if(isrun){
					deadUpdate();
					curCount++;
				}
			}
		}
//		System.out.println("食物停止！！！！！！！！！！！！");
	}
}
