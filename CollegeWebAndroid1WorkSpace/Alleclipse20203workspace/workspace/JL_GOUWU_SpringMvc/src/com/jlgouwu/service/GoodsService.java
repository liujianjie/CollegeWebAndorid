package com.jlgouwu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Goods;
import com.jlgouwu.pojo.Mold;


public interface GoodsService {
	//���շ���id������Ʒ 
	public List<Goods> selGoods(int id);

	//��̨��ѯ��Ʒ��ҳ
	public List<Goods> selhtGoods(int pagecount,int currpage);
	
	public List<Bottom> selBottom();
	
	public boolean addGoods(Goods god);
	
	public boolean delGoods(int id);
	
	public Goods selhang(int id);
	
	public boolean alerthang(Goods god);
	
	//��ѯ3����Ʒ ���շ��� bottomid
	public List<Goods> selthreeGoods(int id,int pageCount);
	
	//��ѯ������Ʒ
	public List<Goods> selxsgoods(String name);
	
	//���ڵķ���
	public Bottom selbottom(int bottom_id);
	
	//���ڵ�����
	public Mold selmold(int mold_id);
	
	//ͨ�������Ķ��ٶԱ�����ȥ��Ʒ ��ҳ������
	public List<Goods> selfyGoods(int pagecount,int currpage);
	
	//�鿴����������
	public int selgoodscount();
	
	//ͨ��bottomid���鿴��Ʒ ��ת goodslistҳ�� ��ҳ
	public List<Goods> sellistgoods(int pagecount,int currpage,int id);
	
	//�鿴��������µ�������Ʒ
	public int selbottomgoodscount(int bottom_id);
	
	//����һ������bottom_id��������������Ʒ
	public Goods seldangegoods(int bottom_id);
	
	// ���շ���ɾ��
	public boolean delGoodsByBid(int bottom_id);
}
