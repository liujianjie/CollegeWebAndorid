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
			// TODO 自动生成的 catch 块
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
		
		//用map查询
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("dnames", "ACCOUNTING");
//		map.put("dlocs", "NEW YORK");
//		Dept dept = mains.getDept(map);
//		System.out.println(dept.getDeptno());
//		
//		mains.add(map);//添加
		
//		Dept deptss= new Dept();
//		deptss = new Dept(23,"教导处","三楼dd");
//		mains.update(deptss);//修改
//		
//		mains.delete(23);//删除
	}
	@Override
	public Dept getDept(Map<String, Object> map) {
		//路径为 接口的方法的路径 因为在map配置了 而在 config配置了map 而用config获取数据源得到session
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
		int count = session.insert("serviceI.DeptI.update",dept);//yong insert也可以
		session.commit();
		return count;
	}
	@Override
	public int delete(Integer deptnos) {
		SqlSession session =MybatisUtil.opensession();
		int count = session
				.insert("serviceI.DeptI.delete",deptnos);//yong insert也可以
		session.commit();
		return count;
	}
}
