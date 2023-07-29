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
	private static HashMap serviceinteances=new HashMap();//����ʵ����
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	//��̬�Ļ�ֵ�ǹ����
	public static Object getService(String servicename){
		Object service=serviceinteances.get(servicename);
		try {
			if(service==null){
				String classname=(String)serviceclassname.get(servicename);
				//�������ʵ��
				service=Class.forName(classname).newInstance();
				//����
				serviceinteances.put(classname, service);	
			}
			System.out.println("create class="+service.getClass().getName());
			return service;
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
}
