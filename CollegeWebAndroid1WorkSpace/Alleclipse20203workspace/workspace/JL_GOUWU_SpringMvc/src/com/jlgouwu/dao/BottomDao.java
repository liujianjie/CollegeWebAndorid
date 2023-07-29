package com.jlgouwu.dao;

import java.util.List;

import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Mold;



public interface BottomDao {
	public List<Bottom> selbottom();
	
	public List<Mold> selMold();
	
	public int addbottom(Bottom bot);
	
	public int delbottom(int id);
	
	public Bottom selhang(int id);
	
	public int alerthang(Bottom emp);
	
	//��������id���ҷ���
	public List<Bottom> selfenlei(int mold_id);
	
	//��������id��ѯ��һ��bottom_id��ֵ �Ա�����Ʒ
	public int selonnbottom_id(int mold_id);
	
	//��ѯ������
	public String selbottomname(int bottomid);
	
	//��ѯ������
	public String selMold2(int moldid);
	
	// ����һ������id����һ����������
	public Bottom seloneBottomByMoldId(int moldId);
}
