package com.snake.bean;

// ��ͼ�ļ�Ҫ��Ϣ
public class GsnMapInFoBean {
	public String authorname;// ��������
	public String mapname;// ��ͼ����
	public String mappwd;// ��ͼ����
	public String creationtime;// ����ʱ��
	public String tips;// ��Ҫ
	public int barcount;// �ϰ�����ٸ�
	public int levelorder;// �ȼ����
	// ��ͼ�ϴ�Խ�ڵ����Ϣ
	public int crossnodecount;// ����
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
