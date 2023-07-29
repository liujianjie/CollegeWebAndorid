
package serviceImp;

import java.util.List;

import common.Hibernate_Dao;

import serviceI.IQqService;
import vo.AndroidQqDynamic;
import vo.AndroidQqHy;
import vo.AndroidQqMessage;
import vo.AndroidQqUser;

public class QqServiceImp extends Hibernate_Dao implements IQqService{

	public List selUser(String qqZhanghao,String mima) {
		return listbysql("select qq_id from android_qq_user where qq_zhanghao='"+qqZhanghao+"' and  qq_mima='"+mima+"'");
	}
	public boolean UpdUserStatu(Long qqId) {
		return executeSql("update  android_qq_user set qq_statu=1 where qq_id="+qqId);
	}
	public AndroidQqUser getUser(Long qqId) {
		return (AndroidQqUser) getObj(AndroidQqUser.class, qqId);
	}
	public List selhy(Long qqId) {//hy_id��Ϊ�˻�ȡ�����б�myqq_id��hyqq_id��Ϊ�˻�ȡ��̬�б�
		//select hy_id,myqq_id,hyqq_id from android_qq_hy where (myqq_id="+qqId+" and hy_statu = 1) or (hyqq_id="+qqId+" and hy_statu=1)
		//���� hy_state ����ҳ��ʱ�ж�
		return listbysql("select hy_id,myqq_id,hyqq_id from android_qq_hy where (myqq_id="+qqId+" and hy_statu = 1) or (hyqq_id="+qqId+" and hy_statu=1)");
	}
	@Override
	public AndroidQqHy getQqhy(Long hyid) {
		return (AndroidQqHy) getObj(AndroidQqHy.class, hyid);
	}
	//��Ӻ���֮���������� �������������
	public boolean addQqhy(AndroidQqHy qqhy){
		return addObj(qqhy);
	}
	//��Ӻ���֮��ѯ�й��Լ����ѵ����ݵ��б� ״̬Ϊ0
	public List selQqhyOfmy(Long qqId){
		return listbysql("select hy_id from android_qq_hy where (hyqq_id="+qqId+" and hy_statu=0)");
	}
	//�޸����� ״̬Ϊ1
	public boolean updHaoYouStatu(AndroidQqHy qqhy){
		return updObj(qqhy);
	}
	public List seldynamic(List qqhyidlist,int CurrPage,int PageCount) {
		//ƴ���ַ���
		String sql = "select dy_id from android_qq_dynamic where qq_id in (";
		for(int i=0;i<qqhyidlist.size();i++){
			Long id = (Long) qqhyidlist.get(i);
			sql+=id;
			//�ж��ǲ������һ��
			if(i!=qqhyidlist.size()-1){
				sql+=",";
			}
		}
		sql+=") order by dy_date desc ";//����ʱ������
		System.out.println(sql);
//		return listpagebysql(sql, CurrPage, PageCount);
		//����ҳ
		return listbysql(sql);
	}
	//��ȡ���ѵ�bean����list
	public AndroidQqDynamic getdynamic(Long dyId){
		return (AndroidQqDynamic) getObj(AndroidQqDynamic.class, dyId);
	}
	//��Ӷ�̬
	public boolean addQqDt(AndroidQqDynamic qqdynamic){
		return addObj(qqdynamic);
	}
	//ע��
	public boolean addUser(AndroidQqUser qquser){
		return addObj(qquser);
	}
	//������Ϣ ���
	public boolean addMsg(AndroidQqMessage msg){
		return addObj(msg);
	}
	//������Ϣ
	public AndroidQqMessage getMsg(Long mId){
		return (AndroidQqMessage) getObj(AndroidQqMessage.class, mId);
	}
	//���������ʱ ��ȡ����Ϣ�б�
	public List getChartList(Long qqId,Long hyId){
		return listbysql("select m_id from android_qq_message where (qq_id="+qqId+" and  m_jsid="+hyId+") or (qq_id="+hyId+" and  m_jsid="+qqId+") order by m_date");
	}
	//����Ϣҳ��    ��ȡ��Ϣ�б�
	public List getmidOfMsg(Long qqId){
		return listbysql("select qq_id,qq_zhanghao,qq_name,qq_touxiang,m_jsid,m_zhanghao,m_name,m_touxiang from android_qq_message where m_jsid="+qqId+" group by qq_id,qq_zhanghao,qq_name,qq_touxiang,m_jsid,m_zhanghao,m_name,m_touxiang");
	}
	public List selUserList(String xinxi){
		return listbysql("select qq_id from android_qq_user where qq_zhanghao like '%"+xinxi+"%' or qq_name like '%"+xinxi+"%'");
	}
	@Override
	public boolean alertUser(AndroidQqUser qquser) {
		return updObj(qquser);
	}
	@Override
	public List getHyList(Long hyqqId, Long qqId) {
		return listbysql("select hy_id from android_qq_hy where (myqq_id = "+qqId+" and hyqq_id = "+hyqqId+") or (myqq_id = "+hyqqId+" and hyqq_id = "+qqId+")");
	}
	@Override
	public boolean delHyuser(Long hyId) {
		return executeSql("delete from android_qq_hy where hy_id="+hyId);
	}
	public List getMsgXq(Long qq_id,Long m_jsid){
		return listbysql("select * from (select m_id from android_qq_message where (qq_id="+qq_id+" and  m_jsid="+m_jsid+") or (qq_id="+m_jsid+" and  m_jsid="+qq_id+") order by m_date desc) where rownum=1");
	}
}
