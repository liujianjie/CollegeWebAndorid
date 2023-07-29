package com.experiment.control;

import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

//���� sax����xml 
public class Main {
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder sb = new SAXBuilder();// ����һ��SAXBuilder����  
//        Document doc = sb.build(Main.class.getClassLoader().getResourceAsStream("E://studentinfo.xml"));
		 Document doc = sb.build("E://studentinfo.xml");
        // �����ĵ�����  
        Element root = doc.getRootElement(); // ��ȡ��Ԫ��  
        List list = root.getChildren("student");// ȡ����Ϊdisk������Ԫ��  
        for (int i = 0; i < list.size(); i++) {  
            Element element = (Element) list.get(i);  
            String name = element.getChildText("username");// ȡdisk��Ԫ��capacity������  
            String password = element.getChildText("password");  
            System.out.println("�����̷�:" + name);  
            System.out.println("��������:" + password);  
            System.out.println("-----------------------------------");  
        }  
	}
}
