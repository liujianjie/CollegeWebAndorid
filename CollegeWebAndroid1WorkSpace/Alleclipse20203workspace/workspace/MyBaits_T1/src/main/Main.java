package main;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bean.Dept;
import serviceI.DeptI;
import util.MybatisUtil;

public class Main implements DeptI{

	@Override
	public List<Dept> selDept() {
		List<Dept> list = null;
		try {
			Reader reader = Resources.getResourceAsReader("MyBatis.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(reader);
			SqlSession session = ssf.openSession();
			list = session.selectList("serviceI.DeptI.selDept");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return list;
	}
	public static void main(String[] args) {
		Main mains = new Main();
		List<Dept> dlist = mains.selDept();
		for(Dept dept : dlist){
			System.out.println(dept.getDname()+dept.getLoc()+dept.getDeptno());
		}
//		Dept dept = mains.getDept(20);
//		System.out.println(dept.getDname());
		
		//��map��ѯ
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("dnames", "ACCOUNTING");
//		map.put("dlocs", "NEW YORK");
//		Dept dept = mains.getDept(map);
//		System.out.println(dept.getDeptno());
//		
//		mains.add(map);//���
		
//		Dept deptss= new Dept();
//		deptss = new Dept(23,"�̵���","��¥dd");
//		mains.update(deptss);//�޸�
//		
//		mains.delete(23);//ɾ��
	}
	@Override
	public Dept getDept(Map<String, Object> map) {
		//·��Ϊ �ӿڵķ�����·�� ��Ϊ��map������ ���� config������map ����config��ȡ����Դ�õ�session
		return MybatisUtil.opensession().selectOne("serviceI.DeptI.getDept", map);
	}
	@Override
	public int add(Map<String, Object> map) {
		SqlSession session =MybatisUtil.opensession();
		int count = session.insert("serviceI.DeptI.add",map);
		session.commit();
		return count;
	}
	@Override
	public int update(Dept dept) {
		SqlSession session =MybatisUtil.opensession();
		int count = session.insert("serviceI.DeptI.update",dept);//yong insertҲ����
		session.commit();
		return count;
	}
	@Override
	public int delete(Integer deptnos) {
		SqlSession session =MybatisUtil.opensession();
		int count = session
				.insert("serviceI.DeptI.delete",deptnos);//yong insertҲ����
		session.commit();
		return count;
	}
}
