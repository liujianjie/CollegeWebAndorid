package com.experiment.control;

import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

//测试 sax解析xml 
public class Main {
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder sb = new SAXBuilder();// 创建一个SAXBuilder对象  
//        Document doc = sb.build(Main.class.getClassLoader().getResourceAsStream("E://studentinfo.xml"));
		 Document doc = sb.build("E://studentinfo.xml");
        // 构造文档对象  
        Element root = doc.getRootElement(); // 获取根元素  
        List list = root.getChildren("student");// 取名字为disk的所有元素  
        for (int i = 0; i < list.size(); i++) {  
            Element element = (Element) list.get(i);  
            String name = element.getChildText("username");// 取disk子元素capacity的内容  
            String password = element.getChildText("password");  
            System.out.println("分区盘符:" + name);  
            System.out.println("分区容量:" + password);  
            System.out.println("-----------------------------------");  
        }  
	}
}
