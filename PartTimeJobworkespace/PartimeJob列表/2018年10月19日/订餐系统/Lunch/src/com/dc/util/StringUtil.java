package com.dc.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StringUtil {
	public static boolean checkNotNull(Object obj){
		if(obj!=null){
			String str=obj.toString();
			if(str!=" "&&str!=""&&str!="null"&&!str.equals("")&&!str.equals("null")&&!str.equals(" ")){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	/**
	 * ��object����ת����int�����objΪnull�򷵻�-1
	 * ת��ʧ��Ҳ����-1��
	 * @param obj
	 * @return
	 */
	public static int changeObjectToInt(Object obj){
		if(obj!=null){
			try{
			   int i=Integer.parseInt(obj.toString());
			   return i;
			}catch(Exception e){
				return -1;
			}
		}else{
			return -1;
		}
	}
	/**
	 * ��ʽ���ַ��������Ϊnull���ߡ�null���򷵻ء��������򷵻��Լ�
	 * @param obj
	 * @return
	 */
	public static String formatString(Object obj){
		if(obj!=null){
			String str=obj.toString();
			if(str!=""&&str!="null"&&!str.equals("")&&!str.equals("null")){
				return str;
			}else{
				return "";
			}
		}else{
			return "";
		}
	}
	/**
	 * ��object����תΪjson��ʽ���ַ���
	 * @param obj
	 * @return
	 */
	public static String transObjectToJson(Object obj){
		JSONObject objJson=JSONObject.fromObject(obj);
		return objJson.toString();
	}
	/**
	 * ��List����ת��Ϊjson��ʽ���ַ���
	 * @param list
	 * @return
	 */
	public static String transListToJson(List list){
		JSONArray json=JSONArray.fromObject(list);
		return json.toString();
	}

}
