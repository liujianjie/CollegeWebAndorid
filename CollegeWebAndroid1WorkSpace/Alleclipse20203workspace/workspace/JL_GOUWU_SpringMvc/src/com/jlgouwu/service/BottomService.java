package com.jlgouwu.service;

import java.util.List;

import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Mold;



public interface BottomService {
	public List<Bottom> selbottom();
	
	public List<Mold> selMold();
	
	public boolean addbottom(Bottom bot);
	
	public boolean delbottom(int id);
	
	public Bottom selhang(int id);
	
	public boolean alerthang(Bottom emp);
	
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
