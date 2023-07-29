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

//����ʵ�����еķ�ҳ��ѯ
@Component
public class PageUtil {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	//�õ���ҳ���������
    public  PageEntity  getDataByPage(final String hql,final PageEntity page){
    	//�����ڲ���
    	List list=hibernateTemplate.executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery(hql);
				query.setFirstResult((page.getNowPage()-1)*page.getPageSize());//����ÿһҳ�ӵڼ������ݿ�ʼ
				query.setMaxResults(page.getPageSize());//����ÿҳ��ʾ������
				List list=query.list();
				return list;
			}
		});
    	page.setList(list);//ÿҳ��ʾ������
    	List list2=hibernateTemplate.find(hql);
    	int count=list2.size()>0 ? list2.size():0;
    	page.setTotalCount(count);
    	int totalPage=0;//��ҳ��
    	//�����������ÿҳ��ʾ����ȡ������Ϊ0��˵��������������ҳ��=������/ÿҳ��ʾ����
    	if(count%page.getPageSize()==0){
    		totalPage=count/page.getPageSize();
    	}else{
    		//�����������ÿҳ��ʾ����ȡ��������Ϊ0��˵����������������ҳ��=������/ÿҳ��ʾ����+1
    		totalPage=count/page.getPageSize()+1;
    	}
    	page.setTotalPage(totalPage);
		return page;
    	
    	
    }
}
