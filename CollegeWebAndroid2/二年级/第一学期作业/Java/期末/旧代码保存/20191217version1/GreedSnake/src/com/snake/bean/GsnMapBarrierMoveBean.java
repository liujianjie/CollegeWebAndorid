package com.snake.bean;

// ��ͼ�ϰ������� һ���ϰ��� ���ݷ����count������ϰ���
public class GsnMapBarrierMoveBean {
	public int bari;// ���Ͻ�λ��y
	public int barj;// ���Ͻ�λ��x
	public int barwidth;// �ƶ��Ŀ�� x
	public int barheight;// �ƶ��ĸ߶� y
	public int bardir;// ���� ֻ������ �� ���ң�0�����£�1������
	public int barwide;// �ƶ��ĸ����ж��ٸ� 
	public long barspeed;// ���߳� ����s
	@Override
	public String toString() {
		return "bari:" + bari + 
				"&barj:" + barj + 
				"&barwidth:" + barwidth+ 
				"&barheight:"+barheight+
				"&bardir:" + bardir + 
				"&barwide:" + barwide +
				"&barspeed:" + barspeed + "";
	}
	public static void main(String[] args) {
//		System.out.println(new GsnMapBarrierMoveBean());
	}
}