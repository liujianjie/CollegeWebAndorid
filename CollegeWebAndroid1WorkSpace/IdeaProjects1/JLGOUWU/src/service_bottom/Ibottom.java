package service_bottom;

import java.util.List;

import bean.BottomBean;


public interface Ibottom {
	public List selbottom();
	
	public List selMold();
	
	public boolean addbottom(BottomBean bot);
	
	public boolean delbottom(int id);
	
	public BottomBean selhang(int id);
	
	public boolean alerthang(BottomBean emp);
	
	//��������id���ҷ���
	public List selfenlei(int mold_id);
	
	//��������id��ѯ��һ��bottom_id��ֵ �Ա�����Ʒ
	public int selonnbottom_id(int mold_id);
	
	//��ѯ������
	public String selbottomname(int bottomid);
	
	//��ѯ������
	public String selMold(int moldid);
	
	// ����һ������id����һ����������
	public BottomBean seloneBottomByMoldId(int moldId);
}
