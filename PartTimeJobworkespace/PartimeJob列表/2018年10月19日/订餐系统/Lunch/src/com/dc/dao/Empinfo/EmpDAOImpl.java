package com.dc.dao.Empinfo;

import java.util.HashMap;
import java.util.List;

import com.dc.util.BaseDAO;
import com.dc.util.StringUtil;
public class EmpDAOImpl implements EmpDAO{
/**
 * ����Ա��id��ѯԱ����Ϣ
 */
	public List<HashMap> selectOneEmpById(String empid) {
		BaseDAO base= new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select a.*,");
		sql.append(" b.emp_user,b.emp_password,b.emp_account_id  ");
		sql.append(" from emp a");
		sql.append(" left join emp_account b on a.emp_id=b.emp_id");
		sql.append(" where a.emp_id=?");
		try {
			List<HashMap> list=base.selectInfo(sql.toString(), new Object[]{empid});
			if(list!=null&&list.size()>0){
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
/**
 * ����û����Ƿ����
 */
	public boolean checkUserName(String username, String accountid) {
		String sql="select * from emp_account where emp_user=?";
		BaseDAO base=new BaseDAO();
		try {
			if(accountid!=null&&!accountid.equals("")){
				sql+=" and emp_account_id!="+accountid;
				//System.out.println("checkusername:"+sql);
			}
				List list=base.selectInfo(sql, new Object[]{username});
				if(list!=null&&list.size()>0){
					return true;
				}else{
					return false;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * �޸�Ա����Ϣ
	 */
	public int updateThisEmp(String departid,String ssuserid,String ssusername,String accountid, String empid, String empname,
			String phone, String pwd, String username, String province,
			String city, String district, String day, String month,
			String year, String age, String sex,String address,String dutyid){
			BaseDAO base=new BaseDAO();
			String sqlemp="UPDATE emp_account SET emp_user=? , emp_password=?  WHERE emp_account_id= ?";
			try {
				int i1=base.updateSql(sqlemp, new Object[]{username,pwd,accountid});
				String hiredate=year+"-"+month+"-"+day;
				String sqlacc="UPDATE emp SET emp_name=? , phone=?,hiredate=?,"+
				"sex=?,age=?,province=?,city=?,district=?,address=?,duty_id=?,user_id=?,user_name=?,date=now(),depart_id=?  WHERE emp_id=?";	
				int i2=base.updateSql(sqlacc, new Object[]{empname,phone,hiredate,sex,age,province,city,district,address,dutyid,ssuserid,ssusername,departid,empid});
				if(i1!=0&&i2!=0){
					return 1;
				}
				else{
					return -1;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}
/**
 * ����һ��Ա��
 */
	public int insertOneEmp(String departid,String ssuserid,String ssusername,String empname, String phone, String username,
			String pwd, String province, String city, String district,
			String day, String month, String year, String age, String sex,
			String address,String dutyid) {
		String hiredate=year+"-"+month+"-"+day;
		String sql="insert into emp(depart_id,emp_name, phone,hiredate,"+
				"sex,age,province,city,district,address,duty_id,user_id,user_name,date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
		BaseDAO base=new BaseDAO();
		try {
			if(!StringUtil.checkNotNull(username)){
				return -1;
			}
			int key=base.insertSql(sql, new Object[]{departid,empname,phone,hiredate,sex,age,province,city,district,address,dutyid,ssuserid,ssusername});
			String sql2="insert into emp_account(emp_user,emp_password,emp_id,state)" +
					"values(?,?,?,1)";
			
			int accountid=base.insertSql(sql2, new Object[]{username,pwd,key});
			//int result=base.updateSql("insert into role_account(emp_account_id,role_id)values(?,?)",new Object[]{accountid});
			if(key!=0&&accountid!=0){
				return 1;
			}
			else{
				return -1;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * ��ѯ���в���
	 */
			public List<HashMap> selectAllDuty() {
				BaseDAO base=new BaseDAO();
				String sql="select * from duty where state=0";
				try {
					List<HashMap> list =base.selectInfo(sql, null);
					return list;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
	/**
	 * ��ѯ���н�ɫ
	 */
			public List<HashMap> selectAllRole() {
				BaseDAO base=new BaseDAO();
				String sql="select * from role where state=0";
				try {
					List<HashMap> list =base.selectInfo(sql, null);
					return list;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
	@Override
/**
 * ��ѯһԱ�����н�ɫ
 */
	public List<HashMap> selectEmpRole(String empaccountid) {
		BaseDAO base =new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select a.role_name,a.role_level,a.state,b.* from role a");
		sql.append(" left join role_account b on a.role_id=b.role_id");
		sql.append(" where b.emp_account_id=?");
		try {
			List<HashMap> list=base.selectInfo(sql.toString(), new Object[]{empaccountid});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	/**
	 * ��������Ա����ɫ
	 */
	public boolean insertEmpRole(String empaccountid, String[] roleid) {
		BaseDAO base =new BaseDAO();
		int count;
		String 	sql="DELETE FROM role_account WHERE  emp_account_id=?";
		String sql2="INSERT INTO role_account (role_id, emp_account_id) VALUES (?, ?)";
		try {
			int i=base.updateSql(sql, new Object[]{empaccountid});
			if(StringUtil.checkNotNull(roleid)){
				count=roleid.length;
			}
			else{
				 count=0;
			}
			for(int j=0;j<count;j++){
				String rolei=roleid[j];
				base.updateSql(sql2, new Object[]{rolei,empaccountid});
			}
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	/**
	 * ��ѯ���в���
	 */
	public List<HashMap> selectAllDepart() {
		BaseDAO base =new BaseDAO();
		String sql="SELECT * FROM `depart` where state=0";
		try {
			List list=base.selectInfo(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	/**
	 * ͨ�����Ų�ְ��
	 */
	public List selectDutyBydepid(String departid) {
		BaseDAO base =new BaseDAO();
		String sql="select *FROM duty where depart_id=? and state=0";
		try {
			List list=base.selectInfo(sql, new Object[]{departid});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
			
}
