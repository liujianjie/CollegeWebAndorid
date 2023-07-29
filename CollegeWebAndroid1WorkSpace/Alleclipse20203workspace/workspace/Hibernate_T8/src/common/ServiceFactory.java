package common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ServiceFactory {
	private static HashMap serviceclassname=new HashMap();
	private static HashMap serviceinteances=new HashMap();//缓存实现类
	static{
		SAXBuilder saxbuil=new SAXBuilder();
		try {
			Document doc=saxbuil.build(ServiceFactory.
					class.getResourceAsStream("//config-source/service-cfg-factory.xml"));
			Element root=doc.getRootElement();
			List child=root.getChildren();
			for(Iterator it=child.iterator();it.hasNext();){
				Element serviceNode=(Element)it.next();
				String servicename=serviceNode.getAttributeValue("name");
				String classname=serviceNode.getAttributeValue("class");
				serviceclassname.put(servicename, classname);
			}
		} catch (JDOMException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	//静态的话值是共享的
	public static Object getService(String servicename){
		Object service=serviceinteances.get(servicename);
		try {
			if(service==null){
				String classname=(String)serviceclassname.get(servicename);
				//加载类的实例
				service=Class.forName(classname).newInstance();
				//保存
				serviceinteances.put(classname, service);	
			}
			System.out.println("create class="+service.getClass().getName());
			return service;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
}
