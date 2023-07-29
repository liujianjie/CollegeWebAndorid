package serviceI;

import java.util.List;

import vo.AndroidQqDynamic;
import vo.AndroidQqHy;
import vo.AndroidQqMessage;
import vo.AndroidQqUser;

public interface IQqService {
	//ע��
	public boolean addUser(AndroidQqUser qquser);
	//�޸�
	public boolean alertUser(AndroidQqUser qquser);
	//��¼ �Ƿ����û�
	public List selUser(String qqZhanghao,String mima);
	//��¼ �޸�״̬
	public boolean UpdUserStatu(Long qqId);
	//�û���Ϣ ��ѯ������Ϣ
	public AndroidQqUser getUser(Long qqId);
	//������Ϣ ��ѯ�û��ĺ����б��id
	public List selhy(Long qqId);
	//��ȡ������Ϣ ��ȡ���ѵ�bean����list
	public AndroidQqHy getQqhy(Long hyid);
	//��Ӻ���֮���������� �������������
	public boolean addQqhy(AndroidQqHy qqhy);
	//��Ӻ���֮��ѯ�й��Լ����ѵ������б�
	public List selQqhyOfmy(Long qqId);
	//�޸����� ״̬Ϊ1
	public boolean updHaoYouStatu(AndroidQqHy qqhy);
	//��ȡ��̬ ��ѯ���Ѷ�̬��id
	public List seldynamic(List qqhyidlist,int CurrPage,int PageCount);
	//��ȡ��̬ʵ����Ϣ ��ȡ���ѵ�bean����list
	public AndroidQqDynamic getdynamic(Long dyId);
	//��Ӷ�̬
	public boolean addQqDt(AndroidQqDynamic qqdynamic);
	//������Ϣ ���
	public boolean addMsg(AndroidQqMessage msg);
	//������Ϣ ��ѯ
	public AndroidQqMessage getMsg(Long mId);
	//���������ʱ ��ȡ����Ϣ�б�
	public List getChartList(Long qqId,Long hyId);
	//����Ϣҳ��    ��ȡ��Ϣ�б�
	public List getmidOfMsg(Long qqId);
	//��Ӻ��Ѳ�ѯ�û��б�
	public List selUserList(String xinxi);
	
	//ɾ������
	public List getHyList(Long hyqqId,Long qqId);
	public boolean delHyuser(Long hyId);
	
	//��ȡ����һ����Ϣ
	public List getMsgXq(Long qq_id,Long m_jsid);
}
