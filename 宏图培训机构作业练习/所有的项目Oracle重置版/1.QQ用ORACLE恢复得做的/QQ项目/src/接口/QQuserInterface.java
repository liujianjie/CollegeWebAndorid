package �ӿ�;

import java.util.List;
import java.util.Vector;

import QQ���ݿ���Ϣ.QQgame;
import QQ���ݿ���Ϣ.QQuser;
import QQ���ݿ���Ϣ.QQhistory;

public interface QQuserInterface {
	public boolean add(QQuser s);//�����Ϣ�����ݿ�
	
	public boolean addQqgame(QQgame g);//��Ϸ��Ϣ��ӵ����ݿ�
	
	public boolean QQID(String qqnum);//��ѯqq���ǲ���Ψһ
	
	public QQuser chkuser(QQuser quer);//�Ա���Ϣ�Ƿ���ȷ
	
	public boolean updstate(String qqnum,int state);//�ı�����״̬
	
	public boolean addhistory(QQhistory qqh);//����ʷ��Ϣ

	public List selhi();	//��ѯ��¼��ʷ
	
	public Vector<QQuser> selectusergroupname(String myqq,String groupname);//��ѯ������Ϣ
	
	public Vector<Vector> selusers(QQuser user);//��ѯ���� ���غ�����Ϣ��vector��ʽ
	
	public boolean selhy(String myq,String fyq);//��ѯ�����Ƿ�����Լ����б���
	
	public QQuser selQQuserbyfind(String qqnum);//���Ѷ���
	
	public void addfrid(String myqnum,String fyqnum,String groupname);//��Ӻ���

	public String mimanull(String myqnum);//�����Ϊ��
	
	public boolean upfrid(String myqq,String hyqq);//ɾ������
	
	public boolean movegroup(String myqnum,String fyqnum,String groupname);//�ƶ�����
	
	public boolean upduser(QQuser quser);//�޸�����
	public boolean upgameuser(QQgame quser);//��Ϸ������ҲҪ�޸�
	
	public QQuser selzt(String qqnum);//��ѯ״̬
	
	public QQuser chkqqnum(QQuser quer);//�һ�������˺��Ƿ���ȷ
	public QQuser chkqqziliao(QQuser quer);//�һ�����������Ƿ���ȷ
	
	public void addscore(String qqnum,int score);//�ı�̰���ߵķ���

	public boolean chekhui(String qqnum);//�ǲ��ǻ�Ա
	
	public QQgame shenode(String qqnum);//��ѯ�߽�
	
	public boolean updshenode(String qqnum,int node,int shetoux0,int shetouy0,int shetoux1,int shetouy1,int foodx,int foody,int direction);//�ı��߽ں���ͷ����
	
	public int seltxzgk(String qqnum);//��ѯ�����ӹؿ���
	
	public boolean savetxzgk(String qqnum,int level);//�����󱣴������ӹؿ���
	
	public Vector<Vector> selscore();//����
	
	public boolean vipzhuce(String qqnum);//��Աע��
	
	public void TestAddHistory();
}
