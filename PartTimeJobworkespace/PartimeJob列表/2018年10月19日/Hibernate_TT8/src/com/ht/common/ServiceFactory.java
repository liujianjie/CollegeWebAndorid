package com.ht.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ServiceFactory {
	private static HashMap serviceClassNames = new HashMap();// 缓存实现类
	private static HashMap serviceInstances = new HashMap();// 缓存实现类实例
	static {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(ServiceFactory.class
					.getResourceAsStream("/config-resource/service-config.xml"));
			// 获取根元素
			Element root = doc.getRootElement();
			// 获取根元素下的子元素
			List children = root.getChildren();
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				// 得到每一个service 标签
				Element serviceNode = (Element) iter.next();
				// 获取service标签的name属性值
				String serviceName = serviceNode.getAttributeValue("name");
				// 获取service标签的class属性值
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
				// 根据路径加载类的实例
				service = Class.forName(className).newInstance();
				//deptEmpService    service对象实例
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
