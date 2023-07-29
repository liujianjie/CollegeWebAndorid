package com.aaa.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

//帮助实现所有的分页查询
@Component
public class PageUtil {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	//得到分页的相关数据
    public  PageEntity  getDataByPage(final String hql,final PageEntity page){
    	//匿名内部类
    	List list=hibernateTemplate.executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery(hql);
				query.setFirstResult((page.getNowPage()-1)*page.getPageSize());//设置每一页从第几条数据开始
				query.setMaxResults(page.getPageSize());//设置每页显示的条数
				List list=query.list();
				return list;
			}
		});
    	page.setList(list);//每页显示的条数
    	List list2=hibernateTemplate.find(hql);
    	int count=list2.size()>0 ? list2.size():0;
    	page.setTotalCount(count);
    	int totalPage=0;//总页数
    	//如果总条数对每页显示条数取余余数为0，说明可以整除，总页数=总条数/每页显示条数
    	if(count%page.getPageSize()==0){
    		totalPage=count/page.getPageSize();
    	}else{
    		//如果总条数对每页显示条数取余余数不为0，说明不可以整除，总页数=总条数/每页显示条数+1
    		totalPage=count/page.getPageSize()+1;
    	}
    	page.setTotalPage(totalPage);
		return page;
    	
    	
    }
}
