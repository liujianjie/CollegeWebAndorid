package com.dc.dao.Function;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface FunDAO {
	 //��ҳ��ѯ��������
	 public List FindParentFunction(PageEntity page);
	 //��ѯ���й���
	 public List FindALLFunctions();
	//��ѯ���й������ƺ�ID
	 public List findFunctions(String functionid);
	 //����ID��ѯ����
	 public Map findFunctionsByid(String functionid);
     //����
     public boolean insertFunction(String functionname,String functiondec,String functionurl,String state,String functionparentid, String userid,String username);
     //�޸�
     public boolean updateFunction(String functionname,String functiondec,String functionurl,String state,String functionparentid, String userid,String username,String functionid);
     //��ҳ��ѯ�������� ,���ݸ������Ʋ�ѯ�ӹ���
     public List Selfunction(String functionid,PageEntity page);
     //�޸Ĺ���״̬
     public boolean upOrDown(String state,String functionid);
     //У�鹦�����Ƿ��ظ�
     public boolean checkFunctions(String functionname,String functionid);
     //��ѯ���й���״̬
     public List FindState();
}
