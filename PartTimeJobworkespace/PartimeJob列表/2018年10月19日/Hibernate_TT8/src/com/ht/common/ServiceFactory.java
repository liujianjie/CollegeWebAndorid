package com.ht.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ServiceFactory {
	private static HashMap serviceClassNames = new HashMap();// ����ʵ����
	private static HashMap serviceInstances = new HashMap();// ����ʵ����ʵ��
	static {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(ServiceFactory.class
					.getResourceAsStream("/config-resource/service-config.xml"));
			// ��ȡ��Ԫ��
			Element root = doc.getRootElement();
			// ��ȡ��Ԫ���µ���Ԫ��
			List children = root.getChildren();
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				// �õ�ÿһ��service ��ǩ
				Element serviceNode = (Element) iter.next();
				// ��ȡservice��ǩ��name����ֵ
				String serviceName = serviceNode.getAttributeValue("name");
				// ��ȡservice��ǩ��class����ֵ
				String className = serviceNode.getAttributeValue("class");
				serviceClassNames.put(serviceName, className);
				//deptEmpService          com.ht.service.impl.DeptEmpServiceImpl
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// deptEmpService
	public static Object getService(String serviceName) {
		try {
			Object service = serviceInstances.get(serviceName);
			if (service == null) {
				// com.ht.service.impl.DeptEmpServiceImpl
				String className = (String) serviceClassNames.get(serviceName);
				// ����·���������ʵ��
				service = Class.forName(className).newInstance();
				//deptEmpService    service����ʵ��
				serviceInstances.put(serviceName, service);
			}
			System.out.println("createService == "
					+ service.getClass().getName());
			return service;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
