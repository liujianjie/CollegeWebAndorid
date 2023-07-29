package com.snake.bean;

// 地图的简要信息
public class GsnMapInFoBean {
	public String authorname;// 作者名称
	public String mapname;// 地图名称
	public String mappwd;// 地图密码
	public String creationtime;// 创建时间
	public String tips;// 概要
	public int barcount;// 障碍物多少个
	public int levelorder;// 等级编号
	// 地图上穿越节点的信息
	public int crossnodecount;// 数量
	@Override
	public String toString() {
		return "authorname:" + authorname + "&mapname:" + mapname + "&mappwd:" + mappwd
				+ "&creationtime:" + creationtime + "&tips:" + tips + "&barcount:"
						+ barcount + "&levelorder:" + levelorder  + "&crossnodecount:" + crossnodecount  + "";
	}
	public GsnMapInFoBean(){
		
	}
	public GsnMapInFoBean(GsnMapInFoBean be){
		this.authorname = new String(be.authorname);
		this.mapname = new String(be.mapname);
		this.mappwd = new String(be.mappwd);
		this.creationtime = new String(be.creationtime);
		this.tips = new String(be.tips);
		this.barcount = be.barcount;
		this.levelorder = be.levelorder;
		this.crossnodecount = be.crossnodecount;
	}
}
