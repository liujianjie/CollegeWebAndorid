package service_goods;

import java.util.List;

import bean.BottomBean;
import bean.Goodsbean;
import bean.MoldBean;

public interface IGoods {
	//���շ���id������Ʒ 
	public List selGoods(int id);

	//��̨��ѯ��Ʒ��ҳ
	public List selhtGoods(int pagecount,int currpage);
	
	public List selBottom();
	
	public boolean addGoods(Goodsbean god);
	
	public boolean delGoods(int id);
	
	public Goodsbean selhang(int id);
	
	public boolean alerthang(Goodsbean god);
	
	//��ѯ3����Ʒ ���շ��� bottomid
	public List selthreeGoods(int id,int pageCount);
	
	//��ѯ������Ʒ
	public List selxsgoods(String name);
	
	//���ڵķ���
	public BottomBean selbottom(int bottom_id);
	
	//���ڵ�����
	public MoldBean selmold(int mold_id);
	
	//ͨ�������Ķ��ٶԱ�����ȥ��Ʒ ��ҳ������
	public List selfyGoods(int pagecount,int currpage);
	
	//�鿴����������
	public int selgoodscount();
	
	//ͨ��bottomid���鿴��Ʒ ��ת goodslistҳ�� ��ҳ
	public List sellistgoods(int pagecount,int currpage,int id);
	
	//�鿴��������µ�������Ʒ
	public int selbottomgoodscount(int bottom_id);
	
	//����һ������bottom_id��������������Ʒ
	public Goodsbean seldangegoods(int bottom_id);
}
