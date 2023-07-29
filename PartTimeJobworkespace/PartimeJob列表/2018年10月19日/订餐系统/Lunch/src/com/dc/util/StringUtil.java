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
	 * 将object对象转换成int，如果obj为null则返回-1
	 * 转换失败也返回-1；
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
	 * 格式化字符串，如果为null或者“null”则返回“”，否则返回自己
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
	 * 将object对象转为json格式的字符串
	 * @param obj
	 * @return
	 */
	public static String transObjectToJson(Object obj){
		JSONObject objJson=JSONObject.fromObject(obj);
		return objJson.toString();
	}
	/**
	 * 将List数组转换为json格式的字符串
	 * @param list
	 * @return
	 */
	public static String transListToJson(List list){
		JSONArray json=JSONArray.fromObject(list);
		return json.toString();
	}

}
