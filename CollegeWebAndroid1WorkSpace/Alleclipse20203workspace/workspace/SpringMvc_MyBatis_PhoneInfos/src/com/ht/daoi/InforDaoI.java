package com.ht.daoi;

import java.util.List;
import java.util.Map;

import com.ht.bean.Informations;

public interface InforDaoI {
	//��ѯ�б�
	public List<Informations> selinforlist();
	//��ȡһ����Ѷ
	public Informations getinfor(Long id);
	//�޸�һ����Ѷ����Ϣ
	public int alertinfor(Map<String,Object> map);
		
}
